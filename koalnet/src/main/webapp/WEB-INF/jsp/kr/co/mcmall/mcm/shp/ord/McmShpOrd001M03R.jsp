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


<%

	
	
%>



<!DOCTYPE html>
<html lang="ko">

	<head>
	
		<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeadInclude.jsp" %>
		
		<!-- 가맹점 URL이 http일 경우 http처리, 실제 오픈시 가맹점 MID로 stdpay로 처리 -->	
		<script language="javascript" type="text/javascript" src="https://stgstdpay.inicis.com/stdjs/INIStdPay.js" charset="UTF-8"></script>
	
		<script type="text/javascript">
		
			$(document).ready(function () {  

				// 완료후 이동 화면
				$("#btnGoComplete").click(function() {
					//alert('서비스 준비중');
					btnGoComplete();
				});
				
				$("#btnGoPay").click(function() {	
					INIStdPay.pay('mcmShpOrd001VO');
				});
				

			});
			
			
			// 완료후 이동 화면
			function btnGoComplete(){
						
				$("#upMenuId").val("M001");
				$("#subMenuId").val("M001001");
				
				
				$("#mcmShpOrd001VO").attr("action", "<c:url value='/McmShpOrd002M01L.do'/>");
				$("#mcmShpOrd001VO").submit();
			}
			
			
		</script>
		
		
</head><!-- End of head -->

<body>

<form:form commandName="mcmShpOrd001VO" name="mcmShpOrd001VO" method="post">
		 
										
<%-- 필수 옵션 시작 --%>
<input type="hidden" name="version"      value="1.0" />
<input type="hidden" name="mid"          value="${ mid }" />
<input type="hidden" name="goodname"     value="${ oid }" />
<input type="hidden" name="oid"          value="${ oid }" />
<input type="hidden" name="price"        value="${ price }" /> 
<input type="hidden" name="currency"     value="WON" />
<input type="hidden" name="buyername"    value="${ userInfoVO.usrNm }" />
<input type="hidden" name="buyertel"     value="${ userInfoVO.telNo }" />
<input type="hidden" name="buyeremail"   value="${ userInfoVO.emailAddr }" />
<input type="hidden" name="timestamp"    value="${ timestamp }" />
<input type="hidden" name="signature"    value="${ signature }" />
<input type="hidden" name="returnUrl"    value="${ returnDomain }/McmShpOrd001M02R.do" />
<input type="hidden" name="mKey"         value="${ mKey }" />
<input type="hidden" name="gopaymethod"  value="Card:DirectBank:HPP:VBank" />
<input type="hidden" name="offerPeriod"  value="20170601-20181231" />
<input type="hidden" name="acceptmethod" value="HPP(2):below1000" />
<input type="hidden" name="languageView" value="" />
<input type="hidden" name="charset"      value="" />
<input type="hidden" name="payViewType"  value="" />
<input type="hidden" name="closeUrl"     value="${ siteDomain }/close.jsp" />
<input type="hidden" name="popupUrl"     value="${ siteDomain }/popup.jsp" />
<input type="hidden" name="quotabase"    value="${ cardQuotaBase }" />
<input type="hidden" name="ini_cardcode" value="" />  
<input type="hidden" name="ansim_quota"  value="" />	
<input type="hidden" name="vbankRegNo"   value="" />
<input type="hidden" name="merchantData" value="" />
												
		
		
<header>
	<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeaderInclude.jsp" %>
</header><!-- End of header -->   
    
<article>
    <div id="content_box">
   
        <div class="sub_content_1">
           
           <div id="sub3_content">
                <div>
               		<img src="<c:url value='/images/brochure/box.png' />" alt="" />
                    <div class="sub3_con_title">
                     <h1>구매가 완료되었습니다.</h1>
                     </div>
                      <div class="sub3_con">
                      <p><b>주문번호 : ${ resultInfo.ordNo }</b></p>
                      <p><b>결제금액 : ${resultInfo.ordTotAmt} 원</b></p>
                      <br>
                      <p><strong>주문 금액은 아래의 계좌로 입금 후 연락부탁드립니다.</strong></p>
                      <p><strong>계좌번호 : <b>농협 000-00-000000 예금주</b></strong></p> 
                      <p class="sub3_color_0"><small>전화번호 : 0000-0000</small></p>
                      <div class="sub3_color">
                       <!--  <p>당협쇼핑몰월드 자유이용권(3만원)을 예매하시는 분에게</p>
                        <p>홍보위원으로 위촉해드리고, 오픈 후</p>
                        <p>기념품 및 홍보비 (3만원)를 배당해 드려요!!</p> -->
                      </div>
                      </div>
                </div>
            </div> 
            <div class="line"></div>
            
            
            <div class="sub_box_2_2" id="sub_box_bu">
            	<c:if test="${'N' eq resultInfo.payYn }" >
            		<c:if test="${ userInfoVO.usrId eq 'mcbiz' or userInfoVO.usrId eq 'mcbizadmin' or userInfoVO.usrId eq 'admin' }">
            			<a href="#;" id="btnGoPay" class="ti ti_color"><h2>결제하기</h2></a>
            		</c:if>	
            	</c:if>            	
            	<a href="#;" id="btnGoComplete" class="ti"><h2>주문내역확인</h2></a>
            	<a href="<c:url value='/McmMalItr001M01L.do' />"class="ti"><h2>쇼핑몰로 이동</h2></a>
            </div>   
        </div><!-- End of content_1 -->

    </div><!-- End of content_box -->
</article><!-- End of article -->
    
<footer>

</footer><!-- End of footer -->

</form:form>


</body><!-- End of body -->

</html>