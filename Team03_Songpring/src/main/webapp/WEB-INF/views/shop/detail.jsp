<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shop/detail.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
<style>
	.img-wrapper {
		width: 450px;
		height: 600px;
		object-fit: scale-down;
	}
	.img-div {
		padding-left: 10px;
		padding-right: 10px;
	}</style>
</head>
<body>
<div class="container">
	<div class="row no-gutters">
		<div class="img-div">
			<img class="img-wrapper" src="${pageContext.request.contextPath }${dto.imagePath}">
		</div>
		<div class="col-md-4 padding-10">
			<div class="card-body">
				<h3 class="card-title">[
					<c:choose>
						<c:when test="${dto.genre eq 'novel'}">소설</c:when>
						<c:when test="${dto.genre eq 'culture'}">교양</c:when>
						<c:when test="${dto.genre eq 'workbook'}">문제집</c:when>
						<c:when test="${dto.genre eq 'comicbook'}">만화</c:when>
						<c:when test="${dto.genre eq 'dictionary'}">사전</c:when>
					</c:choose>
					] ${dto.title }</h3>
				<p class="card-text"><small>저자</small> ${dto.writer } | <small>출판</small> ${dto.publisher }</p>
				<p class="card-text"><small>판매 수</small> ${dto.sellCount }</p>
				<p class="card-text">${dto.price } 원</p>
				<table class="table table-striped">
					<tbody>
						<tr>
							<th>출간일</th>
							<td>${dto.regdate }</td>
						</tr>
						<tr>
							<th>쪽수</th>
							<td>${dto.page }쪽</td>
						</tr>
						<tr>
							<th>크기</th>
							<td>${dto.bookSize }mm</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div>
		<h4>책 설명</h4>
		<p>${dto.content }</p>
	</div>
</div>
</body>
</html>