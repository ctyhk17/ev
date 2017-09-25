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
				
				// 아이디 중복체크
				$("#btnIdCheck").click(function() {	
					fnIdCheck();
				});
				
				// 아이디 한글 제거
				$("#usrId").keyup(function(){$(this).val( $(this).val().replace(/[^\!-z]/g,"") );} );
				
				
				$("#usrPwdCheck").blur(function(){
					fnPwdCheck();
				});
				
			});
			
			// 취소
			function fnCancel(){
				$("#mcmCmnUsr002VO").attr("action", "<c:url value='/McmCmnUsr002M01L.do'/>");
				$("#mcmCmnUsr002VO").submit();
			} 
			
			
			// 저장
			function fnSave()
			{
				
				
				var usrId     = $("#usrId").val(); 
				var usrPwd    = $("#usrPwd").val();
				var usrNm     = $("#usrNm").val();
				var telNo     = $("#telNo").val();
				var emailAddr = $("#emailAddr").val();
				var useYn     = $("#useYn").val();
				var feePayYn  = $("#feePayYn").val();
				
				var isValid  = $("#isValid").val();
				var pwdCheck = $('#usrPwdCheck').val();
				
				
				if(usrId.length == 0)
				{
					alert('아이디를 입력하세요');
					$("#usrId").focus();
					return;
				}
				
				if(usrNm.length == 0)
				{
					alert('이름을 입력하세요');
					$("#usrNm").focus();
					return;
				}
				
				if(usrPwd.length == 0)
				{
					alert("비밀번호를 입력하세요");
					$("#usrPwd").focus();
					return;
				}
				
				if(pwdCheck.length == 0)
				{
					alert("비밀번호를 입력하세요");
					$("#usrPwdCheck").focus();
					return;
				}
				
				
				if(usrPwd != pwdCheck)
				{
					alert("비밀번호가 일치하지 않습니다.");
					$("#usrPwdCheck").focus();
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
				
				if(isValid == "999"){
					alert("ID중복확인이 필요합니다.");
					return;
				}
				
				
				$.post(
						"<c:url value='/McmCmnUsr002M03CP.do'/>", 
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
								$(location).attr("href", "<c:url value='/McmCmnUsr002M01L.do'/>");
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
			
			
			// 아이디 중복체크
			function fnIdCheck()
			{
				
					var usrId = $("#usrId").val();
					
					if(usrId.length == 0)
					{
						alert("아이디를 입력하세요.");
						return;
					}
					
					$.post(
							"<c:url value='/McmCmnUsr002P03R.do'/>", 
							{ 
								"usrId": usrId 
							}, 
							function(responseText)
							{
								var rtnCode = responseText.rtnCode;
								
								if(rtnCode == "999") 
								{
									alert("중복된 아이디가 존재합니다.");
									$('#usrId').focus();
									
								
								}else{
									alert("사용가능한 아이디 입니다.");
									$('#usrPwd').focus();
								}
								
								$("#isValid").val(rtnCode);
								
							}, 
							"json"
					)
					.done(function() {
						
  					})
					.fail(function() {
						alert( "처리 도중 에러가 발생하였습니다." );
  					})
  					;

			}
			
			// 패스워드 확인
			function fnPwdCheck()
			{
				
				var pwd       = $('#usrPwd').val();
				var pwdCheck  = $('#usrPwdCheck').val();
				var textDiv   = "";
				
				if(pwd.length == 0)
				{
					alert("패스워드를 입력하세요.");
					$("#usrPwd").focus();
					return;
				
				}else
				{
					if(pwd == pwdCheck)	// 패스워드 일치
					{	
						textDiv = " * 패스워드가 일치합니다.";
						$('#pwdCheck').text(textDiv);
				
					}else if(pwd != pwdCheck)	// 패스워드 불일치
					{	
						textDiv = " * 패스워드가 일치하지 않습니다.";
						$('#pwdCheck').text(textDiv);
					}
				}
			}
			
			
		</script>	
			
			
	</head><!-- End of head -->

	<body>

<form:form commandName="mcmCmnUsr002VO" name="mcmCmnUsr002VO" method="post">
	<form:hidden path="pageIndex"/>
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
			                    <div class="aside_menu_back">조합원관리 > <b>조합원관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>조합원관리 <small>| 당협에 가입한 조합원을 관리합니다.</small></h3>
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
			                                                <li class="sub_back" style="width:30%;"><form:input path="usrId" style="width:70%;" /><a href="#;" id="btnIdCheck" >중복체크</a></li>
			                                                <li class="title_back" style="width:16%;">이름</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="usrNm" style="width:98%;" /></li>
			                                            </ul>
			                                            
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">비밀번호</li>
			                                                <li class="sub_back" style="width:30%;"><form:password path="usrPwd" style="width:90%;" /></li>
			                                                <li class="title_back" style="width:16%;">비밀번호 확인</li>
			                                                <li class="sub_back" style="width:30%;"><input type="password" name="usrPwdCheck" id="usrPwdCheck" maxlength="20" style="width:98%;" /></li>
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