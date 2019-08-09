package com.bookmanager.spring.EntityForm;

import javax.persistence.Column;
import javax.persistence.Id;

public class Pieces {
	
	@Id
	@Column(name = "booknum")
	private Integer booknum;
	@Column(name = "authornum")
	private Integer authornum;
	
//	(Attribute)BookNum
	public Integer getBooknum() {
		return booknum;
	}
	public void setBooknum(Integer booknum){
		this.booknum = booknum;
	}
	
//	(Attribute)AuthorNum
	public Integer getAuthornum() {
		return authornum;
	}
	public void setAuthornum(Integer authornum) {
		this.authornum = authornum;
	}
	
}
