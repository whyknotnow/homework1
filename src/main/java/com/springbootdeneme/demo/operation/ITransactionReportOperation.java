package com.springbootdeneme.demo.operation;

import java.time.LocalDate;

import com.springbootdeneme.demo.model.TransactionReportResponseModel;

public interface ITransactionReportOperation {
	TransactionReportResponseModel getTransactionReport(LocalDate fromDate, LocalDate toDate, int merchantId,
			int acquirerId);
}
