package com.bb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.CityCityRelHelper;
import com.bb.controller.helper.Response;
import com.bb.primary.model.CityCityRel;
import com.bb.primary.model.MCity;
import com.bb.primary.repository.CityCityRelRepository;
import com.bb.primary.repository.MCityRepository;

@RestController
@RequestMapping("admin/citycity")
public class CityCityRelController {

	@Autowired
	CityCityRelRepository cityCityRelRepository;
	@Autowired
	MCityRepository mCityRepository;

	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestBody List<CityCityRel> country) {

		List<CityCityRel> city = cityCityRelRepository.findBySourceCityId(country.get(0).getSourceCityId());
		if (city != null) {
			cityCityRelRepository.deleteAll(city);
		}

		List<CityCityRel> country2 = cityCityRelRepository.saveAll(country);
		
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@PathVariable(value = "id") Long id) {

		List<Object[]> country = cityCityRelRepository.findByCityIdQuery(id);
		List<CityCityRelHelper> CityCityRelHelperList = new ArrayList<CityCityRelHelper>();

		for (Object[] obj : country) {
			CityCityRelHelper helper = new CityCityRelHelper();
			helper.setId(Long.parseLong("" + obj[0]));
			helper.setSourceCityId(Long.parseLong("" + obj[1]));
			helper.setDestiCityId(Long.parseLong("" + obj[2]));
			helper.setSoruceCity("" + obj[3]);
			helper.setDestiCity("" + obj[4]);
			helper.setSortingOrder(Integer.parseInt("" + obj[5]));
			CityCityRelHelperList.add(helper);
		}

		Response res = new Response();
		res.setPayload(CityCityRelHelperList);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/findByName/{seoName}")
	public Response FindForm(@PathVariable(value = "seoName") String seoName, 
			@RequestHeader(value="projectId", required = false) Integer projectId, 
			@RequestHeader(value = "siteId", required = false) String siteId) {

		List<Object[]> cityToCityRelData = cityCityRelRepository.findByCityName(seoName);
		List<CityCityRelHelper> CityCityRelHelperList = new ArrayList<CityCityRelHelper>();

		for (Object[] obj : cityToCityRelData) {
			CityCityRelHelper helper = new CityCityRelHelper();
			helper.setId(Long.parseLong("" + obj[0]));
			helper.setSourceCityId(Long.parseLong("" + obj[1]));
			helper.setDestiCityId(Long.parseLong("" + obj[2]));
			helper.setSoruceCity("" + obj[3]);
			helper.setDestiCity("" + obj[4]);
			helper.setSortingOrder(Integer.parseInt("" + obj[5]));
			CityCityRelHelperList.add(helper);
		}

		Response res = new Response();
		res.setPayload(CityCityRelHelperList);
		res.setMessage("sucessful");
		return res;
	}
}
