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
import org.springframework.ui.Model;
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
import com.bb.comparator.ProviderComparator;
import com.bb.controller.helper.BroadBandView;
import com.bb.controller.helper.ProviderCity;
import com.bb.controller.helper.ProviderUI;
import com.bb.controller.helper.Response;
import com.bb.controller.helper.SearchObject;
import com.bb.primary.model.Broadband;
import com.bb.primary.model.CityProviderRel;
import com.bb.primary.model.Provider;
import com.bb.primary.repository.BroadbandRepository;
import com.bb.primary.repository.CityProviderRelRepository;
import com.bb.primary.repository.ProviderRepository;
import com.bb.service.AdminService;

@RestController
@RequestMapping("admin/provider")
public class ProviderController {

	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	CityProviderRelRepository cityProviderRelRepository;
	@Autowired
	BroadbandRepository broadbandRepository;
	@Autowired AdminService adminService;
//	static PassiveExpiringMap<String, List<Provider>> map = new PassiveExpiringMap<>(10000);
	static Map<String, List<Provider>> map = new HashMap<String, List<Provider>>();
	
	
	@CrossOrigin
	@GetMapping("/list")
	public Response list(@RequestHeader(value = "projectId", required = false)
	Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,Model model
	,@RequestParam(value = "status", required = false) Integer status,
	@RequestParam(value = "categoryId", required = false ) Integer categoryId , @RequestParam(value="cache", required=false) Integer cache ) {
		Response res = new Response();
		String key=siteId+","+status+","+categoryId;
		List<Provider> list =map.get(key);
		
		if(list!=null)
		{
			res.setPayload(list);
			res.setMessage("sucessful");
			return res;
		}
		if(cache !=null && cache==1) {
			res.setPayload(CacheObject.broadbandMasterMap);
		}else {
		if(categoryId==null)
			categoryId=1;
		if(status==null)
			status=0;
		if(status==0)
		{
			 list = providerRepository.findBySiteIdAndCategoryIdOrderBySortingOrder(siteId,categoryId);
			ProviderComparator com=new ProviderComparator("sortingOrder");
			Collections.sort(list, com);
			res.setPayload(list);
		}else
		{	
			 list =providerRepository.findBySiteIdAndStatusAndCategoryIdOrderBySortingOrder(siteId,status,categoryId);
			
			ProviderComparator com=new ProviderComparator("sortingOrder");
			Collections.sort(list, com);
			 
			res.setPayload(list);
		}
		
		}
		map.put(key, list);
		
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("/save")
	public Response save(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,@RequestBody Provider country) {
		System.out.println("providerSave=" + country);
		country.setProjectId(projectId);
		country.setSiteId(siteId);
		if(country.getCategoryId()==null)
			country.setCategoryId(1);
		Provider country2 = providerRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/listWithCity")
	public Response listWithCity(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,@RequestParam(value = "status", required = false) Integer status) {
		
		List<Provider>list=null;
		if(status!=null)
			list=	providerRepository.findBySiteIdAndStatus(siteId,status);
		else
			list=	providerRepository.findBySiteId(siteId);
		List<ProviderUI>responseList=new ArrayList<ProviderUI>();
		for(Provider country:list)
		{
			ProviderUI pro=new ProviderUI();
			
			pro.setDescription(country.getDescription());
			pro.setId(country.getId());
			pro.setImage(country.getImage());
			pro.setLink(country.getLink());
			pro.setLogo(country.getLogo());
			pro.setMeta_description(country.getMeta_description());
			pro.setMeta_keyword(country.getMeta_keyword());
			pro.setMeta_title(country.getMeta_title());
			pro.setName(country.getName());
			pro.setProjectId(country.getProjectId());
			pro.setRating(country.getRating());
			 pro.setSiteId(country.getSiteId());
			pro.setSortingOrder(country.getSortingOrder());
			pro.setStatus(country.getStatus());
			pro.setSeoName(country.getSeoName());
			pro.setMenu(country.getMenu());
			pro.setField1(country.getField1());
			
			
			
			pro.setField2(country.getField2());
			pro.setField2(country.getField3());
			pro.setFaq(country.getFaq());
			pro.setProvider_top_banner_txt(country.getProvider_top_banner_txt());
			pro.setProvider_top_banner_plans(country.getProvider_top_banner_plans());
			pro.setProvider_top_banner_color(country.getProvider_top_banner_color());
			
			List<Map<String,Object>>li=	getCityofProvider( country.getId());
			pro.setCitiesMapping(li);
			responseList.add(pro);
		}
		Response res = new Response();
		res.setPayload(responseList);
		res.setMessage("sucessful");
		return res;
	}
	
	
	@CrossOrigin
	@PostMapping("/saveWithCity")
	public Response saveWithCity(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@RequestBody ProviderUI country) {
		System.out.println("country=" + country);
		Provider pro = new Provider();
		pro.setDescription(country.getDescription());
		pro.setId(country.getId());
		pro.setImage(country.getImage());
		pro.setLink(country.getLink());
		pro.setLogo(country.getLogo());
		pro.setMeta_description(country.getMeta_description());
		pro.setMeta_keyword(country.getMeta_keyword());
		pro.setMeta_title(country.getMeta_title());
		pro.setName(country.getName());
		pro.setProjectId(projectId);
		pro.setRating(country.getRating());
		pro.setSiteId(siteId);
		pro.setSortingOrder(country.getSortingOrder());
		pro.setStatus(country.getStatus());
		pro.setSeoName(country.getSeoName());
		pro.setField1(country.getField1());
		pro.setField2(country.getField2());
		pro.setField3(country.getField3());
		pro.setFaq(country.getFaq());
		pro.setProvider_top_banner_txt(country.getProvider_top_banner_txt());
		pro.setProvider_top_banner_plans(country.getProvider_top_banner_plans());
		pro.setProvider_top_banner_color(country.getProvider_top_banner_color());
	//	pro.setCitiesMapping(country.getCitiesMapping().toString());
			Provider country2 = providerRepository.save(pro);
		if (country.getCitiesMapping() != null) {
			int count=0;
			List<CityProviderRel> list = cityProviderRelRepository.findByProviderId(country2.getId());
			cityProviderRelRepository.deleteAllInBatch(list);
			for (Map<String, Object> map : country.getCitiesMapping()) {
				CityProviderRel rel = new CityProviderRel();
	
				rel.setCityId(Long.parseLong("" + map.get("value")));
				rel.setProviderId(country2.getId());
				rel.setStatus(1);
				cityProviderRelRepository.save(rel);
				
					count=count+1;
				//pro.setCitiesMapping(str.toString());
			}
		//	 country2 = providerRepository.save(pro);
		}
		Response res = new Response();
		country.setId(country2.getId());
		country.setCitiesMapping(getCityofProvider(country2.getId()));
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}
	

	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		Optional<Provider> op = providerRepository.findById(id);
		Provider country = null;
		if (op.isPresent())
			country = op.get();

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@RequestBody SearchObject<Provider> searchObject) {

		System.out.println("countr=" + searchObject);
		Example<Provider> example = Example.of(searchObject.getSearch());
		System.out.println("searchObject.getPage=" + searchObject.getPage());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<Provider> countryList = providerRepository.findAll(example, pageable);
		
		System.out.println("countryList=" + countryList);
		Response res = new Response();
		res.setPayload(countryList);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("providerCityAdd")
	public Response providercityAdd(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@RequestBody CityProviderRel country) {
		System.out.println("country=" + country);
		CityProviderRel country2 = cityProviderRelRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("providerByCity/{id}")
	public Response providerCitySearch(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		List<Object[]> list = cityProviderRelRepository.findByCityIdQuery(id);
		List<ProviderCity> providerCityList = new ArrayList<ProviderCity>();
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

			}
		Response res = new Response();
		res.setPayload(providerCityList);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("planByCityName/{seoName}")
	public Response providerCityNameSearch(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@PathVariable(value = "seoName") String seoName) {
		List<Long> list = cityProviderRelRepository.findByCitySeoNameQuery(seoName,siteId);
		List<Broadband> list2 =broadbandRepository.findAllById(list);
		
		Response res = new Response();
		BroadBandViewComparator comp=new BroadBandViewComparator("sortingOrder");
	List<BroadBandView> list3 = adminService.findProvider(list2,null,null,null);
	if(list3==null)
		list3=new ArrayList<BroadBandView>();
		Collections.sort(list3, comp);
		res.setPayload(list3);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("cityByProvider/{id}")
	public Response cityProviderSearch(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		Optional<Provider> providerO=	providerRepository.findById(id);
		Provider provider=providerO.get();
		ProviderUI pc=new ProviderUI();
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
		pc.setSeoName(provider.getSeoName());
		pc.setMenu(provider.getMenu());
		pc.setField1(provider.getField1());
		
		
		
		pc.setField2(provider.getField2());
		pc.setField2(provider.getField3());
		pc.setFaq(provider.getFaq());
		pc.setProvider_top_banner_txt(provider.getProvider_top_banner_txt());
		pc.setProvider_top_banner_plans(provider.getProvider_top_banner_plans());
		pc.setProvider_top_banner_color(provider.getProvider_top_banner_color());
		List<Map<String,Object>>li=	getCityofProvider( id);
		pc.setCitiesMapping(li);
		Response res = new Response();
		res.setPayload(pc);
		res.setMessage("sucessful");
		return res;
	}

	private List<Map<String,Object>> getCityofProvider(Long id) {
		List<Object[]> list = cityProviderRelRepository.findByProviderIdQuery(id);
		List<ProviderCity> providerCityList = new ArrayList<ProviderCity>();
		List<Map<String,Object>>li=new ArrayList<Map<String,Object>>();
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
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("value",city.getCityId());
				map.put("label", city.getCityName());
				li.add(map);

			}
		System.out.println("li="+li);
		return li;
	}

}
