<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>test2</title>
</head>
<body>
<form action="/spring/test2" method="get">
	<input type="text" name="num1" placeholder="정수1" value="${num1}"> +
	<input type="text" name="num2" placeholder="정수2" value="${num2}"> =
	<input type="text" readonly value="${result}">
	<button type="submit">전송</button>
</form>

</body>
</html>
