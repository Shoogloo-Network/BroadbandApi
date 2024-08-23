package com.bb.primary.model;

import java.io.Serializable;
import java.util.Date;

import com.bb.util.Utility;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQuery(name = "Broadband.findAll", query = "SELECT b FROM Broadband b")

@Table(name = "broadband")
public class Broadband implements Serializable {
	private static final long serialVersionUID = 1L;

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
	String seoName;
	String description;

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

	@Override
	public String toString() {
		return "Broadband [id=" + id + ", projectId=" + projectId + ", providerId=" + providerId + ", siteId=" + siteId
				+ ", name=" + name + ", currency=" + currency + ", cost=" + cost + ", costDurationScale="
				+ costDurationScale + ", speed=" + speed + ", speedScale=" + speedScale + ", bandwidth=" + bandwidth
				+ ", bandwidthSpeedScale=" + bandwidthSpeedScale + ", bandwidthDurationScale=" + bandwidthDurationScale
				+ ", contractLength=" + contractLength + ", contractLengthDuration=" + contractLengthDuration
				+ ", dealUrl=" + dealUrl + ", meta_title=" + meta_title + ", meta_keyword=" + meta_keyword + ", status="
				+ status + ", sortingOrder=" + sortingOrder + ", imageUrl=" + imageUrl + ", link=" + link
				+ ", meta_description=" + meta_description + ", planExpiry=" + planExpiry + ", rating=" + rating
				+ ", basePrice=" + basePrice + ", setupCost=" + setupCost + ", installation=" + installation
				+ ", taxes=" + taxes + ", others=" + others + ", sponsored=" + sponsored + ", seoName=" + seoName
				+ ", description=" + description + "]";
	}

	public String getSeoName() {
		if(seoName==null|| seoName.equals(""))
		try {
			return Utility.getSeoName(name);
		} catch (Exception e) {
		}
		return seoName;
	}

	public void setSeoName(String seoName) {
		this.seoName = seoName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}