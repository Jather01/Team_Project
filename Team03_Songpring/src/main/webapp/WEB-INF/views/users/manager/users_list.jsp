<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/manager/users_list.jsp</title>
<jsp:include page="../../include/resource.jsp"></jsp:include>
</head>
<body>
<div class="container">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>이메일</th>
				<th>주소</th>
				<th>등록일</th>
				<th>권한</th>
				<th>권한 부여</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="tmp" items="${list }">
			<tr>
				<td>${tmp.name }</td>
				<td>${tmp.id }</td>
				<td>${tmp.email}</td>
				<td>${tmp.useraddr1} ${tmp.useraddr2} ${tmp.useraddr3}</td>
				<td>${tmp.regdate }</td>
				<td>
					<c:choose>
						<c:when test="${empty tmp.grade || tmp.grade eq 'user' }">일반유저</c:when>
						<c:when test="${tmp.grade eq 'manager' }">관리자</c:when>
					</c:choose>
				</td>
				<td>
					<select name="grade" id="grade_${tmp.id }" onchange="chageGradeSelect('${tmp.id }')">
						<option value="user" ${tmp.grade eq 'user'? 'selected':'' }>일반유저</option>
						<option value="manager" ${tmp.grade eq 'manager'? 'selected':'' }>관리자</option>
					</select>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<script>
	function chageGradeSelect(id){
		var langSelect = document.getElementById("grade_"+id);
		var grade = langSelect.options[langSelect.selectedIndex].value; 
		console.log(id);
		console.log(grade);
		location.href="${pageContext.request.contextPath }/users/manager/users_manage.do?id="+id+"&grade="+grade;
	}
</script>
</body>
</html>