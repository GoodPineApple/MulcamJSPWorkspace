package vo;

import java.sql.Timestamp;

public class ArticleVO {
	private int ArticleNum;
	private String title;
	private String id;
	private String content;
	private Timestamp writeDate;
	private int readCount;
	private int replyGrp;
	private int replyLevel;
	private int replyIndex;

	public ArticleVO() {
		super();
	}

	public ArticleVO(int articleNum, String title, String id, String content, Timestamp writeDate, int readCount,
			int replyGrp, int replyLevel, int replyIndex) {
		super();
		ArticleNum = articleNum;
		this.title = title;
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.readCount = readCount;
		this.replyGrp = replyGrp;
		this.replyLevel = replyLevel;
		this.replyIndex = replyIndex;
	}

	public int getArticleNum() {
		return ArticleNum;
	}

	public void setArticleNum(int articleNum) {
		ArticleNum = articleNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getReplyGrp() {
		return replyGrp;
	}

	public void setReplyGrp(int replyGrp) {
		this.replyGrp = replyGrp;
	}

	public int getReplyLevel() {
		return replyLevel;
	}

	public void setReplyLevel(int replyLevel) {
		this.replyLevel = replyLevel;
	}

	public int getReplyIndex() {
		return replyIndex;
	}

	public void setReplyIndex(int replyIndex) {
		this.replyIndex = replyIndex;
	}

	@Override
	public String toString() {
		return "ArticleVO [ArticleNum=" + ArticleNum + ", title=" + title + ", id=" + id + ", content=" + content
				+ ", writeDate=" + writeDate + ", readCount=" + readCount + ", replyGrp=" + replyGrp + ", replyLevel="
				+ replyLevel + ", replyIndex=" + replyIndex + "]";
	}

}
