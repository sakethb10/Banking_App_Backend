package com.springboot.bankproj.controllers;

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

import com.springboot.bankproj.dto.AccountDto;
import com.springboot.bankproj.service.AccountService;

@RestController
@RequestMapping(value="/api/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value="/createAccount")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto request){
		AccountDto newAccount=accountService.createAccount(request);
		return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getAccount/{id}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable Long id){
		try {
			AccountDto account=accountService.getAccount(id);
			return new ResponseEntity<>(account, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
		}
	}
	
	@PutMapping(value="/deposit/{id}/{amount}")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @PathVariable Double amount){
		try {
			AccountDto account=accountService.deposit(id, amount);
			return new ResponseEntity<>(account, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/withdraw/{id}/{amount}")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @PathVariable Double amount){
		try {
			AccountDto account=accountService.withdraw(id, amount);
			return new ResponseEntity<>(account, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping (value="/deleteAccount/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable long id){
		try {
			accountService.deleteAccount(id);
			return new ResponseEntity<>("Account "+id+" Removed Successfully!", HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>("Account Not Found!", HttpStatus.NOT_FOUND);
		}
	}
}
