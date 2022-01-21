<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<div class="body">
		<form class="container" action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">
			<c:if test="${bd_type=='공지'}">
				<h1>공지사항 쓰기</h1>
			</c:if>
			<c:if test="${bd_type=='일반'}">
				<h1>글쓰기</h1>
			</c:if>
			<c:if test="${bd_ori_num != null}">
				<input type="hidden" name="bd_ori_num" value="${bd_ori_num}">
			</c:if>
			<input type="hidden" name="bd_type" value="${bd_type}">
			<div class="form-group">			  
				<label>제목</label>
				<input type="text" class="form-control" name="bd_title" placeholder="제목">
			</div>
		    <div class="form-group">
		        <label>첨부 파일</label>
		        <input type="file" class="form-control" name="files2">
		        <input type="file" class="form-control" name="files2">
		        <input type="file" class="form-control" name="files2">
		    </div>
			<div class="form-group">
				<label>내용</label>			  
				<textarea class="form-control" name="bd_content"></textarea>
			</div>
			<button class="btn btn-outline-success" type="submit">등록</button>			
		</form>
	</div>
	<script>
		$(document).ready(function() {
		    $('[name=bd_content]').summernote({
		    	placeholder: '내용',
			    tabsize: 2,
			    height: 400	
		    });
		});
	</script>
</body>
</html>
