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
 * The persistent class for the m_imagecategory database table.
 * 
 */
@Entity
@Table(name="m_imagecategory")
@NamedQuery(name="MImagecategory.findAll", query="SELECT m FROM MImagecategory m")
public class MImagecategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String categoryName;

	//bi-directional many-to-one association to MImage
	@OneToMany(mappedBy="MImagecategory")
	private List<MImage> MImages;

	public MImagecategory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<MImage> getMImages() {
		return this.MImages;
	}

	public void setMImages(List<MImage> MImages) {
		this.MImages = MImages;
	}

	public MImage addMImage(MImage MImage) {
		getMImages().add(MImage);
		MImage.setMImagecategory(this);

		return MImage;
	}

	public MImage removeMImage(MImage MImage) {
		getMImages().remove(MImage);
		MImage.setMImagecategory(null);

		return MImage;
	}

}