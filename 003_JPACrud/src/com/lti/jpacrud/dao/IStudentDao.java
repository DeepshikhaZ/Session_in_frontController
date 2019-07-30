package com.lti.jpacrud.dao;

import java.util.List;

import com.lti.jpacrud.client.StudentException;
import com.lti.jpacrud.entities.Student;

public interface IStudentDao {
	
	public abstract List<Student> listStudent() throws StudentException;

	public abstract Student findStudentById(Integer id) throws StudentException;

	public abstract Student addStudent(Student student) throws StudentException;

	public abstract Student removeStudent(Student student) throws StudentException;

	public abstract Student updateStudent(Student student) throws StudentException;

	public abstract void commitTransaction() throws StudentException;

	public abstract void beginTransaction() throws StudentException;

}