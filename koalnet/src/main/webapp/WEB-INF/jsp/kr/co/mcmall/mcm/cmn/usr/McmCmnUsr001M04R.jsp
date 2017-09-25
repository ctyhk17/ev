<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmCmnUsr001M04R.jsp
  * @Description : 회원탈퇴
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
				
				var usrNm     = $("#usrNm").val();
				var usrPwd    = $("#usrPwd").val();
				
				
				//alert('usrNm : ' + usrNm);
				//alert('usrPwd : ' + usrPwd);
				
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
				
				
				$.post(
						"<c:url value='/McmCmnUsr001M04RP.do'/>", 
						{ 
							  "usrNm"  :  usrNm
							, "usrPwd" :  usrPwd						
						}, 
						function(responseText)
						{
							var rtnCode = responseText.rtnCode;
							var rtnMsg = responseText.rtnMsg;
							
							alert(rtnMsg);
							
							if(rtnCode == "000")
								$(location).attr("href", "<c:url value='/McmCmnLgn001M99RP.do'/>");
							
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
							<div class="aside_menu_back">정보내역 > <b>회원탈퇴</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>회원탈퇴 <small>| 해당사이트의 회원을 탈퇴합니다.</small></h3>
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
			                                           <h3>회원탈퇴 안내사항</h3>
			                                            <ul class="re_first">
			                                                <li class="sub_back" style="width:100%;">
			                                                1. 기존 아이디로 재가입이 불가능 합니다. <br />
			                                                &nbsp;&nbsp;회원 탈퇴를 신청하시면 해당 아이디는 즉시 탈퇴 처리되며, 이후 영구적으로 사용이 중지되므로 새로운 아이디로만 재가입이 가능 합니다.<br /><br />
			                                                2. 회원 정보 및 게시물 삭제 <br />
			                                                &nbsp;-&nbsp;계약 또는 청약철회 등에 관한 기록 : 5년 <br />
			                                                &nbsp;-&nbsp;대금결제 및 재화 등의 공급에 관한 기록 : 5년 <br />
			                                                &nbsp;-&nbsp;소비자의 불만 또는 분쟁처리에 관한 기록 : 5년 <br /><br />
			                                                &nbsp;*&nbsp;또한, 아래의 게시판형 서비스에 등록된 게시물은 탈퇴 후 에도 삭제 되지 않습니다.<br />
															&nbsp;&nbsp;게시물 등의 삭제를 원하시는 경우에는 반드시 직접 삭제하신 후, 탈퇴를 신청을 해 주시기 바랍니다.<br />
															&nbsp;-&nbsp;1:1문의 <br />
															&nbsp;-&nbsp;상품문의 <br />
															&nbsp;-&nbsp;상품후기 <br />
			                                                </li>
			                                            </ul>
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                         <div class="resize_box">
			                                           <h3>회원정보 확인</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back" style="width:16%;">아이디</li>
			                                                <li class="sub_back" style="width:auto;">${ mcmCmnUsr001VO.usrId }</li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">이름</li>
			                                                <li class="sub_back" style="width:auto;"><input type="text" name="usrNm"  id="usrNm"  /></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">비밀번호</li>
			                                                <li class="sub_back" style="width:auto;"><input type="password" name="usrPwd"  id="usrPwd"  /></li>
			                                            </ul>
			                                           
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> <a href="#;" id="btnSave">동의</a></div>
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