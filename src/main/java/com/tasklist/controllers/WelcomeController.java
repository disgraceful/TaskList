package com.tasklist.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.tasklist.services.contracts.ProjectService;
import com.tasklist.services.contracts.TaskService;
import com.tasklist.services.contracts.UserService;
import com.tasklist.services.dto.UserDTO;
import com.tasklist.services.requestmodels.UserLoginReqModel;
import com.tasklist.services.requestmodels.UserRegisterReqModel;

@Controller
public class WelcomeController {
	private static final Logger LOG = LogManager.getLogger(WelcomeController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projService;
	
	@Autowired 
	private TaskService taskService;

	@RequestMapping(value = "/login")
	public ModelAndView loginPage() {
		LOG.info("self.location works!");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new UserLoginReqModel());
		return mav;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView registerPage() {
		LOG.info("self.location works!");
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new UserRegisterReqModel());
		return mav;
	}

	@RequestMapping(value = "/tasklist")
	public ModelAndView welcome(HttpSession session, ModelMap model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("tasklistmain");
		UserDTO user = (UserDTO) session.getAttribute("user");
		Cookie userCookie = WebUtils.getCookie(request, "userId");
		if (user == null) {
			if(userCookie!=null){				
				user = userService.getUserAsDTO(new ObjectId(userCookie.getValue()));
				LOG.info(user.getLogin());
			}else{
				model.addAttribute("user", new UserLoginReqModel());
				return new ModelAndView("redirect:/login", model);
			}
		}
		
		mav.addObject("user", user);
		mav.addObject("projects",projService.getProjectByUserIdAsDTO(user.getId()));
		mav.addObject("tasks",taskService.getTasksByUserId(user.getId()));
		return mav;
	}
}
