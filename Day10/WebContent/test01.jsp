<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Connection con = null;
	Statement stmt = null;
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
				"VALUES('JAVA', 'SDS', '2016', 30000)";
	
	
	// 4.Statement ��ü ����
	stmt = con.createStatement();
	
	// 5.SQL ��ɾ� �ۼ�
	result = stmt.executeUpdate(sql);
	
	// 6.����� ó��
	if(result>0) {
		out.print("<h2>å insert�� �Ϸ�Ǿ����ϴ�.</h2>" );
	} else {
		out.print("<h2>å insert�� �����Ͽ����ϴ�.</h2>" );
	}
	
	// 7.����� �ڿ� �ݳ� - close
	if(stmt!=null) {
		stmt.close();		
	}
	if(con!=null) {
		con.close();
	}
%>
�����ͺ��̽� insert �۾� �Ϸ�!<br>
</body>
</html>