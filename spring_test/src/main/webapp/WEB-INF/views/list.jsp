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
		<div class="container">
			<c:if test="${ pm.criteria.type == '일반'}">
				<h1>게시글 목록</h1>
			</c:if>
			<c:if test="${ pm.criteria.type == '공지'}">
				<h1>공지사항</h1>
			</c:if>
			<form class="input-group mb-3" action="<%=request.getContextPath()%>/board/list" method="get">
			  <input type="text" class="form-control" placeholder="검색할 제목을 입력하세요" name="search" value="${pm.criteria.search}">
			  <div class="input-group-append">
			    <button class="btn btn-success" type="submit">검색</button>
			  </div>
			</form>
			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${list}">
						<tr>
					        <td>${board.bd_num}</td>
					        <c:if test="${board.bd_num==board.bd_ori_num}">
					        	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
					        </c:if>
					        <c:if test="${board.bd_num!=board.bd_ori_num}">
					        	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">└답변:${board.bd_title}</a></td>
					        </c:if>
					        <td>${board.bd_me_id}</td>
					        <td>${board.bd_reg_date_str}</td>
					        <td>${board.bd_views}</td>				        
				  	    </tr>
			  	    </c:forEach>
				</tbody>
			</table>
			<c:if test="${user!=null}">
				<c:if test="${pm.criteria.type!='공지'||user.me_authority !='회원' }">
					<a href="<%=request.getContextPath()%>/board/register?type=${pm.criteria.type}">
						<button class="btn btn-outline-success">글쓰기</button>
					</a>
				</c:if>
			</c:if>
			
			<ul class="pagination justify-content-center" >			    
		        <li class="page-item <c:if test="${!pm.prev }">disabled</c:if>">
		            <a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&search=${pm.criteria.search}&type=${pm.criteria.type}">Previous</a>
		        </li>		    
			    <c:forEach begin="${pm.startPage }" end="${pm.endPage}" var="index">
			        <li class="page-item <c:if test="${pm.criteria.page == index}">active</c:if>">
			            <a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&search=${pm.criteria.search}&type=${pm.criteria.type}">${index}</a>
			        </li>
			    </c:forEach>			    
		        <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
		            <a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&search=${pm.criteria.search}&type=${pm.criteria.type}">Next</a>
		        </li>			    
			</ul>
		</div>
	</div>
</body>
</html>
