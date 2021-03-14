package com.avs.hibernate.mapping.onetomany.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.avs.hibernate.mapping.onetomany.entity.Department;
import com.avs.hibernate.mapping.onetomany.entity.Employee;

public class GetOneToMany {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Department.class)
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			Department dept1 = session.get(Department.class, 112345);
			System.out.println("Checking the default first level cache ");
			//getting from the same get query runs only once ib dept1 due to hibernate first level cache [session specific]
			Department dept2 = session.get(Department.class, 112345);
			System.out.println("Department Info"+dept1);
			System.out.println();
			System.out.println("******employess of the department with first level cache**********");
			System.out.println();
			if(dept1!=null) {
				System.out.println(dept1.getEmployee());
			}
			session.getTransaction().commit();
			session.close();
			System.out.println("******second  level cache**********");
			Session session2 = sf.openSession();
			session2.beginTransaction();
			//second level ehcache implementation check
			Department secondLevelcacheDepartment = session2.get(Department.class, 112345);
			System.out.println("second level cacheDepartment Info"+secondLevelcacheDepartment);
			System.out.println();
			System.out.println("******employess of the department with secondlevel cahche*********");
			System.out.println();
			if(secondLevelcacheDepartment!=null) {
				System.out.println(secondLevelcacheDepartment.getEmployee());
			}
			session2.getTransaction().commit();
			session2.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			sf.close();
		}

	}
}
