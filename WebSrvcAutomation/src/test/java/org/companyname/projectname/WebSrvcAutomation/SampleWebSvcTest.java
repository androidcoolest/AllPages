package org.companyname.projectname.WebSrvcAutomation;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;


public class SampleWebSvcTest {
	@Test
	public void simpleTest() throws ClientProtocolException, IOException {
		String Url="http://footballpool.dataaccess.eu/data/info.wso/Cities";
			HttpClient client=HttpClientBuilder.create().build(); 
			HttpResponse response=client.execute(new HttpGet(Url));
			String responseString = new BasicResponseHandler().handleResponse(response);
			System.out.println(responseString);
			System.out.println(response.getStatusLine().getStatusCode());

		//httpGet = new HttpGet("");
	}
}
