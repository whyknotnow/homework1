package com.springbootdeneme.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseRequestModel implements Serializable {

	private static final long serialVersionUID = -3007534450899249613L;

	@JsonIgnore
	private transient String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
