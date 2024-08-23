package com.bb.controller.helper;

public class Response {
	String message;
	Object payload;
	Object wizard;
	int statusCode = 200;
	String cmsAccessToken;

	public String getCmsAccessToken() {
		return cmsAccessToken;
	}

	public void setCmsAccessToken(String cmsAccessToken) {
		this.cmsAccessToken = cmsAccessToken;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getWizard() {
		return wizard;
	}

	public void setWizard(Object wizard) {
		this.wizard = wizard;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + ", payload=" + payload + ", wizard=" + wizard + ", statusCode="
				+ statusCode + "]";
	}

}
