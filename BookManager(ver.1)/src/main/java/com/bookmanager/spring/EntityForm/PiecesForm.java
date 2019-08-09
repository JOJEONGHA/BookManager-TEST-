package com.bookmanager.spring.EntityForm;

public class PiecesForm {
	
	private Integer booknum;
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
