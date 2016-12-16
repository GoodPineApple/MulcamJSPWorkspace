package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet
public class TestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("	<title>자바로 만든 서블릿</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("이 화면은 자바로 작성된 서블릿이 만들어준");
		writer.println("html문서입니다. <br>");
		writer.println("현재시각:" + new Date());
		writer.println("<body>");
		
		writer.println("</html>");
		
		
	}
}
