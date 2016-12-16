package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Book;

@WebServlet("/book.do")
public class BookController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b = new Book("JSP 프로그래밍", "양유진", 30000);
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(b);
		
		request.setAttribute("book", b);
		request.setAttribute("bookList", bookList);
		
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("test02.jsp");
		dispatcher.forward(request, response);
	}
}
















