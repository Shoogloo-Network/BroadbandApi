package com.bb.controller.helper;

public class ProviderCity  {

	private Long id;
	Long cityId;
	Long providerId;
	Long counteryId;
	String cityName;
	Long stateId;
	String providerName;
	String providershortName;
	String description;
	String image;
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
	public Long getCounteryId() {
		return counteryId;
	}
	public void setCounteryId(Long counteryId) {
		this.counteryId = counteryId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	public String getProvidershortName() {
		return providershortName;
	}
	public void setProvidershortName(String providershortName) {
		this.providershortName = providershortName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "ProviderCity [id=" + id + ", cityId=" + cityId + ", providerId=" + providerId + ", counteryId="
				+ counteryId + ", cityName=" + cityName + ", stateId=" + stateId + ", providerName=" + providerName
				+ ", provdershortName=" + providershortName + ", description=" + description + ", image=" + image + "]";
	}
	
	

}