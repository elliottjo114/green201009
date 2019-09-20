<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
난 Detail다 
<!-- f컨트롤과 M_Action을 통해 dot 가져옴 -->
<table border="" width="100%">
	<tr>
		<td>번호</td><td>${dto.id }</td> <!-- dto에 있는 정보들 가져오기 -->
	</tr><tr>
		<td>제목</td><td>${dto.title }</td>
	</tr><tr>
		<td>작성자</td><td>${dto.pname }</td>
	</tr><tr>
		<td>작성일</td><td>${dto.regdate }</td>
	</tr><tr>
		<td>조회수</td><td>${dto.cnt }</td>
	</tr><tr>
<c:if test="${dto.upfile != null }">  <!-- 만약 파일이 있다면 이프문 실행 -->
	
	
		<td>파일</td><td>
		
		<c:choose>
			<c:when test="${dto.imgChk }">   <!--  이미지파일 이라면 -->
				<img src="../../up/${dto.upfileEn }" alt="" width="100px"/> <!-- 이미지파일 띄우기 -->
			</c:when>
			<c:otherwise> <!-- else 이미지 파일이 아니라면 -->
				<a href="FileDown?file=${dto.upfileEn }">${dto.upfile }</a> <!-- f컨트롤로 보내서 FileDown접근하기  인코딩된 file명을 가져간다.-->
			</c:otherwise>
		</c:choose>

		</td>
	</tr><tr>
	
</c:if>
		<td>내용</td><td>${dto.contentBr }</td>
	</tr><tr>
		<td colspan="2" align="right">
			<a href="DeleteForm?id=${dto.id }&page=${page }"">삭제</a> <!-- center/ 가 앞에 붙기 떄문에 모두 f컨트롤로 간다. -->
			<a href="ModifyForm?id=${dto.id }&page=${page }"">수정</a>
			<a href="ReplyForm?id=${dto.id }&page=${page }">답변</a>
			<a href="List?page=${page }">목록으로</a>
		</td>
	</tr>
</table>
