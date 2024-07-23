package com.zettamine.hibernate.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "EMPLOYEE")
@Data
public class Employee {
	@Id
	@Column(name = "EMP_ID")
	private Integer employeeId;
	
	@Column(name = "NAME")
	private String employeeName;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@OneToOne(cascade = CascadeType.PERSIST)
	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JoinColumn(name = "ADDRESS_ID")
	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDR_ID")
	private Address address;
}
