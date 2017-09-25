<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmCmnCcd001M02R.jsp
  * @Description : 코드그룹 상세정보
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2017.06.20            최초 생성
  *
  * author 개발팀
  * since 2017.06.20
  *
  */
%>
<!DOCTYPE html>
<html lang="ko">
	<head>
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    <script>
	    	$(document).ready(function(){
	    		$('#btnContentList').click(function(){
	    			fnCdGrpList();
	    		});
	    		$('#btnUpdate').click(function(){
	    			fnCdGrpUpdate();
	    		});
				$('#btnDelete').click(function(){
	    			fnCdGrpDelete();
	    		});
	    	});
	    	
	    	function fnCdGrpUpdate(){
	    		$("#McmCmnCcd001VO").attr("action", "<c:url value='/McmCmnCcd001M14U.do' />");
				$("#McmCmnCcd001VO").submit();
	    	}
	    	
	    	function fnCdGrpDelete(){
	    		var cdGrpId = $('#cdGrpId').val();
	    		var cd = $('#cd').val();
	    		if(confirm("삭제하시겠습니까?"))
	    		{
    			 jQuery.ajaxSettings.traditional = true;
    			 $.post(
    					 "<c:url value='/McmCmnCcd001M15DP.do' />",
    					 {
    						  "cdGrpId":cdGrpId
    						  ,"cd":cd
    					 },
    					 function(result){
    						 alert("삭제되었습니다.");
    					 },"json"
    					).done(function(){
    						fnCdGrpList();
    					}).fail(function(){
    						alert("삭제 실패하였습니다.");
							document.location.reload();
    					});
	    		}
	    	}
	    	
	    	function fnCdGrpList(){
    			$("#McmCmnCcd001VO").attr("action", "<c:url value='/McmCmnCcd001M11L.do' />");
				$("#McmCmnCcd001VO").submit();
	    	}
		</script>
	</head>    
<body>
	<form:form commandName="McmCmnCcd001VO" name="McmCmnCcd001VO" method="post">
		<form:hidden path="cdGrpId"/>
		<form:hidden path="cd"/>
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
			                    <div class="aside_menu_back">시스템설정 > <b>공통코드관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    <div class="content_1">
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>공통코드관리 <small>| 코드그룹을 설정 하실 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                        
			                        <div class="content_1_1" id="basicSet">
                            			<div class="tab tab_1 tab_1_active">
                                    		<div class="tab_line tab_1_1">
						                        <div class="resize_box">
			                                            <ul class="re_first">
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">코드그룹 ID</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 0px; width: 22%;">
			                                                    <p class="first_text" style="font-size:14px;"><c:out value='${resultMap.cdGrpId}' /></p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">코드그룹명</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;width:20%;">
			                                                	<p class="first_text" style="font-size:14px;"><c:out value='${resultMap.cdGrpNm}' /></p>
			                                                </li>
			                                                
			                                            </ul>
			                                            <ul>
                                                	        <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">코드그룹 설명</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;"">
			                                                	<p class="first_text" style="font-size:14px;"><c:out value='${resultMap.cdGrpCnts}' /></p>
			                                                </li>
			                                            
  			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">코드 ID</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;"">
			                                                	<p class="first_text" style="font-size:14px;"><c:out value='${resultMap.cd}' /></p>
			                                                </li>
			                                             </ul>   
			                                            <ul>
			                                                
		                                                    <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">공통코드명</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;"">
			                                                	<p class="first_text" style="font-size:14px;"><c:out value='${resultMap.cdNm}' /></p>
			                                                </li>
			                                                 <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">등록일/수정일</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;">
			                                                    <p class="first_text" style="font-size:14px;"><c:out value='${resultMap.lstUdtDt}' /></p>
			                                            </ul>
			                                            <ul>
		                                            	   	<li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">비고</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;"">
			                                                	<p class="first_text" style="font-size:14px;"><c:out value='${resultMap.cdEtc}' /></p>
			                                                </li>
			                                            </ul>
			                                    </div><!-- resize_box -->
                              			<div class="save_button">
                              				<a href="#" id="btnUpdate">수정</a>
                              				<a href="#" id="btnDelete">삭제</a>
                              				<a href="#" id="btnContentList">목록</a>
                              			</div>                              		
                              		</div>
                              	</div>
                              </div>
						</div>
					</div>	
				</div>
			</div>
		</div>
		</article>
		<footer>
		    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminFooterInclude.jsp" %>
		</footer><!-- End of footer -->		
	</form:form>	
</body>
</html>