package com.avs.hibernate.mapping.onetoone.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Aadhar {
	@Id
	private long aadharNumber;
	private String name;
	private String address;
	private int phone;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@OneToOne
	private Voter voter;
	public long getAadharNumber() {
		return aadharNumber;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Voter getVoter() {
		return voter;
	}
	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	
}
