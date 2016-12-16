package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import vo.ArticlePageVO;
import vo.ArticleVO;

public class BoardDAO {
	// 객체를 하나만 만들어서 재사용하는 싱글턴(singleton) 패턴 적용
	private static BoardDAO instance;
	
	public static BoardDAO getInstance() {
		if(instance==null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	private BoardDAO() {  // 생성자를 private으로
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩오류");
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////
	public List<ArticleVO> selectArticleList(int startRow, int endRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ArticleVO> articleList = new ArrayList<>();
		
		try {
			con= DBHelper.makeConnection();
			String sql = "SELECT * FROM ARTICLE_BOARD ORDER BY ARTICLE_ID DESC LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow - startRow);
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
			System.out.println("Dao insert 오류");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return articleList;
	}
	
	
	public int selectArticleCount() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int articleCount = 0;
		
		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT COUNT(*) FROM ARTICLE_BOARD";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			articleCount = rs.getInt(1);
			
		} catch (SQLException e) {
			System.out.println("selectarticleCount 오류");
			e.printStackTrace();
		}
		return articleCount;
	}
	
	public int insert(ArticleVO article) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con=DBHelper.makeConnection();
			String sql = "INSERT INTO ARTICLE_BOARD (TITLE, CONTENT,WRITER,READ_COUNT,WRITE_DATE,PASSWORD)"
					+" VALUES(?,?,?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getWriter());
			pstmt.setInt(4, article.getReadCount());
			pstmt.setString(5, article.getPassword());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}

	public ArticleVO selectArticle(int articleId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArticleVO article = null;
		
		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT * FROM ARTICLE_BOARD WHERE ARTICLE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleId);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				article = new ArticleVO();
				article.setArticleId(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setContent(rs.getString(3));
				article.setWriter(rs.getString(4));
				article.setReadCount(rs.getInt(5));
				article.setWriteDate(rs.getTimestamp(6));
				article.setPassword(rs.getString(7));
			}
		} catch (SQLException e) {
			System.out.println("selectArticle 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return article;
	}
	
	public int updateReadCount(int articleId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = DBHelper.makeConnection();
			String sql = "UPDATE ARTICLE_BOARD SET READ_COUNT=READ_COUNT+1 WHERE ARTICLE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateReadCount 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}

	public int update(ArticleVO article) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = DBHelper.makeConnection();
			String sql = "UPDATE ARTICLE_BOARD SET TITLE=?,CONTENT=? WHERE ARTICLE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setInt(3, article.getArticleId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	public int delete(ArticleVO article) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = DBHelper.makeConnection();
			String sql = "DELETE FROM ARTICLE_BOARD WHERE ARTICLE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getArticleId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
}
