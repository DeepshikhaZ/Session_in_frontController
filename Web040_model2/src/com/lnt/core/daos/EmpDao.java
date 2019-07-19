package com.lnt.core.daos;
import java.util.List;

import com.lnt.core.entities.Employee;
import com.lnt.core.exceptions.EmpException;
public interface EmpDao {
	public List<Employee> getEmpList() throws EmpException;
	public Employee getEmpDetails(int empNo) throws EmpException;
	
	

}
