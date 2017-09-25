<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%

response.setHeader("cache-control","no-cache, no-store, must-revalidate");
response.setHeader("expires","0");
response.setHeader("pragma","no-cache");

%>


<%
  /**
  * @Class Name : FmsFndOrd001R13.jsp
  * @Description : 예매자 회원가입하기
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
			
			window.name = "BTPG_CLIENT";
			
			var width = 330;
			var height = 480;
			var xpos = (screen.width - width) / 2;
			var ypos = (screen.width - height) / 2;
			var position = "top=" + ypos + ",left=" + xpos;
			var features = position + ", width=320, height=440";

			
		
			$(document).ready(function () {  

				// 완료후 이동 화면
				$("#btnGoComplete").click(function() {	
					fn_GoComplete();
				});
				
				$("#btnGoPay").click(function() {	
					on_pay();
				});
				
				
				

			});
			
			
			// 완료후 이동 화면
			function fn_GoComplete(){
				
				$("#ddFndOrd001VO").attr("action", "<c:url value='/fnd/ord/DdFndOrd001R14.do'/>");
				$("#ddFndOrd001VO").attr("target", "");
				$("#ddFndOrd001VO").submit();
				
				model.addAttribute("isSucc", isSucc);
				
				
			}
			
			
			
			
			


			function on_pay() { 
				myform = document.ddFndOrd001VO; 
				var wallet = window.open("", "BTPG_WALLET", features);
				/**************************************************************************** 
				결제수단 action url을 아래와 같이 설정한다
				URL끝에 /를 삭제하면 다음과 같은 오류가 발생한다.
				"일시적인 오류로 결제시도가 정상적으로 처리되지 않았습니다.(MX1002) 자세한 사항은 이니시스(1588-4954)로 문의해주세요."
				****************************************************************************/ 
				if(myform.P_GOPAYMETHOD.value == "CARD") {
					myform.action = "https://mobile.inicis.com/smart/wcard/"; //신용카드
					}
				else if(myform.P_GOPAYMETHOD.value == "VBANK") {
					myform.action = "https://mobile.inicis.com/smart/vbank/"; //가상계좌
					}
				else if(myform.P_GOPAYMETHOD.value == "BANK") {
					myform.action = "https://mobile.inicis.com/smart/bank/"; //계좌이체
				}
				else if(myform.P_GOPAYMETHOD.value == "HPP") {
					myform.action = "https://mobile.inicis.com/smart/mobile/"; //휴대폰
					}
				else if(myform.P_GOPAYMETHOD.value == "CULTURE") {
					myform.action = "https://mobile.inicis.com/smart/culture/"; //문화 상품권
					}
				else if(myform.P_GOPAYMETHOD.value == "HPMN") {
					myform.action = "https://mobile.inicis.com/smart/hpmn/"; //해피머니 상품권
					}
				else {
					myform.action = "https://mobile.inicis.com/smart/wcard/"; // 엉뚱한 값이 들어오면  카드가 기본이 되게 함
					}
				
				myform.P_RETURN_URL.value = myform.P_RETURN_URL.value + "?P_OID=" + myform.P_OID.value; // 계좌이체 결제시 P_RETURN_URL로 P_OID값 전송(GET방식 호출)
				myform.target = "BTPG_WALLET";
				myform.submit(); 
			} 	
			
			
			
		</script>
		
		
</head><!-- End of head -->

<body>

<form:form commandName="ddFndOrd001VO" name="ddFndOrd001VO" method="post"  accept-charset="euc-kr">
	<form:hidden path="ordNo" />
	<form:hidden path="fndId" />
	<form:hidden path="lcsNo" />

	<input type="hidden" name="isSucc" value="Y"/>
	<input type="hidden" name="P_NEXT_URL" value="${ siteDomain }/mx_rnext.jsp"> 
	<input type="hidden" name="P_NOTI_URL" value="${ siteDomain }/mx_rnoti.jsp"> 
	<input type="hidden" name="P_RETURN_URL" value="${ siteDomain }/mx_rreturn.jsp"> 
	<input type="hidden" name="P_MID" value="${ P_MID }">
	<input type="hidden" name="P_GOODS" value="${ P_OID }">
	<input type="hidden" name="P_AMT" value="${ P_AMT }">
	<input type="hidden" name="P_UNAME" value="${ userInfoVO.usrNm }">
	<input type="hidden" name="P_EMAIL" value="${ userInfoVO.emailAddr }">
	<input type="hidden" name="P_MOBILE" value="${ userInfoVO.telNo }">
	<input type="hidden" name="P_NOTI" value=""> 
	<input type="hidden" name="P_RESERVED" value="">
	<input type="hidden" name="P_OID" value="${ P_OID }"> 
	<input type="hidden" name="P_HPP_METHOD" value="2"> 
				
		
<header>
	<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeaderInclude.jsp" %>
</header><!-- End of header -->   
    
<article>
            
    
    <div id="content_box">
   
        <div class="sub_content_1">
           
           <div id="sub3_content">
               <div>
               <img src="<c:url value='/images/box.png' />" alt="" />
                    <div class="sub3_con_title">
                     <h1>예매가완료되었습니다!!</h1>
                     </div>
                      <div class="sub3_con">
                          <p>예매번호 : ${ resultInfo.ordNo }</p>
                          <p>결제금액 : <fmt:formatNumber value="${resultInfo.payAmt}" groupingUsed="true"/> 원</p>
                          <br>
                          <p><strong>예매 금액은 아래의 계좌로 입금 후 연락부탁드립니다.</strong></p>
                          <p><strong>계좌번호 : <b>농협 301-1522-4422-51 (주)매칭찬스비즈</strong></p> 
                          <p class="sub3_color_0"><small>전화번호 : 1522-4422</small></p>
                      <div class="sub3_color">
                          <p>당협쇼핑몰월드 자유이용권(3만원)을 예매하시는 분에게</p>
                        <p>홍보위원으로 위촉해드리고, 오픈 후</p>
                        <p>기념품 및 홍보비 (3만원)를 배당해 드려요!!</p>
                      </div>
                      </div>
                </div>
            </div>   
            <div id="sub_box_2_2">
            <div class="line"></div>
            <div class="sub_box_2_2" id="sub_box_bu">
            <div class="margin_sub_6">
               <select name="P_GOPAYMETHOD" id="P_GOPAYMETHOD">
	                <%-- <option value="CARD" selected>신용카드  --%>
					<option value="BANK"        >계좌이체
					<option value="VBANK"        >가상계좌
					<%-- <option value="HPP"          >휴대폰 
					<option value="CULTURE"      >문화상품권
					<option value="HPMN"         >해피머니상품권   --%>
               </select>
            </div>
            <c:if test="${'N' eq resultInfo.payYn }" >
          		<c:if test="${ userInfoVO.usrId eq 'mcbiz' or userInfoVO.usrId eq 'mcbizadmin' }">
          			<a href="#;" id="btnGoPay" class="ti ti_color"><h2>결재하기</h2></a>
          		</c:if>	
          	</c:if>            	
          	<a href="#;" id="btnGoComplete" class="ti"><h2>예매내역확인</h2></a>
            <a href="<c:url value='/cmn/itr/FmsCmnItr001R.do' />"class="ti"><h2>홈페이지로 이동</h2></a>
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