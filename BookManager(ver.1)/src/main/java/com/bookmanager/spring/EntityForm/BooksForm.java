package com.bookmanager.spring.EntityForm;

public class BooksForm {
	
	private Integer booknum;
	private	String title;
	private String publisher;
	private String summary;
	
//	(Attribute)booknum 
	public Integer getBooknum() {
		return booknum;
	}
	public void setBooknum(Integer booknum) {
		this.booknum= booknum;
	}
	
//	(Attribute)title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
//	(Attribute)publisher
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
//	(Attribute)summary
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
