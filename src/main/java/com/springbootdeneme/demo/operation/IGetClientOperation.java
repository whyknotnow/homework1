package com.springbootdeneme.demo.operation;

import com.springbootdeneme.demo.model.GetClientResponseModel;

public interface IGetClientOperation {
	GetClientResponseModel getClient(String clientId);
}
