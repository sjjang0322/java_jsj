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
		<div class="likes-btn-box mb-2">
			<button class="btn btn-outline-primary btn-up" data-value="1">추천</button>
			<button class="btn btn-outline-danger btn-down" data-value="-1">비추천</button>
		</div>
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
		<div class = "comment-pagination">
			
		</div>
		<hr class="mt-3">
		<div class="input-group mt-3 mb-3">
		  <textarea class="form-control text-comment" rows="3" name="co_contents"></textarea>
		  <div class="input-group-append">
		    <button class="btn btn-success" id="comment-submit">댓글 등록</button>
		  </div>
		</div>
	</div>
<script>
	var contextPath = '<%=request.getContextPath()%>';
	commentService.setContextPath(contextPath);		
	
	$(function(){
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
			
			if(co_contents == ''){
				alert('댓글을 입력하세요.');
				return;
			}
			
			commentService.insert(comment, '/comment/register',function(res){
				//댓글 등록에 성공하면
	    		if(res == true){
	    			//입력한 댓글을 지워줌
	    			$('.text-comment').val('');
	    			alert('댓글 등록이 완료되었습니다.');
	    			//새로고침(전체가 아닌 댓글부분만)을 하여 1페이지에 맞는 댓글을 새로 가져옴
	    			var co_bd_num = '${board.bd_num}';
	    			readComment(co_bd_num,1);			    			
	    		}else{
	    			alert('댓글 등록에 실패했습니다.');
	    		}
			});
		})
	
		$(document).on('click', '.comment-pagination .page-item', function(){	
			if($(this).hasClass('disabled')){
				return;
			}
			var page = $(this).data('page');
			var co_bd_num = '${board.bd_num}';
			readComment(co_bd_num, page);
			var listUrl = '/comment/list?page='+page+'&bd_num='+'${board.bd_num}'+'&bd_type='+'${board.bd_type}';			
			commentService.list(listUrl,listSuccess);
		});
		
		$(document).on('click', '.btn-del-comment', function(){			
			var co_num = $(this).data('num');
			//var co_num = $(this).attr('data-num');
			var deleteUrl = '/comment/delete?co_num=' + co_num;
			commentService.delete(deleteUrl, deleteSuccess);
		});
		
		$(document).on('click', '.btn-mod-comment', function(){			
			commentInit();
			$(this).parent().children('button').hide();
			$(this).siblings('.co_contents').hide();
			var text = $(this).siblings('.co_contents').text();
			var textarea 
				= '<textarea class="form-control co_contents2">'+text+'</textarea>';
			$(this).siblings('.co_contents').after(textarea);
			var co_num = $(this).data('num');
			var button
				= '<button class="btn btn-outline-info btn-mod-insert" data-num="'+ co_num +'">댓글 수정</button>';
			$(this).siblings('.co_reg_date').after(button);
		});
		//댓글 수정 등록 버튼 클릭 이벤트
		$(document).on('click', '.btn-mod-insert', function(){
			var co_contents = $('.co_contents2').val();
			var co_num = $(this).data('num');				
			var comment = {
					co_contents : co_contents,
					co_num : co_num
			}
			commentService.modify(comment, '/comment/register', registerSuccess);
		})
		
		$(document).on('click', '.btn-reply-comment', function(){			
			commentInit();
			var co_num = $(this).data('num');
			var str = '<textarea class="form-control co_contents2" rows="3"></textarea>';				
			var buttonStr = '<button class="btn btn-outline-success btn-rep-insert" data-num="'+ co_num +'">답글 등록</button>';
			$(this).parent().children('button').hide();
			$(this).parent().append(str);
			$(this).parent().append(buttonStr);				
		});			
		
		$(document).on('click', '.btn-rep-insert', function(){
			var co_contents = $('.co_contents2').val();
			var co_ori_num = $(this).data('num');
			var co_bd_num = '${board.bd_num}';
			var co_me_id = '${user.me_id}';
			var comment = {
					co_contents : co_contents,
					co_ori_num : co_ori_num,
					co_bd_num : co_bd_num,
					co_me_id : co_me_id
			}
			console.log(comment);
			commentService.reply(comment, '/comment/register', insertSuccess);
		});
		
		//댓글 불러오기
		var listUrl = '/comment/list?page=1&bd_num='+'${board.bd_num}'+'&bd_type='+'${board.bd_type}';			
		commentService.list(listUrl,listSuccess);			
		loadLikes({li_bd_num : '${board.bd_num}'});
	});
	

	$('.likes-btn-box .btn').click(function(){
		var li_me_id = '${user.me_id}';
		var li_bd_num = '${board.bd_num}';
		var li_state = $(this).data('value');
		var likes = {
				li_me_id : li_me_id,
				li_bd_num : li_bd_num,
				li_state : li_state
		}
//		if($(this).hasClass('active')){
//			$(this).removeClass('active');
//		}else{
//			$(this).parent().children().removeClass('active');
//			$(this).addClass('active');
//		}
		$.ajax({
	        async:false,
	        type:'POST',
	        data:JSON.stringify(likes),
	        url: '<%=request.getContextPath()%>/board/likes',
	        contentType:"application/json; charset=UTF-8",
	        success : function(res){
				if(res==1){
					alert('추천하였습니다.');
				}else if(res==-1){
					alert('비추천하였습니다.')
				}else if(res==0){
					if(li_state==1)
						alert('추천을 취소했습니다.')
					else
						alert('비추천을 취소했습니다.')
				}else{
					alert('로그인이 필요합니다.')
				}
				loadLikes({li_bd_num : '${board.bd_num}'});
	        }
		});
		
	});
	
