package com.noisyle.dubbo;

import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.noisyle.dubbo.service.IDemoService;

@SpringBootApplication
public class App {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(url = "dubbo://127.0.0.1:12345")
    private IDemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            logger.info(demoService.sayHello("mercyblitz"));
        };
    }

}
