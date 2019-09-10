package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")// we put only / cuz the spring will provide us a page for the employees only  
	public String showHome() {
		
		return "list-customers";
	}
	
//	@GetMapping("/leaders")// we put only /leaders cuz the spring will provide us a page for the leaders only  
//	public String showLeaders() {
//		
//		return "leaders";
//	
//	}
//	
//	@GetMapping("/systems")// we put only /systems cuz the spring will provide us a page for the leaders only  
//	public String showSystems() {
//		
//		return "systems";
//	
//	}
	
}
