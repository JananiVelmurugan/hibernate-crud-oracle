package com.chainsys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
	@SequenceGenerator(name = "book_generator", sequenceName = "book_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "name")
	@NotNull
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private Author author;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
