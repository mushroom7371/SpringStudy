<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src='./itemjs.js'></script>
<title>product</title>
</head>
<body>
<div id='item'>
	<form name='frm_item' id='frm_item' method='post' action=''>
			<input type='text' name='findStr' id='findStr'/>
			<input type='button' id='btnFindStr' value='조회'/>
	</form>
	
	<form name='frm_sql' id='frm_sql' method='post' action=''>
	<div>
		<br/>
		<c:forEach var='vo' items="${list }">
			<label>코드</label>
			<input type="text" name='pcode' id='pcode' value=${vo.pcode }>
			<label>제품명</label>
			<input type="text" name='pname' id='pname' value=${vo.pname }>
			<label>수량</label>
			<input type="text" name='su' id='su' value=${vo.su }>
			<label>가격</label>
			<input type="text" name='price' id='price' value=${vo.price }>
		</c:forEach>
	</div>
	
	<input type='button' id='btnUpdate' value='수정'/>
	<input type='button' id='btnDelete' value='삭제'/>
	</form>
</div>
<script>
item.init();
</script>
</body>
</html>