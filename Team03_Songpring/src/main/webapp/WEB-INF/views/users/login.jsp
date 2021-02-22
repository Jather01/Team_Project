<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/login.jsp</title>
</head>
<body>
<c:choose>
	<c:when test="${requestScope.isValid }">
		<script>
			alert("로그인 되었습니다.");
			location.href="${requestScope.url }";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("로그인에 실패 헸습니다.");
			location.href="loginform.do?url=${requestScope.encodedUrl }";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>
