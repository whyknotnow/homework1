package com.springbootdeneme.demo.operation.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springbootdeneme.demo.http.IPostClient;
import com.springbootdeneme.demo.model.LoginResponseModel;
import com.springbootdeneme.demo.model.TransactionReportRequestModel;
import com.springbootdeneme.demo.model.TransactionReportResponseModel;
import com.springbootdeneme.demo.operation.ILoginOperation;
import com.springbootdeneme.demo.operation.ITransactionReportOperation;

@Component(value = "operation.transactionreport")
public class TransactionReportOperation implements ITransactionReportOperation {

	private static final String action = "/transactions/report";

	@Autowired
	@Qualifier("http.postclient")
	private IPostClient client;

	@Autowired
	@Qualifier("operation.login")
	private ILoginOperation loginOperation;

	@Override
	public TransactionReportResponseModel getTransactionReport(LocalDate fromDate, LocalDate toDate, int merchantId,
			int acquirerId) {

		TransactionReportRequestModel requestModel = new TransactionReportRequestModel();

		requestModel.setFromDate(fromDate);
		requestModel.setToDate(toDate);
		requestModel.setAcquirerId(acquirerId);
		requestModel.setMerchantId(merchantId);

		LoginResponseModel loginRespModel = loginOperation.doLogin("demo@bumin.com.tr", "cjaiU8CV");

		requestModel.setToken(loginRespModel.getToken());

		TransactionReportResponseModel responseModel = client.postJson(requestModel, action,
				TransactionReportResponseModel.class);

		return responseModel;
	}

}
