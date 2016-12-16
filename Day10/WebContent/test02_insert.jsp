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
	// Ŭ���̾�Ʈ�� ���� �Ķ���� �޴� �κ�
	request.setCharacterEncoding("EUC-KR"); //�ѱ��Ķ���� ó��

	String title = request.getParameter("title");
	String publisher = request.getParameter("pub");
	String year = request.getParameter("year");
	String priceStr = request.getParameter("price");
	int price = 0;

	if(priceStr != null) {
		price = Integer.parseInt(priceStr);
	}
//////////////////////////////////////////////////////////////////////////////
	//������ ���� �Ķ���� �����ͺ��̽��� insert �ϴ� �κ�
	Connection con = null;
	PreparedStatement pstmt = null;
	int result = 0;
	Class.forName("com.mysql.jdbc.Driver");

	// 1.����̹� �ε�
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/jsp";
	String DB_ID = "root";
	String DB_PW = "sds902";
	
	// 2.Ŀ�ؼ� ����
	con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
	
	// 3.SQL ��ɾ� �ۼ�
	String sql = "INSERT INTO BOOKS(TITLE,PUBLISHER,YEAR,PRICE)" + 
				"VALUES(?,?,?,?)";
	
	
	// 4.Statement ��ü ����
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, title);
	pstmt.setString(2, publisher);
	pstmt.setString(3, year);
	pstmt.setInt(4, price);
	
	// 5.SQL ��ɾ� ����
	result = pstmt.executeUpdate();
	
	// 6.����� ó��
	if(result>0) {
		out.print("<h2>å insert�� �Ϸ�Ǿ����ϴ�.</h2>" );
	} else {
		out.print("<h2>å insert�� �����Ͽ����ϴ�.</h2>" );
	}
	
	// 7.����� �ڿ� �ݳ� - close
	if(pstmt!=null) {
		pstmt.close();		
	}
	if(con!=null) {
		con.close();
	}
%>
	<a href="test02_form.jsp">
	<button>å �߰��԰�</button>
	</a> <br>
	
	<a href="test03_select_list.jsp">
	<button>��ü å ��Ϻ���</button>
	</a>


</body>
</html>