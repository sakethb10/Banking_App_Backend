package com.springboot.bankproj.dto;

import com.springboot.bankproj.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDto {
	private long id;
	
	private Customer customer;
	
	private double balance;
}
