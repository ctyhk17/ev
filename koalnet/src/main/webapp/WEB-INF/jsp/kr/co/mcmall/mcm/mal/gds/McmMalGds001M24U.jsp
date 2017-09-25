<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
	    		$('#btnUpdate').click(function(){
	    			fnKeywordUpdate();
	    		}); 
	    		
	    		$('#btnBasicGo').click(function(){
					$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M04U.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    		$('#btnDetailGo').click(function(){
	    			$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M14U.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    		$('#btnKeywordGo').click(function(){
	    			$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M24U.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    		$('#btnCancle').click(function(){
	    			$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M01L.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    	});
	    	 function fnKeywordUpdate(){
	    		
	    		var kwdNm1 = $('#kwdNm1').val();
	    		var kwdNm2 = $('#kwdNm2').val();
	    		var kwdNm3 = $('#kwdNm3').val();
	    		var kwdNm4 = $('#kwdNm4').val();
	    		var kwdNm5 = $('#kwdNm5').val();
	    		var gdsId = $('#gdsId').val();
	    		
	    		var seqNo1 = $('#seqNo1').val();
	    		var seqNo2 = $('#seqNo2').val();
	    		var seqNo3 = $('#seqNo3').val();
	    		var seqNo4 = $('#seqNo4').val();
	    		var seqNo5 = $('#seqNo5').val();
	    		
	    		var kwdRssUrl1 = $('#kwdRssUrl1').val();
	    		var kwdRssUrl2 = $('#kwdRssUrl2').val();
	    		var kwdRssUrl3 = $('#kwdRssUrl3').val();
	    		var kwdRssUrl4 = $('#kwdRssUrl4').val();
	    		var kwdRssUrl5 = $('#kwdRssUrl5').val();
	    		
	    		jQuery.ajaxSettings.traditional = true;
				$.post(
								"<c:url value='/McmMalGds001M24UP.do'/>",
								{
									"kwdNm1":kwdNm1,
									"kwdNm2":kwdNm2,
									"kwdNm3":kwdNm3,
									"kwdNm4":kwdNm4,
									"kwdNm5":kwdNm5,
									"gdsId":gdsId,
									"seqNo1":seqNo1,
									"seqNo2":seqNo2,
									"seqNo3":seqNo3,
									"seqNo4":seqNo4,
									"seqNo5":seqNo5,
									"kwdRssUrl1":kwdRssUrl1,
									"kwdRssUrl2":kwdRssUrl2,
									"kwdRssUrl3":kwdRssUrl3,
									"kwdRssUrl4":kwdRssUrl4,
									"kwdRssUrl5":kwdRssUrl5
									
								}, function(responseText) {
									alert("키워드를 수정하셨습니다.");
								}, "json")
						.done(function(result) {
							fnResult();
								}).fail(function() {
							alert("키워드 수정을 실패하였습니다.");
						});
	    		
	    	}
	    	
	    	function fnResult(){
	    		$('#McmMalGds001VO').attr("action","<c:url value='/McmMalGds001M01L.do' />");
	    		$('#McmMalGds001VO').submit();
	    	}  
	    </script>
	</head>    
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
						                        <div class="resize_box" style="border-top:1px solid black;">
			                                            		<c:forEach var="resultList" items="${resultList}" varStatus="status">
			                                            		<ul>
				                                                <li class="title_back title_back_p title_back_b" style="width:25%;text-align: center;">키워드${status.count}</li>
				                                                <li class="sub_back_p sub_back_b"style="width: 25%;">
<%-- 				                                                	<form:input path="kwdNm1" style="vertical-align:13px;"  /> --%>
				                                                	<input type="text" name="kwdNm${status.count}" id="kwdNm${status.count}" style="vertical-align:13px;width: 95%;" value="${resultList.kwdNm}"  />
				                                                </li>
				                                                <li class="title_back title_back_p title_back_b" style="width:25%;text-align: center;">키워드 처리상태</li>
				                                                <li class="sub_back_p sub_back_b" style="font-size:15px;vertical-align:-2px;">
				                                                	<c:choose>
				                                                		<c:when test="${resultList.kwdSttCd eq 'GDS002001'}">
				                                                			요청
				                                                		</c:when>
				                                                		<c:otherwise>
				                                                			완료
				                                                		</c:otherwise>
				                                                	</c:choose>
<%-- 				                                                	<input type="text" name="kwdRssUrl${status.count}" id="kwdRssUrl${status.count}" style="vertical-align:13px;width: 100%;" value="${resultList.kwdRssUrl}"  /> --%>
				                                                	<input type="hidden" name="seqNo${status.count}" id="seqNo${status.count}" value="${resultList.seqNo}"/>
				                                                </li>	
				                                        		</ul>     
				                                             	</c:forEach>
				                                             <c:forEach varStatus="status"  begin="${fn:length(resultList)+1 }" end="5">
				                                             	<ul>
				                                                <li class="title_back title_back_p title_back_b" style="width:25%;text-align: center;">키워드${status.current}</li>
				                                                <li class="sub_back_p sub_back_b" style="width: 25%;">
<%-- 				                                                	<form:input path="kwdNm1" style="vertical-align:13px;"  /> --%>
				                                                	<input type="text" name="kwdNm${status.current}" id="kwdNm${status.current}" style="vertical-align:13px;width: 95%;"/>
				                                                </li>
				                                                <li class="title_back title_back_p title_back_b" style="width:25%;text-align: center;">키워드 처리상태</li>
				                                                <li class="sub_back_p sub_back_b">
				                                                </li>
				                                                </ul>
				                                             </c:forEach>
				                                           </ul>     	
			                                    </div><!-- resize_box -->
                              			<div class="save_button">
                              				<a href="#" id="btnUpdate">수정</a>
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