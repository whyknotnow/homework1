package com.springbootdeneme.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetTransactionResponseModel extends BaseResponseModel {

	@JsonProperty("fx")
	private List<FxInfoModel> fxInfoList;

	@JsonProperty("CustomerInfo")
	private List<CustomerInfoModel> customerInfoList;

	@JsonProperty("acquirerTransactions")
	private List<AcquirerTransactionModel> acquirerTransactionsList;

	@JsonProperty("merchant")
	private List<MerchantModel> merchantList;

	@JsonProperty("merchantTransactions")
	private List<MerchantTransactionModel> merchantTransactionList;

	public List<FxInfoModel> getFxInfoList() {
		return fxInfoList;
	}

	public void setFxInfoList(List<FxInfoModel> fxInfoList) {
		this.fxInfoList = fxInfoList;
	}

	public List<CustomerInfoModel> getCustomerInfoList() {
		return customerInfoList;
	}

	public void setCustomerInfoList(List<CustomerInfoModel> customerInfoList) {
		this.customerInfoList = customerInfoList;
	}

	public List<AcquirerTransactionModel> getAcquirerTransactionsList() {
		return acquirerTransactionsList;
	}

	public void setAcquirerTransactionsList(List<AcquirerTransactionModel> acquirerTransactionsList) {
		this.acquirerTransactionsList = acquirerTransactionsList;
	}

	public List<MerchantModel> getMerchantList() {
		return merchantList;
	}

	public void setMerchantList(List<MerchantModel> merchantList) {
		this.merchantList = merchantList;
	}

	public List<MerchantTransactionModel> getMerchantTransactionList() {
		return merchantTransactionList;
	}

	public void setMerchantTransactionList(List<MerchantTransactionModel> merchantTransactionList) {
		this.merchantTransactionList = merchantTransactionList;
	}

}
