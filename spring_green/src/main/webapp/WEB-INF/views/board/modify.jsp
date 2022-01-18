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
		<form class="container" action="<%=request.getContextPath()%>/board/modify" method="post">
			<h1>게시글11 수정</h1>
			<div class="form-group">	
				<label>제목</label>		  
				<input type="text" class="form-control" name="bd_title" value="${board.bd_title}">
			</div>			
			<div class="form-group">			  
				<label>내용</label>
				<textarea class="form-control" rows="20" name="bd_content">${board.bd_content}</textarea>
			</div>			
			<button class="btn btn-outline-success" type="submit">수정</button>
			<input type="hidden" class="form-control" name="bd_num" value="${board.bd_num}">
		</form>
	</div>
</body>
</html>
