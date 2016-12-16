package service;

import java.util.List;

import dao.CommentDAO;
import vo.ArticlePageVO;
import vo.ArticleVO;
import vo.CommentPageVO;
import vo.CommentVO;

public class CommentService {
	private static CommentService instance = new CommentService();

	public static CommentService getInstance() {
		return instance;
	}

	public CommentService() {

	}

	CommentDAO dao = CommentDAO.getInstance();

	public CommentPageVO makePage(int currentCommentPage, int articleNum) {
		final int PAGE_PER_COUNT = 3;
		int startRow = (currentCommentPage - 1) * PAGE_PER_COUNT;
		int endRow = startRow + PAGE_PER_COUNT;
		List<CommentVO> articleList = dao.selectCommentPerPage(startRow, endRow, articleNum);
		int totalArticleCount = dao.CountTotalComment(articleNum);
		int totalPage = totalArticleCount / PAGE_PER_COUNT;
		if (totalArticleCount % PAGE_PER_COUNT > 0) {
			totalPage++;
		}
		int startPage = (currentCommentPage - 1) / 10 * 10 + 1;
		int endPage = startPage + 9;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		CommentPageVO commentPage = new CommentPageVO(articleList, currentCommentPage, startPage, endPage, totalPage);
		return commentPage;
	}

	public int writeComment(CommentVO comment) {
		int result = dao.insert(comment);
		return result;
	}

	public int updateCommentGoodCount(int commentNum) {
		int result = dao.updateGoodCount(commentNum);
		return result;
	}

	public int updateCommentBadCount(int commentNum) {
		int result = dao.updateBadCount(commentNum);
		return result;
	}

	public int deleteComment(int commentNum) {
		int result = dao.delete(commentNum);
		return result;
	}
}
