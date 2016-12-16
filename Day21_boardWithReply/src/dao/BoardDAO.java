package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ArticleVO;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	private BoardDAO() {

	}

	public List<ArticleVO> selectArticlePerPage(int startRow, int endRow) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ArticleVO> articleList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM BOARD ORDER BY REPLY_GRP DESC, REPLY_INDEX LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow - startRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setArticleNum(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setId(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setWriteDate(rs.getTimestamp(5));
				article.setReadCount(rs.getInt(6));
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
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String sql = "SELECT COUNT(*) FROM BOARD";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("CountTotalArticle error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}

	public int insert(ArticleVO article) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO BOARD(TITLE,ID,CONTENT,WRITE_DATE,READ_COUNT,REPLY_GRP,REPLY_LEVEL,REPLY_INDEX) SELECT ?,?,?,now(),0,MAX(ARTICLE_NUM)+1,1,1 FROM BOARD";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getId());
			pstmt.setString(3, article.getContent());
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

	public ArticleVO select(int articleNum) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArticleVO article = new ArticleVO();
		try {
			String sql = "SELECT * FROM BOARD WHERE ARTICLE_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				article.setArticleNum(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setId(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setWriteDate(rs.getTimestamp(5));
				article.setReadCount(rs.getInt(6));
				article.setReplyGrp(rs.getInt(7));
				article.setReplyLevel(rs.getInt(8));
				article.setReplyIndex(rs.getInt(9));
			}
		} catch (SQLException e) {
			System.out.println("select error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return article;
	}

	public int updateReadCount(int articleNum) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE BOARD SET READ_COUNT=READ_COUNT+1 WHERE ARTICLE_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
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

	public void delete(int articleNum) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "DELETE FROM BOARD WHERE ARTICLE_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
	}

	public int update(ArticleVO article) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE BOARD SET TITLE=?,CONTENT=? WHERE ARTICLE_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setInt(3, article.getArticleNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}

	public int updateIndex(int replyGrp, int replyIndex) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE BOARD SET REPLY_INDEX = REPLY_INDEX+1 WHERE REPLY_INDEX > ? AND REPLY_GRP = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, replyIndex);
			pstmt.setInt(2, replyGrp);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateIndex error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}

	public int insertReply(ArticleVO article) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO BOARD(TITLE,ID,CONTENT,WRITE_DATE,READ_COUNT,REPLY_GRP,REPLY_LEVEL,REPLY_INDEX) VALUES(?,?,?,now(),0,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getId());
			pstmt.setString(3, article.getContent());
			pstmt.setInt(4, article.getReplyGrp());
			pstmt.setInt(5, article.getReplyLevel());
			pstmt.setInt(6, article.getReplyIndex());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertReply error");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
}
