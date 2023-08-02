<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>Login Form Page</title>
</head>
<body>
<h2>Login Form Page</h2>
	<form action="login.kosa"  method="post">
		<table>
			<tr>
				<td>ID  :</td>
				<td><input type="text"  name="id"></td>
			</tr>
			<tr>
				<td>PWD  :</td>
				<td><input type="password"  name="pwd"></td>
			</tr>
		</table>
	     <br /><br />
		 <input type="submit"  value="로그인"> &nbsp;&nbsp;
		 <input type="button" value="ID확인하기"  onclick="javascript:location.href='check.kosa'" /> 
	</form>	<p>
</body>
</html>