<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>search.jsp</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btnSearch').on('click',function(){
			// 검색 누르면 일단 표 비우기
			$('table tr:gt(0)').remove();
			
			// 사용자가 입력한 검색어 가져오기
			var keyword = $('#keyword').val();
			
			$.ajax({
				url : "searchBook.do",
				type : "post",
				data : "keyword="+keyword,
				dataType : "xml",
				success : function(data){
					// 받아온 검색결과 아래문서에 추가시키기
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
					alert("ajax 에러남");
				}
			})
		})
	})
</script>
</head>
<body>
<h2>네이버 책검색 하기 기능(ajax)</h2>

<input type="text" id="keyword" name="keyword" size="10">
<button id="btnSearch">책검색</button>
<table border="1">
	<tr>
		<th>이미지</th>
		<th>제목</th>
		<th>저자</th>
		<th>출판사</th>
		<th>가격</th>
	</tr>
</table>

</body>
</html>