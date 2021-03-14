package com.avs.hibernate.mapping.manytomany.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	@Id
	private String isbnNumber;
	private String title;
	private String genre;
	private int yearPublished;
	@ManyToMany(mappedBy = "books" )
	private List<Author> Authors;

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public List<Author> getAuthors() {
		return Authors;
	}

	public void setAuthors(List<Author> authors) {
		Authors = authors;
	}
}
