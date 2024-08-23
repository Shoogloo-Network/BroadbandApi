package com.bb.controller.helper;

import java.io.Serializable;
import java.util.List;

import com.bb.primary.model.BroadbandAttributeValue;

public class BroadbandAttributeValueMap implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long broadBandArributeId;
	
	List<BroadbandAttributeValue> arttibuteList;

	public Long getBroadBandArributeId() {
		return broadBandArributeId;
	}

	public void setBroadBandArributeId(Long broadBandArributeId) {
		this.broadBandArributeId = broadBandArributeId;
	}

	public List<BroadbandAttributeValue> getArttibuteList() {
		return arttibuteList;
	}

	public void setArttibuteList(List<BroadbandAttributeValue> arttibuteList) {
		this.arttibuteList = arttibuteList;
	}

	

	
}