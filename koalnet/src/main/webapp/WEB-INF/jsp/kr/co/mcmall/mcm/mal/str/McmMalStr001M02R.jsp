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
		<script type="text/javascript"  src="<c:url value='/js/clipboard.js' />"></script>
    
    
    	<script type="text/javascript">
		
			$(document).ready(function () {  

				
				$("#btnCopyUrl").attr('data-clipboard-action',document.location.href);
				
				var clipboard = new Clipboard('#btnCopyUrl');
				clipboard.on('success',function(e){
					alert('복사되었습니다.');
				});
				clipboard.on('error',function(e){
					console.log(e);
				});
				
				
			
				
				
			// 목록으로
				$("#btnUpdate").click(function() {	
					fnGoUpdate();
				});

			});
			
			function fnGoUpdate(){
				$("#mcmMalStr001VO").attr("action", "<c:url value='/McmMalStr001M03U.do'/>");
				$("#mcmMalStr001VO").submit();		
				
			}
			
			
			


			
			
			
			
			
		</script>	
    
	</head>

	<body>


<form:form commandName="mcmMalStr001VO" name="mcmMalStr001VO" method="post">
	<form:hidden path="strId"/>
	

	
	
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
							<div class="aside_menu_back">시스템설정 >  <b>상점관리</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>상점관리 <small>| 상점설정은 조회/수정 하실 수 있습니다.</small></h3>
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
			                                                <li class="title_back" style="width:16%; text-align:center;">상점코드</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${resultInfo.strId}"/></li>
			                                                <li class="title_back" style="width:16%; text-align:center;">상점명</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${resultInfo.strNm}"/></li>
			                                               
			                                            </ul>
			                                            <ul>
			                                             <li class="title_back" style="width:16%; text-align:center;"><c:out value="${resultInfo.strPhnCnts}"/></li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${resultInfo.strPhnVal}"/></li>
			                                               
			                                                <li class="title_back" style="width:16%; text-align:center;"><c:out value="${resultInfo.strFaxCnts}"/></li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${resultInfo.strFaxVal}"/></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%; text-align:center;"><c:out value="${resultInfo.strBankCnts}"/></li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${resultInfo.strBankVal}"/></li>
			                                                <li class="title_back" style="width:16%; text-align:center;"><c:out value="${resultInfo.strAccCnts}"/></li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${resultInfo.strAccVal}"/></li>
			                                            </ul>
			                                            <ul>
			                                                  <li class="title_back" style="width:16%; text-align:center;"><c:out value="${resultInfo.strAccnmCnts}"/></li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${resultInfo.strAccnmVal}"/></li>
			                                                 <li class="title_back" style="width:16%; text-align:center;"><c:out value="${resultInfo.strEmailCnts}"/></li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${resultInfo.strEmailVal}"/></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%; text-align:center;">상점설명</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${resultInfo.strCnts }"/>
			                                                </li>
			                                                
			                                            </ul>
			                                         
			                                            
			                                            
			                                            
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        <!-- <div class="suchen"><a href="#" class="suchen_a">검색</a></div> -->
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> 
				                                       <!-- <a href="#" id="btnUpdate">수정</a> -->
				                                       <a href="#" id="btnUpdate">수정</a>
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