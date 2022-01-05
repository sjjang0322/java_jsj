<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	  <a class="navbar-brand" href="<%= request.getContextPath()%>">홈</a>
	  

	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="<%= request.getContextPath()%>/login">로그인</a>
	    </li>
	  </ul>
	</nav>
</body>
</html>