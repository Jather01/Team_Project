<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shop/list1.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
</head>
<body>
<div class="container">
<ul>
	<li><a href="">장르 : 소설</a></li>
	<li><a href="">장르 : 교양</a></li>
	<li><a href="">장르 : 문제집</a></li>
	<li><a href="">장르 : 만화</a></li>
	<li><a href="">장르 : 사전</a></li>
</ul>
<c:forEach var="tmp" items="${list }">
	<div class="card mb-3">
		<div class="row">
			<div class="col-md-4">
				<img src="${pageContext.request.contextPath }${tmp.imagePath}">
			</div>
			<div class="col-md-8">
				<div class="card-body">
					<h5 class="card-title">${title }</h5>
					<p class="card-text">${writer } / ${publisher } / ${regdate }</p>
					<p class="card-text">
						<small class="text-muted">${price }</small>
					</p>
				</div>
			</div>
		</div>
	</div>
</c:forEach>
</div>
</body>
</html>