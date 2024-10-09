package com.springboot.bankproj.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankproj.dto.CustomerDto;
import com.springboot.bankproj.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(value="/api/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="/createProfile")
	public ResponseEntity<CustomerDto> createProfile(@RequestBody CustomerDto request){
		try {
			CustomerDto newProfile=customerService.createCustomer(request);
			return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<Object> login(@RequestBody CustomerDto request) {
		Object result=customerService.validateUser(request);
		if(result!=null) {
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
		else {
			Map<String,Object> error=new HashMap<>();
			error.put("Name", null);
			error.put("Id", null);
			error.put("Result", "Failure");
			return new ResponseEntity<>(error , HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping(value="/updateProfile/{id}")
	public ResponseEntity<CustomerDto> updateProfile(@PathVariable Long id, @RequestBody CustomerDto request){
		try {
			CustomerDto updatedProfile=customerService.updateCustomer(id, request);
			return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@DeleteMapping(value="/deleteProfile/{id}")
	public ResponseEntity<String> deleteProfile(@PathVariable Long id){
		try {
			customerService.deleteCustomer(id);
			return new ResponseEntity<>("Profile "+id+" Has Been Deleted!", HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>("Profile Does Not Exist!", HttpStatus.NOT_FOUND);
		}
	}
}
