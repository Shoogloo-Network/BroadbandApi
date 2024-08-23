package com.bb.controller.helper;

import java.util.List;

public class MenuHelper {
Long id;
 String name;
 String url;
 String displayName;
 Integer status;
 String groupName;
Long projectId;
Long siteId;
Integer sortOrder;
List<MenuHelper> child;
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
public String getDisplayName() {
	return displayName;
}
public void setDisplayName(String displayName) {
	this.displayName = displayName;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
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
public List<MenuHelper> getChild() {
	return child;
}
public void setChild(List<MenuHelper> child) {
	this.child = child;
}
@Override
public String toString() {
	return "MenuHelper [id=" + id + ", name=" + name + ", url=" + url + ", displayName=" + displayName + ", status="
			+ status + ", groupName=" + groupName + ", projectId=" + projectId + ", siteId=" + siteId + ", sortOrder="
			+ sortOrder + ", child=" + child + "]";
}


}
