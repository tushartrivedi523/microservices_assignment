package com.nagarro.customermanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.customermanagementservice.models.CustomerManagement;

public interface CustomerRepo extends JpaRepository<CustomerManagement, Long> {

}
