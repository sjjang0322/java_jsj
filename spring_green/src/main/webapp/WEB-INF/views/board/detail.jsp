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
		<hr class="mt-3">
		<div class="comment-list mt-3">			
			<div class="comment-box  clearfix">
				<div class="float-left">└─</div>
				<div class="float-left">
					<div class="co_me_id">댓글 작성자</div>
					<div class="co_contents mt-2">댓글 내용</div>
					<div class="co_reg_date mt-2">댓글 작성 시간</div>
					<button class="btn-reply-comment btn btn-outline-success mt-2">답글</button>
					<button class="btn-mod-comment btn btn-outline-info mt-2">수정</button>
					<button class="btn-del-comment btn btn-outline-warning mt-2">삭제</button>
				</div>
			</div>
		</div>
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link" href="javascript:void(0);">이전</a></li>
			<li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>			
			<li class="page-item"><a class="page-link" href="javascript:void(0);">다음</a></li>
		</ul>
		<hr class="mt-3">
		<div class="input-group mt-3 mb-3">
		  <textarea class="form-control" rows="3" name="co_contents"></textarea>
		  <div class="input-group-append">
		    <button class="btn btn-success" id="comment-submit">댓글 등록</button>
		  </div>
		</div>
	</div>
	<script>
		var contextPath = '<%=request.getContextPath()%>';
		commentService.setContextPath(contextPath);		
		readComment(${board.bd_num});
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
		
		function readComment(co_bd_num){
			if(co_bd_num <= 0 || co_bd_num == null){
				return;
			}
			
			
			$.ajax({
		        async:false,
		        type:'get',		        
		        url:contextPath+"/comment/list?page=1&bd_num="+'${board.bd_num}',
		        success : function(res){
		        	var str = '';
		        	console.log(res);
		            for(tmp of res.list){
		            	str += createCommentStr(tmp);
		            }		            
		            $('.comment-list').html(str);
		        }
		    });
		}
		
		function createCommentStr(comment, me_id){
			var str =
				'<div class="comment-box clearfix">';
			if(comment.co_ori_num != comment.co_num){
			str+=	'<div class="float-left" style="width:24px">└</div>'+
					'<div class="float-left" style="whdth: calc(100% - 24px)">';
			}else{
			str+=	'<div class="float-left" style="whdth: 100%">';
			}
			str+=		'<div class="co_me_id"> 작성자 : '+comment.co_me_id+'</div>'+
						'<div class="co_contents mt-2">'+comment.co_contents+'</div>'+
						'<div class="co_reg_date mt-2"> 작성시간'+comment.co_reg_date+'</div>';
			if(comment.co_ori_num == comment.co_num)
			str+=		'<button class="btn-reply-comment btn btn-outline-success mt-2 mr-2">답글</button>';
			if(comment.co_me_id == me_id){
			str+=		'<button class="btn-mod-comment btn btn-outline-info mt-2 mr-2">수정</button>'+
						'<button class="btn-del-comment btn btn-outline-warning mt-2 mr-2">삭제</button>';
			}
					'</div>'+
					'<hr>'+
				'</div>';
			return str;
			
		}
	</script>
</body>
</html>
