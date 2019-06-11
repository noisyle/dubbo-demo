package com.noisyle.dubbo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.noisyle.dubbo.service.HelloService;

@RestController
public class DemoController {
	final private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Reference(version = "1.0.0", check = false)
    private HelloService demoService;
	
	@RequestMapping(value = "sayHello")
	public ResponseEntity<Object> sayHello(@RequestParam(required = false, defaultValue = "world") String name) {
		try {
	        String sayHello = demoService.sayHello(name);
	        logger.debug("Response: {}", sayHello);
	        return ResponseEntity.ok(sayHello);
		} catch (Exception e) {
		    logger.error("Failed!", e);
            throw e;
		}
	}
}
