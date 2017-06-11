package com.tasklist.controllers;

import java.util.Arrays;
import java.util.Optional;

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

import com.tasklist.services.contracts.UserService;
import com.tasklist.services.requestmodels.UserRegisterReqModel;

@Controller
public class WelcomeController {
	private static final Logger LOG = LogManager.getLogger(WelcomeController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new UserRegisterReqModel());
		return mav;
	}

	@RequestMapping(value = "/tasklist")
	public ModelAndView welcome(HttpSession session, ModelMap model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("tasklistmain");
		Object user = session.getAttribute("user");
		// Optional<Cookie> opt
		// =Arrays.asList(request.getCookies()).stream().filter(e->"userId".equals(e.getName())).findFirst();
		Cookie userCookie = WebUtils.getCookie(request, "userId");
		LOG.info(userCookie != null);
		if (user == null) {
			if(userCookie!=null){
				user = userService.getUserAsDTO(new ObjectId(userCookie.getValue()));
			}else{
				model.addAttribute("user", new UserRegisterReqModel());
				return new ModelAndView("redirect:/login", model);
			}
		}
		mav.addObject("user", user);
		return mav;
	}
}
