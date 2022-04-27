<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>회원가입</title>
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
						<h3>Petstagram 회원가입</h3>
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
				<h2 class="contact-title">친구들의 사진과 동영상을 보려면 가입하세요.</h2>
			</div>
			<div class="">
				<form class="form-contact contact_form" action="insertMember.do"
					method="post" id="signupForm" novalidate="novalidate">
					<!-- novalidate로 유효성 검사 생략하였음 사용자가 정상이라는 가정하에 -->
					<div class="" style="margin: 0 auto;">
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control valid" name="memId" type="text"
									id="id" onfocus="this.placeholder = ''"
									onblur="this.placeholder = '아이디'" placeholder="아이디">
							</div>
							<!-- 가능하면 나중에 ID 중복 확인 추가 -->
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control valid" name="memPw" type="password"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '비밀번호'" placeholder="비밀번호">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control valid" name="memNickname" type="text"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '닉네임'" placeholder="닉네임">
							</div>
						</div>

						<div class="col-sm-6">
							<h5>나를 표현할 프로필 사진</h5>
							<div class="form-group">
								<input class="form-control valid" name="memPic" type="file"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '사진'" placeholder="사진">
							</div>
						</div>
						<div class="imgPreview">
							이미지 미리보기<br>
							<img id="preview" width="400px" height="300px" /> 
						</div>
					</div>
					<div class="form-group mt-3" style="margin-left: 15px;">
						<button type="submit" class="button button-contactForm boxed-btn">회원가입</button>
					</div>
				</form>
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

		$(function() {//중복id체크 비동기처리
			$('#idcheck').on('click', function() {
				$.ajax({
					type : 'get',
					url : 'check.a',
					dataType : 'json',
					data : {
						"id" : $('input[name=memId]').val()
					},
					success : function(data) {
						console.log(data.count);

						num = data.count;
						if ($.trim(data.count) == 0) {
							$("#idError").text("사용가능한 id입니다!");
							$("#idcheckval").val("true");
						} else {
							$("#idError").text("중복 id입니다!");
							$("#idcheckval").val("false");
						}
					}
				})
			})
		});
	</script>
	<script type="text/javascript">
      // 이미지 미리보기
      function preview(input) {
         if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
               document.getElementById('preview').src = e.target.result;
            };
            reader.readAsDataURL(input.files[0]);
         } else {
            document.getElementById('preview').src = "";
         }
      }
   </script>

</body>

</html>