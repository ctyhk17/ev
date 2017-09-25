<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%

response.setHeader("cache-control","no-cache, no-store, must-revalidate");
response.setHeader("expires","0");
response.setHeader("pragma","no-cache");

%>
<%
  /**
  * @Class Name : FmsFndOrd001R22.jsp
  * @Description : 일반회원 회원가입
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

				// 예매화면으로 이동
				$("#btnGoOrd").click(function() {	
					btnGoOrd();
				});
				
				
			});
			
			
			// 예매화면으로 이동
			function btnGoOrd(){
				
				$("#ddFndOrd001VO").attr("action", "<c:url value='/fnd/ord/DdFndOrd001R01.do'/>");
				$("#ddFndOrd001VO").submit();
			}
			
						
			
		</script>	
</head><!-- End of head -->

<body>

<form:form commandName="ddFndOrd001VO" name="ddFndOrd001VO" method="post">
		<form:hidden path="gvaNo" />
		<form:hidden path="fndId" />
		<form:hidden path="lcsNo" />
		
		
<header>
	<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeaderInclude.jsp" %>
</header><!-- End of header -->   
    
<article>
    <div id="content_box">
   
        <div class="sub_content_1">
           
           <div id="sub5_content">
               <div>
               <img src="<c:out value='/images/box.png' />" alt="" />
                <h1>기념품 신청이 완료되었습니다.</h1>
                      <p><b>기념품 쿠폰번호 : ${ ddFndOrd001VO.gvaNo } </b><br />
                      회원 가입만 하셔도! <br> 
                         모든분에게 2만원 상당의 오픈 기념품을 드려요!!!</p><br/>
                      <p>당협쇼핑몰월드 자유이용권(3만원)을 예매하시는 분에게<br/>
                         홍보위원으로 위촉해드리고, 오픈 후 <br/>
                         기념품 및 홍보비 (3만원)를 배당해 드려요!!</p>
                </div>
                
            </div>   
            <div id="sub_box_2_2">
            <div class="line"></div>
            <div class="sub_box_2_2" id="sub_box_bu">
            	<a href="#;" id="btnGoOrd" class="ti"><img src="<c:out value='/images/ticat.png' />" alt="" /><h2>예매티켓 구입하기</h2></a>
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