package com.nagarro.customermanagementservice.models;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name="customermanagement")
public class CustomerManagement {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String gender;

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

	public CustomerManagement(long id, String firstName, String lastName, int age, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public CustomerManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
