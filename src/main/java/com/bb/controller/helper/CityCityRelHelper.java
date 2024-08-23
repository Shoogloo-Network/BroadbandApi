package com.bb.controller.helper;

import java.io.Serializable;



public class CityCityRelHelper implements Serializable {


	private Long id;
	private Long sourceCityId;
	private Long destiCityId;
	String soruceCity;
	String destiCity;
	Integer sortingOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSourceCityId() {
		return sourceCityId;
	}

	public void setSourceCityId(Long sourceCityId) {
		this.sourceCityId = sourceCityId;
	}

	public Long getDestiCityId() {
		return destiCityId;
	}

	public void setDestiCityId(Long destiCityId) {
		this.destiCityId = destiCityId;
	}

	public String getSoruceCity() {
		return soruceCity;
	}

	public void setSoruceCity(String soruceCity) {
		this.soruceCity = soruceCity;
	}

	public String getDestiCity() {
		return destiCity;
	}

	public void setDestiCity(String destiCity) {
		this.destiCity = destiCity;
	}

	public Integer getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	

}