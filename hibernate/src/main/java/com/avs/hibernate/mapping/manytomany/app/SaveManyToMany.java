package com.avs.hibernate.mapping.manytomany.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.avs.hibernate.mapping.manytomany.entity.Author;
import com.avs.hibernate.mapping.manytomany.entity.Book;

public class SaveManyToMany {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Author.class)
				.addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = sf.getCurrentSession();
		List<Author> authors ;
		List<Book> books ;
		try {
			Author author1 = new Author();
			Author author2 = new Author();
			Author author3 = new Author();
			Author author4 = new Author();
			author1.setAuthorId(1);
			author1.setName("author1");
			author2.setAuthorId(2);
			author2.setName("author2");
			author3.setAuthorId(3);
			author3.setName("author3");
			author4.setAuthorId(4);
			author4.setName("author4");
			Book book1 = new Book();
			book1.setGenre("Technical");
			book1.setIsbnNumber("Tech12345");
			book1.setTitle("Spring in Action");
			book1.setYearPublished(2020);
			authors = new ArrayList<Author>();
			authors.add(author1);
			authors.add(author2);
			book1.setAuthors(authors);
			Book book2 = new Book();
			book2.setGenre("Technical");
			book2.setIsbnNumber("Tech12346");
			book2.setTitle("Hibernate in Action");
			book2.setYearPublished(2020);
			authors = new ArrayList<Author>();
			authors.add(author1);
			authors.add(author3);
			book2.setAuthors(authors);
			Book book3 = new Book();
			book3.setGenre("Fantasy");
			book3.setIsbnNumber("Fan12345");
			book3.setTitle("Harry Porter");
			book3.setYearPublished(1995);
			authors = new ArrayList<Author>();
			authors.add(author4);
			book3.setAuthors(authors);
			books = new ArrayList<Book>();
			books.add(book1);
			books.add(book2);
			author1.setBooks(books);
			books = new ArrayList<Book>();
			books.add(book1);
			author2.setBooks(books);
			books = new ArrayList<Book>();
			books.add(book2);
			author3.setBooks(books);
			books = new ArrayList<Book>();
			books.add(book3);
			author4.setBooks(books);
			session.beginTransaction();
			session.save(author1);
			session.save(author2);
			session.save(author3);
			session.save(author4);
			session.save(book1);
			session.save(book2);
			session.save(book3);
			session.getTransaction().commit();
		}catch (Exception ex) {
			throw ex;
		}finally {
			session.close();
			sf.close();
		}
 	}
}
