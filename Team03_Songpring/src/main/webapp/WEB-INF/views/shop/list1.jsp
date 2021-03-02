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
	<li><a href="list1.do?genre=novel&order=${order}" style="${genre eq 'novel'? 'font-weight:bold;' : ''}">소설</a></li>
	<li><a href="list1.do?genre=culture&order=${order}" style="${genre eq 'culture'? 'font-weight:bold;' : ''}">교양</a></li>
	<li><a href="list1.do?genre=workbook&order=${order}" style="${genre eq 'workbook'? 'font-weight:bold;' : ''}">문제집</a></li>
	<li><a href="list1.do?genre=comicbook&order=${order}" style="${genre eq 'comicbook'? 'font-weight:bold;' : ''}">만화</a></li>
	<li><a href="list1.do?genre=dictionary&order=${order}" style="${genre eq 'dictionary'? 'font-weight:bold;' : ''}">사전</a></li>
</ul>
<ul>
	<li><a href="list1.do?order=highPrice&keyword=${encodedK}&genre=${genre}&writer=${writer}&publisher=${publisher}">최고가</a></li>
	<li><a href="list1.do?order=lowPrice&keyword=${encodedK}&genre=${genre}&writer=${writer}&publisher=${publisher}">최저가</a></li>
	<li><a href="list1.do?order=sellCount&keyword=${encodedK}&genre=${genre}&writer=${writer}&publisher=${publisher}">판매수</a></li>
	<li><a href="list1.do?order=date&keyword=${encodedK}&genre=${genre}&writer=${writer}&publisher=${publisher}">출판일</a></li>
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
				<p class="card-text"><small>저자</small> <a href="list1.do?writer=${tmp.writer }">${tmp.writer }</a> | <small>출판</small> <a href="list1.do?publisher=${tmp.publisher }">${tmp.publisher }</a> | ${tmp.regdate }</p>
				<p class="card-text">${tmp.price } 원</p>
			</div>
		</div>
	</div>
</c:forEach>
<nav>
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${startPageNum ne 1 }">
				<li class="page-item">
					<a class="page-link" href="list1.do?pageNum=${startPageNum-1}&keyword=${encodedK}&genre=${genre}&writer=${writer}&publisher=${publisher}&order=${order}">&laquo;</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<a class="page-link" href="javascript:">&laquo;</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<li class="page-item ${i eq pageNum? 'active' : '' }">
				<a class="page-link" href="list1.do?pageNum=${i}&keyword=${encodedK}&genre=${genre}&writer=${writer}&publisher=${publisher}&order=${order}">${i}</a>
			</li>
		</c:forEach>
		<c:choose>
			<c:when test="${endPageNum ne totalPageCount }">
				<li class="page-item">
					<a class="page-link" href="list1.do?pageNum=${endPageNum+1}&keyword=${encodedK}&genre=${genre}&writer=${writer}&publisher=${publisher}&order=${order}">&raquo;</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<a class="page-link" href="javascript:">&raquo;</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
</div>
</body>
</html>