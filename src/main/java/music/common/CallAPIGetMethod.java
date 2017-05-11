package music.common;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class CallAPIGetMethod {

	private byte[] responseBody;
	private String responseBodyString;
	private int statusCode;

	public byte[] getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(byte[] responseBody) {
		this.responseBody = responseBody;
	}

	public String getResponseBodyString() {
		return responseBodyString;
	}

	public void setResponseBodyString(String responseBodyString) {
		this.responseBodyString = responseBodyString;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public CallAPIGetMethod() {
	}

	public CallAPIGetMethod(String url) throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		Header header = new Header();
		header.setName("Accept-Encoding");
		header.setValue("gzip, deflate, sdch");
		try {
			this.statusCode = httpClient.executeMethod(getMethod);
			this.responseBody = getMethod.getResponseBody();
			this.responseBodyString = getMethod.getResponseBodyAsString();
		} finally {
			getMethod.releaseConnection();
		}
	}

}
