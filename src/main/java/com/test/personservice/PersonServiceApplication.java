package com.test.personservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PersonServiceApplication {

	@Bean
	public RestTemplate restTemplate(){
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setReadTimeout(5000);
		httpRequestFactory.setConnectTimeout(5000);
		return new RestTemplate(httpRequestFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApplication.class, args);
	}

}
