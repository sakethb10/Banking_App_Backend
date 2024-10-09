package com.springboot.bankproj.dto;

import com.springboot.bankproj.entities.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
	private long id;
	
	private String password;
	
	private String name;
	
	private String dob;
	
	private String email;
	
	private Address address;
}
