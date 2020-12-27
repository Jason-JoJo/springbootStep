package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class errorController {
	 private Log logger = LogFactory.getLog(errorController.class);
		@ExceptionHandler(Exception.class)
		public ModelAndView handleException(HttpServletRequest request,Exception ex) {
			logger.error("Request: " + request.getRequestURL() + " raised " + ex);

			ModelAndView mv = new ModelAndView();
			
			mv.addObject("exception",ex.getMessage());
			mv.addObject("url",request.getRequestURI());
			mv.setViewName("error");
			
			return mv;
		}
}
