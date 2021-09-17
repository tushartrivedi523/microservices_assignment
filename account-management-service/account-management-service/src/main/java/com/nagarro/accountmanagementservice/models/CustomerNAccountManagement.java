package com.nagarro.accountmanagementservice.models;


public class CustomerNAccountManagement {


	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String gender;	

	private String accountNo;

	private int amount;
	

	private String branchName;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public CustomerNAccountManagement(long id, String firstName, String lastName, int age, String gender,
			String accountNo, int amount, String branchName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.accountNo = accountNo;
		this.amount = amount;
		this.branchName = branchName;
	}


	public CustomerNAccountManagement() {
		// TODO Auto-generated constructor stub
	}
	
	
}

