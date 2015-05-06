package com.cxfjaxws.controller;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxfjaxws.EmployeeRequest;
import com.cxfjaxws.EmployeeResponse;
import com.cxfjaxws.HelloWorld;
import com.cxfjaxws.ObjectFactory;

@Controller
public class HelloWorldController {

	private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
	@Qualifier("helloWorldClient")
	private HelloWorld helloWorldClient;

	@RequestMapping(value = "/sayHi", method = RequestMethod.GET)
	public @ResponseBody EmployeeResponse getEmployee(@RequestParam("id") BigInteger id) {
		logger.info("getEmployee starts");
		ObjectFactory objectFactory = new ObjectFactory();
		EmployeeRequest employeeRequest = objectFactory.createEmployeeRequest();
		employeeRequest.setId(id);
		EmployeeResponse employee = helloWorldClient.getEmployee(employeeRequest);
		logger.info("##################");
		logger.info("employee :: "+employee);
		logger.info("##################");
		logger.info("getEmployee ends");
		return employee;
	}

}
