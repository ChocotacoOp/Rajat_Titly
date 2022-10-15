package com.rajat.usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.rajat.model.Account;
import com.rajat.utility.EMUtil;



public class JPQL {

	public static void main(String[] args) {
		
		EntityManager em =  EMUtil.provideEntity();
		
//		String jpql = "from Account";
		String jpql = "from Account where name ='rajat'";
		
		Query q = em.createQuery(jpql);
		
		List<Account>accounts = q.getResultList();
		
		accounts.forEach(a->System.out.println(a));
		em.close();
		
	}
}
