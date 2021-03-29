package com.avs.hibernate.hql.app;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.avs.hibernate.hql.entiy.Student;

public class SaveVsPersistDemo {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sf.openSession();
		Session session2 = sf.openSession();
		try {
			
//			transientInsert(session);
			detachedTransaction(session,session2);
		}finally {
			session.close();
			session2.close();
			sf.close();
		}
	}
	private static void detachedTransaction(Session session,Session session2) {
		session.beginTransaction();
		Student stud = session.get(Student.class, 6);
		session.getTransaction().commit();
		session2.beginTransaction();
		stud.setEmail("student3@smail.com");
		//session.save of detached objects inserts instead of update when get set and save
//		session2.save(stud);
		//session.persist() for the detached object throws org.hibernate.PersistentObjectException: detached entity passed to persist: com.avs.hibernate.hql.entiy.Student
		session2.persist(stud);
		session2.getTransaction().commit();
	}
	private static void transientInsert(Session session) {
		Student student = new Student();
		session.beginTransaction();
		student.setEmail("student7@testmail.com");
		student.setName("student7");
		//1.Save returns the serialized value of id and it is hibernate specific
		Integer id = (Integer)session.save(student);
		System.out.println(id);
		//1.Persist is JPA method and it return void
//		session.persist(student);
		session.getTransaction().commit();
	}
}
