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
					
					// 등록
					$("#btnAdd").click(function() {	
						fnAdd();
					});
				
				
					fnView( $("[name=resultList]") );
					fnViewAth( $("[name=resultAthList]") );
	
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
					
					$("#mcmCmnAth002VO").attr("action", "<c:url value='/McmCmnAth002M01L.do'/>");
					$("#mcmCmnAth002VO").submit();
				}
				
				// 등록
				function fnAdd(){
					
					var title  = "addPopup";
					var status = "toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=640, height=650, top=0,left=20";
					window.open("","addPopup",status);
					
					$("#mcmCmnAth002VO").attr("target","addPopup");
					$("#mcmCmnAth002VO").attr("action","<c:url value='/McmCmnAth002P03R.do'/>");
					$("#mcmCmnAth002VO").attr("method","post");
		    		$("#mcmCmnAth002VO").submit();
		    		
				}
				
				
				
				// 상세보기
				function fnView(obj){
					obj.css("cursor", "pointer").click( function() {
						
						$("#mcmCmnAth002VO").attr("target","");
						
						$("#usrId").val($(this).attr("usrId"));
						$("#strId").val($(this).attr("strId"));
						
						$("#pageIndex").val("1");
						$("#mcmCmnAth002VO").attr("action", "<c:url value='/McmCmnAth002M02R.do'/>");
						$("#mcmCmnAth002VO").submit();
						
		             	   
					});
				}
				
				function fnViewAth(obj){
					obj.css("cursor", "pointer").click( function() {
						
						$("#mcmCmnAth002VO").attr("target","");
						
						$("#strId").val($(this).attr("strId"));
						$("#athCd").val($(this).attr("athCd"));
						$("#athCnts").val($(this).attr("athCnts"));
						
						
						$("#pageIndex").val("1");
						$("#mcmCmnAth002VO").attr("action", "<c:url value='/McmCmnAth002M01L.do'/>");
						$("#mcmCmnAth002VO").submit(); 
						
					});
				}
				
				
				
				
				// 페이지 이동
				function fnLinkPage(pageNo){
					$("#pageIndex").val(pageNo);
					
					$("#mcmCmnAth002VO").attr("action", "<c:url value='/McmCmnAth002M01L.do'/>");
					$("#mcmCmnAth002VO").submit();
					
				}
			
				
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmCmnAth002VO" name="mcmCmnAth002VO" method="post">
	<form:hidden path="usrId"/>
	<form:hidden path="strId"/>
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
			                    <div class="aside_menu_back">시스템설정 > <b>권한별 사용자관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>권한별 사용자관리 <small>| 권한별 사용자를 설정 하실 수 있습니다.</small></h3>
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
														<h3>권한 리스트</h3>
															<div class="flex first_flex"  style="margin-bottom:2%;width:100%; min-width:0px !important;float:left;display:inline-block;">
					                                                <ul>
					                                                    <li style="width:50%;">권한코드</li>
					                                                    <li style="width:49%;">권한명</li>
		
														
					                                                </ul>
					                                                <c:forEach items="${ resultList2 }" var="resultAthCd" >
						                                                <div class="flex flex_2">
						                                                 <ul name="resultAthList" style="width:100%;" athCd="${resultAthCd.athCd}" strId="${resultAthCd.strId}" athCnts="${resultAthCd.athCnts}">
							                                                    <li style="width:50%;"><c:out value="${ resultAthCd.athCd }"/></li>
							                                                    <li style="width:49%;"><c:out value="${ resultAthCd.athCnts }"/></li>
							                                                    <li style="width:49%; display:none;"><c:out value="${ resultAthCd.strId }"/></li>
							                                                </ul>
							                                             </div>
					                                                </c:forEach>
						                                      </div>	
					                                                
					                                          
					                                            
					                                            
					                                            <%-- <c:forEach items="${ resultList2 }" var="resultAthCd">
					                                            	<div class="flex flex_2" >
						                                                <ul name="resultAthList" style="width:20%;">
						                                                    <li style="width:50%;">${ resultAthCd.athCd }</li>
						                                                    <li style="width:49%;">${ resultAthCd.athCnts }</li>

						                                                </ul>
						                                            </div>	
					                                            </c:forEach> --%>
					                                           
					                                            <br/><br/>
													
				                                            <ul class="re_first">
													<h3 style="font-size:16px;">권한별 회원 리스트</h3>
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
			                                        
			                                        
			                                        <div class="line_class" style="margin-top:15px;"></div>
			                                        
			                                        
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
						                                                <ul name="resultList" usrId="${ resultInfo.usrId }"  strId="${resultInfo.strId}">
						                                                    <li style="width: 8%;"><c:out value="${ resultInfo.rn }"/></li>
						                                                    <li style="width:12%;"><c:out value="${ resultInfo.usrId }"/></li>
						                                                    <li style="width:10%;" ><c:out value="${ resultInfo.usrNm }"/></li>
						                                                    <li style="width:15%;" ><c:out value="${ resultInfo.telNo }"/></li>
						                                                    <li style="width:20%;" ><c:out value="${ resultInfo.emailAddr }"/></li>
						                                                    <li style="width:14%;" ><c:out value="${ resultInfo.joinDt }"/></li>
						                                                    <li style="width:10%;" ><c:out value="${ resultInfo.useYn }"/></li>
						                                                    <li style="width:10%;" ><c:out value="${ resultInfo.feePayYn }"/></li>	
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
			                                        
			                                        
													<div class="save_button">
													
														<a href="#;" id="btnAdd">등록</a>		
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