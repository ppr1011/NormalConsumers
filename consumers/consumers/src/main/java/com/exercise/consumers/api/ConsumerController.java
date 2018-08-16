package com.exercise.consumers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exercise.consumers.service.HelloService;

@RestController
public class ConsumerController {

	@Autowired
	private HelloService helloService;

	@RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
	public String helloController() {
		return helloService.helloService();
	}
}
