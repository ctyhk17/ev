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
	    		$('#btnUpdate').click(function(){
	    			fnUpdate();
	    		});
	    		$('#btnCancle').click(function(){
	    			fnCancle();
	    		})
	    	});
	    	
	    	function fnCancle(){
	    		$("#McmCmnCtr001VO").attr("action", "<c:url value='/McmCmnCtr001M01L.do'/>");
				$("#McmCmnCtr001VO").submit();
	    	}
	    	
	    	function fnUpdate(){
	    		var cd = $('#cd').val();
	    		var cdNm = $('#cdNm').val();
	    		var cdEtc = $('#cdEtc').val();
	    		 jQuery.ajaxSettings.traditional = true;
	    		 $.post(
	    				 "<c:url value='/McmCmnCtr001M04UP.do' />",
	    				 {
	    					  "cd":cd
	    					 ,"cdNm":cdNm
	    					 ,"cdEtc":cdEtc
	    				 },
	    				 function(result){
							alert("수정되었습니다.");
	    				 },"json"
	    				).done(function(){
	    					fnCancle();
	    				}).fail(function(){
	    					alert("수정실패되었습니다.");
							document.location.reload();
	    				})
	    				
	    	} 
		</script>
	</head>    
<body>
	<form:form commandName="McmCmnCtr001VO" name="McmCmnCtr001VO" method="post">
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
			                    <div class="aside_menu_back">시스템설정 > <b>키워드관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    <div class="content_1">
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>카테고리관리 <small>| 카테고리 관리 하실 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                        
			                        <div class="content_1_1" id="basicSet">
                            			<div class="tab tab_1 tab_1_active">
                                    		<div class="tab_line tab_1_1">
						                        <div class="resize_box">
			                                            <ul class="re_first">
			                                                <li class="title_back title_back_p title_back_b" style="width:20%;text-align:center;">카테고리ID</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;width:22%;">
			                                                	<form:input path="cd" style="border:none;" readonly="true" />
			                                                </li>
			                                                <li class="title_back title_back_p title_back_b" style="width:20%;text-align:center;">코드그룹명</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 0px; width: 22%;">
			                                                    <form:input path="cdGrpNm" style="border:none;" readonly="true" />
			                                                </li>
			                                            </ul>
			                                            
			                                            <ul>
			                                                <li class="title_back title_back_p title_back_b" style="width:20%;text-align:center;">카테고리명</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;"">
			                                                	<form:input path="cdNm" style="width:95%;" />
			                                                </li>
          	                                                <li class="title_back title_back_p title_back_b" style="width:20%;text-align:center;">비고</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;"">
			                                                	<form:input path="cdEtc" style="width:95%;" />
			                                                </li>
			                                            </ul>
			                                    </div><!-- resize_box -->
                              			<div class="save_button">
                              				<a href="#" id="btnUpdate">수정</a>
                              				<a href="#" id="btnCancle">취소</a>
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