package vo;

import java.sql.Timestamp;

public class ArticleVO {
		private int articleId;
		private String title;
		private String content;
		private String writer;
		private int readCount;
		private Timestamp writeDate;
		private String password;
		
		public ArticleVO(int articleId, String title, String content, String writer, int readCount, Timestamp writeDate,
				String password) {
			super();
			this.articleId = articleId;
			this.title = title;
			this.content = content;
			this.writer = writer;
			this.readCount = readCount;
			this.writeDate = writeDate;
			this.password = password;
		}

		public ArticleVO() {
			super();
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

		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public int getReadCount() {
			return readCount;
		}

		public void setReadCount(int readCount) {
			this.readCount = readCount;
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
