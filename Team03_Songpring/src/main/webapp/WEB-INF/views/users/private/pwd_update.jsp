<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/pwd_update.jsp</title>
</head>
<body>
<c:choose>
	<c:when test="${isSuccess }">
		<script>
			alert("비밀번호를 수정했습니다. 다시 로그인 해주십시오.");
			location.href="${pageContext.request.contextPath }/users/loginform.do";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("비밀번호 수정에 실패했습니다.");
			location.href="loginform.do?url=${requestScope.encodedUrl }/users/pwd_updateform.do";
		</script>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>