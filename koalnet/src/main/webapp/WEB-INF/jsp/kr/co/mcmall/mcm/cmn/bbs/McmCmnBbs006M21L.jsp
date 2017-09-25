<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
	
	<head>
	
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    
	    
	    <script type="text/javascript">
			
			$(document).ready(function(){
						
						$('#btnSearch').click(function( ){
							
							$("#mcmCmnBbs006VO").attr("action", "<c:url value='/McmCmnBbs006M21L.do'/>");
							$("#mcmCmnBbs006VO").submit();	
						});
						
						$('#btnWrite').click(function(){
				    		location.href="<c:url value='/McmCmnBbs006M23C.do'/>?upMenuId=M003&subMenuId=M003003"
				    	});
						
						infoView($("[name=resultList]"));			
					});
					
					//상세조회
					function infoView(obj){
						obj.css("cursor","pointer").click(function(){
							
							
							$("#bbsId").val($(this).attr("bbsId"));
							
							$("#mcmCmnBbs006VO").attr("action", "<c:url value='/McmCmnBbs006M22R.do'/>");
							$("#mcmCmnBbs006VO").submit();
						});
					};
					
					
					//페이징처리
					function fncLinkPage(pageNo){
						$("#pageIndex").val(pageNo);
						$("#mcmCmnBbs006VO").attr("action", "<c:url value='/McmCmnBbs006M21L.do'/>");
						$("#mcmCmnBbs006VO").submit();
					};
					
					//검색
					function onSearchList() {
						
						$("#mcmCmnBbs006VO").attr("action", "<c:url value='/McmCmnBbs006M21L.do'/>");
						$("#mcmCmnBbs006VO").submit();
						
					}
				
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmCmnBbs006VO" name="mcmCmnBbs006VO" method="post">
	<form:hidden path="bbsId" />
	
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
								<div class="aside_menu_back">고객센터 > <b>공지사항</b></div>
								<%-- 페이지 네베게이션  끝--%>
				                    
								<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
				                    
				                    
								<div class="content_1">
				                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>공지사항 <small>| 공지사항을 조회하실 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>       
			                        <div class="content_1_1">
			                             <div class="tab tab_1 tab_1_active">
			                                    <div class="tab_line tab_1_1"> 
			                                       
			                                      <%-- 검색 결과 시작 --%>
			                                        <div class="resize_box">
		                                                <ul class="re_first">			                                            
			                                              <li class="title_back"style="width:15%;">공지사항</li>
                                                		  <li class="sub_back"style="width:80%;">
                                                		  	<form:input type="text" path="bbsSbj" style="width:70%;"/>
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
					                                                    <li style="width:9%;">번호</li>
					                                                    <li style="width:60.69999%;">공지사항</li>
					                                                    <li style="width:15%;">작성자명</li>
					                                                    <li style="width:15%;">등록일</li>
					                                                </ul>
					                                            </div>
					                                            <c:forEach var ="resultMap" items="${resultList}">
					                                            <div class="flex flex_2" >
					                                                <ul name="resultList"  bbsId = "${resultMap.bbsId }">
					                                                    <li style="width:9%;"><c:out value="${resultMap.rn }" /></li>
					                                                    <li style="width:60.69999%; text-align: left;"><c:out value="${resultMap.bbsSbj }" /></li>
					                                                    <li style="width:15%;"><c:out value="${resultMap.usrNm }" /></li>
					                                                    <li style="width:15%;"><c:out value="${resultMap.lstUdtDt }" /></li>
					                                                </ul>
					                                            </div>   
						                                        </c:forEach>
						                                       <c:if test="${ empty resultList }" >
					                                            	<div class="flex flex_2" >
						                                                <ul>
						                                                    <li style="width: 99.89999%;">조회 결과가 없습니다.</li>
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
					                                            <c:if test="${checkAth }">
				                                            		<div class="save_button">
																		<a href="#" id="btnWrite">글쓰기</a> 
																	</div>
																</c:if>
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