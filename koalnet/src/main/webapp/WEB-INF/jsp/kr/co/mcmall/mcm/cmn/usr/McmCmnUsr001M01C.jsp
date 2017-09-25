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
	    
	    <!--  주소검색 JS -->
	    <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	    
	    
	    <script type="text/javascript">
			
	    
			$(document).ready(function () {  
				
				$("#usrId").focus();

				// 회원가입신청
				$("#btnJoinApp").click(function() {	
					fnJoinApp();
				});
				
				// 아이디 중복체크
				$("#btnIdCheck").click(function() {	
					fnIdCheck();
				});
				
				// 아이디 한글 제거
				$("#usrId").keyup(function(){$(this).val( $(this).val().replace(/[^\!-z]/g,"") );} );
				
				
				$("#usrPwdCheck").blur(function(){
					fnPwdCheck();
				});
				
			
				$("#postcodify_search_button").postcodifyPopUp();
				
				// 카피라이트 제거
				$(".postcodify_logo").empty();
				
			});
			
			
			// 회원가입신청
			function fnJoinApp()
			{
				
				
				var usrId     = $("#usrId").val(); 
				var usrPwd    = $("#usrPwd").val();
				var usrNm     = $("#usrNm").val();
				var telNo     = $("#telNo").val();
				var emailAddr = $("#emailAddr").val();
				
				var isValid  = $("#isValid").val();
				var pwdCheck = $('#usrPwdCheck').val();
				
				
				var pstNo = $("#pstNo").val();
				var rdAddr = $("#rdAddr").val();
				var rdAddrDtl = $("#rdAddrDtl").val();
				var dongNm = $("#dongNm").val();
				
				if(usrId.length == 0)
				{
					alert('아이디를 입력하세요');
					$("#usrId").focus();
					return;
				}
				
				if(usrPwd.length == 0)
				{
					alert('비밀번호를 입력하세요');
					$("#usrPwd").focus();
					return;
				}
				
				if(usrNm.length == 0)
				{
					alert('이름을 입력하세요');
					$("#usrNm").focus();
					return;
				}
				
				if(telNo.length == 0)
				{
					alert('전화번호를 입력하세요');
					$("#telNo").focus();
					return;
				}
				
				if(usrPwd != pwdCheck)
				{
					alert("비밀번호를 확인하세요");
					$("#usrPwdCheck").focus();
					return;
				}
				
				if(pwdCheck.length == 0)
				{
					alert("비밀번호를 입력하세요");
					$("#usrPwdCheck").focus();
					return;
				}
				
				if(emailAddr.length == 0)
					{
						alert("이메일을 입력하세요");
						$("#emailAddr").focus();
						return;
					}
				
				
				
				if(!  $("input[name=infoChk]").is(":checked") )
				{
					alert('개인정보수집,이용에 동의를 하셔야 합니다.');	
					$("input[name=infoChk]").focus();
					return;
				}
				
				
				if(isValid == "999"){
					alert("ID중복확인이 필요합니다.");
					return;
				}
				
				
				$.post(
						"<c:url value='/McmCmnUsr001M01CP.do'/>", 
						{ 
							  "usrId"     :  usrId 
							, "usrPwd"    :  usrPwd
							, "usrNm"     :  usrNm
							, "telNo"     :  telNo
							, "emailAddr" :  emailAddr						
							, "pstNo"     :  pstNo
							, "rdAddr"    :  rdAddr
							, "rdAddrDtl" :  rdAddrDtl
							, "dongNm"    :  dongNm
							
						}, 
						function(responseText)
						{
							var rtnCode = responseText.rtnCode;
							
							if(rtnCode == "999") 
							{
								alert("중복된 아이디가 존재합니다.");
								$('#usrId').focus();
								
							// 회원가입 신청 완료 페이지
							}else{
								
								
								$("#mcmCmnUsr001VO").attr("action", "<c:url value='/McmCmnUsr001M02R.do'/>");
								$("#mcmCmnUsr001VO").submit();
							}
							
							$("#isValid").val(rtnCode);
							
						}, 
						"json"
				)
				.done(function() {
					
					})
				.fail(function() {
					alert( "처리 도중 에러가 발생하였습니다." );
					})
					;
			}
			
			
			// 아이디 중복체크
			function fnIdCheck()
			{
				
					var usrId = $("#usrId").val();
					
					if(usrId.length == 0)
					{
						alert("아이디를 입력하세요.");
						return;
					}
					
					$.post(
							"<c:url value='/McmCmnUsr001P01R.do'/>", 
							{ 
								"usrId": usrId 
							}, 
							function(responseText)
							{
								var rtnCode = responseText.rtnCode;
								
								if(rtnCode == "999") 
								{
									alert("중복된 아이디가 존재합니다.");
									$('#usrId').focus();
									
								
								}else{
									alert("사용가능한 아이디 입니다.");
									$('#usrPwd').focus();
								}
								
								$("#isValid").val(rtnCode);
								
							}, 
							"json"
					)
					.done(function() {
						
  					})
					.fail(function() {
						alert( "처리 도중 에러가 발생하였습니다." );
  					})
  					;

			}
			
			// 패스워드 확인
			function fnPwdCheck()
			{
				
				var pwd       = $('#usrPwd').val();
				var pwdCheck  = $('#usrPwdCheck').val();
				var textDiv   = "";
				
				if(pwd.length == 0)
				{
					alert("패스워드를 입력하세요.");
					$("#usrPwd").focus();
					return;
				
				}else
				{
					if(pwd == pwdCheck)	// 패스워드 일치
					{	
						textDiv = " * 패스워드가 일치합니다.";
						$('#pwdCheck').text(textDiv);
				
					}else if(pwd != pwdCheck)	// 패스워드 불일치
					{	
						textDiv = " * 패스워드가 일치하지 않습니다.";
						$('#pwdCheck').text(textDiv);
					}
				}
			}
			
			
			
		</script>	
			
			
	</head><!-- End of head -->

	<body>

