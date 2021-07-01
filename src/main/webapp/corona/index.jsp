<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<style>
#wrapper{
	border: 1px solid #000000;
	height: max-content;
	min-width:1642px;
	max-width:1642px;
	margin: 0 auto;
	
}


/* ---------------------------------------  */

#header{height: 140px;
	 border: 1px solid #000000;
}
#header>*{
	box-sizing: border-box;
}
#header>#header_logo{
	 height: 60px;
	 border: 1px solid #000000;
}
#header>#header_logo>#logo_IF{
    height: 50px;
    width: max-content;
    margin: 0 auto;
    line-height: 1.5;
}	
#header>#header_logo>#logo_IF>#icon{
    height: 31.5px;
    display: inline-block;
}
#header>#header_logo>#logo_IF>#icon>img{
	height: 100%;
}
#header>#header_logo>#logo_IF>#font{
	width: max-content;
    display: inline-block;
    font-size: 35px;
    font-weight: bold;
}
#header>#header_menu{
    height: 80px;
    border: 1px solid #000000;
    padding: 10px 220px 0 220px;    /* header 메뉴 높이 조절 */
}
#header>#header_menu>div{
	display: flex;
    text-align: center;
    line-height: 3.5;
    font-weight: bold;
    font-size: 16px;
    background-color: #0b9bc9;
    color: #ffffff;
    height: 60px;
}
#header>#header_menu>div>div{
	flex: 1;
	min-width: 118.75px;
	cursor: pointer;
}
#header>#header_menu>div>div:hover{
	border-bottom: 5px solid #0d427f;
}


/* ---------------------------------------  */


#middle{height: max-content;
	 	border: 1px solid #000000;
	 	box-sizing: border-box;
	 	margin-top: 0px;  		/* middle 위치 조절 */
	 	padding: 0 220px 0 220px;
} 

			/* load시 css */
#top_banner{
	height: 180px;
 	border: 1px solid #000000;
    padding: 0 220px 0 220px;
    margin-top: 10px;            /* 배너 위치 조절 */
}
#top_banner_content{
	width: 480px;
	height: 100%;
	border: 1px solid #000000;
	margin: 0 auto
	
}
#top_banner_content>img{
	width: 100%;
	height: 100%;
}


#corona{
	height: max-content;
 	border: 1px solid #000000;
}
#corona>#table{
	height: 100px;
	border: 1px solid #000000;
	margin-top: 30px
}
#corona>#table>#table_content{
	width: 660px;
	height: 100%;
	border: 1px solid #000000;
	margin: 0 auto;
}
#corona>#table>#table_content>img{
	width: 100%;
	height: 100%;
}
#corona>#map{
	height: 650px;
	border: 1px solid #000000;
	margin-top: 10px
}
#corona>#map>#map_content{
	height: 100%;
	margin: 0 auto;
	border: 1px solid #000000;
}
#corona>#map>#map_content>img{
    width: 100%;
    height: 100%;
}
#bottom_banner{
	height: 220px;
 	border: 1px solid #000000;
}
#bottom_banner>#banner_content{
	height: 220px;
 	border: 1px solid #000000;
 	margin: 0 auto;
 	display: flex;
}
#bottom_banner>#banner_content>.content{
	flex:1;
 	border: 1px solid #000000;
 	margin: 15px;
 	border-radius: 8px;
}
#bottom_banner>#banner_content>.content>.content_title{
    height: 85px;
    border: 1px solid #000000;
    margin: 0 auto;
    margin-top: 25px;
    font-size: 25px;
    width: 345px;
}
#bottom_banner>#banner_content>.content>.content_title>.font_point{
	font-weight: bold;
}
#bottom_banner>#banner_content>.content>.content_title>.font_color{
color:#fbb003;
	font-weight: bold;
}
#bottom_banner>#banner_content>.content>.content_sub{
    height: 50px;
    border: 1px solid #000000;
    margin: 0 auto;
    margin-top: 5px;
    display: flex;
    width: 345px;
}
#bottom_banner>#banner_content>.content>.content_sub>.name{
	flex:2;
	border: 1px solid #000000;
	color:#8a8a8a;
}
#bottom_banner>#banner_content>.content>.content_sub>.button{
	flex:1;
	border: 1px solid #000000;
}
#bottom_banner>#banner_content>.content>.content_sub>.button>input{
    width: 90px;
    height: 40px;
    background-color: #ffffff00;
    margin: 5px auto;
    display: block;
    font-size: 15px;
    font-weight: bolder;
    color: #545454;
    border-radius: 8px;
}
#bottom_link{
 	height: 190px;
    border: 1px solid #000000;
    margin: 20px 0;
    display: flex;
    
}
#bottom_link>div{
	flex:1;
	padding:15px;
	border: 1px solid #000000;
	background-color: #ccc;
    
}
#bottom_link>#link1{
  background-color: #18407d;
  font-weight: bold;
  color: #d1ffff;
}
#bottom_link>#link1>div{
  border: 1px solid #000000;
  margin-top: 60px;
  font-size: 12px;
}
#bottom_link>.bottom_link>a>img{
	width:100%;
	height: 100%;
}	 	

	 	
/* ---------------------------------------  */	 	
#footer{height: 150px;
	    border-top: 3px solid #000000;
	    background-color: #f8f8f8;
        padding: 0 220px 0 220px;
} 
#footer>*{
	box-sizing: border-box;
}	    



