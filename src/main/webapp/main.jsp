<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Petstagram</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<!-- Place favicon.ico in the root directory -->

<style>
#mainsection {
	width: 935px;
	margin: 0px 234.5px;
	padding: 30px 0px 0px;
	left: 50%;
	top: 50%;
}

#bigbox {
	width: 616px;
	height: auto;
	border: 1px solid gray;
	display: inline-block;
	left: 50%;
	top: 50%;
}

#writer {
	width: 614px;
	height: 70px;
	border: 1px solid gray;
}

#picture {
	width: 614px;
	height: 614px;
	border: 1px solid gray;
}

#reply {
	width: 614px;
	height: 177px;
	border: 1px solid gray;
}

#sidebox {
	float: right;
	width: 293px;
	height: 937px;
	margin: 0px 0px 30px;
	width: 293px;
}

#sideuser {
	width: 293px;
	height: 56px;
	border: 1px solid gray;
	background: #FAFAFA;
}

#sidefooter {
	width: 293px;
	height: 54px;
	margin: 0px 0px 3px;
	border: 1px solid gray;
}

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
	width: 65%;
	height: 100%;
	border: 1px solid black;
	float: left;
}

#modal .reply {
	width: 34%;
	height: 100%;
	border: 1px solid black;
	float: right;
}
</style>

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
<!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<body>
	<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

	<!-- header_start  -->
	<jsp:include page="common/header.jsp" />
	<!-- header_end  -->

	<section id="mainsection">
	<div style="">
		<!-- ???????????? ?????? footer??? ????????? ?????? ?????????????????? -->
		<!-- ????????? ?????? ???????????? ?????? ???????????? ?????????????????? -->
		<!-- ???????????? -->
		<c:choose>
		<c:when test="${member.memId!=bvo.memId}">
		<div id="sidebox" style="left: 876.5px;">
			<div id="sideuser">
				<div>
					<span><img style="width: 56px; height: 56px;"
						src="NewFeed/${member.memPic}"></span>&nbsp;<span
						style="inline-block: 95%; text-align: center;">${member.memId}</span>
					<span>${member.memNickname}</span>
				</div>
			</div>
		</div>
		</c:when>
		</c:choose>

		<!-- ???????????? ????????? ??? ????????????(????????????) ?????? -->
		<div id="modal" class="modal-overlay close-area">

			<div class="close-area"></div>
			<div class="modal-window">
				<div class="content">
					<div>
						<img src="" alt="????????? ????????? ???">
					</div>
				</div>
				<div class="reply">
					<div>${data.writer}</div>
					<!-- ???????????? ???????????? -->
					<div>${data.content}</div>
					<!-- ?????? ???????????? -->
					<div>${data.reply}</div>
					<!-- ???????????? ???????????? -->
				</div>
			</div>
		</div>


		<c:forEach var="bd" items="${datas}">
			<c:set var="bvo" value="${bd.boardVO }" />
			<div id="bigbox">
				<!-- ?????? ??? ?????? JSTL??? ??????????????? ??? -->
				<!-- ???????????? ????????? ??? -->
				<div id="writer">
					<div style="float: left; padding-top: 22px;">
						<span style="margin-left: 5px; width: 50%;"><img
							style="width: 32px; height: 32px;" src="NewFeed/${bd.memberVO}" alt=""> ${bvo.writer}</span>
						<c:choose>
							<c:when test="${member.memId!=bvo.memId}"> <!-- ???????????? ????????? ???????????? ???????????? -->
								<c:choose>
									<c:when test="${bd.follow=='true'}">
										<a
											href="deleteFollow.do?follower=${member.memId}&followee=${bvo.memId}"
											class="boxed_btn_white">????????????</a>
									</c:when>
									<c:when test="${bd.follow=='false'}">
										<a
											href="insertFollow.do?follower=${member.memId}&followee=${bvo.memId}"
											class="boxed_btn_white">?????????</a>
									</c:when>
								</c:choose>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${member.memId==bvo.memId}">
								<!-- ???????????? ????????? ?????????????????? ????????? ID??? ????????? -->
								<!-- ????????? EL??? ????????? ?????? ???????????? ?????? ???????????? ?????? -->
								<!-- ?????? ?????? ???????????? ?????? or ?????????????????? ???????????? -->
								<span style="text-align: right;"> <a
									href="updatePage.do?bid=${bvo.bid}"><img
										src="images/update.png"></a> <a
									href="deleteBoard.do?bid=${bvo.bid}&memId=${bvo.memId}"><img
										src="images/delete.png"></a>
								</span>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
			<!-- ????????? ????????? ??? -->
			<div id="picture">
				<span><img src="NewFeed/${bvo.pic}" id="picture" alt="??????"></span>
				<!-- ?????? EL??? ????????? ?????? -->
			</div>
			<!-- ????????? -->
			<div id="reply">
				<!-- ?????? ????????? ??? -->
				<span><strong>${bvo.writer}</strong> ${bvo.content}</span>

				<!-- ????????? ... -->
				
				<form action="board.do?bid=${bvo.bid}" method="post">
					<button type="submit">
						<img src="images/detail.png" alt="??? ????????????">
					</button>
				</form>
				<form action="insertReply.do" method="post" id="replyUploadForm"
					name="replyUpload">
					<input type="hidden" name="bid" value="${bvo.bid}">
					<div>
						<input type="text" name="msg" placeholder="?????? ??????">
						<button type="submit">??????</button>
					</div>
				</form>
				<!-- ?????? ?????? EL????????? ????????? ?????? -->
				<hr>
				<%-- <span>?????? ?????? : ${bvo.rpcnt}</span> <br> --%>
				<c:forEach var="r" items="${bd.replyList}">
					<span><strong>${r.memNickname}</strong> ${r.msg} ${r.rdate}</span>
					<c:if test="${member.memNickname==r.memNickname}">
						<a href="deleteReply.do?rid=${r.rid}"><img
							src="images/delete.png"></a>
					</c:if>
					<br>
				</c:forEach>
			</div>
			<br>
			<br>
		</c:forEach>
		</div>
	</section>





	<!-- JS here -->
	<script src="js/vendor/modernizr-3.5.0.min.js"></script>
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/ajax-form.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/imagesloaded.pkgd.min.js"></script>
	<script src="js/scrollIt.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/nice-select.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/gijgo.min.js"></script>

	<!--contact js-->
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>

	<script src="js/main.js"></script>
	<script>
		$('#datepicker').datepicker({
			iconsLibrary : 'fontawesome',
			disableDaysOfWeek : [ 0, 0 ],
		//     icons: {
		//      rightIcon: '<span class="fa fa-caret-down"></span>'
		//  }
		});
		$('#datepicker2').datepicker({
			iconsLibrary : 'fontawesome',
			icons : {
				rightIcon : '<span class="fa fa-caret-down"></span>'
			}

		});
		var timepicker = $('#timepicker').timepicker({
			format : 'HH.MM'
		});
	</script>

	<script>
	//????????? ????????????
const modal = document.getElementById("modal")
function modalOn() {
    modal.style.display = "flex"
    $('body').css("overflow", "hidden"); // ???????????? ????????? ???????????????
}
function isModalOn() {
    return modal.style.display === "flex"
}
function modalOff() {
    modal.style.display = "none"
    $('body').css("overflow", "scroll"); // ???????????? ?????? ????????? ????????????
}
const btnModal = document.querySelector(".btn-modal")//getElementById("btn-modal")
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