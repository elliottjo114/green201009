<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
난insertForm다
<!-- 제출 누르면 center/InsertReg로 가는거라서 f컨트롤로 간다. -->
<form action="InsertReg" method="post" enctype="multipart/form-data">
	<table border="" width="100%">
		<tr>
			<td>제목</td><td><input type="text" name="title"></td>
		</tr><tr>
			<td>작성자</td><td><input type="text" name="pname"></td>
		</tr><tr>
			<td>암호</td><td><input type="password" name="pw"></td>
		</tr><tr>
			<td>파일</td><td><input type="file" name="upfile"></td>
		</tr><tr>
			<td>내용</td><td><textarea  name="content" cols="30" rows="10"></textarea></td>
		</tr><tr>
			<td colspan="2" align="center">
				<input type="submit" value="작성">
				<a href="List">목록으로</a>
			</td>
		</tr>
	</table>
</form>
