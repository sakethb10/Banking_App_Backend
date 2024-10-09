package com.springboot.bankproj.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="cust_pass")
	private String password;
	
	@Column(name="customer_name")
	private String name;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="email")
	private String email;
	
	@OneToOne
	@JoinColumn(name="addr_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Address address;
}
