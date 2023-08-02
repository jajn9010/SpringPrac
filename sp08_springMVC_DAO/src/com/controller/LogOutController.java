package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogOutController {
	
	@RequestMapping(value = "/logout.kosa", method = RequestMethod.POST)
	public String out(HttpSession session) {
		session.invalidate();
		return "loginForm";
	}
}
