<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:forEach var="list" items="${list}">
		<h3>번호 : ${list.deptno}</h3>
		<h3>이름 : ${list.dname}</h3>
		<h3>위치 : ${list.loc}</h3><hr />
	</c:forEach>
	<input type="button" onclick="javascript:location.href='writeform.do'" value="지점저장">&nbsp;
	<input type="button" onclick="javascript:location.href='hello.do'" value="메인으로">
</body>
</html>