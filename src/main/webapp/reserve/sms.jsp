<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<script src='./js/reserve.js'></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>SMS 인증 </title>
</head>
<style>
#reserve form>label{
	display:inline-block;
	width:150px;
}
</style>
<body>
<div id='reserve'>
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		<h2>SMS 문자인증 페이지입니다.</h2>
		<label>휴대폰 번호</label>
		<input type='text'><input type='text'><input type='text'>
		<input type='button' value='인증번호 발송'/>
		<br>
		<label>인증 번호</label>
		<input type='text'>
		<input type='button' value='인증번호 확인'/>
	</form>
</div>
</body>
</html>