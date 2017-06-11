package com.tasklist.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tasklist.services.contracts.UserService;
import com.tasklist.services.dto.UserDTO;
import com.tasklist.services.requestmodels.UserLoginReqModel;
import com.tasklist.services.requestmodels.UserRegisterReqModel;
import com.tasklist.services.utils.UserFormValidator;

@Controller(value = "/api")
public class UserController {
	private static final Logger LOG = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	UserFormValidator userFormValidator;

	// @InitBinder
	// protected void initBinder(WebDataBinder binder) {
	// binder.setValidator(userFormValidator);
	// }

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") UserRegisterReqModel user, BindingResult result, ModelMap model,
			HttpSession session,HttpServletResponse response) {
		LOG.info(user.getLogin() + " " + user.getPassword() + " " + user.getConfirmPassword());
		UserDTO userDTO = userService.createUser(user);
		session.setAttribute("user", userDTO);
		Cookie userCookie = new Cookie("userId",userDTO.getId().toString());
		userCookie.setMaxAge(1800*1800);
		response.addCookie(userCookie);
		return new ModelAndView("redirect:/tasklist");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") UserLoginReqModel user, BindingResult result, Model model) {
		LOG.info(user.getLogin() + " " + user.getPassword());
		return "login";
	}

	@PostMapping(value = "/logout")
	public void logout() {

	}
}
