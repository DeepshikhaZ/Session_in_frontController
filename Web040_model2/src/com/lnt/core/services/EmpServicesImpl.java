package com.lnt.core.services;

import java.util.List;

import com.lnt.core.daos.EmpDao;
import com.lnt.core.daos.EmpImpl;
import com.lnt.core.entities.Employee;
import com.lnt.core.exceptions.EmpException;

public class EmpServicesImpl implements EmpService {
	private EmpDao dao;
	public EmpServicesImpl() {
		dao=new EmpImpl();
	}
	
	@Override
	public List<Employee> getEmpList() throws EmpException{
		return dao.getEmpList();
		
	}

	@Override
	public Employee getEmpDetails(int empNo) throws EmpException {
		return dao.getEmpDetails(empNo);
	}


}
