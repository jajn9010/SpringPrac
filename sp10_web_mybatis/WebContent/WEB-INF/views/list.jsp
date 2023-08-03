<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
	<h1>List Page</h1>
	<table style="border: 1px solid #005b23; text-align: center;">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.seq}</td>
				<td>
					<a href="board?cmd=detail&seq=${list.seq}">${list.title}</a>
				</td>
				<td>${list.writer}</td>
				<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${list.readcount}</td>
				<td><a href="board?cmd=delete&seq=${list.seq}">삭제</a></td>
			</tr>
		</c:forEach>
	</table> <br />
	
	<input type="button" value="글쓰기" onclick="location.href='board?cmd=writeForm'">
	<input type="button" value="검색하기" onclick="location.href='board?cmd=searchForm'">
	</body>
</html>