package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean validate(String name ,String password) {
		boolean boo = false;
		String jason = "jason";
		String pass = "1234";

		if(jason.equals(name) && pass.equals(password)) {
			boo = true;
		}
		
		return boo;
	}

}
