package com.forum.app.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.forum.app.entity.User;
import com.forum.app.entity.dto.UserForm;
import com.forum.app.entity.dto.validation.DuplicateEmailException;
import com.forum.app.service.CrudService;

@Controller
@RequestMapping("/signup")
public class RegisterController {

	@Autowired
	private CrudService crudService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView signUp() {
		ModelAndView modelAndView = new ModelAndView("signup");
		modelAndView.addObject("userForm", new UserForm());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createNewUser(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result,
			WebRequest request) throws DuplicateEmailException {
		GrantedAuthority[] userRoles = { new SimpleGrantedAuthority("ROLE_USER") };
		User register = new User(userForm.getUsername(), userForm.getEmail(), userForm.getPassword(),
				Arrays.asList(userRoles));
		crudService.create(register);
		return "redirect:/login";
	}
}
