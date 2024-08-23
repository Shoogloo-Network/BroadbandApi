
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
import com.bb.primary.model.MImage;
import com.bb.primary.repository.MImageRepository;

@RestController
@RequestMapping("admin/Image")
public class MImageController {
	@Autowired
	MImageRepository mImageRepository;
	@CrossOrigin
	@GetMapping("/list")
	public Response viewHomePage(Model model) {
		Response res = new Response();
		res.setPayload(mImageRepository.findAll());
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestBody MImage country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		MImage country2 = mImageRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		MImage country = mImageRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestBody SearchObject<MImage> searchObject) {

		System.out.println("countr=" + searchObject);
		Example<MImage> example = Example.of(searchObject.getSearch());
		System.out.println("searchObject.getPage="+searchObject.getPage());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<MImage> countryList = mImageRepository.findAll(example, pageable);
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