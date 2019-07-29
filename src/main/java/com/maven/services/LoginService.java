package com.maven.services;

import com.maven.models.LoginBean;

public class LoginService {
	private LoginBean bean;

	public LoginService(LoginBean bean) {
		super();
		this.bean = bean;
	}

	public static boolean check(LoginBean bean) {
		if (bean.getUsername().equals("admin") && bean.getPassword().equals("admin")) {
			return true;
		} else {
			return false;
		}

	}
}
