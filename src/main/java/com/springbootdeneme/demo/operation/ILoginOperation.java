package com.springbootdeneme.demo.operation;

import com.springbootdeneme.demo.model.LoginResponseModel;

public interface ILoginOperation {
	LoginResponseModel doLogin(String email, String password);
}
