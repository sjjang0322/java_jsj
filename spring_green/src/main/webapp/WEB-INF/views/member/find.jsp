<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.box-tabs{
		border:1px solid #dee2e6;
		border-color : transparent #dee2e6 #dee2e6 #dee2e6; 
	}
</style>
<body>
<div class="body">
	<div class="container">
		<h1 class="text-center">아이디/비밀번호 찾기</h1>
		<ul class="nav nav-tabs">
		  <li class="nav-item">
		    <a class="nav-link active show-find-id" href="javascript:;" data-target=".find-id">아이디 찾기</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link show-find-pw" href="javascript:;" data-target=".find-id">비밀번호 찾기</a>
		  </li>
		</ul>
		<div class="box-tabs">
			<div class="find-id ml-1 mr-1 mt-5">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이름" name="me_name">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이메일" name="me_email">
				</div>
				<button class="btn btn-outline-success col-3 btn-find-id">아이디 찾기</button>
			</div>
			<div class="find-pw ml-1 mr-1 mt-5">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" name="me_id">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이메일" name="me_email">
				</div>
				<button class="btn btn-outline-success col-3 btn-find-pw">비밀번호 찾기</button>
			</div>
		</div>
	</div>
</div>
<script>
$(function(){
	$('.find-pw').hide();
});

$('.show-find-id').click(function(){
	$('.find-id').show();
	$('.find-pw').hide();
	$('.show-find-id').addClass('active');
	$('.show-find-pw').removeClass('active');
});

$('.show-find-pw').click(function(){
	$('.find-pw').show();
	$('.find-id').hide();
	$('.show-find-pw').addClass('active');
	$('.show-find-id').removeClass('active');
});

$('.btn-find-id').click(function(){
	var me_email = $('.find-id [name=me_email]').val();
	var me_name = $('.find-id [name=me_name]').val();
	var member = {
			me_email : me_email,
			me_name : me_name
	}
	
	$.ajax({
        async:false,
        type:'POST',
        data:JSON.stringify(member),
        url: '<%=request.getContextPath()%>/member/find/id',
        contentType:"application/json; charset=UTF-8",
        success : function(res){
			if(res==''){
				alert('일치하는 정보가 없습니다.');
			}else{
				alert('회원님의 아이디는 ' + res + '입니다.');
			}
        }
	});
});

$('.btn-find-pw').click(function(){
	var me_email = $('.find-pw [name=me_email]').val();
	var me_id = $('.find-pw [name=me_id]').val();
	var member = {
			me_email : me_email,
			me_id : me_id
	}
	
	$.ajax({
        async:false,
        type:'POST',
        data:JSON.stringify(member),
        url: '<%=request.getContextPath()%>/member/find/pw',
        contentType:"application/json; charset=UTF-8",
        success : function(res){
			console.log(res)
        }
	});
});
</script>
</body>
</html>