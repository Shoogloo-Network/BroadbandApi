package com.bb.controller.helper;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageLimit {
	int min;
	int max;
	int pageNo=1;
	int pageSize=10;
	String sortField;
	String sortOrder;
	Pageable pageable;
	public PageLimit()
	{}
	public PageLimit(int pageNo, int pageSize, String sortField) {
		this.pageNo=pageNo;
		this.pageSize=pageSize;
		this.sortField=sortField;
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

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	public Pageable createAndGetPageable() {
	/*	if (pageNo > 0) {
			min = (pageNo * pageSize)-pageSize;
			max = min + pageSize;
		}*/
		min=pageNo-1;
		max=pageSize;
		if(sortOrder==null)
			this.pageable = PageRequest.of(min, max);
		else if ( sortOrder.equals("desc"))
			this.pageable = PageRequest.of(min, max, Sort.by(sortField).descending());
		else if (sortOrder.equals("asce"))
			this.pageable = PageRequest.of(min, max, Sort.by(sortField).ascending());
		else
			this.pageable = PageRequest.of(min, max, Sort.by(sortField).descending());
		System.out.println("pageabled="+pageable);
		return pageable;
	}
	@Override
	public String toString() {
		return "PageLimit [min=" + min + ", max=" + max + ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", sortField=" + sortField + ", sortOrder=" + sortOrder + ", pageable=" + pageable + "]";
	}
	
}
