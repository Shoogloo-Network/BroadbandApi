package com.bb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.map.PassiveExpiringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bb.cache.CacheObject;
import com.bb.comparator.BroadBandViewComparator;
import com.bb.comparator.BroadbandComparator;
import com.bb.controller.helper.BroadBandCity;
import com.bb.controller.helper.BroadBandSave;
import com.bb.controller.helper.BroadBandView;
import com.bb.controller.helper.BroadBandViewNew;
import com.bb.controller.helper.BroadbandAttributeMap;
import com.bb.controller.helper.BroadbandUI;
import com.bb.controller.helper.ProviderCity;
import com.bb.controller.helper.ProviderUI;
import com.bb.controller.helper.Response;
import com.bb.controller.helper.SearchObject;
import com.bb.primary.model.BroadBandArttibuteRel;
import com.bb.primary.model.Broadband;
import com.bb.primary.model.CityBroadbandRel;
import com.bb.primary.model.MCity;
import com.bb.primary.model.Provider;
import com.bb.primary.repository.BroadBandArttibuteRelRepository;
import com.bb.primary.repository.BroadbandRepository;
import com.bb.primary.repository.CityBroadbandRelRepository;
import com.bb.primary.repository.CityProviderRelRepository;
import com.bb.primary.repository.ProviderRepository;
import com.bb.service.AdminService;

@RestController
@RequestMapping("admin/broadband")
public class BroadbandController {
	@Autowired
	BroadbandRepository broadbandRepository;
	@Autowired
	BroadBandArttibuteRelRepository boradBandArttibuteRelRepository;
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	AdminService adminService;
	@Autowired
	CityBroadbandRelRepository cityBroadbandRelRepository;
	@Autowired
	CityProviderRelRepository cityProviderRelRepository;
	//static PassiveExpiringMap<String, List<BroadBandView>> cacheMap = new PassiveExpiringMap<>(4320);
	static Map<String, List<BroadBandView>> cacheMap = new HashMap<String, List<BroadBandView>>();
	static Map<String, Response> cacheResponseMap = new HashMap<String, Response>();

