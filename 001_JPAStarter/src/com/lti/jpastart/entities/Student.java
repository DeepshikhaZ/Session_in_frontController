package com.lti.jpastart.entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //tells JPA that this class object has to persisted
@Table(name="students_jpa")//tells JPA that this class object has to be mapped with this table
public class Student implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id//tell JPA that this is a Primary key
	@GeneratedValue(strategy=GenerationType.AUTO)//later
	private int studentId;
	
	private String studentName;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String name) {
		this.studentName = name;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	
}
