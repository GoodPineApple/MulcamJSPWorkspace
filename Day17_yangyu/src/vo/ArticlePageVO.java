package vo;

import java.util.List;

public class ArticlePageVO {
	private List<ArticleVO> articleList;
	private int requestPage;
	private int startPage;
	private int endPage;
	private int totalPage;
	
	
	public ArticlePageVO() {
		super();
	}


	public ArticlePageVO(List<ArticleVO> articleList, int requestPage, int startPage, int endPage, int totalPage) {
		super();
		this.articleList = articleList;
		this.requestPage = requestPage;
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


	public int getRequestPage() {
		return requestPage;
	}


	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
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
		return "ArticlePageVO [articleList=" + articleList + ", requestPage=" + requestPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", totalPage=" + totalPage + "]";
	}
	
	
}
