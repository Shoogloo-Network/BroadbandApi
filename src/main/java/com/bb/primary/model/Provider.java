package com.bb.primary.model;

import java.io.Serializable;

import com.bb.util.Utility;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "prod_provider")
public class Provider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer projectId;
	private String name;
	private String shortName;
	private String logo;
	private String image;
	private String link;
	private Integer siteId;
	private String description;
	private Integer status;
	private Integer sortingOrder;
	String meta_description;
	String meta_title;
	String meta_keyword;
	Double rating;
	Integer categoryId=1;
	String seoName;
	int menu;
	String field1;
	String field2;
	String field3;
	String provider_top_banner_txt;
	String provider_top_banner_plans;
	String provider_top_banner_color;
	private String h1tag;
	private String faq;
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

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	
	@Override
	public String toString() {
		return "Provider [id=" + id + ", projectId=" + projectId + ", name=" + name + ", shortName=" + shortName
				+ ", logo=" + logo + ", image=" + image + ", link=" + link + ", siteId=" + siteId + ", description="
				+ description + ", status=" + status + ", sortingOrder=" + sortingOrder + ", meta_description="
				+ meta_description + ", meta_title=" + meta_title + ", meta_keyword=" + meta_keyword + ", rating="
				+ rating + ", categoryId=" + categoryId + ", seoName=" + seoName + ", menu=" + menu + ", field1="
				+ field1 + ", field2=" + field2 + ", field3=" + field3 + ", provider_top_banner_txt="
				+ provider_top_banner_txt + ", provider_top_banner_plans=" + provider_top_banner_plans
				+ ", provider_top_banner_color=" + provider_top_banner_color + ", h1tag=" + h1tag + ", faq=" + faq
				+ ", tracking_link=" + tracking_link + "]";
	}

	public String getMeta_description() {
		return meta_description;
	}

	public void setMeta_description(String meta_description) {
		this.meta_description = meta_description;
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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}



	public String getProvider_top_banner_txt() {
		return provider_top_banner_txt;
	}

	public void setProvider_top_banner_txt(String provider_top_banner_txt) {
		this.provider_top_banner_txt = provider_top_banner_txt;
	}

	public String getProvider_top_banner_plans() {
		return provider_top_banner_plans;
	}

	public void setProvider_top_banner_plans(String provider_top_banner_plans) {
		this.provider_top_banner_plans = provider_top_banner_plans;
	}

	public String getSeoName() {
		if(seoName==null||seoName.equals(""))
		return Utility.getSeoName(name);
		else
			return seoName;
	}

	public void setSeoName(String seoName) {
		this.seoName = seoName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public int getMenu() {
		return menu;
	}

	public void setMenu(int menu) {
		this.menu = menu;
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

	public String getProvider_top_banner_color() {
		return provider_top_banner_color;
	}

	public void setProvider_top_banner_color(String provider_top_banner_color) {
		this.provider_top_banner_color = provider_top_banner_color;
	}

	public String getFaq() {
		return faq;
	}

	public void setFaq(String faq) {
		this.faq = faq;
	}
	

}