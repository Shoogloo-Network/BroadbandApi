package com.bb.controller.helper;

public class CityDetail {

	private Long id;
	private String name;
	String entityName;
	String url;
	String entityId;
	
	private String description;
	private String displayName;
	private String status;
	private String group;
	Long projectId;
	Long siteId;
	Integer sortOrder;
	String title;
	String sortDesc;
	String image1;
	String desc;
	String longdesc;
	String metatitle;
	String metaKeyword;
	String metadescription;
	Integer sortingOrder;

	String meta1;
	String body1;
	String footer1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSortDesc() {
		return sortDesc;
	}

	public void setSortDesc(String sortDesc) {
		this.sortDesc = sortDesc;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLongdesc() {
		return longdesc;
	}

	public void setLongdesc(String longdesc) {
		this.longdesc = longdesc;
	}

	public String getMetatitle() {
		return metatitle;
	}

	public void setMetatitle(String metatitle) {
		this.metatitle = metatitle;
	}

	public String getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

	public String getMetadescription() {
		return metadescription;
	}

	public void setMetadescription(String metadescription) {
		this.metadescription = metadescription;
	}

	public Integer getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
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

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	@Override
	public String toString() {
		return "PageDetail [id=" + id + ", name=" + name + ", url=" + url + ", description=" + description
				+ ", displayName=" + displayName + ", status=" + status + ", group=" + group + ", projectId="
				+ projectId + ", siteId=" + siteId + ", sortOrder=" + sortOrder + ", title=" + title + ", sortDesc="
				+ sortDesc + ", image1=" + image1 + ", desc=" + desc + ", longdesc=" + longdesc + ", metatitle="
				+ metatitle + ", metaKeyword=" + metaKeyword + ", metadescription=" + metadescription
				+ ", sortingOrder=" + sortingOrder + ", meta1=" + meta1 + ", body1=" + body1 + ", footer1=" + footer1
				+ "]";
	}

}
