<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>loginSuccess.jsp</title>
</head>
<body>
	<h1>${USERID} 님 환영합니다.</h1>
	<form action="logout.kosa" method="post">
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>