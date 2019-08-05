package com.lti.core.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.EmpDao;
import com.lti.core.exception.EmpException;
import com.lti.core.model.Employee;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao dao;

	@Override
	public ArrayList<Employee> getEmpList() throws EmpException {
		return dao.getEmpList();
	}

}
