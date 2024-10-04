package com.springboot.bankproj.mapper;

import com.springboot.bankproj.dto.CustomerDto;
import com.springboot.bankproj.entities.Customer;

public class CustomerMapper {
	public static Customer mapToCustomer(CustomerDto dto) {
		Customer customer=new Customer(dto.getId(), dto.getPassword(), dto.getName(), dto.getDob(), dto.getEmail());
		return customer;
	}
	public static CustomerDto mapToCustomerDto(Customer customer) {
		CustomerDto customerDto=new CustomerDto(customer.getId(), customer.getPassword(), customer.getName(), customer.getDob(), customer.getEmail());
		return customerDto;
	}
}
