package com.lti.spring_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lti.spring_mvc.exception.ProjectException;
import com.lti.spring_mvc.model.User;
import com.lti.spring_mvc.services.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	//  /user/userList
	@RequestMapping(value="/userList")
	public String showUserList(Model model) {
		
		List<User> userList = null;
		String viewName="";
		
		try {
			userList = userService.getUserList();
			model.addAttribute("userList", userList);
			viewName="userListPage";
		} catch (ProjectException e) {
			viewName="errorPage";
			model.addAttribute("errorMsg", e.getMessage());
			return viewName;
		}
		
		return viewName;
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
