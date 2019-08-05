package com.lti.core.daos;

import java.util.ArrayList;
import java.util.List;

import com.lti.core.exception.EmpException;
import com.lti.core.model.Employee;

public interface EmpDao {
	 ArrayList<Employee> getEmpList() throws EmpException;
	
}
