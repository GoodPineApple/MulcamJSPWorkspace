package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import service.CommentService;
import vo.ArticleVO;
import vo.CommentPageVO;
import vo.ArticlePageVO;

@WebServlet(urlPatterns = "/board.do")
public class BoardController extends HttpServlet {
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
		BoardService service = BoardService.getInstance();
		CommentService commentService = CommentService.getInstance();

		if (action == null || action.equals("main")) {
			int page = 1;
			String pageStr = req.getParameter("page");
			if (pageStr != null && pageStr.length() > 0) {
				page = Integer.parseInt(pageStr);
			}

			ArticlePageVO articlePage = service.makeArticlePage(page);
			System.out.println(articlePage);
			req.setAttribute("articlePage", articlePage);
			viewPath = "board_list.jsp";
		} else if (action.equals("writeForm")) {
			viewPath = "write_form.jsp";
		} else if (action.equals("write")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			HttpSession session = req.getSession();
			String id = (String) session.getAttribute("userId");

			ArticleVO article = new ArticleVO();
			article.setTitle(title);
			article.setContent(content);
			article.setId(id);
			int result = service.write(article);
			req.setAttribute("result", result);
			viewPath = "write_result.jsp";
		} else if (action.equals("read")) {
			int articleNum = 0;
			String articleNumStr = req.getParameter("articleNum");
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			ArticleVO article = service.read(articleNum);
			
			int commentPageNum = 1;
			CommentPageVO commentPage = commentService.makePage(commentPageNum, articleNum);
			
			
			req.setAttribute("commentPage", commentPage);
			req.setAttribute("article", article);
			viewPath = "read.jsp";
		} else if (action.equals("delete")) {
			int articleNum = 0;
			String articleNumStr = req.getParameter("articleNum");
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			service.delete(articleNum);
			viewPath = "delete_result.jsp";
		} else if (action.equals("updateForm")) {
			int articleNum = 0;
			String articleNumStr = req.getParameter("articleNum");
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			ArticleVO article = service.readwithoutCount(articleNum);
			req.setAttribute("article", article);
			viewPath = "update_form.jsp";
		} else if (action.equals("update")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			int articleNum = 0;
			String articleNumStr = req.getParameter("articleNum");
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			ArticleVO article = service.readwithoutCount(articleNum);
			article.setTitle(title);
			article.setContent(content);
			int result = service.updateArticle(article);
			req.setAttribute("result", result);
			viewPath="update_result.jsp";
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
}
