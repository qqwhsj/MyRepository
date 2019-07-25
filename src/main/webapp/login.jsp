<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>登录</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />

<style type="text/css">
.myDiv {
	width: 336px;
	height: 290px;
	margin-top: 402px;
	margin-left: 806px;
	position: absolute;
	border-radius: 5px;
}
.inputText {
	border: 0px;
	border-bottom: 1px solid #8ad2a3;
	font-size: 18px;
	line-height: 50px;
	width: 100%;
	outline:none;
}
.inputBtn {
	margin-top: 30px;
	font-size: 24px;
	-moz-box-shadow: 0px 20px 30px #4de5a4; /* 老的 Firefox */
	box-shadow: 0px 20px 30px #4de5a4;
	background: linear-gradient(to right, #4de5a4 , #15a54d);
}
</style>
</head>
<body style="background: url('img/login.png') no-repeat;">
	<div class="myDiv">
		<form method="post" action="<c:url value=''/>">
		<input type="text" class="inputText" name="username" id="username" placeholder="请输入账号" autofocus value="admin" style="margin-top: 30px;"/><br>
		<input type="password" class="inputText" name="password" id="pwd" placeholder="请输入密码" value="feicui123" style="margin-top: 60px;"/><br>
		<input type="button" class="btn btn-success btn-lg btn-block inputBtn" value="登录" onclick="javascript:location.href='system/index/index.html'"/>
		</form>
	</div>
</body>
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</html>