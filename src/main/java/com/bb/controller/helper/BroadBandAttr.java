package com.bb.controller.helper;

public class BroadBandAttr {
	Long id;
	Long broadBandbandId;
	String position;
	Long mId;
	String name;
	String colorCode;
	String imageUrl;
	String toolTip;
	String type;
	Integer sortingOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBroadBandbandId() {
		return broadBandbandId;
	}

	public void setBroadBandbandId(Long broadBandbandId) {
		this.broadBandbandId = broadBandbandId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getmId() {
		return mId;
	}

	public void setmId(Long mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getToolTip() {
		return toolTip;
	}

	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	@Override
	public String toString() {
		return "BroadBandAttr [id=" + id + ", boradBandbandId=" + broadBandbandId + ", position=" + position + ", mId="
				+ mId + ", name=" + name + ", colorCode=" + colorCode + ", imageUrl=" + imageUrl + ", toolTip="
				+ toolTip + ", type=" + type + ", sortingOrder=" + sortingOrder + "]";
	}

}
