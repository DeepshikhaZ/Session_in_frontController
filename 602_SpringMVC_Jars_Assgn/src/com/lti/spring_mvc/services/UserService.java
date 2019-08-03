package com.lti.spring_mvc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.spring_mvc.exception.ProjectException;
import com.lti.spring_mvc.model.User;

@Service
public class UserService implements IUserService {

	@Override
	public List<User> getUserList() throws ProjectException {
		List<User> userList = new ArrayList<User>();
		userList.add(new User(100l, "Z", "zzz", "dev"));
		userList.add(new User(101l, "Nilesh", "123456", "sleeping"));
		userList.add(new User(102l, "Deepshikha", "pass", "dev"));
		userList.add(new User(103l, "Priya", "password", "lost"));
		return userList;
	}

	

}
