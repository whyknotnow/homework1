package com.springbootdeneme.demo.model;

public class CacheTokenModel {
	private String token;
	private long putTimestamp;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getPutTimestamp() {
		return putTimestamp;
	}

	public void setPutTimestamp(long putTimestamp) {
		this.putTimestamp = putTimestamp;
	}

}
