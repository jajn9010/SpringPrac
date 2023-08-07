<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>
</head>
<body>
	<h3>${msg}</h3>
	<button type="button" onclick="location.href='${path}/user/updateForm.do?userid=${userid}'" >비밀번호 변경</button>
</body>
</html>