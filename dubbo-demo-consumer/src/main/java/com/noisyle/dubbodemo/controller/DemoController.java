package com.noisyle.dubbodemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noisyle.dubbodemo.service.DemoService;

@Controller
public class DemoController {
	final private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value = "/")
	public String test(Model model, @RequestParam(required = false, defaultValue = "") String name) {
		try {
			String msg = demoService.test(name);
			model.addAttribute("msg", msg);
			logger.info("Response: {}", msg);
			return "index";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			logger.info("Error: ", e);
			return "index";
		}
	}
}
