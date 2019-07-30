package com.lti.jpacrud.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lti.jpacrud.entities.Student;
import com.lti.jpacrud.util.JPAUtil;
public class StudentDao implements IStudentDao {
	private EntityManager entityManager;
	public StudentDao() {
		//step 1 : obtain entity manager object
		entityManager = JPAUtil.getEntityManager();
	}
	@Override
	public Student findStudentById(Integer id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}
	@Override
	public Student addStudent(Student student) {
		entityManager.persist(student);
		return student;
	}
	@Override
	public Student removeStudent(Student student) {
		entityManager.remove(student);
		return student;
	}
	@Override
	public Student updateStudent(Student student) {
		return entityManager.merge(student);
	}
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	@Override
	public List<Student> listStudent() {
		String hql = "from Student";
		Query query = entityManager.createQuery(hql);
		List<Student> studentList = query.getResultList();
		return studentList;
	}
}
