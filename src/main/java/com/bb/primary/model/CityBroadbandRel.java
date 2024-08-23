
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
@Table(name="city_broadband_rel")
@NamedNativeQuery(name="CityBroadbandRel.findByCityIdQuery", query="select a.id,a.cityId,a.broadbandId,"
		+ "b.countryId,b.name cityName,b.stateId,c.name  providerName, c.shortName providershortName,"
		+ "c.description,c.image from city_broadband_rel a , m_city b,broadband c where a.cityId=b.id "
		+ " and a.broadbandId=c.id and cityId=?1")
@NamedNativeQuery(name="CityBroadbandRel.findByBroadbandIdQuery", query="select a.id,a.cityId,a.broadbandId,b.countryId,b.name"
		+ " cityName,b.stateId,c.name  providerName, c.shortName providershortName,c.description,c.image from"
		+ " city_broadband_rel a , m_city b,broadband c where a.cityId=b.id  and a.broadbandId=c.id and providerId=?1 ")
@NamedNativeQuery(name="CityBroadbandRel.findByCitySeoNameQuery", query="   select id from broadband where providerId in(select a.providerId from city_broadband_rel a , m_city b where a.cityId=b.id \r\n"
		+ "		 and b.seoName=?1 and siteId=?2) ")

@NamedNativeQuery(name="CityBroadbandRel.findBroadbandByCityIdQuery", query="SELECT a.id,  b.* FROM city_broadband_rel a, broadband b where a.cityId=?1 and a.broadbandId=b.id")

@NamedNativeQuery(name="CityBroadbandRel.findCityBroadbandPlans", query=" select a.id, a.cityId, a.broadbandId, b.name cityName, c.name, "
		+ " c.description , c.status from city_broadband_rel a, m_city b, broadband c where a.cityId=b.id "
		+ " and a.broadbandId=c.id and c.siteId=?1")


public class CityBroadbandRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long cityId;
	private Long broadbandId;
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
	
	public Long getBroadbandId() {
		return broadbandId;
	}
	public void setBroadbandId(Long broadbandId) {
		this.broadbandId = broadbandId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CityProviderRel [id=" + id + ", cityId=" + cityId + ", broadband=" + broadbandId + ", status=" + status
				+ "]";
	}



}