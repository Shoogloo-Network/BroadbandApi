package com.bb.primary.model;

import java.io.Serializable;
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


/**
 * The persistent class for the prod_categorymaster database table.
 * 
 */
@Entity
@Table(name="prod_categorymaster")
@NamedQuery(name="ProdCategorymaster.findAll", query="SELECT p FROM ProdCategorymaster p")
public class ProdCategorymaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String category;

	private int dataTpyeId;

	private String descption2;

	private String description;

	private String status;

	private String tooltip;

	//bi-directional many-to-one association to MImage
	@ManyToOne
	@JoinColumn(name="imageId")
	private MImage MImage;

	//bi-directional many-to-one association to ProdProjectCategoryRel
	@OneToMany(mappedBy="prodCategorymaster")
	private List<ProdProjectCategoryRel> prodProjectCategoryRels;

	public ProdCategorymaster() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getDataTpyeId() {
		return this.dataTpyeId;
	}

	public void setDataTpyeId(int dataTpyeId) {
		this.dataTpyeId = dataTpyeId;
	}

	public String getDescption2() {
		return this.descption2;
	}

	public void setDescption2(String descption2) {
		this.descption2 = descption2;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTooltip() {
		return this.tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public MImage getMImage() {
		return this.MImage;
	}

	public void setMImage(MImage MImage) {
		this.MImage = MImage;
	}

	public List<ProdProjectCategoryRel> getProdProjectCategoryRels() {
		return this.prodProjectCategoryRels;
	}

	public void setProdProjectCategoryRels(List<ProdProjectCategoryRel> prodProjectCategoryRels) {
		this.prodProjectCategoryRels = prodProjectCategoryRels;
	}

	public ProdProjectCategoryRel addProdProjectCategoryRel(ProdProjectCategoryRel prodProjectCategoryRel) {
		getProdProjectCategoryRels().add(prodProjectCategoryRel);
		prodProjectCategoryRel.setProdCategorymaster(this);

		return prodProjectCategoryRel;
	}

	public ProdProjectCategoryRel removeProdProjectCategoryRel(ProdProjectCategoryRel prodProjectCategoryRel) {
		getProdProjectCategoryRels().remove(prodProjectCategoryRel);
		prodProjectCategoryRel.setProdCategorymaster(null);

		return prodProjectCategoryRel;
	}

}