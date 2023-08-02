<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>joinForm.jsp</title>
</head>
<body>
<form action="join.kosa"  method="post">
	<table>
		<tr>
			<td>ID :</td>
			<td><input type="text"  name="id"></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><input type="text"  name="name"></td>
		</tr>
		<tr>
			<td>PassWd :</td>
			<td><input type="password"  name="pwd"></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><input type="email"  name="email"></td>
		</tr>
		<tr>
			<td>Age :</td>
			<td><input type="text"  name="age"></td>
		</tr>
	</table>
	 <input type="submit"  value="가입" > &nbsp;&nbsp;
	 <input type="reset"  value="취소" >
</form>
</body>
</html>