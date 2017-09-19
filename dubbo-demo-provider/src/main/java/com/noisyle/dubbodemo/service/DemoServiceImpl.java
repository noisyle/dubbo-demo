package com.noisyle.dubbodemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("demoService")
public class DemoServiceImpl implements DemoService {
	final private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
	
	@Autowired
	private DemoDao demoDao;

	public String test(String name) {
		logger.info("Request: {}", name);
		String str = null;
		try {
			str = demoDao.test(name);
		} catch (Exception e) {
			logger.error("Error: ", e);
			throw e;
		}
		return str;
	}
}
