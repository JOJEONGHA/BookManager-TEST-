package bookVO;

public class JoinTable{
    private String booknum;
    private String title;
    private String publisher;
    private String summary;
    private String authornum;
    private String authorname;
    private String birthyear;
    
    public JoinTable() {}
    
	public String getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getAuthornum() {
		return authornum;
	}
	public void setAuthornum(String authornum) {
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
	public String getBooknum() {
		return booknum;
	}
	public void setBooknum(String booknum) {
		this.booknum = booknum;
	}
}