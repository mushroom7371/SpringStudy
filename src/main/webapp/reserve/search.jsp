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
<title>예약 조회</title>
</head>
<style>
#reserve form>label{
	display:inline-block;
	width:200px;
}
</style>
<body>
<h2>예약 결과가 조회 되었습니다.</h2>
<div id='reserve'>
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		<div>
			<div>1단계 | 본인인증 및 예약여부 확인</div>
			<div>2단계 | 예약정보 조회</div>
		</div>
		<br/>
		
		<h3>예약자 정보</h3>
		<hr/>
		<label>예약자 이름</label>
		<input type='text'>
		<hr/>
		<label>예약자 주민등록번호</label>
		<input type='text'><span> - </span><input type='text'>
		<hr/>
		
		<h3>예약 정보</h3>
		<label>예약 번호</label>
		<input type='text'>
		<hr/>
		<label>접종 받는 분 이름</label>
		<input type='text'>
		<hr/>
		<label>접종 받는 분 주민등록번호</label>
		<input type='text'><span> - </span><input type='text'>
		<hr/>
		<label>예약 백신</label>
		<input type='text'>
		<hr/>
		<label>예약 의료기관</label>
		<input type='text'>
		<input type='button' value='의료기관 정보 확인'/>
		<hr/>
		<label>접종 일시</label>
		<input type='text'>
		<hr/>
		<input type='button' id='btnCancle' value='예약 취소'/>
		<input type='button' value='홈으로'/>
		<hr/>
	
	</form>
</div>
<script>reserve.init();</script>
</body>
</html>