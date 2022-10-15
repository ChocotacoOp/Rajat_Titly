package com.rajat.dao;

import javax.persistence.EntityManager;

import com.rajat.model.Account;
import com.rajat.utility.EMUtil;

public class AccountDaoImpl implements AccountDao{

	@Override
	public boolean createAccount(Account account) {
		boolean flag = false;
		
		EntityManager em = EMUtil.provideEntity();
		
		em.getTransaction().begin();
		em.persist(account);
		flag = true;
		em.getTransaction().commit();
		
		em.close();
		
		return flag;
	}

	@Override
	public boolean deleteAccount(int accno) {
		boolean flag = false;
		
		EntityManager em = EMUtil.provideEntity();
		Account acc = em.find(Account.class, accno);
		
		if(acc!=null) {
			em.getTransaction().begin();
			em.remove(acc);
			flag = true;
			em.getTransaction().commit();
		}
		
		return flag;
	}

	@Override
	public boolean updateAccount(Account account) {
		boolean flag = false;
		
		EntityManager em = EMUtil.provideEntity();
		Account acc = em.find(Account.class, account.getAccno());
		
		if(acc==null)
			throw new IllegalArgumentException("Invalid Account");
		else {
		em.getTransaction().begin();
		em.merge(account);
		flag = true;
		em.getTransaction().commit();
		
		}
		em.close();
		return flag;
	}

	@Override
	public Account findAccount(int accno) {
		
//		Account acc =  null;
//		EntityManager em= EMUtil.provideEntity();
//		acc = em.find(Account.class, accno);
//		return acc;
		
		//shortcut approach**********
		return EMUtil.provideEntity().find(Account.class,accno);
	}

}
