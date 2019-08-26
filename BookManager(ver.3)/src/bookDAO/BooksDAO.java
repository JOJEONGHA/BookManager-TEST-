package bookDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
    public JoinTable bookInfo(int num) {
    	JoinTable info = new JoinTable();
    	
    	List<JoinTable> list = new ArrayList<JoinTable>();
    	list = listBooks();
    	// 글쓴이 수정하는 거는 복수개가 들어가므로 신경써야한다.
    	for(JoinTable i : list) {
    		if(i.getBooknum() == num) {
    			info = i;
    			break;
    		}
    	}
    	return info;
    }
	
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
				Integer booknum = rs.getInt("booknum");
                String title = rs.getString("title");
                String authorname = rs.getString("authorname");
                String publisher = rs.getString("publisher");
                String summary = rs.getString("summary");
                Integer authornum = rs.getInt("authornum");
                Integer birthyear = rs.getInt("birthyear");
                JoinTable jt = new JoinTable();
                
                // Same authors catch
                while(true){
                    boolean switch_ = rs.next();
                    
                    if(switch_ == true) {
                    	Integer temp = rs.getInt("booknum");
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
}