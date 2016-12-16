package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.MemberVO;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private MemberService service = MemberService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// URL�� �ƴ� post ��Ŀ����� �ѱ� ���ڵ��� �ʿ��� �� ����.
		req.setCharacterEncoding("UTF-8");
		execute(req, resp);
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// action �Ķ���ͷ� ��û�� ������ �ľ�
		String action = request.getParameter("action");
		String viewPath = "";
		
		if(action.equals("index") || action == null) {
			viewPath = "index.jsp";
		} else if (action.equals("join")) {
			// �Է��� �������� ȸ������ ����
			MemberVO member = new MemberVO();
			member.setId(request.getParameter("id"));
			member.setEmail(request.getParameter("email"));
			member.setName(request.getParameter("username"));
			member.setPassword(request.getParameter("password"));

			if (service.join(member) == true) {
				viewPath = "index.jsp";
			} else {
				viewPath = "default.jsp";
			}
		} else if (action.equals("login")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String RememberId = request.getParameter("remember");
			boolean login_flag = service.login(id, password);
			if (login_flag == true) {
				HttpSession session = request.getSession();
				session.setAttribute("loginId", id);
				System.out.println("test:"+RememberId);
				if(RememberId != null) {
					session.setAttribute("rememberId", id);
				}
				viewPath = "main.jsp";
			} else if(login_flag == false){
				request.setAttribute("login_flag", "false");
				viewPath = "index.jsp";
			}
		} else if (action.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			viewPath = "logout.jsp";
		} else if (action.equals("forgotId")) {
			System.out.println("test");
			viewPath = "FindId.jsp";
		} else if (action.equals("forgotPassword")) {
			viewPath = "FindPassword.jsp";
		} else if(action.equals("findId")){
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			boolean idFlag = service.confirmEmail(name, email);
			if(idFlag == true) {
				request.setAttribute("idFlag", idFlag);
				String findedId = service.findId(email);
				request.setAttribute("name", name);
				request.setAttribute("findedId", findedId);
			} else if(idFlag == false) {
				request.setAttribute("idFlag", idFlag);
			}
			viewPath = "FindId.jsp";
		}
		
		// �ڹ� ������ �۾��� �������� jsp���� forward �ϱ�
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
