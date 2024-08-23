package com.bb.primary.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * The persistent class for the admin_user database table.
 * 
 */
@Entity
@Table(name = "admin_user")
@NamedQuery(name = "AdminUser.findAll", query = "SELECT a FROM AdminUser a")
public class AdminUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	
	private Date activeFrom;


	private Date activeTil;

	@Column(name = "admin_usercol")
	private String adminUsercol;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;

	private String email;

	private String password;

	private String phone;

	private BigInteger role;

	private Integer status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedate;

	private String userid;

	private String username;
	private Integer projectId;
	
	

	public AdminUser() {
	}

	

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
	public Long getId() {
		return id;
	}
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", activeFrom=" + activeFrom + ", activeTil=" + activeTil + ", adminUsercol="
				+ adminUsercol + ", createdate=" + createdate + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", role=" + role + ", status=" + status + ", updatedate=" + updatedate
				+ ", userid=" + userid + ", username=" + username + ", projectId=" + projectId  + "]";
	}

}