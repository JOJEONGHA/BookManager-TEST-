package com.bookmanager.spring.vo;

public class BookInf {
	private String title;
	private String publisher;
	private String authorname;
	private String summary;
	
	// Setter
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	// Getter
	public String getTitle() {
		return this.title;
	}
	public String getPublisher() {
		return this.publisher;
	}
	public String getAuthorname() {
		return this.authorname;
	}
	public String getSummary() {
		return this.summary;
	}
	
	public String toString() {
		return "BookInf[title=" + title + ", publisher="+ publisher
				+ ", authorname=" + authorname +", summary="+ summary +"]";
	}
}
