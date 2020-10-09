package com.bridgelabz.registerapp.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityLayoutServlet;

import com.bridgelabz.registerapp.model.User;
import com.bridgelabz.registerapp.service.UserService;

public class RegistrationController extends VelocityLayoutServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
	@Override
	protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
		User user = new User();
		user.setFirstName(request.getParameter("first_name"));
		user.setLastName(request.getParameter("last_name"));
		user.setPhoneNumber(request.getParameter("phone_number"));
		user.setEmailId(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setConfirmPassword(request.getParameter("confirm-password"));
		boolean isRegister = false;
		try {
			isRegister = userService.registerUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Template template = null;

		try {
			if(isRegister) {
				template = getTemplate("login.vm");
				response.setHeader("Template Returned", "Success");
			} else {
				template = getTemplate("register.vm");
				response.setHeader("Template Returned", "Failed");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return template;

	}	
}
