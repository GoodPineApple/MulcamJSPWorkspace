package repository;

import java.sql.*;

import vo.MusicVO;

public class MusicDAO {
	
	private final String DRLVERNAME = "com.mysql.jdbc.Driver";
	private final String DB_ID = "root";
	private final String DB_PW = "sds902";
	private final String DB_URL = "jdbc:mysql://70.12.109.107:3306/jsp";
	
	private PreparedStatement pstmt;
	private Connection conection;
	private ResultSet rs = null;
	

}
