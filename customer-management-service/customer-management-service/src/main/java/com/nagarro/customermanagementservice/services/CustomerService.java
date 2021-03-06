package com.nagarro.customermanagementservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.customermanagementservice.models.AccountManagement;
import com.nagarro.customermanagementservice.models.CustomerManagement;
import com.nagarro.customermanagementservice.repository.CustomerRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<CustomerManagement> getAllCustomer()
	{
		return customerRepo.findAll();
	}
	
	public void addNewCustomer(CustomerManagement customerDataToAdd)
	{
		customerDataToAdd.setId((long)(Math.random()*(99999-10000+1)+10000));
		customerRepo.save(customerDataToAdd);
	}

	public void updateCustomer(CustomerManagement customerDataToUpdate)
	{
		customerRepo.save(customerDataToUpdate);
	}
	public Optional<CustomerManagement> getCustomerById(long id)
	{
		return customerRepo.findById(id);
	}
	
	public CustomerManagement checkForValidCustomer(long id)
	{
		List<CustomerManagement> getAllCustomer = customerRepo.findAll();
		for(CustomerManagement getCustomer: getAllCustomer)
		{
			if(getCustomer.getId()==id)
			{
				return getCustomer ;
			}
		}
		return null;
	}
	
	public void updateDetailsOfCustomer(CustomerManagement customerDataToUpdate)
	{
		customerRepo.save(customerDataToUpdate);
	}
	
	@HystrixCommand(fallbackMethod="deleteCustomerById_fallback")
	public String deleteCustomerById(long id)
	{
		restTemplate.delete("http://account-management-service/accountManagement/deleteAccount/"+id);
		customerRepo.deleteById(id);
		return "Data Deleted!";
	}
	
	public String deleteCustomerById_fallback(long id)
	{
		return "Account Service Down due to some reason, try again after some time!";
	}
	
	
	
	
}
