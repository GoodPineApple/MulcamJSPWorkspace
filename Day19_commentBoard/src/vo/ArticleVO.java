package vo;

import java.sql.Timestamp;

public class ArticleVO {
	private String title;
	private int articleNum;
	private String id;
	private String content;
	private Timestamp writeDate;
	private int readCount;
	
	public ArticleVO() {
		super();
	}

	public ArticleVO(String title, int articleNum, String id, String content, Timestamp writeDate, int readCount) {
		super();
		this.title = title;
		this.articleNum = articleNum;
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.readCount = readCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "ArticleVO [title=" + title + ", articleNum=" + articleNum + ", id=" + id + ", content=" + content
				+ ", writeDate=" + writeDate + ", readCount=" + readCount + "]";
	}
	
}
