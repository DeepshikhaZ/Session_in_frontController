package com.lti.jpacrud.service;
import java.util.List;

import com.lti.jpacrud.client.StudentException;
import com.lti.jpacrud.dao.IStudentDao;
import com.lti.jpacrud.dao.StudentDao;
import com.lti.jpacrud.entities.Student;
public class StudentService implements IStudentService {
	//prep-work object of Dao
	private IStudentDao studentDao;
	public StudentService() {
		studentDao = new StudentDao();//create the object of Dao
	}
	@Override
	public Student addStudent(Student student) throws StudentException {//c
		studentDao.beginTransaction();
		studentDao.addStudent(student);
		studentDao.commitTransaction();
		return student;
	}	
	@Override
	public Student updateStudent(Student student) throws StudentException {//u
		studentDao.beginTransaction();
		studentDao.updateStudent(student);
		studentDao.commitTransaction();
		return student;
	}	
	@Override
	public Student removeStudent(Student student) throws StudentException {//D
		studentDao.beginTransaction();
		studentDao.removeStudent(student);
		studentDao.commitTransaction();
		return student;
	}
	
	@Override
	public Student findStudentById(Integer id) throws StudentException {//R
		//no need of transaction, as it's an read operation
		Student student  = studentDao.findStudentById(id);
		return student;
	}
	@Override
	public List<Student> listStudent() throws StudentException {

		return studentDao.listStudent();
	}
}
