<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmCmnUsr003M01L.jsp
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
					
					//엑셀다운로드
					$("#btnExcel").click(function() {	
						fnExcel();
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
					
					$("#mcmCmnUsr003VO").attr("action", "<c:url value='/McmCmnUsr003M01L.do'/>");
					$("#mcmCmnUsr003VO").submit();
				}
				
				// 등록
				function fnAdd(){
					
					$("#usrId").val("");
					
					$("#mcmCmnUsr003VO").attr("action", "<c:url value='/McmCmnUsr003M03C.do'/>");
					$("#mcmCmnUsr003VO").submit();
				}
				
				
				// 상세보기
				function fnView(obj){
					obj.css("cursor", "pointer").click( function() {
	
						$("#usrId").val($(this).attr("usrId"));
						
						$("#mcmCmnUsr003VO").attr("action", "<c:url value='/McmCmnUsr003M02R.do'/>");
						$("#mcmCmnUsr003VO").submit();  
						
		             	   
					});
				}
				
				// 페이지 이동
				function fnLinkPage(pageNo){
					$("#pageIndex").val(pageNo);
					
					$("#mcmCmnUsr003VO").attr("action", "<c:url value='/McmCmnUsr003M01L.do'/>");
					$("#mcmCmnUsr003VO").submit();
					
				}
				
				//엑셀다운로드
				function fnExcel() {
					$("#mcmCmnUsr003VO").attr("action", "<c:url value='/McmCmnUsr003M06E.do'/>");
					$("#mcmCmnUsr003VO").submit();
				}
				
			</script>
			
			
	</head><!-- End of head -->

	<body>
 

<form:form commandName="mcmCmnUsr003VO" name="mcmCmnUsr003VO" method="post">
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
			                    <div class="aside_menu_back">조합원관리 > <b>회원관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>회원관리 <small>| 당협에 가입한 회원을 관리합니다.</small></h3>
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
			                                                <li class="sub_back" style="width:39.8%;">
			                                                	<form:input path="searchJoinDtFrom" style="text-align:center;" /> ~ <form:input path="searchJoinDtTo" style="text-align:center;"/>
			                                                </li>
			                                                
			                                                <li class="title_back" style="width:8%;">사용여부</li>
			                                                <li class="sub_back" style="width:15%;">
			                                                	<form:select path="searchUseYn" style="width:90%;">
			                                                		<form:option value="">전체</form:option>
			                                                		<form:option value="Y">예</form:option>
			                                                		<form:option value="N">아니오</form:option>
			                                                	</form:select>
			                                                </li>
			                                                
			                                                <li class="title_back" style="width:8%;">회비납부여부</li>
			                                                <li class="sub_back" style="width:15%;">
			                                                	<form:select path="searchFeePayYn" style="width:90%;">
			                                                		<form:option value="">전체</form:option>
			                                                		<form:option value="Y">예</form:option>
			                                                		<form:option value="N">아니오</form:option>
			                                                	</form:select>
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
					                                                    <li style="width:12%;">아이디</li>
					                                                    <li style="width:10%;">이름</li>
					                                                    <li style="width:15%;">전화번호</li>
					                                                    <li style="width:20%;">이메일</li>
					                                                    <li style="width:14%;">가입일자</li>
					                                                    <li style="width:10%;">사용여부</li>
					                                                    <li style="width:10%;">회비납부여부</li>					                                                    
					                                                </ul>
					                                            </div>
					                                            
					                                            
					                                            <c:forEach items="${ resultList }" var="resultInfo">
					                                            	<div class="flex flex_2" >
						                                                <ul name="resultList" usrId="${ resultInfo.usrId }">
						                                                    <li style="width: 8%;">${ resultInfo.rn }</li>
						                                                    <li style="width:12%;">${ resultInfo.usrId }</li>
						                                                    <li style="width:10%;">${ resultInfo.usrNm }</li>
						                                                    <li style="width:15%;">${ resultInfo.telNo }</li>
						                                                    <li style="width:20%;height: 16px;">${ resultInfo.emailAddr }</li>
						                                                    <li style="width:14%;">${ resultInfo.joinDt }</li>
						                                                    <li style="width:10%;">${ resultInfo.useYn }</li>
						                                                    <li style="width:10%;">${ resultInfo.feePayYn }</li>	
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
					                                            	 <a href="#;" id="btnExcel" style="display:inline-block;float:right;margin-right:23px;position: relative; color:black">엑셀 다운로드</a>
					                                            </div>
					                                            
					                                            
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
			                                        
			                                        
													<div class="save_button"><a href="#;" id="btnAdd">등록</a></div>
                                       				 
                                       				 
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