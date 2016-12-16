package vo;

import java.sql.Timestamp;

public class ArticleVO {
	private int articleId;		//글번호
	private String title;		//글제목
	private String content;		//내용
	private int readCount;		//조회수
	private String password;	//글 비밀번호
	private String writer;		//작성자
	private Timestamp writeDate;//작성일시
	
	public ArticleVO() {
		super();
	}
	public ArticleVO(String title, String content, int readCount, String password, String writer, Timestamp writeDate) {
		super();
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.password = password;
		this.writer = writer;
		this.writeDate = writeDate;
	}
	public ArticleVO(int articleId, String title, String content, int readCount, String password, String writer,
			Timestamp writeDate) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.password = password;
		this.writer = writer;
		this.writeDate = writeDate;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	
}
