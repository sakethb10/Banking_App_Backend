package com.springboot.bankproj.service;

import com.springboot.bankproj.dto.CustomerDto;

public interface CustomerService {
	public CustomerDto createCustomer(CustomerDto dto);
	
	public CustomerDto updateCustomer(Long id, CustomerDto dto);
	
	public void deleteCustomer(Long id);
}
