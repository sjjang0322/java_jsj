<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div class="body container">
		<select class="main-category">
			<option>대분류</option>
		</select>
		<select class="middle-category">
			<option>중분류</option>
		</select>
		<select class="sub-category">
			<option>소분류</option>
		</select>
	</div>
</body>
<script>
/*
async : 비동기이면 true, 동기이면 false
비동기는 ajax가 끝나지 않아도 다음코드가 실행.
동기는 ajax가 완료되어야 다음코드가 실행
data : 서버로 보낼 데이터
url : 데이터를 보낼 서버 url
dataType : 서버에서 보내준 데이터의 타입
contentType : 서버에 보낼 데이터(위의 data)의 타입
success : ajax를 이용하여 서버에 데이터 전송 후 서버에서 데이터를 처리 한 후
	성공했을 때 호출되는 함수
	- res : 서버에서 화면으로 보낸 데이터
*/


 
$(function(){
    $.ajax({
        async:false,
        type:'POST',
        data:{str : "sample"},
        url:"<%=request.getContextPath()%>/ajax/test1",
        //dataType:"json",
        //contentType:"application/json; charset=UTF-8",
        //contentType:"application/x-www-form-urlencoded;; charset=UTF-8",
        success : function(res){
            console.log(res);
        }
    });
    $.ajax({
        async:false,
        type:'POST',
        data:"sample",
        url:"<%=request.getContextPath()%>/ajax/test2",
        //dataType:"json",
        contentType:"application/json; charset=UTF-8",
        //contentType:"application/x-www-form-urlencoded;; charset=UTF-8",
        success : function(res){
            console.log(res);
            console.log('주소 : ' + res.address);
            console.log('주소 : ' + res['address']);
        }
    });
    $.ajax({
        async:false,
        type:'POST',
        data:JSON.stringify({id : "qwe", pw : "asd"}),
        url:"<%=request.getContextPath()%>/ajax/test3",
        dataType:"json",
        contentType:"application/json; charset=UTF-8",	        
        success : function(res){
            console.log(res);
            console.log('주소 : ' + res.address);
            console.log('주소 : ' + res['address']);
            console.log('id : ' + res.data.id);
            console.log('pw : ' + res.data.pw);
        }
    });
});

var idRegex = /^[A-z]\w{4,7}$/g;
$('#btn').click(function(){
	var id = $('#input').val();
	if(idRegex.test(id)){
		alert('정규표현식에 맞습니다.');
	}else{
		alert('정규표현식에 맞지 않습니다.');
	}
});



setMainCategory();
	
$('.main-category').change(function(){
	var ma_num = $(this).val();
	setMiddleCategory(ma_num);
});

$('.middle-category').change(function(){
	var mi_num = $(this).val();
	setSubCategory(mi_num);
});
	
function setMainCategory(){
	var str = '<option value ="0">대분류</option>';
	$.ajax({
		async:false,
        type:'get',	        
        url: '<%=request.getContextPath()%>/maincategory',
        dataType:"json",
        success : function(res){
        	var list = res.list;
			for(main of list){
				str+='<option value ="'+main.ma_num+'">'+main.ma_name+'</option>';
			}
        	$('.main-category').html(str);
        }
	});
}



function setMiddleCategory(ma_num){
	var str = '<option value ="0">중분류</option>';
	//대분류에서 대분류라는 항목이 선택된 경우
	if(ma_num <= 0){
		$('.middle-category').html(str);
		return;
	}
	$.ajax({
		async:false,
        type:'get',	        
        url: '<%=request.getContextPath()%>/middlecategory?mi_ma_num='+ma_num,
        dataType:"json",
        success : function(res){
        	console.log(res);
        	var list = res.list;
			for(middle of list){
				str+='<option value ="'+middle.mi_num+'">'+middle.mi_name+'</option>';
			}
        	$('.middle-category').html(str);
        }
	});		
}

function setSubCategory(mi_num){
	var str = '<option value ="0">소분류</option>';
	//중분류에서 중분류라는 항목이 선택된 경우
	if(mi_num <= 0){
		$('.sub-category').html(str);
		return;
	}
	$.ajax({
		async:false,
        type:'get',	        
        url: '<%=request.getContextPath()%>/subcategory?su_mi_num='+mi_num,
        dataType:"json",
        success : function(res){
        	var list = res.list;
			for(sub of list){
				str+='<option value ="'+sub.su_num+'">'+sub.su_name+'</option>';
			}
        	$('.sub-category').html(str);
        }
	});		
}
</script>
</html>
