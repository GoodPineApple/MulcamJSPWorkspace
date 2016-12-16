package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JavaTest01")
public class JavaTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cName = request.getParameter("clientName"); // request 받은 내용 풀기
		System.out.println("JavaTest01 서블릿이 Get방식 요청을 받음!" + cName);
		
		response.setContentType("text/html; charset=UTF-8"); // 한글처리
		PrintWriter writer = response.getWriter(); //response의 쓰기도구
		
		writer.println("<html>");
		writer.println("	<head>");
		writer.println("		<title>자바 서블릿의 응답화면</title>");
		
		writer.println("	</head>");
		writer.println("	<body>");
		writer.println("<h3>당신이 보낸 clientName 값:" + cName +"</h3>"); // <h?>태그는 헤드라인 ? 숫자에 따라 크기 결정
		
		writer.println("	</body>");
		writer.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cName = request.getParameter("clientName"); // request 받은 내용 풀기
		System.out.println("JavaTest01 서블릿이 Post방식 요청을 받음!" + cName);
		
		response.setContentType("text/html; charset=UTF-8"); // 한글처리
		
		PrintWriter writer = response.getWriter(); //response의 쓰기도구
		writer.println("<html>");
		writer.println("	<head>");
		writer.println("		<title>자바 서블릿의 응답화면</title>");
		
		writer.println("	</head>");
		writer.println("	<body>");
		writer.println("<h3>당신이 보낸 clientName 값:" + cName +"</h3>"); // <h?>태그는 헤드라인 ? 숫자에 따라 크기 결정
		
		writer.println("	</body>");
		writer.println("</html>");
	}

}
