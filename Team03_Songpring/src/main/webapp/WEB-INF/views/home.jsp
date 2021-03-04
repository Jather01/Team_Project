<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
	<div class="container">
		<h1>홈페이지</h1>
		<ul>
			<c:choose>
				<c:when test="${empty sessionScope.id }">
					<li><a href="users/testlogin.do">테스트용 로그인</a></li>
				</c:when>
				<c:otherwise>
					<li>${sessionScope.id }님 로그인 중</li>
				</c:otherwise>
			</c:choose>
			<li><a href="test.do">test</a></li>
			<li><a href="shop/list1.do">쇼핑몰 목록 보기1</a></li>
			<li><a href="shop/list2.do">쇼핑몰 목록 보기2</a></li>
			<li><a href="shop/manager/uploadform.do">책 판매 업로드</a></li>
			<li><a href="users/manager/users_list.do">유저 관리</a></li>
			<li><a href="notice/manager/insertform.do">공지 업로드</a></li>
			<li><a href="notice/list.do">공지 목록</a></li>
		</ul>
	</div>
</body>
</html>