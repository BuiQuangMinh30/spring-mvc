package com.example.demo.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;

import org.springframework.ui.ModelMap;

@Controller
public class LoginControl {
	private ApplicationContext context = null;
	private UserJDBCTemplate userJDBCTemplate = null;

	public LoginControl() {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLogin() {
		return new ModelAndView("login", "command", new User());
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String checkUser(@ModelAttribute("SpringWeb") User user, ModelMap model) {
		model.addAttribute("username", user.getUsername());
		System.out.println(user.getUsername());
		if (userJDBCTemplate.checkLogin(user)) {
			return "loginsuccess";
		}
		return "loginerror";
	}
}