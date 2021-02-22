<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-dark bg-primary navbar-expand-sm fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${pageContext.request.contextPath }/">
			<img style="width:30px; heigth:30px;" src="${pageContext.request.contextPath }/resources/images/yellowbird.png"></img>Acorn</a>
		<button class="navbar-toggler" data-toggle="collapse" data-target="#topNav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="topNav">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item ${param.thisPage eq 'cafe' ? 'active':'' }">
					<a class="nav-link" href="${pageContext.request.contextPath }/cafe/list.do">카페 글 목록</a></li>
				<li class="nav-item ${param.thisPage eq 'file' ? 'active':'' }">
					<a class="nav-link" href="${pageContext.request.contextPath }/file/list.do">자료실 목록</a></li>
				<li class="nav-item ${param.thisPage eq 'gallery' ? 'active':'' }">
					<a class="nav-link" href="${pageContext.request.contextPath }/gallery/list.do">갤러리 목록</a></li>
			</ul>
		</div>
		<c:choose>
			<c:when test="${empty sessionScope.id }">
				<a class="btn btn-success btn-sm" href="${pageContext.request.contextPath }/users/loginform.do">로그인</a>
				<a class="btn btn-danger btn-sm ml-1" href="${pageContext.request.contextPath }/users/signup_form.do">회원 가입</a>
			</c:when>
			<c:otherwise>
				<span class="navbar-text">
					<a href="${pageContext.request.contextPath }/users/private/info.do">${sessionScope.id }</a>님 로그인 중...
					<a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath }/users/logout.do">로그아웃</a>
				</span>
			</c:otherwise>
		</c:choose>
	</div>
</nav>