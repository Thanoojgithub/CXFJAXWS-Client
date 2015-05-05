package com.cxfjaxws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxfjaxws.HelloWorld;

@Controller
public class HelloWorldController {

	private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
	@Qualifier("helloWorldClient")
	private HelloWorld helloWorldClient;

	@RequestMapping(value = "/sayHi", method = RequestMethod.GET)
	public @ResponseBody String sayHi(@RequestParam("name") String name) {
		logger.info("sayHi starts");
		String sayHi = helloWorldClient.sayHi(name);
		logger.info("##################");
		logger.info(sayHi);
		logger.info("##################");
		logger.info("sayHi ends");
		return sayHi;
	}

}
