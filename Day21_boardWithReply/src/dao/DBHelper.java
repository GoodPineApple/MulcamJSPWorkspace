package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
	final private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final private static String DB_URL = "jdbc:mysql://localhost:3306/jsp2";
	final private static String DB_ID = "root";
	final private static String DB_PW = "sds902";

	public static Connection makeConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loadin error");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection building error");
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("close con error");
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("close pstmt error");
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("close rs error");
				e.printStackTrace();
			}
		}
	}
}
