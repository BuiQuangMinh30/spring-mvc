package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;

@Controller
public class HelloController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(ModelMap model, HttpServletRequest request) {
		
		model.addAttribute("message",
				"Hello Spring MVC Web Framework!" + request.getParameter("name"));
		return "hello";
	}
}
