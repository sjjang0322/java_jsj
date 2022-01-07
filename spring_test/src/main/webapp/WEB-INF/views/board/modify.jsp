<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="body container">
		<h1>게시글 수정</h1>
		<form action="<%=request.getContextPath()%>/board/modify" method="post">
			<div class="form-group">
				<input type="text" class="form-control" name="bd_title" placeholder="제목" value="${board.bd_title}">
			</div>
			<div class="form-group">
				<textarea class="form-control" name="bd_content" placeholder="내용" rows="10" >${board.bd_title}</textarea>
			</div>
			<button class="btn btn-outline-success col-12">수정</button>
		</form>
	</div>
</body>
</html>