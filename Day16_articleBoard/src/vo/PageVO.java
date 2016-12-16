package vo;

import java.util.List;

public class PageVO {
	private List<ArticleVO> articleList;
	private List<CommentVO> commentList;
	private int currentPage;
	private int totalPage;
	private int startPage;
	private int endPage;
	
	public PageVO() {
		super();
	}

	public PageVO(List<CommentVO> commentList, int currentPage, int totalPage) {
		super();
		this.commentList = commentList;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}

	public PageVO(List<ArticleVO> articleList, int currentPage, int totalPage, int startPage, int endPage) {
		super();
		this.articleList = articleList;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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

}
