package com.lti.jpacrud.client;
import java.util.List;
import java.util.Scanner;

import com.lti.jpacrud.entities.Student;
import com.lti.jpacrud.service.IStudentService;
import com.lti.jpacrud.service.StudentService;
import com.lti.jpacrud.util.JPAUtil;
public class StudentClientUI {
	//perp-work-create object of service
	static IStudentService service = new StudentService();
	
	public static void main(String[] args) throws StudentException {
		Scanner sc = new Scanner(System.in);
		//Debug this program as Debug -> Debug as Java Application
		//create student object
		Student student = new Student();
	//	Integer id=(int) (1000+Math.random()*1234.1234);
		
		
		/*System.out.println("Enter Student Id");
		id=sc.nextInt();
		student.setStudentId(id);*/
		
		
		System.out.println("Enter Student Name");
		String name=sc.next();
		student.setStudentName(name);
//Create
	Student persistedStudent	=service.addStudent(student);
	Integer studentId=persistedStudent.getStudentId();
	if(studentId>0) {
		System.out.println("student persisted with unique"+ "student id :"+studentId);
	}
		//at this breakpoint, we have added one record to table
		List<Student> studentList = service.listStudent();
		if(studentList!=null) {
			System.out.println("List of Students");
			studentList.forEach((s1)->System.out.println(s1));;
		}
		else {
			System.out.println("No Records Found");
		}
	
//Retrieve
		/*student = service.findStudentById(id);
		System.out.print("ID:"+student.getStudentId());
		System.out.println(" Name:"+student.getName());
//Update
		student.setName("Sachin Tendulkar");
		service.updateStudent(student);
		
		//at this breakpoint, we have updated record added in first section
		student = service.findStudentById(id);
		System.out.print("ID:"+student.getStudentId());
		System.out.println(" Name:"+student.getName());
//Delete
		//at this breakpoint, record is removed from table
		//service.removeStudent(student);
*/		
	

		
		
		System.out.println("End of program...");
		JPAUtil.closeEntityManager();
	}
}
