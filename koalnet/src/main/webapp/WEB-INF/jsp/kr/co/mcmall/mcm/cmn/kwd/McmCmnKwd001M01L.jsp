<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmCmnAth001M01L.jsp
  * @Description : 조합원 리스트 화면
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
	    	$(document).ready(function(){
	    		$( "#endDtSearch" ).datepicker().mask("9999-99-99");
				$( "#stDtSearch" ).datepicker().mask("9999-99-99");
	    		
	    		$('#btnSeachList').click(function(){
					fnSearchList();
				});
	    		
	    		fnInfoView($("[name=resultList]"));
	    		
	    	});
	    	
	    	function fnInfoView(obj){
				obj.css("cursor","pointer").click(function(){
					$('#gdsId').val($(this).attr("gdsId"));
					$('#seqNo').val($(this).attr("seqNo"));
					$("#McmCmnKwd001VO").attr("action", "<c:url value='/McmCmnKwd001M02R.do'/>");
					$("#McmCmnKwd001VO").submit();	
				});
			}
	    	
	    	function fnSearchList(){
	    		
	    		 var startDate = new Date($("#stDtSearch").datepicker("getDate"));
				 var endDate = new Date($("#endDtSearch").datepicker("getDate"));
				   if(endDate - startDate <0){
						alert('날짜를 확인해주십시오.');
							$("#endDtSearch").focus();
							  return false;
					}
				   
				$("#pageIndex").val("1");
				
				$("#McmCmnKwd001VO").attr("action", "<c:url value='/McmCmnKwd001M01L.do'/>");
				$("#McmCmnKwd001VO").submit();
			}
			
			function fncLinkPage(pageNo){
				$("#pageIndex").val(pageNo);
				
				$("#McmCmnKwd001VO").attr("action", "<c:url value='/McmCmnKwd001M01L.do'/>");
				$("#McmCmnKwd001VO").submit();
			};
	    
		</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="McmCmnKwd001VO" name="McmCmnKwd001VO" method="post">
	<form:hidden path="gdsId" />
	<form:hidden path="seqNo" />
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
			                    <div class="aside_menu_back">시스템설정 > <b>키워드관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>키워드관리 <small>| 키워드관리 하실 수 있습니다.</small></h3>
			                        </div>
			                        
			                        <div class="content_1_1">
			                             <div class="tab tab_1 tab_1_active">
			                                    <div class="tab_line tab_1_1"> 
			                                        <%-- 검색조건 시작 --%>
													<div class="resize_box">
				                                            <ul class="re_first">
			                                                <li class="title_back" style="width:10%;text-align: center;">상품ID</li>
			                                                <li class="sub_back" style="width:15%;">
			                                                	<form:input path="gdsIdSearch" />
			                                                </li>
			                                                
			                                                <li class="title_back" style="width:10%;text-align: center;">키워드명</li>
			                                                <li class="sub_back" style="width:15%;">
			                                                	<form:input path="kwdNmSearch" />
			                                                </li>
                                                           <li class="title_back" style="width:10%;text-align: center;">등록일/수정일</li>
			                                                <li class="sub_back">
			                                               		 <form:input path="stDtSearch" style="text-align:center;" /> ~ <form:input path="endDtSearch" style="text-align:center;"/>
			                                                </li>
			                                            </ul>
													</div>
				                                    <%-- 검색조건 종료 --%>
													<div class="suchen">
				                                                <a href="#" class="suchen_a" id="btnSeachList">검색</a>
				                                    </div>
			                                        <div class="line_class"></div>
			                                        
			                                        
			                                        
			                                        
			                                        <%-- ========================================== --%>
			                                       <%-- 본문 시작 --%>
			                                       <%-- ========================================== --%>
			                                        <div class="suchen_result_cap">
			                                        
			                                        
				                                        <div class="suchen_result"> 전체 <b><c:out value="${totCnt}" /></b></b>건</div>
					                                        <div>
					                                            <div class="flex first_flex">
					                                                <ul>
					                                                	 <li style="width:8%;">번호</li>
					                                                    <li style="width:18%;">상품ID</li>
					                                                    <li style="width:40%;">키워드명</li>
					                                                    <li style="width:18.099999%;">키워드 처리상태</li>
					                                                    <li style="width:15%;">등록일/수정일</li>
					                                                </ul>
					                                            </div>
					                                            <c:forEach var="resultList" items="${resultList}">
					                                            	<div class="flex flex_2">
																		<ul>
						                                                    <li style="width:8%; padding:15px 0px;">
						                                                    <c:out value="${resultList.rn}" />
						                                                    </li>
						                                                    <li style="width:18%; padding:15px 0px;">
						                                                    	<c:out value="${resultList.gdsId}" />
						                                                    </li>
						                                                    <li style="width:40%; padding:15px 0px;" name="resultList" gdsId="${resultList.gdsId}" seqNo="${resultList.seqNo}">
						                                                    	<c:out value="${resultList.kwdNm}" />
						                                                    </li>
						                                                    <c:choose>
						                                                    	<c:when test="${resultList.kwdSttCd eq 'GDS002001'}">
						                                                    			<li style="width:18.099999%; padding:15px 0px;">요청</li>
						                                                    	</c:when>
						                                                    	<c:otherwise>
						                                                    			<li style="width:18.099999%; padding:15px 0px;">완료</li>
						                                                    	</c:otherwise>
						                                                    </c:choose>
						                                                    <li style="width:15%; padding:15px 0px;">
						                                                    	<c:out value="${resultList.lstUdtDt}" />
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
													          </div>
				                                        </div>
			                                        
											</div><!-- End of tab_1_1 -->
										</div>
									</div>
								</div>
						</div><!-- End of content -->
	              </div><!-- End of aside -->
              </div><!-- End of aside_back -->
          </div><!-- End of article_cap -->
		</article>




		<footer>
		    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminFooterInclude.jsp" %>
		</footer><!-- End of footer -->
	
</form:form>
	
	</body><!-- End of body -->

</html>