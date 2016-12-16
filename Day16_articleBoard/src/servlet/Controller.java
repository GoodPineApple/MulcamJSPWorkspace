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

import dao.ArticleDAO;
import service.ArticleService;
import vo.ArticleVO;
import vo.PageVO;

@WebServlet(urlPatterns="/board.do")
public class Controller extends HttpServlet{
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
		ArticleDAO dao = ArticleDAO.getInstance();
		ArticleService service = ArticleService.getInstance();
		
		if(action == null || action.equals("main")) {
			String pageStr = req.getParameter("page");
			int page = 1;
			if(pageStr != null && pageStr.length()>0) {
				page = Integer.parseInt(pageStr);
			}
			PageVO articlePage = service.makePage(page);
			req.setAttribute("articlePage", articlePage);
			viewPath = "boardList.jsp";
		} else if(action.equals("write")){
			viewPath = "write_form.jsp";
		} else if(action.equals("writeForm")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			String password = req.getParameter("password");
			
			ArticleVO writeArticle = new ArticleVO();
			writeArticle.setTitle(title);
			writeArticle.setContent(content);
			writeArticle.setWriter(writer);
			writeArticle.setPassword(password);
			
			int result = dao.insert(writeArticle);
			req.setAttribute("result", result);
			viewPath = "write_result.jsp";
		} else if(action.equals("read")){
			String articleIdStr = req.getParameter("articleId");
			int articleId =0;
			if(articleIdStr != null && articleIdStr.length() > 0) {
				articleId = Integer.parseInt(articleIdStr);
			}
			ArticleVO article = dao.selectArticle(articleId);
			service.upperReadCount(article);
			req.setAttribute("article", article);
			viewPath = "read.jsp";
		} else if(action.equals("toconfirmPassword")){
			String articleIdStr = req.getParameter("articleId");
			int articleId =0;
			if(articleIdStr != null && articleIdStr.length() > 0) {
				articleId = Integer.parseInt(articleIdStr);
			}
			String type = req.getParameter("type");
			viewPath = "confirmPassword.jsp";
			req.setAttribute("type", type);
			req.setAttribute("articleId", articleId);
		} else if(action.equals("confirmPassword")){
			String articleIdStr = req.getParameter("articleId");
			System.out.println(articleIdStr);
			int articleId =0;
			if(articleIdStr != null && articleIdStr.length() > 0) {
				articleId = Integer.parseInt(articleIdStr);
			}
			ArticleVO original = dao.selectArticle(articleId);
			String userPassword = req.getParameter("password");
			String originalPassword = original.getPassword();
			
			int flag = service.checkPassword(userPassword, originalPassword);
			if(flag != 1) { 
				viewPath = "password_default.jsp";
			} else{
				String type = req.getParameter("type");
				System.out.println(type);
				if(type.equals("delete")){
					req.setAttribute("articleId", articleId);
					int result = service.delete(articleId);
					System.out.println(result);
					req.setAttribute("result", result);
					viewPath = "delete_result.jsp";
				} else if(type.equals("update")) {
					req.setAttribute("articleId", articleId);
					viewPath = "update_form.jsp";					
				}
				req.setAttribute("original", original.getArticleId());
			}
		} else if(action.equals("updateResult")){
			String articleIdStr = req.getParameter("articleId");
			int articleId =0;
			if(articleIdStr != null && articleIdStr.length() > 0) {
				articleId = Integer.parseInt(articleIdStr);
			}
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			String password = req.getParameter("password");
			
			ArticleVO updateArticle = dao.selectArticle(articleId);
			updateArticle.setArticleId(articleId);
			updateArticle.setTitle(title);
			updateArticle.setContent(content);
			updateArticle.setWriter(writer);
			updateArticle.setPassword(password);
			
			int result = dao.updateArticle(updateArticle);
			req.setAttribute("result", result);
			viewPath = "write_result.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
}
