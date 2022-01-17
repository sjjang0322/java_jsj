<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="body container">
		<h1>게시글 수정</h1>
		<form action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<input type="text" class="form-control" name="bd_title" value="${board.bd_title}">
			</div>
		    <div class="form-group attachment">		    	
		    	<label>첨부파일(최대 3개)</label>  
		    	<c:forEach items="${fileList}" var="file">
			    	<div class="form-control">
			    		<input type="hidden" name="fileNums" value="${file.fi_num}">
			    		<span>${file.fi_ori_name}</span>
			    		<a class="btn-close" href="#">X</a>
		    		</div>
		    	</c:forEach>
		    	<c:forEach begin="1" end="${3-fileList.size()}">
		    		<input type="file" class="form-control" name="files">
		    	</c:forEach>
		    </div>
			<div class="form-group">
				<textarea class="form-control" name="bd_content" rows="10" >${board.bd_content}</textarea>
			</div>
			<input type="hidden" name="bd_num" value="${board.bd_num}">
			<button class="btn btn-outline-success col-12">수정</button>
		</form>
	</div>
	<script>
		$(function(){
			$('.attachment .btn-close').click(function(e){
				e.preventDefault();
				$(this).parent().remove();
				var str = '<input type="file" class="form-control" name="files">';
				$('.attachment').append(str);
			});
		});
	</script>
</body>
</html>