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

		}
		//(main - Load all book list)
		else if (action.equals("/List.do")) {
			List<JoinTable> booksList = dao.listBooks();
			request.setAttribute("booksList", booksList);
			nextPage = "/main_LS.jsp";
		}
		//(info - book information update & delete)
		else if(action.equals("/Update.do")){

		}
		//(enroll - Author enroll)
		else if(action.equals("/Enroll.do")){

		}
		//(all page - back to main(list))
		else if(action.equals("/Back.do") || action == ""){

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
