<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원가입</title>
	<script src="../js/jquery.min.js"></script>
	<!-- datepicker -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">  
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<!-- 주소입력 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

	
	<style>

	</style>
</head>
<body>
	<form action="<%=request.getContextPath() %>/signup" method="post">
		<input type="text" name="me_id" id="id" placeholder="아이디"> <br>
		<input type="password" name="me_pw" id="pw" placeholder="비밀번호"> <br>
		<input type="password" name="pw2" id="pw2" placeholder="비밀번호 확인"> <br>
		<input type="text" name="me_name" id="name" placeholder="이름"> <br>
		<input type="text" name="me_phone" id="phone" placeholder="전화번호"> <br>
		성별 <br>
		<input type="radio" name="me_gender" id="man">남자
		<input type="radio" name="me_gender" id="woman">여자 <br>
		생년월일 <br>
		<input type="text" name="birthday" id="birthday"> <br>
		주소 <br>
		<input type="text" id="sample6_postcode" placeholder="우편번호">
		<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample6_address" placeholder="주소"><br>
		<input type="text" id="sample6_detailAddress" placeholder="상세주소">
		<input type="text" id="me_address" style="display : block">		
		 <br>
		<input type="checkbox" name="terms" id="terms">약관 동의 <br>
		<button type="submit" class="submit">회원가입</button>		
	</form>
	
	<script>
		$(function(){
			// datepicker
			$( "#birthday" ).datepicker();
			$( "#birthday" ).datepicker("option", "dateFormat", "yy-mm-dd");
			
			/* 조건 변수 */
			// 공란이 있음
			isBlank = true;
			// 비밀번호 불일치
			isPass = false;
			// 약관 미동의
			isAgree = false;
			
			// 비밀번호 입력시
			$('input[type=password]').change(function(){
				if($('#pw').val()==$('#pw2').val()){
					isPass=true;
				}
			})

			// 약관 동의 클릭
			$('#terms').click(function(){
				isAgree = $('#terms').prop('checked');
			})

			// 회원가입 클릭
			$('.submit').click(function(){
				isBlank=false;
				if($('#id').val()==''){
					isBlank=true;
				}
				if($('#pw').val()==''){
					isBlank=true;
				}				
				if($('#name').val()==''){
					isBlank=true;
				}
				if($('#phone').val()==''){
					isBlank=true;
				}
				if(!$('input[name=me_gender]').prop('checked')){
					isBlank=true;
				}
				if($('#birthday').val()==''){
					isBlank=true;
				}
				if($('#sample6_postcode').val()==''){
					isBlank=true;
				}
				if($('#sample6_address').val()==''){
					isBlank=true;
				}
				if($('#sample6_detailAddress').val()==''){
					isBlank=true;
				}
				
				console.log(isBlank);
				if(isBlank){
					alert('빈칸이 있습니다.');
					return false;
				}
				if(!isPass){
					alert('비밀번호가 일치하지 않습니다.');
					return false;
				}
				if(!isAgree){
					alert('약관에 동의하지 않았습니다.');
					return false;
				}			
				
				
				return false;
			})




		});
		// 주소입력
		function sample6_execDaumPostcode() {
			new daum.Postcode({
				oncomplete: function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var addr = ''; // 주소 변수
					var extraAddr = ''; // 참고항목 변수

					//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
					}

					// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
					if(data.userSelectedType === 'R'){
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
									extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if(data.buildingName !== '' && data.apartment === 'Y'){
									extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
							}

					
					} 

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample6_postcode').value = data.zonecode;
					document.getElementById("sample6_address").value = addr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("sample6_detailAddress").focus();
				}
			}).open();
		}	
	</script>	
</body>
</html>