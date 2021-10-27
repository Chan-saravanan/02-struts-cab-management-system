package com.zoho.users;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SignUpUserAction extends ActionSupport implements ModelDriven<SignUp>{
	private final UserAccountManager userManager;
	private String actionType;
	private SignUp signupAccount;
	
	public SignUpUserAction() {
		userManager = UserAccountManager.getManager();
	}
	
	@Override
	public void validate() {
		System.out.println("Validating the signup account!");
	}
	
	public String createUser(){
		System.out.println("actionType :"+actionType);
		System.out.println(signupAccount);
		System.out.println("Inside the create user action!");
		if("submitted".equals(actionType)) {
			System.out.println("Performing the submission action!");
		}
		return SUCCESS;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public SignUp getSignupAccount() {
		return signupAccount;
	}

	public void setSignupAccount(SignUp signupAccount) {
		this.signupAccount = signupAccount;
	}
	
	@Override
	public SignUp getModel() {
		return new SignUp();
	}
}
