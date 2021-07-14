<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='../member/member.js'></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id='member'>
	<form id='frm_member' name='frm_member' method='POST' action=''>
		<label>아이디</label>
		<input type='text' id='findMid' name='findMid'>
		<label>비밀번호</label>
		<input type='text' id='findPwd' name='findPwd'>
		<input type='button' id='btnSearch' value='조회'>
		
		<br/>
		
		<label>검색된 이름</label>
		
		<c:forEach var='vo' items='${list }'>
		<input type='text' id='mid' name='mid' value='${vo.mname }'>
		</c:forEach>
	
	</form>
</div>
<script>
member.init();
</script>
</body>
</html>