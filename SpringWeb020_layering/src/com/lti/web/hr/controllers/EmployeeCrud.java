package com.lti.web.hr.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lti.core.model.Employee;
import com.lti.core.services.EmpService;

/* @Component
 *    @Service
 *    @Controller:Its a muti-action controller
 *    @RestController: To publish all Rest methods as Rest services.
    http://localhost:8084/SpringWeb020_layering/app/home
 */
@Controller
public class EmployeeCrud {
	@Autowired
	private EmpService service;
	@RequestMapping("/home")
	public String getHomePage()
	{
		return "Home";
	}
	@RequestMapping("/getEmpList")
	public ModelAndView getEmpList( )
	{
		ModelAndView mnv=null;

		try {
			List<Employee> empList=service.getEmpList();
			mnv=new ModelAndView();
			mnv.addObject("empList",empList);
			mnv.setViewName("EmpList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mnv;
		
	}
}
