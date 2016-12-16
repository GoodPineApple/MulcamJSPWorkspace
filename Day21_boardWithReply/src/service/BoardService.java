package service;

import java.util.List;

import dao.BoardDAO;
import vo.ArticleVO;
import vo.ArticlePageVO;

public class BoardService {
	private static BoardService instance = new BoardService();

	public static BoardService getInstance() {
		return instance;
	}

	private BoardService() {

	}

	BoardDAO dao = BoardDAO.getInstance();

	public ArticlePageVO makeArticlePage(int currentPage) {
		final int PAGE_PER_COUNT = 10;
		int startRow = (currentPage - 1) * PAGE_PER_COUNT;
		int endRow = startRow + PAGE_PER_COUNT;
		List<ArticleVO> articleList = dao.selectArticlePerPage(startRow, endRow);
		int totalArticleCount = dao.CountTotalArticle();
		int totalPage = totalArticleCount / PAGE_PER_COUNT;
		if (totalArticleCount % PAGE_PER_COUNT > 0) {
			totalPage++;
		}
		int startPage = currentPage / PAGE_PER_COUNT * PAGE_PER_COUNT + 1;
		int endPage = startPage + PAGE_PER_COUNT - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		ArticlePageVO articlePage = new ArticlePageVO(articleList, currentPage, startPage, endPage, totalPage);
		return articlePage;
	}

	public int write(ArticleVO article) {
		int result = dao.insert(article);
		return result;
	}

	public ArticleVO read(int articleNum) {
		ArticleVO article = dao.select(articleNum);
		dao.updateReadCount(articleNum);
		return article;
	}

	public ArticleVO readwithoutCount(int articleNum) {
		ArticleVO article = dao.select(articleNum);
		return article;
	}

	public void delete(int articleNum) {
		dao.delete(articleNum);
	}

	public int updateArticle(ArticleVO article) {
		int result = 0;
		result = dao.update(article);
		return result;
	}

	public int updateIndex(int replyGrp, int replyIndex) {
		int result = dao.updateIndex(replyGrp, replyIndex);
		return result;
	}

	public int writeReply(ArticleVO article) {
		int replyIndex = article.getReplyIndex() + 1;
		article.setReplyIndex(replyIndex);
		int replyLevel = article.getReplyLevel() + 1;
		article.setReplyLevel(replyLevel);
		System.out.println(article.getContent() + article.getId() + article.getTitle() + article.getReplyGrp()
				+ replyIndex + "," + replyLevel);
		int result = dao.insertReply(article);
		return result;
	}
}
