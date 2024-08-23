package com.bb.primary.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the m_tag database table.
 * 
 */
@Entity
@Table(name="m_tag")
@NamedQuery(name="MTag.findAll", query="SELECT m FROM MTag m")
public class MTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String tag;

	//bi-directional many-to-one association to ProdTagImageRel
	@OneToMany(mappedBy="MTag")
	private List<ProdTagImageRel> prodTagImageRels;

	public MTag() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<ProdTagImageRel> getProdTagImageRels() {
		return this.prodTagImageRels;
	}

	public void setProdTagImageRels(List<ProdTagImageRel> prodTagImageRels) {
		this.prodTagImageRels = prodTagImageRels;
	}

	public ProdTagImageRel addProdTagImageRel(ProdTagImageRel prodTagImageRel) {
		getProdTagImageRels().add(prodTagImageRel);
		prodTagImageRel.setMTag(this);

		return prodTagImageRel;
	}

	public ProdTagImageRel removeProdTagImageRel(ProdTagImageRel prodTagImageRel) {
		getProdTagImageRels().remove(prodTagImageRel);
		prodTagImageRel.setMTag(null);

		return prodTagImageRel;
	}

}