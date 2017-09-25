<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%

response.setHeader("cache-control","no-cache, no-store, must-revalidate");
response.setHeader("expires","0");
response.setHeader("pragma","no-cache");

%>
<%
  /**
  * @Class Name : FmsFndOrd001R12.jsp
  * @Description : 예매자 회원가입
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2017.05.17            최초 생성
  *
  * author 개발팀
  * since 2017.05.17
  *
  */
%>



<!DOCTYPE html>
<html lang="ko">

	<head>
	
		<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeadInclude.jsp" %>
		
		
		<script type="text/javascript">
		
			$(document).ready(function () {  

				
				
				
				// 기존회원
				$("#btnLogin").click(function() {	
					btnLogin();
				});
				
				
				// 신규회원
				$("#btnGoJoin").click(function() {	
					btnGoJoin();
				});
				
				
				
				// 추후 에러메시지 처리 로직으로 이동해야 함
				var rtnMsg = "<c:out value='${rtnMsg}' />";
				if(rtnMsg.length > 0)
					alert(rtnMsg);

			});
			
			
			
			// 기존회원
			function btnLogin(){
				
				var usrId = $("#usrId").val();
				var usrPwd = $("#usrPwd").val();
				
				if(usrId.length == 0)
				{
					alert("아이디를 입력하세요.");
					$("#usrId").focus();
					return;
				}
				
				if(usrPwd.length == 0)
				{
					alert("비밀번호를 입력하세요.");
					$("#usrPwd").focus();
					return;
				}
				
				$("#ddFndOrd001VO").attr("action", "<c:url value='/fnd/ord/DdFndOrd001R12Proc.do'/>");
				$("#ddFndOrd001VO").submit();
			}
			
			
			// 신규회원
			function btnGoJoin(){
				
				$("#ddFndOrd001VO").attr("action", "<c:url value='/fnd/ord/DdFndOrd001R121.do'/>");
				$("#ddFndOrd001VO").submit();
			}
			
			
		</script>	
</head><!-- End of head -->

<body>

<form:form commandName="ddFndOrd001VO" name="ddFndOrd001VO" method="post">
		<form:hidden path="lcsNo" />
		<form:hidden path="fndId" />
		<form:hidden path="ordCnt" />
		
<header>
	<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeaderInclude.jsp" %>
</header><!-- End of header -->
    
<article>



	<div id="content_box">
   
        <div class="sub_content_1">
            
            <div class="sub_box_1">
            <h1><img src="<c:url value='/images/dang_logo_1.png' />" alt="" /> 로그인/신규 회원가입</h1>
            <div class="line" id="line_top"></div> 
            </div>
            <div id="main_box">
                <%-- <div>
                   <div class="line_main line_main_bottom"></div>
                    <div><span><b></b> 아이디</span><form:input path="usrId" /></div>
                    <div><span><b></b> 비밀번호</span><form:password path="usrPwd" /></div>
                    <div><a href="#;" class="login_main" id="btnLogin">로그인</a></div>
                    <div class="line_main line_main_top"></div>
                    <div class="login_box_1_4">
                      <p>▶아직 매칭펀드 회원이 아니신가요?<span><a href="#"; id="btnGoJoin">회원가입</a></span></p>
                      <p>▶<b>아이디/비밀번호</b>를 잊으셨나요?<span><a href="#">아이디/비번 찾기</a></span></p>
                  </div>
                </div> --%>
                
                
                <div>
                   <div class="line_main line_main_bottom"></div>
                    <div><span><b></b> 아이디</span><form:input path="usrId" /></div>
                    <div><span><b></b> 비밀번호</span><form:password path="usrPwd" /></div>
                    <div><a href="#;" class="login_main" id="btnLogin">로그인</a></div>
                    
                    <div class="line_main line_main_top"></div>
                    <div class="login_box_1_4">
                      <p>▶아직 당협쇼핑몰 회원이 아니신가요?<span><a href="#;" id="btnGoJoin">회원가입</a></span></p>
                       <p>▶<b>아이디/비밀번호</b>를 잊으셨나요?<span><a href="<c:url value='/cmn/lgn/FmsCmnLgn002R.do'/>">아이디/비번 찾기</a></span></p>
                  </div>
                </div>
                
                
                
            </div>
        </div><!-- End of content_1 -->

    </div><!-- End of content_box -->
    
    
</article><!-- End of article -->
    
<footer>

</footer><!-- End of footer -->

</form:form>
</body><!-- End of body -->

</html>