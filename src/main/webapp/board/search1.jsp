<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id='board'>
<h2>게시판 조회(String MVC)</h2>
		<div class='find_zone'>
			<input type='search' name='findStr' value='${param.findStr }'/>
			<input type='button' value='검색' id='btnFind'/>
		</div>
		<br/>
	
	<div class='title'>
		<span class='subject'>제목</span>
		<span class='mid'>작성자</span>

	</div>

	<div class='items'>
		<c:forEach var='vo' items="${list}">
		<div>
			<span>${vo.subject }</span>
			<span>${vo.mid }</span>
		</div>
		</c:forEach>
	</div>
</div>
</body>
</html>