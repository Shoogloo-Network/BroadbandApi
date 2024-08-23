package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the prod_project_category_rel database table.
 * 
 */
@Entity
@Table(name="prod_project_category_rel")
@NamedQuery(name="ProdProjectCategoryRel.findAll", query="SELECT p FROM ProdProjectCategoryRel p")
public class ProdProjectCategoryRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte status;

	//bi-directional many-to-one association to ProdCategorymaster
	@ManyToOne
	@JoinColumn(name="categoryId")
	private ProdCategorymaster prodCategorymaster;

	//bi-directional many-to-one association to MDomain
	@ManyToOne
	@JoinColumn(name="domainId")
	private MDomain MDomain;

	//bi-directional many-to-one association to MCountry
	@ManyToOne
	@JoinColumn(name="countryId")
	private MCountry MCountry;

	//bi-directional many-to-one association to MProject
	@ManyToOne
	@JoinColumn(name="projectId")
	private MProject MProject;

	public ProdProjectCategoryRel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public ProdCategorymaster getProdCategorymaster() {
		return this.prodCategorymaster;
	}

	public void setProdCategorymaster(ProdCategorymaster prodCategorymaster) {
		this.prodCategorymaster = prodCategorymaster;
	}

	public MDomain getMDomain() {
		return this.MDomain;
	}

	public void setMDomain(MDomain MDomain) {
		this.MDomain = MDomain;
	}

	public MCountry getMCountry() {
		return this.MCountry;
	}

	public void setMCountry(MCountry MCountry) {
		this.MCountry = MCountry;
	}

	public MProject getMProject() {
		return this.MProject;
	}

	public void setMProject(MProject MProject) {
		this.MProject = MProject;
	}

}