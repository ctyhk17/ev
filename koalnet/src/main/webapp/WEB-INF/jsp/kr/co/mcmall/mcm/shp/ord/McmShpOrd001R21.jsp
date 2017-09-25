<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%

response.setHeader("cache-control","no-cache, no-store, must-revalidate");
response.setHeader("expires","0");
response.setHeader("pragma","no-cache");

%>
<%
  /**
  * @Class Name : FmsFndOrd001R21.jsp
  * @Description : 예매자 회원가입 완료
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

				// 회원간단가입화면 이동
				$("#btnGoNext").click(function() {	
					btnGoNext();
				});

			});
			
			
			// 회원간단가입화면 이동
			function btnGoNext(){
				
				$("#ddFndOrd001VO").attr("action", "<c:url value='/fnd/ord/DdFndOrd001R22.do'/>");
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
            
            <div class="sub_box_1" id="sub4_box">
            <h1><img src="<c:out value='/images/Mv.png' />" alt="" /> 라이트월드기념품확인<small style="font-size:14px;color:red;vertical-align: -4px;margin-left:5px;padding-left:5px;">l 3가지 제품중 1가지 선택형 상품 입니다.</small></h1>
            <div class="line" id="line_top"></div> 
            <div id="sub4_box_1">
            <div><h3>No.01</h3><img src="<c:out value='/images/Layer-2.png' />" alt="" /></div>
            <div>
            <h4>뉴욕주립대 인증</h4><h1>4th워터 스템 미스트</h1>
            <p>뉴욕주립대 인증 워터 스템 미스트 </p>
            </div>
            </div>
            
            <div id="sub4_box_1">
            <div><h3>No.02</h3><img src="<c:out value='/images/Layer-1.png' />" alt="" /></div>
            <div>
            <h4>뉴욕주립대 인증</h4><h1>산삼효소비누세트</h1>
            <p> 뉴욕주립대 인증 산삼효소비누세트</p>
            </div>
            </div>
            
            <div id="sub4_box_1">
            <div><h3>No.03</h3><img src="<c:out value='/images/Layer-3.png' />" alt="" /></div>
            <div>
            <h4>한국조폐공사</h4><h1>당협쇼핑몰월드 기념주화</h1>
            <p> 한국조폐공사 당협쇼핑몰월드 기념주화</p>
            </div>
            </div>

            </div>
            <div id="sub_box_2_2">
            <div class="line"></div>
            <div class="sub_box_2_2">
            	<a href="#;" id="btnGoNext" class="ti">
            		<h2>회원간단가입</h2>
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