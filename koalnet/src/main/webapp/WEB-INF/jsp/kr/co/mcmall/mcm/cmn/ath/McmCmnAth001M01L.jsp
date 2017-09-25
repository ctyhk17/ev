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
			
				$(document).ready(function () {
					
					$( "#searchJoinDtFrom" ).datepicker().mask("9999-99-99");
					$( "#searchJoinDtTo" ).datepicker().mask("9999-99-99");
	
					// 검색
					$("#btnRetrieve").click(function() {	
						fnRetrieve();
					});
					$("#btnAthCntsModi").click(function(){
						fnAthCntsModi();
					});
					$("#btnAthCntsAdd").click(function(){
						fnAthCntsAdd();
					})
					// 등록
					$("#btnAdd").click(function() {	
						fnAdd();
					});
					fnViewAth( $("[name=resultAthList]") );
					
	
				});
				
				function fnAthCntsAdd(){
					var athCd      = $("#athCd").val();
					var athCntsAdd = $("#athCntsAdd").val();
					
					jQuery.ajaxSettings.traditional = true;
					$.post(
							"<c:url value='/McmCmnAth001M03CP.do'/>", 
							{ 
								  "athCd"              : athCd
								, "athCntsAdd"         : athCntsAdd
							}, 
							function(responseText)
							{
							}, 
							"json"
					)
					.done(function() {
						alert('추가되었습니다.');
						window.location.reload();
	 				})
					.fail(function() {
						alert( "권한 추가에 실패하였습니다." );
					})
					;
				}
				
				function fnViewAth(obj){
					obj.css("cursor", "pointer").click( function() {
						$("#athCd").val($(this).attr("athCd"));
						$("#athCnts").val($(this).attr("athCnts"));
					});
				}
				// 조회
				function fnRetrieve(){
					$("#pageIndex").val("1");
					
					$("#mcmCmnAth001VO").attr("action", "<c:url value='/McmCmnAth001M01L.do'/>");
					$("#mcmCmnAth001VO").submit();
				}
				
				// 등록
				function fnAdd(){
					
					$("#usrId").val("");
					
					$("#mcmCmnAth001VO").attr("action", "<c:url value='/McmCmnAth001M03C.do'/>");
					$("#mcmCmnAth001VO").submit();
				}
				
				
				
				
				
				
				
				// 페이지 이동
				function fnLinkPage(pageNo){
					$("#pageIndex").val(pageNo);
					
					$("#mcmCmnAth001VO").attr("action", "<c:url value='/McmCmnAth001M01L.do'/>");
					$("#mcmCmnAth001VO").submit();
					
				}
				
				function fnAthCntsModi(){
					var athCd       = $("#athCd").val();
					var athCntsModify = $("#athCntsModify").val();
					jQuery.ajaxSettings.traditional = true;
					$.post(
							"<c:url value='/McmCmnAth001M05UP.do'/>", 
							{ 
								  "athCd"              : athCd
								, "athCntsModify"        : athCntsModify
							}, 
							function(responseText)
							{
							}, 
							"json"
					)
					.done(function() {
						alert('수정되었습니다.');
						window.location.reload();
	 				})
					.fail(function() {
						alert( "권한 수정에 실패하였습니다." );
					})
					;
					
				}
				
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmCmnAth001VO" name="mcmCmnAth001VO" method="post">
	<form:hidden path="athCd"/>
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
			                    <div class="aside_menu_back">시스템설정 > <b>권한관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>권한관리 <small>| 권한을 추가, 수정 또는 삭제 하실 수 있습니다.</small></h3>
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
				                                            <%-- <ul class="re_first">
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
			                                                
			                                                
			                                            </ul> --%>
													</div>
				                                    <%-- 검색조건 종료 --%>
			                                            
			                                            
                                        
												
			                                        
			                                        <div class="line_class"></div>
			                                        
			                                        
			                                        <%-- 검색 결과 시작 --%>
			                                        <div class="suchen_result_cap">
			                                        
			                                        
				                                        <%-- <div class="suchen_result">전체 <b>${paginationInfo.totalRecordCount}</b>명</div> --%>
					                                        <div class="resize_box">
					                                           <h3>권한 리스트</h3>
					                                            <div class="flex first_flex"  style="width:100%; min-width:0px !important;display:inline-block;">
					                                                <ul>
					                                                    <li style="width:50%;">권한코드</li>
					                                                    <li style="width:49%;">권한명</li>
		
					                                                </ul>
					                                                 <c:forEach items="${ resultList }" var="resultInfo">
					                                            	<div class="flex flex_2" >
						                                                <ul name="resultAthList" athCd="${ resultInfo.athCd}" athCnts="${ resultInfo.athCnts }">
						                                                    <li style="width:50%;">${ resultInfo.athCd }</li>
						                                                    <li style="width:49%;">${ resultInfo.athCnts }</li>

						                                                </ul>
						                                            </div>	
					                                            </c:forEach>
						                                      </div>
						                                   </div>
					                                            
					                                            <c:if test="${ empty resultList }" >
					                                            	<div class="flex flex_2" >
						                                                <ul name="resultList">
						                                                    <li style="width: 99%;">조회 결과가 없습니다.</li>
						                                                </ul>
						                                        	</div>
					                                            </c:if>
					                                            
					                                       <br/>    
					                                    <div class="resize_box">
				                                           <h3>권한 추가</h3>
				                                            <ul class="re_first">
				                                                <li class="title_back" style="width:16%;">권한코드</li>
				                                                <li class="sub_back" style="width:30%;">* 등록 시 자동 부여 됩니다.</li>
				                                                <li class="title_back" style="width:16%;">권한명</li>
				                                                <li class="sub_back" style="width:30%;"><form:input path="athCntsAdd"/></li>
				                                            </ul>
				                                            
				                                        </div>
				                                       <div class="save_button"><a href="#;" id="btnAthCntsAdd">등록</a></div>
				                                        
					                                    <!-- <div class="resize_box">
				                                           <h3>권한 삭제</h3>
				                                            <ul class="re_first">
				                                                <li class="title_back" style="width:16%;">권한코드</li>
				                                                <li class="sub_back" style="width:30%;"></li>
				                                                <li class="title_back" style="width:16%;">권한명</li>
				                                                <li class="sub_back" style="width:30%;"><input type="text"/></li>
				                                            </ul>
				                                            
				                                            
				                                        </div>
					                                    <div class="save_button"><a href="#;" id="btnAdd">삭제</a></div>    -->      
					                                          
					                                    <div class="resize_box">
				                                           <h3>권한 수정</h3>
				                                            <ul class="re_first">
				                                                <li class="title_back" style="width:16%;">변경 전 권한명</li>
				                                                <li class="sub_back" style="width:30%;"><form:input path="athCnts" placeholder="상단 리스트에서 클릭하세요." style="width:50%;"/></li>
				                                                <li class="title_back" style="width:16%;">변경 후 권한명</li>
				                                                <li class="sub_back" style="width:30%;"><form:input path="athCntsModify"/></li>
				                                            </ul>
				                                        </div>      
														<div class="save_button"><a href="#;" id="btnAthCntsModi">수정</a></div>					                                          
					                                          
					                                            
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
					                                           <%--  <div class="next">
					                                            	<ul>
						                                                <ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fnLinkPage" />
						        										<form:hidden path="pageIndex" />
					        										</ul>
					                                            </div> --%>
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