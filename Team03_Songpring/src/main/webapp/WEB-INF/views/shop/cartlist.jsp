<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 목록</title>
<script>
$(function(){
    $("#btnDelete").click(function(){
        if(confirm("장바구니를 비우시겠습니까?")){
            location.href="${path}/shop/cart/deleteAll.do";
        }
    });
});
</script>
</head>
<body>
	<h2>장바구니 목록</h2>
	<c:choose>
		<c:when test="${map.count == 0 }">
			<!-- map에 자료가 아무것도 없다면 -->
        장바구니가 비었습니다.
    </c:when>
		<!-- map에 있는 list출력-->
		<c:forEach var="row" items="${map.list}">
			<tr align="center">
				<td>${row.product_name}</td>

				<td><fmt:formatNumber value="${row.price}" pattern="#,###,###" /></td>
				<!-- fmt:formatNumber 태그는 숫자를 양식에 맞춰서 문자열로 변환해주는 태그이다 -->

				<td><input type="number" name="amount" style="width: 30px;"
					value="<fmt:formatNumber value="${row.amount}"
 								pattern="#,###,###" />">
					<input type="hidden" name="cart_id" value="${row.cart_id}">


				</td>
				<td><fmt:formatNumber value="${row.money}" pattern="#,###,###" /></td>
				<!-- 장바구니 삭제 -->
				<td><a
					href="${path}/shop/cart/delete.do?cart_id=${row.cart_id}">[삭제]</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="right">장바구니 금액 합계 : <fmt:formatNumber
					value="${map.sumMoney}" pattern="#,###,###" /><br> 배송료 :
				${map.fee}<br> 총합계 : <fmt:formatNumber value="${map.sum}"
					pattern="#,###,###" />
			</td>
		</tr>
		<!-- </table> -->
		<button id="btnUpdate">수정</button>
		<button type="button" id="btnDelete">장바구니 비우기</button>
	</c:choose>
	<li><a href="shop/list1.do">쇼핑몰 목록 보기1</a></li>
</body>
</html>