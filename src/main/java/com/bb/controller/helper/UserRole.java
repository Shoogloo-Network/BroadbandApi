package com.bb.controller.helper;

import java.math.BigInteger;
import java.util.Date;

public class UserRole {
	
	private Long user_id;

	
	private Date activeFrom;


	private Date activeTil;


	private String adminUsercol;

	private Date createdate;

	private String email;

	private String password;

	private String phone;

	private BigInteger role;

	private Integer status;

	private Date updatedate;

	private String userid;

	private String username;
	private Integer projectId;
	
	
	

	public Date getActiveFrom() {
		return this.activeFrom;
	}

	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}

	public Date getActiveTil() {
		return this.activeTil;
	}

	public void setActiveTil(Date activeTil) {
		this.activeTil = activeTil;
	}

	public String getAdminUsercol() {
		return this.adminUsercol;
	}

	public void setAdminUsercol(String adminUsercol) {
		this.adminUsercol = adminUsercol;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return "";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigInteger getRole() {
		return this.role;
	}

	public void setRole(BigInteger role) {
		this.role = role;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



}
