package application;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
					
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int accountNumber = sc.nextInt();
			System.out.print("Holder: ");
			sc.next();
			String accountHolder = sc.nextLine();
			System.out.print("Initial balance: ");
			double accountBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(accountNumber, accountHolder, accountBalance, withdrawLimit);
			
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			double withdrawAmount = sc.nextDouble();
			
			account.withdraw(withdrawAmount);
			System.out.println(account);
			
		}
		catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Error not a number ");
		}
		
		sc.close();
	}

}
