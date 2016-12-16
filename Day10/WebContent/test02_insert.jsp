<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test02_insert.jsp</title>
</head>
<body>
<%
	// 클라이언트가 보낸 파라미터 받는 부분
	request.setCharacterEncoding("EUC-KR"); //한글파라미터 처리

	String title = request.getParameter("title");
	String publisher = request.getParameter("pub");
	String year = request.getParameter("year");
	String priceStr = request.getParameter("price");
	int price = 0;

	if(priceStr != null) {
		price = Integer.parseInt(priceStr);
	}
//////////////////////////////////////////////////////////////////////////////
	//위에서 받은 파라미터 데이터베이스에 insert 하는 부분
	Connection con = null;
	PreparedStatement pstmt = null;
	int result = 0;
	Class.forName("com.mysql.jdbc.Driver");

	// 1.드라이버 로딩
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/jsp";
	String DB_ID = "root";
	String DB_PW = "sds902";
	
	// 2.커넥션 연결
	con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
	
	// 3.SQL 명령어 작성
	String sql = "INSERT INTO BOOKS(TITLE,PUBLISHER,YEAR,PRICE)" + 
				"VALUES(?,?,?,?)";
	
	
	// 4.Statement 객체 생성
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, title);
	pstmt.setString(2, publisher);
	pstmt.setString(3, year);
	pstmt.setInt(4, price);
	
	// 5.SQL 명령어 실행
	result = pstmt.executeUpdate();
	
	// 6.결과값 처리
	if(result>0) {
		out.print("<h2>책 insert가 완료되었습니다.</h2>" );
	} else {
		out.print("<h2>책 insert가 실패하였습니다.</h2>" );
	}
	
	// 7.사용한 자원 반납 - close
	if(pstmt!=null) {
		pstmt.close();		
	}
	if(con!=null) {
		con.close();
	}
%>
	<a href="test02_form.jsp">
	<button>책 추가입고</button>
	</a> <br>
	
	<a href="test03_select_list.jsp">
	<button>전체 책 목록보기</button>
	</a>


</body>
</html>