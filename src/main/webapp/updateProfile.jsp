<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>회원 정보수정</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<!-- Place favicon.ico in the root directory -->

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

	<!-- bradcam_area_start -->
	<div class="bradcam_area breadcam_bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="bradcam_text text-center">
						<h3>
							<a href="main.do">Petstagram</a>
						</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- bradcam_area_end -->

	<!-- ================ contact section start ================= -->
	<section class="contact-section">
		<div class="">
			<div class="col-12">
				<h2 class="contact-title">회원 정보수정</h2>
			</div>
			<div class="">
				<form class="form-contact contact_form" action="updateMember.do"
					method="post" id="updateForm" novalidate="novalidate">
					<div class="" style="margin: 0 auto;">
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control valid" name="memNickname"
									value="${member.memNickname}" type="text"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '닉네임'" placeholder="닉네임">
							</div>
						</div>
						<br>
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control valid" name="memPw"
									value="${member.memPw}" type="password"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '비밀번호'" placeholder="비밀번호">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control valid" name="memPic" type="file"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '사진'" placeholder="사진">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control valid" name="memId" type="hidden"
									value="${member.memId }">
							</div>
						</div>
					</div>
					<div class="form-group mt-3" style="margin-left: 15px;">
						<button type="submit" class="button button-contactForm boxed-btn">수정하기</button>
					</div>
				</form>
				<div class="form-group mt-3" style="margin-left: 15px;">
					<a href="deleteMember.jsp"
						class="button button-contactForm boxed-btn">탈퇴하기</a>
				</div>
			</div>
		</div>
	</section>
	<!-- ================ contact section end ================= -->

	<!-- footer_start  -->
	<jsp:include page="common/footer.jsp" />
	<!-- footer_end  -->

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
		// ID,이메일 정규식
		function is_valid_email(value) {
			if (!value)
				return true
			let email_format = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
			return email_format.test(value)
		}
		// 비밀번호 정규식
		function is_valid_password(value) {
			if (!value)
				return true
			let pw_format = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{5,16}$/
			return pw_format.test(value)
		}
	</script>

	<script type="text/javascript">
		function memberdelete() {
			ans = confirm("정말 탈퇴하시겠습니까? 데이터는 복원되지않습니다.");
			if (ans == true) {
				document.checkForm.action.value = "deleteMember.do?memId=${member.memId}";
				document.checkForm.submit();
			} else {
				return;
			}
		}
	</script>

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
</body>

</html>