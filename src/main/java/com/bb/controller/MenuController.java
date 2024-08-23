
package com.bb.controller;

import java.util.List;

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
import com.bb.primary.model.MCity;
import com.bb.primary.model.Menu;
import com.bb.primary.repository.MCityRepository;
import com.bb.primary.repository.MenuRepository;

@RestController
@RequestMapping("admin/menu")
public class MenuController {
	@Autowired
	MenuRepository mCountryRepository;
	@Autowired
	MCityRepository cityRepository;
	@CrossOrigin
	@GetMapping("/list")
	public Response viewHomePage(@RequestHeader(value = "projectId", required = false) Long projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId) {
		Response res = new Response();
		List<Menu> pageList = mCountryRepository.findBySiteId(siteId);
	
		res.setPayload(pageList);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/listMenu")
	public Response viewMax(@RequestHeader(value = "projectId", required = false) Long projectId,@RequestHeader(value = "siteId", required = false) Long siteId ) {
		Response res = new Response();
		List<Menu> pageList = mCountryRepository.findBySiteId(siteId);
		List<MCity>cityList=cityRepository.findBySiteIdAndMenu(siteId,1);
		
		res.setPayload(pageList);
		res.setMessage("sucessful");
		return res;
	}

	@GetMapping("/list/status/{status}")
	public Response viewHomePagesiteUd(@RequestHeader(value = "projectId", required = false) Long projectId, @RequestHeader(value = "siteId", required = false) Long siteId, @PathVariable(value = "status") Integer status) {
		Response res = new Response();
		List<Menu> pageList =null;
		if(status==1 || status==0)
		pageList=mCountryRepository.findBySiteIdAndStatusOrderBySortOrderAsc( siteId,status);
		else
			pageList=mCountryRepository.findByProjectIdAndSiteIdOrderBySortOrder(projectId, siteId);
			
		res.setPayload(pageList);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@RequestBody Menu country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		Menu country2 = mCountryRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		Menu country = mCountryRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@RequestBody SearchObject<Menu> searchObject) {

		System.out.println("countr=" + searchObject);
		Example<Menu> example = Example.of(searchObject.getSearch());
		System.out.println("searchObject.getPage=" + searchObject.getPage());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<Menu> countryList = mCountryRepository.findAll(example, pageable);
		System.out.println("countryList=" + countryList);
		Response res = new Response();
		res.setPayload(countryList);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/delete/{id}")
	public String deleteThroughId(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@PathVariable(value = "id") int id) {
		// mCountryRepository.deleteById(id);
		return "redirect:/";

	}
}