</style>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="header_logo">
			<div id="logo_IF">
				<div id="icon">
					<img alt="손바닥이미지" src="./son.png">
				</div>
				<div id="font">
					코로나! 멈춰!
				</div>
			</div>
		</div>
		<div id="header_menu">
			<div id="menu_wrapper">
				<div>바로알기</div>
				<div>발생동향</div>
				<div>뉴스&이슈</div>
				<div>홍보자료&FAQ</div>
				<div>피해지원정책</div>
				<div>공지사항</div>
				<div>사회적거리두기</div>
				<div>마스크착용</div>
			</div>
		</div>
	</div>
	<div id="middle"> <!-- 여기 div에 load 시키세요! -->
		<div id="top_banner">
			<div id="top_banner_content">
				<img alt="배너이미지" src="http://ncov.mohw.go.kr/upload/ncov/20210629173254.png"> <!-- 임시 이미지  -->
			</div>
		</div>
		<div id="corona">		<!-- 지영씨 메인 페이지 load 할곳  -->
			<div id="table">
				<div id="table_content">
					<img alt="테이블이미지" src="./table.png">
				</div>
			</div>
			<div id="map">
				<div id="map_content">
					<img alt="map이미지" src="./map.png"> <!-- 임시 이미지  -->
				</div>
			</div>
		</div>
		<div id="bottom_banner">
			<div id="banner_content">
				<div id="content1" class="content">
					<div class="content_title">코로나19 예방접종<br/><font class="font_point">온라인</font><font class="font_color">예약방법</font></div>
					<div class="content_sub">
						<div class="name">누구나 편리하게<br/>이용할 수 있도록</div>
						<div class="button">
							<input type="button" value="자세히">
						</div>
					</div>
				</div>
				<div id="content2" class="content">
					<div class="content_title">코로나19 예방접종<br/><font class="font_color">콜센터</font><font class="font_point">안내</font></div>
					<div class="content_sub">
						<div class="name">취약계층을 위한<br/>콜센터 운영</div>
						<div class="button">
							<input type="button" value="자세히">
						</div>
					</div>
				</div>
				<div id="content3" class="content">
					<div class="content_title">사업참여<br/><font class="font_color">의료기관</font><font class="font_point">찾기</font></div>
					<div class="content_sub">
						<div class="name">코로나19 예방접종사업<br/>참여의료기관 정보</div>
						<div class="button">
							<input type="button" value="자세히">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="bottom_link">
			<div id="link1" class="bottom_link">
				#지금 우리는<br/>
				#힘내라 대한민국<br/>
				#우리는 할 수 있습니다<br/>
				#코로나19 물렀거라!
				<div>국민을 응원하는 영상을 선별하여 게재합니다.</div>
			</div>
			<div id="link2" class="bottom_link">
				<a target="_blank" href=" https://youtu.be/APOt56usrt4">
					<img alt="코로나 link 이미지1" src="http://ncov.mohw.go.kr/upload/ncov/20210331144816.jpg">
				</a>
			</div>
			<div id="link3" class="bottom_link">
				<a target="_blank" href=" https://youtu.be/hlcrgEeF9nQ">
					<img alt="코로나 link 이미지2" src="http://ncov.mohw.go.kr/upload/ncov/20210305171415.jpg">
				</a>
			</div>
			<div id="link4" class="bottom_link">
				<a target="_blank" href=" https://youtu.be/z4V-svP6yY8">
					<img alt="코로나 link 이미지3" src="http://ncov.mohw.go.kr/upload/ncov/20210115160226.jpg">
				</a>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</div>



</body>
</html>