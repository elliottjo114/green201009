<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="DeleteReg" method="post">
	<input type="hidden" name="id" value="${param.id }" />
		<input type="hidden" name="page" value="${page }" />
	<table>
		<tr>
			<td>암호</td>
			<td><input type="password" name="pw" /></td>
		</tr>
		<tr>
			
			<td colspan="2" align="center">
				<input type="submit" value="삭제" />
				<a href="Detail?id=${param.id }&page=${page }"">뒤로</a>
			</td>
		</tr>
	</table>
</form>