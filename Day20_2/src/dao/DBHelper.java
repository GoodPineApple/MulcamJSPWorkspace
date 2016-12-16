package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	
	public static Connection makeConnection() {
		String DB_URL = "jdbc:mysql://127.0.0.1:3306/jsp";
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
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("con 종료 오류");
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("rs 종료 오류");
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("stmt 종료 오류");
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("pstmt 종료 오류");
			e.printStackTrace();
		}
	}
	
}
