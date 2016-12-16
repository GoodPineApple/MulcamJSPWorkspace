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
		
		int startRow = (currentPage -1)*PAGE_PER_COUNT; // 1��������� startRow=0, 2��������� startRow=10...
		int endRow = startRow + PAGE_PER_COUNT;
		
		ArticleDAO dao = ArticleDAO.getInstance();
		
		// ���� �������� ������ ���� DB���� ��ȸ
		List<ArticleVO> articlePage = dao.selectArticleList(startRow, endRow);
		
		//�� �Խñ� ���� ��ȸ
		int totalArticle = dao.selectArticleCount();
		
		//�� �������� ���
		int totalPage = totalArticle/PAGE_PER_COUNT;
		if(totalArticle%PAGE_PER_COUNT != 0) {
			totalPage++;
		}
		
		// ������ �ϴ��� ���������� ���
		int startPage = (currentPage-1)/10*10 +1;
		// ������ �ϴ��� �� ������ ���
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
