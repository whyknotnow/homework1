package com.springbootdeneme.demo.model;

import java.math.BigDecimal;

public class MerchantModel {
	private BigDecimal originalAmount;

	private String originalCurrency;

	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}

	public String getOriginalCurrency() {
		return originalCurrency;
	}

	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
	}
}
