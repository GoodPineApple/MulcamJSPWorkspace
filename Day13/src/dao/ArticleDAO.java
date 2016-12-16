package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.ArticleVO;

public class ArticleDAO {
	private static ArticleDAO instance;

	public static ArticleDAO getInstance() {
		if (instance == null) {
			instance = new ArticleDAO();
		}
		return instance;
	}

	private ArticleDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
			e.printStackTrace();
		}
	}

	public List<ArticleVO> selectArticleList(int startRow, int endRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ArticleVO> result = new ArrayList<>();

		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT * FROM BOARD ORDER BY BOARD_ID DESC LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow - startRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setBoardId(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setContent(rs.getString(3));
				article.setWriter(rs.getString(4));
				article.setReadCount(rs.getInt(5));
				article.setWriteDate(rs.getTimestamp(6));
				article.setPassword(rs.getString(7));

				result.add(article);
			}

		} catch (SQLException e) {
			System.out.println("selectArticleList 오류");
			e.printStackTrace();
		} finally {
			DBHelper.closeResultset(rs);
			DBHelper.closePreparedStatement(pstmt);
			DBHelper.closeConnection(con);
		}
		return result;
	}
	
	public int selectArticleCount() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT COUNT(*) FROM BOARD";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			result = rs.getInt(1);
			
		} catch (SQLException e) {
			System.out.println("Count 메소드 에러");
			e.printStackTrace();
		}
		return result;
	}
	
	public int insert(ArticleVO article) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "INSERT INTO BOARD(TITLE,CONTENT,WRITER,READ_COUNT,WRITE_DATE,PASSWORD)"
					+" VALUES(?,?,?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getWriter());
			pstmt.setInt(4, article.getReadCount());
			pstmt.setString(5, article.getPassword());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert오류");
			e.printStackTrace();
		} finally {
			DBHelper.closePreparedStatement(pstmt);
			DBHelper.closeConnection(con);
		}
		return result;
	}


}
