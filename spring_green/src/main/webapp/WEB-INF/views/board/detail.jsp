<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/comment.js"></script>
</head>
<body>
	<div class="body container">
		<form>
			<c:if test="${board.bd_type == '공지'}">
				<h1>공지사항 상세</h1>
			</c:if>
			<c:if test="${board.bd_type == '일반'}">
				<h1>게시글 상세</h1>
			</c:if>
			<div class="form-group">			  
			  <input type="text" class="form-control" name="title" value="제목 : ${board.bd_title}" readonly>
			</div>
			<div class="form-group">			  
			  <input type="text" class="form-control" name="id" value="작성자 : ${board.bd_me_id}" readonly>
			</div>
			<div class="form-group">			  
			  <input type="text" class="form-control" name="reg_date" value="작성일 : ${board.bd_reg_date_str}" readonly>
			</div>
			<div class="form-group">			  
			  <input type="hidden" class="form-control" name="bd_num" value="${board.bd_num}" readonly>
			</div>
			<div class="form-group">			
				<label>첨부 파일</label>
				<c:forEach items="${fileList}" var="file">  
					<a class="form-control" href="<%=request.getContextPath()%>/board/download?fileName=${file.fi_name}">${file.fi_ori_name }</a>
				</c:forEach>
			</div>
			<c:if test="${board.bd_up_date!=null}">
				<div class="form-group">			  
				  <input type="text" class="form-control" name="up_date" value="최종 수정일 : ${board.bd_up_date_str}" readonly>
				</div>
			</c:if>
			<div class="form-group">			  
			  <div class="form-control" id="content" style="height: auto; min-height: 400px">${board.bd_content}</div>
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
		<c:if test="${board.bd_type == '일반' }">
			<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_ori_num}">	
				<button class="btn btn-outline-success">답변</button>
			</a>
		</c:if>
		<div class="mt-3">
			댓글 리스트
		</div>
		<div class="input-group mb-3">
		  <textarea class="form-control" rows="3" name="co_contents"></textarea>
		  <div class="input-group-append">
		    <button class="btn btn-success" id="comment-submit">댓글 등록</button>
		  </div>
		</div>
	</div>
	<script>
		var contextPath = '<%=request.getContextPath()%>';
		commentService.setContextPath(contextPath);
		console.log(commentService.name);
		$('#comment-submit').click(function(){
			var co_contents = $('[name=co_contents]').val();
			var bd_num = $('[name=bd_num]').val();
			var co_me_id = '${user.me_id}';
			if(co_me_id == ''){
				alert('로그인 후 이용가능합니다.');
				return;
			}
			var comment = {
					co_contents : co_contents,
					co_bd_num : bd_num,
					co_me_id : co_me_id
			}
			console.log(comment);
			
			commentService.insert(comment, '/comment/register',function(res){
				if(res){
	            	alert('댓글 등록이 완료 되었습니다.')
	            	$('[name=co_contents]').val('');
	            }else{
	            	alert('댓글 등록에 실패 했습니다.');
	            }	
			});
		})
	</script>
</body>
</html>
