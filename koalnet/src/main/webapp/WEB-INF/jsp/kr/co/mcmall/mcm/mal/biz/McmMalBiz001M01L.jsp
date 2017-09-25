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
					
					$("#mcmMalBiz001VO").attr("action", "<c:url value='/McmMalBiz001M01L.do'/>");
					$("#mcmMalBiz001VO").submit();
				}
				
				function infoView(obj){
					obj.css("cursor","pointer").click(function(){
						$("#usrId").val($(this).attr("usrId"));
						$("#lcsId").val($(this).attr("lcsId"));
						$("#upLcsId").val($(this).attr("upLcsId"));
			    		$("#mcmMalBiz001VO").attr("action","<c:url value='/McmMalBiz001M02R.do'/>");
			    		$("#mcmMalBiz001VO").submit();
			    	})
				}
				
				function fnCreate(){
						
			    		$("#mcmMalBiz001VO").attr("action","<c:url value='/McmMalBiz001M03C.do'/>");
			    		$("#mcmMalBiz001VO").submit();					
				}
				
				function fncLinkPage(pageNo){
					$("#pageIndex").val(pageNo);
					$("#mcmMalBiz001VO").attr("action", "<c:url value='/McmMalBiz001M01L.do'/>");
					$("#mcmMalBiz001VO").submit();
				};
				
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmMalBiz001VO" name="mcmMalBiz001VO" method="post">
	<form:hidden path="lcsId"/>
	<form:hidden path="usrId"/>
	<form:hidden path="upLcsId"/>

	

	
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
			                    <div class="aside_menu_back">홍보관리 > <b>사업자 관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>사업자 관리 <small>| 사업자를 등록/조회 하실 수 있습니다.</small></h3>
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
 														   		<li class="title_back" style="width:8%;">사업자 아이디</li>
			                                                	<li class="sub_back" style="width:15%;"><form:input path="searchLcsId"/></li>
	 														   <li class="title_back" style="width:8%;">상점</li>
	 														   <li class="sub_back" style="width:15%;">
				                                      			<form:select path="searchStrId" style="width:90%;">
				                                                		<form:option value="">선택</form:option>
				                                                	<c:forEach var="strList" items="${selectStrList}">
				                                                		<form:option value="${strList.strId}">${strList.strNm}</form:option>
				                                                	</c:forEach>
				                                                </form:select>			
				                                                </li>
				                                                <li class="title_back" style="width:8%;">아이디</li>
				                                                <li class="sub_back" style="width:15%;"><form:input path="searchUsrId"/></li>
				                                                
				                                                <li class="title_back" style="width:8%;">이름</li>
				                                                <li class="sub_back" style="width:15%;"><form:input path="searchUsrNm"/></li>
			                                                
			                                                
			                                                
			                                      			
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
					                                                    <li style="width:5.49999%;">순번</li>
					                                                    <li style="width:15%;">사업자 아이디</li>
					                                                    <li style="width:20%;">상점</li>
					                                                    <li style="width:20%;">아이디</li>
					                                                    <li style="width:19%;">이름</li>
					                                                    <li style="width:20%;">연락처</li>
					                                                    
					                                                </ul>
					                                            </div>
					                                            <c:forEach var="selectResultList" items="${selectResultList}">
					                                            <div class="flex flex_2">
					                                                <ul name="resultList"  lcsId="${selectResultList.lcsId}" usrId="${selectResultList.usrId }" upLcsId="${selectResultList.upLcsId}">
					                                                    <li style="width:5.49999%;"><c:out value="${selectResultList.rn}"/></li>
					                                                    <li style="width:15%;"><c:out value="${selectResultList.lcsId}"/></li>
					                                                    <li style="width:20%;"><c:out value="${selectResultList.strNm}"/></li>
					                                                    <li style="width:20%;"><c:out value="${selectResultList.usrId}"/></li>
					                                                    <li style="width:19%;"><c:out value="${selectResultList.usrNm}"/></li>
					                                                    <li style="width:20%;"><c:out value="${selectResultList.telNo}"/></li>
					                                                    
					                                                </ul>
					                                            </div>
					                                            </c:forEach>
					                                            
					                                             <c:if test="${empty selectResultList}">
					                                            <div class="flex flex_2">
						                                            <ul>
						                                            	<li style="width:99.89999%;">조회결과가 없습니다.</li>
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
			                                        
			                                        
													<div class="save_button" style="display:none;">
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