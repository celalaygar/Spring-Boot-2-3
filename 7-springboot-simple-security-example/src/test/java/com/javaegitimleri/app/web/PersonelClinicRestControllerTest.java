package com.javaegitimleri.app.web;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.javaegitimleri.app.model.Personel;

import ch.qos.logback.core.boolex.Matcher;
import junit.framework.Assert;

public class PersonelClinicRestControllerTest {

	private RestTemplate restTemplate;
	
	
	@Before
	public void setup() {
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void deletePersonelTest() {
		restTemplate.delete("http://localhost:8182/rest/personel/6");
		try {
			restTemplate.getForEntity("http://localhost:8182/rest/personel/6", Personel.class);
			Assert.fail("Should have not returned Personel");
			
		} catch (HttpClientErrorException e) {
			MatcherAssert.assertThat(e.getStatusCode().value(), Matchers.equalTo(404));
		}
		
	}
	
	@Test
	public void updatePersonelTest() {
		Personel p=restTemplate.getForObject("http://localhost:8182/rest/personel/2", Personel.class);
		MatcherAssert.assertThat(p.getFirstname(), Matchers.equalTo("Celal"));
		p.setFirstname("Haci Celal");
		restTemplate.put("http://localhost:8182/rest/personel/2", p);
		p=restTemplate.getForObject("http://localhost:8182/rest/personel/2", Personel.class);
		MatcherAssert.assertThat(p.getFirstname(), Matchers.equalTo("Haci Celal"));
	}
	
	
	
	@Test
	public void createPersonelTest() {	
		Personel p=new Personel();
		p.setFirstname("Cemal");
		p.setLastname("Sayman");
		p.setId(8L);
		URI location=restTemplate.postForLocation("http://localhost:8182/rest/personel", p);
		Personel p2=restTemplate.getForObject(location, Personel.class);
		MatcherAssert.assertThat(p2.getFirstname(), Matchers.equalTo(p.getFirstname()));
		MatcherAssert.assertThat(p2.getLastname(), Matchers.equalTo(p.getLastname()));
	}
	@Test
	public void testGetPersonelById() {
		ResponseEntity<Personel> response=  restTemplate.getForEntity("http://localhost:8182/rest/personel/1", Personel.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getBody().getFirstname(), Matchers.equalTo("Kemal"));
		
	}
	
	@Test
	public void testGetPersonelByLastName() {
		ResponseEntity<List> response=  restTemplate.getForEntity("http://localhost:8182/rest/personel?fn=Celal", List.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		List<Map<String, String>> body=response.getBody();
		List<String> firstname =body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
		MatcherAssert.assertThat(firstname, Matchers.containsInAnyOrder("Celal","Kemal","Yavuz"));
		
	}
	@Test
	public void testGetPersonel() {
		ResponseEntity<List> response=  restTemplate.getForEntity("http://localhost:8182/rest/personels", List.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		List<Map<String, String>> body=response.getBody();
		List<String> firstname =body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
		MatcherAssert.assertThat(firstname, Matchers.containsInAnyOrder("Celal","Kemal","Yavuz"));
		
	}
}
