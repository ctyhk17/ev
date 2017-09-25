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
					$("#btnAdd").click(function(){
						fnCreate();
					})
					
					$("#btnSearch").click(function(){
						fnSearch();
					})
					infoView($("[name=resultList]"));
				});
				
				function fnSearch(){
					$("#pageIndex").val("1");
					
					$("#mcmMalStr001VO").attr("action", "<c:url value='/McmMalStr001M01L.do'/>");
					$("#mcmMalStr001VO").submit();
				}
				
				function infoView(obj){
					obj.css("cursor","pointer").click(function(){
  			    		
						$("#strId2").val($(this).attr("strId2"));
			    		$("#mcmMalStr001VO").attr("action","<c:url value='/McmMalStr001M02R.do'/>");
			    		$("#mcmMalStr001VO").submit();
			    	})
				}
				
				function fnCreate(){
						
			    		$("#mcmMalStr001VO").attr("action","<c:url value='/McmMalBiz001M03C.do'/>");
			    		$("#mcmMalStr001VO").submit();					
				}
				
				function fncLinkPage(pageNo){
					$("#pageIndex").val(pageNo);
					$("#mcmMalStr001VO").attr("action", "<c:url value='/McmMalStr001M01L.do'/>");
					$("#mcmMalStr001VO").submit();
				};
				
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmMalStr001VO" name="mcmMalStr001VO" method="post">
	<form:input path="strId2"/>

	
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
			                    <div class="aside_menu_back">시스템설정 > <b>상점관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>상점관리<small>| 상점을 등록/조회 하실 수 있습니다.</small></h3>
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
 														   <li class="title_back" style="width:15%;">상점</li>
			                                      			<form:select path="searchStrId" style="width:17%;">
			                                                		<form:option value="">선택</form:option>
			                                                	<c:forEach var="strList" items="${selectStrList}">
			                                                		<form:option value="${strList.strId}">${strList.strNm}</form:option>
			                                                	</c:forEach>
			                                                </form:select>			
			                                                
			                                               <%--  <li class="title_back" style="width:15%;">아이디</li>
			                                                <li class="sub_back" style="width:16%;"><form:input path="searchUsrId"/></li>
			                                                
			                                                <li class="title_back" style="width:15%;">이름</li>
			                                                <li class="sub_back" style="width:16%;"><form:input path="searchUsrNm"/></li>
			                                                 --%>
			                                      			
			                                            </ul>
			                                            
													</div> 
				                                    <%-- 검색조건 종료 --%>
			                                            
			                                            
			                                            
			                                       
			                                       
			                                       
			                                       
                                        
                                        
                                        
													<div class="suchen">
				                                                <a href="#" class="suchen_a" id="btnSearch">검색</a>
				                                    </div>
			                                        
			                                        
			                                        <div class="line_class"></div>
			                                        
			                                        
			                                        <%-- 검색 결과 시작 --%>
			                                        <div class="suchen_result_cap">
			                                        
			                                          
				                                        <div class="suchen_result">전체 <b><c:out value="${totCnt}"/></b>명</div>
					                                        <div>
					                                            <div class="flex first_flex">
					                                                <ul>
					                                                    <li style="width:10%;">순번</li>
					                                                    <li style="width:15%;">상점 코드</li>
					                                                    <li style="width:20%;">상점명</li>
					                                                    <li style="width:25%;">상점설명</li>
					                                                    <li style="width:29%;">상점 URL</li>
					                                                </ul>
					                                            </div>
					                                            <c:forEach var="resultList" items="${resultList}">
					                                            <div class="flex flex_2">
					                                                <ul name="resultList"  strId2="${resultList.strId2}">
					                                                    <li style="width:10%;"><c:out value="${resultList.rn}"/></li>
					                                                    <li style="width:15%;"><c:out value="${resultList.strId2}"/></li>
					                                                    <li style="width:20%;"><c:out value="${resultList.strNm}"/></li>
					                                                    <li style="width:25%;"><c:out value="${resultList.strCnts}"/></li>
					                                                    <li style="width:29%;">http://www.koalnetcity.net/<c:out value="${resultList.strId2}"/></li>
					                                                    
					                                                </ul>
					                                            </div>
					                                            </c:forEach>
					                                            
					                                             <c:if test="${empty resultList}">
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
					                                           <div class="next">
					                                            	<ul>
														        		<ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fncLinkPage" />
														        		<form:hidden path="pageIndex" />
														        	</ul>
													           </div> 

					                                            <%-- 페이지 네비게이션 끝 --%>
				                                            
				                                        </div>
				                                        
			                                        </div>
			                                        <!-- suchen_result_cap -->
			                                        <%-- 검색 결과 종료 --%>
			                                        
			                                        
													<div class="save_button">
														<a href="#" id="btnAdd">사업자 등록</a> 
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