package service;

import java.util.List;

import dao.ArticleDAO;
import vo.ArticlePageVO;
import vo.ArticleVO;

public class BoardService {
	private static BoardService instance;
	public static BoardService getInstance() {
		if(instance == null) {
			instance = new BoardService();
		}
		return instance;
	}
	private BoardService() {
	}
	
	public ArticlePageVO makePage(int currentPage) {
		final int PAGE_PER_COUNT = 10;
		
		int startRow = (currentPage -1)*PAGE_PER_COUNT; // 1페이지라면 startRow=0, 2페이지라면 startRow=10...
		int endRow = startRow + PAGE_PER_COUNT;
		
		ArticleDAO dao = ArticleDAO.getInstance();
		
		// 현재 페이지에 보여줄 글을 DB에서 조회
		List<ArticleVO> articlePage = dao.selectArticleList(startRow, endRow);
		
		//총 게시글 갯수 조회
		int totalArticle = dao.selectArticleCount();
		
		//총 페이지수 계산
		int totalPage = totalArticle/PAGE_PER_COUNT;
		if(totalArticle%PAGE_PER_COUNT != 0) {
			totalPage++;
		}
		
		// 페이지 하단의 시작페이지 계산
		int startPage = (currentPage-1)/10*10 +1;
		// 페이지 하단의 끝 페이지 계산
		int endPage = startPage +9;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		return new ArticlePageVO(articlePage, currentPage, startPage, endPage, totalPage);
	}
	
	public int write(ArticleVO article) {
		ArticleDAO dao = ArticleDAO.getInstance();
		int result = dao.insert(article);
		return result;
	}

}
