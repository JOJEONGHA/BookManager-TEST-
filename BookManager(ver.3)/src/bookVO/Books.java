package bookVO;

public class Books {
    private Integer booknum;
    private String title;
    private String publisher;
    private String summary;

    public Integer getBooknum() {
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

    public void setBooknum(Integer booknum) {
        this.booknum = booknum;
    }
}
