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
	    
	    <script type="text/javascript" src="<c:url value='/js/se2/js/HuskyEZCreator.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/se2/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js'/> "></script>
    
    
    	<script type="text/javascript">
			$(document).ready(function(){
						
				$('#searchBtn').click(function( ){
					
					$("#ddCmt001VO").attr("action", "<c:url value='/McmCmnBbs006M21L.do'/>");
					$("#ddCmt001VO").submit();	
				});
				$("[id='btnList']").click(function(){
					location.href="/McmCmnBbs006M21L.do?upMenuId=M003&subMenuId=M003003";
				});
				$("[id='btnUpdate']").click(function(){
					fnUpdate();
				});
				$("[id='btnDelete']").click(function(){
					
					fnDelete();
					
				});
				$("[id='btnReply']").click(function(){
					
					fnReply();
					
				});
				
			});
			function fnUpdate() {
				$("#mcmCmnBbs006VO").attr("action", "<c:url value='/McmCmnBbs006M24U.do'/>");
				$("#mcmCmnBbs006VO").submit();	
			}			
			
			
			function fnDelete() {
				
		    	var bbsId = $("#bbsId").val();
		    	
		    	jQuery.ajaxSettings.traditional = true;
		    	$.post(
		    		"<c:url value='/McmCmnBbs006M25DP.do'/>",
		    		{	
		    			"bbsId" : bbsId
		    		},
		    		function(responseText){
		    			alert("공지사항이 삭제되었습니다.")
		    		},
		    		"json"
		    	)
		    	.done(function(){
		    		location.href = "/McmCmnBbs006M21L.do?upMenuId=M003&subMenuId=M003003"
		    	})
		    	.fail(function(){
		    		alert('공지사항 삭제에 실패하였습니다.');
		    	}); 
			}
		
	</script>
    
	</head>

	<body>


<form:form commandName="mcmCmnBbs006VO" name="mcmCmnBbs006VO" method="post">
<form:hidden path="bbsId" value="${resultMap.bbsId }"/>
<form:hidden path="usrId" value="${resultMap.usrId }"/>
<form:hidden path="usrNm" value="${resultMap.usrNm }"/>
	
	
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
							<div class="aside_menu_back">고객센터 > 공지사항 ><b> 공지사항 조회</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>공지사항 <small>| 공지사항을 조회 하실 수 있습니다.</small></h3>
		                        </div>
		                        <%-- 상단 타이틀 끝  --%>
		                        
		                        
		                        <div class="content_1_1">
		                             <div class="tab tab_1 tab_1_active">
		                                    <div class="tab_line tab_1_1"> 
			                                       <%-- ========================================== --%>
			                                       <%-- 본문 시작 --%>
			                                       <%-- ========================================== --%>
												 
			                                        <div class="resize_box">
			                                            <ul class="re_first" >
			                                                <li class="title_back" style="width:16%;">공지내용</li>
			                                                <li class="sub_back" style="width:64%;"><c:out value="${resultMap.bbsSbj }" /></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="sub_back" style="width:80%;padding:50px 0 50px 20px;"><c:out value="${fn:replace(resultMap.bbsCnts, cn, br)}" escapeXml="false"/></li>
			                                            </ul>
			                                        </div><!-- resize_box -->
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> 
			                                       <a href="#" id="btnList">목록</a>
			                                        <c:if test="${checkAth }">
			                                        &nbsp;<a href="#" id="btnUpdate">수정</a>
			                                        &nbsp;<a href="#" id="btnDelete">삭제</a>
			                                        </c:if>
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