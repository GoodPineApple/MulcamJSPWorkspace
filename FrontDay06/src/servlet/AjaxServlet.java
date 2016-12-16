package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ajax.do")
public class AjaxServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<people>");
        out.print(" <person>");
        out.print("     <name>양유진</name>");
        out.print("     <age>20</age>");
        out.print("     <addr>서울시 서대문구</addr>");
        out.print(" </person>");
        out.print(" <person>");
        out.print("     <name>홍길동</name>");
        out.print("     <age>25</age>");
        out.print("     <addr>서울시 마포구</addr>");
        out.print(" </person>");
        out.print(" <person>");
        out.print("     <name>김한빛</name>");
        out.print("     <age>30</age>");
        out.print("     <addr>제주도 서귀포시</addr>");
        out.print(" </person>");
        out.print("</people>");
	}
}
