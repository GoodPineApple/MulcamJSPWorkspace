<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<form name="f" method="post" action="�� ���� �ּ�">
 <input type="password" id="pwd" name="pwd" maxlength="20" />
 <input type="button" value="Ȯ��" onclick="btnSubmit()" />
 </form>
 <script type="text/javascript">
//���Խ� : ��й�ȣ
 function chkPwd(str)
 {
  var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
  if(!reg_pwd.test(str))
  {
   return false;
  }
  return true;
 }
 // �� ����
 function btnSubmit()
 {
  // Ȯ�� : ��й�ȣ
  $('#pwd').val($('#pwd').val().trim()); // javascript�� �̿��ؼ� trim() �����ϱ� �ٷΰ���
  if(!chkPwd($('#pwd').val().trim()))
  {
   alert('��й�ȣ�� Ȯ���ϼ���.(����,���ڸ� ȥ���Ͽ� 6~20�� �̳�)');
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