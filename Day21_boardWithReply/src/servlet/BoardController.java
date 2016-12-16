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
import vo.CommentVO;
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
			viewPath = "update_result.jsp";
		} else if (action.equals("read")) {
			int articleNum = 0;
			String articleNumStr = req.getParameter("articleNum");
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			ArticleVO article = service.read(articleNum);

			int commentPageNum = 1;
			String commentPageNumStr = req.getParameter("commentPageNum");
			if (commentPageNumStr != null && commentPageNumStr.length() > 0) {
				commentPageNum = Integer.parseInt(commentPageNumStr);
			}
			CommentPageVO commentPage = commentService.makePage(commentPageNum, articleNum);

			req.setAttribute("commentPage", commentPage);
			req.setAttribute("article", article);
			viewPath = "read.jsp";
		} else if (action.equals("commentWrite")) {
			String content = req.getParameter("content");
			String articleNumStr = req.getParameter("articleNum");
			int articleNum = 0;
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			HttpSession session = req.getSession();
			String id = (String) session.getAttribute("userId");
			CommentVO comment = new CommentVO();
			comment.setContent(content);
			comment.setArticleNum(articleNum);
			comment.setId(id);
			commentService.writeComment(comment);
			viewPath = "board.do?action=readWithoutReadCount&articleNum=" + articleNum;
		} else if (action.equals("commentGood")) {
			String commentNumStr = req.getParameter("commentNum");
			String articleNumStr = req.getParameter("articleNum");
			int commentNum = 0;
			int articleNum = 0;
			if (commentNumStr != null && commentNumStr.length() > 0) {
				commentNum = Integer.parseInt(commentNumStr);
			}
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			int result = commentService.updateCommentGoodCount(commentNum);
			viewPath = "board.do?action=readWithoutReadCount&articleNum=" + articleNum;
		} else if (action.equals("commentBad")) {
			String commentNumStr = req.getParameter("commentNum");
			String articleNumStr = req.getParameter("articleNum");
			int commentNum = 0;
			int articleNum = 0;
			if (commentNumStr != null && commentNumStr.length() > 0) {
				commentNum = Integer.parseInt(commentNumStr);
			}
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			int result = commentService.updateCommentBadCount(commentNum);
			viewPath = "board.do?action=readWithoutReadCount&articleNum=" + articleNum;
		} else if (action.equals("deleteComment")) {
			String commentNumStr = req.getParameter("commentNum");
			String articleNumStr = req.getParameter("articleNum");
			int commentNum = 0;
			int articleNum = 0;
			if (commentNumStr != null && commentNumStr.length() > 0) {
				commentNum = Integer.parseInt(commentNumStr);
			}
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			commentService.deleteComment(commentNum);
			viewPath = "board.do?action=readWithoutReadCount&articleNum=" + articleNum;
		} else if (action.equals("readWithoutReadCount")) {
			int articleNum = 0;
			String articleNumStr = req.getParameter("articleNum");
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			ArticleVO article = service.readwithoutCount(articleNum);

			int commentPageNum = 1;
			String commentPageNumStr = req.getParameter("commentPageNum");
			if (commentPageNumStr != null && commentPageNumStr.length() > 0) {
				commentPageNum = Integer.parseInt(commentPageNumStr);
			}
			CommentPageVO commentPage = commentService.makePage(commentPageNum, articleNum);

			req.setAttribute("commentPage", commentPage);
			req.setAttribute("article", article);
			viewPath = "read.jsp";
		} else if (action.equals("writeReply")) {
			int articleNum = 0;
			String articleNumStr = req.getParameter("articleNum");
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			int instanceReplyGrp = 0;
			String replyGrpStr = req.getParameter("replyGrp");
			if (replyGrpStr != null && replyGrpStr.length() > 0) {
				instanceReplyGrp = Integer.parseInt(replyGrpStr);
			}
			int replyLevel = 0;
			String replyLevelStr = req.getParameter("replyLevel");
			if (replyLevelStr != null && replyLevelStr.length() > 0) {
				replyLevel = Integer.parseInt(replyLevelStr);
			}
			int replyIndex = 0;
			String replyIndexStr = req.getParameter("replyIndex");
			if (replyIndexStr != null && replyIndexStr.length() > 0) {
				replyIndex = Integer.parseInt(replyIndexStr);
			}
			ArticleVO article = new ArticleVO();
			article.setArticleNum(articleNum);
			article.setReplyGrp(instanceReplyGrp);
			article.setReplyLevel(replyLevel);
			article.setReplyIndex(replyIndex);
			req.setAttribute("article", article);
			viewPath = "write_reply_form.jsp";
		} else if (action.equals("write_reply")) {
			int articleNum = 0;
			String articleNumStr = req.getParameter("articleNum");
			if (articleNumStr != null && articleNumStr.length() > 0) {
				articleNum = Integer.parseInt(articleNumStr);
			}
			int replyGrp = 0;
			String replyGrpStr = req.getParameter("replyGrp");
			if (replyGrpStr != null && replyGrpStr.length() > 0) {
				replyGrp = Integer.parseInt(replyGrpStr);
			}
			int replyLevel = 0;
			String replyLevelStr = req.getParameter("replyLevel");
			if (replyLevelStr != null && replyLevelStr.length() > 0) {
				replyLevel = Integer.parseInt(replyLevelStr);
			}
			int replyIndex = 0;
			String replyIndexStr = req.getParameter("replyIndex");
			if (replyIndexStr != null && replyIndexStr.length() > 0) {
				replyIndex = Integer.parseInt(replyIndexStr);
			}
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			HttpSession session = req.getSession();
			String id = (String) session.getAttribute("userId");
			ArticleVO article = service.readwithoutCount(articleNum);
			article.setTitle(title);
			article.setContent(content);
			article.setId(id);

			service.updateIndex(replyGrp, replyIndex);
			int result = service.writeReply(article);
			req.setAttribute("result", result);
			viewPath = "write_result.jsp";
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
}
