package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * The persistent class for the m_domain database table.
 * 
 */
@Entity
@Table(name = "m_domain")
@NamedQuery(name = "MDomain.findAll", query = "SELECT m FROM MDomain m")
public class MDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String domainName;

	private Byte subDomain;
	Integer projectId;
	String logo;
	String websiteName;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Byte getSubDomain() {
		return this.subDomain;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSubDomain(Byte subDomain) {
		this.subDomain = subDomain;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	@Override
	public String toString() {
		return "MDomain [id=" + id + ", domainName=" + domainName + ", subDomain=" + subDomain + ", projectId="
				+ projectId + "]";
	}

}