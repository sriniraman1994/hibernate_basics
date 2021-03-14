package com.avs.hibernate.mapping.onetomany.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.avs.hibernate.mapping.manytomany.entity.Author;
import com.avs.hibernate.mapping.manytomany.entity.Book;
import com.avs.hibernate.mapping.onetomany.entity.Department;
import com.avs.hibernate.mapping.onetomany.entity.Employee;

public class GetQueryOneToOne {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Department.class)
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			Query q1 = session.createQuery(" from Department  where departmentId = 112345");
			q1.setCacheable(true);
			System.out.println("***************Hql first level cache******************");
			Department dept = (Department) q1.getSingleResult();
			System.out.println("dept from firstlevel cache:"+dept);
			System.out.println("employees of dept from firstlevel cache:"+dept.getEmployee());
			session.getTransaction().commit();
			session.close();
			Session session2 = sf.openSession();
			Query q2 = session2.createQuery(" from Department  where departmentId= 112345");
			q2.setCacheable(true);
			System.out.println("****************Hql second level cache**************");
			session2.beginTransaction();
			Department dept2 = (Department) q2.getSingleResult();
			System.out.println("dept from secondlevel cache:"+dept2);
			System.out.println("employees of dept from secondlevel cache:"+dept2.getEmployee());
			session2.getTransaction().commit();
			session2.close();
		}catch (Exception ex) {
			throw ex;
		}finally {
			sf.close();
		}
	}
}
