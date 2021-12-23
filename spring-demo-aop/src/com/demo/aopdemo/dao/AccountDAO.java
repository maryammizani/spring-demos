package com.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.demo.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account iAccount) {
		System.out.println(getClass() + ": Doing my DB work: Adding an account");
	}
}
