<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="changeDiv">
		<div class="changePwd">비밀번호 입력하기</div>
		<form action="${path}/user/update.do" method="post" class="changePwdForm">
			<input type="password" name="passwd" placeholder="기존 비밀번호 입력하기"> <br/>
			<input type="password" name="changePwd" placeholder="바꿀 비밀번호를 입력하세요."> <br/>
			<input type="password" name="changeCheckPwd" placeholder="바꿀 비밀번호를 한번더 입력하세요."> <br/>
			<input type="hidden" value="${userid}" name="userid">
			<input type="submit" value="변경하기">
		</form>
	</div>
</body>
</html>