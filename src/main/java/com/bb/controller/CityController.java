package com.bb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.bb.controller.helper.Response;
import com.bb.controller.helper.SearchObject;
import com.bb.primary.model.MCity;
import com.bb.primary.repository.MCityRepository;

@RestController
@RequestMapping("admin/city")
public class CityController {
	@Autowired
	MCityRepository cityRepository;

	@CrossOrigin
	@GetMapping("/list")
	public Response viewHomePage(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "cache", required = false) String cache) {
		Response res = new Response();
		if (status == null)
			res.setPayload(cityRepository.findBySiteId(siteId));
		else {
			List<MCity> list = CacheObject.cityList.get(siteId);
			if (list == null) {
				list = cityRepository.findBySiteIdAndStatusOrderBySortingOrder(siteId, status);
				if (list.size() > 50)
					list = list.subList(0, 50);
				CacheObject.cityList.put(siteId, list);
			}
			res.setPayload(list);
		}
		res.setMessage("sucessful");
		return res;
	}

	Map<String, List<MCity>> cityCountryMap = new HashMap<String, List<MCity>>();

	@CrossOrigin
	@GetMapping("/findByCountryId")
	public Response findByCountryId(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "cache", required = false) Integer cache,
			@RequestParam(value = "countryId", required = true) Long countryId) {
		Response res = new Response();

		String key = "" + siteId + "," + countryId + "," + status;
		List<MCity> list = null;
		if (cache != null && cache == 1) {
			list = cityCountryMap.get(key);

		}
		if (list == null)
			list = cityRepository.findBySiteIdAndCountryIdAndStatusOrderBySortingOrder(siteId, countryId, status);
		cityCountryMap.put(key, list);

		res.setPayload(list);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestBody MCity country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		MCity country2 = cityRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		MCity country = cityRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestBody SearchObject<MCity> searchObject) {
		Page<MCity> countryList = null;
		try {
			Example<MCity> example = Example.of(searchObject.getSearch());

			Pageable pageable = searchObject.getPage().createAndGetPageable();
			countryList = cityRepository.findAll(example, pageable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Response res = new Response();
		res.setPayload(countryList);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/searchByName/{seoName}")
	public Response searchBySeoName(@PathVariable(value = "seoName") String seoName,
			@RequestHeader(value = "siteId", required = false) Long siteId) {
		Set<MCity> cityList = new HashSet<MCity>();
		Set<String> keySet = CacheObject.cityMap.get(siteId).keySet();

		for (String key : keySet) {

			if (key != null) {

				if (key.contains(seoName) && cityList.size() < 6)
					cityList.add(CacheObject.cityMap.get(siteId).get(key));

			}
		}

		Response res = new Response();
		res.setPayload(cityList);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("searchByName")
	public Response searchByName(@RequestParam String name,
			@RequestHeader(value = "siteId", required = false) Long siteId) {
		Set<MCity> cityList = new HashSet<MCity>();
		Set<String> keySet = CacheObject.cityMap.get(siteId).keySet();
		name = name.toLowerCase();
		for (String key : keySet) {
			if (key != null) {

				if (key.startsWith(name) && cityList.size() < 6)
					cityList.add(CacheObject.cityMap.get(siteId).get(key));

			}
		}

		Response res = new Response();
		res.setPayload(cityList);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/delete/{id}")
	public Response deleteThroughId(@PathVariable(value = "id") Long id) {
		cityRepository.deleteById(id);
		Response res = new Response();
		res.setPayload(id);

		res.setMessage("sucessful");
		return res;

	}
}
