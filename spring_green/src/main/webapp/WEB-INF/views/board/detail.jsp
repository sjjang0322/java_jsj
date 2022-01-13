<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div class="body container">
		<form>
			<h1>게시글</h1>
			<div class="form-group">			  
			  <input type="text" class="form-control" name="title" value="제목 : ${board.bd_title}" readonly>
			</div>
			<div class="form-group">			  
			  <input type="text" class="form-control" name="id" value="작성자 : ${board.bd_me_id}" readonly>
			</div>
			<div class="form-group">			  
			  <input type="text" class="form-control" name="reg_date" value="작성일 : ${board.bd_reg_date_str}" readonly>
			</div>
			<c:if test="${board.bd_up_date!=null}">
				<div class="form-group">			  
				  <input type="text" class="form-control" name="up_date" value="최종 수정일 : ${board.bd_up_date_str}" readonly>
				</div>
			</c:if>
			<div class="form-group">			  
			  <textarea class="form-control" rows="20" id="content" readonly>${board.bd_content}</textarea>
			</div>			
		</form>
		<c:if test="${board.bd_me_id == user.me_id}">
			<a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">	
				<button class="btn btn-outline-success">수정</button>
			</a>
			<a href="<%=request.getContextPath()%>/board/delete?bd_num=${board.bd_num}">	
				<button class="btn btn-outline-success">삭제</button>
			</a>
		</c:if>
	</div>
</body>
</html>
