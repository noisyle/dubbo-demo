package com.noisyle.dubbo.service;

import java.time.LocalTime;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0", timeout = 1000, retries = -1)
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return String.format("%s - Hello, %s!", LocalTime.now().toString(), name);
    }

}
