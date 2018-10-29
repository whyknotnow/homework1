package com.springbootdeneme.demo.operation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springbootdeneme.demo.http.IPostClient;
import com.springbootdeneme.demo.model.GetClientRequestModel;
import com.springbootdeneme.demo.model.GetClientResponseModel;
import com.springbootdeneme.demo.model.LoginResponseModel;
import com.springbootdeneme.demo.operation.IGetClientOperation;
import com.springbootdeneme.demo.operation.ILoginOperation;

@Component(value = "operation.getclient")
public class GetClientOperation implements IGetClientOperation {

	private static final String action = "/client";

	@Autowired
	@Qualifier("http.postclient")
	private IPostClient client;

	@Autowired
	@Qualifier("operation.login")
	private ILoginOperation loginOperation;

	@Override
	public GetClientResponseModel getClient(String clientId) {

		LoginResponseModel loginResp = loginOperation.doLogin("demo@bumin.com.tr", "cjaiU8CV");

		GetClientRequestModel reqModel = new GetClientRequestModel();
		reqModel.setTransactionId(clientId);
		reqModel.setToken(loginResp.getToken());

		GetClientResponseModel response = client.postJson(reqModel, action, GetClientResponseModel.class);

		return response;

	}

}
