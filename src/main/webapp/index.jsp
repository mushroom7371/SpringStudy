<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱인덱스</title>
<script src='./js/board.js'></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id='index'>
	<h2>Spring MVC</h2>
	<a href='board/search.board'>조회(연습)</a>
	<input type='button' value='게시판' onclick='brd.home()'/>
	
	<hr/>
	<div id='board'></div>
	
	
	
</div>
</body>
</html>