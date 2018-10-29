package com.springbootdeneme.demo.operation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.springbootdeneme.demo.http.IPostClient;
import com.springbootdeneme.demo.model.LoginRequestModel;
import com.springbootdeneme.demo.model.LoginResponseModel;
import com.springbootdeneme.demo.operation.ILoginOperation;

@Component(value = "operation.login")
public class LoginOperation implements ILoginOperation {

	@Autowired
	@Qualifier("http.postclient")
	private IPostClient client;

	private static final String action = "/merchant/user/login";

	@Cacheable(value = "loginRespCache")
	public LoginResponseModel doLogin(String email, String password) {

		LoginRequestModel loginReqModel = new LoginRequestModel();
		loginReqModel.setEmail(email);
		loginReqModel.setPassword(password);

		LoginResponseModel resp = client.postJson(loginReqModel, action, LoginResponseModel.class);

		return resp;
	}

}
