package com.lti.core.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lti.core.exception.EmpException;
import com.lti.core.model.Employee;
// the EmpDaoImpl is depending on DataSource
//EmpDaoImpl to have DI of Data Source.
@Repository
public class EmpDaoImpl implements EmpDao{
	//when there r more than 1 class for same i/f then use byName or 
	//use @Qualifier annotation
	@Autowired
		private DataSource dataSource;
	@Override
	@Qualifier("ds") //@resource is used when no @annotation
	//@Resource(name="ds") //by default w/o name it may go with default by type
	public ArrayList<Employee> getEmpList() throws EmpException {
		String qry="SELECT EmpNo,EmpNm ,Sal from Emp";
		Connection connect=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Employee> empList=new ArrayList<Employee>();
		try {
			connect =dataSource.getConnection();
			stmt=connect.createStatement();
			rs=stmt.executeQuery(qry);
			while(rs.next())
			{
				
				int empNo=rs.getInt("EmpNo");
				String empNm=rs.getString("EmpNm");
				float empSal=rs.getFloat("Sal");
				
				Employee emp =new Employee(empNo,empNm,empSal);
				empList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(connect!=null) {
					connect.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return empList ;
	}

}
