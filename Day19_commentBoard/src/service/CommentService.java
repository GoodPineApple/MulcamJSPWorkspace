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
		int startRow = (currentCommentPage-1)*PAGE_PER_COUNT;
		int endRow = startRow + PAGE_PER_COUNT;
		List<CommentVO> articleList = dao.selectCommentPerPage(startRow, endRow, articleNum);
		int totalArticleCount = dao.CountTotalComment();
		int totalPage = totalArticleCount / PAGE_PER_COUNT;
		if(totalArticleCount % PAGE_PER_COUNT > 0) {
			totalPage++;
		}
		int startPage = currentCommentPage/PAGE_PER_COUNT*PAGE_PER_COUNT+1;
		int endPage = startPage + PAGE_PER_COUNT - 1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		CommentPageVO commentPage = new CommentPageVO(articleList, currentCommentPage, startPage, endPage, totalPage);
		return commentPage;
	}
}
