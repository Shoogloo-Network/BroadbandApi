package com.bb.primary.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Document 
public class CmsAccessToken {
	
	@Id
	String id;
	Long userId;
	String accessToken;
	Date expireAfterSeconds;
	Date lastLoginAt;
	Long timeInMilli;
	String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Date getExpireAfterSeconds() {
		return expireAfterSeconds;
	}
	public void setExpireAfterSeconds(Date expireAfterSeconds) {
		this.expireAfterSeconds = expireAfterSeconds;
	}
	public Date getLastLoginAt() {
		return lastLoginAt;
	}
	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}
	public Long getTimeInMilli() {
		return timeInMilli;
	}
	public void setTimeInMilli(Long timeInMilli) {
		this.timeInMilli = timeInMilli;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserAccessToken [id=" + id + ", userId=" + userId + ", accessToken=" + accessToken
				+ ", expireAfterSeconds=" + expireAfterSeconds + ", lastLoginAt=" + lastLoginAt + ", timeInMilli="
				+ timeInMilli + ", email=" + email + "]";
	}
	
	
	
}
