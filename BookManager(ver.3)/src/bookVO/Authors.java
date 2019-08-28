package bookVO;

public class Authors {
	private String authornum;
    private String authorname;
    private String birthyear;
    
    public Authors(String authorname, String birthyear) {
    	this.authorname = authorname;
    	this.birthyear = birthyear;
    }
    
    public String getAuthornum() {
        return authornum;
    }

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

    public void setAuthornum(String authornum) {
        this.authornum = authornum;
    }
}
