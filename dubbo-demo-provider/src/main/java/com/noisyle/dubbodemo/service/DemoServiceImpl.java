package com.noisyle.dubbodemo.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService {
	Logger logger = Logger.getLogger(DemoServiceImpl.class);

	public String test(String name) {
		logger.info("Request: " + name);
		if(name.length()==0){
			throw new RuntimeException("Please input a name.");
		}
		return "hello " + name + "!";
	}
}
