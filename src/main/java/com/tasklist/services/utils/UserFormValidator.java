package com.tasklist.services.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tasklist.services.contracts.UserService;
import com.tasklist.services.requestmodels.UserRegisterReqModel;

@Component
public class UserFormValidator implements Validator {
	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;

	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegisterReqModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserRegisterReqModel user = (UserRegisterReqModel) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty.user.login");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.user.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.user.confirmPassword");

		if (!emailValidator.valid(user.getLogin())) {
			errors.rejectValue("login", "Pattern.user.email");
		}

		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
		}
	}
}