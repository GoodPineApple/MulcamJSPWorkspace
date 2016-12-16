<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<form name="f" method="post" action="폼 전송 주소">
 <input type="password" id="pwd" name="pwd" maxlength="20" />
 <input type="button" value="확인" onclick="btnSubmit()" />
 </form>
 <script type="text/javascript">
//정규식 : 비밀번호
 function chkPwd(str)
 {
  var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
  if(!reg_pwd.test(str))
  {
   return false;
  }
  return true;
 }
 // 폼 전송
 function btnSubmit()
 {
  // 확인 : 비밀번호
  $('#pwd').val($('#pwd').val().trim()); // javascript를 이용해서 trim() 구현하기 바로가기
  if(!chkPwd($('#pwd').val().trim()))
  {
   alert('비밀번호를 확인하세요.(영문,숫자를 혼합하여 6~20자 이내)');
   $('#pwd').val('');
   $('#pwd').focus();
   return false;
  }
  
  //document.f.submit();
 }
 </script>
</head>
<body>

<input type = "password", id="pwd">
 
</body>
</html>