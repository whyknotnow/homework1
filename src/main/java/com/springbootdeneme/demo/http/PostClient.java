package com.springbootdeneme.demo.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.springbootdeneme.demo.model.BaseRequestModel;

@Component(value = "http.postclient")
public class PostClient implements IPostClient {

	// TODO move this to config
	String baseTestUrl = "https://sandbox-reporting.rpdpymnt.com/api/v3";

	@Autowired
	private Gson gson;

	private Logger LOG = LoggerFactory.getLogger(getClass());

	public <T> T postJson(BaseRequestModel requestModel, String action, Class<T> respClass) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(baseTestUrl + action);

		String json = gson.toJson(requestModel);
		HttpEntity entity;
		T returnModel = null;
		try {
			entity = new StringEntity(json);

			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");

			if (requestModel.getToken() != null) {
				httpPost.setHeader("Authorization", requestModel.getToken());
			}

			CloseableHttpResponse response = client.execute(httpPost);

			entity = response.getEntity();

			String rawResponse = convert(entity.getContent(), Charset.forName("UTF-8"));

			LOG.debug("::postJson req:{} res:{}", json, rawResponse);

			returnModel = (T) gson.fromJson(rawResponse, respClass);

			client.close();

		} catch (UnsupportedEncodingException e) {
			LOG.error("::postJson preRequest exception. req:{}", json, e);
		} catch (IOException e) {
			LOG.error("::postJson postRequest exception. req:{}", json, e);
		}

		return returnModel;
	}

	public String convert(InputStream inputStream, Charset charset) throws IOException {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
			return br.lines().collect(Collectors.joining(System.lineSeparator()));
		}
	}
}
