package com.lti.jpacrud.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	static {// static block to initialize only static variable
		// invoked before object creation i.e. before constructor
		factory = Persistence
				.createEntityManagerFactory("JPA-PU");
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public static void closeEntityManager() {
		if (entityManager != null || entityManager.isOpen()) {
			entityManager.close();
			entityManager = null;
			factory.close();
		}
	}

}
