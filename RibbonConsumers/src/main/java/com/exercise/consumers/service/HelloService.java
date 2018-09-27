package com.exercise.consumers.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@Service
public class HelloService {

	private final Logger logger = LoggerFactory.getLogger(HelloService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="helloFallback")
	public String helloService() {
		long start = System.currentTimeMillis();
		String resultString = restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
		long end = System.currentTimeMillis();
		logger.info("SpendTime : " +(end-start));
		return resultString;
	}
	
	public String helloFallback() {
		return "time out! error!";
	}
}
