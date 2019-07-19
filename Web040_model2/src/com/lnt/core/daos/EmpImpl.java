package com.lnt.core.daos;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lnt.ApplicationFactory;
import com.lnt.core.entities.Employee;
import com.lnt.core.exceptions.EmpException;

public class EmpImpl implements EmpDao {
	private Connection connect;

	public EmpImpl() {
		connect=ApplicationFactory.getConnection();
	}

	@Override
	public List<Employee> getEmpList() throws EmpException {
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Employee> empList=new ArrayList<>();
		try {
			stmt=connect.createStatement();
			rs=stmt.executeQuery("Select employee_id,first_name, salary from employees");
			
			while(rs.next())
			{
				int empno=rs.getInt("employee_id");
				String empNm=rs.getString("first_name");
				float empSal=rs.getFloat("salary");
				
				Employee emp=new Employee(empno,empNm,empSal);
				empList.add(emp);
			}
		} catch (SQLException e) {
			throw new EmpException("Data fetch failed in getEmpList()",e);
		
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new EmpException("closing failed getEmpList()",e);
			}
		}
		return empList;
	}
	@Override
	public Employee getEmpDetails(int empNo) throws EmpException {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Employee p=null;
		try
		{
	stmt=connect.prepareStatement("Select * from Employees where employee_id=?");
		stmt.setInt(1, empNo);
		rs=stmt.executeQuery();
		
		
			if(rs.next())
			{
				do {
				String fname=rs.getString("FIRST_NAME");
				float empsal=rs.getFloat("SALARY");
				
				p=new Employee(empNo,fname,empsal);
				}while(rs.next());				
			}		
				
		
		} catch (SQLException e) {
			throw new EmpException("Data fetch failed in getEmpList()",e);
		
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new EmpException("closing failed getEmpList()",e);
			}
		}
		return p;
		
	}

	@Override
	protected void finalize() throws Throwable {
		if(connect!=null) {
			connect.close();
		}
		super.finalize();
	}

	
	
	

}
