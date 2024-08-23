package com.bb.primary.model;

import java.io.Serializable;

import  jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * The persistent class for the boradbandattributemaster database table.
 * 
 */
@Entity

@Table(name="broadbandAttributeValue")

public class BroadbandAttributeValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private Long broadbandAttributeId;
	private String value;
	private String image;
	private String sortDesc;
	
	private String description;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBroadbandAttributeId() {
		return broadbandAttributeId;
	}

	public void setBroadbandAttributeId(Long broadbandAttributeId) {
		this.broadbandAttributeId = broadbandAttributeId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSortDesc() {
		return sortDesc;
	}

	public void setSortDesc(String sortDesc) {
		this.sortDesc = sortDesc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BoradbandAttributeValue [id=" + id + ", broadbandAttributeId=" + broadbandAttributeId + ", value="
				+ value + ", image=" + image + ", sortDesc=" + sortDesc + ", description=" + description + "]";
	}

	
}