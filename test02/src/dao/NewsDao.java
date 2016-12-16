package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.News;

public class NewsDao {
	private static NewsDao instance = new NewsDao();
	private NewsDao(){}
	public static NewsDao getInstance(){
		return instance;
	}
	public News select(String newsLink) {
		Connection con = DBHelper.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("FROM * NEWS ");
		sql.append("WHERE NEWS_LINK = ? ");
		return null;
	}
}
