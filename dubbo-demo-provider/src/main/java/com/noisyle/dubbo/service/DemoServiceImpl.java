package com.noisyle.dubbo.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.noisyle.dubbo.repository.DemoDao;


@Service(interfaceClass = IDemoService.class, timeout = 2000, retries = 2)
@Component
public class DemoServiceImpl implements IDemoService {
	final private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
	
	@Autowired
	private DemoDao demoDao;

    public DemoMessage greeting(DemoMessage msg) throws Exception {
		logger.info("Request: {}", msg.getMsg());
		String str = null;
		try {
			str = demoDao.greeting(msg.getMsg());
		} catch (Exception e) {
			logger.error("Error: ", e);
			throw e;
		}
		return new DemoMessage(str, new Date());
	}
}
