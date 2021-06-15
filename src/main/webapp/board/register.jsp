<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>게시판 입력</title>
<script src='./js/board.js'></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel='stylesheet' type='text/css' href='./css/board.css'>
</head>
<body>
<div id='board'>

	<h1>게시판 입력</h1>
	<form name='frm_board' id='frm_board' method='post' action=''>

		<label>작성자</label>
		<input type='text' name='mid' value='juna' />
		<br/>
		
		<label>제목</label>
		<input type='text' name='subject' value='hi~' />
		<br/>
		
		<textarea name='doc'></textarea>
		<br/>
		
		<label>암호</label>
		<input type='password' name='pwd' />
		<br/>
		
		<input type='text' name='nowPage' value='${param.nowPage }'/>
		<input type='text' name='findStr' value='${param.findStr }'/>
		<input type='text' name='serial' value='${param.serial }'/>
	</form>
	
	<form name='frm_upload' id='frm_upload' method='post'>
		<label>파일첨부</label>
		<input type='file' name='attfile' id='attfile' multiple/>
		
		<div id='image_preview'>
			<div id='attzone'></div>
		</div>
	</form>
			
	<div id='btn_zone'>
		<input type='button' value='작성' id='btnInsertR'>
		<input type='button' value='취소' id='btnSearch'/>
	<!-- reset은 모두 삭제가 아니라 초기값으로 설정해준다. -->
	</div>
</div>
<script>
brd.init();
imageView('attfile', 'attzone');
</script>
</body>
</html>