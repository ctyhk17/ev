<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
	
	<head>
	
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    
	    
	    <script type="text/javascript">
			
			$(document).ready(function(){
						
						$('#btnSearch').click(function( ){
							
							$("#mcmCmnBbs006VO").attr("action", "<c:url value='/McmCmnBbs006M11L.do'/>");
							$("#mcmCmnBbs006VO").submit();	
						});
						
						$('#btnWrite').click(function(){
				    		location.href="<c:url value='/McmCmnBbs006M13C.do'/>?upMenuId=M003&subMenuId=M003002"
				    	});
						
						infoView($("[name=resultList]"));			
					});
					
					//상세조회
					function infoView(obj){
						obj.css("cursor","pointer").click(function(){
							
							
							$("#bbsId").val($(this).attr("bbsId"));
							$("#bbsGrpId").val($(this).attr("bbsGrpId"));
							
							$("#mcmCmnBbs006VO").attr("action", "<c:url value='/McmCmnBbs006M14U.do'/>");
							$("#mcmCmnBbs006VO").submit();
						});
					};
					
					
					//페이징처리
					function fncLinkPage(pageNo){
						$("#pageIndex").val(pageNo);
						$("#mcmCmnBbs006VO").attr("action", "<c:url value='/McmCmnBbs006M11L.do'/>");
						$("#mcmCmnBbs006VO").submit();
					};
					
					
					function fnTab(faqCd) {
						
						$("#bbsOpn").val(faqCd);
						
						$("#mcmCmnBbs006VO").attr("action", "<c:url value='/McmCmnBbs006M11L.do'/>");
						$("#mcmCmnBbs006VO").submit();
						
					}
					
					
				
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmCmnBbs006VO" name="mcmCmnBbs006VO" method="post">
	<form:hidden path="bbsId" />
	<form:hidden path="bbsGrpId" />
	<form:hidden path="bbsOpn" />
	
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
								<div class="aside_menu_back">고객센터 > <b>FAQ</b></div>
								<%-- 페이지 네베게이션  끝--%>
				                    
								<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
				                    
				                    
								<div class="content_1">
				                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>FAQ<small>| FAQ를 조회 하실 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                        
			                        
			                         <div class="pointer_cap">
			                        	<div class="pointer <c:if test="${'FAQ001001' eq bbsOpn  }">pointer_active</c:if>"><a href="#;" style="color:black;" onclick="javascript:fnTab('FAQ001001');" >전체보기</a></div>
			                        	<div class="pointer <c:if test="${'FAQ001002' eq bbsOpn  }">pointer_active</c:if>"><a href="#;" style="color:black;" onclick="javascript:fnTab('FAQ001002');" >배송관련</a></div>
			                        	<div class="pointer <c:if test="${'FAQ001003' eq bbsOpn  }">pointer_active</c:if>"><a href="#;" style="color:black;" onclick="javascript:fnTab('FAQ001003');" >교환/환불</a></div>
			                        	<div class="pointer <c:if test="${'FAQ001004' eq bbsOpn  }">pointer_active</c:if>"><a href="#;" style="color:black;" onclick="javascript:fnTab('FAQ001004');" >AS관련</a></div>
			                        	<div class="pointer <c:if test="${'FAQ001005' eq bbsOpn  }">pointer_active</c:if>"><a href="#;" style="color:black;" onclick="javascript:fnTab('FAQ001005');" >회원/적립</a></div>
			                        	<div class="pointer <c:if test="${'FAQ001006' eq bbsOpn  }">pointer_active</c:if>"><a href="#;" style="color:black;" onclick="javascript:fnTab('FAQ001006');" >기타</a></div>
			                        </div> 
			                        <div class="line_class"></div>
			                        
			                        <div class="content_1_1">
			                             <div class="tab tab_1 tab_1_active">
			                                    <div class="tab_line tab_1_1">
			                                        
			                                       <%-- ========================================== --%>
			                                       <%-- 본문 시작 --%>
			                                       <%-- ========================================== --%>
			                                       <div class="resize_box">
			                                       </div>
			                                        <div class="suchen_result_cap">
					                                        <div>
					                                        	<div class="flex first_flex">
					                                                <ul>
					                                                    <li style="width:5%;">분류</li>
					                                                    <li style="width:94%;">제목</li>
					                                                </ul>
					                                            </div>
					                                        
					                                            <c:forEach var ="resultMap" items="${resultList}">
					                                            <div class="flex flex_2" >
					                                                <ul>
					                                            		<c:choose>
					                                            			<c:when test="${checkAth }">
					                                            				<c:if test="${resultMap.bbsGrpDep eq 1 }"><li style="width:5%;" name="resultList"  bbsId = "${resultMap.bbsId }" bbsGrpId = "${resultMap.bbsGrpId }">질문</li></c:if>
					                                            			</c:when>
					                                            			<c:otherwise>
					                                            				<c:if test="${resultMap.bbsGrpDep eq 1 }"><li style="width:5%;">질문</li></c:if>
					                                            			</c:otherwise>
					                                            		</c:choose>
						                                            			<c:if test="${resultMap.bbsGrpDep eq 2 }"><li style="width:5%;background: #f1f1f1;">답변</li></c:if>
					                                                    <c:choose>
					                                                    	<c:when test="${checkAth}">
						                                            			<c:if test="${resultMap.bbsGrpDep eq 1 }"><li style="width:94%; text-align: left;" name="resultList"  bbsId = "${resultMap.bbsId }" bbsGrpId = "${resultMap.bbsGrpId }"><c:out value="${resultMap.bbsCnts }" />&nbsp;</li></c:if>
					                                            			</c:when>
					                                            			<c:otherwise>
					                                            				<c:if test="${resultMap.bbsGrpDep eq 1 }"><li style="width:94%; text-align: left;"><c:out value="${resultMap.bbsCnts }" />&nbsp;</li></c:if>
					                                            			</c:otherwise>
					                                            		</c:choose>
					                                                    	<c:if test="${resultMap.bbsGrpDep eq 2 }"><li style="width:94%; text-align: left; background: #f1f1f1;"><c:out value="${resultMap.bbsCnts }" />&nbsp;</li></c:if>
					                                                </ul>
					                                            </div>   
						                                        </c:forEach>
						                                       <c:if test="${ empty resultList }" >
					                                            	<div class="flex flex_2" >
						                                                <ul>
						                                                    <li style="width: 99%;">조회 결과가 없습니다.</li>
						                                                </ul>
						                                        	</div>
					                                            </c:if>
						                                      
					                                        
					                                            <%-- 페이지 네비게이션 끝 --%>
					                                            <div class="next">
					                                            &nbsp;
													           </div>
					                                          <div class="save_button">
					                                          <c:if test="${checkAth}">
																	<a href="#" id="btnWrite">글쓰기</a> 
															  </c:if>
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