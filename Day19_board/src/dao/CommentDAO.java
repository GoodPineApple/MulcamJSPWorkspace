package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.CommentPageVO;
import vo.CommentVO;

public class CommentDAO {
	private static CommentDAO instance = new CommentDAO();
	public static CommentDAO getInstance() {
		return instance;
	}
	private CommentDAO() {
		
	}
	
	public int insert(CommentVO comment) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO COMMENT(CONTENT,ARTICLE_NUM,WRITE_DATE,GOOD,BAD,ID) "
					+"VALUES(?,?,now(),0,0,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, comment.getContent());
			pstmt.setInt(2, comment.getArticleNum());
			pstmt.setString(3, comment.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("comment insert error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	public List<CommentVO> selectCommentPerPage(int startRow, int endRow, int articleNum) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CommentVO> commentList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM COMMENT WHERE ARTICLE_NUM=? LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow - startRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentVO comment = new CommentVO();
				comment.setCommentNum(rs.getInt(1));
				comment.setContent(rs.getString(2));
				comment.setArticleNum(rs.getInt(3));
				comment.setWriteDate(rs.getTimestamp(4));
				comment.setGood(rs.getInt(5));
				comment.setBad(rs.getInt(6));
				comment.setId(rs.getString(7));
				commentList.add(comment);
			}
		} catch (SQLException e) {
			System.out.println("selectCommentPerPage error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return commentList;
	}
	
	public int CountTotalComment(int articleNum) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String sql = "SELECT COUNT(*) FROM COMMENT WHERE ARTICLE_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("CountTotalComment error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	public int updateGoodCount(int commentNum){
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE COMMENT SET GOOD = GOOD+1 WHERE COMMENT_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateGoodCount error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	public int updateBadCount(int commentNum){
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE COMMENT SET BAD = BAD+1 WHERE COMMENT_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateBadCount error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	public int delete(int commentNum){
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "DELETE FROM COMMENT WHERE COMMENT_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("deleteComment error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
}
