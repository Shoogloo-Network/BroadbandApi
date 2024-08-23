package com.bb.primary.model;

import java.io.Serializable;
import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * The persistent class for the admin_role_page_rel database table.
 * 
 */
@Entity
@Table(name="admin_role_activity_rel")

public class AdminRoleActivityRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private BigInteger roleId;

	private BigInteger activityId;

	public AdminRoleActivityRel() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public BigInteger getRoleId() {
		return roleId;
	}

	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}

	public BigInteger getActivityId() {
		return activityId;
	}

	public void setActivityId(BigInteger activityId) {
		this.activityId = activityId;
	}

	
}