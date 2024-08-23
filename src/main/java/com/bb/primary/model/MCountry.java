	package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="m_country")
@NamedQuery(name="MCountry.findAll", query="SELECT m FROM MCountry m")
public class MCountry implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;

	private String currency;
	private String isdCode;
	private String logo;
	private String name;
	private String image;
	private String shortName;
	private String symbol;
	private Integer siteId;
	private Integer projectId;
	
	private String meta_title;

	private String meta_keyword;
	private String description;
	private Integer menu;
	String seoName;

	private Long  stateId;
	
	private String url;
	
	private String 	displayName;
	private String  status;
	

	private String  shortDesc;
	private String  languageId;



	private String  meta_description;
	private Integer  sortingOrder;
	private String  body1;
	private String  meta1;
	private String  footer1;
	private String h1tag;
	private String tracking_link;
	String field1;
	String field2;
	String field3;
	
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getIsdCode() {
		return isdCode;
	}
	public void setIsdCode(String isdCode) {
		this.isdCode = isdCode;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getMenu() {
		return menu;
	}
	public void setMenu(Integer menu) {
		this.menu = menu;
	}
	public String getSeoName() {
		return seoName;
	}
	public void setSeoName(String seoName) {
		this.seoName = seoName;
	}
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
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
	@Override
	public String toString() {
		return "MCountry [id=" + id + ", currency=" + currency + ", isdCode=" + isdCode + ", logo=" + logo + ", name="
				+ name + ", image=" + image + ", shortName=" + shortName + ", symbol=" + symbol + ", siteId=" + siteId
				+ ", projectId=" + projectId + ", meta_title=" + meta_title + ", meta_keyword=" + meta_keyword
				+ ", description=" + description + ", menu=" + menu + ", seoName=" + seoName + ", stateId=" + stateId
				+ ", url=" + url + ", displayName=" + displayName + ", status=" + status + ", shortDesc=" + shortDesc
				+ ", languageId=" + languageId + ", meta_description=" + meta_description + ", sortingOrder="
				+ sortingOrder + ", body1=" + body1 + ", meta1=" + meta1 + ", footer1=" + footer1 + ", h1tag=" + h1tag
				+ ", tracking_link=" + tracking_link + "]";
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
	
	
	

	
}