package com.globaldata;

public class GlobalDatas {

	private String logtoken;
	private int statusCode;
	private int cityId;
	private int stateId;
	private String stateIdText;
	private String addressId;
	
	public String getAddressId() {
		return addressId;
	}
	
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getStateIdText() {
		return stateIdText;
	}

	public void setStateIdText(String stateIdText) {
		this.stateIdText = stateIdText;
	}

	public String getLogtoken() {
		return logtoken;
	}

	public void setLogtoken(String logtoken) {
		this.logtoken = logtoken;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

}
