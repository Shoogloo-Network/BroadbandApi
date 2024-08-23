package com.bb.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.Response;
import com.bb.controller.helper.SearchObject;
import com.bb.primary.model.MLocation;
import com.bb.primary.repository.MLocationRepository;

@RestController
@RequestMapping("admin/location")
public class LocationController {
	@Autowired
	MLocationRepository locationRepository;

/*	@GetMapping("/list")
	public Response viewHomePage(Model model) {
		Response res = new Response();
		res.setPayload(locationRepository.findAll());
		res.setMessage("sucessful");
		return res;
	}
*/
	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId", required = false) String siteId,@RequestBody MLocation country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		MLocation country2 = locationRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId", required = false) String siteId,@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		MLocation country = locationRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId", required = false) String siteId,@RequestBody SearchObject<MLocation> searchObject) {

		System.out.println("countr=" + searchObject);
		Example<MLocation> example = Example.of(searchObject.getSearch());
		System.out.println("searchObject.getPage="+searchObject.getPage());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<MLocation> countryList = locationRepository.findAll(example, pageable);
		System.out.println("countryList=" + countryList);
		Response res = new Response();
		res.setPayload(countryList);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/delete/{id}")
	public String deleteThroughId(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId", required = false) String siteId,@PathVariable(value = "id") int id) {
		// mCountryRepository.deleteById(id);
		return "redirect:/";

	}
}
