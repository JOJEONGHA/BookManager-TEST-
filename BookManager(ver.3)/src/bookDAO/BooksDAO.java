package bookDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import bookVO.Authors;
import bookVO.Books;
import bookVO.JoinTable;

public class BooksDAO {
    private Connection con;
	private PreparedStatement pstmt;
    private DataSource dataFactory;

	public BooksDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/mariaDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	// (info_UD - 선택한 책 정보)
    public JoinTable bookInfo(String num) {
    	JoinTable info = new JoinTable();
    	
    	List<JoinTable> list = new ArrayList<JoinTable>();
    	list = listBooks();
    	// 글쓴이 수정하는 거는 복수개가 들어가므로 신경써야한다.
    	for(JoinTable i : list) {
    		if(i.getBooknum().equals(num)) {
    			info = i;
    			break;
    		}
    	}
    	return info;
    }
	
    // (Main - 책 리스트)
    public List<JoinTable> listBooks(){
        List<JoinTable> list = new ArrayList<JoinTable>();
        try {
            con = dataFactory.getConnection();
            String query = "SELECT * "
					+ "FROM books b "
					+ "INNER JOIN pieces p ON b.booknum = p.booknum "
                    + "inner join authors a on p.authornum = a.authornum "
                    + "order by b.title desc";
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
				String booknum = rs.getString("booknum");
                String title = rs.getString("title");
                String authorname = rs.getString("authorname");
                String publisher = rs.getString("publisher");
                String summary = rs.getString("summary");
                String authornum = rs.getString("authornum");
                String birthyear = rs.getString("birthyear");
                JoinTable jt = new JoinTable();
                
                // Same authors catch
                while(true){
                    boolean switch_ = rs.next();
                    
                    if(switch_ == true) {
                    	String temp = rs.getString("booknum");
                    	if(booknum == temp)
                            authorname += ", " + rs.getString("authorname");
                        else{
                            rs.previous();
                            System.out.println("test");
                            break;
                        }
                    }else {
                    	
                    	System.out.println("test");
                    	break;
                    }
                    
                }
                System.out.println("test");
                jt.setBooknum(booknum);
                jt.setTitle(title);
                jt.setAuthorname(authorname);
                jt.setPublisher(publisher);
                jt.setSummary(summary);
                jt.setAuthornum(authornum);
                jt.setBirthyear(birthyear);
				list.add(jt);
			}
			rs.close();
			pstmt.close();
			con.close();
        } catch (SQLException e) {
            e.printStackTrace();
		}
        return list;
    }
    
    // (create_C - 책 추가 시 일련번호 생성)
    public String firstCreate() {
    	Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyMMddhhmmss");
		String now = date.format(today);
		// book code is start 01-
        String booknum = "01-" + now;
        
        return booknum;
    }
    
    // (enroll_C - 같은 이름,생일 가진 작가 유무 판단 후 없으면 db에 추가)
    public boolean checkAuthor(Authors a) {
    	String temp_name = a.getAuthorname();
    	String temp_birth = a.getBirthyear();
    	String query = "SELECT * FROM authors WHERE authorname= '" 
    					+ temp_name + "' and birthyear= '" 
    					+ temp_birth + "'";
    	
    	try {
    		con = dataFactory.getConnection();
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() == true) 
				return false;
			
			// Authors Code Setting
			// Authors code is start 00-
			Date today = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyMMddhhmmss");
			String now = date.format(today);
			String authornum = "00-"+now;

			// Add Author into DB
			query = "INSERT INTO authors ";
			query += " (authornum,authorname,birthyear)";
			query += " values(?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, authornum);
			pstmt.setString(2, temp_name);
			pstmt.setString(3, temp_birth);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    	return true;
    }
    
    public void createBooks(JoinTable jt) {
   	    try {
			con = dataFactory.getConnection();
			String query = "";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
                
    }
}