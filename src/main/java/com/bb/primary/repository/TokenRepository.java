package com.bb.primary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bb.primary.model.CmsAccessToken;

public interface TokenRepository extends MongoRepository<CmsAccessToken, Long> {

	CmsAccessToken findByAccessToken(String accessToken);

	CmsAccessToken findByEmail(String email);

	CmsAccessToken deleteByEmail(String userEmail);

}
