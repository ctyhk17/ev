<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%

response.setHeader("cache-control","no-cache, no-store, must-revalidate");
response.setHeader("expires","0");
response.setHeader("pragma","no-cache");

%>


<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"      uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
  /**
  * @Class Name : McmCmnLgn001M01R.jsp
  * @Description : 로그인화면
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
	
					// 로그인
					$("#btnLogin").click(function() {	
						fnLogin();
					});
				});
				
				function onEnterLogin(){
					var keyCode = window.event.keyCode;
					
					if(keyCode == 13)
						{
							fnLogin();
						}
				}
				
				// 로그인
				function fnLogin(){
					
					
					var usrId = $("#usrId").val();
					var usrPwd = $("#usrPwd").val();
					
					var returnUrl = $("#returnUrl").val();
					
					
					
					if(usrId.length == 0){
						alert("아이디를 입력하세요.");
						$("#usrId").focus();
						return;
					}
					
					if(usrPwd.length == 0){
						alert("비밀번호를 입력하세요.");
						$("#usrPwd").focus();
						return;
					}
					
					
					$.post(
							"<c:url value='/McmCmnLgn001M01RP.do'/>", 
							{ 
								"usrId": usrId, 
								"usrPwd": usrPwd
							}, 
							function(responseText)
							{
								var rtnMsg  = responseText.rtnMsg;
								var rtnCode = responseText.rtnCode;		
								
								// 정상처리
								if(rtnCode == "000")
								{
									if(returnUrl.length > 0)
									{
										$("#mcmCmnLgn001VO").attr("action", returnUrl);
										$("#mcmCmnLgn001VO").submit();
										
									}else{
										$(location).attr("href", "<c:url value='/McmMalItr001M01L.do'/>");	
									}
									
								// 승인 대기
								}else if(rtnCode == "001")
								{	
									
									$("#mcmCmnLgn001VO").attr("action", "<c:url value='/McmCmnUsr001M02R.do'/>");
									$("#mcmCmnLgn001VO").submit();
								}else{
									alert(rtnMsg);	
								}
							}, 
							"json"
					)
					.done(function(responseText) {
  					})
					.fail(function() {
						alert( "처리 도중 에러가 발생하였습니다." );
  					})
  					;
				}
				
				
				
			</script>
			
			
	</head><!-- End of head -->

	<body onkeydown="javascript:onEnterLogin();">

<form:form commandName="mcmCmnLgn001VO" name="mcmCmnLgn001VO" method="post">

	<form:hidden path="returnUrl"/>
	<form:hidden path="gdsId"/>
	<header>
   <div id="header_box">
         <div class="back1">
<!--            <div class="story">Story</div>-->
            <div class="logo"><h2><a href="<c:url value="/McmMalItr001M01L.do"/>"><img style="width:75px;" src="<c:url value="/images/main/koalicon.png"/>"></a></h2></div>
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

	<article>
    <div id="content_box">
   
        <div class="sub_content_1">
            
            <div class="sub_box_1">
            <h1><!--<img src="../images/dang_logo_1.png" alt=""> -->로그인/신규 회원가입</h1>
            <div class="line" id="line_top"></div> 
            </div>
            <div id="main_box">
                <div>
                   <div class="line_main line_main_bottom"></div>
                    <div><span><b></b> 아이디</span><form:input path="usrId" placeholder="ID" maxlength="20"/></div>
                    <div><span><b></b> 패스워드</span><form:password path="usrPwd" placeholder="PASSWORD" maxlength="30"/></div>
                    <div><a href="#" id="btnLogin" class="login_main">LOGIN</a></div>
                    
                    <div class="line_main line_main_top"></div>
                    <div class="login_box_1_4">
                      <p>▶아직 매칭펀드 회원이 아니신가요?<span><a href="<c:url value='/McmCmnUsr001M01C.do' />">회원가입</a></span></p>
                      <p>▶<b>아이디/비밀번호</b>를 잊으셨나요?<span><a href="<c:url value='/McmCmnLgn001M02R.do' />">아이디/비번 찾기</a></span></p>
                  </div>
                </div>
            </div>
        </div><!-- End of content_1 -->

    </div><!-- End of content_box -->
</article><!-- End of article -->
</form:form>
	</body><!-- End of body -->

</html>