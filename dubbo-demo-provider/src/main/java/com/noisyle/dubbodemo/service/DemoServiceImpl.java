package com.noisyle.dubbodemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("demoService")
public class DemoServiceImpl implements DemoService {
	final private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

	public String test(String name) {
		logger.info("Request: {}", name);
		if(name.length()==0){
			throw new DemoException("Please input a name.");
		}
		return "hello " + name + "!";
	}
}
