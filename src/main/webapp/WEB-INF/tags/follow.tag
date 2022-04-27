<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>

	<c:when test="${member.memId!=bvo.memId}">
		<!-- 로그인한 계정이 저장되어있는 계정의 ID와 같다면 -->
		<!-- 글쓴이 EL식 들어올 공간 눌렀을때 해당 프로필로 이동 -->
		<!-- 버튼 하나 만들어서 수정 or 삭제갈것인지 물어보기 -->
		<div
			style="float: left; text-align: right; width: 50%; padding-top: 10px;">
			<a id="btn-modal" class="btn-modal" style="text-align: right;"><img
				src="images/more.png"></a>
		</div>
		<span> <a href="updatePage.do?bid=${bvo.bid}"><img
				src="images/update.png"></a> <a
			href="deleteBoard.do?bid=${bvo.bid}&memId=${bvo.memId}"><img
				src="images/delete.png"></a>
		</span>


	</c:when>
	<c:otherwise>
		<div
			style="float: left; text-align: right; width: 50%; padding-top: 10px;">
			<a id="btn-modal" class="btn-modal" style="text-align: right;"><img
				src="images/more.png"></a>
		</div>

	</c:otherwise>
</c:choose>
