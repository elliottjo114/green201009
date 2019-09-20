<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<c:if test="${msg!=null }">
	<script>
		alert("${msg }");
	</script>
</c:if>


<script>
function fileDelete(){
	
	if(confirm("삭제된 파일은 복원불가입니다.\n삭제하시겠습니까?")){
		frm.action = "FileDelete";
		frm.submit();
	}
}

</script>
  
난ModifyForm다
<form name="frm" action="ModifyReg" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${dto.id }">
		<input type="hidden" name="page" value="${page }" />
	<table border="" width="100%">
		<tr>
			<td>제목</td><td><input type="text" name="title" value="${dto.title }"></td>
		</tr><tr>
			<td>작성자</td><td><input type="text" name="pname" value="${dto.pname }"></td>
		</tr><tr>
			<td>암호</td><td><input type="password" name="pw"></td>
		</tr><tr>
		
		
		
		<c:if test="${dto.lev==0 }">
		
		
			<td>파일</td><td>
			<c:choose>
				<c:when test="${dto.upfile == null }">
					<input type="file" name="upfile">
				</c:when>
				<c:otherwise>
							
							
					<c:choose>
						<c:when test="${dto.imgChk }">
							<img src="../../up/${dto.upfileEn }" alt="" width="100px" />
						</c:when>
						<c:otherwise>
							${dto.upfile }
						</c:otherwise>
					</c:choose>
					<input type="button" onclick="fileDelete()" value="파일삭제" >		
					<input type="hidden" name="upfile" value="${dto.upfile }">		
							
							
				</c:otherwise>
			</c:choose>
			</td>
		</tr><tr>
		
	</c:if>
		
			<td>내용</td><td><textarea  name="content" cols="30" rows="10">${dto.content }</textarea></td>
		</tr><tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정">
				<a href="ModifyForm?id=${dto.id }">초기화</a>
				<a href="Detail?id=${dto.id }&page=${page }"">뒤로</a>
			</td>
		</tr>
	</table>
</form>
