package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="m_city")

public class MCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long  countryId;
	private Long  stateId;
	private String name;
	private String url;
	
	private String 	displayName;
	private String  status;
	Long		  projectId;
	Long siteId;
	private String  shortDesc;
	private String  languageId;
	private String  logo;
	private String  image;
	private String  description;

	private String  meta_title;
	private String  meta_keyword;
	private String  meta_description;
	private Integer  sortingOrder;
	private String  body1;
	private String  meta1;
	private String  footer1;
	private String seoName;
	private String h1tag;
	private String tracking_link;
	Integer menu;
	String field1;
	String field2;
	String field3;
	@Transient 
	String Country;
	Integer isfeatured;
	
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
	public String getH1tag() {
		return h1tag;
	}
	public void setH1tag(String h1tag) {
		this.h1tag = h1tag;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLanguageId() {
		return languageId;
	}
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	@Override
	public String toString() {
		return "MCity [id=" + id + ", countryId=" + countryId + ", stateId=" + stateId + ", name=" + name + ", url="
				+ url + ", displayName=" + displayName + ", status=" + status + ", projectId=" + projectId + ", siteId="
				+ siteId + ", shortDesc=" + shortDesc + ", languageId=" + languageId + ", logo=" + logo + ", image="
				+ image + ", description=" + description + ", meta_title=" + meta_title + ", meta_keyword="
				+ meta_keyword + ", meta_description=" + meta_description + ", sortingOrder=" + sortingOrder
				+ ", body1=" + body1 + ", meta1=" + meta1 + ", footer1=" + footer1 + ", seoName=" + seoName + ", h1tag="
				+ h1tag + ", tracking_link=" + tracking_link + ", menu=" + menu + ", Country=" + Country + "]";
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	public Integer getIsfeatured() {
		return isfeatured;
	}
	public void setIsfeatured(Integer isfeatured) {
		this.isfeatured = isfeatured;
	}
	



}