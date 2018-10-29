package com.springbootdeneme.demo.model;

public class GetClientRequestModel extends BaseRequestModel {

	private static final long serialVersionUID = -7516882942119681805L;

	private String transactionId;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
