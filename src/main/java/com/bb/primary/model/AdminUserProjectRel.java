package com.bb.primary.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the admin_user_project_rel database table.
 * 
 */
@Entity
@Table(name="admin_user_project_rel")
@NamedQuery(name="AdminUserProjectRel.findAll", query="SELECT a FROM AdminUserProjectRel a")
public class AdminUserProjectRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	//bi-directional many-to-one association to AdminUser
	@ManyToOne
	@JoinColumn(name="userid")
	private AdminUser adminUser;

	//bi-directional many-to-one association to MProject
	@ManyToOne
	@JoinColumn(name="projectId")
	private MProject MProject;

	public AdminUserProjectRel() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AdminUser getAdminUser() {
		return this.adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

	public MProject getMProject() {
		return this.MProject;
	}

	public void setMProject(MProject MProject) {
		this.MProject = MProject;
	}

}