package com.beginners.HRRS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value= {"/", "/home"}, method=RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value= {"/admin/dashboard", "/admin/home"}, method=RequestMethod.GET)
	public String adminDashboardPage() {
		return "admin/dashboard";
	}
	
}
