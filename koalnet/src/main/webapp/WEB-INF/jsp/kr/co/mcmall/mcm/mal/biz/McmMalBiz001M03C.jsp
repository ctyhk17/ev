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

				
				
				
				$("#btnIdFind").click(function() {	
					fnIdFind();
				});
				
				$("#btnMalFind").click(function() {	
					fnMalFind();
				});
				
				$("#btnUpFind").click(function() {	
					fnUpFind();
				});
				
				$("#btnGoList").click(function() {	
					fnGoList();
				});
				
				$("#btnSave").click(function() {	
					fnSave();
				});
				
				
				
				fncView( $("[name=resultList]") );

			});
			
			// 목록으로
			function fnGoList(){
				$("#mcmMalBiz001VO").attr("action", "<c:url value='/McmMalBiz001M01L.do'/>");
				$("#mcmMalBiz001VO").submit();				
			}
			
			function fnIdFind(){
				var win = window.open("<c:url value='/McmMalBiz001P03C.do'/>", "callback", "toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=550, height=550, top=0,left=20");
			}
			
			function fnMalFind(){
				var win = window.open("<c:url value='/McmMalBiz001P04C.do'/>", "callback", "toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=550, height=550, top=0,left=20");
			}
			
			function fnUpFind(){
				var win = window.open("<c:url value='/McmMalBiz001P05C.do'/>", "callback", "toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=550, height=550, top=0,left=20");
			}
			
			function fnSave(){
				var lcsId    = $("#lcsId").val();
				var usrId    = $("#usrId").val();
				var upLcsId  = $("#upLcsId").val();
				var lcsDivCd = $("#lcsDivCd").val();
				var strId    = $("#strId").val();
				var upLcsCk  = $(".upLcsCk:checked").val();

				if(usrId.length==0){
					alert('ID를 입력해주세요.')
					$("#usrId").focus();
					return;
				};
				
				jQuery.ajaxSettings.traditional = true;
				$.post(
			    		"<c:url value='/McmMalBiz001M03CP.do'/>",
			    		{
			    			"lcsId"    : lcsId,
			    			"usrId"    : usrId,
			    			"upLcsId"  : upLcsId,
			    			"lcsDivCd" : lcsDivCd,
			    			"upLcsCk"  : upLcsCk
			    		},
			    		function(responseText){
			    			alert("사업자가 등록되었습니다.")
			    		},
			    		"json"
			    	)
			    	.done(function(){
			    		fnGoList();
			    	})
			    	.fail(function(){
			    		alert('이미 등록된 사업자입니다.');
			    	});
			}
			
			
			
			
		</script>	
    
	</head>

	<body>


<form:form commandName="mcmMalBiz001VO" name="mcmMalBiz001VO" method="post">
	
<form:hidden path="lcsId"/>
<form:hidden path="lcsDivCd"/>
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
							<div class="aside_menu_back">홍보관리 > 사업자 관리 > <b>사업자 등록</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>사업자 등록 <small>| 사업자를 등록/조회 하실 수 있습니다.</small></h3>
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
			                                            <ul class="re_first">
			                                                <li class="title_back" style="width:16%;">사업자 번호(아이디)</li>
			                                                <li class="sub_back_p sub_back_b" style="width:30%; vertical-align:0px; "> <p class="first_text">* 사업자 등록시 자동 생성됩니다.</p></li>
			                                                <li class="title_back" style="width:16%;">사용자 아이디</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="usrId"/>
			                                                	<a href="#" id="btnIdFind"style="background-color:#f29d06; color:white; font-size:12px; padding:8px; font-weight:bold;">ID찾기</a>
			                                                </li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">상점 아이디</li>
			                                                <li class="sub_back_p sub_back_b" style="width:30%; vertical-align:0px; "><p class="first_text">* 사업자 등록시 자동 부여됩니다.</p>
			                                                </li>
			                                                <li class="title_back" style="width:16%;">판매사업자 아이디</li>
			                                                <li class="sub_back_p sub_back_b" style="width:30%;"><form:input path="upLcsId"/>
			                                                	<a href="#" id="btnUpFind"style="background-color:#f29d06; color:white; font-size:12px; padding:8px; font-weight:bold;">ID찾기</a>
			                                                	<p class="first_text">* 판매사업자가 존재하지 않을 시 비워주세요.</p>
			                                                </li>
			                                            </ul>
			                                        	<%-- <ul>
			                                        		<li class="title_back" style="width:16%;">상위사업자 등록여부</li>
			                                                <li class="sub_back" style="width:30%;">
				                                                <form:checkbox class="upLcsCk" path="athCd" value="CMN001004"/>등록
			                                                </li>
			                                        	</ul> --%>
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        <!-- <div class="suchen"><a href="#" class="suchen_a">검색</a></div> -->
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button">
														<a href="#" id="btnSave">저장</a>
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