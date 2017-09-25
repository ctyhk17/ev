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
		
		
		
			$(document).ready(function () {  

				// 완료후 이동 화면
				$("#btnGoComplete").click(function() {	
					/* btnGoComplete(); */
					alert('서비스 준비중');
				});
				

			});
			
			
			// 완료후 이동 화면
			function btnGoComplete(){
				
				$("#ddFndOrd001VO").attr("action", "<c:url value='/cmn/usr/DdCmnUsr006L.do'/>");
				$("#ddFndOrd001VO").submit();
			}
			
			
			$(document).keydown(function(e) {
			    key = (e) ? e.keyCode : event.keyCode;
			     
			    var t = document.activeElement;
			     
			    if (key == 8 || key == 116 || key == 17 || key == 82) {
			        if (key == 8) {
			            if (t.tagName != "INPUT") {
			                if (e) {
			                    e.preventDefault();
			                } else {
			                    event.keyCode = 0;
			                    event.returnValue = false;
			                }
			            }
			        } else {
			            if (e) {
			                e.preventDefault();
			            } else {
			                event.keyCode = 0;
			                event.returnValue = false;
			            }
			        }
			    }
			});
			
			window.history.forward(1);

			
		</script>
		
		
</head><!-- End of head -->

<body>

<form:form commandName="ddFndOrd001VO" name="ddFndOrd001VO" method="post">
		<%-- <form:hidden path="ordNo" />
		<form:hidden path="fndId" />
		<form:hidden path="lcsNo" /> --%>
										
		
		
<header>
	<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeaderInclude.jsp" %>
</header><!-- End of header -->   
    
<article>
    

<div id="content_box">
   
        <div class="sub_content_1">
           
           
           <c:if test="${ 'Y' eq isSucc }">
	           	<div id="sub7_content">
	              <h1><img src="<c:url value='/images/dang_logo_1.png' />" alt=""><small>결제확인</small></h1>
	              <h2>결제가 성공적으로 이루어졌습니다.</h2>
	                 
	                 <%--
	                 <div> <p>예매번호 <span> ${ resultMap.resultCode } </span></p></div>
	                 <div> <p>예매번호 <span> ${ resultMap.resultMsg } </span></p></div>
	                  --%>
	                  <div> <p>예매번호 <span> ${ resultMap.MOID } </span></p></div>
	                  <div> <p>결제금액 <span> <fmt:formatNumber value="${resultMap.TotPrice}" groupingUsed="true"/> 원 </span> </p></div>
	                  <div> <p>결제정보 <span> ${ resultMap.payMethod } </span> </p></div>
	                  
	                  <c:if test="${'VBank' eq resultMap.payMethod  }">
	                  	<div> <p>입금 은행명 <span> ${ resultMap.vactBankName } </span> </p></div>
	                  	<div> <p>입금 계좌번호 <span> ${ resultMap.VACT_Num } </span> </p></div>
	                  	<div> <p>예금주 명 <span> ${ resultMap.VACT_Name } </span> </p></div>
	                  	<div> <p>송금자 명 <span> ${ resultMap.VACT_InputName } </span> </p></div>
	                  	<div> <p>송금 일자 <span> ${ resultMap.VACT_Date } </span> </p></div>
	                  	<%-- <div> <p>송금 시간 <span> ${ resultMap.VACT_Time } </span> </p></div> --%>
	                  </c:if>
	                  
	                  
					 
	                        
	            </div>
           </c:if>
           <c:if test="${ 'Y' ne isSucc }">
           		<div id="sub7_content">
	              <h1><img src="<c:url value='/images/dang_logo_1.png' />" alt=""><small>결제확인</small></h1>
	              <h2>결제처리중 오류가 발생하였습니다.</h2>
	                  <div> <p>관리자에게 문의 바랍니다.</p></div>
	            </div>
           </c:if>
            
               
            <div id="sub_box_2_2">
	            <div class="line"></div>
	            	<div class="sub_box_2_2" id="sub_box_bu">
	            		<a href="#;" id="btnGoComplete" class="ti"><h2>확인</h2></a>
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