package com.bb.controller.helper;

public class CityBroadbandRelHelper {
	
	 private Long id;
	 private Long cityId;
	 private long broadbandId;
	 private String cityName;
	 private String name;
	 private String description;
	 private int status;
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
	public long getBroadbandId() {
		return broadbandId;
	}
	public void setBroadbandId(long broadbandId) {
		this.broadbandId = broadbandId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
