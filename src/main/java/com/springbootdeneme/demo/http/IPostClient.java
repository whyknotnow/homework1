package com.springbootdeneme.demo.http;

import com.springbootdeneme.demo.model.BaseRequestModel;

public interface IPostClient {
	<T> T postJson(BaseRequestModel requestModel, String action, Class<T> respClass);
}
