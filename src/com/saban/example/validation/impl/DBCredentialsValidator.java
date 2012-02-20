package com.saban.example.validation.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.saban.example.jpa.model.Users;
import com.saban.example.validation.CredentialsValidator;

/**
 * An implementation of {@link CredentialsValidator} that has a JPA backing.
 * Uses "example" schema.
 */
public class DBCredentialsValidator implements CredentialsValidator {
	private static EntityManagerFactory factory;

	/**
	 * Ideally the constructor would take EntityManagerFactory as a parameter
	 * and/or have it injected into this class. This would encapsulate the
	 * "example" schema.
	 */
	public DBCredentialsValidator() {
		factory = Persistence.createEntityManagerFactory("example");
	}

	@Override
	public boolean validateCredentials(String userName, String password) {
		EntityManager entityManager = factory.createEntityManager();

		List<Users> userList = entityManager
				.createNamedQuery("findByUsernameAndPassword", Users.class)
				.setParameter("username", userName)
				.setParameter("password", password).getResultList();
		
		// need to prevent any resource leaks. Would have preferred
		// to do this using some container such as EJB automatically.
		entityManager.close();
		return !userList.isEmpty();
	}

	@Override
	public boolean validateUserName(String userName) {
		EntityManager entityManager = factory.createEntityManager();

		List<Users> userList = entityManager
				.createNamedQuery("findByUsername", Users.class)
				.setParameter("username", userName).getResultList();
		
		// need to prevent any resource leaks. Would have preferred
		// to do this using some container such as EJB automatically.
		entityManager.close();
		return !userList.isEmpty();
	}

}
