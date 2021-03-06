package com.nagarro.customermanagementservice.models;


import javax.persistence.*;

@Entity
@Table(name="accountmanagement")
public class AccountManagement {

	@Id
	private long id;
	
	@Column(name="accountno")
	private String accountNo;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="branchname")
	private String branchName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public AccountManagement(long id, String accountNo, int amount, String branchName) {
		super();
		this.id = id;
		this.accountNo = accountNo;
		this.amount = amount;
		this.branchName = branchName;
	}

	public AccountManagement() {
//		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	
}
