package com.infosys.api.product;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfig {
//@LoadBalanced
	@Bean 
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
