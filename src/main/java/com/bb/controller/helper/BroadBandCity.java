package com.bb.controller.helper;

import java.util.List;
import java.util.Map;

import com.bb.primary.model.Broadband;
import com.bb.primary.model.MCity;
import com.bb.primary.model.Provider;

public class BroadBandCity {
	
	List<BroadBandView> broadBandList;
	MCity city;
	public List<BroadBandView> getBroadBandList() {
		return broadBandList;
	}
	public void setBroadBandList(List<BroadBandView> broadBandList) {
		this.broadBandList = broadBandList;
	}
	public MCity getCity() {
		return city;
	}
	public void setCity(MCity city) {
		this.city = city;
	}
	
	
}
