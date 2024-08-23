package com.bb.controller.helper;

public class SearchObject<T> {
T search;
PageLimit page=new PageLimit();
int min;
int max;
int pageNo;
int pageSize;
String sortOrder;
String sortField;
public T getSearch() {
	return search;
}
public void setSearch(T search) {
	this.search = search;
}
public PageLimit getPage() {
	if(page==null)
		this.page = new PageLimit();
	page.min=min;
	page.max=max;
	page.pageNo=pageNo;
	page.pageSize=pageSize;
	page.sortOrder=sortOrder;
	page.sortField=sortField;
	return page;
}
public void setPage(PageLimit page) {
	
	this.page = page;
}
public int getMin() {
	return min;
}
public void setMin(int min) {
	this.min = min;
}
public int getMax() {
	return max;
}
public void setMax(int max) {
	this.max = max;
}
public int getPageNo() {
	return pageNo;
}
public void setPageNo(int pageNo) {
	this.pageNo = pageNo;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public String getSortOrder() {
	return sortOrder;
}
public void setSortOrder(String sortOrder) {
	this.sortOrder = sortOrder;
}
public String getSortField() {
	return sortField;
}
public void setSortField(String sortField) {
	this.sortField = sortField;
}
@Override
public String toString() {
	return "SearchObject [search=" + search + ", page=" + page + ", min=" + min + ", max=" + max + ", pageNo=" + pageNo
			+ ", pageSize=" + pageSize + ", sortOrder=" + sortOrder + ", sortField=" + sortField + "]";
}


}
