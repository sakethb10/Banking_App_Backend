package com.springboot.bankproj.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproj.dao.AddressDao;
import com.springboot.bankproj.dao.CustomerDao;
import com.springboot.bankproj.dto.CustomerDto;
import com.springboot.bankproj.entities.Address;
import com.springboot.bankproj.entities.Customer;
import com.springboot.bankproj.mapper.CustomerMapper;
import com.springboot.bankproj.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public CustomerDto createCustomer(CustomerDto dto) throws RuntimeException{
		Address address=CustomerMapper.mapToCustomer(dto).getAddress();
		Address savedAddress=addressDao.save(address);
		Customer customer=CustomerMapper.mapToCustomer(dto);
		customer.setAddress(savedAddress);
		Customer newCustomer=customerDao.save(customer);
		if(newCustomer!=null) {
			return CustomerMapper.mapToCustomerDto(newCustomer);
		}
		else {
			throw new RuntimeException();
		}
	}

	@Override
	public CustomerDto updateCustomer(Long id, CustomerDto dto) throws RuntimeException{
		Customer customer=customerDao.findById(id).orElseThrow(()->new RuntimeException());
		if(customer.getPassword()!=dto.getPassword()&&dto.getPassword()!=null) {
			customer.setPassword(dto.getPassword());
		}
		if(customer.getName()!=dto.getName()&&dto.getName()!=null) {
			customer.setName(dto.getName());
		}
		if(customer.getDob()!=dto.getDob()&&dto.getDob()!=null) {
			customer.setDob(dto.getDob());
		}
		if(customer.getEmail()!=dto.getEmail()&&dto.getEmail()!=null) {
			customer.setEmail(dto.getEmail());
		}
		Customer updatedCustomer=customerDao.save(customer);
		return CustomerMapper.mapToCustomerDto(updatedCustomer);
	}

	@Override
	public void deleteCustomer(Long id) throws RuntimeException{
		Customer customer=customerDao.findById(id).orElseThrow(()->new RuntimeException());
		customerDao.delete(customer);
	}

	@Override
	public Object validateUser(CustomerDto dto) {
		Map<String,Object> result=new HashMap<>();
		Customer customer = customerDao.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
		if (customer != null) {
			result.put("Name", customer.getName());
			result.put("Id", customer.getId());
			result.put("Result", "Success");
			return result;
		}
		else {
			return null;
		}
	}
	
}
