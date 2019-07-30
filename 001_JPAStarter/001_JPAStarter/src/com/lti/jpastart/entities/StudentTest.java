package com.lti.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentTest {

	public static void main(String[] args) {
		// step 1 : obtain EntityManagerFactory object
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		// step 2 : Obtain EntityManager object
		EntityManager em = factory.createEntityManager();
		// step 3 : begin Transaction
		em.getTransaction().begin();
		// step 4 : create the bean object and persist it on the DB

		Student student = new Student();
		student.setStudentName("Zubair");
		//step 5: persist bean object in DB
		em.persist(student);
		//step 6 : commit the tx
		em.getTransaction().commit();

		System.out.println("Added one student to database.");
		//step 7: close em and em factory
		em.close();
		factory.close();
	}
}
