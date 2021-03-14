package com.avs.hibernate.mapping.onetomany.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Department {
	@Id
	private int departmentID;
	private String name;
	public int getDepartmentID() {
		return departmentID;
	}
	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", name=" + name + "]";
	}
	public String getName() {
		return name;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public void setName(String name) {
		this.name = name;
	}
	//default is lazy fetch , for eager fetch outer join  is appended
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "dept")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	private List<Employee> employee;
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}
