package com.springbootdeneme.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.springbootdeneme.demo.model.GetClientResponseModel;
import com.springbootdeneme.demo.model.GetTransactionResponseModel;
import com.springbootdeneme.demo.model.LoginResponseModel;
import com.springbootdeneme.demo.model.TransactionReportResponseModel;
import com.springbootdeneme.demo.operation.IGetClientOperation;
import com.springbootdeneme.demo.operation.IGetTransactionOperation;
import com.springbootdeneme.demo.operation.ILoginOperation;
import com.springbootdeneme.demo.operation.ITransactionReportOperation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	@Qualifier("operation.login")
	private ILoginOperation loginOp;

	@Autowired
	@Qualifier("operation.transactionreport")
	private ITransactionReportOperation transactionReportOperation;

	@Autowired
	@Qualifier("operation.gettransaction")
	private IGetTransactionOperation getTransactionOperation;

	@Autowired
	@Qualifier("operation.getclient")
	private IGetClientOperation getClient;

	@Autowired
	private Gson gson;

	@Test
	public void contextLoads() {
	}

	@Test
	public void loginOperationTest() {

		LOG.debug("::loginOperationTest test debug log");
		LoginResponseModel loginResp = loginOp.doLogin("demo@bumin.com.tr", "cjaiU8CV");

		assertNotNull(loginResp);
		assertTrue("APPROVED".equals(loginResp.getStatus()));

		LOG.debug("::loginOperationTest login response:{}", gson.toJson(loginResp));

	}

	@Test
	public void transactionReportOperationTest() {

		LOG.debug("::transactionReportOperationTest test debug log");
		TransactionReportResponseModel transactionReportResp = transactionReportOperation
				.getTransactionReport(LocalDate.now().minusDays(50), LocalDate.now(), 1, 2);

		assertNotNull(transactionReportResp);
		assertTrue("APPROVED".equals(transactionReportResp.getStatus()));

		LOG.debug("::transactionReportOperationTest report response:{}", gson.toJson(transactionReportResp));

	}

	@Test
	public void getTransactionOperationTest() {

		String transactionId = "1-1444392550-1";
		LOG.debug("::getTransactionOperationTest test debug log");

		GetTransactionResponseModel transactionRespModel = getTransactionOperation.getTransactionDetails(transactionId);

		assertNotNull(transactionRespModel);
		assertTrue(!"DECLINED".equals(transactionRespModel.getStatus()));
		LOG.debug("::getTransactionOperationTest response:{}", gson.toJson(transactionRespModel));

	}

	@Test
	public void getClientOperationTest() {

		LOG.debug("::getClientOperationTest test debug log");
		String clientId = "1-1444392550-1";
		GetClientResponseModel getClientResp = getClient.getClient(clientId);

		assertNotNull(getClientResp.getCustomerInfo());
		LOG.debug("::getClientOperationTest login response:{}", gson.toJson(getClientResp));

	}

//	@Test
//	public void testPropFile() {
//		PropertiesModel propModel = new PropertiesModel();
//
//		String email = propModel.getEmail();
//		String password = propModel.getPassword();
//
//		assertTrue(!email.isEmpty());
//		assertTrue(!password.isEmpty());
//	}

	@Test
	public void testLoginCache() {
		LoginResponseModel resp1 = loginOp.doLogin("demo@bumin.com.tr", "cjaiU8CV");
		LoginResponseModel resp2 = loginOp.doLogin("demo@bumin.com.tr", "cjaiU8CV");

		String token1 = resp1.getToken();
		String token2 = resp2.getToken();

		assertTrue(token1.equals(token2));

	}

//	@Test
//	public void testLoginCacheTtl() {
//
//		LoginResponseModel resp1 = loginOp.doLogin("demo@bumin.com.tr", "cjaiU8CV");
//
//		LoginResponseModel resp2 = loginOp.doLogin("demo@bumin.com.tr", "cjaiU8CV");
//
//		String token1 = resp1.getToken();
//		String token2 = resp2.getToken();
//
//		assertTrue(!token1.equals(token2));
//
//	}

}
