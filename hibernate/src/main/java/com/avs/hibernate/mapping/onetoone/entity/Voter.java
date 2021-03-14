package com.avs.hibernate.mapping.onetoone.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Voter {
@Id
private String voterId;
public String getVoterId() {
	return voterId;
}
public void setVoterId(String voterId) {
	this.voterId = voterId;
}
private String electoralConstituency;
private String name;
private String gender;
@OneToOne
private Aadhar aadhar;
@Temporal(TemporalType.DATE)
private Date dob;
public String getElectoralConstituency() {
	return electoralConstituency;
}
public void setElectoralConstituency(String electoralConstituency) {
	this.electoralConstituency = electoralConstituency;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public Aadhar getAadhar() {
	return aadhar;
}
public void setAadhar(Aadhar aadhar) {
	this.aadhar = aadhar;
}

}
