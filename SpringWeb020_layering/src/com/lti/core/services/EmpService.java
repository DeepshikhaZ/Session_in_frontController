package com.lti.core.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.lti.core.exception.EmpException;
import com.lti.core.model.Employee;
 //@Service
public interface EmpService {
	 ArrayList<Employee> getEmpList() throws EmpException;

}
