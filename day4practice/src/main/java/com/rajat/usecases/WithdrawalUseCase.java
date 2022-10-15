package com.rajat.usecases;

import java.util.Scanner;

import com.rajat.dao.AccountDao;
import com.rajat.dao.AccountDaoImpl;
import com.rajat.model.Account;

public class WithdrawalUseCase {

	public static void main(String[] args) {
		
		AccountDao dao = new AccountDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account No...");
		int accno = sc.nextInt();
		
		Account acc = dao.findAccount(accno);
		
		if(acc==null)
			System.out.println("Account does not exist...!");
		else {
			System.out.println("Enter amount --");
			int amount = sc.nextInt();
			//check user entered a negative number..
			if(amount<0) {
				System.out.println("Please Enter a valid amount...!");
			}
			//sufficient balance check
			else if(amount<=acc.getBalance()) {
			acc.setBalance(acc.getBalance()-amount);
			
			boolean b = dao.updateAccount(acc);
			if(b)
				System.out.println("please collect the cash !");
			else
				System.out.println("Transaction Failed !! please try again !");
			}
			else
				System.out.println("Insufficinet Balance !!");
		}	

	}

}
