<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>membercheckSuccess.jsp</title>
</head>
<body>

<h2>
	<c:forEach var="ok" items="${ok}">
		${ok.id} &nbsp;&nbsp;&nbsp;
		${ok.name} &nbsp;&nbsp;&nbsp;
		${ok.age}<hr />
	</c:forEach>
</h2>
<input type="button" value="뒤로가기"  onclick="javascript:location.href='check.kosa'" />
<input type="button" value="로그인"  onclick="javascript:location.href='login.kosa'" />
	membercheckSuccess move
</body>
</html>