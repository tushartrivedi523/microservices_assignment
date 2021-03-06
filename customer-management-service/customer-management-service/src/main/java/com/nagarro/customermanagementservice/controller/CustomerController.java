package com.nagarro.customermanagementservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.customermanagementservice.models.CustomerManagement;
import com.nagarro.customermanagementservice.services.CustomerService;

@RestController
@RequestMapping("/customerManagement")
public class CustomerController {

	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/customer")
	public ResponseEntity<List<CustomerManagement>> getAllCustomers()
	{
		return new ResponseEntity<List<CustomerManagement>>(customerservice.getAllCustomer(), HttpStatus.OK);
//		return customerservice.getAllCustomer();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Optional<CustomerManagement>> getCustomerById(@PathVariable long id)
	{
		return new ResponseEntity<Optional<CustomerManagement>>(customerservice.getCustomerById(id), HttpStatus.OK);
	}
		
	@GetMapping("/customer/checkValidCustomer/{id}")
	public CustomerManagement checkValidCustomer(@PathVariable long id)
	{
		return customerservice.checkForValidCustomer(id);
	}
		
	@PostMapping("/customer")
	public void addNewCustomer(@RequestBody CustomerManagement customerToAdd)
	{
		customerservice.addNewCustomer(customerToAdd);
	}
	
	@PutMapping("/customer/{id}")
	public void updateCustomerData(@RequestBody CustomerManagement dataToUpdate, @PathVariable long id)
	{
		Optional<CustomerManagement> getData = customerservice.getCustomerById(id);
		dataToUpdate.setId(id);
		customerservice.updateCustomer(dataToUpdate);	
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomerById(@PathVariable long id)
	{
		return customerservice.deleteCustomerById(id);
	}
	
	
	
}
