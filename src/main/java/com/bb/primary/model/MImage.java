package com.bb.primary.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the m_image database table.
 * 
 */
@Entity
@Table(name="m_image")
@NamedQuery(name="MImage.findAll", query="SELECT m FROM MImage m")
public class MImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String dimension;

	private BigInteger groupimageid;

	private String imageuri;

	private String imageUrl;

	private int sizeKB;

	private byte status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date uploadDate;

	//bi-directional many-to-one association to MImagecategory
	@ManyToOne
	@JoinColumn(name="imagecatoryId")
	private MImagecategory MImagecategory;

	//bi-directional many-to-one association to ProdCategorymaster
	@OneToMany(mappedBy="MImage")
	private List<ProdCategorymaster> prodCategorymasters;

	//bi-directional many-to-one association to ProdTagImageRel
	@OneToMany(mappedBy="MImage")
	private List<ProdTagImageRel> prodTagImageRels;

	public MImage() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDimension() {
		return this.dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public BigInteger getGroupimageid() {
		return this.groupimageid;
	}

	public void setGroupimageid(BigInteger groupimageid) {
		this.groupimageid = groupimageid;
	}

	public String getImageuri() {
		return this.imageuri;
	}

	public void setImageuri(String imageuri) {
		this.imageuri = imageuri;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getSizeKB() {
		return this.sizeKB;
	}

	public void setSizeKB(int sizeKB) {
		this.sizeKB = sizeKB;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public MImagecategory getMImagecategory() {
		return this.MImagecategory;
	}

	public void setMImagecategory(MImagecategory MImagecategory) {
		this.MImagecategory = MImagecategory;
	}

	public List<ProdCategorymaster> getProdCategorymasters() {
		return this.prodCategorymasters;
	}

	public void setProdCategorymasters(List<ProdCategorymaster> prodCategorymasters) {
		this.prodCategorymasters = prodCategorymasters;
	}

	public ProdCategorymaster addProdCategorymaster(ProdCategorymaster prodCategorymaster) {
		getProdCategorymasters().add(prodCategorymaster);
		prodCategorymaster.setMImage(this);

		return prodCategorymaster;
	}

	public ProdCategorymaster removeProdCategorymaster(ProdCategorymaster prodCategorymaster) {
		getProdCategorymasters().remove(prodCategorymaster);
		prodCategorymaster.setMImage(null);

		return prodCategorymaster;
	}

	public List<ProdTagImageRel> getProdTagImageRels() {
		return this.prodTagImageRels;
	}

	public void setProdTagImageRels(List<ProdTagImageRel> prodTagImageRels) {
		this.prodTagImageRels = prodTagImageRels;
	}

	public ProdTagImageRel addProdTagImageRel(ProdTagImageRel prodTagImageRel) {
		getProdTagImageRels().add(prodTagImageRel);
		prodTagImageRel.setMImage(this);

		return prodTagImageRel;
	}

	public ProdTagImageRel removeProdTagImageRel(ProdTagImageRel prodTagImageRel) {
		getProdTagImageRels().remove(prodTagImageRel);
		prodTagImageRel.setMImage(null);

		return prodTagImageRel;
	}

}