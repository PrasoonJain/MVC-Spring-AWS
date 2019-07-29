package com.maven.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maven.models.LoginBean;
import com.maven.services.LoginService;

@Controller
public class LoginController {
	@RequestMapping("/")
	public String sayHello() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login", "loginAttr", new LoginBean());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String save(@ModelAttribute("loginAttr") @Valid LoginBean loginbean, BindingResult result, ModelMap model,
			HttpSession session) {
		if (result.hasErrors()) {
			System.out.println("eroror hai ");
			return "login";
		}

		if (LoginService.check(loginbean)) {
			System.out.println("true returned");
			session.setAttribute("username", loginbean.getUsername());

			return "index";
		}
		// System.out.println("truelol ");
		model.addAttribute("error", "Please enter valid credentials!");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("gone here");

		session.invalidate();
		System.out.println("gone");

		return "index";
	}

}
