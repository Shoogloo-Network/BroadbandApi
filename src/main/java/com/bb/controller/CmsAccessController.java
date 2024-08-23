package com.bb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.Response;
import com.bb.primary.model.CmsAccessToken;
import com.bb.primary.repository.TokenRepository;


@RestController
@RequestMapping("admin/cms")
public class CmsAccessController {
	@Autowired
	TokenRepository jwtTokenRepository;
	
	@CrossOrigin
	@GetMapping("/getUserAccessToken")
	public Response getUserAccessToken(@RequestHeader(value = "siteId", required = true) Long siteId,
			@RequestHeader(value = "accessToken", required = false) String accessToken, @RequestHeader HttpHeaders headers) {
		
		String authorizationHeader = headers.getFirst("Authorization");
		if (authorizationHeader != null) {
            accessToken = authorizationHeader.substring("Bearer ".length());
        }
		Response res = new Response();
		CmsAccessToken userAccessToken = jwtTokenRepository.findByAccessToken(accessToken);
		userAccessToken.setUserId(null);
		res.setPayload(userAccessToken);
		res.setMessage("sucessful");
		return res;
	}
	
	@CrossOrigin
	@GetMapping("/getUserAccessTokenByEmail")
	public Response getUserAccessTokenByEmail(@RequestHeader(value = "siteId", required = true) Long siteId,
			@RequestHeader(value = "email", required = false) String email) {
		
		
		Response res = new Response();
		CmsAccessToken userAccessToken = jwtTokenRepository.findByEmail(email);
		userAccessToken.setUserId(null);
		res.setPayload(userAccessToken);
		res.setMessage("sucessful");
		return res;
	}

}
