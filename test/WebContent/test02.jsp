<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html> 
<html> 
  <head> 
    <title>redlamp</title> 
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script> 
    <script> 
        $(document).ready(function(){ 
            $("#id_save").click(function(){ 
                var reg_id = /^[a-z0-9_-]{4,12}$/; 
                var reg_pw = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/; 
                var reg_email = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

                if(!reg_id.test($("#id").val())){ 
                            alert("���̵�� 3-15�� �̿��� �ϸ� \n" 
                                    +"��ħǥ, '-', '_'�� ������ ���ڴ� ����ϽǼ� �����ϴ�.");

                } 
                else if(!reg_pw.test($("#pw").val())){ 
                    alert('��й�ȣ ������ �߸��Ǿ����ϴ�.\n' 
                        +'(����,���ڸ� ȥ���Ͽ� 6~20�� �̳�)'); 
                } 
                else if(!reg_email.test($("#email").val())){ 
                    alert('�̸��� �ּҰ� ��ȿ���� �ʽ��ϴ�'); 
                } 
                else{ 
                    alert("���Խ� �˻� �Ϸ�") 
                } 
            }); 
        }); 
    </script> 
  </head> 
  <body> 
    ID : <input type="text" id="id"><br /> 
    ��й�ȣ : <input type="text" id="pw"><br /> 
    �̸��� : <input type="text" id="email"> 
    <input type="button" value="����" id="id_save"> 
  </body> 
</html>