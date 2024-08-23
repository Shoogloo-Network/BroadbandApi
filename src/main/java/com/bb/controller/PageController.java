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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.Response;
import com.bb.controller.helper.SearchObject;
import com.bb.primary.model.Pages;
import com.bb.primary.repository.PageRepository;


@RestController
@RequestMapping("admin/page")
public class PageController {
	@Autowired
	PageRepository pageRepository;

	@GetMapping("/list")
	public Response viewHomePage(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId,@RequestParam(value = "status", required = false) Integer status) {
		Response res = new Response();
		if(status!=null)
		res.setPayload(pageRepository.findBySiteIdAndStatus(siteId,  status));
		else
			res.setPayload(pageRepository.findBySiteId(siteId));
		res.setMessage("sucessful");
		return res;
	}
	

	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId,
			@RequestBody Pages country) {
		country.setSiteId(siteId);
		country.setProjectId(projectId);
	
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		Pages country2 = pageRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) String projectId,
			@RequestHeader(value = "siteId", required = false) String siteId,@PathVariable(value = "id") Long id) {
		Pages country = pageRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestHeader(value = "projectId", required = false) String projectId,
			@RequestHeader(value = "siteId", required = false) String siteId,@RequestBody SearchObject<Pages> searchObject) {

		System.out.println("countr=" + searchObject);
		Example<Pages> example = Example.of(searchObject.getSearch());
		System.out.println("searchObject.getPage="+searchObject.getPage());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<Pages> countryList = pageRepository.findAll(example, pageable);
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
