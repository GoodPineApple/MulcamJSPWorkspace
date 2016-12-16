package service;

import dao.MemberDAO;
import vo.MemberVO;

public class MemberService {
	private static MemberService instance = new MemberService();
	private MemberService() {
		
	}
	public static MemberService getInstance() {
		return instance;
	}
	//dao 활용할 일이 많으므로 dao를 맴버로 유지함
	private MemberDAO dao = MemberDAO.getInstance();
	
	//회원가입 메소드
	public boolean join(MemberVO member) {
		MemberVO savedMember = dao.select(member.getId());
		
		if(savedMember != null) {
			// 입력한 아이디의 회원이 이미 데이터베이스에 있음
			return false;
		} else {
			int result = dao.insert(member);
			if(result == 1) {
				return true;
			} else {
				return false;
			}
		}
	}

	//로그인 메소드
	public boolean login(String id, String password) {
		MemberVO savedMember = dao.select(id);
		
		if(savedMember!=null && savedMember.getPassword().equals(password)){
			return true;
		} else {
			return false;
		}
	}
}
