package com.saban.example.jpa.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class UsersTest {

	@Test
	public void test() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager em = factory.createEntityManager();
		List<Users> userList = 	em.createNamedQuery("findByUsername", Users.class).setParameter("username", "test").getResultList();
		assertEquals(1, userList.size());

		em.close();
	}

}
