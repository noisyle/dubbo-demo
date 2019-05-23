package com.noisyle.dubbo.service;

import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


@Service(interfaceClass = IDemoService.class, timeout = 1000, retries = 0)
public class DemoServiceImpl implements IDemoService {
	final private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
	
    @Value("${dubbo.application.name}")
    private String serviceName;

    public String sayHello(String name) {
		logger.info("Request: {}", name);
		return String.format("[%s] : Hello, %s", serviceName, name);
	}
}
