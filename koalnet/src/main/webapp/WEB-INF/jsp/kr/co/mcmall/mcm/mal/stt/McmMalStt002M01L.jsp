<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmTplTpl001M01L.jsp
  * @Description : 템플릿 리스트 화면
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2016.07.12            최초 생성
  *
  * author 개발팀
  * since 2016.07.12
  *
  */
%>








<!DOCTYPE html>
<html lang="ko">
	
	<head>
	
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    
	    
	    <script type="text/javascript">
			
				$(document).ready(function () {
					 $( "#searchOrdDt" ).datepicker().mask("9999-99-99");
				     $( "#searchOrdDtTo" ).datepicker().mask("9999-99-99");
					
				    
				     
				     
				     $("#btnSearch").click(function(){
				    	 fnSearch();
				     });
				});
				     function fnSearch(){
							
							
							 if(!$("#searchOrdDt").val())
							 {
								 alert('시작 날짜를 선택하세요');
								 $("#searchOrdDt").focus();
								 return false;
							 }
						     if(!$("#searchOrdDtTo").val())
						     {
						    	 alert('끝 날짜를 선택하세요'); 
						    	 $("#searchOrdDtTo").focus();
						    	 return false;
						     }
						     var startDate = new Date($("#searchOrdDt").datepicker("getDate"));
							 var endDate = new Date($("#searchOrdDtTo").datepicker("getDate"));
							   if(endDate - startDate <0){
									alert('날짜를 확인해주십시오.');
										  return false;
								}
						     
						    $("#pageIndex").val("1");
							$("#mcmMalStt001VO").attr("action", "<c:url value='/McmMalStt002M01L.do'/>");
							$("#mcmMalStt001VO").submit();				    	 
				     }

						function fncLinkPage(pageNo){
							$("#pageIndex").val(pageNo);
							$("#mcmMalStt001VO").attr("action", "<c:url value='/McmMalStt002M01L.do'/>");
							$("#mcmMalStt001VO").submit();
						};
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmMalStt001VO" name="mcmMalStt001VO" method="post">
	<form:hidden path="lcsId"/>

	
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
			                    <div class="aside_menu_back">현황통계 > <b>일자별 매출현황</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>일자별 매출현황 <small>| 일자별 매출현황을 조회하실 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                        
			                        
			                        <!-- <div class="pointer_cap">
			                        	<div class="pointer pointer_active">탭메뉴1</div><div class="pointer">탭메뉴1</div><div class="pointer">탭메뉴1</div>
			                        </div> -->
			                        
			                        
			                        <div class="content_1_1">
			                             <div class="tab tab_1 tab_1_active">
			                                    <div class="tab_line tab_1_1"> 
			                                       
			                                       <%-- ========================================== --%>
			                                       <%-- 본문 시작 --%>
			                                       <%-- ========================================== --%>
			                                       
			                                       
			                                       
			                                        <%-- 검색조건 시작 --%>
													<div class="resize_box">
				                                            <ul class="re_first">
			                                                <li class="title_back" style="width:16%;">일자</li>
<%-- 			                                                <form:select path="searchGdsId"> --%>
<%-- 			                                                		<form:option value="">선택</form:option> --%>
<%-- 			                                                	<c:forEach var="gdsList" items="${selectGdsList}"> --%>
<%-- 			                                                		<form:option value="${gdsList.gdsId}">${gdsList.gdsNm}</form:option> --%>
<%-- 			                                                	</c:forEach> --%>
<%-- 			                                                </form:select>		 --%>
			                                                <%--
			                                                <li class="title_back" style="width:10%; text-align:center;">아이디</li>
			                                                <li class="sub_back" style="width:15%;"><form:input path="searchUsrId"/></li>
			                                                
			                                                <li class="title_back" style="width:10%; text-align:center;">이름</li>
			                                                <li class="sub_back" style="width:15%;"><form:input path="searchUsrNm"/></li>
			                                                 --%>
