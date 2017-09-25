<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
	
	<head>
	
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    
	    
	    <script type="text/javascript">
			
			$(document).ready(function(){
						
				$('#btnSearch').click(function( ){
					
					$("#mcmCmnPot001VO").attr("action", "<c:url value='/McmCmnPot001M01L.do'/>");
					$("#mcmCmnPot001VO").submit();	
				});
				
				infoView($("[name=resultList]"));			
			});
			
			//상세조회
			function infoView(obj){
				obj.css("cursor","pointer").click(function(){
					
					
					$("#usrId").val($(this).attr("usrId"));
					$("#strId").val($(this).attr("strId"));
					
					$("#mcmCmnPot001VO").attr("action", "<c:url value='/McmCmnPot001M02R.do'/>");
					$("#mcmCmnPot001VO").submit();
				});
			};
			
			
			//페이징처리
			function fncLinkPage(pageNo){
				$("#pageIndex").val(pageNo);
				$("#mcmCmnPot001VO").attr("action", "<c:url value='/McmCmnPot001M01L.do'/>");
				$("#mcmCmnPot001VO").submit();
			};

			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmCmnPot001VO" name="mcmCmnPot001VO" method="post">
	<form:hidden path="usrId" />
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
								<div class="aside_menu_back">현황통계 > <b>포인트조회</b></div>
								<%-- 페이지 네베게이션  끝--%>
				                    
								<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
				                    
				                    
								<div class="content_1">
				                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>포인트조회 <small>| 포인트조회를 할 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                        
			                        <div class="content_1_1">
			                             <div class="tab tab_1 tab_1_active">
			                                    <div class="tab_line tab_1_1"> 
			                                       
			                                      <%-- 검색 결과 시작 --%>
			                                        <div class="resize_box">
			                                           <!-- <h3>1:1상담</h3> -->
		                                                <ul class="re_first">			                                             
			                                              <li class="title_back" style="width : 10%;">상점명</li>
                                                		  <li class="sub_back" style="width : 20%;">
                                                		  	<form:select path="scStrId" style="width:90%;">
			                                                		<form:option value="">선택</form:option>
			                                                	<c:forEach var="strList" items="${selectStrList}">
			                                                		<form:option value="${strList.strId}">${strList.strNm}</form:option>
			                                                	</c:forEach>
			                                                </form:select>	
                                                		  </li>
                                                		  <li class="title_back" style="width : 10%;">이름</li>
                                                		  <li class="sub_back" style="width : 20%;">
                                                		  	<form:input path="scUsrNm" style="text-align:center; width: 90%;" /> 
                                                		  </li>
                                                		  <li class="title_back" style="width : 10%;">아이디</li>
                                                		  <li class="sub_back" style="width : 20%;">
                                                		  	<form:input path="scUsrId" style="text-align:center; width: 90%;" /> 
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
					                                                    <li style="width:18%;">상점ID</li>
					                                                    <li style="width:18.49999%;">상점명</li>
					                                                    <li style="width:18%;">이름</li>
					                                                    <li style="width:18%;">아이디</li>
					                                                    <li style="width:18%;">포인트합계</li>
					                                                </ul>
					                                            </div>
					                                            <c:forEach var ="resultMap" items="${resultList}">
					                                            <div class="flex flex_2" >
					                                                <ul name="resultList"  usrId = "${resultMap.usrId }" strId="${resultMap.strId }"  >
					                                                    <li style="width:9%;"><c:out value="${resultMap.rn }" /></li>
					                                                    <li style="width:18%;"><c:out value="${resultMap.strId }" /></li>
					                                                    <li style="width:18.49999%;"><c:out value="${resultMap.strNm }" /></li>
					                                                    <li style="width:18%;"><c:out value="${resultMap.usrNm }" /></li>
					                                                    <li style="width:18%;"><c:out value="${resultMap.usrId }" /></li>
					                                                    <li style="width:18%;">${resultMap.potTotSum }</li>
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
						                                        <div class="flex last_flex">
					                                            </div>
					                                            <%-- 페이지 네비게이션 시작 --%>
					                                 			<div class="next">
					                                            	<ul>
														        		<ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fncLinkPage" />
														        		<form:hidden path="pageIndex" />
														        	</ul>
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