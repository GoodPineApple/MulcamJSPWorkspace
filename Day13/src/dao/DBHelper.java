package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	public static Connection makeConnection() {
		String DB_URL = "jdbc:mysql://70.12.109.107:3306/jsp";
		String DB_ID = "root";
		String DB_PW = "sds902";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
		} catch (SQLException e) {
			System.out.println("커넥션 연결 오류");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("커넥션 종료 오류");
				e.printStackTrace();
			}
		}
	}
	
	public static void closePreparedStatement(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("pstmt 종료 오류");
				e.printStackTrace();
			}
		}
	}
	
	public static void closeResultset(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("rs 종료 오류");
				e.printStackTrace();
			}
		}
	}
	
	public static void closeStatement(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("stmt 종료 오류");
				e.printStackTrace();
			}
		}
	}
}
