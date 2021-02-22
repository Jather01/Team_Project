<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
<jsp:include page="include/resource.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="include/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>홈페이지입니다.</h1>
		<ul>
			<li><a href="cafe/list.do">카페 글 목록 보기</a></li>
			<li><a href="file/list.do">자료실 목록 보기</a></li>
			<li><a href="gallery/list.do">갤러리 보기</a></li>
		</ul>
	</div>
</body>
</html>