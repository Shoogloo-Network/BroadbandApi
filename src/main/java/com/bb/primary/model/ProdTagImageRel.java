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
 * The persistent class for the prod_tag_image_rel database table.
 * 
 */
@Entity
@Table(name="prod_tag_image_rel")
@NamedQuery(name="ProdTagImageRel.findAll", query="SELECT p FROM ProdTagImageRel p")
public class ProdTagImageRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to MImage
	@ManyToOne
	@JoinColumn(name="imageId")
	private MImage MImage;

	//bi-directional many-to-one association to MTag
	@ManyToOne
	@JoinColumn(name="tagid")
	private MTag MTag;

	public ProdTagImageRel() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MImage getMImage() {
		return this.MImage;
	}

	public void setMImage(MImage MImage) {
		this.MImage = MImage;
	}

	public MTag getMTag() {
		return this.MTag;
	}

	public void setMTag(MTag MTag) {
		this.MTag = MTag;
	}

}