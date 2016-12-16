package vo;

import java.sql.Timestamp;

public class CommentVO {
	private int commentId;
	private String content;
	private String writer;
	private int articleId;
	private Timestamp writeDate;
	private String password;
	
	public CommentVO() {
		super();
	}

	public CommentVO(int commentId, String content, String writer, int articleId, Timestamp writeDate,
			String password) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.writer = writer;
		this.articleId = articleId;
		this.writeDate = writeDate;
		this.password = password;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
