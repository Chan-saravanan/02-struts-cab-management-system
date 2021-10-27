package com.zoho.users;

import java.util.ArrayList;
import java.util.List;

public class UserAccountManager {
	private final List<UserProfile> userAccountList;
	private final static UserAccountManager manager = new UserAccountManager();
	
	private UserAccountManager() {
		userAccountList = new ArrayList<>();
	}
	
	static UserAccountManager getManager(){
		return manager;
	}
	
	public List<UserProfile> getUserAccountList() {
		return userAccountList;
	}
	
	public Boolean addUser(UserProfile userProfile) {
		System.out.println("Inside the add userprofile in user profile manager!");
		return true;
	}
	
	public Boolean removeUser(String username) {
		System.out.println("Inside the remove userprofile in user profile manager!");
		return true;
	}
}
