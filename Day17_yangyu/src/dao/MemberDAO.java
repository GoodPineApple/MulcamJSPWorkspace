package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {
		
	}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public int insert(MemberVO member) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con=DBUtill.makeConnection();
			String sql = "INSERT INTO MEMBER(ID,PASSWORD,NAME,EMAIL) VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert member error");
			e.printStackTrace();
		} finally {
			DBUtill.close(pstmt);
			DBUtill.close(con);
		}
		return result;
	}
	
	public MemberVO select(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO result = null;
		
		try {
			con = DBUtill.makeConnection();
			String sql = "SELECT ID,PASSWORD,NAME,EMAIL FROM MEMBER WHERE ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = new MemberVO();
				result.setId(rs.getString(1));
				result.setPassword(rs.getString(2));
				result.setName(rs.getString(3));
				result.setEmail(rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("select error");
			e.printStackTrace();
		} finally {
			DBUtill.close(rs);
			DBUtill.close(pstmt);
			DBUtill.close(con);
		}
		return result;
	}
}
