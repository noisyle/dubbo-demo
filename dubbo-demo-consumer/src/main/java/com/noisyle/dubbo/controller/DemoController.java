package com.noisyle.dubbo.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.dubbo.config.annotation.Reference;
import com.noisyle.dubbo.service.DemoMessage;
import com.noisyle.dubbo.service.IDemoService;

@Controller
public class DemoController {
	final private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Reference(check=false)
	private IDemoService demoService;
	
	@RequestMapping(value = "/")
	public String test(Model model, @RequestParam(required = false, defaultValue = "") String name) {
		try {
		    DemoMessage msg = demoService.greeting(new DemoMessage(name, new Date()));
			model.addAttribute("msg", msg.getMsg());
			logger.info("Response: {}", msg.getMsg());
			return "index";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			logger.info("Error: ", e);
			return "index";
		}
	}
}
