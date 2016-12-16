package vo;

public class FileVO {
	private int fileNum;
	private String fileName;
	private String savedPath;
	private int downCount;
	private int fileSize;
	
	public FileVO(){
		
	}

	public FileVO(String fileName, String savedPath, int downCount, int fileSize) {
		super();
		this.fileName = fileName;
		this.savedPath = savedPath;
		this.downCount = downCount;
		this.fileSize = fileSize;
	}

	public FileVO(int fileNum, String fileName, String savedPath, int downCount, int fileSize) {
		super();
		this.fileNum = fileNum;
		this.fileName = fileName;
		this.savedPath = savedPath;
		this.downCount = downCount;
		this.fileSize = fileSize;
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSavedPath() {
		return savedPath;
	}

	public void setSavedPath(String savedPath) {
		this.savedPath = savedPath;
	}

	public int getDownCount() {
		return downCount;
	}

	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "FileVO [fileNum=" + fileNum + ", fileName=" + fileName + ", savedPath=" + savedPath + ", downCount="
				+ downCount + ", fileSize=" + fileSize + "]";
	}

}
