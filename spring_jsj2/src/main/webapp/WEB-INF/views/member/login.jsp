<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form class="container" action="<%=request.getContextPath()%>/login" method="post">
		<h1>로그인</h1>
		<div class="form-group">		  
		  <input type="text" class="form-control" placeholder="아이디" name="me_id">
		</div>
		<div class="form-group">
		  <input type="password" class="form-control" placeholder="비밀번호" name="me_pw">
		</div>
		<button class="btn btn-outline-success col-12">로그인</button>
	</form>
</body>
</html>