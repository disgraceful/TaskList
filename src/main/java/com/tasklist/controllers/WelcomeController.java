package com.tasklist.controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController  {
	private static final Logger LOG = LogManager.getLogger(WelcomeController.class);
	
	@RequestMapping(value="/tasklist")
	public ModelAndView welcome() {
		return new ModelAndView("tasklistmain");
	}
}
