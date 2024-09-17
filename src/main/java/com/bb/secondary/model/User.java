package com.bb.secondary.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private String lastname;
	private String mobile;
	private Long loanamount;
	private String loantype;
	private String email;
	private String property_city;
	private Long interestrate = 0l;
	private int tenure;
	private String gender;
	private String otp = "123456";
	private int status;
	@CreationTimestamp
	@Column(updatable = false)
	private Date created_at;
	@CreationTimestamp
	private Date updated_at;

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

	public Long getInterestrate() {
		return interestrate;
	}

	public void setInterestrate(Long interestrate) {
		this.interestrate = interestrate;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", lastname=" + lastname + ", mobile=" + mobile + ", loanamount="
				+ loanamount + ", loantype=" + loantype + ", email=" + email + ", property_city=" + property_city
				+ ", interestrate=" + interestrate + ", tenure=" + tenure + ", gender=" + gender + ", otp=" + otp
				+ ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

}
