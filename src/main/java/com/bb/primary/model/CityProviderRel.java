package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the m_domain database table.
 * 
 */
@Entity
@Table(name="city_provider_rel")
@NamedNativeQuery(name="CityProviderRel.findByCityIdQuery", query="select a.id,a.cityId,a.providerId,"
		+ "b.countryId,b.name cityName,b.stateId,c.name  providerName, c.shortName providershortName,"
		+ "c.description,c.image from city_provider_rel a , m_city b,prod_provider c where a.cityId=b.id "
		+ " and a.providerId=c.id and cityId=?1")
@NamedNativeQuery(name="CityProviderRel.findByProviderIdQuery", query="select a.id,a.cityId,a.providerId,b.countryId,b.name"
		+ " cityName,b.stateId,c.name  providerName, c.shortName providershortName,c.description,c.image from"
		+ " city_provider_rel a , m_city b,prod_provider c where a.cityId=b.id  and a.providerId=c.id and providerId=?1 ")
@NamedNativeQuery(name="CityProviderRel.findByCitySeoNameQuery", query="   select id from broadband where providerId "
		+ "in(select a.providerId from city_provider_rel a "
		+ ", m_city b where a.cityId=b.id "
		+ "		 and b.seoName=?1 and siteId=?2) ")

public class CityProviderRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long cityId;
	private Long providerId;
	Integer status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public Long getProviderId() {
		return providerId;
	}
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CityProviderRel [id=" + id + ", cityId=" + cityId + ", providerId=" + providerId + ", status=" + status
				+ "]";
	}



}