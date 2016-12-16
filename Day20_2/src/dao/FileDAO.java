package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vo.FileVO;

public class FileDAO {
	private static FileDAO instance = new FileDAO();
	public static FileDAO getInstance() {
		return instance;
	}
	private FileDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql 드라이버 로딩 오류");
			e.printStackTrace();
		}
	}
	
	public List<FileVO> selectFileList(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<FileVO> fileList = new ArrayList<>();
		
		try {
			con = DBHelper.makeConnection();
			String sql = "select * from file_board";
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				FileVO file = new FileVO();
				file.setFileNum(rs.getInt(1));
				file.setFileName(rs.getString(2));
				file.setSavedPath(rs.getString(3));
				file.setDownCount(rs.getInt(4));
				file.setFileSize(rs.getInt(5));
				
				fileList.add(file);
			}
		} catch (SQLException e) {
			System.out.println("selectFileList error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(stmt);
			DBHelper.close(con);
		}
		return fileList;
	}
	
	public int insert(FileVO fileVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = DBHelper.makeConnection();
			String sql = "INSERT INTO FILE_BOARD(FILE_NAME,SAVED_PATH,FILE_SIZE,DOWN_COUNT) VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileVO.getFileName());
			pstmt.setString(2, fileVO.getSavedPath());
			pstmt.setInt(3, fileVO.getFileSize());
			pstmt.setInt(4, fileVO.getDownCount());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	public FileVO selectFile(int fileNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FileVO file = null;
		
		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT * FROM FILE_BOARD WHERE FILE_NUM=?";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery(sql);
			if(rs.next()){
				file = new FileVO();
				file.setFileNum(rs.getInt(1));
				file.setFileName(rs.getString(2));
				file.setSavedPath(rs.getString(3));
				file.setDownCount(rs.getInt(4));
				file.setFileSize(rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println("selectFile error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return file;
	}
	
	public int updateDownCount(int fileNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = DBHelper.makeConnection();
			String sql = "UPDATE FILE_BOARD SET DOWN_COUNT=DOWNCOUNT+1 WHERE FILE_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fileNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateDownCount error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	

}
