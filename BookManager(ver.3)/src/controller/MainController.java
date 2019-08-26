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
				nextPage = "/create_C.jsp";
			}else {
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
				String temp_snum = request.getParameter("bookinfo");
				int temp_num = Integer.parseInt(temp_snum);
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
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
