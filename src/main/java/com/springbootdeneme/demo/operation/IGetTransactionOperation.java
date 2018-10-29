package com.springbootdeneme.demo.operation;

import com.springbootdeneme.demo.model.GetTransactionResponseModel;

public interface IGetTransactionOperation {
	GetTransactionResponseModel getTransactionDetails(String transactionId);
}
