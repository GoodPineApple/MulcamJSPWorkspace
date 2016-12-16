package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtill {
	private static String DRIVER_NAME="com.mysql.jdbc.Driver";
	private static String DB_URL="jdbc:mysql://127.0.0.1:3306/jsp";
	private static String DB_ID="root";
	private static String DB_PW="sds902";
	
	public static Connection makeConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(DB_URL,DB_ID,DB_PW);
		} catch (SQLException e) {
			System.out.println("makeConnection error");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading error");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("close con error");
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("close stmt error");
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt){
		try {
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("close pstmt error");
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("close rs error");
			e.printStackTrace();
		}
	}
}
