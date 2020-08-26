package com.example.redis.sampleapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.sampleapplication.dao.AccountDao;
import com.example.redis.sampleapplication.entity.Account;

@RestController
public class AccountController {
	
	@Autowired
	AccountDao accountDao;

	@Cacheable(value="accounts" ,key = "#accountId")
	@GetMapping("/account/{accountId}")
	public Account getAccount(@PathVariable int accountId) {
		System.out.println("Get Accounts "+accountId);
		return accountDao.getAccount(accountId);
	}
	
	@Cacheable(value="accounts")
	@GetMapping("/account/all")
	public List<Account> getAccounts() {
		System.out.println("Get All Accounts");
		return accountDao.getAll();
	}
	
	@CachePut(value="accounts" ,key = "#account.getId()")
	@PutMapping("/account/{accountId}")
	public void updateAccount(@RequestBody Account account) {
		System.out.println("Update Account");
		accountDao.updateAccount(account);
	}
	
	@CacheEvict(value="accounts" ,key = "#accountId")
	@DeleteMapping("/account/{accountId}")
	public void deleteAccount(@PathVariable int accountId) {
		System.out.println("delete Account");
		accountDao.deleteAccount(accountId);
	}
}
