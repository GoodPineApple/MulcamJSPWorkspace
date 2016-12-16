package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import service.MemberService;
import vo.MemberVO;

@WebServlet(urlPatterns="/member.do")
public class MemberController extends HttpServlet {
	private MemberService service = MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		execute(req, resp);
	}
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String viewPath = "";
		
		if(action.equals("joinForm")) {
			// 회원가입 양식 보여주기
			viewPath = "join_form.jsp";
		} else if(action.equals("join")) {
			// 입력한 내용으로 회원가입 진행
			MemberVO member = new MemberVO();
			member.setId(req.getParameter("id"));
			member.setEmail(req.getParameter("email"));
			member.setName(req.getParameter("name"));
			member.setPassword(req.getParameter("password"));
			
			if(service.join(member)==true) {
				viewPath="join_success.jsp";
			} else{
				viewPath="join_fail.jsp";
			}
		} else if(action.equals("login")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			if((service.login(id, password))==true){
				HttpSession session = req.getSession();
				session.setAttribute("loginId", id);
			} else {
				req.setAttribute("loginResult", "fail");
			}
			viewPath="login_result.jsp";
		} else if(action.equals("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
			viewPath = "logout.jsp";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}

}
