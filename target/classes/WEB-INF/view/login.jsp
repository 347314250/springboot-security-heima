<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>用户登录</title>
</head>
<body>
		<h3>登录页面</h3><!--  -->
		<form  action="login"  method="post">
			用户名：<input type="input" name="username" /><br/>
			密&nbsp;&nbsp;&nbsp;码：<input type="input" name="password" /><br/>
			<input  type="checkbox"  name="remember">记住我<br/>
			<input type="submit" value="登录" />
		</form>
		
		
		
</body>
</html>