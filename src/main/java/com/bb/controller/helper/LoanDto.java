package com.bb.controller.helper;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;

public class LoanDto {
	
	private Long Id;
	private String name;
	private String lastname;
	private String mobile;
	private Long loanamount;
	private String loantype;
	private String email;
	private String property_city;
	private String gender;
	private Date createdAt;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getLoanamount() {
		return loanamount;
	}
	public void setLoanamount(Long loanamount) {
		this.loanamount = loanamount;
	}
	public String getLoantype() {
		return loantype;
	}
	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProperty_city() {
		return property_city;
	}
	public void setProperty_city(String property_city) {
		this.property_city = property_city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "LoanDto [Id=" + Id + ", name=" + name + ", lastname=" + lastname + ", mobile=" + mobile
				+ ", loanamount=" + loanamount + ", loantype=" + loantype + ", email=" + email + ", property_city="
				+ property_city + ", gender=" + gender + ", createdAt=" + createdAt + "]";
	}
	
	
}
