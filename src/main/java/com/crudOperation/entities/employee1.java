package com.crudOperation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class employee1 {
	@Id
	@GeneratedValue
	private long empId;
	private String name;
	private String country;
	public employee1() {}
	public employee1(long empId, String name, String country) {
		super();
		this.empId = empId;
		this.name = name;
		this.country = country;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