<%-- 									                    <div><span><label for="date" id="fl">일자 : </label><form:input path="searchOrdDt"  style="width:80px;"/> --%>
<%-- 									                    <label for="date">~ </label><form:input path="searchOrdDtTo" style="width:80px;" /></span></div>  --%>
									                    <li class="sub_back" style="width:30%;"><form:input path="searchOrdDt"  style="width:80px;"/>
									                    ~ <form:input path="searchOrdDtTo" style="width:80px;" /></li>			                                      			
			                                            </ul>
			                                            
													</div>
				                                    <%-- 검색조건 종료 --%>
			                                            
			                                            
			                                            
			                                       
			                                       
			                                       
			                                       
                                        
                                        
                                        
													<div class="suchen">
				                                                <a href="#" class="suchen_a" id="btnSearch">검색</a>
				                                    </div>
			                                        
			                                        
			                                        <div class="line_class"></div>
			                                        
			                                        
			                                        <%-- 검색 결과 시작 --%>
			                                        <div class="suchen_result_cap">
			                                        
			                                          
				                                        <%-- <div class="suchen_result">전체 <b><c:out value="${totCnt}"/></b>명</div> --%>
					                                        <div>
					                                            <div class="flex first_flex">
					                                                <ul>
<!-- 					                                                    <li style="width:5%;">순번</li> -->
					                                                    <li style="width:21.39999%;">날짜</li>
					                                                    <li style="width:13%;">총 주문 수 (건)</li>
					                                                    <li style="width:13%;">총 주문금액 (원)</li>
					                                                    <li style="width:13%;">입금 확인 수 (건)</li>
					                                                    <li style="width:13%;">입금 확인 금액 (원)</li>
					                                                    <li style="width:13%;">입금 미확인 수 (건)</li>
					                                                    <li style="width:13%;">입금 미확인 금액 (원)</li>
					                                                </ul>
					                                            </div>
					                                            <c:forEach var="selectResultListDay" items="${selectResultListDay}">
					                                            <div class="flex flex_2">
					                                                <ul>
<%-- 					                                                    <li style="width:5%;"><c:out value="${selectResultListDay.rn}"/></li> --%>
					                                                    <li style="width:21%;"><c:out value="${selectResultListDay.ordDt}"/></li>
					                                                    <li style="width:13%;"><fmt:formatNumber value="${selectResultListDay.cntAll}" type="number"/></li>
					                                                    <li style="width:13%;"><c:out value="${selectResultListDay.ordTotAmtall}"/></li>
					                                                    <li style="width:13%;height: 16px;"><fmt:formatNumber value="${selectResultListDay.cntOk}" type="number"/></li>
					                                                    <li style="width:13%;height: 16px;"><c:out value="${selectResultListDay.ordTotAmtOk}"/></li>
					                                                    <li style="width:13%;"><fmt:formatNumber value="${selectResultListDay.cntNo}" type="number"/></li>
					                                                    <li style="width:13%;"><c:out value="${selectResultListDay.ordTotAmtNo}"/></li>
<%-- 					                                                    <li style="width:29%;">http://www.koalnetcity.net/<c:out value="${selectResultListDay.lcsId}"/></li> --%>
					                                                </ul>
					                                            </div>
					                                            </c:forEach>
					                                            
					                                             <c:if test="${empty selectResultListDay}">
					                                            <div class="flex flex_2">
						                                            <ul>
						                                            	<li style="width:100%;">조회결과가 없습니다.</li>
						                                            </ul>
					                                            </div>
					                                            </c:if>
					                                            
					                                            <%-- 하단 버튼 시작 --%>
					                                            <div class="flex last_flex">
					                                                <!--    <a href="#">선택 가입승인</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">엑셀 다운로드</a>-->
					                                            </div> 
					                                            <%-- 하단 버튼 끝 --%>
					                                            
					                                            
					                                             <%-- 페이지 네비게이션 시작 --%>
<!-- 					                                           <div class="next"> -->
<!-- 					                                            	<ul> -->
<%-- 														        		<ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fncLinkPage" /> --%>
<%-- 														        		<form:hidden path="pageIndex" /> --%>
<!-- 														        	</ul> -->
<!-- 													           </div>  -->

					                                            <%-- 페이지 네비게이션 끝 --%>
				                                            
				                                        </div>
				                                        
			                                        </div>
			                                        <!-- suchen_result_cap -->
			                                        <%-- 검색 결과 종료 --%>
			                                        
			                                        
													<div class="save_button">
														<!-- <a href="#" id="btnAdd">사업자 등록</a> --> 
													</div>
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 <%-- ========================================== --%>
                                       				 <%-- 본문 종료 --%>
                                       				 <%-- ========================================== --%>
			                                        
											</div>
											<!-- End of tab_1_1 -->
										</div>
									</div>
								</div>
			                    
						</div><!-- End of content -->
			            
			            
					</div>
				</div>
			</div>   
		   
		</article><!-- End of article -->





		<footer>
		    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminFooterInclude.jsp" %>
		</footer><!-- End of footer -->
	
</form:form>
	
	</body><!-- End of body -->

</html>