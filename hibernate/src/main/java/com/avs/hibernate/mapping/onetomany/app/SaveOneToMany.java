package com.avs.hibernate.mapping.onetomany.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.avs.hibernate.mapping.onetomany.entity.Department;
import com.avs.hibernate.mapping.onetomany.entity.Employee;

public class SaveOneToMany {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Department.class)
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		try {
			Session session = sf.getCurrentSession();
			List<Employee> empList = new ArrayList<Employee>();
			Department d1 = new Department();
			d1.setName("HR");
			d1.setDepartmentID(112345);
			Employee e1 = new Employee();
			Employee e2 = new Employee();
			Employee e3 = new Employee();
			Employee e4 = new Employee();
			e1.setEmpId(123);
			e1.setName("TestEmp1");
			e1.setRole("Associate");
			e1.setDoj(new SimpleDateFormat("yyyy/MM/dd").parse("2016/01/01"));
			e1.setDept(d1);
			e2.setEmpId(345);
			e2.setName("TestEmp2");
			e2.setRole("Associate");
			e2.setDoj(new SimpleDateFormat("yyyy/MM/dd").parse("2016/01/01"));
			e2.setDept(d1);
			e3.setEmpId(567);
			e3.setName("TestEmp3");
			e3.setRole("Associate");
			e3.setDoj(new SimpleDateFormat("yyyy/MM/dd").parse("2016/01/01"));
			e3.setDept(d1);
			e4.setEmpId(001);
			e4.setName("TestEmp0");
			e4.setRole("Manager");
			e4.setDoj(new SimpleDateFormat("yyyy/MM/dd").parse("2015/01/01"));
			e4.setDept(d1);
			empList.add(e1);
			empList.add(e2);
			empList.add(e3);
			empList.add(e4);
			d1.setEmployee(empList);
			session.beginTransaction();
			session.save(e4);
			session.save(e2);
			session.save(e1);
			session.save(e3);
			session.save(d1);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sf.close();
		}
	}
}
