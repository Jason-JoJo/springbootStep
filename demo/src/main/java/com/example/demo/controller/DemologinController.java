package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.service.LoginService;

@Controller
@SessionAttributes("name")
public class DemologinController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/log",method = RequestMethod.GET)
	public String demolog(@RequestParam String name, ModelMap model) {
		
		model.put("name", name);
		return "log";
	}
	@RequestMapping(value="/",method = RequestMethod.GET)
//	@GetMapping("/")
	public String form() {
		
		return "Form";
	}
	
	@RequestMapping(value="/",method = RequestMethod.POST)
//	@PostMapping("/")
	public String welcome(@RequestParam String name, @RequestParam String password,ModelMap model) {
		
//		LoginService loginService = new LoginService(); //之前的寫法，改用 Autowired 且 LoginService class 也要加上 @Component
		
		boolean isVal = loginService.validate(name, password);
		
		if(!isVal) {
			model.put("errorMsg", "Invalid Credentials!!");
			return "Form";
		}else {
			model.put("name", name);
			
			return "welcome";
		}
		
	}

}
