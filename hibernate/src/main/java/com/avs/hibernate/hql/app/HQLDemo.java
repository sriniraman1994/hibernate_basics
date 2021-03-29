package com.avs.hibernate.hql.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.avs.hibernate.hql.entiy.Customer;

public class HQLDemo {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
		Session session = sf.openSession();
		try {
			insert(session);
			Query<Customer> query = session.createQuery("from Customer");
			System.out.println("selecting all the data");
			//getting all records.
			List<Customer> customers = query.list();
			for(Customer c:customers) {
				System.out.println(c);
			}
			System.out.println("getting single result");
			//getting single result
			Query<Customer> query2 = session.createQuery("from Customer where customerid = 1 ");
			Customer c =  query2.uniqueResult();
			System.out.println(c);
			System.out.println("getting single result with specific columns");
			//getting single result with specific cols
			Query query3 = session.createQuery("select customerName , emailAddress, phoneNumber from Customer where customerid = 1 ");
			Object[] results = (Object[]) query3.uniqueResult();
			for(Object result:results) {
				System.out.println(result);
			}
			Query query4 = session.createQuery("select customerName , emailAddress, phoneNumber from Customer");
			//adding pagination support
			query4.setFirstResult(0);
			query4.setMaxResults(1);
			
			List<Object[]> results1 = (List)query4.list();
			for(Object[]customersArray: results1) {
				System.out.println("*******************");
				System.out.println("Name"+":"+customersArray[0]);
				System.out.println("email"+":"+customersArray[1]);
				System.out.println("phone"+":"+customersArray[2]);
			}
		}catch (Exception ex) {
			throw ex;
		}finally{
			session.close();
			sf.close();
		}
	}

	private static void insert(Session session) {
		//transient state
		Customer customer1 = new Customer();
		customer1.setCustomerName("customer1");
		customer1.setEmailAddress("customer1@service.com");
		customer1.setCustomerId(1);
		customer1.setPhoneNumber(1234567890);
		//transient state
		Customer customer2 = new Customer();
		customer2.setCustomerName("customer2");
		customer2.setEmailAddress("customer2@service.com");
		customer2.setPhoneNumber(986543210);
		customer2.setCustomerId(2);
		//transient state
		Customer customer3 = new Customer();
		customer3.setCustomerName("customer3");
		customer3.setEmailAddress("customer3@service.com");
		customer3.setCustomerId(3);
		customer3.setPhoneNumber(986543210);
		session.beginTransaction();
		//attached state
		session.saveOrUpdate(customer1);
		session.saveOrUpdate(customer2);
		session.saveOrUpdate(customer3);
		session.getTransaction().commit();
		//detaxhed state
//		session.evict(customer1);
//		session.evict(customer2);
//		session.evict(customer3);
	}
}
