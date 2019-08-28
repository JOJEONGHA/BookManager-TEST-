package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookDAO.BooksDAO;
import bookVO.Authors;
import bookVO.JoinTable;

@WebServlet("/controller/*")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BooksDAO dao = new BooksDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();	// URL name of request

		//(Main - create new book)
		if(action.equals("/Create_Book.do")){
			String visit = request.getParameter("btn_create");
			// First visit and Direct visit(URL)
			if(visit.equals("first_visit") || visit.equals(null)) {
				String booknum = dao.firstCreate();
				request.setAttribute("booknum", booknum);
				nextPage = "/create_C.jsp";
			}else {
				String booknum = request.getParameter("Bnum_info");
				String title = request.getParameter("Bname_info");
				String author = request.getParameter("Bauth_info");
				String publisher = request.getParameter("Bpub_info");
				String summary = request.getParameter("Binf_info");
				JoinTable temp = new JoinTable();
				temp.setBooknum(booknum);
				temp.setTitle(title);
				temp.setAuthorname(author);
				temp.setPublisher(publisher);
				temp.setSummary(summary);
				//temp.setAuthornum(authornum);
				//temp.setBirthyear(birthyear);
				
				dao.createBooks(temp);
				nextPage = "/main_LS.jsp";
			}
		}
		//(main - Load all book list)
		else if (action.equals("/List.do")) {
			List<JoinTable> booksList = dao.listBooks();
			request.setAttribute("booksList", booksList);
			nextPage = "/main_LS.jsp";
		}
		//(info - book information update & delete)
		else if(action.equals("/update.do")){
			// View Button Click Action
			if(request.getParameter("btnInfo").equals("view")) {
				String temp_num = request.getParameter("bookinfo");
				JoinTable temp = dao.bookInfo(temp_num);
				request.setAttribute("bookInfo", temp);
				nextPage = "/info_UD.jsp";
			}
		}
		//(enroll - Author enroll)
		else if(action.equals("/Enroll.do")){
			
		}
		//(all page - back to main(list))
		else if(action.equals("/Back.do") || action == ""){
			nextPage = "/main_LS.jsp";
		}
		//(createA_C - Add author)
		else if(action.equals("/CreateAuthor.do")){
			String visit = request.getParameter("btn_createA");
			String booknum = request.getParameter("booknum");
			request.setAttribute("booknum", booknum);
			if(visit.equals("first")) {
				nextPage = "/enroll_C.jsp";
			}else {
				String name = request.getParameter("name_author");
				String birthyear = request.getParameter("birth_author");
				Authors temp = new Authors(name,birthyear);
				boolean exi = dao.checkAuthor(temp);		// Add author or Exist Yes,No
				request.setAttribute("exist", exi);
				nextPage = "/create_C.jsp";
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
