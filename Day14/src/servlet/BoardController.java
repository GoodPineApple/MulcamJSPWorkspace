package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//C Controller
@WebServlet(urlPatterns="/board.do")
public class BoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	//doGet이랑 doPost는 오버라이딩이고 아래의 execute는 임의 지정
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String viewPath = "";
		
		System.out.println("test");
		if(action==null || action.equals("main")) {
			request.setAttribute("articlePage", "게시글 목록 데이터");
			viewPath = "main.jsp";
		} else if(action.equals("writeForm")) {
			viewPath = "write_Form.jsp";
		} else if(action.equals("write")) {
			request.setAttribute("writeResult", "글쓰기 수행 결과 데이터");
			viewPath = "write_result.jsp";
		}
		
		//선택된 JSP뷰에게 forward 하기
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
