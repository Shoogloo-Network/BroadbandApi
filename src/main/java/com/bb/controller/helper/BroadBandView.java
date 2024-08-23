package com.bb.controller.helper;

import java.util.List;
import java.util.Map;

import com.bb.primary.model.Broadband;
import com.bb.primary.model.MCity;
import com.bb.primary.model.Provider;

public class BroadBandView {
	
	Broadband broadBand;
	Provider provider;
	List<BroadBandAttr> broadbandAttributeMaster;
	List<Map<String, Object>> broadbandAttribute;
	Integer countOTT;
	
	public Broadband getBroadBand() {
		return broadBand;
	}
	public void setBroadBand(Broadband broadBand) {
		this.broadBand = broadBand;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	
	public List<BroadBandAttr> getBroadbandAttributeMaster() {
		return broadbandAttributeMaster;
	}
	public void setBroadbandAttributeMaster(List<BroadBandAttr> broadbandAttributeMaster) {
		this.broadbandAttributeMaster = broadbandAttributeMaster;
	}
	@Override
	public String toString() {
		return "BroadBandView [broadBand=" + broadBand + ", provider=" + provider + ", broadbandAttributeMaster="
				+ broadbandAttributeMaster + "]";
	}
	public List<Map<String, Object>> getBroadbandAttribute() {
		return broadbandAttribute;
	}
	public void setBroadbandAttribute(List<Map<String, Object>> broadbandAttribute) {
		this.broadbandAttribute = broadbandAttribute;
	}
	public Integer getCountOTT() {
		return countOTT;
	}
	public void setCountOTT(Integer countOTT) {
		this.countOTT = countOTT;
	}
	
	
	
}
