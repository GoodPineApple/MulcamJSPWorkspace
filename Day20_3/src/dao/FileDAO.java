package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.FileVO;

public class FileDAO {
	static private FileDAO instance = new FileDAO();
	public static FileDAO getInstance() {
		return instance;
	}
	private FileDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql 드라이버 로딩 오류");
			e.printStackTrace();
		}
	}
	
	public List<FileVO> selectFileList() {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FileVO> resultList = new ArrayList<>();
		try {
			String sql = "select * from file_board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FileVO file = new FileVO();
				file.setFileNum(rs.getInt(1));
				file.setFileName(rs.getString(2));
				file.setSavedPath(rs.getString(3));
				file.setDownCount(rs.getInt(4));
				file.setFileSize(rs.getInt(5));
				resultList.add(file);
			}
		} catch (SQLException e) {
			System.out.println("selectFileList error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return resultList;
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
}
