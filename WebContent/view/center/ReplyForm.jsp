<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

난ReplyForm다
<form action="ReplyReg" method="post" >

<input type="hidden" name="gid" value="${dto.gid }">
<input type="hidden" name="seq" value="${dto.seq }">
<input type="hidden" name="lev" value="${dto.lev }">
		<input type="hidden" name="page" value="${page }" />
	<table border="" width="100%">
		<tr>
			<td>제목</td><td><input type="text" name="title" value="[답변]${dto.title }"></td>
		</tr><tr>
			<td>작성자</td><td><input type="text" name="pname" value="[답변]${dto.pname }"></td>
		</tr><tr>
			<td>암호</td><td><input type="password" name="pw"></td>
		</tr><tr>
			<td>내용</td><td><textarea  name="content" cols="30" rows="10">[답변]${dto.content }</textarea></td>
		</tr><tr>
			<td colspan="2" align="center">
				<input type="submit" value="답변">
				<input type="reset" value="초기화">
				<a href="Detail?id=${dto.id }&page=${page }"">뒤로</a>
			</td>
		</tr>
	</table>
</form>
