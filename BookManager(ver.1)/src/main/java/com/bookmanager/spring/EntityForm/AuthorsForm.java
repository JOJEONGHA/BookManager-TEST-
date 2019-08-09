package com.bookmanager.spring.EntityForm;

public class AuthorsForm {
	
	private Integer authornum;
	private String authorname;
	
//	(Attribute)AuthorNum
	public Integer getAuthornum() {
		return authornum;
	}
	public void setAuthornum(Integer authornum) {
		this.authornum = authornum;
	}
	
//	(Attribute)AuthorName
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname){
		this.authorname = authorname;
	}
}
