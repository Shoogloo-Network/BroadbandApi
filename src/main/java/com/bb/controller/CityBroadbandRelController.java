package com.bb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.CityBroadbandRelHelper;
import com.bb.controller.helper.Response;
import com.bb.primary.model.Broadband;
import com.bb.primary.model.CityBroadbandRel;
import com.bb.primary.model.MCity;
import com.bb.primary.repository.BroadbandRepository;
import com.bb.primary.repository.CityBroadbandRelRepository;
import com.bb.primary.repository.MCityRepository;

@RestController
@RequestMapping("admin/citybroadbandrel")
public class CityBroadbandRelController {
	@Autowired
	CityBroadbandRelRepository cityBroadbandRelRepository;
	@Autowired
	BroadbandRepository broadbandRepository;
	@Autowired
	MCityRepository mCityRepository;

	@CrossOrigin
	@PutMapping("/save")
	public Response save(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@RequestBody CityBroadbandRel cityBroadbandRel) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		Response res = new Response();
		try {
			CityBroadbandRel cityBroadband = cityBroadbandRelRepository.save(cityBroadbandRel);
			res.setPayload(cityBroadband);
			res.setMessage("sucessful");
		} catch (Exception e) {

			res.setPayload(null);
			res.setMessage("dublicate");

		}

		return res;
	}

	@CrossOrigin
	@DeleteMapping("/delete")
	public Response delete(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@RequestBody CityBroadbandRel cityBroadbandRel) {
		// public Response search(@ModelAttribute("country") MCountry country ) {

		CityBroadbandRel rel = cityBroadbandRelRepository.findByCityIdAndBroadbandId(cityBroadbandRel.getCityId(),
				cityBroadbandRel.getBroadbandId());
		if (rel != null)
			cityBroadbandRelRepository.delete(rel);
		Response res = new Response();

		res.setPayload("deleted");
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/findBroadbandByCityId/{cityId}")
	public Response findByCityId(@RequestHeader(value = "projectId") String projectId,
			@RequestHeader(value = "siteId") String siteId, @PathVariable(value = "cityId") Long cityId) {
		System.out.println("id=" + cityId);

		// List<Object[]> broadbandByCityId =
		// cityBroadbandRelRepository.findBroadbandByCityIdQuery(cityId);
		List<CityBroadbandRel> broadbandByCityId = cityBroadbandRelRepository.findByCityId(cityId);
		List<Long> ids = new ArrayList<Long>();

		for (CityBroadbandRel obj : broadbandByCityId) {
			ids.add(obj.getBroadbandId());
		}

		List<Broadband> broadbandList = broadbandRepository.findAllById(ids);
		Response res = new Response();
		res.setPayload(broadbandList);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/findCityByBroadbandId/{broadbandId}")
	public Response findByBroadbandId(@RequestHeader(value = "projectId") String projectId,
			@RequestHeader(value = "siteId") String siteId, @PathVariable(value = "broadbandId") Long broadbandId) {

		List<CityBroadbandRel> broadbandListByCity = cityBroadbandRelRepository.findByBroadbandId(broadbandId);
		List<Long> ids = new ArrayList<Long>();

		for (CityBroadbandRel obj : broadbandListByCity) {
			ids.add(obj.getCityId());
		}

		List<MCity> cityList = mCityRepository.findAllById(ids);
		Response res = new Response();
		res.setPayload(cityList);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/getBroadbandPlan")
	public Response getBroadbandPlans(@RequestHeader(value = "siteId") Integer siteId) {
		List<Object[]> broadbandPlans = cityBroadbandRelRepository.findCityBroadbandPlans(siteId);
		List<CityBroadbandRelHelper> cbl = new ArrayList<CityBroadbandRelHelper>();
		for (Object[] obj : broadbandPlans) {
			CityBroadbandRelHelper helper = new CityBroadbandRelHelper();
			helper.setId(Long.parseLong("" + obj[0]));
			helper.setCityId(Long.parseLong("" + obj[1]));
			helper.setBroadbandId(Long.parseLong("" + obj[2]));
			helper.setCityName("" + obj[3]);
			helper.setName("" + obj[4]);
			helper.setDescription("" + obj[5]);
			helper.setStatus(Integer.parseInt("" + obj[6]));
			cbl.add(helper);
		}
		Response res = new Response();
		res.setPayload(cbl);
		res.setMessage("successfull");

		return res;
	}

	/*
	 * @CrossOrigin
	 * 
	 * @PostMapping("search") public Response search(@RequestHeader(value =
	 * "projectId", required = false) String projectId,
	 * 
	 * @RequestHeader(value = "siteId", required = false) String siteId,
	 * 
	 * @RequestBody SearchObject<MCountry> searchObject) {
	 * 
	 * System.out.println("countr=" + searchObject); Example<MCountry> example =
	 * Example.of(searchObject.getSearch());
	 * System.out.println("searchObject.getPage=" + searchObject.getPage());
	 * Pageable pageable = searchObject.getPage().createAndGetPageable();
	 * Page<MCountry> countryList = mCountryRepository.findAll(example, pageable);
	 * System.out.println("countryList=" + countryList); Response res = new
	 * Response(); res.setPayload(countryList);
	 * 
	 * res.setMessage("sucessful"); return res; }
	 * 
	 * @CrossOrigin
	 * 
	 * @GetMapping("/delete/{id}") public Response
	 * deleteThroughId(@RequestHeader(value = "projectId", required = false) String
	 * projectId,
	 * 
	 * @RequestHeader(value = "siteId", required = false) String
	 * siteId, @PathVariable(value = "id") Long id) { //
	 * mCountryRepository.deleteById(id); Response res = new Response();
	 * res.setPayload(id);
	 * 
	 * res.setMessage("sucessful"); return res;
	 * 
	 * }
	 */
}
