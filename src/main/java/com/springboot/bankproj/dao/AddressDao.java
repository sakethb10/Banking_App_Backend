package com.springboot.bankproj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bankproj.entities.Address;

public interface AddressDao extends JpaRepository<Address,Long>{

}
