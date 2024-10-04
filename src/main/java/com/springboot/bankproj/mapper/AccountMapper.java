package com.springboot.bankproj.mapper;

import com.springboot.bankproj.dto.AccountDto;
import com.springboot.bankproj.entities.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDto dto) {
		Account account=new Account(dto.getId(), dto.getCustomer(), dto.getBalance());
		return account;
	}
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto=new AccountDto(account.getId(), account.getCustomer(), account.getBalance());
		return accountDto;
	}
}
