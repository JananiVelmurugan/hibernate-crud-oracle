package com.chainsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name = "author_generator", sequenceName = "author_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "name", unique = true, length = 255)
	private String name;

	// @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	// private Set<Book> books;

	// public Set<Book> getBooks() {
	// return books;
	// }
	//
	// public void setBooks(Set<Book> books) {
	// this.books = books;
	// }

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
		return "Author [id=" + id + ", name=" + name + "]";
	}

	// @Override
	// public String toString() {
	// return "Author [id=" + id + ", name=" + name + ", books=" + books + "]";
	// }

}
