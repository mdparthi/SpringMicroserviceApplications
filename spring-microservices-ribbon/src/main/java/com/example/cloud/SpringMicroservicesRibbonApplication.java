package com.example.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
//@RibbonClient(name="simple-service-2", configuration=SimpleServiceConfiguration.class)
public class SpringMicroservicesRibbonApplication {
	
	@Bean
//	@LoadBalanced // restTemplate consult our ribbon client configuration while invoking service 
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping("/startClient")
	public String startClient()
	{
		return this.restTemplate.getForObject("http://localhost:7777/execute", String.class);
//		return this.restTemplate.getForObject("http://simple-service-2/execute", String.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesRibbonApplication.class, args);
	}
}
