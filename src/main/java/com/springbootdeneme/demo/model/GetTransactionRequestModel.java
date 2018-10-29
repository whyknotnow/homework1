package com.springbootdeneme.demo.model;

public class GetTransactionRequestModel extends BaseRequestModel {

	private static final long serialVersionUID = 608657971480397276L;

	private String transactionId;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
