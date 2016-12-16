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
		if(instance == null) {
			instance = new ArticleDAO();
		}
		return instance;
	}
	private ArticleDAO () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("driver loading error");
			e.printStackTrace();
		}
	}
	
	public List<ArticleVO> selectArticlePerPage(int startRow, int countRow) {
		Connection con = DBHelper.makeConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<ArticleVO> articleList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM ARTICLE_BOARD ORDER BY ARTICLE_ID DESC LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, countRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setArticleId(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setContent(rs.getString(3));
				article.setWriter(rs.getString(4));
				article.setReadCount(rs.getInt(5));
				article.setWriteDate(rs.getTimestamp(6));
				article.setPassword(rs.getString(7));
				articleList.add(article);
			}
		} catch (SQLException e) {
			System.out.println("selectArticlePerPage error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		} 
		return articleList;
	}
	
	public int CountTotalArticle() {
		Connection con = DBHelper.makeConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int totalArticle = 0;
		try {
			String sql = "SELECT COUNT(*) FROM ARTICLE_BOARD";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalArticle = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("CountAllPage error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		} 
		return totalArticle;
	}
	
	public int insert(ArticleVO article) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO ARTICLE_BOARD (TITLE,CONTENT,WRITER,READ_COUNT," +
						 "WRITE_DATE,PASSWORD) VALUES(?,?,?,0,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getWriter());
			pstmt.setString(4, article.getPassword());
			
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
	
	public ArticleVO selectArticle(int articleId){
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArticleVO article = new ArticleVO();
		try {
			String sql = "SELECT * FROM ARTICLE_BOARD WHERE ARTICLE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				article.setArticleId(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setContent(rs.getString(3));
				article.setWriter(rs.getString(4));
				article.setReadCount(rs.getInt(5));
				article.setWriteDate(rs.getTimestamp(6));
				article.setPassword(rs.getString(7));
			}
		} catch (SQLException e) {
			System.out.println("selectArticle error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return article;
	}
	
	public void updateReadCount(int readCount, int articleId){
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql="UPDATE ARTICLE_BOARD SET READ_COUNT=? WHERE ARTICLE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, readCount+1);
			pstmt.setInt(2, articleId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateReadCount error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
	}
	
	public int deleteArticle(int articleId){
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql="DELETE FROM ARTICLE_BOARD WHERE ARTICLE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("deleteArticle error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	public int updateArticle(ArticleVO article){
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql="UPDATE ARTICLE_BOARD SET TITLE=?,CONTENT=?,WRITER=?,PASSWORD=? WHERE ARTICLE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getWriter());
			pstmt.setString(4, article.getPassword());
			pstmt.setInt(5, article.getArticleId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateReadCount error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
}
