<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){ 
    $("#id_save").click(function(){ 
        var reg_id = /^[a-z0-9_-]{4,12}$/; 
        var reg_pw = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/; 
        var reg_email = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

        if(!reg_id.test($("#id").val())){ 
                    alert("아이디는 3-15자 이여야 하며 \n" 
                            +"마침표, '-', '_'를 제외한 문자는 사용하실수 없습니다.");

        } 
        else if(!reg_pw.test($("#pw").val())){ 
            alert('비밀번호 형식이 잘못되었습니다.\n' 
                +'(영문,숫자를 혼합하여 6~20자 이내)'); 
        } 
        else if(!reg_email.test($("#email").val())){ 
            alert('이메일 주소가 유효하지 않습니다'); 
        } 
        else{ 
            alert("정규식 검사 완료") 
        } 
    }); 
}); 
</script>
</head>
<body>
    ID : <input type="text" id="id"><br /> 
    비밀번호 : <input type="text" id="pw"><br /> 
    이메일 : <input type="text" id="email"> 
    <input type="button" value="저장" id="id_save"> 
</body>
</html>