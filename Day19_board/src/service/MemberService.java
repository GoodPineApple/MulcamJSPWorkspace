package service;

import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

public class MemberService {
	private static MemberService instance = new MemberService();
	public static MemberService getInstance(){
		return instance;
	}
	private MemberService() {
		
	}
	
	MemberDAO dao = MemberDAO.getInstance();
////////////////////////////////////////////////////////////////////////////////
	public int joinMember(MemberVO member){
		String originalId = member.getId();
		MemberVO original = dao.selectMember(originalId);
		int result = 0;

		if(original.getId() == null) {
			result = dao.insert(member);
			return result;
		} else if(original.getId().equals(member.getId())){
			result = 2;
			return result;
		} else {
			return result;
		} // result=1 ȸ������ ����, result=2 ���Ͼ��̵� �̹� ����, result=0 dao���� ȸ������ ����
	}
	
	public int confirmLogin(String id, String password) {
		MemberVO member = dao.selectMember(id);
		int result = 0;
		if(member.getPassword() != null && member.getPassword().equals(password)){
			result = 1; // �α��� ���� result=1;
			return result;
		}
		return result; // �α��� ���� result=0;
	}
	
	public MemberVO selectMember(String id) {
		MemberVO member = dao.selectMember(id);
		return member;
	}
	
}
