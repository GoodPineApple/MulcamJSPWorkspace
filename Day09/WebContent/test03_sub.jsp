<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- �� ������ sub�� ����ϴ�. -->

<%
	int n = 10;
	if(n%2==0){
%>

<h2>test03_sub.jsp ���� �ۼ��� ���� : ¦��</h2>
<%
	} else{
%>
<h2>test03_sub.jsp ���� �ۼ��� ���� : Ȧ��</h2>
<%
	}
%>