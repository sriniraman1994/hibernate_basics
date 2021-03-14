package com.avs.hibernate.mapping.onetomany.entity;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employee {
	private String name;
	private String role;
	@ManyToOne
	private Department dept;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", role=" + role + ", doj=" + doj + ", empId=" + empId
				+ "]";
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Temporal(TemporalType.DATE)
	private Date doj;
	@Id
	private int empId;
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public Date getDoj() {
		return doj;
	}
	public int getEmpId() {
		return empId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
}
