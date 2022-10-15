package com.rajat.usecases;

import java.util.Scanner;

import com.rajat.dao.AccountDao;
import com.rajat.dao.AccountDaoImpl;
import com.rajat.model.Account;

public class CreateUseCase {

	public static void main(String[] args) {
		
		
		AccountDao dao = new AccountDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the account holder.. ");
		String str = sc.next();
		
		System.out.println("Enter the balance you want to enter in your account..");
		int amount = sc.nextInt();
		
		Account account = new Account();
		account.setName(str);
		account.setBalance(amount);
		
		boolean b = dao.createAccount(account);
		
		if(b)
			System.out.println("Account created successfully !!");
		else
			System.out.println("Account create failed !");
	}
}
