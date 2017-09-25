<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmTplTpl003M01L.jsp
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

				$("#btnDownAdd").click(function(){
					window.open("","callback","toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=550, height=450, top=0,left=20");
					
			    	$("#mcmMalBiz003VO").attr("target", "callback");  
		    		$("#mcmMalBiz003VO").attr("action","<c:url value='/McmMalBiz003P02R.do'/>");
			    	$("#mcmMalBiz003VO").attr("method","post");
		    		$("#mcmMalBiz003VO").submit();
				})
			
				
				$("#btnGoList").click(function() {	
					fnGoList();
				});

					
			});
			
			// 목록으로
			function fnGoList(){
				$("#mcmMalBiz003VO").attr("action", "<c:url value='/McmMalBiz003M01L.do'/>");
				$("#mcmMalBiz003VO").submit();				
			}
		
			
			
			
			
			
			
			
			
		</script>	
    
	</head>

	<body>


<form:form commandName="mcmMalBiz003VO" name="mcmMalBiz003VO" method="post">
	
	<form:hidden path="upLcsId"/>
	

	
	
		<header>
    		<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeaderInclude.jsp" %>
		</header>   


		<article>
		   
			<div class="article_cap">
				<div class="aside_back">
					<div class="aside">
			                
			                
			                <%-- Left 메뉴 인클루드 --%>
			                <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminLeftMenuInclude.jsp" %>
			                
			                
						<div class="content">
			                
			                
							<%-- 페이지 네베게이션 시작 --%>
							<div class="aside_menu_back">홍보관리 > 팀장 관리 > <b>팀장 현황</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>팀장 현황 <small>| 팀장(상위사업자)을 조회 할 수 있습니다.</small></h3>
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
			                                       
			                                       
			                                        <div class="resize_box">
			                                            <ul class="re_first" name="resultList" >
			                                                <li class="title_back" style="width:16%;">팀장 구분코드</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${selectResultInfo.upLcsId}"/></li>
			                                                <li class="title_back" style="width:16%;">팀장 연락처</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${selectResultInfo.telNo}"/></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">팀장 아이디</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${selectResultInfo.usrId}"/></li>
			                                                <li class="title_back" style="width:16%;">상점 아이디</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${selectResultInfo.strId}"/></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사업자 이름</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${selectResultInfo.usrNm}"/></li>
			                                                <li class="title_back" style="width:16%;">하위사업자</li>
			                                                <li class="sub_back" style="width:30%;">
			                                                		<a href="#" id="btnDownAdd" style="background-color:#f29d06; color:white; font-size:12px; padding:8px; font-weight:bold;">등록하기</a>
			                                                </li>
			                                            </ul>
			                                            <br/>
			                                            <ul>
			                                                <li class="title_back" style="width:99.1%;border-top: 1px solid black;text-align:center;">하위사업자 목록</li>
			                                            </ul>
			                                            <ul style="padding:10px; background-color: #eeeeee;">
			                                            	<li class="sub_back" style="width:10%; text-align:center;">순번</li>
			                                                <li class="sub_back" style="width:20%; text-align:center;">구분코드</li>
			                                                <li class="sub_back" style="width:23%; text-align:center;">아이디</li>
			                                                <li class="sub_back" style="width:19%; text-align:center;">이름</li>
			                                                <li class="sub_back" style="width:25%; text-align:center;">연락처</li>
			                                            </ul>
			                                            
			                                            <c:forEach var="resultList" items="${selectResultList}">
			                                            <ul style="padding:10px;" name="selectDownLcs" lcsId="${resultList.lcsId}">
			                                            	<li class="sub_back" style="width:10%; text-align:center;"><c:out value="${resultList.rn}"/></li>
			                                                <li class="sub_back" style="width:20%; text-align:center;"><c:out value="${resultList.lcsId}"/></li>
			                                                <li class="sub_back" style="width:23%; text-align:center;"><c:out value="${resultList.usrId}"/></li>
			                                                <li class="sub_back" style="width:19%; text-align:center;"><c:out value="${resultList.usrNm}"/></li>
			                                                <li class="sub_back" style="width:25%; text-align:center;"><c:out value="${resultList.telNo}"/></li>
			                                                
			                                            </ul>
			                                            </c:forEach>
			                                         
			                                              <c:if test="${empty selectResultList}">
					                                            <div class="flex flex_2">
						                                            <ul>
						                                            	<li style="width:100%;">조회 된 하위사업자가 없습니다.</li>
						                                            </ul>
					                                            </div>
				                                            </c:if>
			                                            
			                                            
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        <!-- <div class="suchen"><a href="#" class="suchen_a">검색</a></div> -->
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> 
				                                       
				                                       <a href="#" id="btnGoList">취소</a>
			                                       </div>
			                                       <%-- 하단 버튼 끝 --%>
			                                       
			                                        				                                        
			                                      
			                                  
			                                  
			                                  	 <%-- ========================================== --%>
                                       				 <%-- 본문 종료 --%>
                                       				 <%-- ========================================== --%>
			                                  
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