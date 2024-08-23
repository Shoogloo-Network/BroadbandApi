
package com.bb.controller;

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
import com.bb.controller.helper.Response;
import com.bb.controller.helper.SearchObject;
import com.bb.primary.model.MDomain;
import com.bb.primary.repository.DomainRepository;

@RestController
@RequestMapping("admin/site")
public class DomainController {
	@Autowired
	DomainRepository mDomainRepository;
	@CrossOrigin
	@GetMapping("/list/{projectId}")
	public Response viewHomePage(Model model,@PathVariable(value = "projectId", required = false) Integer id,
			@RequestParam(value = "cache", required = false) Integer cache) {
		Response res = new Response();
		
			res.setPayload(CacheObject.doaminList.get(id));
		
		res.setMessage("sucessful");
		return res;
	}
	
	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId" , required = false) String siteId,@RequestBody MDomain country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		MDomain country2 = mDomainRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@RequestHeader(value = "projectId" , required = false) Integer projectId,@RequestHeader(value = "siteId" , required = false) Integer siteId,@PathVariable(value = "id") Integer id) {
		System.out.println("id=" + id);
		MDomain country = mDomainRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestHeader(value = "projectId" , required = false) Integer projectId,@RequestHeader(value = "siteId" , required = false) Integer siteId,@RequestBody SearchObject<MDomain> searchObject) {

		Example<MDomain> example = Example.of(searchObject.getSearch());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<MDomain> countryList = mDomainRepository.findAll(example, pageable);
		Response res = new Response();
		res.setPayload(countryList);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/delete/{id}")
	public String deleteThroughId(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId" , required = false) String siteId,@PathVariable(value = "id") int id) {
		// mCountryRepository.deleteById(id);
		return "redirect:/";

	}
}

