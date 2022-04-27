<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<c:choose>
	<c:when test="${member!=null}">
		<!-- ${member!=null}: 로그인이 되어있다면 -->
 
  <a href="NewFeed.jsp" class="boxed_btn_white"><img src="images/newfeed.ico" alt="새 글쓰기 이미지"></a>
	</c:when>
	<c:otherwise>
		<a href="login.jsp" class="boxed_btn_white"><img src="images/newfeed.ico" alt="새 글쓰기 이미지"></a>
	</c:otherwise>
	
</c:choose>
