package com.noisyle.dubbo.service;

import java.time.LocalTime;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0", timeout = 1000, retries = -1)
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return String.format("%s - Hello, %s!", LocalTime.now().toString(), name);
    }

}