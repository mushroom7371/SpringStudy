<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<script src='./js/reserve.js'></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>백신예약~</title>
</head>
<style>
#reserveindex .btn{
 	width:150px;height:100px;font-size:20px;
}
</style>
<body>
<div id='reserveindex'>
<h2>백신 예약</h2>
<input type='button' class='btn' value='백신 예약' onclick='reserve.doReserve()'/>
<input type='button' class='btn' value='예약 조회' onclick='reserve.sc()'/>

</div>
</body>
</html>