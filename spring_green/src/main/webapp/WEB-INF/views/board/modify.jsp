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
		<form class="container" action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
			<h1>게시글 수정</h1>
			
			<div class="form-group">	
				<label>제목</label>		  
				<input type="text" class="form-control" name="bd_title" value="${board.bd_title}">
			</div>	
			<div class="form-group attachment">
		        <label>첨부 파일</label>		        
		        <c:forEach items="${fileList}" var="file">  
					<div class="form-controll">
						<input type="hidden" name="fileNum" value="${file.fi_num}">
						<span>${file.fi_ori_name }</span>
						<a class="btn-close" href="#">X</a>
					</div>
				</c:forEach>
		        <c:forEach begin="1" end="${3-fileList.size()}">
		        	<input type="file" class="form-control" name="files2" >
		        </c:forEach>
		    </div>		
			<div class="form-group">			  
				<label>내용</label>
				<textarea class="form-control" rows="20" name="bd_content">${board.bd_content}</textarea>
			</div>			
			<button class="btn btn-outline-success" type="submit">수정</button>
			<input type="hidden" class="form-control" name="bd_num" value="${board.bd_num}">
		</form>
	</div>
	<script>
		$(function(){
			$(".attachment .btn-close").click(function(e){
				e.preventDefault();
				$(this).parent().remove();
				var str = '<input type="file" class="form-control" name="files2">'
				$('.attachment').append(str);
			})
		});
		

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
