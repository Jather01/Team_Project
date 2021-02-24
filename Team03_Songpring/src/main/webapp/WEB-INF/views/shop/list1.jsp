<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shop/list1.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
<style>
	.img-wrapper {
		width: 150px;
		height: 200px;
		object-fit: scale-down;
	}
	.img-div {
		padding-left: 10px;
		padding-right: 10px;
	}
	.row {
		height: 200px;
		border: 1px solid gray;
		border-radius: 5px;
	}
	.padding-10 {
		padding-left: 10px;
		padding-right: 10px;
	}
	a {
		color: #000;
	}
</style>
</head>
<body>
<div class="container">
<ul>
	<li><a href="list1.do?genre=novel">소설</a></li>
	<li><a href="list1.do?genre=culture">교양</a></li>
	<li><a href="list1.do?genre=workbook">문제집</a></li>
	<li><a href="list1.do?genre=comicbook">만화</a></li>
	<li><a href="list1.do?genre=dictionary">사전</a></li>
</ul>
<ul>
	<li><a href="list1.do?order=highPrice">최고가</a></li>
	<li><a href="list1.do?order=lowPrice">최저가</a></li>
	<li><a href="list1.do?order=sellCount">판매수</a></li>
	<li><a href="list1.do?order=date">출판일</a></li>
</ul>
<c:forEach var="tmp" items="${list }">
	<div class="row no-gutters">
		<a href="detail.do?num=${tmp.num}">
			<div class="img-div">
				<img class="img-wrapper" src="${pageContext.request.contextPath }${tmp.imagePath}">
			</div>
		</a>
		<div class="col-md-8 padding-10">
			<div class="card-body">
				<h5 class="card-title">[
					<c:choose>
						<c:when test="${tmp.genre eq 'novel'}">소설</c:when>
						<c:when test="${tmp.genre eq 'culture'}">교양</c:when>
						<c:when test="${tmp.genre eq 'workbook'}">문제집</c:when>
						<c:when test="${tmp.genre eq 'comicbook'}">만화</c:when>
						<c:when test="${tmp.genre eq 'dictionary'}">사전</c:when>
					</c:choose>
					] <a href="detail.do?num=${tmp.num}">${tmp.title }</a></h5>
				<p class="card-text"><small>저자</small> <a href="list1.do?writer=${writer }">${tmp.writer }</a> | <small>출판</small> <a href="list1.do?writer=${publisher }">${tmp.publisher }</a> | ${tmp.regdate }</p>
				<p class="card-text">${tmp.price } 원</p>
			</div>
		</div>
	</div>
</c:forEach>
</div>
<script>
	
</script>
</body>
</html>