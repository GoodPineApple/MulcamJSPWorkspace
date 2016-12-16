package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;

import service.MemberService;
import sun.rmi.server.Dispatcher;
import vo.MemberVO;

@WebServlet(urlPatterns = "/member.do")
public class MemberController extends HttpServlet {

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
		String viewPath = "";
		String action = req.getParameter("action");
		MemberService service = MemberService.getInstance();

		if (action == null || action.equals("main")) {
			viewPath = "index.jsp";
		} else if (action.equals("joinForm")) {
			viewPath = "join_form.jsp";
		} else if (action.equals("join")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");

			MemberVO member = new MemberVO(id, password, name, email, gender);
			int result = service.joinMember(member);
			req.setAttribute("result", result);
			viewPath = "join_result.jsp";
		} else if (action.equals("login")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			int result = service.confirmLogin(id, password);
			if (result == 1) {
				MemberVO member = service.selectMember(id);
				String userId = member.getId();
				String name = member.getName();
				HttpSession session = req.getSession();
				session.setAttribute("name", name);
				session.setAttribute("userId", id);
			}

			req.setAttribute("result", result);
			viewPath = "login_result.jsp";
		} else if (action.equals("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
			viewPath = "logout.jsp";
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}

}
