<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
	
	<head>
	
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    
	    
	    <script type="text/javascript">
			
			$(document).ready(function(){
				
				$( "#stOrdDt" ).datepicker().mask("9999-99-99");
				$( "#endOrdDt" ).datepicker().mask("9999-99-99");
						
				$('#btnSearch').click(function( ){
					
					 var startDate = new Date($("#stOrdDt").datepicker("getDate"));
					 var endDate = new Date($("#endOrdDt").datepicker("getDate"));
					   if(endDate - startDate <0){
							alert('날짜를 확인해주십시오.');
								$("#endOrdDt").focus();
								  return false;
						}
					
					$("#mcmShpOrd004VO").attr("action", "<c:url value='/McmShpOrd004M41L.do'/>");
					$("#mcmShpOrd004VO").submit();	
				});
				
				infoView($("[name=resultList]"));			
			});
			
			//상세조회
			function infoView(obj){
				obj.css("cursor","pointer").click(function(){
					
					
					$("#usrId").val($(this).attr("usrId"));
					$("#ordNo").val($(this).attr("ordNo"));
					$("#strId").val($(this).attr("strId"));
					
					$("#mcmShpOrd004VO").attr("action", "<c:url value='/McmShpOrd004M42R.do'/>");
					$("#mcmShpOrd004VO").submit();
				});
			};
			
			
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
								<div class="aside_menu_back">주문관리 > <b>반품관리</b></div>
								<%-- 페이지 네베게이션  끝--%>
				                    
								<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
				                    
				                    
								<div class="content_1">
				                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>반품관리 <small>| 반품 요청된 주문을 조회 할 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                 
			                        
			                        
			                        <div class="content_1_1">
			                             <div class="tab tab_1 tab_1_active">
			                                    <div class="tab_line tab_1_1"> 
			                                       
			                                      <%-- 검색 결과 시작 --%>
			                                        <div class="resize_box">
			                                           <!-- <h3>1:1상담</h3> -->
		                                                 <ul class="re_first">
			                                              <li class="title_back" style="width : 8%;">주문일자</li>
                                                		  <li class="sub_back" style="width : 31%;">
                                                		  	<form:input path="stOrdDt" style="text-align:center;" /> ~ <form:input path="endOrdDt" style="text-align:center;"/>
                                                		  </li>
			                                              <li class="title_back" style="width : 8%;">주문번호</li>
                                                		  <li class="sub_back" style="width : 19%;">
                                                		  	<form:input path="scOrdNo" style="text-align:center; width: 90%;" /> 
                                                		  </li>
			                                              <%-- <li class="title_back" style="width : 8%;">상점명</li>
                                                		  <li class="sub_back" style="width : 19%;">
                                                		  	<form:input path="scStrNm" style="text-align:center; width: 90%;" /> 
                                                		  	<form:select path="scStrId" style="width:90%;">
			                                                		<form:option value="">선택</form:option>
			                                                	<c:forEach var="strList" items="${selectStrList}">
			                                                		<form:option value="${strList.strId}">${strList.strNm}</form:option>
			                                                	</c:forEach>
			                                                </form:select>	
                                                		  </li> --%>
			                                            </ul>
		                                                <ul>
		                                                  <li class="title_back" style="width : 8%;">주문금액</li>
                                                		  <li class="sub_back" style="width : 31%;">
                                                		  	<form:input path="stOrdAmt" style="text-align:center; text-align:right;" placeholder="0" onkeyup="checkNumber(this)"/> ~ 
                                                		  	<form:input path="endOrdAmt" style="text-align:center;text-align:right;" placeholder="0" onkeyup="checkNumber(this)" />
                                                		  </li>
			                                              <li class="title_back" style="width : 8%;">주문자명</li>
                                                		  <li class="sub_back" style="width : 19%;">
                                                		  	<form:input path="scUsrNm" style="text-align:center; width: 90%;" />
                                                		  </li>
			                                              <li class="title_back" style="width : 8%;">주문자ID</li>
                                                		  <li class="sub_back" style="width : 19%;">
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
					                                                    <li style="width:9.39999%;">번호</li>
					                                                    <li style="width:15%;">주문번호</li>
					                                                    <li style="width:15%;">상점명</li>
					                                                    <li style="width:15%;">주문자명</li>
					                                                    <li style="width:15%;">주문자ID</li>
					                                                    <li style="width:15%;">주문금액</li>
					                                                    <li style="width:15%;">주문일자</li>
					                                                </ul>
					                                            </div>
					                                            <c:forEach var ="resultMap" items="${resultList}">
					                                            <div class="flex flex_2" >
					                                                <ul name="resultList"  usrId = "${resultMap.usrId }" ordNo="${resultMap.ordNo }" strId="${resultMap.strId }" >
					                                                    <li style="width:9.39999%;"><c:out value="${resultMap.rn }" /></li>
					                                                    <li style="width:15%;"><c:out value="${resultMap.ordNo }" /></li>
					                                                    <li style="width:15%;"><c:out value="${resultMap.strNm }" /></li>
					                                                    <li style="width:15%;"><c:out value="${resultMap.usrNm }" /></li>
					                                                    <li style="width:15%;"><c:out value="${resultMap.usrId }" /></li>
					                                                    <li style="width:15%;"><fmt:formatNumber value="${resultMap.ordAmt }" pattern="#,###.##"/>원</li>
					                                                    <li style="width:15%;"><c:out value="${resultMap.ordDt }" /></li>
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