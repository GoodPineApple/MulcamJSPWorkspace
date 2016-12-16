package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {
		
	}
///////////////////////////////////////////////////////////////////////////
	public int insert(MemberVO member) {
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO MEMBER(ID,PASSWORD,NAME,EMAIL,GENDER) VALUES(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getGender());
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
	
	public MemberVO selectMember(String id){
		Connection con = DBHelper.makeConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = new MemberVO();
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setEmail(rs.getString(4));
				member.setGender(rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("selectMember error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return member;
	}
	
	
}
