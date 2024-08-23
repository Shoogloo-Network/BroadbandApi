package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "city_city_rel")
@NamedNativeQuery(name = "CityCityRel.findByCityIdQuery", query = "select a.id, a.sourceCityId, a.destiCityId,"
		+ " b.name soruceCity ,c.name destiCity,a.sortingOrder from city_city_rel a,m_city b,m_city c where a.sourceCityId=b.id"
		+ " and a.destiCityId=c.id and sourceCityId=?1")

@NamedNativeQuery(name = "CityCityRel.findByCityName", query = "select a.id, a.sourceCityId, a.destiCityId,"
		+ " b.name soruceCity, c.name destiCity, a.sortingOrder from city_city_rel a, m_city b, m_city c where a.sourceCityId=b.id"
		+ " and a.destiCityId=c.id and b.seoName=?1")

public class CityCityRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long sourceCityId;
	private Long destiCityId;

	private Integer sortingOrder;

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

	public Integer getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	@Override
	public String toString() {
		return "CityCityRel [id=" + id + ", sourceCityId=" + sourceCityId + ", destiCityId=" + destiCityId
				+ ", sortingOrder=" + sortingOrder + "]";
	}

}