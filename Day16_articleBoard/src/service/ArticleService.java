package service;

import java.util.ArrayList;
import java.util.List;

import dao.ArticleDAO;
import vo.ArticleVO;
import vo.PageVO;

public class ArticleService {
	private static ArticleService instance;
	public static ArticleService getInstance() {
		if(instance == null) {
			instance = new ArticleService();
		}
		return instance;
	}
	ArticleDAO dao = ArticleDAO.getInstance();
	
	public PageVO makePage(int currentPage) {
		final int PAGE_PER_COUNT = 10;
		int startRow = (currentPage-1)*10; 
		int countRow = currentPage + PAGE_PER_COUNT;
		List<ArticleVO> articleList = new ArrayList<>();
		
		
		articleList = dao.selectArticlePerPage(startRow, countRow);
		int totalArticle = dao.CountTotalArticle();
		int totalPage = totalArticle / PAGE_PER_COUNT;
		if(totalArticle%PAGE_PER_COUNT >0) {
			totalPage++;
		}
		int startPage = (currentPage-1)/10*10+1;
		int endPage = startPage + PAGE_PER_COUNT -1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		PageVO articlePage = new PageVO(articleList, currentPage, totalPage, startPage, endPage);
		return articlePage;
	}
	
	public void upperReadCount(ArticleVO article) {
		int articleId = article.getArticleId();
		int readCount = article.getReadCount();
		dao.updateReadCount(readCount, articleId);
	}
	
	public int checkPassword(String userPassword, String originalPassword){
		int result = 0;
		if(userPassword.equals(originalPassword)) {
			result = 1;
		}
		return result;
	}
	
	public int delete(int articleId) {
		int result = dao.deleteArticle(articleId);
		return result;
	}
	
	
}
