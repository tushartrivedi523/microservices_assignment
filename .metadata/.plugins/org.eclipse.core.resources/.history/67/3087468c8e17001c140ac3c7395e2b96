package com.nagarro.accountmanagementservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.accountmanagementservice.models.AccountManagement;
import com.nagarro.accountmanagementservice.models.CustomerManagement;
import com.nagarro.accountmanagementservice.models.CustomerNAccountManagement;
import com.nagarro.accountmanagementservice.repository.AccountRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private RestTemplate restTemplate;

	public AccountManagement addMoney(long id, int amountToUpdated) 
	{
		List<AccountManagement> allAccountData = accountRepo.findAll();

		for (AccountManagement accountData : allAccountData)
		{
			if (accountData.getId() == id) 
			{
				accountData.setAmount(accountData.getAmount() + amountToUpdated);
				accountRepo.save(accountData);
				return accountData;
			}
		}
		return null;
	}

	
	
	public AccountManagement withdrawMoney(long id, int amountToUpdated)
	{
		List<AccountManagement> allAccountData = accountRepo.findAll();

		for (AccountManagement accountData : allAccountData)
		{
			if (accountData.getId() == id)
			{
				if (accountData.getAmount() - amountToUpdated < 0) 
				{
					return null;
				}
				accountData.setAmount(accountData.getAmount() - amountToUpdated);
				accountRepo.save(accountData);
				return accountData;
			}
		}
		return null;
	}

	
	
	@HystrixCommand(fallbackMethod = "getCustomerNAccountDetailsById_fallback")
	public CustomerNAccountManagement getCustomerNAccountDetailsById(long id) 
	{
		CustomerNAccountManagement detail = restTemplate.getForObject(
				"http://customer-management-service/customerManagement/customer/" + id,
				CustomerNAccountManagement.class);

		List<AccountManagement> allAccountData = accountRepo.findAll();

		for (AccountManagement accountData : allAccountData) 
		{
			if (accountData.getId() == id) 
			{
				detail.setAccountNo(accountData.getAccountNo());
				detail.setAmount(accountData.getAmount());
				detail.setBranchName(accountData.getBranchName());
			}
		}
		return detail;
	}
	
	

	public CustomerNAccountManagement getCustomerNAccountDetailsById_fallback(long id) 
	{
		CustomerNAccountManagement detail = new CustomerNAccountManagement();
		List<AccountManagement> allAccountData = accountRepo.findAll();

		for (AccountManagement accountData : allAccountData) 
		{
			if (accountData.getId() == id)
			{
				detail.setAccountNo(accountData.getAccountNo());
				detail.setAmount(accountData.getAmount());
				detail.setBranchName(accountData.getBranchName());
			}
		}
		return detail;
	}

	
	
	public List<AccountManagement> getAllAccount() 
	{
		return accountRepo.findAll();
	}


	
	@HystrixCommand(fallbackMethod="checkForValidCustomer_fallback")
	public boolean checkForValidCustomer(long id)
	{
		CustomerManagement customerValid = restTemplate.getForObject(
				"http://customer-management-service/customerManagement/customer/checkValidCustomer/" + id,
				CustomerManagement.class);
		if(customerValid == null)
		{
			return false;
		}
		return true;
	}
	
	
	
	public boolean checkForValidCustomer_fallback(long id)
	{
		return false;
	}
	

	
	public void deleteAccountById(long id) 
	{
		accountRepo.deleteById(id);
	}
	

}
