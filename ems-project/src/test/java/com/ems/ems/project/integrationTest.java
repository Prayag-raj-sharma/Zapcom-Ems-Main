/*package com.ems.ems.project;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ems.ems.project.model.Employee;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EmsProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class integrationTest {
	
	@LocalServerPort
	private int port;

	TestRestTemplate test = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testGetEmployeeById() throws JSONException{
		
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		
		ResponseEntity<String> response = test.exchange(createURLWithPort("/api/employees/id/7"), HttpMethod.GET,
				                           entity, String.class);
		
		String expected = "{id:7,emailId:clark@gmail.com,firstName:clark,lastName:kent}";
		
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
    
	@Test
	public void testGetEmployeeByFirstName() throws JSONException{
		
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		
		ResponseEntity<String> response = test.exchange(createURLWithPort("/api/employees/fn/clark"), HttpMethod.GET,
				                           entity, String.class);
		
		String expected = "{id:7,emailId:clark@gmail.com,firstName:clark,lastName:kent}";
		
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void testGetEmployeeByLastName() throws JSONException{
		
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		
		ResponseEntity<String> response = test.exchange(createURLWithPort("/api/employees/ln/kent"), HttpMethod.GET,
				                           entity, String.class);
		
		String expected = "{id:7,emailId:clark@gmail.com,firstName:clark,lastName:kent}";
		
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void testPostEmployee() throws JSONException {
		
		Employee emp = new Employee(30L,"lucky@gmail.com","lucky","rai");
		
		HttpEntity<Employee> entity = new HttpEntity<Employee>(emp,headers);
		
		ResponseEntity<String> response = test.exchange(createURLWithPort("/api/employees"), HttpMethod.POST,
				                            entity, String.class);
		
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		
		assertTrue(actual.contains("/api/employees/"));
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	
	
	



	

}*/
