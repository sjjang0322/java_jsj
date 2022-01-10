<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="body">
		<div class="container">
			<h1 class="text-center">로그인</h1>
			<form action="<%=request.getContextPath()%>/login" method="post">
				<div class="form-group">
					<input type="text" name="me_id" placeholder="아이디" class="form-control">
				</div>
				<div class="form-group">
					<input type="password" name="me_pw" placeholder="비밀번호" class="form-control">
				</div>
				<button type="submit" class="btn btn-outline-success col-12">로그인</button>
			</form>
		</div>
	</div>
</body>
</html>