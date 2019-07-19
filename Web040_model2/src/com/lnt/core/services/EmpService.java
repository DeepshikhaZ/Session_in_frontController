package com.lnt.core.services;

import java.util.List;

import com.lnt.core.entities.Employee;
import com.lnt.core.exceptions.EmpException;

public interface EmpService {
	public List<Employee> getEmpList() throws EmpException;
	public Employee getEmpDetails(int empNo) throws EmpException;


}