<form:form commandName="mcmCmnUsr001VO" name="mcmCmnUsr001VO" method="post">
	<input type="hidden" name="isValid" id="isValid" value="999" />
	
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
	
	
	
	<article>
    <div id="content_box">
   
        <div class="sub_content_1">
            
            <div class="sub_box_1">
            <h1><%-- <img src="<c:url value="/images/brochure/dang_logo_1.png"/>" alt=""> --%> 회원가입</h1>
            <div class="line" id="line_top"></div> 
            </div>
            <div id="sub2_box">
                <div>
                    <div><span><b>*</b> 아이디</span><form:input path="usrId"  maxlength="15" /><a href="#;" class="id_check" id="btnIdCheck">ID중복확인</a></div>
                    <div><span><b>*</b> 패스워드</span><form:password path="usrPwd" maxlength="20"  /></div>
                    <div><span><b>*</b> 패스워드 확인</span><form:password path="usrPwdCheck" maxlength="20" /></div>
                    <div class="line_bottom"></div>
                    <div><span><b>*</b> 이름</span><form:input path="usrNm" maxlength="15"/></div>
                    <div><span><b>*</b> 전화번호</span><form:input path="telNo" maxlength="20"/></div>
                    <div><span><b>*</b> 이메일</span><form:input path="emailAddr" maxlength="50"/></div>
                    <div><span><b>*</b> 우편번호</span><form:input path="pstNo" class="postcodify_postcode5" />
                    <a href="#;" class="address_check" id="postcodify_search_button">주소검색</a>
                    </div>
                    <div><span><b>*</b> 도로명주소</span><form:input path="rdAddr" class="postcodify_address"/></div>
                    <div><span><b>*</b> 상세주소</span><form:input path="rdAddrDtl" class="postcodify_details"/></div>
                    <div><span><b>*</b> 행정동명</span><form:input path="dongNm" class="postcodify_extra_info"/></div>
                    
                    
                </div>
            </div>
            <p id="ast"><b>* 는 필수입력사항입니다.</b></p>
            <div id="sub2_box1">
                <div><p style="font-size:14px;font-weight:bold;">개인정보 수집 동의</p></div>
                <div>
                
                <textarea readonly rows="8" cols="88" style="textarea_scroll-auto; resize:none;margin:15px 0;">1. 개인정보 수집 및 이용목적
 
   당협쇼핑몰은 고객님께서 결제하고 서비스를 이용하는데 있어,
   원활한 후원등록 및 결제, 서비스제공을 진행하기 위한 최소한의 정보를 수집합니다.
   결제시 제공하신 모든 정보는 상기 목적에 필요한 용도 이외로는 사용되지 않습니다.
 
 2. 개인정보 수집 범위
 
   - 성명, e-mail, 전화번호(핸드폰 번호), 계좌번호 : 결재 안내 및 결재관련문의처리를 위한 의사소통 방법 확보. 
   - 결제정보(카드사 및 카드번호/유효기간/은행 및 계좌번호/생년월일): 결제 등록을 위한 정보 확보.
 
   * 주문처리과정에서 아래와 같은 정보들이 생성되어 수집될 수 있습니다.
	 주문이용기록, 접속로그, 쿠키, 접속ip, 결제기록
 
 3. 개인정보 보유기간 및 이용기간
 
   결재시 제공하신 개인정보는 수집목적 및 제공받은 목적이 달성되면 재생할 수 없는
   기술적 방법에 의해 삭제 되며, 어떠한 용도로도 열람 또는 이용될 수 없도록 파기됩니다.
   단, 상법 등 관련법령의 규정에 의하여 다음과 같이 거래 관련 권리 의무 관계의 확인 등을
   이유로 일정기간 보유하여야 할 필요가 있는 경우에는 일정기간 보유합니다.
 
   전자상거래등에서의소비자보호에관한법률에 의해 다음기간동안 보존합니다.
	- 계약 또는 청약철회 등에 관한 기록 : 5년
	- 대금결제 및 재화등의 공급에 관한 기록 : 5년
	- 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년
                </textarea>
                <div style="text-align:right;margin-bottom:35px;margin-top:-10px;">
                    <input id="infoChk" name="infoChk" type="checkbox" value="Y" style="vertical-align: -3px;" /> <b style="font-size:12px;">개인정보수집,이용에 동의합니다</b>
                </div>
                </div>

            </div>
            <div id="sub_box_2_2">
            <div class="line"></div>
            <div class="sub_box_2_2"> 
            	<a href="#;" id="btnJoinApp" style="color:white; text-align:center; font-weight:bold;">가입완료</a>
            </div>
            </div>            
        </div><!-- End of content_1 -->

    </div><!-- End of content_box -->
</article><!-- End of article -->
	
	
	
	
	
	
	
	
	
	
	
	
	

</form:form>
	
	</body><!-- End of body -->

</html>