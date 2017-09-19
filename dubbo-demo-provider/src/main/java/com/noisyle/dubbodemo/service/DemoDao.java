package com.noisyle.dubbodemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("demoDao")
public class DemoDao {
	final private static Logger logger = LoggerFactory.getLogger(DemoDao.class);

	public String test(String name) {
		if(name.length()==0){
			logger.error("name is empty");
			throw new DemoException("Please input a name.");
		}
		return "hello " + name + "!";
	}
}
