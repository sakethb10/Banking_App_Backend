package com.springboot.bankproj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bankproj.entities.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long>{

}
