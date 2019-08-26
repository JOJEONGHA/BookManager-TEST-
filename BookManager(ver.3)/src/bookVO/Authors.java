package bookVO;

public class Authors {
	private Integer authornum;
    private String authorname;
    private Integer birthyear;

    public Integer getAuthornum() {
        return authornum;
    }

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

    public void setAuthornum(Integer authornum) {
        this.authornum = authornum;
    }
}
