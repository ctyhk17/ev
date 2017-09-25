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

				// 회원가입신청
				$("#btnJoin").click(function() {	
					btnJoin();
				});
				
				$("#btnIdCheck").click(function() {	
					fn_IdCheck();
				});
				
				
				$("#usrId").keyup(function(){$(this).val( $(this).val().replace(/[^\!-z]/g,"") );} );

				
				

			});
			
			
			// 회원가입신청
			function btnJoin(){
				
				
				var usrId = $("#usrId").val(); 
				var usrPwd = $("#usrPwd").val();
				var usrPwdCf = $("#usrPwdCf").val();
				
				var usrNm = $("#usrNm").val();
				var telNo = $("#telNo").val();
				var emailAddr = $("#emailAddr").val();
				
				var isValid = $("#isValid").val();
				
				
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
				
				if(usrPwdCf.length == 0)
				{
					alert('비밀번호를 입력하세요');
					$("#usrPwdCf").focus();
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
				
				
				
				
				if(!  $("input[name=infoChk]").is(":checked") )
				{
					alert('개인정보수집,이용에 동의를 하셔야 합니다.');	
					$("input[name=infoChk]").focus();
					return;
				}
				
				
				if(isValid == "0"){
					alert("ID중복확인이 필요합니다.");
					return;
				}
				
					
				if( usrPwd != usrPwdCf){
					alert('비밀번호가 일치하지 않습니다.');
					$("#usrPwdCf").val("");
					$("#usrPwdCf").focus();
					return;
				}
				
				
				
				
				$("#ddFndOrd001VO").attr("action", "<c:url value='/fnd/ord/DdFndOrd001R221Proc.do'/>");
				$("#ddFndOrd001VO").submit();
			}
			
			
			
			function fn_IdCheck(){
				
				
					var usrId = $("#usrId").val();
					
					if(usrId.length == 0)
					{
						alert("아이디를 입력하세요.");
						return;
					}
					
					
					$.post(
							"<c:url value='/fnd/ord/IsValidId.do'/>", 
							{ "usrId": usrId }, 
							function(responseText)
							{
								var rtnCode = responseText.rtnCode;
								
								if(rtnCode == "0") {
									alert("중복된 아이디가 존재합니다.");
								}else{
									alert("사용가능한 아이디 입니다.");
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
			
			
			// 추후 에러메시지 처리 로직으로 이동해야 함
			var rtnMsg = "<c:out value='${rtnMsg}' />";
			if(rtnMsg.length > 0)
				alert(rtnMsg);
			
		</script>	
</head><!-- End of head -->

<body>

<form:form commandName="ddFndOrd001VO" name="ddFndOrd001VO" method="post">
		<form:hidden path="lcsNo" />
		<form:hidden path="fndId" />
		<form:hidden path="ordCnt" />
		
		<input type="hidden" name="isValid" id="isValid" value="0" />
		
<header>
	<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeaderInclude.jsp" %>
</header><!-- End of header -->   
    
<article>
    <div id="content_box">
   
        <div class="sub_content_1">
            
            <div class="sub_box_1">
            <h1><img src="<c:url value='/images/Mv.png' />" alt="" /> 회원가입하기</h1>
            <div class="line" id="line_top"></div> 
            </div>
            
            
            
            
            <div id="sub2_box">
            	<div>
                    <div><span><b>*</b> 아이디</span><form:input path="usrId"  maxlength="15" /><!-- <button type="button"> --><a href="#;" id="btnIdCheck">ID중복확인</a><!-- </button> --></div>
                    <div><span><b>*</b> 비밀번호</span><form:password path="usrPwd" maxlength="20" /></div>
                    <div><span><b>*</b> 비밀번호 확인</span><input type="password" name="usrPwdCf" id="usrPwdCf" maxlength="20" /></div>
                    <div class="line_bottom"></div>
                    <div><span><b>*</b> 이름</span><form:input path="usrNm" maxlength="15" /></div>
                    <div><span><b>*</b> 전화번호</span><form:input path="telNo" maxlength="20" /></div>
                    <div><span> 이메일</span><form:input path="emailAddr" maxlength="50" /></div>
				</div>                    
            </div>
            <p id="ast">* 는 필수입력사항입니다!!</p>
            <div id="sub2_box1">
                <div><p style="font-size:14px;font-weight:bold;">개인정보 수집 동의</p></div>
                <div>
                
                <textarea readonly rows="8" cols="88" style="textarea_scroll-auto; resize:none;margin:15px 0;">1. 개인정보 수집 및 이용목적
 
   매칭펀드은 후원자님께서 결제하고 서비스를 이용하는데 있어,
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
<form:checkbox path="infoChk"  value="Y" /> <b style="font-size:12px;">개인정보수집,이용에 동의합니다</b>
                </div>

            </div>
            <div id="sub_box_2_2">
            <div class="line"></div>
            <div class="sub_box_2_2">
            	<a href="#;" id="btnJoin" class="ti">
            		<h2>회원가입신청</h2>
            	</a>
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