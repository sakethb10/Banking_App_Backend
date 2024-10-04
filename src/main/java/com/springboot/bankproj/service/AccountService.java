package com.springboot.bankproj.service;

import com.springboot.bankproj.dto.AccountDto;

public interface AccountService {
	public AccountDto createAccount(AccountDto dto);
	
	public AccountDto getAccount(Long id);
	
	public AccountDto deposit(Long id, Double amount);
	
	public AccountDto withdraw(Long id, Double amount);
	
	public void deleteAccount(Long id);
}
