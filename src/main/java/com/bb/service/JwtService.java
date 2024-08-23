package com.bb.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


	@Service
	public class JwtService {

		private static final String SECRET_KEY = "ShooglooHfxIqntP8WyPvaE9RCg0ss4Rqc8lnt7BJ5dX38hD2XY8Wg7bCrEch2h6QY7417ZA2024LD";

		public String generateToken(String useremail, Date expireTime) {
			Date nowDt = new Date();
			return Jwts.builder().setSubject(useremail).setIssuedAt(nowDt).setExpiration(expireTime)
					.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
		}

		private Key getSignKey() {
			byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
			return Keys.hmacShaKeyFor(keyBytes);
		}

}
