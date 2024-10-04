package com.springboot.bankproj.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproj.dao.AccountDao;
import com.springboot.bankproj.dto.AccountDto;
import com.springboot.bankproj.entities.Account;
import com.springboot.bankproj.mapper.AccountMapper;
import com.springboot.bankproj.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public AccountDto createAccount(AccountDto dto) {
		Account account=AccountMapper.mapToAccount(dto);
		Account newAccount=accountDao.save(account);
		return AccountMapper.mapToAccountDto(newAccount);
	}

	@Override
	public AccountDto getAccount(Long id) throws RuntimeException{
		Account account=accountDao.findById(id).orElseThrow(()->new RuntimeException());
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, Double amount) throws RuntimeException{
		Account account=accountDao.findById(id).orElseThrow(()->new RuntimeException());
		Double currAmount=account.getBalance();
		Double newAmount=currAmount+amount;
		account.setBalance(newAmount);
		Account updatedAccount=accountDao.save(account);
		return AccountMapper.mapToAccountDto(updatedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, Double amount) throws RuntimeException{
		Account account=accountDao.findById(id).orElseThrow(()->new RuntimeException());
		Double currAmount=account.getBalance();
		Double newAmount=currAmount-amount;
		if(newAmount<0) {
			throw new RuntimeException("Insufficient Balance!");
		}
		else {
			account.setBalance(newAmount);
			Account updatedAccount=accountDao.save(account);
			return AccountMapper.mapToAccountDto(updatedAccount);
		}
	}

	@Override
	public void deleteAccount(Long id) throws RuntimeException{
		Account account=accountDao.findById(id).orElseThrow(()->new RuntimeException());
		accountDao.delete(account);
	}

}
