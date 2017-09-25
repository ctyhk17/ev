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
				$('#btnInsert').click(function(){
					fnCdInsert();
				});
				$('#btnCancle').click(function(){
		   			fnCdInfoView();
				});
			});
			
			function fnCdInfoView(){
				$("#McmCmnCcd001VO").attr("action", "<c:url value='/McmCmnCcd001M11L.do' />");
				$("#McmCmnCcd001VO").submit();
			}
			
			function fnCdInsert(){
				var cdGrpId = $('#cdGrpId').val();
				var cd = $('#cd').val();
				var cdNm = $('#cdNm').val();
	    		var cdEtc = $('#cdEtc').val();
	    		
	    		 jQuery.ajaxSettings.traditional = true;
	    		 $.post(
	    				 "<c:url value='/McmCmnCcd001M13CP.do' />",
	    				 {
	    					  "cdNm":cdNm
	    					 ,"cdEtc":cdEtc
	    					 ,"cdGrpId":cdGrpId
	    					 ,"cd":cd
	    				 },
	    				 function(result){
	    					 var res = result.rtnMsg;
	    					 
	    					 if(res == 1){
	    						 alert("등록되었습니다.");
	    						 fnCdInfoView();
	    					 }else{
								 alert("이미 등록된 코드ID 입니다.");
								 $('#cd').focus();
								 return;
	    					 }
	    					 
	    				 },"json"
	    				).fail(function(){
							document.location.reload();
	    				})
			}
		</script>
	</head>    
<body>
	<form:form commandName="McmCmnCcd001VO" name="McmCmnCcd001VO" method="post">
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
			                                                <li class="title_back title_back_p title_back_b" style="width:20%;text-align:center;">코드그룹명</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;width:22%;">
			                                                	<p class="first_text" style="font-size:14px;">
			                                                		<form:select path="cdGrpId">
																		<form:option value="" label="선택하세요"/>
																		<c:forEach var="resultCdGrpList" items="${resultCdGrpList}">
																			<form:option value="${resultCdGrpList.cdGrpId}" label="${resultCdGrpList.cdGrpNm}"/>
																		</c:forEach>			                                                	
			                                                		</form:select>
			                                                	</p>
			                                                </li>
			                                                
		                                                    <li class="title_back title_back_p title_back_b" style="width:20%;text-align:center;">코드 ID</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;">
			                                                	<p class="first_text" style="font-size:14px;"><form:input path="cd" /></p>
			                                                </li>
			                                            </ul>
			                                            
			                                            <ul>
		                                                    <li class="title_back title_back_p title_back_b" style="width:20%;text-align:center;">공통코드명</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;"">
			                                                	<p class="first_text" style="font-size:14px;"><form:input path="cdNm" style="width:95%;"/></p>
			                                                </li>
		                                                	<li class="title_back title_back_p title_back_b" style="width:20%;text-align:center;">비고</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;"">
			                                                	<p class="first_text" style="font-size:14px;"><form:input path="cdEtc" /></p>
			                                                </li>
			                                            </ul>
			                                            <ul>
			                                            
			                                            </ul>
			                                    </div><!-- resize_box -->
                              			<div class="save_button">
                              				<a href="#" id="btnInsert">등록</a>
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