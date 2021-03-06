package com.nagarro.accountmanagementservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.accountmanagementservice.models.AccountManagement;
import com.nagarro.accountmanagementservice.models.CustomerManagement;
import com.nagarro.accountmanagementservice.models.CustomerNAccountManagement;
import com.nagarro.accountmanagementservice.services.AccountService;

import net.bytebuddy.implementation.bytecode.Throw;

@RestController
@RequestMapping("/accountManagement")
public class AccountController {

	@Autowired
	private AccountService accountService;

	

	@GetMapping("/accountData/{id}/addMoney/{amountToAdd}")
	private ResponseEntity<AccountManagement> addMoney(@PathVariable long id, @PathVariable int amountToAdd) 
	{
		boolean checkCustomer = accountService.checkForValidCustomer(id);
		
		if (checkCustomer == false) 
		{
			return new ResponseEntity(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		}
		
		AccountManagement accountData = accountService.addMoney(id, amountToAdd);
		
		return new ResponseEntity<AccountManagement>(accountData, HttpStatus.OK);
	}

	
	
	@GetMapping("/accountData/{id}/withdrawMoney/{amountToWithdraw}")
	private ResponseEntity<AccountManagement> withdrawMoney(@PathVariable long id, @PathVariable int amountToWithdraw) 
	{
		boolean checkCustomer = accountService.checkForValidCustomer(id);
		if (checkCustomer == false) 
		{
			return new ResponseEntity(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		}
		
		AccountManagement accountData = accountService.withdrawMoney(id, amountToWithdraw);
		
		return new ResponseEntity<AccountManagement>(accountData, HttpStatus.OK);
	}

	
	
	@GetMapping("/accountData")
	private ResponseEntity<List<AccountManagement>> getAllAccount() 
	{
		return new ResponseEntity<List<AccountManagement>>(accountService.getAllAccount(), HttpStatus.OK);
	}

	
	
	@GetMapping("/accountData/{id}")
	private ResponseEntity<CustomerNAccountManagement> getCustomerNAccountById(@PathVariable long id) 
	{
		return new ResponseEntity<CustomerNAccountManagement>(accountService.getCustomerNAccountDetailsById(id),
				HttpStatus.OK);
	}

	
	
	@DeleteMapping("/deleteAccount/{id}")
	private AccountManagement deleteAccountById(@PathVariable long id) {
		accountService.deleteAccountById(id);
		return null;
	}
	
	

}
