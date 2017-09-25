<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
	
	<head>
	
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    
	    
	     <script type="text/javascript">
			
			$(document).ready(function(){
				
				$("#chkAll").click(function(){
					if($("#chkAll").prop("checked")) {
						$("input[type=checkbox]").prop("checked",true);
						
					} else {
					$("input[type=checkbox]").prop("checked",false); } 
				});
				
				$("#btnBuyGds").click(function(){
					var cartIdArray = new Array();
					
					
					
					$("#mcmShpOrd003VO").attr("action", "<c:url value='/McmShpOrd001M02R.do'/>");
					$("#mcmShpOrd003VO").submit();	
					
					
					
				});
				$("#btnDel").click(function(){
					
					var checkCrtId  = new Array();
					
					$("[name=crtId]:checked").each(function(){
						
						checkCrtId.push($(this).val());
					});					
					
					jQuery.ajaxSettings.traditional = true;
					$.post(
							"<c:url value='/McmShpOrd003M05D.do'/>", 
							{ 
								"checkCrtId" : checkCrtId
								
								
								
							},function(responseText)
							{
								$("#cartPop").show();		
							}, 
							"json"
					)
					.done(function() {
						location.href="/McmShpOrd003M01L.do?upMenuId=M001&subMenuId=M001002";	
					})
					.fail(function() {
						alert( "처리 도중 에러가 발생하였습니다." );
					});
					
				});
				
						
				$('#btnSearch').click(function( ){
					
					$("#mcmShpOrd003VO").attr("action", "<c:url value='/McmShpOrd003M01L.do'/>");
					$("#mcmShpOrd003VO").submit();	
				});
				
				infoView($("[name=resultList]"));			
			});
			
			//상세조회
			function infoView(obj){
				obj.css("cursor","pointer").click(function(){
					
					
					$("#usrId").val($(this).attr("usrId"));
					$("#strId").val($(this).attr("strId"));
					$("#gdsId").val($(this).attr("gdsId"));
					
					$("#mcmShpOrd003VO").attr("action", "<c:url value='/McmShpOrd001M02R.do'/>");
					$("#mcmShpOrd003VO").submit();
				});
			};
			
			
			//페이징처리
			function fncLinkPage(pageNo){
				$("#pageIndex").val(pageNo);
				$("#mcmShpOrd003VO").attr("action", "<c:url value='/McmShpOrd003M01L.do'/>");
				$("#mcmShpOrd003VO").submit();
			};
					
				
				
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmShpOrd003VO" name="mcmShpOrd003VO" method="post">
	<form:hidden path="usrId" />
	<form:hidden path="strId" />
	<form:hidden path="gdsId" />
	<input type="hidden" name="ordDiv" id="ordDiv" value="cart"/>
	
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
								<div class="aside_menu_back">주문현황 > <b>장바구니</b></div>
								<%-- 페이지 네베게이션  끝--%>
				                    
								<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
				                    
				                    
								<div class="content_1">
				                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>장바구니 <small>| 장바구니를 조회 할 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                 
			                        
			                        
			                        <div class="content_1_1">
			                             <div class="tab tab_1 tab_1_active">
			                                    <div class="tab_line tab_1_1"> 
			                                        <div class="resize_box">
			                                       
			                                        </div>
			                                      <%-- 검색 결과 시작 --%>
			                                        <%-- <div class="resize_box">
			                                           <h3>1:1상담</h3>
		                                                <ul class="re_first">
			                                              <li class="title_back">주문일자</li>
                                                		  <li class="sub_back">
                                                		  	<form:input path="stOrdDt" style="text-align:center;" /> ~ <form:input path="endOrdDt" style="text-align:center;"/>
                                                		  </li>
			                                            </ul>
			                                        </div><!-- resize_box -->
			                                        <div class="suchen"><a href="#" class="suchen_a" id="btnSearch">검색</a></div> --%>
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
					                                                	<li style="width:5%;">
					                                                		<input type="checkbox"  id="chkAll" name="chkAll"	/>
					                                                	</li>
					                                                    <li style="width:5%;">번호</li>
					                                                    <li style="width:12%;">상점명</li>
					                                                    <li style="width:11%;">판매자ID</li>
					                                                    <li style="width:11%;">주문자ID</li>
					                                                    <li style="width:11%;">상품명</li>
					                                                    <li style="width:11%;">상품단가</li>
					                                                    <li style="width:11%;">수량</li>
					                                                    <li style="width:11%;">할인</li>
					                                                    <li style="width:11%;">합계</li>
					                                                </ul>
					                                            </div>
					                                            <c:forEach var ="resultMap" items="${resultList}">
					                                            <div class="flex flex_2" >
					                                                <ul>
					                                                	<li style="width:5%; padding:10px 0px;">
						                                                    	<form:checkbox path="crtId" value="${resultMap.crtId}"/>
						                                                </li> 
					                                                    <li style="width:5%;"><c:out value="${resultMap.rn }" /></li>
					                                                    <li style="width:12%;"><c:out value="${resultMap.strNm }" /></li>
					                                                    <li style="width:11%;"><c:out value="${resultMap.pusrId }" /></li>
					                                                    <li style="width:11%;"><c:out value="${resultMap.usrId }" /></li>
					                                                    <li style="width:11%;"><c:out value="${resultMap.gdsNm }" /></li>
					                                                    <li style="width:11%;"><c:out value="${resultMap.ordCnt }" /></li>
					                                                    <li style="width:11%;"><fmt:formatNumber value="${resultMap.ordAmt}" groupingUsed="true"/></li>
					                                                    <li style="width:11%;"><fmt:formatNumber value="${resultMap.salRt}" groupingUsed="true"/>%</li>
					                                                    <li style="width:11%;">
					                                                    	<fmt:formatNumber value="${resultMap.ordAmtSum}" groupingUsed="true"/>원
					                                                    </li>
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
													           <div class="save_button">
																	<a href="#;" id="btnBuyGds">결제</a>
																	<a href="#;" id="btnDel">삭제</a> 
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