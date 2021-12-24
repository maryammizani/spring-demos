package com.demo.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean iEnableException) {
		
		// For testing purpose: Simulate an exception
		if(iEnableException) {
			throw new RuntimeException("Excpetion happened!");
		}
		List<Account> lAccounts = new ArrayList<>();
		
		// Create Sample Accounts
		Account lAccount1 = new Account("John", "Silver");
		Account lAccount2 = new Account("Mary", "Platinum");
		Account lAccount3 = new Account("Luca", "Gold");
		lAccounts.add(lAccount1);
		lAccounts.add(lAccount2);
		lAccounts.add(lAccount3);
		return lAccounts;
	}
	
	public void addAccount(Account iAccount, boolean iFlag) {
		System.out.println(getClass() + ": Doing my DB work: Adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": Doing work");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode");
		this.serviceCode = serviceCode;
	}
}
