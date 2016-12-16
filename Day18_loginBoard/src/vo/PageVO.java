package vo;

import java.util.List;

public class PageVO {
	private List<ArticleVO> articleList;
	private int currentPage;
	private int startPage;
	private int endPage;
	private int totalPage;
	
	public PageVO() {
		super();
	}
	
	public PageVO(List<ArticleVO> articleList, int currentPage, int startPage, int endPage, int totalPage) {
		super();
		this.articleList = articleList;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;
	}

	
	
	public List<ArticleVO> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleVO> articleList) {
		this.articleList = articleList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "PageVO [articleList=" + articleList + ", currentPage=" + currentPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", totalPage=" + totalPage + "]";
	}

	
}
