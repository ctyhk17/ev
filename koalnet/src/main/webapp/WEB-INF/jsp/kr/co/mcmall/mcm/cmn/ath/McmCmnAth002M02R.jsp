<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmCmnUsr001M03C.jsp
  * @Description : 회원정보수정
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
				
				// 목록
				$("#btnList").click(function() {	
					fnList();
				});
				
				// 수정
				$("#btnUpdate").click(function() {	
					fnUpdate();
				});
				
				// 삭제
				$("#btnDelete").click(function() {	
					fnDelete();
				});
				
			});
			
			// 목록
			function fnList(){
				$("#mcmCmnAth002VO").attr("action", "<c:url value='/McmCmnAth002M01L.do'/>");
				$("#mcmCmnAth002VO").submit();
			}
			
			// 수정
			function fnUpdate(){
				
			
				if(confirm("회원 권한 정보를 등록하시겠습니까?")){
				
				var usrId = $("#usrId").val(); 
				var athCd = $("#athCd").val();
				var strId = $("#strId").val();
				
				if(athCd.length==0){
					alert('권한코드를 선택하여 주세요.')
					$("#athCd").focus();
					return;
				}
				
				
				
				jQuery.ajaxSettings.traditional = true;
				$.post(
						"<c:url value='/McmCmnAth002M04UP.do'/>", 
						{ 
							  "usrId"              : usrId
							, "athCd"              : athCd
							, "strId"              : strId
						}, 
						function(responseText)
						{
							var rtnMsg = responseText.rtnMsg;
							alert("정상적으로 등록되었습니다.") 
							window.location.reload();
						}, 
						"json"
				)
				.done(function() {
					$("#mcmCmnAth002VO").attr("action", "<c:url value='/McmCmnAth002M02R.do'/>");
 				})
				.fail(function() {
					alert( "이미 보유한 권한입니다." );
					$("#athCd").focus();
					return;
				})
				;

				
				}
			}
			
			// 삭제
			function fnDelete(){
				
				
				
				if(confirm("회원 권한 정보를 삭제하시겠습니까?")){
				
					var usrId     = $("#usrId").val();
					var strId     = $("#strId").val();
					var athCd     = $("#athCd").val();
					
					$.post(
							"<c:url value='/McmCmnAth002M05DP.do'/>", 
							{ 
								  "usrId"     :  usrId,
								  "athCd"     :  athCd,
								  "strId"     :  strId
								  
							}, 
							function(responseText)
							{
								
								var rtnMsg = responseText.rtnMsg;
								alert("정상적으로 삭제되었습니다.") 
								window.location.reload();
								
								
							}, 
							"json"
					)
					.done(function() {
						$("#mcmCmnAth002VO").attr("action", "<c:url value='/McmCmnAth002M02R.do'/>");
					})
					.fail(function() {
						alert( "처리 도중 에러가 발생하였습니다." );
					});
				}
			}
			
		</script>	
			
			
	</head><!-- End of head -->

	<body>

<form:form commandName="mcmCmnAth002VO" name="mcmCmnAth002VO" method="post">
	<form:hidden path="pageIndex"/>
	<form:hidden path="usrId"/>
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
			                                       
			                                       
			                                        <div class="resize_box">
			                                           <h3>회원정보</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back" style="width:16%;">아이디</li>
			                                                <li class="sub_back" style="width:30%;">${ resultInfo.usrId }</li>
			                                                <li class="title_back" style="width:16%;">이름</li>
			                                                <li class="sub_back" style="width:30%;">${ resultInfo.usrNm}</li>
			                                            </ul>
			                                            
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">권한코드설정</li>
			                                                <li class="sub_back" style="width:auto;">
			                                                <form:select path="athCd">
			                                                	<form:option value="">선택</form:option>
				                                                	<c:forEach var="resultList" items="${resultList}">
				                                                		<form:option value="${resultList.athCd}">${resultList.athCnts}</form:option>
				                                                	</c:forEach>
			                                                </form:select>
			                                                </li>
			                                                <li class="sub_back_p sub_back_b" style="width:30%; vertical-align: -2px;">
			                                                <p class="first_text">* 등록 또는 삭제 하실 권한코드를 선택해 주세요.</p>
			                                                </li>
			                                            </ul>
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> 
														<a href="#;" id="btnUpdate">등록</a>
														<a href="#;" id="btnDelete">삭제</a>
														<a href="#;" id="btnList">목록</a>
			                                       </div>			                                       
			                                       <%-- 하단 버튼 끝 --%>
			                                       
				                                   <div class="resize_box">
			                                           <h3>보유회원권한</h3>
			                                           <ul class="re_first" style="width:100%;">
			                                           		<li class="title_back" style="width:33%; text-align:center;">아이디</li>
			                                           		<li class="title_back" style="width:32%; margin-left:-5px; text-align:center;">권한코드</li>
			                                           		<li class="title_back" style="width:32%; margin-left:-5px; text-align:center;">권한</li>
			                                           </ul>
			                                           <c:forEach var="resultUsrList" items="${resultUsrList}">
			                                            <ul style="width:100%; ">
			                                                <li class="title_back" style="width:33%; background-color: white; text-align:center; font-weight: normal;">${ resultUsrList.usrId }</li>
			                                                <li class="title_back" style="width:32%; margin-left:-5px; background-color: white; text-align:center; font-weight: normal;">${ resultUsrList.athCd}</li>
			                                                <li class="title_back" style="width:32%; margin-left:-5px; background-color: white; text-align:center; font-weight: normal;">${ resultUsrList.athCnts}</li>
			                                            </ul>
			                                            </c:forEach>
			                                            
			                                            <c:if var="resultUsrList" test="${empty resultUsrList }">
			                                            	<ul class="re_first" style="width:100%;">
			                                            		<li class="title_back" style="width:100%; background-color: white; text-align:center; font-weight: normal;">보유중인 권한이 없습니다.</li>
			                                            	</ul>
			                                            </c:if>
			                                        </div>         
				                                        
			                                      
			                                  
			                                  
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
			
			
		   
		   
		   
		</article>





		<footer>
		    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminFooterInclude.jsp" %>
		</footer><!-- End of footer -->
	
</form:form>
	
	</body><!-- End of body -->

</html>