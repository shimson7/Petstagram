<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petstagram</title>
<style>
#modal.modal-overlay {
	width: 100%;
	height: 100%;
	position: absolute;
	left: 0;
	top: 0;
	display: none;
	flex-direction: column;
	justify-content: center;
	background: #000000A6;
	box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
	backdrop-filter: blur(1.5px);
	-webkit-backdrop-filter: blur(1.5px);
	border-radius: 10px;
	border: 1px solid rgba(255, 255, 255, 0.18);
}

#modal .modal-window {
	background: white;
	align-self: center;
	box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
	backdrop-filter: blur(13.5px);
	-webkit-backdrop-filter: blur(13.5px);
	border-radius: 10px;
	border: 1px solid rgba(255, 255, 255, 0.18);
	width: 1421px;
	height: 937px;
	position: relative;
	padding: 10px;
}

#modal .close-area {
	
	align-self: right;
	padding-right: 10px;
	cursor: pointer;
	text-shadow: 1px 1px 2px gray;
	color: white;
}

#modal .content {
	width:65%;
	height : 100%;
	border: 1px solid black;
	float: left;
}

#modal .reply{
	width:34%;
	height : 100%;
	border: 1px solid black;
	float: right;
}
</style>

<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">

<!-- CSS here -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/themify-icons.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/gijgo.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/slicknav.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<!-- 모달창을 이용한 글쓰기 제작하려 했으나 일단은 모달창으로 보여주기만 나중에는 지울 예정 -->

	<div style="text-align: center; margin:0 auto;">
		<button id="btn-modal">Modal 띄우기</button>
	</div>
	
		<div id="modal" class="modal-overlay close-area">

			<div class="close-area"></div>
			<div class="modal-window">
				<div class="content">
					
						<img style="top:50%; left:50%; text-align: " class="content" src="NewFeed/${data.pic}" alt="그림이 들어올 곳">
					
				</div>
				<div class="reply">
					<div><strong>${data.writer}</strong></div> <!-- 글쓴이가 들어올곳 -->
					<div>${data.content}</div> <!-- 글이 들어올곳 -->
					<hr>
					<c:forEach var="rd" items="${datas}">
						<span><strong>${rd.memNickname}</strong> ${rd.msg} ${rd.rdate}</span><c:if test="${member.memNickname==rd.memNickname}">
							<a href="deleteReply.do?rid=${rd.rid}"><img src="images/delete.png"></a>
						</c:if>
						<br>
					</c:forEach>
					
				</div>
			</div>

		</div>


<script>
//모달창 스크립트
const modal = document.getElementById("modal")
function modalOn() {
    modal.style.display = "flex"
    $('body').css("overflow", "hidden"); // 켜졌을때 스크롤 불가능하게
}
function isModalOn() {
    return modal.style.display === "flex"
}
function modalOff() {
    modal.style.display = "none"
    $('body').css("overflow", "scroll"); // 꺼졌을때 다시 스크롤 가능하게
}
const btnModal = document.getElementById("btn-modal")
btnModal.addEventListener("click", e => {
    modalOn()
    modal.wrapper
})
const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modalOff()
})
modal.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modalOff()
    }
})

window.addEventListener("keyup", e => {
    if(isModalOn() && e.key === "Escape") {
        modalOff()
    }
})
</script>

</body>
</html>