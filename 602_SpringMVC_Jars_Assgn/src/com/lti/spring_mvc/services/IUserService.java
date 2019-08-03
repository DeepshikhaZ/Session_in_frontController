package com.lti.spring_mvc.services;

import java.util.List;

import com.lti.spring_mvc.exception.ProjectException;
import com.lti.spring_mvc.model.User;

public interface IUserService {
	public List<User> getUserList() throws ProjectException;
}
