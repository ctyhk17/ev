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

				
				
				
				

			});
			
		
			
			
			
			
			
			
			
			
		</script>	
    
	</head>

	<body>


<form:form commandName="mcmMalBiz001VO" name="mcmMalBiz001VO" method="post">
	
	<form:input path="lcsDivCd"/>

	

	
	
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
							<div class="aside_menu_back">홍보관리 > <b>사업자 관리</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>사업자 관리 <small>| 쇼핑몰의 기본적인 정보를 변경하실 수 있습니다.</small></h3>
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
			                                           <h3>사업장</h3>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사업자 구분코드</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="lcsDivCd"/></li>
			                                                <li class="title_back" style="width:16%;">사업자 연락처</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="telNo"/></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사업자 아이디</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="usrId"/></li>
			                                                <li class="title_back" style="width:16%;">상점 아이디</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="strId"/></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사업자 이름</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="usrNm"/></li>
			                                                <li class="title_back" style="width:16%;">사업자 URL</li>
			                                                <li class="sub_back" style="width:30%;"></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%; padding:88px 5px; vertical-align:86px;">1</li>
			                                                <li class="sub_back" style="width:30%;">
			                                                	<%-- <form:textarea path="itrCnts" rows="10" style="width:275%; height:180px;"/> --%>
			                                                </li>
			                                                
			                                            </ul>
			                                            
			                                         
			                                            
			                                            
			                                            
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        <!-- <div class="suchen"><a href="#" class="suchen_a">검색</a></div> -->
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> 
				                                       <a href="#" id="btnUpdate">수정</a>
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