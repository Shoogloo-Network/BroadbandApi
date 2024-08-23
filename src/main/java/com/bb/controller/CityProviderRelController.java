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
import com.bb.primary.model.CityBroadbandRel;
import com.bb.primary.model.CityProviderRel;
import com.bb.primary.model.MCity;
import com.bb.primary.model.Provider;
import com.bb.primary.repository.CityProviderRelRepository;
import com.bb.primary.repository.MCityRepository;
import com.bb.primary.repository.ProviderRepository;

@RestController
@RequestMapping("admin/cityproviderrel")
public class CityProviderRelController {
	@Autowired
	CityProviderRelRepository cityProviderRelRepository;
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	MCityRepository mCityRepository;

	@CrossOrigin
	@PutMapping("/save")
	public Response save(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@RequestBody CityProviderRel cityProviderRel) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		Response res = new Response();
		try {
			CityProviderRel cityBroadband = cityProviderRelRepository.save(cityProviderRel);
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

		CityProviderRel rel = cityProviderRelRepository.findByCityIdAndProviderId(cityBroadbandRel.getCityId(),
				cityBroadbandRel.getBroadbandId());
		if (rel != null)
			cityProviderRelRepository.delete(rel);
		Response res = new Response();

		res.setPayload("deleted");
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/findProviderByCityId/{cityId}")
	public Response findByCityId(@RequestHeader(value = "projectId") String projectId,
			@RequestHeader(value = "siteId") String siteId, @PathVariable(value = "cityId") Long cityId) {
		System.out.println("id=" + cityId);

		// List<Object[]> broadbandByCityId =
		// cityBroadbandRelRepository.findBroadbandByCityIdQuery(cityId);
		List<CityProviderRel> providerByCityId = cityProviderRelRepository.findByCityId(cityId);
		List<Long> ids = new ArrayList<Long>();

		for (CityProviderRel obj : providerByCityId) {
			ids.add(obj.getProviderId());
		}

		List<Provider> broadbandList = providerRepository.findAllById(ids);
		Response res = new Response();
		res.setPayload(broadbandList);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/findCityByProviderId/{broadbandId}")
	public Response findByBroadbandId(@RequestHeader(value = "projectId") String projectId,
			@RequestHeader(value = "siteId") String siteId, @PathVariable(value = "broadbandId") Long broadbandId) {

		List<CityProviderRel> broadbandListByCity = cityProviderRelRepository.findByProviderId(broadbandId);
		List<Long> ids = new ArrayList<Long>();

		for (CityProviderRel obj : broadbandListByCity) {
			ids.add(obj.getCityId());
		}

		List<MCity> cityList = mCityRepository.findAllById(ids);
		Response res = new Response();
		res.setPayload(cityList);

		res.setMessage("sucessful");
		return res;
	}

	
}
