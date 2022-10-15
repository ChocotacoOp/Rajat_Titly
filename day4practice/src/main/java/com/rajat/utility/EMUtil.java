package com.rajat.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
	
	private static EntityManagerFactory emf; //private variable 
	
	static {
		emf =Persistence.createEntityManagerFactory("account-unit"); // inside static block to load in the memory once the program executed 
	}
	
	public static EntityManager provideEntity() {
		
//		EntityManager em = emf.createEntityManager();
//		return em;
		
		
		return emf.createEntityManager();
	}


}
