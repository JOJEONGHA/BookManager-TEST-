package com.bookmanager.spring.EntityForm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authors {
	
	@Id
	@Column(name = "authornum")
	private Integer authornum;
	@Column(name = "authorname")
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
