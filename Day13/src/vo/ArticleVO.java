package vo;

import java.sql.Timestamp;

public class ArticleVO {
	private int boardId;
	private String title;
	private String writer;
	private String content;
	private int readCount;
	private String password;
	private Timestamp writeDate;

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public ArticleVO(int boardId, String title, String writer, String content, int readCount, String password, Timestamp writeDate) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.readCount = readCount;
		this.password = password;
		this.writeDate = writeDate;
	}

	public ArticleVO() {
		super();
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
}
