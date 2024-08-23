package com.bb.controller.helper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BroadBandViewNew {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer projectId;
	private Long providerId;
	private Integer siteId;
	private String name;
	private String currency;
	private Double cost;
	private String costDurationScale;
	private Integer speed;
	private String speedScale;
	Integer bandwidth;
	String bandwidthSpeedScale;
	String bandwidthDurationScale;
	Integer contractLength;
	String contractLengthDuration;
	String dealUrl;
	String meta_title;
	String meta_keyword;
	String status;
	Integer sortingOrder;
	String imageUrl;
	String link;
	String meta_description;
	Date planExpiry;
	Double rating;
	Double basePrice;
	Double setupCost;
	Double installation;
	Double taxes;
	Double others;
	String sponsored;
	String providerImage;
	String providerLogo;
	String providerName;
	String providerLink;
	
	List<BroadBandAttr> broadbandAttributeMaster;
	List<Map<String, Object>> broadbandAttribute;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Long getProviderId() {
		return providerId;
	}
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getCostDurationScale() {
		return costDurationScale;
	}
	public void setCostDurationScale(String costDurationScale) {
		this.costDurationScale = costDurationScale;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public String getSpeedScale() {
		return speedScale;
	}
	public void setSpeedScale(String speedScale) {
		this.speedScale = speedScale;
	}
	public Integer getBandwidth() {
		return bandwidth;
	}
	public void setBandwidth(Integer bandwidth) {
		this.bandwidth = bandwidth;
	}
	public String getBandwidthSpeedScale() {
		return bandwidthSpeedScale;
	}
	public void setBandwidthSpeedScale(String bandwidthSpeedScale) {
		this.bandwidthSpeedScale = bandwidthSpeedScale;
	}
	public String getBandwidthDurationScale() {
		return bandwidthDurationScale;
	}
	public void setBandwidthDurationScale(String bandwidthDurationScale) {
		this.bandwidthDurationScale = bandwidthDurationScale;
	}
	public Integer getContractLength() {
		return contractLength;
	}
	public void setContractLength(Integer contractLength) {
		this.contractLength = contractLength;
	}
	public String getContractLengthDuration() {
		return contractLengthDuration;
	}
	public void setContractLengthDuration(String contractLengthDuration) {
		this.contractLengthDuration = contractLengthDuration;
	}
	public String getDealUrl() {
		return dealUrl;
	}
	public void setDealUrl(String dealUrl) {
		this.dealUrl = dealUrl;
	}
	public String getMeta_title() {
		return meta_title;
	}
	public void setMeta_title(String meta_title) {
		this.meta_title = meta_title;
	}
	public String getMeta_keyword() {
		return meta_keyword;
	}
	public void setMeta_keyword(String meta_keyword) {
		this.meta_keyword = meta_keyword;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getSortingOrder() {
		return sortingOrder;
	}
	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getMeta_description() {
		return meta_description;
	}
	public void setMeta_description(String meta_description) {
		this.meta_description = meta_description;
	}
	public Date getPlanExpiry() {
		return planExpiry;
	}
	public void setPlanExpiry(Date planExpiry) {
		this.planExpiry = planExpiry;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}
	public Double getSetupCost() {
		return setupCost;
	}
	public void setSetupCost(Double setupCost) {
		this.setupCost = setupCost;
	}
	public Double getInstallation() {
		return installation;
	}
	public void setInstallation(Double installation) {
		this.installation = installation;
	}
	public Double getTaxes() {
		return taxes;
	}
	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}
	public Double getOthers() {
		return others;
	}
	public void setOthers(Double others) {
		this.others = others;
	}
	public String getSponsored() {
		return sponsored;
	}
	public void setSponsored(String sponsored) {
		this.sponsored = sponsored;
	}
	public String getProviderImage() {
		return providerImage;
	}
	public void setProviderImage(String providerImage) {
		this.providerImage = providerImage;
	}
	public String getProviderLogo() {
		return providerLogo;
	}
	public void setProviderLogo(String providerLogo) {
		this.providerLogo = providerLogo;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderLink() {
		return providerLink;
	}
	public void setProviderLink(String providerLink) {
		this.providerLink = providerLink;
	}
	public List<BroadBandAttr> getBroadbandAttributeMaster() {
		return broadbandAttributeMaster;
	}
	public void setBroadbandAttributeMaster(List<BroadBandAttr> broadbandAttributeMaster) {
		this.broadbandAttributeMaster = broadbandAttributeMaster;
	}
	public List<Map<String, Object>> getBroadbandAttribute() {
		return broadbandAttribute;
	}
	public void setBroadbandAttribute(List<Map<String, Object>> broadbandAttribute) {
		this.broadbandAttribute = broadbandAttribute;
	}
	
}
