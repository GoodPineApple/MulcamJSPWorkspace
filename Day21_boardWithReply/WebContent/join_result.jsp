<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������ ���</title>
</head>
<body>
<c:choose>
	<c:when test="${result==1}">
		<script type="text/javascript">
			alert("ȸ������ �Ϸ�.")
			location = "/Day21_boardWithReply/";
		</script>
	</c:when>
	<c:when test="${result==2}">
		<script type="text/javascript">
			alert("�̹� ������ ���̵� �ֽ��ϴ�.")
			location = "/Day21_boardWithReply/";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("ȸ������ ����")
			location.href = "/Day21_boardWithReply/";
		</script>
	</c:otherwise>
</c:choose>

</body>
</html>