package com.springboot.bankproj.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.bankproj.entities.Account;

@Repository
public interface AccountDao extends JpaRepository<Account,Long>{
	@Query("SELECT COUNT(a) FROM Account a WHERE a.customer.id=:id")
	public Integer checkExisting(Long id);

	@Query("SELECT a FROM Account a WHERE a.customer.id=:id")
	public Account findByCid(Long id);
	
}
