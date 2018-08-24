package com.noisyle.dubbodemo.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("demoService")
public class DemoServiceImpl implements DemoService {
	final private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
	
	@Autowired
	private DemoDao demoDao;

	public DemoMessage test(DemoMessage msg) throws Exception {
		logger.info("Request: {}", msg.getMsg());
		String str = null;
		try {
			str = demoDao.test(msg.getMsg());
		} catch (Exception e) {
			logger.error("Error: ", e);
			throw e;
		}
		return new DemoMessage(str, new Date());
	}
}
