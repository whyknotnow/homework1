package com.springbootdeneme.demo.operation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springbootdeneme.demo.http.IPostClient;
import com.springbootdeneme.demo.model.GetTransactionRequestModel;
import com.springbootdeneme.demo.model.GetTransactionResponseModel;
import com.springbootdeneme.demo.model.LoginResponseModel;
import com.springbootdeneme.demo.operation.IGetTransactionOperation;
import com.springbootdeneme.demo.operation.ILoginOperation;

@Component(value = "operation.gettransaction")
public class GetTransactionOperation implements IGetTransactionOperation {

	private static final String action = "/transaction";

	@Autowired
	@Qualifier("http.postclient")
	private IPostClient client;

	@Autowired
	@Qualifier("operation.login")
	private ILoginOperation loginOperation;

	@Override
	public GetTransactionResponseModel getTransactionDetails(String transactionId) {

		LoginResponseModel loginResponse = loginOperation.doLogin("demo@bumin.com.tr", "cjaiU8CV");

		GetTransactionRequestModel request = new GetTransactionRequestModel();

		request.setTransactionId(transactionId);
		request.setToken(loginResponse.getToken());

		GetTransactionResponseModel transactionResp = client.postJson(request, action,
				GetTransactionResponseModel.class);

		return transactionResp;
	}

}
