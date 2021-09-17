package com.nagarro.accountmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.accountmanagementservice.models.AccountManagement;

public interface AccountRepo extends JpaRepository<AccountManagement, Long> {

}
