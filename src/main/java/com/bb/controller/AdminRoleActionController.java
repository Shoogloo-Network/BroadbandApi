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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.Response;
import com.bb.controller.helper.SearchObject;
import com.bb.primary.model.AdminRoleActionRel;
import com.bb.primary.repository.AdminRoleActionRelRepository;

@RestController
@RequestMapping("admin/AdminRoleAction")
public class AdminRoleActionController {
	@Autowired
	AdminRoleActionRelRepository adminRoleActionRelRepository;
	@CrossOrigin
	@GetMapping("/list")
	public Response viewHomePage(Model model) {
		Response res = new Response();
		res.setPayload(adminRoleActionRelRepository.findAll());
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestBody AdminRoleActionRel country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		AdminRoleActionRel country2 = adminRoleActionRelRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		AdminRoleActionRel country = adminRoleActionRelRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestBody SearchObject<AdminRoleActionRel> searchObject) {

		System.out.println("countr=" + searchObject);
		Example<AdminRoleActionRel> example = Example.of(searchObject.getSearch());
		System.out.println("searchObject.getPage="+searchObject.getPage());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<AdminRoleActionRel> countryList = adminRoleActionRelRepository.findAll(example, pageable);
		System.out.println("countryList=" + countryList);
		Response res = new Response();
		res.setPayload(countryList);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/delete/{id}")
	public String deleteThroughId(@PathVariable(value = "id") int id) {
		// mCountryRepository.deleteById(id);
		return "redirect:/";

	}
}
