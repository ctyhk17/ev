<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"      uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt"%>


<%
  /**
  * @Class Name : McmCmnUsr001M01C.jsp
  * @Description : 회원가입화면
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2016.07.12            최초 생성
  *
  * author 개발팀
  * since 2016.07.12
  *
  */
%>


<!DOCTYPE html>
<html lang="ko">
	
	<head>
	
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 모바일 -->
	    
	    <title>당당충주</title>
	    
	    
	        
	    <!-- 스타일 시트 -->
	    <link rel="stylesheet" href="<c:url value='/css/brochure/brochure.css' />"> <!-- css.index -->
	    <link rel="stylesheet" href="<c:url value='/css/jquery-ui.css' />"> <!-- css.index -->
	    
	    
	    <!-- Jquery JS -->
	    <script type="text/javascript"  src="<c:url value='/js/jquery-1.10.2.js' />"></script>
	    <script type="text/javascript"  src="<c:url value='/js/jquery.number.min.js' />"></script>
	    <script type="text/javascript"  src="<c:url value='/js/jquery.maskedinput.min.js' />"></script>
	    <script type="text/javascript" src="<c:url value='/js/jquery-ui-1.12.0.js' />"></script>
	    
	    <script type="text/javascript" src="<c:url value='/js/jquery.checkbyte.js' />"></script>
	    <script type="text/javascript" src="<c:url value='/js/jquery.textchange.js' />"></script>
	    <script type="text/javascript" src="<c:url value='/js/jquery.uamatch.js' />"></script>
	    
	    
	    <!-- Custom JS -->
	    <script type="text/javascript"  src="<c:url value='/js/common.js' />"></script>    
	    <script  type="text/javascript" src="<c:url value='/js/admin/admin.js'/>"></script>
	    
	    
	    <script type="text/javascript">
	    
				$(document).ready(function () {  
	
				});
				
				
			</script>
			
			
	</head><!-- End of head -->

	<body>

<form:form commandName="mcmCmnUsr001VO" name="mcmCmnUsr001VO" method="post">
	<header>
   <div id="header_box">
         <div class="back1">
<!--            <div class="story">Story</div>-->
            <div class="logo"><h2><a href="<c:url value="/McmMalItr001M01L.do"/>"><img src="<c:url value="/images/brochure/w_logo.png"/>"></a></h2></div>
         </div>
           <div class="back">
            <ul class="footer_box">
<!--            <li><img src="../images/m.png" alt="매칭찬스" title="매칭찬스"></li>-->
         <%--    <li><img src="<c:url value="/images/brochure/t.png"/>" alt="트위터" title="트위터"></li>
            <li><img src="<c:url value="/images/brochure/f.png"/>" alt="페이스북" title="페이스북"></li> --%>
            </ul>
        </div>
    </div>
</header><!-- End of header -->   
	

	<div class="join_guide_cap">
       <div class="join_guide" style="border:1px solid #333333; margin-top:5%;">
           <div class="join_text_title" style="background:#333333;">
               <h2>조합복지몰 가입을 환영 합니다.</h2>
           </div>
           <div class="join_text">
               <p class="text_p_f">조합복지몰계정을 사용하는 다양한 서비스들을 아래 ID로 편리하게 사용할 수 있습니다.</p>
               <div class="id_join">
                   <p>조합복지몰계정 : <span><b><c:out value="${resultInfo.usrId}"/></b></span></p>
                   <p>( 가입일: <span><b><c:out value="${resultInfo.joinDt}"/></b></span> )</p>
               </div>
<!--
               <p>추가멘트</p> 
               <p>추가멘트</p>
               <p>추가멘트</p>
-->
           </div>
       </div>
       <div class="home_button">
           <a style="background:#d7242b;" href="<c:url value='/McmMalItr001M01L.do'/>">메인으로</a>
           <a style="background:#d7242b;" href="<c:url value='/McmCmnLgn001M01R.do'/>">로그인</a>
       </div>
   </div>
	
		



</form:form>
	
	</body><!-- End of body -->

</html>