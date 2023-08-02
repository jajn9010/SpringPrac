<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>writeform.jsp</title>
</head>
<body>
	<h3>회사 지점 위치 추가 글쓰기</h3>
	<form action="write.do" method="post">
		<table>
			<tr>
				<td>지점 번호 :</td>
				<td><input type="text" name="deptno"> </td>
			</tr>
			<tr>
				<td>영업소 명 :</td>
				<td><input type="text" name="dname"> </td>
			</tr>
			<tr>
				<td>위    치 :</td>
				<td><input type="text" name="loc"> </td>
			</tr>
		</table>
		<input type="submit" value="지점저장">&nbsp;&nbsp;
		<input type="reset" value="취소">&nbsp;&nbsp;
		<input type="button" value="List Page" onclick="location.href='list.do'">&nbsp;&nbsp;
	</form>
</body>
</html>