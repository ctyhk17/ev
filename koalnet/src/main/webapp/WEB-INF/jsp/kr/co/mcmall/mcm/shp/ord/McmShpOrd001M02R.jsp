<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
/* 
response.setHeader("cache-control","no-cache, no-store, must-revalidate");
response.setHeader("expires","0");
response.setHeader("pragma","no-cache"); */

%>
<%
  /**
  * @Class Name : FmsFndOrd001R11.jsp
  * @Description : 예매티켓 구입하기
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
		
		<!--  주소검색 JS -->
	    <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	    <!-- 가맹점 URL이 http일 경우 http처리, 실제 오픈시 가맹점 MID로 stdpay로 처리 -->	
		<script language="javascript" type="text/javascript" src="https://stgstdpay.inicis.com/stdjs/INIStdPay.js" charset="UTF-8"></script>
		<!-- 취소처리로 Overlay / popup 창을 닫아주는 역활을 하는 페이지-->
		<script language="javascript" type="text/javascript" src="https://stdpay.inicis.com/stdjs/INIStdPay_close.js" charset="UTF-8"></script>
		
		
		
		<script type="text/javascript">
		
			$(document).ready(function () {  
				
				var totAmt;
				
				if('${fn:length(resultList)}' > 0){
					totAmt = '<fmt:formatNumber value="${gdsAmt+ (fn:length(resultList)*2500)}" groupingUsed="true"/>';
					
				}else{
					totAmt = '<fmt:formatNumber value="${gdsAmt + 2500}" groupingUsed="true"/>';
				}
// 				$("input[name='price']").val(totAmt);
				
				

				// 제품구입하기 화면으로 이동
				$("#btnGoNext").click(function() {	
					btnGoNext();
				});
				
				// 숫자 포멧팅
				$("#ordCntMask").number(true);
				
				$("#ordCntMask").keyup(function() {	
					fn_calAmt();
				});
				
				$("#ordTotAmtMask > big > b").text(numberWithCommas(totAmt));
				
				$("input:radio[name=addr]").change( function() {
					var addrDiv = $(this).val();
					
					if(addrDiv == 'basic') {
						
						
						$.post(
								"<c:url value='/McmShpOrd001M12RP.do'/>",
								function(responseText)
								{
									$("#dlvPstNo").val(responseText.pstNo);
									$("#dlvRdAddr").val(responseText.rdAddr);
									$("#dlvAddrDtl").val(responseText.rdAddrDtl);
									$("#dlvDongNm").val(responseText.dongNm);
								}, 
								"json"
						)
						.fail(function() {
							alert( "처리 도중 에러가 발생하였습니다." );
						});
						
						
					}else{
						$("#dlvPstNo").val("");
						$("#dlvRdAddr").val("");
						$("#dlvAddrDtl").val("");
						$("#dlvDongNm").val("");
					}
					
				});
				
				
				
				$("#btnPay").click(function(){
					
					var div = $("input:radio[name='payDiv']:checked").val();
					
					$("#ordTotAmt").val(totAmt);	
					$("input[name='buyertel']").val($("#telNo").val());
					$("input[name='buyername']").val($("#rcptNm").val());
					var rcptNm = $("#rcptNm").val();
					var telNo = $("#telNo").val();
					var dlvPstNo = $("#dlvPstNo").val();
					var dlvRdAddr = $("#dlvRdAddr").val();
					var dlvAddrDtl = $("#dlvAddrDtl").val();
					var dlvNt = $("#dlvNt").val();
					var dlvDongNm = $("#dlvDongNm").val();
					var dlvDongNm = $("#oid").val();
					
					
						
					var url;
					
					if($("#ordDiv").val() == 'cart'){
						
						url = "${ siteDomain }/McmShpOrd001M32RP.do?ordDiv=cart";
						
						$("input:hidden[name='returnUrl']").val(url);
						
					}else{
						url = "${ siteDomain }/McmShpOrd001M32RP.do?ordDiv=dir";
						
						$("input:hidden[name='returnUrl']").val(url);
					}
					
					//직접이체
					if(div == 'MOOZ'){
						$("#mcmShpOrd001VO").attr("action", "<c:url value='/McmShpOrd001M22RP.do'/>");
		 				$("#mcmShpOrd001VO").submit();
						
					}else{
						
						var crtIdArray = new Array();
						var gdsIdArray = new Array();
						var lcsIdArray = new Array();
						
						$("input:hidden[name='crtId']").each(function(){
							crtIdArray.push($(this).val());
						});
						$("input:hidden[name='gdsIds']").each(function(){
							gdsIdArray.push($(this).val());
						});
						$("input:hidden[name='lcsIds']").each(function(){
							lcsIdArray.push($(this).val());
						});
						
						//가상계좌
						if(div == 'MOO'){
							
							$("input[name='gopaymethod']").val("VBank");				
							
						}
						//카드
						if(div == 'CAD'){
							
							
							$("input[name='gopaymethod']").val("Card");
							
						}
						//계좌이체
						if(div == 'VAC'){
							$("input[name='gopaymethod']").val("DirectBank");
						}
						
						jQuery.ajaxSettings.traditional = true;
						$.post(
								"<c:url value='/McmShpOrd001M02RP.do'/>", 
								{ 
									"rcptNm" : rcptNm,
									"telNo" : telNo,
									"dlvPstNo" : dlvPstNo,
									"dlvRdAddr" : dlvRdAddr,
									"dlvAddrDtl" : dlvAddrDtl,
									"dlvNt" : dlvNt,
									"dlvDongNm" : dlvDongNm,
									"ordTotAmt" : $("#price").val(),
									"ordNo" : $("#oid").val(),
									"ordDiv" : $("#ordDiv").val(),
									"gdsId" : $("#gdsId").val(),
									"ordCnt" : $("#ordCnt").val(),
									"lcsId" : $("#lcsId").val(),
									"ordAmt" : $("#ordAmt").val(),
									"crtId" : crtIdArray,
									"gdsIds" : gdsIdArray,
									"lcsIds" : lcsIdArray
									
								}, 
								"json"
						)
						.done(function() {
							INIStdPay.pay('mcmShpOrd001VO');	
						})
						.fail(function() {
							alert( "처리 도중 에러가 발생하였습니다." );
							$("#cartPop").show();	
						});
						
					}
					
					
					
					
				});
				
				$("#postcodify_search_button").postcodifyPopUp();

			});
			
			
			
			
			
			// 금액 계산
			function fn_calAmt(){
				
				var gdsAmt = $("#gdsAmt").val();
				var ordCnt = removeComma($("#ordCntMask").val());
				
				if(! $.isNumeric(gdsAmt)){
					alert('단가가 잘못 입력되었습니다.\n관리자에게 문의하세요.');						
				}
				
				if(! $.isNumeric(ordCnt)){
					ordCnt = 0;						
				}
				
				var ordAmtMask = parseInt(gdsAmt) * parseInt(ordCnt);
				
				$("#ordAmtMask").text(numberWithCommas(ordAmtMask));
			}
			
			// 제품 구입화면으로 이동
			function btnGoNext(){
				
				
				var ordCntDivCd    = $("input:radio[name=ordCntDivCd]:checked").val();
				var ordCnt = $("#ordCntMask").val(); 
				
				
				if($("input:radio[name=ordCntDivCd]:checked").length < 1)
				{
					alert('수량를 선택하세요.');
					$("#ordCntDivCd1").focus();
					return;
				}
				
				if(ordCntDivCd == '0')
				{
					if(ordCnt.length == 0 || ordCnt < 1)
					{
						alert("수량를 입력하세요.");
						$("#ordCntMask").focus();
						return;
					}
					
				}
				
				$("#ordCnt").val(removeComma(ordCnt));
				
				
				$("#mcmShpOrd001VO").attr("action", "<c:url value='/McmShpOrd001M02RP.do'/>");
				$("#mcmShpOrd001VO").submit();
			}
			
			
		</script>	
		
	    
	</head><!-- End of head -->

<body>

	<form:form commandName="mcmShpOrd001VO" name="mcmShpOrd001VO" method="post">
		<form:hidden path="ordTotAmt" />
		<form:hidden path="ordDiv" />
		<form:hidden path="ordCnt" />
		<form:hidden path="ordAmt" />
		<form:hidden path="gdsId" />
		<form:hidden path="lcsId" />
		<input type="hidden" name="version"      value="1.0" />
		<input type="hidden" name="mid"          value="${ mid }" />
		<input type="hidden" name="goodname"     value="테스트" />
		<input type="hidden" name="oid" id="oid"          value="${ oid }" />
		<input type="hidden" name="price" id="price"        value="1000" /> 
		<input type="hidden" name="currency"     value="WON" />
		<input type="hidden" name="timestamp"    value="${ timestamp }" />
		<input type="hidden" name="signature"    value="${ signature }" />
		<input type="hidden" name="returnUrl"    value="" />
<%-- 		<input type="hidden" name="returnUrl"    value="${ siteDomain }/INIpay/INIStdPayReturn.jsp" /> --%>
		<input type="hidden" name="mKey"         value="${ mKey }" />
		<input type="hidden" name="gopaymethod"  value="" />
		<input type="hidden" name="offerPeriod"  value="20170601-20181231" />
		<input type="hidden" name="acceptmethod" value="HPP(2):below1000" />
		<input type="hidden" name="languageView" value="" />
		<input type="hidden" name="charset"      value="" />
		<input type="hidden" name="payViewType"  value="" />
		<input type="hidden" name="closeUrl"     value="${ siteDomain }/McmShpOrd001M02R.do" />
		<input type="hidden" name="popupUrl"     value="${ siteDomain }/popup.jsp" />
		<input type="hidden" name="quotabase"    value="${ cardQuotaBase }" />
		<input type="hidden" name="ini_cardcode" value="" />
		<input type="hidden" name="ansim_quota"  value="" />	
		<input type="hidden" name="vbankRegNo"   value="" />
		<input type="hidden" name="merchantData" value="" />
		<input type="hidden" name="buyertel" value="010-1234-5678" />
		<input type="hidden" name="buyername" value="이현기" />
		<input type="hidden" name="buyeremail" value="ctyhk17@gmail.com" />


<header>
<%-- 	<%@ include file="/WEB-INF/jsp/net/dangdang/include/fms/DdBrcHeaderInclude.jsp" %> --%>
	<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeaderInclude.jsp" %>
</header><!-- End of header -->   
    
<article>
    <div id="content_box">
        <div class="delivery_cap">
          <div class="cap_1">
               <div class="delivery_litle delivery_litle_1">
                   <h1>상품목록 </h1>
               </div>
               <div class="delivery_list">
                   <ul class="d_list">
                       <li>
                           <span>상품정보</span>
                       </li>
                       <li>
                           <span>판매자ID</span> 
                      </li>
                       <li>
                           <span>배송비</span>
                      </li>
                       <li>
                          <span>수량</span>
                       </li>
                       <li>
                          <span>상품단가</span>
                       </li>
                      <!--  <li>
                           <span>할인</span>
                       </li> -->
                       <li>
                           <span>주문금액</span>
                       </li>
                   </ul>
                 <c:choose>
                 	<c:when test="${mcmShpOrd001VO.ordDiv eq 'dir' }" >
	                   <ul class="d_list_1">
	                       <li>
	                           <span><c:out value="${resultInfo.gdsNm }" /></span>
	                      </li>
	                       <li>
	                           <span><c:out value="${resultInfo.pusrId }" /></span>
	                      </li>
	                       <li>
	                          <span>2,500원</span>
	                       </li>
	                       <li>
	                           <span><c:out value="${mcmShpOrd001VO.ordCnt }" /></span>
	                      </li>
	                       <li>
	                           <span><c:out value="${mcmShpOrd001VO.gdsAmt }" /></span>
	                      </li>
	                      <%--  <li>
	                           <span><c:out value="${resultInfo.salRt }" />%</span>
	                      </li> --%>
	                       <li>
	                          <span><fmt:formatNumber value="${mcmShpOrd001VO.ordCnt * mcmShpOrd001VO.ordAmt }"/>원</span>
	                       </li>
	                   </ul>
	                </c:when>
	                <c:otherwise>
	                	<c:forEach var="resultInfo" items="${resultList }">
	                		<ul class="d_list_1">
		                       <li>
		                           <span><c:out value="${resultInfo.gdsNm }" /></span>
		                      </li>
		                       <li>
		                           <span><c:out value="${resultInfo.pusrId }" /></span>
		                      </li>
		                       <li>
		                          <span>2,500원</span>
		                       </li>
		                       <li>
		                           <span><c:out value="${resultInfo.ordCnt }" /></span>
		                      </li>
		                       <li>
		                           <span><c:out value="${resultInfo.ordAmt }" />원</span>
		                      </li>
		                       <li>
		                          <span><fmt:formatNumber value="${resultInfo.ordAmtSum }"/>원</span>
		                       </li>
		                       <form:hidden path="gdsIds" value="${resultInfo.gdsId }" /> 
		                       <form:hidden path="lcsIds" value="${resultInfo.lcsId }" /> 
		                       <form:hidden path="crtId" value="${resultInfo.crtId }" /> 
	                   		</ul>
	                	</c:forEach>
	                </c:otherwise>
                  </c:choose>
               </div>
           </div><!-- End of cap_1 -->
           
           <div class="cap_1">
                   <div class="delivery_litle delivery_litle_1">
                       <h1>배송지정보 </h1>
                   </div>
                   <div class="d_list_2">
                       <ul class="d_ul">
                           <li class="f_li"><h4>수령인</h4></li>
                           <li class="f_li_1">
                           <span><p>
                           		<form:input path="rcptNm" value="${mcmShpOrd001VO.usrNm }" class="in_width1"/>
                           </p></span></li>
                       </ul>
                       <div class="line_1"></div>
                       <ul class="d_ul">
                           <li class="f_li"><h4>연락처</h4></li>
                           <li class="f_li_1">
                           	 <span><p>
                           		<form:input path="telNo" value="${addrInfo.telNo }" class="in_width1"/>
                           </p></span></li>
                       </ul>
                       
                       <div class="line_1"></div>
                       <ul class="d_ul">
                           <li class="f_li"><h4>배송지선택</h4></li>
                           <li class="f_li_1">
	                           <span><p> 
	                           			 <input type="radio" name="addr" id="addr" checked class="in_ra1" value="basic"/> 기본배송지 
	       							     <input type="radio" name="addr" id="addr"  class="in_ra2" value="new" /> 신규배송지 
	       							</p>
	       					   </span>
                       		</li>
                       </ul>
                       <div class="line_1"></div>
                       <ul class="d_ul d_ul_padding" style="height:105px;">
                           <li class="f_li"><h4>배송지주소</h4></li>
                           <li class="f_li_1"><span><p>
                           	<form:input path="dlvPstNo" class="postcodify_postcode5" value="${addrInfo.pstNo }" style="width:50%;"/>
                           	<a href="#;" id="postcodify_search_button" class="a_bt">우편번호</a></p>
                           	<p><form:input path="dlvRdAddr" class="postcodify_address" value="${addrInfo.rdAddr }" style="width:100%;"/></p>
	                        <p><form:input path="dlvAddrDtl" class="postcodify_details" value="${addrInfo.rdAddrDtl }" style="width:100%;"/></p>
	                        <p><form:input path="dlvDongNm" class="postcodify_extra_info" value="${addrInfo.dongNm }"  style="width:100%;"/></p>
                           	</span></li>
                       </ul>
                       
                      <div class="line_1"></div>
                       <ul class="d_ul">
                           <li class="f_li"><h4>배송메모</h4></li>
                           <li class="f_li_1"><span><form:input path="dlvNt" class="in_width2" /></span></li>
                       </ul>
                       <div class="line_1"></div>
                   </div>
           </div><!-- End of cap_1 -->
           
           <div class="cap_1 cap_2">
               <div class="delivery_litle delivery_litle_1">
                   <h1>결제방법</h1>
               </div>
               <div class="d_list_2">
                  <ul class="d_ul">
                      <li class="f_li"><b>결제금액</b></li>
                      <li class="f_li_1"><span class="f_color" id="ordTotAmtMask"><big><b></b></big><small>원</small><b style="padding:0 0 0 20px; color:#000;">(배송비 포함)</b></span></li>
                  </ul>
                  <div class="line_1"></div>
                  <ul class="d_ul">
                      <li class="f_li"><b>결제수단</b></li>
                      <li class="f_li_1 f_li_0">
                      <span>
	                      <input type="radio" name="payDiv" class="in_ra1" checked value="MOOZ">무통장입금(직접이체)  
	                      <input type="radio" name="payDiv" class="in_ra1"  value="MOO">무통장입금(가상계좌)  
	                      <input type="radio" name="payDiv" class="in_ra1" value="CAD">카드결제  
	                      <input type="radio" name="payDiv" class="in_ra1" value="VAC">계좌이체
                      </span></li>
                  </ul>
                  <div class="line_1"></div>
                  <ul class="d_ul">
                      <li class="f_li"><b>입금계좌</b></li>
                      <li class="f_li_1 f_li_01"><span>
                      <select name="" id="">
                      	<option value="">하나은행 110-282-340854 (주)매칭찬스비즈</option>
                      </select></span></li>
                  </ul>
                  <div class="line_1"></div>
                  <ul class="d_ul">
                      <li class="f_li"><b>입금자명</b></li>
                      <li class="f_li_1"><span><input type="text" class="in_width3"></span></li>
                  </ul>
                  <div class="line_1"></div>
               </div>
           </div><!-- End of cap_1 -->
           
       </div>
        <div class="last_btn">
               <a href="#;" id="btnPay">결제하기</a>
       </div>

    </div><!-- End of content_box -->
</article><!-- End of article -->
    
<footer>

    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcFooterInclude.jsp" %>
    
</footer><!-- End of footer -->

</form:form>
</body><!-- End of body -->

</html>