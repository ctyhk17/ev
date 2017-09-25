<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmMalGds001M001L.jsp
  * @Description : 상품 키워드 등록
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2017.06.20            최초 생성
  *
  * author 개발팀
  * since 2017.06.20
  *
  */
%>
<!DOCTYPE html> 
<html lang="ko">
	<head>
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    <script>
	    	$(document).ready(function(){
	    		$('#btnInsert').click(function(){
	    			fnKeywordInsert();
	    		});
	    		
	    		$('#btnBasicGo').click(function(){
					$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M03C.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    		$('#btnDetailGo').click(function(){
	    			$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M13C.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    		$('#btnKeywordGo').click(function(){
	    			$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M23C.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    		$('#btnCancle').click(function(){
	    			$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M01L.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    	});
	    	function fnKeywordInsert(){
	    		
	    		
	    		var kwdNm1 = $('#kwdNm1').val();
	    		var kwdNm2 = $('#kwdNm2').val();
	    		var kwdNm3 = $('#kwdNm3').val();
	    		var kwdNm4 = $('#kwdNm4').val();
	    		var kwdNm5 = $('#kwdNm5').val();
	    		var gdsId = $('#gdsId').val();
	    		
	    		jQuery.ajaxSettings.traditional = true;
				$.post(
								"<c:url value='/McmMalGds001M23CP.do'/>",
								{
									"kwdNm1":kwdNm1,
									"kwdNm2":kwdNm2,
									"kwdNm3":kwdNm3,
									"kwdNm4":kwdNm4,
									"kwdNm5":kwdNm5,
									"gdsId":gdsId
								}, function(responseText) {
									alert("키워드를 설정하셨습니다.");
								}, "json")
						.done(function(result) {
							fnResult();
								}).fail(function() {
							alert("상품설정을 실패하셨습니다.");
						});
	    		
	    	}
	    	
	    	function fnResult(){
	    		$('#McmMalGds001VO').attr("action","<c:url value='/McmMalGds001M01L.do' />");
	    		$('#McmMalGds001VO').submit();
	    	}
	    </script>
	</head>
	<style>
	.pointer{
		cursor: default !important;
	}	
	.pointer:hover{
	background-color: #eeeeee !important;
	}
	</style>        
<body>
	<form:form commandName="McmMalGds001VO" name="McmMalGds001VO" method="post">
		<form:hidden path="gdsId" />
		<header>
    		<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeaderInclude.jsp" %>
		</header>
		
		<article>
			<div class="article_cap">
   				 <div class="aside_back">
            		<div class="aside">
           			     <%-- Left 메뉴 인클루드 시작 --%>
		                 <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminLeftMenuInclude.jsp" %>
		                 <%-- Left 메뉴 인클루드 종료 --%>
						<div class="content">
			                	<%-- 페이지 네베게이션 시작 --%>
			                    <div class="aside_menu_back">상품 > 상품관리 > <b>상품관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    <div class="content_1">
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>상품 등록 <small>| 쇼핑몰의 기본적인 키워드를 등록을 할 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                        <div class="pointer_cap">
			         					<div class="pointer" id="basicSetTab"><a href="#" id="btnBasicGo"  style="color:black">기본 설정</a></div>
			                        	<div class="pointer" id="detailSetTab"><a href="#" id="btnDetailGo"  style="color:black">상세 설명</a></div>
			                        	<div class="pointer  pointer_active" id="keywordSetTab"><a href="#" id="btnKeywordGo"  style="color:black">키워드</a></div>
			                        </div>
			                        
			                        <div class="content_1_1" id="basicSet">
                            			<div class="tab tab_1 tab_1_active">
                                    		<div class="tab_line tab_1_1">
						                        <div class="resize_box">
			                                           <h3>기본설정</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back title_back_p title_back_b" style="width:5%;text-align: center;">키워드1</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                	<form:input path="kwdNm1" style="vertical-align:13px;"  />
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:5%;text-align: center;">키워드2</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                	<form:input path="kwdNm2" style="vertical-align:13px;" />
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:5%;text-align: center;">키워드3</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                	<form:input path="kwdNm3" style="vertical-align:13px;" />
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:5%;text-align: center;">키워드4</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                	<form:input path="kwdNm4" style="vertical-align:13px;" />
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:5%;text-align: center;">키워드5</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                	<form:input path="kwdNm5" style="vertical-align:13px;" />
			                                                </li>
			                                            </ul>
			                                    </div><!-- resize_box -->
                              			<div class="save_button">
                              				<a href="#" id="btnInsert">등록</a>
                              				<a href="#" id="btnCancle">취소</a>
                              			</div>                              		
                              		</div>
                              	</div>
                              </div>
						</div>
					</div>	
				</div>
			</div>
		</div>	 
		</article>
		<footer>
		    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminFooterInclude.jsp" %>
		</footer><!-- End of footer -->		
	</form:form>	
</body>
</html>