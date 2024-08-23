package com.bb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.Response;
import com.bb.service.JwtService;
import com.bb.util.AuthToken;
import com.bb.controller.helper.SearchObject;
import com.bb.primary.model.AdminActivity;
import com.bb.primary.model.CmsAccessToken;
import com.bb.primary.repository.AdminActivityRepository;
import com.bb.primary.repository.TokenRepository;


@RestController
@RequestMapping("admin/adminActivity")
public class AdminActivityController {
	@Autowired
	AdminActivityRepository adminActivityRepository;
	@Autowired
	TokenRepository jwtTokenRepository;
	
	private final JwtService jwtService;
	private final AuthToken jwtAuthToken;
	
	
	public AdminActivityController(JwtService jwtService, AuthToken jwtAuthToken) {
		super();
		this.jwtService = jwtService;
		this.jwtAuthToken = jwtAuthToken;
	}
	@CrossOrigin
	@GetMapping("/list")
	public Response viewHomePage(Model model) {
		Response res = new Response();
		res.setPayload(adminActivityRepository.findAll());
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestHeader(value = "accessToken", required = false) String accessToken  ,
			@RequestBody AdminActivity country,
			@RequestHeader HttpHeaders headers) {
	//	AuthToken token = new AuthToken();
		String authorizationHeader = headers.getFirst("Authorization");
		if (authorizationHeader != null) {
            accessToken = authorizationHeader.substring("Bearer ".length());
        } 
		AdminActivity country2 = null;
	//	boolean user = token.staticMap.containsValue(accessToken);
	//	System.out.println("user:"+user);
		CmsAccessToken userAccessToken = jwtTokenRepository.findByAccessToken(accessToken);
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		if(userAccessToken!=null) {
		 country2 = adminActivityRepository.save(country);
		}
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		AdminActivity country = adminActivityRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestBody SearchObject<AdminActivity> searchObject) {

		System.out.println("countr=" + searchObject);
		Example<AdminActivity> example = Example.of(searchObject.getSearch());
		System.out.println("searchObject.getPage="+searchObject.getPage());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<AdminActivity> countryList = adminActivityRepository.findAll(example, pageable);
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
	@CrossOrigin
	@GetMapping("/getUserAccessToken")
	public Response getUserAccessToken(@RequestHeader(value = "siteId", required = true) Long siteId,
			@RequestHeader(value = "accessToken", required = false) String accessToken, @RequestHeader HttpHeaders headers) {
		
		String authorizationHeader = headers.getFirst("Authorization");
		if (authorizationHeader != null) {
            accessToken = authorizationHeader.substring("Bearer ".length());
        }
		Response res = new Response();
		CmsAccessToken cmsAccessToken = jwtTokenRepository.findByAccessToken(accessToken);
		cmsAccessToken.setUserId(null);
		res.setPayload(cmsAccessToken);
		res.setMessage("sucessful");
		return res;
	}
}
