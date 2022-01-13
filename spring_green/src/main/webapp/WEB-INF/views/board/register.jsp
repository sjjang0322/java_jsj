<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div class="body">
		<form class="container" action="<%=request.getContextPath()%>/board/register" method="post">
			<h1>글쓰기</h1>
			<div class="form-group">			  
				<label>제목</label>
				<input type="text" class="form-control" name="bd_title" placeholder="제목">
			</div>
			<div class="form-group">
				<label>내용</label>			  
				<textarea class="form-control" rows="20" name="bd_content" placeholder="내용"></textarea>
			</div>
			<button class="btn btn-outline-success" type="submit">등록</button>			
		</form>
	</div>
</body>
</html>
