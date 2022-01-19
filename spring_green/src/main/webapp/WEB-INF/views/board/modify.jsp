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
		<form class="container" action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
			<h1>게시글 수정 </h1>
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
	</script>
</body>
</html>
