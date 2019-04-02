package com.data;

import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes=JavaSpringBootApplication.class)

@TestComponent
public class JavaSpringBootApplicationTests {
	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate=new TestRestTemplate();
	@Test
	public void contextLoads()
	{
				JSONObject jsonObject;
				try {
					jsonObject = new JSONObject((String)restTemplate.getForObject(createURLWithPort("/hello"),String.class));
					assertTrue(jsonObject.has("car"));
				} catch (RestClientException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			String expected = "{\"car\":{\"manufacturer\":\"Germany\",\"name\":\"BMW\"}}";
			try {
				JSONAssert.assertEquals(expected,restTemplate.getForObject(createURLWithPort("/hello"),String.class),false);
			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	public String createURLWithPort(String uri) 
	{
		return "http://localhost:" + port + uri;
	}

	

}
