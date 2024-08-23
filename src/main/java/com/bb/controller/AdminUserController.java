package com.bb.controller;

import java.util.Optional;

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

import com.bb.controller.helper.Login;
import com.bb.controller.helper.Response;
import com.bb.controller.helper.SearchObject;
import com.bb.primary.model.AdminUser;
import com.bb.primary.model.CmsAccessToken;
import com.bb.primary.repository.AdminRoleUserRelRepository;
import com.bb.primary.repository.AdminUserRepository;
import com.bb.primary.repository.MRoleRepository;
import com.bb.primary.repository.TokenRepository;
import com.bb.service.JwtService;
import com.bb.util.AuthToken;

@RestController
@RequestMapping("admin/adminUser")
public class AdminUserController {
	@Autowired
	AdminUserRepository adminUserRepository;
	AdminRoleUserRelRepository adminRoleUserRelRepository;
	MRoleRepository MroleRepository;

	@Autowired
	TokenRepository jwtTokenRepository;

	private final JwtService jwtService;
	private final AuthToken jwtAuthToken;

	public AdminUserController(JwtService jwtService, AuthToken jwtAuthToken) {
		super();
		this.jwtService = jwtService;
		this.jwtAuthToken = jwtAuthToken;
	}

	@CrossOrigin
	@GetMapping("/list")
	public Response viewHomePage(@RequestHeader(value = "projectId", required = false) Integer projectId) {
		Response res = new Response();
		if (projectId == null || projectId == 1) {
			res.setMessage("in Valid request");
			res.setStatusCode(400);
			return res;
		}

		res.setPayload(adminUserRepository.findByProjectId(projectId));
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestBody AdminUser country) {

		AdminUser country2 = null;
		Response res = new Response();
		if (projectId == null || projectId == 1) {
			res.setMessage("in Valid request");
			res.setStatusCode(400);
			return res;
		}
		try {
			country.setProjectId(projectId);
			country2 = adminUserRepository.save(country);
			jwtAuthToken.createAccessToken(country2.getEmail(), country2.getId());
			res.setPayload(country2);
			res.setMessage("sucessful");

		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("fail:" + e.getLocalizedMessage());
			res.setStatusCode(500);
		}

		return res;
	}

	@CrossOrigin
	@GetMapping("/find/{id}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@PathVariable(value = "id") Long id) {

		Response res = new Response();
		if (projectId == null || projectId == 1) {
			res.setMessage("inValid request");
			res.setStatusCode(400);
			return res;
		}
		try {
			AdminUser country = null;
			System.out.println("id=" + id);
			Optional<AdminUser> r = adminUserRepository.findById(id);
			if (r != null)
				country = r.get();
			res.setPayload(country);

			res.setMessage("sucessful");
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("fail:user not found");
			res.setStatusCode(500);
		}
		return res;
	}

	@CrossOrigin
	@PostMapping("/login")
	public Response login(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestBody Login searchObject) {

		Response res = new Response();
		if (projectId == null || projectId == 1) {
			res.setMessage("inValid request");
			res.setStatusCode(400);
			return res;
		}

		try {
			AdminUser country = adminUserRepository.findByUseridAndPasswordAndStatusAndProjectId(
					searchObject.getUserid(), searchObject.getPassword(), 1, projectId );

			if (country != null) {
				String accessToken = jwtAuthToken.createAccessToken(country.getEmail(), country.getId());
				res.setPayload(country);
				res.setStatusCode(200);
				res.setCmsAccessToken(accessToken);
			} else {
				res.setPayload(country);
				res.setStatusCode(403);
				res.setMessage("no Access");
			}
			res.setMessage("sucessful");
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("fail:" + e.getLocalizedMessage());
			res.setStatusCode(500);
		}
		return res;
	}

	@CrossOrigin
	@PostMapping("search")
	public Response search(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestBody SearchObject<AdminUser> searchObject) {
		Response res = new Response();
		if (projectId == null || projectId == 1) {
			res.setMessage("in Valid request");
			res.setStatusCode(400);
			return res;
		}
		searchObject.getSearch().setProjectId(projectId);
		Example<AdminUser> example = Example.of(searchObject.getSearch());
		Pageable pageable = searchObject.getPage().createAndGetPageable();
		Page<AdminUser> countryList = adminUserRepository.findAll(example, pageable);

		res.setPayload(countryList);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/delete/{id}")
	public Response deleteThroughId(@RequestHeader(value = "projectId", required = false) String projectId,
			@PathVariable(value = "id") Long id) {
		Response res = new Response();
		if (projectId == null) {
			res.setMessage("in Valid request");
			res.setStatusCode(400);
			return res;
		}
		adminUserRepository.deleteById(id);
		return res;

	}

}
