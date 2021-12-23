package com.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addMember() {
		System.out.println(getClass() + ": Adding a membership account");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": Sleeping");
	}
}
