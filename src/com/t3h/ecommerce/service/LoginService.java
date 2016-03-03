package com.t3h.ecommerce.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.t3h.ecommerce.entity.Account;

public class LoginService {

	public String testLogin(String userName, String password) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("eElectronicSite");
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager
				.createQuery("select a from Account a where a.username=:user and a.password=:pass");
		query.setParameter("user", userName);
		query.setParameter("pass", password);
		try {
			Account account = (Account) query.getSingleResult();
			return account.getFullName();
		} catch (NoResultException ex) {
			return "Password or username not true";
		}
	}

}
