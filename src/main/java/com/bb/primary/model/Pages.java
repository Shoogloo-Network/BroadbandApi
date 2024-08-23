package com.bb.primary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="m_page")
//@NamedNativeQuery(name="Detail.findByPage", query="select a.*,b.* from m_page a, m_detail b where a.projectid=?1 and a.siteId=?2 and a.id=b.entityId and entityName='page' and b.status>?3 ")
//@NamedNativeQuery(name="Detail.city", query="select a.*,b.* from m_page a, m_detail b where a.projectid=?1 and a.siteId=?2 and a.id=b.entityId and entityName='city' and b.status>?3 ")
//@NamedNativeQuery(name="Detail.provider", query="select a.*,b.* from m_page a, m_detail b where a.projectid=?1 and a.siteId=?2 and a.id=b.entityId and entityName='provider' and b.status>?3 ")


public class Pages {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	Integer		  projectId;
	Long siteId;
	String name;
	String		  title;
	String		  shortDesc;
	String		  languageId;
	private String  description;

	Integer		  sortingOrder;
	Integer		  status;
	String		  meta1;
	String		  body1;
	String		  footer1;
	private String  logo;
	private String  image;
	

	private String  meta_title;
	private String  meta_keyword;
	private String  meta_description;
	
	private String seoName;
	private String h1tag;
	private String tracking_link;
	
	@Override
	public String toString() {
		return "Pages [id=" + id + ", projectId=" + projectId + ", siteId=" + siteId + ", name=" + name + ", title="
				+ title + ", shortDesc=" + shortDesc + ", languageId=" + languageId + ", description=" + description
				+ ", sortingOrder=" + sortingOrder + ", status=" + status + ", meta1=" + meta1 + ", body1=" + body1
				+ ", footer1=" + footer1 + ", logo=" + logo + ", image=" + image + ", meta_title=" + meta_title
				+ ", meta_keyword=" + meta_keyword + ", meta_description=" + meta_description + ", seoName=" + seoName
				+ ", h1tag=" + h1tag + ", tracking_link=" + tracking_link + "]";
	}
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
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectid) {
		this.projectId = projectid;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMeta1() {
		return meta1;
	}
	public void setMeta1(String meta1) {
		this.meta1 = meta1;
	}
	public String getBody1() {
		return body1;
	}
	public void setBody1(String body1) {
		this.body1 = body1;
	}
	public String getFooter1() {
		return footer1;
	}
	public void setFooter1(String footer1) {
		this.footer1 = footer1;
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
	public String getSeoName() {
		return seoName;
	}
	public void setSeoName(String seoName) {
		this.seoName = seoName;
	}
	
	
			

}
