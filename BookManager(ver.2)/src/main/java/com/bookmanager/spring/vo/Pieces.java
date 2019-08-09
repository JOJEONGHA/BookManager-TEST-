package com.bookmanager.spring.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "pieces")
public class Pieces {
	@Id
	@GeneratedValue
	@Column(name = "piecenum")
	private Integer piecenum;

	@Column(name = "authornum")
	private Integer authornum;

	@Column(name = "booknum")
	private Integer booknum;

	@ManyToOne(targetEntity = Books.class)//, fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "booknum", insertable = false, updatable = false)
	private Books books;

	@ManyToOne(targetEntity = Authors.class)//, fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "authornum", insertable = false, updatable = false)
	private Authors authors;
	
	@Override
	public String toString() {
		return "Pieces [booknum=" + booknum + ", authornum=" + authornum + 
				", piecenum ="+ piecenum +"]";
	}
	
//	(Attribute)BookNum
	public Integer getPiecenum() {
		return piecenum;
	}

	public void setPiecenum(Integer piecenum) {
		this.piecenum = piecenum;
	}

//	(Attribute)BookNum
	public Integer getBooknum() {
		return booknum;
	}

	public void setBooknum(Integer booknum) {
		this.booknum = booknum;
	}

//	(Attribute)AuthorNum
	public Integer getAuthornum() {
		return authornum;
	}

	public void setAuthornum(Integer authornum) {
		this.authornum = authornum;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Authors getAuthors() {
		return authors;
	}

	public void setAuthors(Authors authors) {
		this.authors = authors;
	}
}