//	$(function(){
//		if(${dblikes!=null}){
//			if(${dblikes.li_state==1})
//				$('.btn-up').addClass('active');
//			else if(${dblikes.li_state==-1})
//				$('.btn-down').addClass('active');
//		}
//	});
	
	function getDateToString(date){
		return "" + date.getFullYear() + "-" + 
			(date.getMonth()+1) + "-" +
			date.getDate() + "-" +
			date.getHours() + ":" +
			date.getMinutes();
	}
	
	function commentInit(){
		$('.comment-box').each(function(){
			$(this).find('.co_contents2').remove();
			$(this).find('.btn-mod-insert').remove();
			$(this).find('.btn-rep-insert').remove();
			$(this).find('button').show();
			$(this).find('.cocontents').show();
		});
	}
	

	
	function deleteSuccess(res){
		if(res){
			alert('댓글을 삭제했습니다.')
			var listUrl = '/comment/list?page=1&bd_num='+'${board.bd_num}'+'&bd_type='+'${board.bd_type}';
			commentService.list(listUrl,listSuccess);
		}else{
			alert('댓글 삭제에 실패했습니다.')
		}
	
	}
	
	
	function readComment(co_bd_num, page){
		if(co_bd_num <= 0 || co_bd_num == null){
			return;
		}
		if(page <=0 || page == null){
			page = 1;
		}
		console.log(page);
		
		$.ajax({
	        async:false,
	        type:'get',		        
	        url:contextPath+"/comment/list?page="+1+"&bd_num="+'${board.bd_num}'+"&bd_type="+'${board.bd_type}',
	        success : function(res){
	        	var str = '';
	        	var me_id = '${user.me_id}'
	        	console.log(res);
	            for(tmp of res.list){
	            	str += createComment(tmp, me_id);
	            }		            
	            $('.comment-list').html(str);
	            
	            var paginationStr = createPagination(res.pm);
	            $('.comment-pagination').html(paginationStr);
	        }
	    });
	}
	
	function createComment(comment, me_id){
		var co_reg_date = getDateToString(new Date(comment.co_reg_date));
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
					'<div class="co_reg_date mt-2"> 작성시간'+co_reg_date+'</div>';
		if(comment.co_ori_num == comment.co_num)
		str+=		'<button class="btn-reply-comment btn btn-outline-success mt-2 mr-2" data-num="'+comment.co_num+'">답글</button>';
		if(comment.co_me_id == me_id){
		str+=		'<button class="btn-mod-comment btn btn-outline-info mt-2 mr-2" data-num="'+comment.co_num+'">수정</button>'+
					'<button class="btn-del-comment btn btn-outline-warning mt-2 mr-2" data-num="'+comment.co_num+'">삭제</button>';
		}
		str+=	'</div>'+
				'<hr>'+
			'</div>';
		return str;
		
	}
	
	function createPagination(pm){
		var prevDisabled = pm.prev ? '' : 'disabled';
		var nextDisabled = pm.next ? '' : 'disabled';
		var page = pm.criteria.page;			
		var str = '';
		str+=	'<ul class="pagination comment-pagination justify-content-center">';
		str+=		'<li class="page-item '+prevDisabled+'" data-page="'+(pm.startPage - 1)+'"><a class="page-link" href="javascript:void(0);">이전</a></li>';
		for(i = pm.startPage; i<=pm.endPage; i++){
			var active = page == i ? 'active' : '';
			str+=	'<li class="page-item '+active+'" data-page="'+i+'"><a class="page-link" href="javascript:void(0);">'+i+'</a></li>';
		}
		str+=		'<li class="page-item '+nextDisabled+'" data-page="'+(pm.endPage + 1)+'"><a class="page-link" href="javascript:void(0);">다음</a></li>';
		str+=	'</ul>';
		return str;
	}
	
	function listSuccess(res){
		var str = '';
	    var me_id = '${user.me_id}';
	    console.log(res);
	    if(res.list.length == 0){
	    	$('.comment-list').html('');
	    	$('.comment-pagination').html('');
	    	return;
	    }
	    for(tmp of res.list){
	    	console.log(tmp);
	    	str += createComment(tmp, me_id);
	    }
	    $('.comment-list').html(str);
	    
	    var paginationStr = createPagination(res.pm);
	    $('.comment-pagination').html(paginationStr);
	}
	
	function insertSuccess(res){
		if(res){
           	alert('댓글 등록이 완료 되었습니다.')
           	$('[name=co_contents]').val('');	     
           	var bd_type = '${board.bd_type}'
           	var bd_num = '${board.bd_num}'
           	var listUrl = '/comment/list?page=1&bd_num='+bd_num+'&bd_type='+bd_type;
           	commentService.list(listUrl,listSuccess)
           }else{
           	alert('댓글 등록에 실패 했습니다.');
           }
	}
	
	function modifySuccess(res){
		if(res){
			var bd_type = '${board.bd_type}'
			var page = $('.comment-pagination .active').data('page');
			var listUrl = '/comment/list?page='+page+'&bd_num='+'${board.bd_num}&bd_type='+bd_type;
        	commentService.list(listUrl,listSuccess);
		}
	}
	
	function loadLikes (likes){
		$.ajax({
	        async:false,
	        type:'POST',
	        data:JSON.stringify(likes),
	        url: '<%=request.getContextPath()%>/board/likes/views',
	        contentType:"application/json; charset=UTF-8",
	        success : function(res){
				$('.btn-up')
					.addClass('btn-outline-primary')
					.removeClass('btn-primary');
				$('.btn-down')
					.addClass('btn-outline-danger')
					.removeClass('btn-danger');
				if(res == -1){
					$('.btn-down')
						.removeClass('btn-outline-danger')
						.addClass('btn-danger');
				}else if(res == 1){
					$('.btn-up')
						.removeClass('btn-outline-primary')
						.addClass('btn-primary');
				}
	        }
		});
	}
	
	
</script>
</body>
</html>
