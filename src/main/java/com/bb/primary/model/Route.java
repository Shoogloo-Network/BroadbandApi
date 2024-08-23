package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="m_route")

public class Route implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String city1;
	private String city2;
	private String name;
	private String url;
	private String 	displayName;
	private String  status;
	Integer		  projectId;
	Integer siteId;
	private String  shortDesc;

	private String  description;


	private Integer  sortingOrder;
	private String  body1;
	private String  meta1;
	private String  footer1;
	private String seoName;
	Integer menu;

	private String  logo;
	private String  image;
	private String thumbnail;
	private String  meta_title;
	private String  meta_keyword;
	private String  meta_description;
	private String h1tag;
	private String tracking_link;
	
	public String getH1tag() {
		return h1tag;
	}
	public void setH1tag(String h1tag) {
		this.h1tag = h1tag;
	}
	public String getTracking_link() {
		return tracking_link;
	}
	public void setTracking_link(String tracking_link) {
		this.tracking_link = tracking_link;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSortingOrder() {
		return sortingOrder;
	}
	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}
	public String getBody1() {
		return body1;
	}
	public void setBody1(String body1) {
		this.body1 = body1;
	}
	public String getMeta1() {
		return meta1;
	}
	public void setMeta1(String meta1) {
		this.meta1 = meta1;
	}
	public String getFooter1() {
		return footer1;
	}
	public void setFooter1(String footer1) {
		this.footer1 = footer1;
	}
	public String getSeoName() {
		return seoName;
	}
	public void setSeoName(String seoName) {
		this.seoName = seoName;
	}
	public Integer getMenu() {
		return menu;
	}
	public void setMenu(Integer menu) {
		this.menu = menu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMeta_title() {
		return meta_title;
	}
	public void setMeta_title(String meta_title) {
		this.meta_title = meta_title;
	}
	public String getMeta_keyword() {
		return meta_keyword;
	}
	public void setMeta_keyword(String meta_keyword) {
		this.meta_keyword = meta_keyword;
	}
	public String getMeta_description() {
		return meta_description;
	}
	public void setMeta_description(String meta_description) {
		this.meta_description = meta_description;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	@Override
	public String toString() {
		return "Route [id=" + id + ", city1=" + city1 + ", city2=" + city2 + ", name=" + name + ", url=" + url
				+ ", displayName=" + displayName + ", status=" + status + ", projectId=" + projectId + ", siteId="
				+ siteId + ", shortDesc=" + shortDesc + ", description=" + description + ", sortingOrder="
				+ sortingOrder + ", body1=" + body1 + ", meta1=" + meta1 + ", footer1=" + footer1 + ", seoName="
				+ seoName + ", menu=" + menu + ", logo=" + logo + ", image=" + image + ", thumbnail=" + thumbnail
				+ ", meta_title=" + meta_title + ", meta_keyword=" + meta_keyword + ", meta_description="
				+ meta_description + ", h1tag=" + h1tag + ", tracking_link=" + tracking_link + "]";
	}	
}