package vo;

import java.sql.Timestamp;

public class CommentVO {
	private int commentNum;
	private String content;
	private int articleNum;
	private Timestamp writeDate;
	private int good;
	private int bad;
	private String id;

	public CommentVO() {
		super();
	}

	public CommentVO(int commentNum, String content, int articleNum, Timestamp writeDate, int good, int bad,
			String id) {
		super();
		this.commentNum = commentNum;
		this.content = content;
		this.articleNum = articleNum;
		this.writeDate = writeDate;
		this.good = good;
		this.bad = bad;
		this.id = id;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CommentVO [commentNum=" + commentNum + ", content=" + content + ", articleNum=" + articleNum
				+ ", writeDate=" + writeDate + ", good=" + good + ", bad=" + bad + ", id=" + id + "]";
	}

}
