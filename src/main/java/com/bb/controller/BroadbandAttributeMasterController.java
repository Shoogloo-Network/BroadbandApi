package com.bb.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.BroadbandAttributeValueMap;
import com.bb.controller.helper.Response;
import com.bb.controller.helper.SearchObject;
import com.bb.primary.model.BroadbandAttributeMaster;
import com.bb.primary.model.BroadbandAttributeValue;
import com.bb.primary.repository.BroadbandAttributeMasterRepository;
import com.bb.primary.repository.BroadbandAttributeValueRepository;

@RestController
@RequestMapping("admin/broadbandAttribute")
public class BroadbandAttributeMasterController {
	@Autowired
	BroadbandAttributeMasterRepository broadbandAttributeRepository;
	@Autowired
	BroadbandAttributeValueRepository broadbandAttributeValueRepository;

	@CrossOrigin
	@GetMapping("/list")
	public Response viewHomePage(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId", required = false) String siteId,Model model) {
		Response res = new Response();
		res.setPayload(broadbandAttributeRepository.findAll());
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId", required = false) String siteId,@RequestBody BroadbandAttributeMaster country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		BroadbandAttributeMaster country2 = broadbandAttributeRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/findByAttribute/{id}")
	public Response findAttribute(@PathVariable(value = "id") Long id) {
		List<BroadbandAttributeValue> countryList = broadbandAttributeValueRepository.findByBroadbandAttributeId(id);

		Response res = new Response();
		res.setPayload(countryList);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId", required = false) String siteId,@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		BroadbandAttributeMaster country = broadbandAttributeRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestHeader(value = "projectId", required = false) Integer projectId,@RequestHeader(value = "siteId", required = false) Integer siteId,@RequestBody SearchObject<BroadbandAttributeMaster> searchObject) {

		Example<BroadbandAttributeMaster> example = Example.of(searchObject.getSearch());
		System.out.println("searchObject.getPage=" + searchObject.getPage());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<BroadbandAttributeMaster> countryList = broadbandAttributeRepository.findAll(example, pageable);
		System.out.println("Boradbandattributemaster=" + countryList);
		Response res = new Response();
		res.setPayload(countryList);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/delete/{id}")
	public Response deleteThroughId(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId", required = false) String siteId,@PathVariable(value = "id") Long id) {
		broadbandAttributeRepository.deleteById(id);
		Response res = new Response();
		res.setMessage("sucessful");
		return res;

	}

	@CrossOrigin
	@PostMapping("/saveBoradBandAttributeValue")
	public Response mapBoradBandAttribute(@RequestHeader(value = "projectId", required = false) String projectId,@RequestHeader(value = "siteId", required = false) String siteId,@RequestBody BroadbandAttributeValueMap country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);

		List<BroadbandAttributeValue> attrList = broadbandAttributeValueRepository
				.findByBroadbandAttributeId(country.getBroadBandArributeId());
		if (attrList != null) {
			for (BroadbandAttributeValue attr : attrList) {
				broadbandAttributeValueRepository.delete(attr);
			}
		}
		if (country.getArttibuteList() != null)
			for (BroadbandAttributeValue attr : country.getArttibuteList()) {

				attr.setBroadbandAttributeId(country.getBroadBandArributeId());
				attr.setDescription(attr.getDescription());
				attr.setImage(attr.getImage());
				attr.setSortDesc(attr.getImage());
				attr.setValue(attr.getValue());
				broadbandAttributeValueRepository.save(attr);
			}
		Response res = new Response();
		res.setPayload(country);
		res.setMessage("sucessful");
		return res;
	}
}
