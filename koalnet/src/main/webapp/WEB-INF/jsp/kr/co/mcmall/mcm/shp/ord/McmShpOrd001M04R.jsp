<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>




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
<!--                       <div class="sub3_con"> -->
                      <%-- <p><b>주문번호 : ${ resultInfo.ordNo }</b></p>
                      <p><b>결제금액 : ${resultInfo.ordTotAmt} 원</b></p>
                      <br>
                      <p><strong>주문 금액은 아래의 계좌로 입금 후 연락부탁드립니다.</strong></p>
                      <p><strong>계좌번호 : <b>농협 000-00-000000 예금주</b></strong></p> 
                      <p class="sub3_color_0"><small>전화번호 : 0000-0000</small></p> --%>
                      
                      
                      <div class="sub3_con">
                      
                      <p><strong>*구매내역</strong></p>
                      <table border="1px solid" width="100%">
                    <%--   <p><b>주문번호 : ${ resultMap.ordNo }</b></p>
                     		
                     		<p><b>상품명 : ${ resultMap.gdsNm} </b></p>
                     		<p><b>구매갯수 : ${ resultMap.ordCnt} </b></p>
                     		<p><b>상품가격 : ${ resultMap.ordAmt} </b></p> --%>
                     	<colgroup>
                     		<col width="25%">
                     		<col width="25%">
                     		<col width="25%">
                     		<col width="25%">
                     	</colgroup>
                     	<thead>
                     		<th>주문번호</th>
                     		<th>상품명</th>
                     		<th>구매갯수</th>
                     		<th>상품가격</th>
                     	</thead>	
                      <c:forEach var="resultMap" items="${resultList}" >
                      	<tr>
                      		<td>${ resultMap.ordNo }</td>
                      		<td>${ resultMap.gdsNm}</td>
                      		<td>${ resultMap.ordCnt}</td>
                      		<td>${ resultMap.ordAmt}</td>
                      	</tr>
                      </c:forEach>
                      </table>
                      <p><b>결제금액 : ${ usrMap.ordTotAmt} </b></p>
                      <p></p>
                      <p></p>
                      <p></p>
                      <p><strong>*구매자 정보</strong></p>
                      <table border="1px solid" width="100%">
                     	<colgroup>
                     		<col width="20%">
                     		<col width="10%">
                     		<col width="20%">
                     		<col width="20%">
                     		<col width="15%">
                     		<col width="15%">
                     	</colgroup>
                     	<thead>
                     		<th>전화번호</th>
                     		<th>우편번호</th>
                     		<th>주소</th>
                     		<th>주소상세</th>
                     		<th>구매자명</th>
                     		<th>구매자ID</th>
                     	</thead>	
                     	<tr>
                      		<td>${ usrMap.telNo }</td>
                      		<td>${ usrMap.dlvPstNo}</td>
                      		<td>${ usrMap.dlvRdAddr}</td>
                      		<td>${ usrMap.dlvRdAddrDtl}</td>
                      		<td>${ usrMap.usrNm}</td>
                      		<td>${ usrMap.usrId}</td>
                      	</tr>
                      </table>
                      
                      
                      <p><strong>*결제 정보</strong></p>
                      <c:if test="${not empty resultMap.payMethod  }">
                      	<c:if test="${resultMap.payMethod eq 'Card' }">
							 <p><b>카드번호 : ${ resultMap.CARD_Num } || 승인번호 : ${ resultMap.applNum }</b></p>
                      	</c:if>
                      	<c:if test="${resultMap.payMethod eq 'VBank' }">
 	                         <table border="1px solid" width="100%">
		                     	<colgroup>
		                     		<col width="20%">
		                     		<col width="20%">
		                     		<col width="20%">
		                     		<col width="10%">
		                     		<col width="15%">
		                     		<col width="15%">
		                     	</colgroup>
		                     	<thead>
		                     		<th>입금계좌번호</th>
		                     		<th>은행코드</th>
		                     		<th>은행명</th>
		                     		<th>예금주</th>
		                     		<th>송금자</th>
		                     		<th>송금 일자</th>
		                     	</thead>	
		                     	<tr>
		                      		<td>${ resultMap.VACT_Num }</td>
		                      		<td>${ resultMap.VACT_BankCode}</td>
		                      		<td>${ resultMap.vactBankName}</td>
		                      		<td>${ resultMap.VACT_Name}</td>
		                      		<td>${ resultMap.VACT_InputName}</td>
		                      		<td>${ resultMap.VACT_Date}</td>
		                      	</tr>
		                      </table>
                      	</c:if>
                      	
                      	<c:if test="${resultMap.payMethod eq 'DirectBank' }">
                      		 <p><b>입금은행코드 : ${ resultMap.ACCT_BankCode }</b></p>
                      		 <p><b>결제가 완료되었습니다.</b></p>
                      	</c:if>
                      	
                      </c:if>
                      
                      </div>
                      
                </div>
            </div> 
            <div class="line"></div>
            
            
            <div class="sub_box_2_2" id="sub_box_bu">
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