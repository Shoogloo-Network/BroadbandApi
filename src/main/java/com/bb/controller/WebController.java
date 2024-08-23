
package com.bb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bb.controller.helper.MenuHelper;
import com.bb.controller.helper.Response;
import com.bb.primary.model.LeadForm;
import com.bb.primary.model.MCity;
import com.bb.primary.model.MCountry;
import com.bb.primary.model.Menu;
import com.bb.primary.model.Pages;
import com.bb.primary.model.Provider;
import com.bb.primary.model.Route;
import com.bb.primary.repository.LeadFormRepository;
import com.bb.primary.repository.MCityRepository;
import com.bb.primary.repository.MCountryRepository;
import com.bb.primary.repository.MenuRepository;
import com.bb.primary.repository.PageRepository;
import com.bb.primary.repository.ProviderRepository;
import com.bb.primary.repository.RouteRepository;

@RestController
@RequestMapping("admin/web")
public class WebController {

	@Autowired
	LeadFormRepository leadFormRepository;
	@Autowired
	CacheObject cacheObject;

	@CrossOrigin
	@GetMapping("/menu")
	public Response viewHomePage(@RequestHeader(value = "projectId", required = false) Long projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId,
			@RequestParam(value = "status", required = false) Integer status) {
		Response res = new Response();

		res.setPayload(CacheObject.menuHelperList.get(siteId));
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/page/{seoName}")
	public Response viewMax(@RequestHeader(value = "projectId", required = false) Long projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId,
			@PathVariable(value = "seoName") String seoName) {
		Response res = new Response();
		res.setWizard(CacheObject.wizardMap.get(siteId).get("page" + seoName));
		Pages page = CacheObject.pageMap.get(siteId).get(seoName);

		res.setPayload(page);
		res.setMessage("sucessful");
		return res;
	}

	@GetMapping("/city/{seoName}")
	public Response viewHomePagesiteUd(@RequestHeader(value = "projectId", required = false) Long projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId,
			@PathVariable(value = "seoName") String seoName) {
		Response res = new Response();

		MCity city = CacheObject.cityMap.get(siteId).get(seoName);

		if (city != null) {
			try {
				if (CacheObject.countryIdMap.get(siteId).get("" + city.getCountryId()) != null)
					city.setCountry(CacheObject.countryIdMap.get(siteId).get("" + city.getCountryId()).getName());

			} catch (Exception e) {
			}
		}
		Map map = new HashMap<String, Object>();
		map.put("city", city);
		map.put("wizard", CacheObject.wizardMap.get(siteId).get("city" + seoName));
		res.setPayload(map);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/provider/{category}/{seoName}")
	public Response saveEmployee(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId,
			@PathVariable(value = "seoName") String seoName, @PathVariable(value = "category") String category) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		// System.out.println("country=" + country);
		// Menu country2 = mCountryRepository.save(country);
		Response res = new Response();
		Provider city = null;
		if (category != null && category.equals("bus")) {
			city = CacheObject.busProviderMap.get(siteId).get(seoName);
			res.setWizard(CacheObject.wizardMap.get(siteId).get("busProvider" + seoName));
		}
		if (category != null && category.equals("rail")) {
			city = CacheObject.railProviderMap.get(siteId).get(seoName);
			res.setWizard(CacheObject.wizardMap.get(siteId).get("railProvider" + seoName));
		}
		res.setPayload(city);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/country/{seoName}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId,
			@PathVariable(value = "seoName") Integer seoName) {
		// System.out.println("id=" + id);
		// Menu country = mCountryRepository.getReferenceById(id);

		Response res = new Response();
		// res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/route/{seoName}")
	public Response route(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId,
			@PathVariable(value = "seoName") String seoName) {
		// System.out.println("id=" + id);
		Route country = CacheObject.routeMap.get(siteId).get(seoName);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("/leadform/save")
	public Response leadForm(@RequestBody LeadForm leadForm,
			@RequestHeader(value = "siteId", required = false) Integer siteId) {
		// System.out.println("id=" + id);
		leadForm.setDateTime(new Date());
		LeadForm country = leadFormRepository.save(leadForm);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/leadform/list")
	public Response list(@RequestHeader(value = "siteId", required = false) Integer siteId) {
		// System.out.println("id=" + id);
		List<LeadForm> country = leadFormRepository.findAll();

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

}