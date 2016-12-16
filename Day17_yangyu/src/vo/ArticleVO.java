package vo;

import java.sql.Date;

public class ArticleVO {
	private int articleNum;
	private String tilte;
	private String id;
	private String content;
	private Date writeDate;
	private int readCount;
	
	public ArticleVO(String tilte, String id, String content, Date writeDate, int readCount) {
		super();
		this.tilte = tilte;
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.readCount = readCount;
	}

	public ArticleVO(int articleNum, String tilte, String id, String content, Date writeDate, int readCount) {
		super();
		this.articleNum = articleNum;
		this.tilte = tilte;
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.readCount = readCount;
	}

	public ArticleVO() {
		super();
	}

	public int getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}

	public String getTilte() {
		return tilte;
	}

	public void setTilte(String tilte) {
		this.tilte = tilte;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
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
		return "ArticleVO [articleNum=" + articleNum + ", tilte=" + tilte + ", id=" + id + ", content=" + content
				+ ", writeDate=" + writeDate + ", readCount=" + readCount + "]";
	}
	
	
}
