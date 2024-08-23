package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="broadBandArttibuteRel")
@NamedNativeQuery(name="BroadBandArttibuteRel.findByBroadbandId", query="SELECT a.id,a.broadBandId,a.position,b.id BroadBandAttributeId,"
		+ "b.name,b.colorCode,b.imageUrl,b.toolTip,b.type,a.sortingOrder FROM broadBandArttibuteRel a,broadBandAttributeMaster "
		+ "b where a.BrodoadBandAttributeId=b.id and  broadBandId=?1")
@NamedNativeQuery(name="BroadBandArttibuteRel.findByBroadbandIds", query="SELECT a.id,a.broadBandId,a.position,"
		+ "b.id BroadBandAttributeId,b.name,b.colorCode,b.imageUrl,b.toolTip,b.type,a.sortingOrder "
		+ "FROM broadBandArttibuteRel a,broadBandAttributeMaster b where a.BrodoadBandAttributeId=b.id and  broadBandId in(?1)")

public class BroadBandArttibuteRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long broadBandId;
	private Long BrodoadBandAttributeId;
	private Long projectId;

	private String 	position;
	private Integer  status;
	private Integer  siteId;
	private Integer sortingOrder;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	@Override
	public String toString() {
		return "BoradBandArttibuteRel [id=" + id + ", broadBandId=" + broadBandId + ", BrodoadBandAttributeId="
				+ BrodoadBandAttributeId + ", projectId=" + projectId + ", position=" + position + ", status=" + status
				+ ", siteId=" + siteId + "]";
	}
	public Integer getSortingOrder() {
		return sortingOrder;
	}
	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}
	public Long getBroadBandId() {
		return broadBandId;
	}
	public void setBroadBandbandId(Long broadBandId) {
		this.broadBandId = broadBandId;
	}
	public Long getBrodoadBandAttributeId() {
		return BrodoadBandAttributeId;
	}
	public void setBrodoadBandAttributeId(Long brodoadBandAttributeId) {
		BrodoadBandAttributeId = brodoadBandAttributeId;
	}

	
	
}