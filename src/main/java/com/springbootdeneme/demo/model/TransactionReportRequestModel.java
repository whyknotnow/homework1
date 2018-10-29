package com.springbootdeneme.demo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionReportRequestModel extends BaseRequestModel {

	private static final long serialVersionUID = 7041011536547937397L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fromDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate toDate;

	@JsonProperty("merchant")
	private int merchantId;

	@JsonProperty("acquirer")
	private int acquirerId;

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public int getAcquirerId() {
		return acquirerId;
	}

	public void setAcquirerId(int acquirerId) {
		this.acquirerId = acquirerId;
	}

}
