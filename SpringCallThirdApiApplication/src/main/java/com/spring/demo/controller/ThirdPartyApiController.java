package com.spring.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ThirdPartyApiController {

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

	@GetMapping("/callclienthello")
	public String getClientHello() {
		String uri = "http://localhost:8080/hello";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

	@GetMapping("/countries")
	public List<Object> getCountries() {
		String uri = "https://restcountries.eu/rest/v2/all";
		RestTemplate restTemplate = new RestTemplate();
		Object[] countries= restTemplate.getForObject(uri, Object[].class);
		return Arrays.asList(countries);
	}
	
	@GetMapping("/location")
    public ResponseEntity<String> getISSLocation() {
        String uri = "http://api.open-notify.org/iss-now.json";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
