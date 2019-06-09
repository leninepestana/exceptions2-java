package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
	private Integer accountNumber;
	private String accountHolder;
	private Double accountBalance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer accountNumber, String accountHolder, Double accountBalance, Double withdrawLimit) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}
	/*
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	*/
	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}
	
	/*
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	*/
	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	
	public void deposit(double depositAmount) {
		accountBalance += depositAmount;
	}
	
	public void withdraw(double withdrawAmount) {
		if (withdrawAmount > withdrawLimit ) {
			throw new DomainExceptions("Withdraw error: The amount exceeds withdraw limit");
		}
		if (withdrawAmount > accountBalance) {
			throw new DomainExceptions("Withdraw error: Not enough balance");
		}
		accountBalance -= withdrawAmount;
	}
	
	@Override
	public String toString() {
		return "New balance: "
				+ String.format("%.2f", accountBalance);
	}
	
}
