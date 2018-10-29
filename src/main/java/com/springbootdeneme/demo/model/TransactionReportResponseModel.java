package com.springbootdeneme.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionReportResponseModel extends BaseResponseModel {

	@JsonProperty("response")
	private List<TransactionModel> transactionModelList;

	public List<TransactionModel> getTransactionModelList() {
		return transactionModelList;
	}

	public void setTransactionModelList(List<TransactionModel> transactionModelList) {
		this.transactionModelList = transactionModelList;
	}

}
