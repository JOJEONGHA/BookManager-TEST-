package bookVO;

public class Books {
    private String booknum;
    private String title;
    private String publisher;
    private String summary;

    public Books(String booknum, String title, String publisher, String summary) {  
        this.booknum = booknum;
        this.title = title;
        this.publisher = publisher;
        this.summary = summary;
	}

	public String getBooknum() {
        return booknum;
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

    public void setBooknum(String booknum) {
        this.booknum = booknum;
    }
}
