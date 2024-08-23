package com.bb.controller.helper;

import java.io.Serializable;
import java.util.List;

import com.bb.primary.model.BroadBandArttibuteRel;

public class BroadbandAttributeMap implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long boradBandId;
	private Integer siteId;
	private Long projectId;

	List<BroadBandArttibuteRel> arttibuteList;

	public Long getBoradBandId() {
		return boradBandId;
	}

	public void setBoradBandId(Long boradBandId) {
		this.boradBandId = boradBandId;
	}

	public List<BroadBandArttibuteRel> getArttibuteList() {
		return arttibuteList;
	}

	public void setArttibuteList(List<BroadBandArttibuteRel> arttibuteList) {
		this.arttibuteList = arttibuteList;
	}

	@Override
	public String toString() {
		return "BroadbandAttributeMap [boradBandId=" + boradBandId + ", arttibuteList=" + arttibuteList + "]";
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

}