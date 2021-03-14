package com.avs.hibernate.mapping.onetoone.app;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.avs.hibernate.mapping.onetoone.entity.Aadhar;
import com.avs.hibernate.mapping.onetoone.entity.Voter;

public class SaveOneToOne {
	public static void main(String[] args)  {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Aadhar.class)
				.addAnnotatedClass(Voter.class).buildSessionFactory();
		try {
			Session session = sf.getCurrentSession();
			Voter voter1 = new Voter();
			voter1.setVoterId("INTN0001");
			voter1.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1994-01-01"));
			voter1.setElectoralConstituency("salem");
			voter1.setGender("male");
			voter1.setName("testvoter");
			Aadhar aadhar1 = new Aadhar();
			aadhar1.setAadharNumber(Long.parseLong("12345678090"));
			aadhar1.setAddress("no.000 ,testplace,testcity,teststate,testcountry");
			aadhar1.setEmail("test1@testmail.com");
			aadhar1.setName("testvoter");
			aadhar1.setPhone(1234567890);
			aadhar1.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1994-01-01"));
			voter1.setAadhar(aadhar1);
			aadhar1.setVoter(voter1);
			session.beginTransaction();
			session.save(voter1);
			session.save(aadhar1);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sf.close();
		}
		
	}

}
