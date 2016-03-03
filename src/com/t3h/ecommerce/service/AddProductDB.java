package com.t3h.ecommerce.service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.t3h.ecommerce.entity.EcomProduct;


public class AddProductDB {

	public void addProduct(String username,String txtDescription,String txtImage,String role){
		
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("eElectronicSite");
		EntityManager entityManager = factory.createEntityManager();
		
		EcomProduct ecomProduct=new EcomProduct();
		ecomProduct.setProductName(username);
		ecomProduct.setDescription(txtDescription);
		ecomProduct.setProductImage(txtImage);
		try{
		Integer iRole=Integer.parseInt(role);
		ecomProduct.setProductCategoryId(iRole);
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		entityManager.persist(ecomProduct);
	}
}
