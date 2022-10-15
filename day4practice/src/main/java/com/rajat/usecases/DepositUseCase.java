package com.rajat.usecases;

import java.util.Scanner;

import com.rajat.dao.AccountDao;
import com.rajat.dao.AccountDaoImpl;
import com.rajat.model.Account;

public class DepositUseCase {

	public static void main(String[] args) {
		
		AccountDao dao = new AccountDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account No...");
		int accno = sc.nextInt();
		
		Account acc = dao.findAccount(accno);
		
		if(acc==null)
			System.out.println("Account does not exist...!");
		else {
			System.out.println("Enter amount to Deposit/- ");
			int amount = sc.nextInt();
			acc.setBalance(acc.getBalance()+amount);
			
			boolean b = dao.updateAccount(acc);
			
			if(b)
				System.out.println("Deposited successfully !!");
			else
				System.out.println("Failed !! please try again later !");
		}
	}

}
