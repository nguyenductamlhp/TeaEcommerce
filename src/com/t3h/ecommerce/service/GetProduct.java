package com.t3h.ecommerce.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.t3h.ecommerce.entity.Account;
import com.t3h.ecommerce.entity.EcomProduct;

public class GetProduct {
	public List<EcomProduct> getProduct(int id) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("eElectronicSite");
		EntityManager entityManager = factory.createEntityManager();
		Query query;
		if(id==-1){
			query=entityManager.createQuery("select a from EcomProduct a");
		}else{
			query=entityManager.createQuery("select a from EcomProduct a where a.id=:idinput");
			query.setParameter("idinput", id);
		}
		List<EcomProduct> ecomProducts=query.getResultList();
		return ecomProducts;
	}
}
