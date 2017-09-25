<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
	
	<head>
	
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    
	    
	    <script type="text/javascript">
			
			$(document).ready(function(){
				
				$( "#stOrdDt" ).datepicker().mask("9999-99-99");
				$( "#endOrdDt" ).datepicker().mask("9999-99-99");
						
				$('#btnList').click(function( ){
					
					$("#mcmShpOrd004VO").attr("action", "<c:url value='/McmShpOrd004M41L.do'/>");
					$("#mcmShpOrd004VO").submit();	
				});
				
							
			});
			
			
			//페이징처리
			function fncLinkPage(pageNo){
				$("#pageIndex").val(pageNo);
				$("#mcmShpOrd004VO").attr("action", "<c:url value='/McmShpOrd004M41L.do'/>");
				$("#mcmShpOrd004VO").submit();
			};
					
				
				
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmShpOrd004VO" name="mcmShpOrd004VO" method="post">
	<form:hidden path="usrId" />
	<form:hidden path="ordNo" />
	<form:hidden path="strId" />
	
	
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
								<div class="aside_menu_back">주문관리 > 반품관리 ><b>반품현황</b></div>
								<%-- 페이지 네베게이션  끝--%>
				                    
								<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
				                    
				                    
								<div class="content_1">
				                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>반품현황 <small>| 반품 요청된 주문을 조회 할 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                 
			                        
			                        
			                        <div class="content_1_1">
			                             <div class="tab tab_1 tab_1_active">
			                                    <div class="tab_line tab_1_1"> 
			                                       
			                                      <%-- 검색 결과 시작 --%>
			                                        <div class="resize_box">
			                                           <!-- <h3>1:1상담</h3> -->
		                                                <ul class="re_first">
			                                              <li class="title_back">주문일자</li>
                                                		  <li class="sub_back">
                                                		  	<form:input path="stOrdDt" style="text-align:center;" /> ~ <form:input path="endOrdDt" style="text-align:center;"/>
                                                		  </li>
			                                            </ul>
			                                        </div><!-- resize_box -->
			                                        <div class="suchen"><a href="#" class="suchen_a" id="btnSearch">검색</a></div>
			                                        <div class="line_class"></div>
			                                        <%-- 검색 결과 시작 --%>
			                                        
			                                       <%-- ========================================== --%>
			                                       <%-- 본문 시작 --%>
			                                       <%-- ========================================== --%>
			                                        <div class="suchen_result_cap">
			                                        
			                                        
				                                        <div class="suchen_result"> 전체 <b><c:out value="${totCnt }" /></b></b>건</div>
					                                        <div>
					                                            <div class="flex first_flex">
					                                                <ul>
					                                                    <li style="width:8%;">번호</li>
					                                                    <li style="width:13%;">주문번호</li>
					                                                    <li style="width:13%;">상점명</li>
					                                                    <li style="width:13%;">주문자명</li>
					                                                    <li style="width:13%;">상품명</li>
					                                                    <li style="width:13%;">주문수량</li>
					                                                    <li style="width:13%;">상품금액</li>
					                                                    <li style="width:13%;">주문일자</li>
					                                                </ul>
					                                            </div>
					                                            <c:forEach var ="resultMap" items="${resultList}">
					                                            <div class="flex flex_2" >
					                                                <ul>
					                                                    <li style="width:8%;"><c:out value="${resultMap.rn }" /></li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.ordNo }" /></li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.strNm }" /></li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.usrNm }" /></li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.gdsNm }" /></li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.ordCnt }" /></li>
					                                                    <li style="width:13%;"><fmt:formatNumber value="${resultMap.ordAmt }" pattern="#,###.##"/>원</li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.ordDt }" /></li>
					                                                </ul>
					                                            </div>   
						                                        </c:forEach>
						                                         <c:if test="${ empty resultList }" >
					                                            	<div class="flex flex_2" >
						                                                <ul name="resultList">
						                                                    <li style="width: 99%;">조회 결과가 없습니다.</li>
						                                                </ul>
						                                        	</div>
					                                            </c:if>
						                                        <div class="flex last_flex">
					                                            </div>
					                                            <%-- 페이지 네비게이션 시작 --%>
					                                 			<div class="next">
					                                            	<ul>
														        		<ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fncLinkPage" />
														        		<form:hidden path="pageIndex" />
														        	</ul>
													           </div>
													             <%-- 페이지 네비게이션 끝 --%>
			                                            		<div class="save_button">
																	<a href="#" id="btnList">목록</a> 
																</div>
													          </div>
				                                        </div>
				                                        
			                                        </div>
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