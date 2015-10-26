package com.noisyle.dubbodemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noisyle.dubbodemo.service.DemoService;

@Controller
public class DemoController {
	@Autowired
	private DemoService demoService;

	@RequestMapping("test")
	public @ResponseBody String test(@RequestParam(required = false, defaultValue = "world") String str) {
		try {
			return demoService.test(str);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
