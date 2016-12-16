<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>search.jsp</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btnSearch').on('click',function(){
			// �˻� ������ �ϴ� ǥ ����
			$('table tr:gt(0)').remove();
			
			// ����ڰ� �Է��� �˻��� ��������
			var keyword = $('#keyword').val();
			
			$.ajax({
				url : "searchBook.do",
				type : "post",
				data : "keyword="+keyword,
				dataType : "xml",
				success : function(data){
					// �޾ƿ� �˻���� �Ʒ������� �߰���Ű��
					$(data).find('item').each(function(){
						var title = 
							$(this).find('title').text();
						var image = 
							$(this).find('image').text();
						var author = 
							$(this).find('author').text();
						var price = 
							$(this).find('price').text();
						var publisher = 
							$(this).find('publisher').text();
						
						var result = "<tr>";
						
						result += "<td>";
						result += "<img src='"+image+"'>";
						result += "</td>";
						
						result += "<td>" +title+ "</td>";
						result += "<td>" +author+ "</td>";
						result += "<td>" +publisher+ "</td>";
						result += "<td>" +price+ "</td>";						
						
						result += "</tr>";
						
						$('table').append(result);
					})
				},
				error : function(){
					alert("ajax ������");
				}
			})
		})
	})
</script>
</head>
<body>
<h2>���̹� å�˻� �ϱ� ���(ajax)</h2>

<input type="text" id="keyword" name="keyword" size="10">
<button id="btnSearch">å�˻�</button>
<table border="1">
	<tr>
		<th>�̹���</th>
		<th>����</th>
		<th>����</th>
		<th>���ǻ�</th>
		<th>����</th>
	</tr>
</table>

</body>
</html>