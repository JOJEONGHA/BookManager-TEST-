package com.bookmanager.spring.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Authors {

	@Id
	@GeneratedValue
	@Column(name = "authornum")
	private Integer authornum;
	@Column(name = "authorname")
	private String authorname;
	@Column(name = "birthyear")
	private Integer birthyear;

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

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	
//	(Attribute)Birthyear
	public Integer getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(Integer birthyear) {
		this.birthyear = birthyear;
	}

	@Override
	public String toString() {
		return "Authors [authornum=" + authornum + ", authorname=" + authorname 
				+ ", birthyear="+birthyear + "]";
	}

}