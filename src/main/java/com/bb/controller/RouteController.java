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
import com.bb.primary.model.Route;
import com.bb.primary.repository.RouteRepository;

@RestController
@RequestMapping("admin/route")
public class RouteController {
	@Autowired
	RouteRepository routeRepository;
	@CrossOrigin
	@GetMapping("/list")
	public Response viewHomePage(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId", required = false) Integer siteId) {
		Response res = new Response();
		res.setPayload(routeRepository.findBySiteId(siteId));
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestBody Route country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		Route country2 = routeRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		Route country = routeRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestBody SearchObject<Route> searchObject) {

	
		Example<Route> example = Example.of(searchObject.getSearch());

		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<Route> countryList = routeRepository.findAll(example, pageable);

		Response res = new Response();
		res.setPayload(countryList);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/delete/{id}")
	public Response deleteThroughId(@PathVariable(value = "id") Long id) {
		routeRepository.deleteById(id);
		 Response res = new Response();
			res.setPayload(id);

			res.setMessage("sucessful");
			return res;

	}
}
