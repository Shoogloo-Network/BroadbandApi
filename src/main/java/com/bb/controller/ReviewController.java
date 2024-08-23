
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
import com.bb.primary.model.Review;
import com.bb.primary.repository.ReviewRepository;

@RestController
@RequestMapping("admin/review")
public class ReviewController {
	@Autowired
	ReviewRepository mCountryRepository;
	@CrossOrigin
	@GetMapping("/list")
	public Response viewHomePage(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@RequestParam(value = "status", required = false)Integer status) {
		Response res = new Response();
		if(status==null|| status==0 )
		res.setPayload(mCountryRepository.findBySiteId(siteId));
		else
			res.setPayload(mCountryRepository.findBySiteIdAndStatus(siteId,status));
		res.setMessage("sucessful");
		return res;
	}
	@GetMapping("/find/cat/{cat}/id/{id}/status/{status}")
	public Response findByProvider(@RequestHeader(value = "projectId", required = false)
	Integer projectId,@RequestHeader(value = "siteId", required = false)
	Integer siteId,@PathVariable(value = "status", required = true)Integer status,
	@PathVariable(value = "cat") String cat, @PathVariable(value = "id") Integer id) {
		Response res = new Response();
		System.out.println(""+siteId+",cat:"+cat+",id:"+id+",status:"+status);
		res.setPayload(mCountryRepository.findBySiteIdAndCategoryAndEntityIdAndStatus(siteId,cat,id,status));
				res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@RequestBody Review country) {
		Review country2 = mCountryRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@PathVariable(value = "id") Long id) {
		Review country = mCountryRepository.getReferenceById(id);
		Response res = new Response();
		res.setPayload(country);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestBody SearchObject<Review> searchObject) {

		Example<Review> example = Example.of(searchObject.getSearch());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<Review> countryList = mCountryRepository.findAll(example, pageable);
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