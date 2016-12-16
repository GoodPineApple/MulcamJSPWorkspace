package vo;

public class MusicVO {
	int musicId;
	String title;
	String publisher;
	int price;
	String year;
	
	public MusicVO() {
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public MusicVO(int musicId, String title, String publisher, int price, String year) {
		super();
		this.musicId = musicId;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.year = year;
	}

}
