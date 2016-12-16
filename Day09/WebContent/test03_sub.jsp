<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 이 내용은 sub가 만듭니다. -->

<%
	int n = 10;
	if(n%2==0){
%>

<h2>test03_sub.jsp 에서 작성한 내용 : 짝수</h2>
<%
	} else{
%>
<h2>test03_sub.jsp 에서 작성한 내용 : 홀수</h2>
<%
	}
%>