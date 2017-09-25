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
				
				// 취소
				$("#btnCancel").click(function() {	
					fnCancel();
				});
				
			});
			
			// 취소
			function fnCancel(){
				$("#mcmCmnUsr003VO").attr("action", "<c:url value='/McmCmnUsr003M02R.do'/>");
				$("#mcmCmnUsr003VO").submit();
			} 
			
			
			// 저장
			function fnSave()
			{
				
				
				var usrId     = $("#usrId").val(); 
				var usrNm     = $("#usrNm").val();
				var telNo     = $("#telNo").val();
				var emailAddr = $("#emailAddr").val();
				var useYn     = $("#useYn").val();
				var feePayYn  = $("#feePayYn").val();
				
				
				if(usrNm.length == 0)
				{
					alert('이름을 입력하세요');
					$("#usrNm").focus();
					return;
				}
				
				/*
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
				*/
				
				if(useYn.length == 0)
				{
					alert("사용여부를 선택하세요");
					$("#useYn").focus();
					return;
				}
				
				if(feePayYn.length == 0)
				{
					alert("회비납부여부를 입력하세요");
					$("#feePayYn").focus();
					return;
				}
				
				
				$.post(
						"<c:url value='/McmCmnUsr003M04UP.do'/>", 
						{ 
							  "usrId"     :  usrId
							, "usrNm"     :  usrNm
							, "telNo"     :  telNo
							, "emailAddr" :  emailAddr						
							, "useYn"     :  useYn
							, "feePayYn"  :  feePayYn
						}, 
						function(responseText)
						{
							var rtnCode = responseText.rtnCode;
							var rtnMsg = responseText.rtnMsg;
							
							alert(rtnMsg);
							
							if(rtnCode == "000")
							{
								$("#mcmCmnUsr003VO").attr("action", "<c:url value='/McmCmnUsr003M02R.do'/>");
								$("#mcmCmnUsr003VO").submit();
							}
							
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

<form:form commandName="mcmCmnUsr003VO" name="mcmCmnUsr003VO" method="post">
	<form:hidden path="pageIndex"/>
	<form:hidden path="usrId"/>
	
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
			                    <div class="aside_menu_back">조합원관리 > <b>회원관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>회원관리 <small>| 당협에 가입한 회원을 관리합니다.</small></h3>
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
			                                                <li class="sub_back" style="width:30%;"><form:input path="usrNm" style="width:98%;" /></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">전화번호</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="telNo" style="width:90%;" /></li> 
			                                                <li class="title_back" style="width:16%;">이메일</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="emailAddr" style="width:98%;" /></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사용여부</li>
			                                                <li class="sub_back" style="width:30%;">
			                                                	<form:select path="useYn" style="width:40%;">
			                                                		<form:option value="">선택하세요.</form:option>
			                                                		<form:option value="Y">예</form:option>
			                                                		<form:option value="N">아니오</form:option>
			                                                	</form:select>
			                                                </li>
			                                                <li class="title_back" style="width:16%;">회비납부여부</li>
			                                                <li class="sub_back" style="width:30%;">
			                                                	<form:select path="feePayYn" style="width:40%;">
			                                                		<form:option value="">선택하세요.</form:option>
			                                                		<form:option value="Y">예</form:option>
			                                                		<form:option value="N">아니오</form:option>
			                                                	</form:select>
			                                                </li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">가입일자</li>
			                                                <li class="sub_back" style="width:auto;">${ resultInfo.joinDt }</li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">주소</li>
			                                                <li class="sub_back" style="width:auto;"></li>
			                                            </ul>
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> 
														<a href="#;" id="btnSave">저장</a>
														<a href="#;" id="btnCancel">취소</a>
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