<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmCmnUsr002M11L.jsp
  * @Description : 조합원가입승인 리스트 화면
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
					
					$( "#searchJoinDtFrom" ).datepicker().mask("9999-99-99");
					$( "#searchJoinDtTo" ).datepicker().mask("9999-99-99");
	
					// 검색
					$("#btnRetrieve").click(function() {	
						fnRetrieve();
					});
					
					// 등록
					$("#btnAdd").click(function() {	
						fnAdd();
					});
					
					
					fnView( $("[name=resultList]") );
	
				});
				
				
				// 조회
				function fnRetrieve(){
					
					 var startDate = new Date($("#searchJoinDtFrom").datepicker("getDate"));
					 var endDate = new Date($("#searchJoinDtTo").datepicker("getDate"));
					   if(endDate - startDate <0){
							alert('날짜를 확인해주십시오.');
								$("#searchJoinDtTo").focus();
								  return false;
						}
					
					$("#pageIndex").val("1");
					
					$("#mcmCmnUsr002VO").attr("action", "<c:url value='/McmCmnUsr002M11L.do'/>");
					$("#mcmCmnUsr002VO").submit();
				}
				
				
				// 상세보기
				function fnView(obj){
					obj.css("cursor", "pointer").click( function() {
	
						$("#usrId").val($(this).attr("usrId"));
						
						$("#mcmCmnUsr002VO").attr("action", "<c:url value='/McmCmnUsr002M12R.do'/>");
						$("#mcmCmnUsr002VO").submit();  
						
		             	   
					});
				}
				
				
				
				
				
				// 페이지 이동
				function fnLinkPage(pageNo){
					$("#pageIndex").val(pageNo);
					
					$("#mcmCmnUsr002VO").attr("action", "<c:url value='/McmCmnUsr002M11L.do'/>");
					$("#mcmCmnUsr002VO").submit();
					
				}
				
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmCmnUsr002VO" name="mcmCmnUsr002VO" method="post">
	<form:hidden path="usrId"/>
	
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
			                    <div class="aside_menu_back">조합원관리 > <b>조합원가입승인</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>조합원가입승인 <small>| 당협에 조합원으로 가입을 신청한 사용자를 승인합니다.</small></h3>
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
			                                                <li class="title_back" style="width:8%;">아이디</li>
			                                                <li class="sub_back" style="width:15%;"><form:input path="searchUsrId" style="width:90%;" /></li>
			                                                
			                                                <li class="title_back" style="width:8%;">이름</li>
			                                                <li class="sub_back" style="width:15%;"><form:input path="searchUsrNm" style="width:90%;" /></li>
			                                                
			                                                <li class="title_back" style="width:8%;">전화번호</li>
			                                                <li class="sub_back" style="width:15%;"><form:input path="searchTelNo" style="width:90%;" /></li>
			                                                
			                                                <li class="title_back" style="width:8%;">이메일</li>
			                                                <li class="sub_back" style="width:15%;"><form:input path="searchEmailAddr" style="width:90%;" /></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:8%;">가입일자</li>
			                                                <li class="sub_back" style="width:auto;">
			                                                	<form:input path="searchJoinDtFrom" style="text-align:center;" /> ~ <form:input path="searchJoinDtTo" style="text-align:center;"/>
			                                                </li>
			                                            </ul>
													</div>
				                                    <%-- 검색조건 종료 --%>
			                                            
			                                            
                                        
													<div class="suchen">
				                                                <a href="#;" id="btnRetrieve" class="suchen_a">검색</a>
				                                    </div>
			                                        
			                                        
			                                        <div class="line_class"></div>
			                                        
			                                        
			                                        <%-- 검색 결과 시작 --%>
			                                        <div class="suchen_result_cap">
			                                        
			                                        
				                                        <div class="suchen_result">전체 <b>${paginationInfo.totalRecordCount}</b>명</div>
					                                        <div>
					                                            <div class="flex first_flex">
					                                                <ul>
					                                                    <li style="width: 8%;">순번</li>
					                                                    <li style="width:15%;">아이디</li>
					                                                    <li style="width:15%;">이름</li>
					                                                    <li style="width:22%;">전화번호</li>
					                                                    <li style="width:25.39999%;">이메일</li>
					                                                    <li style="width:14%;">가입일자</li>
					                                                </ul>
					                                            </div>
					                                            
					                                            
					                                            <c:forEach items="${ resultList }" var="resultInfo">
					                                            	<div class="flex flex_2" >
						                                                <ul name="resultList" usrId="${ resultInfo.usrId }">
						                                                    <li style="width: 8%;">${ resultInfo.rn }</li>
						                                                    <li style="width:15%;">${ resultInfo.usrId }</li>
						                                                    <li style="width:15%;">${ resultInfo.usrNm }</li>
						                                                    <li style="width:22%;">${ resultInfo.telNo }</li>
						                                                    <li style="width:25.39999%;">${ resultInfo.emailAddr }</li>
						                                                    <li style="width:14%;">${ resultInfo.joinDt }</li>
						                                                </ul>
						                                            </div>	
					                                            </c:forEach>
					                                            
					                                            <c:if test="${ empty resultList }" >
					                                            	<div class="flex flex_2" >
						                                                <ul>
						                                                    <li style="width: 99.79999%;">조회 결과가 없습니다.</li>
						                                                </ul>
						                                        	</div>
					                                            </c:if>
					                                            
					                                            
					                                            
					                                            <%-- 하단 버튼 시작 --%>
					                                            <!-- <div class="flex last_flex">
					                                                   <a href="#">선택 가입승인</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">엑셀 다운로드</a>
					                                            </div> -->
					                                            <%-- 하단 버튼 끝 --%>
					                                            
					                                            
					                                            <%-- 페이지 네비게이션 시작 --%>
					                                            <div class="next">
					                                            	<ul>
						                                                <ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fnLinkPage" />
						        										<form:hidden path="pageIndex" />
					        										</ul>
					                                            </div>
					                                            <%-- 페이지 네비게이션 끝 --%>
				                                            
				                                        </div>
				                                        
			                                        </div>
			                                        <!-- suchen_result_cap -->
			                                        <%-- 검색 결과 종료 --%>
			                                        
			                                        
                                       				 
                                       				 
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