	@CrossOrigin
	@GetMapping("/list")
	public Response viewHomePage(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "cache", required = false) Integer cache,
			@RequestParam(value = "pageNo", required = false) Integer pageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize) {
		Response res = new Response();
		int max = 0;
		int min = 0;
		String key = "list" + projectId + "," + siteId + "," + status + "," + pageNo + "," + pageSize;
		if (pageNo != null && pageSize != null) {
			min = pageNo * pageSize - pageSize + 1;
			max = pageNo * pageSize;
		}
		if (cache != null && cache == 1) {
			res.setPayload(CacheObject.broadbandMasterMap);
		} else {
			// broadbandRepository.find
			List<BroadBandView> countryList = cacheMap.get(key);
			if (countryList != null) {
				res.setPayload(countryList);
				res.setMessage("sucessful");
				return res;
			}
			List<Broadband> broadbandList = null;
			if (status == null)
				broadbandList = broadbandRepository.findBySiteId(siteId);
			else
				broadbandList = broadbandRepository.findBySiteIdAndStatusOrderBySortingOrder(siteId, status);
			if (broadbandList != null && pageNo != null && broadbandList.size() > pageSize)
				broadbandList = broadbandList.subList(min, max);
			System.out.println("broadbandList=" + broadbandList.size());
			countryList = adminService.findProvider(broadbandList, null, null, status);

			BroadBandViewComparator comp = new BroadBandViewComparator("sortingOrder");
			Collections.sort(countryList, comp);

			res.setPayload(countryList);
			cacheMap.put(key, countryList);
		}

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/filter/{ott}/value/{value}")
	public Response filter(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId, @PathVariable(value = "ott") String ott,
			@PathVariable(value = "value") String value,
			@RequestParam(value = "status", required = false) String status) {
		Response res = new Response();
		BroadBandViewComparator comp = null;

		String key = "filterottvalue" + siteId + "," + value + "," + ott + "," + value + "," + status;
		List<BroadBandView> countryList = cacheMap.get(key);
		if (countryList != null) {
			res.setPayload(countryList);
			res.setMessage("sucessful");
			return res;
		}
		if (status == null) {
			if (ott != null && ott.equals("speed")) {
				countryList = adminService.findProvider(broadbandRepository
						.findBySiteIdAndSpeedGreaterThanEqualOrderBySortingOrder(siteId, Integer.parseInt(value)), ott,
						value, status);
				comp = new BroadBandViewComparator("sortingOrder");
			} else if (ott != null && ott.equals("cost")) {
				countryList = adminService.findProvider(broadbandRepository
						.findBySiteIdAndCostLessThanEqualOrderBySortingOrder(siteId, Integer.parseInt(value)), ott,
						value, status);
				comp = new BroadBandViewComparator("cost");
			} else {
				countryList = adminService.findProvider(broadbandRepository.findBySiteId(siteId), ott, value, status);
				comp = new BroadBandViewComparator("ott");
			}
		} else {
			if (ott != null && ott.equals("speed")) {
				countryList = adminService.findProvider(broadbandRepository
						.findBySiteIdAndStatusAndSpeedScaleOrderBySortingOrder(siteId, status, "gbps"), ott, value,
						status);

				countryList.addAll(adminService.findProvider(
						broadbandRepository.findBySiteIdAndStatusAndSpeedGreaterThanEqualOrderBySortingOrder(siteId,
								status, Integer.parseInt(value)),
						ott, value, status));
				comp = new BroadBandViewComparator("sortingOrder");
			} else if (ott != null && ott.equals("cost")) {
				countryList = adminService.findProvider(
						broadbandRepository.findBySiteIdAndStatusAndCostLessThanEqualOrderBySortingOrder(siteId, status,
								Integer.parseInt(value)),
						ott, value, status);
				comp = new BroadBandViewComparator("cost");
			} else {
				countryList = adminService.findProvider(
						broadbandRepository.findBySiteIdAndStatusOrderBySortingOrder(siteId, status), ott, value,
						status);
				comp = new BroadBandViewComparator("ott");
			}
		}

		if (countryList != null && countryList.size() > 1)
			Collections.sort(countryList, comp);
		cacheMap.put(key, countryList);
		res.setPayload(countryList);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/listPrivderId/{providerId}")
	public Response listPrivderId(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@PathVariable(value = "providerId") Long providerId) {
		Response res = new Response();

		List<BroadBandView> countryList = adminService
				.findProvider(broadbandRepository.findBySiteIdAndProviderId(siteId, providerId), null, null, null);
		// if (siteId != null)
		// countryList = findProvider(broadbandRepository.findBySiteId(siteId));
		// else
		// countryList = findProvider(broadbandRepository.findAll());
		BroadBandViewComparator comp = new BroadBandViewComparator("sortingOrder");
		Collections.sort(countryList, comp);

		res.setPayload(countryList);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/listPrivder/{seoName}")
	public Response listPrivderId(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@PathVariable(value = "seoName") String seoName) {
		String key = "listPrivderSeoName" + projectId + "," + siteId + "," + seoName;
		Response res = cacheResponseMap.get(key);
		if (res != null)
			return res;
		else
			res = new Response();

		Provider providerId = providerRepository.findBySeoName(seoName);
		if (providerId != null) {
			List<BroadBandView> countryList = adminService.findProvider(
					broadbandRepository.findBySiteIdAndProviderId(siteId, providerId.getId()), null, null, null);
			// if (siteId != null)
			// countryList = findProvider(broadbandRepository.findBySiteId(siteId));
			// else
			// countryList = findProvider(broadbandRepository.findAll());
			BroadBandViewComparator comp = new BroadBandViewComparator("sortingOrder");
			Collections.sort(countryList, comp);

			res.setPayload(countryList);
			res.setMessage("sucessful");
			cacheResponseMap.put(key, res);
			return res;
		}
		res.setPayload(null);

		res.setMessage("fail");
		cacheResponseMap.put(key, res);
		return res;
	}

	@CrossOrigin
	@GetMapping("/listCache")
	public Response listCache(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId) {
		Response res = new Response();
		List<BroadBandViewNew> countryList = adminService.findProviderCache(broadbandRepository.findBySiteId(siteId));

		res.setPayload(countryList);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId, @RequestBody Broadband country) {
		country.setProjectId(projectId);
		country.setSiteId(siteId);
		Broadband country2 = broadbandRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("/saveWithAttr")
	public Response saveWithAttr(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId, @RequestBody BroadBandSave country) {
		country.setProjectId(projectId);
		country.setSiteId(siteId);
		System.out.println("country=" + country);
		Broadband br = new Broadband();
		br.setBandwidth(country.getBandwidth());
		br.setBandwidthDurationScale(country.getBandwidthDurationScale());
		br.setBandwidthSpeedScale(country.getBandwidthSpeedScale());
		br.setContractLength(country.getContractLength());
		br.setContractLengthDuration(country.getContractLengthDuration());
		br.setCost(country.getCost());
		br.setCostDurationScale(country.getCostDurationScale());
		br.setCurrency(country.getCurrency());
		br.setDealUrl(country.getDealUrl());
		br.setId(country.getId());
		br.setImageUrl(country.getImageUrl());
		br.setLink(country.getLink());
		br.setMeta_description(country.getMeta_description());
		br.setMeta_keyword(country.getMeta_keyword());
		br.setMeta_title(country.getMeta_title());
		br.setName(country.getName());
		br.setPlanExpiry(country.getPlanExpiry());
		br.setProjectId(country.getProjectId());
		br.setProviderId(country.getProviderId());
		br.setSiteId(country.getSiteId());
		br.setSortingOrder(country.getSortingOrder());
		br.setSpeed(country.getSpeed());
		br.setSpeedScale(country.getSpeedScale());
		br.setStatus(country.getStatus());
		br.setRating(country.getRating());
		br.setBasePrice(country.getBasePrice());
		br.setInstallation(country.getInstallation());
		br.setSetupCost(country.getSetupCost());
		br.setOthers(country.getOthers());
		br.setSeoName(country.getSeoName());
		br.setTaxes(country.getTaxes());
		br.setSponsored(country.getSponsored());
		br.setDescription(country.getDescription());
		br.setSeoName(country.getSeoName());
		Broadband country2 = broadbandRepository.save(br);
		List<Map<String, Object>> list = country.getArttibuteList();
		List<BroadBandArttibuteRel> list2 = boradBandArttibuteRelRepository.findByBroadBandId(country2.getId());
		for (BroadBandArttibuteRel rel : list2)
			boradBandArttibuteRelRepository.delete(rel);
		for (Map<String, Object> map : list) {

			BroadBandArttibuteRel boradBandArttibuteRel = new BroadBandArttibuteRel();
			boradBandArttibuteRel.setBroadBandbandId(country2.getId());
			boradBandArttibuteRel.setBrodoadBandAttributeId(Long.parseLong("" + map.get("BroadBandAttributeId")));
			boradBandArttibuteRel.setPosition("" + map.get("position"));
			boradBandArttibuteRel.setStatus(1);
			if (map.get("sortingOrder") != null)
				boradBandArttibuteRel.setSortingOrder(Integer.parseInt("" + map.get("sortingOrder")));
			boradBandArttibuteRelRepository.save(boradBandArttibuteRel);
		}
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) String projectId,
			@RequestHeader(value = "siteId", required = false) String siteId, @PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		Broadband country = broadbandRepository.getReferenceById(id);
		List<Long> list = new ArrayList<Long>();
		Response res = new Response();
		if (id != null) {
			list.add(id);

			List<Map<String, Object>> attrList = boradBandArttibuteRelRepository.findByBroadbandIds(list);
			Provider provider = providerRepository.findById(country.getProviderId()).get();
			BroadBandView broadbandView = adminService.findProvider(country, null, null, provider, attrList);

			res.setPayload(broadbandView);
		}

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("planDetailsByPlanName/{seoName}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) Long projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId,
			@PathVariable(value = "seoName") String seoName) {

		Response res = new Response();
		List<Long> list = new ArrayList<Long>();
		System.out.println("aa-" + 1417032);
		// Broadband broadband =
		// broadbandRepository.getBySiteIdAndSeoNameAndStatus(siteId, seoName, "1");
		// Broadband broadband = broadbandRepository.getBySiteIdAndNameAndStatus(siteId,
		// Utility.getNameFromSeo(seoName), "1");
		Broadband broadband = CacheObject.broadbandSeoNameMap.get(siteId).get(seoName);
		if (broadband != null) {
			System.out.println("broadband=" + broadband);
			list.add(broadband.getId());
			List<Map<String, Object>> attrList = boradBandArttibuteRelRepository.findByBroadbandIds(list);
			Provider provider = providerRepository.findById(broadband.getProviderId()).get();
			BroadBandView broadbandView = adminService.findProvider(broadband, null, null, provider, attrList);
			res.setPayload(broadbandView);
		} else {
			res.setPayload(list = new ArrayList<Long>());
		}
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@RequestBody SearchObject<Broadband> searchObject) {

		System.out.println("countr=" + searchObject);
		Example<Broadband> example = Example.of(searchObject.getSearch());

		System.out.println("searchObject.getPage=" + searchObject.getPage());
		Pageable pageable = searchObject.getPage().createAndGetPageable();

		Page<Broadband> countryList = broadbandRepository.findAll(example, pageable);

		// countryList= findProvider(countryList);
		System.out.println("countryList=" + countryList);
		Response res = new Response();

		// for (Broadband broad : countryList) {
		// BroadBandViewNew broadBandView = adminService.convert(broad);
		// }
		res.setPayload(countryList);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/delete/{id}")
	public String deleteThroughId(@RequestHeader(value = "projectId", required = false) String projectId,
			@RequestHeader(value = "siteId", required = false) String siteId, @PathVariable(value = "id") int id) {
		// mCountryRepository.deleteById(id);
		return "redirect:/";

	}

	@CrossOrigin
	@PostMapping("/saveBoradBandAttribute")
	public Response mapBoradBandAttribute(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@RequestBody BroadbandAttributeMap country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);

		List<BroadBandArttibuteRel> attrList = boradBandArttibuteRelRepository
				.findByBroadBandId(country.getBoradBandId());
		if (attrList != null) {
			for (BroadBandArttibuteRel attr : attrList) {
				attr.setStatus(0);
				boradBandArttibuteRelRepository.save(attr);
			}
		}
		if (country.getArttibuteList() != null)
			for (BroadBandArttibuteRel attr : country.getArttibuteList()) {
				attr.setStatus(1);
				attr.setBroadBandbandId(country.getBoradBandId());
				attr.setProjectId(country.getProjectId());
				attr.setSiteId(country.getSiteId());
				boradBandArttibuteRelRepository.save(attr);
			}
		Response res = new Response();
		res.setPayload(country);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/listBoradBandAttribute")
	public Response listBoradBandAttribute(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId, @PathVariable(value = "id") Long id) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		List<BroadBandArttibuteRel> attrList = boradBandArttibuteRelRepository.findByBroadBandIdAndStatusAndSiteId(id,
				1, siteId);

		Response res = new Response();
		res.setPayload(attrList);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("/saveWithCity")
	public Response saveWithCity(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId, @RequestBody BroadbandUI country) {
		System.out.println("country=" + country);
		Broadband pro = new Broadband();
		pro.setDescription(country.getDescription());
		pro.setId(country.getId());
		pro.setBandwidth(siteId);
		pro.setBandwidthDurationScale(country.getBandwidthDurationScale());
		pro.setBandwidthSpeedScale(country.getBandwidthSpeedScale());
		pro.setBasePrice(country.getBasePrice());
		pro.setContractLength(country.getContractLength());
		pro.setContractLengthDuration(country.getContractLengthDuration());
		pro.setCost(country.getCost());
		pro.setCurrency(country.getCurrency());
		pro.setDealUrl(country.getDealUrl());
		pro.setDescription(country.getDescription());
		pro.setId(country.getId());
		pro.setImageUrl(country.getImageUrl());
		pro.setInstallation(country.getInstallation());
		pro.setLink(country.getLink());
		pro.setMeta_description(country.getMeta_description());
		pro.setMeta_keyword(country.getMeta_keyword());
		pro.setMeta_title(country.getMeta_title());
		pro.setName(country.getName());
		pro.setOthers(country.getOthers());
		pro.setPlanExpiry(country.getPlanExpiry());
		pro.setProjectId(projectId);
		pro.setProviderId(country.getProviderId());
		pro.setRating(country.getRating());
		pro.setSeoName(country.getSeoName());
		pro.setSetupCost(country.getSetupCost());
		pro.setSiteId(siteId);
		pro.setSortingOrder(country.getSortingOrder());
		pro.setSpeed(country.getSpeed());
		pro.setSpeedScale(country.getSpeedScale());
		pro.setSponsored(country.getSponsored());
		pro.setStatus(country.getStatus());
		pro.setTaxes(country.getTaxes());

		// pro.setCitiesMapping(country.getCitiesMapping().toString());
		Broadband country2 = broadbandRepository.save(pro);
		if (country.getCitiesMapping() != null) {
			int count = 0;
			List<CityBroadbandRel> list = cityBroadbandRelRepository.findByBroadbandId(country2.getId());
			cityBroadbandRelRepository.deleteAllInBatch(list);
			for (Map<String, Object> map : country.getCitiesMapping()) {
				CityBroadbandRel rel = new CityBroadbandRel();

				rel.setCityId(Long.parseLong("" + map.get("value")));
				rel.setBroadbandId(country2.getId());
				rel.setStatus(1);
				cityBroadbandRelRepository.save(rel);

				count = count + 1;
				// pro.setCitiesMapping(str.toString());
			}
			// country2 = providerRepository.save(pro);
		}
		Response res = new Response();
		country.setId(country2.getId());
		country.setCitiesMapping(getCityofBroadband(country2.getId()));
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("cityByBroadband/{id}")
	public Response cityBroadbandSearch(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId, @PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		Optional<Provider> providerO = providerRepository.findById(id);
		Provider provider = providerO.get();
		ProviderUI pc = new ProviderUI();
		pc.setDescription(provider.getDescription());
		pc.setId(provider.getId());
		pc.setImage(provider.getImage());
		pc.setLink(provider.getLink());
		pc.setLogo(provider.getLogo());
		pc.setMeta_description(provider.getMeta_description());
		pc.setMeta_keyword(provider.getMeta_keyword());
		pc.setMeta_title(provider.getMeta_title());
		pc.setName(provider.getName());
		pc.setProjectId(provider.getProjectId());
		pc.setRating(provider.getRating());
		pc.setShortName(provider.getShortName());
		pc.setSiteId(provider.getSiteId());
		pc.setSortingOrder(provider.getSortingOrder());

		List<Map<String, Object>> li = getCityofBroadband(id);
		pc.setCitiesMapping(li);
		Response res = new Response();
		res.setPayload(pc);
		res.setMessage("sucessful");
		return res;
	}

	private List<Map<String, Object>> getCityofBroadband(Long id) {
		List<Object[]> list = cityBroadbandRelRepository.findByBroadbandIdQuery(id);
		List<ProviderCity> providerCityList = new ArrayList<ProviderCity>();
		List<Map<String, Object>> li = new ArrayList<Map<String, Object>>();
		if (list != null)
			for (Object aa[] : list) {
				ProviderCity city = new ProviderCity();
				city.setId(Long.parseLong("" + aa[0]));
				city.setCityId(Long.parseLong("" + aa[1]));
				city.setProviderId(Long.parseLong("" + aa[2]));
				if (aa[3] != null)
					city.setCounteryId(Long.parseLong("" + aa[3]));
				city.setCityName("" + aa[4]);
				if (aa[5] != null)
					city.setStateId(Long.parseLong("" + aa[5]));
				city.setProviderName("" + aa[6]);
				city.setDescription("" + aa[7]);
				city.setImage("" + aa[8]);
				providerCityList.add(city);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("value", city.getCityId());
				map.put("label", city.getCityName());
				li.add(map);

			}
		return li;
	}

	@CrossOrigin
	@GetMapping("planByCityName/{seoName}")
	public Response providerCityNameSearch(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId,
			@PathVariable(value = "seoName") String seoName) {

		MCity city = CacheObject.cityMap.get(siteId).get(seoName);
		List<BroadBandView> list3 = null;
		if (city != null) {
			List<CityBroadbandRel> list = cityBroadbandRelRepository.findByCityId(city.getId());
			List<Broadband> list2 = new ArrayList<Broadband>();// broadbandRepository.findAllById(list);
			BroadbandComparator comp = new BroadbandComparator("sortingOrder");

			for (CityBroadbandRel rel : list) {

				if (CacheObject.broadbandMasterMap.get(siteId).get(rel.getBroadbandId()) != null)
					list2.add(CacheObject.broadbandMasterMap.get(siteId).get(rel.getBroadbandId()));
			}
			Collections.sort(list2, comp);

			list3 = adminService.findProvider(list2, null, null, null);

			if (list3 == null)
				list3 = new ArrayList<BroadBandView>();

		}

		Response res = new Response();
		res.setPayload(list3);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("planByCityName2/{seoName}")
	public Response providerCityNameSearch2(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId,
			@PathVariable(value = "seoName") String seoName) {

		MCity city = CacheObject.cityMap.get(siteId).get(seoName);
		List<BroadBandView> list3 = null;
		if (city != null) {
			List<CityBroadbandRel> list = cityBroadbandRelRepository.findByCityId(city.getId());
			List<Broadband> list2 = new ArrayList<Broadband>();// broadbandRepository.findAllById(list);
			BroadbandComparator comp = new BroadbandComparator("sortingOrder");

			for (CityBroadbandRel rel : list) {

				if (CacheObject.broadbandMasterMap.get(siteId).get(rel.getBroadbandId()) != null)
					list2.add(CacheObject.broadbandMasterMap.get(siteId).get(rel.getBroadbandId()));
			}
			Collections.sort(list2, comp);

			list3 = adminService.findProvider(list2, null, null, null);

			if (list3 == null)
				list3 = new ArrayList<BroadBandView>();

		}
		BroadBandCity borad = new BroadBandCity();
		borad.setBroadBandList(list3);
		borad.setCity(city);

		Response res = new Response();
		res.setPayload(borad);
		res.setMessage("sucessful");
		return res;
	}
}