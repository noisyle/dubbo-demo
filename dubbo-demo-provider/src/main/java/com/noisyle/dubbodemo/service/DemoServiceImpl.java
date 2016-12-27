package com.noisyle.dubbodemo.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService {
	Logger logger = Logger.getLogger(DemoServiceImpl.class);

	public String test(String str) {
		if(str.length()==0){
			throw new RuntimeException("Please input a name.");
		}
		String result = "hello " + str + "!";
		logger.info("result : " + result);
		return result;
	}
}
