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
	}
	/* ul 요소의 기본 스타일 제거 */
	.reviews ul{
		padding: 0;
		margin: 0;
		list-style-type: none;
	}
	.reviews dt{
		margin-top: 5px;
	}
	.reviews dd{
		margin-left: 50px;
	}
	.review-form textarea, .review-form button{
		float: left;
	}
	.reviews li{
		clear: left;
	}
	.reviews ul li{
		border-top: 1px solid #888;
	}
	.review-form textarea{
		width: 85%;
		height: 100px;
	}
	.review-form button{
		width: 15%;
		height: 100px;
	}
	/* 댓글에 댓글을 다는 폼과 수정폼은 일단 숨긴다. */
	.reviews .review-form{
		display: none;
	}
	/* .reply_icon 을 li 요소를 기준으로 배치 하기 */
	.reviews li{
		position: relative;
	}
	pre {
	  display: block;
	  padding: 9.5px;
	  margin: 0 0 10px;
	  font-size: 13px;
	  line-height: 1.42857143;
	  color: #333333;
	  word-break: break-all;
	  word-wrap: break-word;
	  background-color: #f5f5f5;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	}
</style>
</head>
<body>
<div class="container">
	<div class="row no-gutters">
		<div class="img-div">
			<img class="img-wrapper" src="${pageContext.request.contextPath }${shopDto.imagePath}">
		</div>
		<div class="col-md-4 padding-10">
			<div class="card-body">
				<h3 class="card-title">[
					<c:choose>
						<c:when test="${shopDto.genre eq 'novel'}">소설</c:when>
						<c:when test="${shopDto.genre eq 'culture'}">교양</c:when>
						<c:when test="${shopDto.genre eq 'workbook'}">문제집</c:when>
						<c:when test="${shopDto.genre eq 'comicbook'}">만화</c:when>
						<c:when test="${shopDto.genre eq 'dictionary'}">사전</c:when>
					</c:choose>
					] ${shopDto.title }</h3>
				<p class="card-text"><small>저자</small> ${shopDto.writer } | <small>출판</small> ${shopDto.publisher }</p>
				<p class="card-text"><small>판매 수</small> ${shopDto.sellCount }</p>
				<p class="card-text">${shopDto.price } 원</p>
				<table class="table table-striped">
					<tbody>
						<tr>
							<th>출간일</th>
							<td>${shopDto.regdate }</td>
						</tr>
						<tr>
							<th>쪽수</th>
							<td>${shopDto.page }쪽</td>
						</tr>
						<tr>
							<th>크기</th>
							<td>${shopDto.bookSize }mm</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div>
		<h4>책 설명</h4>
		<p>${shopDto.content }</p>
	</div>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation">
		<a class="nav-link active" id="review-tab" data-toggle="tab" href="#review"
			role="tab" aria-controls="review" aria-selected="true">Review</a>
		</li>
		<li class="nav-item" role="presentation">
		<a class="nav-link" id="QnA-tab" data-toggle="tab" href="#QnA"
			role="tab" aria-controls="QnA" aria-selected="false">Q&A</a>
		</li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="review" role="tabpanel"
			aria-labelledby="review-tab">
			<!-- 원글에 리뷰를 작성하는 form -->
			<form class="review-form insert-form" action="private/review_insert.do" method="post">
				<!-- 원글의 글번호가 bookNum 번호가 된다. -->
				<input type="hidden" name="bookNum" value="${shopDto.num }"/>
				<textarea name="content"><c:if test="${empty id }">로그인이 필요합니다</c:if></textarea>
				<button type="submit">등록</button>
			</form>
			<!-- 댓글 목록 -->
			<div class="reviews">
				<ul>
					<c:forEach var="tmp" items="${list }">
						<li id="review${tmp.num }" style="padding-left:50px;">
							<dl>
								<dt>
									<span>${tmp.writer }</span>
									<span>${tmp.regdate }</span>
									<c:if test="${tmp.writer eq id }">
										| <a data-num="${tmp.num }" href="javascript:" class="review-update-link">수정</a>
										| <a data-num="${tmp.num }" href="javascript:" class="review-delete-link">삭제</a>
									</c:if>
								</dt>
								<dd><pre>${tmp.content }</pre></dd>
							</dl>
							<!-- 로그인된 아이디와 리뷰의 작성자가 같으면 수정 폼 출력 -->
							<c:if test="${tmp.writer eq id }">
								<form class="review-form update-form" action="private/review_update.do" method="post">
									<input type="hidden" name="num" value="${tmp.num }"/>
									<textarea name="content">${tmp.content }</textarea>
									<button type="submit">수정</button>
								</form>
							</c:if>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="tab-pane fade" id="QnA" role="tabpanel"
			aria-labelledby="QnA-tab">
			
		</div>
	</div>
</div>
<script>
	//댓글 수정 링크를 눌렀을때 호출되는 함수 등록
	$(document).on("click",".review-update-link", function(){
		/*
			click 이벤트가 일어난 댓글 수정 링크에 저장된 data-num 속성의 값을 
			읽어와서 id 선택자를 구성한다.
		*/
		var selector="#review"+$(this).attr("data-num");
		//구성된 id  선택자를 이용해서 원하는 li 요소에서 .update-form 을 찾아서 동작하기
		$(selector)
		.find(".update-form")
		.slideToggle();
	});
	//로딩한 jquery.form.min.js jquery플러그인의 기능을 이용해서 댓글 수정폼을 
	//ajax 요청을 통해 전송하고 응답받기
	$(document).on("submit", ".update-form", function(){
		//이벤트가 일어난 폼을 ajax로 전송되도록 하고 
		$(this).ajaxSubmit(function(data){
			//수정이 일어난 댓글의 li 요소를 선택해서 원하는 작업을 한다.
			var selector="#review"+data.num; //"#review6" 형식의 선택자 구성
			
			//댓글 수정 폼을 안보이게 한다. 
			$(selector).find(".update-form").slideUp();
			//pre 요소에 출력된 내용 수정하기
			$(selector).find("pre").text(data.content);
		});
		//폼 전송을 막아준다.
		return false;
	});
	
	$(document).on("click",".review-delete-link", function(){
		//삭제할 글번호 
		var num=$(this).attr("data-num");
		let isDelete=confirm("리뷰를 삭제 하시겠습니까?");
		if(isDelete){
			location.href="${pageContext.request.contextPath }"+
			"/shop/private/review_delete.do?num="+num+"&bookNum=${shopDto.num}";
		}
	});
	$(document).on("submit",".insert-form", function(){
		//로그인 여부
		var isLogin=${not empty id};
		if(isLogin == false){
			alert("로그인 페이지로 이동합니다.")
			location.href="${pageContext.request.contextPath }/users/loginform.do?"+
					"url=${pageContext.request.contextPath }/shop/detail.do?num=${shopDto.num}";
			return false; //폼 전송 막기 		
		}
	});
	function deleteReview(num){
		var isDelete=confirm("이 제품을 삭제 하시겠습니까?");
		if(isDelete){
			location.href="delete.do?num=${dto.num}";
		}
	}
</script>
</body>
</html>