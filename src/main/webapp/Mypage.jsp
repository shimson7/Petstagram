<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<!--
	Miniport by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>${member.memNickname} (@${member.memId})</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<style>
#nav {
	background-color: white;
	position: fixed;
	text-align: center;
	left: 0;
	top: 0;
	width: 100%;
	z-index: 10000;
	cursor: default;
	height: 60px;
	line-height: 60px;
}

#nav ul {
	margin-bottom: 0;
	list-style: none;
	padding-left: 0;
}

#nav li {
	display: inline-block;
	padding-left: 0;
}

#nav a {
	-moz-transition: background-color .2s ease-in-out;
	-webkit-transition: background-color .2s ease-in-out;
	-ms-transition: background-color .2s ease-in-out;
	transition: background-color .2s ease-in-out;
	position: relative;
	display: block;
	color: black;
	text-decoration: none;
	outline: 0;
	font-weight: 600;
	border-radius: 8px;
	color: black;
	height: 2.5em;
	line-height: 2.5em;
	padding: 0 1.25em;
}

#nav a:hover {
	color: white;
}

#nav a.active {
	background: #484848;
}

#nav a.active:before {
	content: '';
	display: block;
	position: absolute;
	bottom: -0.6em;
	left: 50%;
	margin-left: -0.75em;
	border-left: solid 0.75em transparent;
	border-right: solid 0.75em transparent;
	border-top: solid 0.6em #282828;
}
</style>
</head>
<body class="is-preload">

	<!-- Nav -->
	<nav id="nav">
		<div>
			<div>
				<ul class="container">
					<li><a href="main.do"><img src="images/instahome.ico"
							alt="인스타 홈 이미지"></a></li>
					<li><div><tag:login /></div></li>
					<li><a href="NewFeed.jsp"><img src="images/newfeed.ico"
							alt="새 글쓰기 이미지"></a></li>
					<li><a href="#portfolio"><img src="images/myfeed.ico"
							alt="내 글보기"></a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Home -->
	<article id="top" class="wrapper style1">
		<div class="container" style="text-align:center;">
			<div class="row">
				<div class="col-4 col-5-large col-12-medium">
					<span class="image fit"><img src="NewFeed/${member.memPic}" alt="" /></span>
				<!-- 사진 EL식으로 변경할 곳 -->
				</div>
				<div class="col-8 col-7-large col-12-medium">
					<span>${member.memfollower}</span>&nbsp;&nbsp;<span>${member.memfollowee}</span>
					<!-- 팔로워, 팔로우 -->
					<br>
					 <a href="moveUpdate.do?memId=${member.memId}" class="button scrolly">프로필 편집</a>
					<h1>${member.memNickname}</h1>
					<!-- 닉네임 -->
				</div>
			</div>
		</div>
	</article>

	<!-- 피드 -->
	<article id="portfolio" class="wrapper style3">
		<div class="container">
			<div class="row">
				<!-- 여기서부터 -->
				<c:forEach var="v" items="${datas}">
				<div class="col-4 col-6-medium col-12-small">
					<article class="box style2">
					<!-- 모달창 띄우는것으로 확인하게끔 발전시킬수 있음 -->
						<div href="common/modal.jsp" class="image featured"><img src="NewFeed/${v.pic}"
							alt="" style="padding: 15px; width: 383.344px; height: 268.531px;"/></div>
					</article>
				</div>
				</c:forEach>
				<!-- 여기까지 JSTL 반복하면 됨 -->
			</div>
		</div>
	</article>

	<!-- footer_start  -->
	<jsp:include page="common/footer.jsp" />
	<!-- footer_end  -->

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>