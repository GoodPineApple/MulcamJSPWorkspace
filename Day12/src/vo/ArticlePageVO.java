package vo;

import java.util.List;

public class ArticlePageVO {
	private List<ArticleVO> articleList;
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;
	
	

	public ArticlePageVO() {
		super();
	}
	
	public ArticlePageVO(List<ArticleVO> articleList, int startPage, int endPage, int currentPage, int totalPage) {
		super();
		this.articleList = articleList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	
	public List<ArticleVO> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<ArticleVO> articleList) {
		this.articleList = articleList;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
