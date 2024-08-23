package com.bb.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bb.primary.model.AdminUser;
import com.bb.primary.model.CmsAccessToken;
import com.bb.primary.repository.AdminUserRepository;
import com.bb.primary.repository.TokenRepository;
import com.bb.service.JwtService;

@Service
public class AuthToken {
	@Autowired
	TokenRepository jwtTokenRepository;
	AdminUserRepository adminUserRepository;
    public static HashMap<String,CmsAccessToken> staticMap = new HashMap<>(); 
	public String createAccessToken(String userEmail, Long userId) {
		AdminUser user = new AdminUser();
		JwtService jwtService = new JwtService();
		CmsAccessToken jwtHelper = new CmsAccessToken();
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		long date1 = calendar.getTimeInMillis();
		Date expireTime = new Date(System.currentTimeMillis() + 1000 * 60 * 30);

		jwtTokenRepository.deleteByEmail(userEmail);

		// simple generate user access token
		String accessToken = jwtService.generateToken(userEmail, expireTime);
		staticMap.put(""+userId, jwtHelper);
		jwtHelper.setUserId(userId);
		jwtHelper.setEmail(userEmail);
		jwtHelper.setAccessToken(accessToken);
		jwtHelper.setExpireAfterSeconds(expireTime);
		jwtHelper.setLastLoginAt(new Date());
		jwtHelper.setTimeInMilli(date1);
		jwtTokenRepository.save(jwtHelper);
		return accessToken;

	}
}
