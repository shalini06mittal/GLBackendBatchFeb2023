package com.gl.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRestConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestConsumerApplication.class, args);
		
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> resp = 
//				template.getForEntity("http://localhost:8081/rest"
//						, String.class);
		template.postForEntity("http://localhost:8081/rest", null
				, String.class);
		System.out.println(resp.getBody());
		System.out.println(resp.getStatusCode());
	}

}


