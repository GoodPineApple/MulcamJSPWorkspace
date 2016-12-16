package vo;

public class News {
	private int newsNo;
	private String imgUrl;	
	private String title;	
	private String mainTitle;
	private String content;
	private String mainContent;
	private String press;
	private String newsLink;
	private String keyword;
	
	public News(){}
	public News(String imgUrl, String title, String content, String press, String newsLink, String keyword) {
		this.imgUrl = imgUrl;
		this.title = title;
		this.content = content;
		this.press = press;
		this.newsLink = newsLink;
		this.keyword = keyword;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getNewsLink() {
		return newsLink;
	}
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getMainTitle() {
		return mainTitle;
	}
	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}
	public String getMainContent() {
		return mainContent;
	}
	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}
	
	public int getNewsNo() {
		return newsNo;
	}
	public void setNewsNo(int newsNo) {
		this.newsNo = newsNo;
	}
	@Override
	public String toString() {
		return "News [imgUrl=" + imgUrl + ", title=" + title + ", mainTitle=" + mainTitle + ", content=" + content
				+ ", mainContent=" + mainContent + ", press=" + press + ", newsLink=" + newsLink + ", keyword="
				+ keyword + "]";
	}
	
	
	
}
