package com.noisyle.dubbodemo.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noisyle.dubbodemo.service.DemoMessage;
import com.noisyle.dubbodemo.service.DemoService;

@Controller
public class DemoController {
	final private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value = "/")
	public String test(Model model, @RequestParam(required = false, defaultValue = "") String name) {
		try {
		    DemoMessage msg = demoService.test(new DemoMessage(name, new Date()));
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
