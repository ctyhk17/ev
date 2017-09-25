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
				
				// 저장
				$("#btnSave").click(function() {	
					fnSave();
				});
				
			});
			
			
			// 저장
			function fnSave()
			{
				
				
				//var usrId     = $("#usrId").val(); 
				//var usrPwd    = $("#usrPwd").val();
				var usrNm     = $("#usrNm").val();
				var telNo     = $("#telNo").val();
				var emailAddr = $("#emailAddr").val();
				var rdAddrDtl = $("#rdAddrDtl").val();
				var rdAddr    = $("#rdAddr").val();
				var pstNo     = $("#pstNo").val(); 
				
				if(usrNm.length == 0)
				{
					alert('이름을 입력하세요');
					$("#usrNm").focus();
					return;
				}
				
				if(telNo.length == 0)
				{
					alert('전화번호를 입력하세요');
					$("#telNo").focus();
					return;
				}
				
				
				if(emailAddr.length == 0)
					{
						alert("이메일을 입력하세요");
						$("#emailAddr").focus();
						return;
					}
				
				
				$.post(
						"<c:url value='/McmCmnUsr001M03UP.do'/>", 
						{ 
							  "usrNm"     :  usrNm
							, "telNo"     :  telNo
							, "emailAddr" :  emailAddr			
							, "rdAddrDtl" :  rdAddrDtl
							, "rdAddr"    :  rdAddr
							, "pstNo"     :  pstNo
						}, 
						function(responseText)
						{
							var rtnCode = responseText.rtnCode;
							var rtnMsg = responseText.rtnMsg;
							
							alert(rtnMsg);
							
							
						}, 
						"json"
				)
				.done(function() {
					
				})
				.fail(function() {
					alert( "처리 도중 에러가 발생하였습니다." );
				});
			}
			
			
		</script>	
			
			
	</head><!-- End of head -->

	<body>

<form:form commandName="mcmCmnUsr001VO" name="mcmCmnUsr001VO" method="post">
	<input type="hidden" name="isValid" id="isValid" value="999" />
	
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
							<div class="aside_menu_back">정보내역 > <b>회원정보관리</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>회원정보관리 <small>| 회원의 기본적인 정보를 변경하실 수 있습니다.</small></h3>
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
			                                                <li class="title_back" style="width:16%;">아이디</li>
			                                                <li class="sub_back" style="width:30%;">${ mcmCmnUsr001VO.usrId }</li>
			                                                <li class="title_back" style="width:16%;">이름</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="usrNm" /></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">전화번호</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="telNo" /></li>
			                                                <li class="title_back" style="width:16%;">이메일</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="emailAddr" /></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%; padding:45px 5px;">주소</li>
			                                                <li class="sub_back" style="width:auto; vertical-align: -15px;">
			                                                (우)<form:input path="pstNo"/><br>
			                                                <form:input path="rdAddr" style="width:140%;"/><br>
			                                                <form:input path="rdAddrDtl" style="width:140%;"/></li>
			                                            </ul>
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> <a href="#;" id="btnSave">저장</a></div>
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