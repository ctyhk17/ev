<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
	
	<head>
	
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    
	    
	    <script type="text/javascript">
			
			$(document).ready(function(){
						
				$('#btnSearch').click(function( ){
					
					$("#mcmCmnPot001VO").attr("action", "<c:url value='/McmCmnPot001M02R.do'/>");
					$("#mcmCmnPot001VO").submit();	
				});
				
				$( "#scStLstUdtDt" ).datepicker().mask("9999-99-99");
				$( "#scEdLstUdtDt" ).datepicker().mask("9999-99-99");
				
				
				
				$("#btnList").click(function(){
					$("#mcmCmnPot001VO").attr("action", "<c:url value='/McmCmnPot001M01L.do'/>");
					$("#mcmCmnPot001VO").submit();	
				});
				
				$("#btnPotDel").click(function(){
					fnPotDel();
				});
				
				$("#checkAll").click(function(){
			        if($("#checkAll").prop("checked")){
			            $("input[name=checkPotNo]").prop("checked",true);
			        }else{
			            $("input[name=checkPotNo]").prop("checked",false);
			        }
    			});
			});
			
			//페이징처리
			function fncLinkPage(pageNo){
				$("#pageIndex1").val(pageNo);
				$("#mcmCmnPot001VO").attr("action", "<c:url value='/McmCmnPot001M01L.do'/>");
				$("#mcmCmnPot001VO").submit();
			};
			
			function fnPotDel() {
				if($("input[type='checkbox']:checked").length == 0){
	    			alert("체크를 한 후 진행해주세요.");
	    			return;
	    		}else{
	    			var checkPotNo = new Array();
	    		}
				
				var usrId = $("#usrId").val();
				var strId = $("#strId").val();
				
	    		$('.checkPotNo:checked').each(function(){
	    			checkPotNo.push($(this).val());
	    		});
	    		
	    		jQuery.ajaxSettings.traditional = true;
	    		$.post(
	    				"<c:url value='/McmCmnPot001M05DP.do' />",
	    				{
	    					"checkPotNo":checkPotNo,
	    					"usrId" : usrId,
	    					"strId" : strId
	    				},
	    				function(result){
	    					alert("해당 포인트를 차감했습니다.");
	    				},"json"
	    			  ).done(function(){
	    				  $("#mcmCmnPot001VO").attr("action", "<c:url value='/McmCmnPot001M02R.do'/>");
	    					$("#mcmCmnPot001VO").submit();
	    			  }).fail(function(){
	    				  alert("실패하였습니다.");
	    				  document.location.reload();
	    			  })
	    		
			}

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
			                                              <li class="title_back" style="width : 9%;">포인트적용일자</li>
                                                		  <li class="sub_back" style="width : 31%;">
                                                		  	<form:input path="scStLstUdtDt" style="text-align:center;" /> ~ <form:input path="scEdLstUdtDt" style="text-align:center;"/>
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
			                                        
		                                        	 	<div class="resize_box">
			                                            	 <ul class="re_first">
			                                            	 <li class="title_back" style="width : 9%;">포인트합계</li>
	                                                		  <li class="sub_back" style="width : 10%;"><b>${pointSum }점</b></li>
				                                            </ul>
			                                            </div>
				                                        <div class="suchen_result"> 전체 <b><c:out value="${totCnt }" /></b></b>건</div>
					                                        <div>
					                                            <div class="flex first_flex">
					                                                <ul class="re_first">	
					                                                	<li style="width:6%;">
					                                                		<input type="checkbox" name="checkAll" id="checkAll" />
	 				                                                	</li>
					                                                    <li style="width:5%;">번호</li>
					                                                    <li style="width:13%;">상점명</li>
					                                                    <li style="width:13%;">이름</li>
					                                                    <li style="width:13%;">아이디</li>
					                                                    <li style="width:13%;">주문번호</li>
					                                                    <li style="width:13%;">포인트구분</li>
					                                                    <li style="width:10%;">적립/차감</li>
					                                                    <li style="width:13%;">포인트적용일자</li>
					                                                </ul>
					                                            </div>
					                                            <c:forEach var ="resultMap" items="${resultList}">
					                                            <div class="flex flex_2" >
					                                                <ul>
					                                                	<li style="width:6%;">
					                                                	<c:if test="${resultMap.potYn eq 'Y'}">
					                                                		<form:checkbox path="checkPotNo" value="${resultMap.potNo }" class="checkPotNo" />
					                                                	</c:if>
					                                                	
					                                                	
						                                                </li>
					                                                    <li style="width:5%;"><c:out value="${resultMap.rn }" /></li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.strNm }" /></li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.usrNm }" /></li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.usrId }" /></li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.ordNo }" /></li>
					                                                    <li style="width:13%;">
					                                                    	<c:choose>
					                                                    		<c:when test="${resultMap.potYn eq 'N' and resultMap.potNm eq '구입'}">
					                                                    			<span style="text-decoration: line-through;"><c:out value="${resultMap.potNm }" />(취소)</span>
					                                                    		</c:when>					                                                    		
					                                                    		<c:otherwise>
					                                                    			<span><c:out value="${resultMap.potNm }" /></span>
					                                                    		</c:otherwise>
					                                                    	</c:choose>
					                                                    </li>
					                                                    <li style="width:10%;">
					                                                    	<c:choose>
					                                                    		<c:when test="${resultMap.potYn eq 'N' and resultMap.potNm eq '구입'}">
					                                                    			<span style="text-decoration: line-through;color:red;">+<c:out value="${resultMap.potSv }" />P</span>
					                                                    		</c:when>
					                                                    		<c:when test="${resultMap.potYn eq 'N' and resultMap.potNm eq '사용'}">
					                                                    			<span style="text-decoration: line-through;color:red;">+<c:out value="${resultMap.potSv }" />P</span>
					                                                    		</c:when>			                                                    		
					                                                    		<c:otherwise>
					                                                    			<span style="color:blue;">+<c:out value="${resultMap.potSv }" />P</span>
					                                                    		</c:otherwise>
					                                                    	</c:choose>
					                                                    </li>
					                                                    <li style="width:13%;"><c:out value="${resultMap.lstUdtDt }" /></li>
					                                                </ul>
					                                            </div>   
						                                        </c:forEach>
						                                         <c:if test="${ empty resultList }" >
					                                            	<div class="flex flex_2" >
						                                                <ul name="resultList">
						                                                    <li style="width: 99%;">적립된 포인트가 없습니다.</li>
						                                                </ul>
						                                        	</div>
					                                            </c:if>
						                                        <div class="flex last_flex">
					                                            </div>
					                                            <%-- 페이지 네비게이션 시작 --%>
					                                 			<div class="next">
					                                            	<ul>
														        		<ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fncLinkPage" />
														        		<form:hidden path="pageIndex1" />
														        	</ul>
													           </div>
													           <div class="save_button">
													           		<a href="#" id = "btnPotDel">포인트 차감</a>
													           		<a href="#" id = "btnList">포인트목록조회</a>
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