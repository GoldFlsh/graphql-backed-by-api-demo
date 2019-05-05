package org.ryank.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
public class GraphqlBackedByApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlBackedByApiDemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://jsonplaceholder.typicode.com"));
		return restTemplate;
	}
}
