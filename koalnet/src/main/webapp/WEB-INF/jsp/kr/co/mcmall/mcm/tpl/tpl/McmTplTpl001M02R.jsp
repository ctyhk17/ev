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

				// 검색화면으로 이동
				$("#btnGoList").click(function() {	
					fncGoList();
				});
				
				// 수정화면으로 이동
				$("#btnGoUpdate").click(function() {	
					fncGoUpdate();
				});
				
				// 삭제
				$("#btnDelete").click(function() {	
					fncDelete();
				});
				
				
				

				
				fncView( $("[name=resultList]") );

			});
			
			
			// 목록으로 이동
			function fncGoList(){
				
				$("#mcmTplTpl001VO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntL.do'/>");
				$("#mcmTplTpl001VO").submit();
			}
			
			// 수정화면으로 이동
			function fncGoUpdate(){
				
				$("#mcmTplTpl001VO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntU.do'/>");
				$("#mcmTplTpl001VO").submit();
			}
			
			// 삭제처리
			function fncDelete(){
			
				if(confirm("해당 가감점 항목을 삭제하시겠습니까?"))
				{
					var adsubMgntNo = $("#adsubMgntNo").val();
					
					$.post(
							"<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntDProc.do'/>", 
							{ "adsubMgntNo": adsubMgntNo }, 
							function(responseText)
							{
								var rtnMsg = responseText.rtnMsg;
								alert("데이터가 정상적으로 삭제되었습니다.") 
								
							}, 
							"json"
					)
					.done(function() {
						fncGoList();
  					})
					.fail(function() {
						alert( "처리 도중 에러가 발생하였습니다." );
  					})
  					;

				}
			}
			
		</script>	
    
	</head>

	<body>


<form:form commandName="mcmTplTpl001VO" name="mcmTplTpl001VO" method="post">
	
	
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
							<div class="aside_menu_back">기본설정 > 기본정책 > <b>기본 정보 설정</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>기본 정보 설정 <small>| 쇼핑몰의 기본적인 정보를 변경하실 수 있습니다.</small></h3>
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
			                                            <ul class="re_first">
			                                                <li class="title_back" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back" style="width:30%;">사업장주소111</li>
			                                                <li class="title_back" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back" style="width:30%;">사업장주소</li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back" style="width:30%;">사업장주소111</li>
			                                                <li class="title_back" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back" style="width:30%;">사업장주소</li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back" style="width:auto;">사업장주소</li>
			                                            </ul>
			                                            <ul>
			                                            	<li class="title_back title_back_p title_back_b" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b" style="width:30%;">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b" style="width:30%;">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                            </ul>
			                                            
			                                            <ul>
			                                            	<li class="title_back title_back_p title_back_b" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b" style="width:auto;">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                                
			                                            </ul>
			                                            
			                                            <ul>
			                                                <li class="title_back title_back_p" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p" style="width:30%;">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p" style="width:30%;">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back title_back_p" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p" style="width:auto;">
			                                                    <input type="text" >
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">실제 접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        <!-- <div class="suchen"><a href="#" class="suchen_a">검색</a></div> -->
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> <a href="#">저장</a></div>
			                                       <%-- 하단 버튼 끝 --%>
			                                       
			                                        
			                                        <div class="resize_box">
			                                           <h3>사업장</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:20%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                            
			                                            <ul>
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:20%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                        </div><!-- resize_box -->
			                                        <div class="save_button"><a href="#">저장</a></div>
			                                        
			                                        <div class="resize_box">
			                                           <h3>사업장</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back title_back_p" style="width:10%;">사업장주소</li>
			                                                <li class="sub_back_p">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">실제 접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p" style="width:20%;">사업장주소</li>
			                                                <li class="sub_back_p">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">실제 접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                            
			                                            <ul>
			                                                <li class="title_back title_back_p" style="width:10%;">사업장주소</li>
			                                                <li class="sub_back_p">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">실제 접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p" style="width:20%;">사업장주소</li>
			                                                <li class="sub_back_p">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">실제 접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> <a href="#">저장</a></div>
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