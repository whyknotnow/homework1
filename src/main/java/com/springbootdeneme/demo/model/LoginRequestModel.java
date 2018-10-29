package com.springbootdeneme.demo.model;

public class LoginRequestModel extends BaseRequestModel {

	private static final long serialVersionUID = -3454597898809421430L;

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
