<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center/notice</title>
</head>
<body>
<table border="">
	<tr>
		<td>
			<jsp:include page="inc/top.jsp"/>
		</td>
	</tr>
	<tr>
		<td width="500px">
			<jsp:include page="center/${mainUrl }.jsp"/> <!-- f컨트롤에서 받아온 mainUrl을 사용하여 받아온 정보들을 포항시켜 이동시키기 -->
		</td>
	</tr>
	<tr>
		<td>
			<jsp:include page="inc/bottom.jsp"/>
		</td>
	</tr>
</table>
</body>
</html>