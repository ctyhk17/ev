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
				
				// 승인
				$("#btnUpdate").click(function() {	
					fnUpdate();
				});
				
				
			});
			
			// 목록
			function fnList(){
				$("#mcmCmnUsr002VO").attr("action", "<c:url value='/McmCmnUsr002M11L.do'/>");
				$("#mcmCmnUsr002VO").submit();
			}
			
			
			
			// 승인
			function fnUpdate(){
				
				if(confirm("해당 신청건을 [승인]하시겠습니까?")){
				
					var usrId     = $("#usrId").val();
					var strId = $("#strId").val();
					var athCd = $("#searchAthCd").val();
					
					$.post(
							"<c:url value='/McmCmnUsr002M12RP.do'/>", 
							{ 
								  "usrId"     :  usrId,
								  "strId"     : strId,
								  "athCd"     : athCd
							}, 
							function(responseText)
							{
								var rtnCode = responseText.rtnCode;
								var rtnMsg = responseText.rtnMsg;
								
								/* alert(rtnMsg); */
								
								/* if(rtnCode == "000")
								{
									fnUsrStrAdd();
								} */
								
							}, 
							"json"
					)
					.done(function() {
						alert('승인되었습니다');
						location.href="/McmCmnUsr002M11L.do?upMenuId=M008&subMenuId=M008001";
					})
					.fail(function() {
						alert( "처리 도중 에러가 발생하였습니다." );
					});
				}
			}
			
			/* function fnUsrStrAdd(){
				
				var usrId = $("#usrId").val();
				var strId = $("#strId").val();
				var athCd = $("#searchAthCd").val();
				jQuery.ajaxSettings.traditional = true;
				$.post(
						"<c:url value='/McmCmnUsr002M13RP.do'/>", 
						{ 
							  "usrId"              : usrId
							, "strId"              : strId
							, "athCd"              : athCd
						},
						"json"
				)
				.fail(function() {
					alert( "처리 도중 에러가 발생하였습니다." );
				})
				;
			}	 */
		</script>	
			
			
	</head><!-- End of head -->

	<body>

<form:form commandName="mcmCmnUsr002VO" name="mcmCmnUsr002VO" method="post">
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
			                    <div class="aside_menu_back">조합원관리 > 조합원가입승인 > <b>조합원가입승인 조회</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>조합원가입승인 조회<small>| 당협에 조합원으로 가입을 신청한 사용자를 승인합니다.</small></h3>
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
			                                                <li class="title_back" style="width:16%;">전화번호</li>
			                                                <li class="sub_back" style="width:30%;">${ resultInfo.telNo }</li>
			                                                <li class="title_back" style="width:16%;">이메일</li>
			                                                <li class="sub_back" style="width:30%;">${ resultInfo.emailAddr }</li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">신청일자</li>
			                                                <li class="sub_back" style="width:auto;">${ resultInfo.joinDt }</li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%; padding:28px 5px;">주소</li>
			                                                <li class="sub_back" style="width:auto;vertical-align: -13px;">(우)${resultInfo.pstNo}<br>${resultInfo.rdAddr}<br>${resultInfo.rdAddrDtl}</li>
			                                            </ul>
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> 
														<a href="#;" id="btnUpdate">승인</a>														
														<a href="#;" id="btnList">목록</a>
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
			
			
		   
		   
		   
		</article>





		<footer>
		    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminFooterInclude.jsp" %>
		</footer><!-- End of footer -->
	
</form:form>
	
	</body><!-- End of body -->

</html>