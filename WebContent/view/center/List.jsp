<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
난 List다
<!-- f컨트롤에서 M_Action을 통해 받아온 정보를 가지고 뿌리기 -->
<table border="" width="800px">
	<tr align="center">
		<td width="50px">번호</td>
		<td width="400px">제목</td>
		<td width="100px">작성자</td>
		<td width="200px">작성일</td>
		<td width="50px">조회수</td>
	</tr>
<c:forEach var="dto" items="${data }" varStatus="no">	  <!-- 향상된 for문을 사용하여 키 data의 정보를 dto로 하나씩 보내기  -->
	<tr>
		<td>${start + no.index + 1 }</td> <!-- varStatus는 포문이 하나씩 돌떄마다 1씩 증가한다 -->
		<td>
		<c:if test="${dto.lev>0 }">
			<c:forEach begin="1" end="${dto.lev }" step="1">
				&nbsp;&nbsp;
			</c:forEach>
			└
		</c:if>
		<a href="Detail?id=${dto.id }&page=${page}">${dto.title }</a></td> <!--같은 center폴더  Detail.jsp 보낼때  (center로 시작하기 떄문에)f컨트롤 먼저 간다. id를 보낸다. -->
		<td>${dto.pname }</td>
		<td><fmt:formatDate value="${dto.regdate }" pattern="yy-MM-dd HH:mm"/></td>
		<td>${dto.cnt }</td>
	</tr>
</c:forEach>

	<tr align="center">
		<td  colspan="5">
			<c:if test="${pageStart>1 }">
				<a href="?page=${pageStart-1 }">[이전]</a>
			</c:if>
			<c:forEach begin="${pageStart }" end="${pageEnd }" var="i" step="1">
				<c:choose>
					<c:when test="${i==page }">
						[${i }]
					</c:when>
					<c:otherwise>
						<a href="?page=${i }">${i }</a>	
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			<c:if test="${pageEnd<pageTotal }">
				<a href="?page=${pageEnd+1 }">[다음]</a>
			</c:if>
		</td>
	</tr>

	<tr align="right">
	
		<td  colspan="5">
		<a href="InsertForm">글쓰기</a></td>  <!-- 글쓰기 버튼을 누르면 center폴더에 있는 InsertForm.jsp파일로 보내기 -->
	</tr>
</table>
