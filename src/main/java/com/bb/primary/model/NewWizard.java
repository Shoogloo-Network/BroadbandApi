package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "new_wizard")
@NamedQuery(name = "NewWizard.findAll", query = "SELECT n FROM NewWizard n")
public class NewWizard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Lob
	private String description;

	private String freetext;

	private String image;

	private String morelink;

	private Long siteId;

	private String title;
	String name;
	Long menuId;
	Long entityId;
	Integer status;
	String tag;
	Integer sortingOrder;
	String entityName;

	public NewWizard() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFreetext() {
		return this.freetext;
	}

	public void setFreetext(String freetext) {
		this.freetext = freetext;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMorelink() {
		return this.morelink;
	}

	public void setMorelink(String morelink) {
		this.morelink = morelink;
	}

	public Long getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "NewWizard [id=" + id + ", description=" + description + ", freetext=" + freetext + ", image=" + image
				+ ", morelink=" + morelink + ", siteId=" + siteId + ", title=" + title + ", name=" + name + ", menuId="
				+ menuId + ", entityId=" + entityId + ", status=" + status + ", tag=" + tag + "]";
	}

	public Integer getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	
}