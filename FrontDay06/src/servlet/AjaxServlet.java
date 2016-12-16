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
        out.print("     <name>������</name>");
        out.print("     <age>20</age>");
        out.print("     <addr>����� ���빮��</addr>");
        out.print(" </person>");
        out.print(" <person>");
        out.print("     <name>ȫ�浿</name>");
        out.print("     <age>25</age>");
        out.print("     <addr>����� ������</addr>");
        out.print(" </person>");
        out.print(" <person>");
        out.print("     <name>���Ѻ�</name>");
        out.print("     <age>30</age>");
        out.print("     <addr>���ֵ� ��������</addr>");
        out.print(" </person>");
        out.print("</people>");
	}
}
