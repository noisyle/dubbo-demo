package com.noisyle.dubbodemo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noisyle.dubbodemo.service.DemoService;

@Controller
public class DemoController {
	Logger logger = Logger.getLogger(DemoController.class);
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value = "test")
	public String test(Model model, @RequestParam(required = false, defaultValue = "") String name) {
		try {
			model.addAttribute("msg", demoService.test(name));
			logger.info("Response: " + demoService.test(name));
			return "index";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "index";
		}
	}
}
