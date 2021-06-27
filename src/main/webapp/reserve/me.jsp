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
<title>본인 예약</title>
</head>
<style>
#reserve form>label{
	display:inline-block;
	width:200px;
}
#reserve .btn{
	 width:150px;height:100px;font-size:20px;
}
</style>
<body>
<h2>본인 예약하기</h2>
<div id='reserve'>
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		<div>
			<div>1단계 | 예약정보 입력</div>
			<div>2단계 | 예약완료 안내</div>
		</div>
		<br/>
		
		<div>
			<h3>개인정보 수집 및 이용에 대한 안내</h3>
			<p>「감염병의 예방 및 관리에 관한 법률」 제33조의 4 및 같은 법 시행령 제32조의 3에 따라 코로나19 예방접종 예약신청을 위하여 다음의 개인정보를 수집합니다</p>
		</div>
		
		<hr/>
		
		<label>이름</label>
		<input type='text'>
		<hr/>
		
		<label>주민등록번호</label>
		<input type='text'><span> - </span><input type='text'>
		<hr/>
		
		<label>본인인증</label>
		<input type='button' class='btn' id='btnSms' value='SMS 문자인증' onclick="smsPopup();"/>
		<input type='button' class='btn' id='btnEmail' value='e-mail 인증' onclick="emailPopup();"/>
		<br/>
		<label></label>
		<input type='text' value='본인 인증을 완료하여 주세요'/>
		<hr/>
		
		<label>예약 백신</label>
		<input type='text'>
		<hr/>
		
		<label>휴대폰 번호</label>
		<input type='text'><input type='text'><input type='text'>
		<br/>
		<span>* 본인 명의의 휴대폰이 아닌경우 온라인 예약이 불가능합니다.</span>
		<hr/>
		
		<label>의료기관 및 예약일시 선택</label>
		<input type='button' id='' value='의료기관 찾기'/>
		<input type='button' id='btnReserve' value='예약'/>
		<input type='button' value='취소' onclick='reserve.doReserve()'/>
		<hr/>
		
		<input type='hidden' id='authentication' value=''>
		
	</form>
</div>
<script>
reserve.init();
function smsPopup() {
	window.open("./reserve/sms.jsp", "a", "width=850, height=300, left=100, top=50");
	}
function emailPopup() {
	window.open("./reserve/email.jsp", "b", "width=850, height=300, left=100, top=50");
	}
</script>
</body>
</html>