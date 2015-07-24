package com.cxfjaxws.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cxfjaxws.EmployeeRequest;
import com.cxfjaxws.EmployeeResponse;
import com.cxfjaxws.HelloWorldPortType;
import com.cxfjaxws.ObjectFactory;
import com.cxfjaxws.vo.EmployeeVo;

@Controller
public class HelloWorldController {

	private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
	@Qualifier("helloWorldClient")
	private HelloWorldPortType helloWorldClient;

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public String getEmployee(@RequestParam("id") BigInteger id, Model model) {
		logger.info("getEmployee starts");
		ObjectFactory objectFactory = new ObjectFactory();
		EmployeeRequest employeeRequest = objectFactory.createEmployeeRequest();
		employeeRequest.setId(id);
		EmployeeResponse employee = helloWorldClient.getEmployee(employeeRequest);
		logger.info("##################");
		List<EmployeeVo> employeeVos = new ArrayList<EmployeeVo>();
		EmployeeVo employeeVo = new EmployeeVo(employee.getId(),employee.getFirstname(),employee.getLastname());
		employeeVos.add(employeeVo);
		logger.info("employeeVo :: "+employeeVo);
		model.addAttribute("employeeVos", employeeVos);
		logger.info("##################");
		logger.info("getEmployee ends");
		return "employee";
	}

}
