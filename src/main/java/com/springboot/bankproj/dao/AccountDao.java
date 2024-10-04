package com.springboot.bankproj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bankproj.entities.Account;

@Repository
public interface AccountDao extends JpaRepository<Account,Long>{

}
