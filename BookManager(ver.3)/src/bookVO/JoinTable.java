package bookVO;

public class JoinTable{
    private Integer booknum;
    private String title;
    private String publisher;
    private String summary;
    private Integer authornum;
    private String authorname;
    private Integer birthyear;
    
    public JoinTable() {}
    
	public Integer getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(Integer birthyear) {
		this.birthyear = birthyear;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public Integer getAuthornum() {
		return authornum;
	}
	public void setAuthornum(Integer authornum) {
		this.authornum = authornum;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getBooknum() {
		return booknum;
	}
	public void setBooknum(Integer booknum) {
		this.booknum = booknum;
	}
}