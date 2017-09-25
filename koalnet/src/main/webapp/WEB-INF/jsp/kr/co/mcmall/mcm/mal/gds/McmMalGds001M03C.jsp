<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmMalGds001M001L.jsp
  * @Description : 상품 리스트
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
		    		$('#btnCancle').click(function(){
		    			$("#McmMalGds001VO").attr("target", "");  
		    			$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M01L.do'/>");
						$("#McmMalGds001VO").submit();
		    		});
	    		
		    		$('#btnSave').click(function(){
		    			fnSave();
		    		});
		    		
		    		$('#btnImg').click(function(){
		    			fnImgPopup();
		    		})
		    		$('#btnImg2').click(function(){
		    			fnImgPopup2();
		    		})
		    		
				});
	    		function fnImgPopup()
	    		{
	    			var title  = "testpop";
					var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=400, height=350, top=0,left=20"; 
					window.open("", "testpop",status); 
					 
					 $("#McmMalGds001VO").attr("target", "testpop");  
					 $("#McmMalGds001VO").attr("action", "<c:url value='/McmMalGds001P03C.do'/>"); 
					 $("#McmMalGds001VO").attr("method", "post"); 
					 $("#McmMalGds001VO").submit();
	    			
	    		}
	    		function fnImgPopup2()
	    		{
	    			var title  = "testpop";
					var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=400, height=350, top=0,left=20"; 
					window.open("", "testpop",status); 
					 
					 $("#McmMalGds001VO").attr("target", "testpop");  
					 $("#McmMalGds001VO").attr("action", "<c:url value='/McmMalGds001P13C.do'/>"); 
					 $("#McmMalGds001VO").attr("method", "post"); 
					 $("#McmMalGds001VO").submit();
	    			
	    		}
	    	
	    	
						function fnSave() {
							$("#McmMalGds001VO").attr("target", "");
							var gdsNm = $("#gdsNm").val();
							var gds001002 = $("#gds001002").val();
							var gds001001 = $("#gds001001").val();
							var gdsAttSnImg = $('#gdsAttSnImg').val();
							var gdsAttSnImgPath = $('#gdsAttSnImgPath').val();
							var gdsAttMnImg = $('#gdsAttMnImg').val();
							var gdsAttImgPath = $('#gdsAttImgPath').val();
							var lcsId = $('#lcsId').val();
							var gds001003 = $('#gds001003').val();
							var gds001005 = $('#gds001005').val();
							var gds001004 = $('input[type=radio]:checked').val();
							var gdsId="";
							var cd = $('#cd').val();
							
							
							if(gdsNm == null || gdsNm.length == 0){
								alert("상품명을 입력해주세요.");
								return;
							}
							if(gds001002 == null || gds001002.length == 0){
								alert("수량을 입력해주세요.");
								return;
							}
							if(gds001001 == null || gds001001.length == 0){
								alert("가격을 입력해주세요.");
								return;
							}
							if(gdsAttMnImg == null || gdsAttMnImg.length == 0){
								alert("메인 이미지를 입력해주세요.");
								return;
							}
							if(gdsAttSnImg == null || gdsAttSnImg.length == 0){
								alert("썸네일 이미지를 선택해주세요.");
								return;
							}
							if(lcsId == null || lcsId.length == 0){
								alert("사업자코드를 선택해주세요. ");
								return;
							}
							
							if(cd == null || cd.length == 0 ){
								alert("카테고리를 선택해주세요.");
								return;
							}
							
							jQuery.ajaxSettings.traditional = true;
							$.post(
											"<c:url value='/McmMalGds001M03CP.do'/>",
											{
												"gdsNm" : gdsNm,
												"gds001001" : gds001001,
												"gds001002" : gds001002,
												"gdsAttSnImg" : gdsAttSnImg,
												"gdsAttMnImg" : gdsAttMnImg,
												"gdsAttImgPath":gdsAttImgPath,
												"gdsAttSnImgPath":gdsAttSnImgPath,
												"lcsId":lcsId
												,"gds001003":gds001003
												,"gds001004":gds001004
												,"gds001005":gds001005
												,"cd":cd
											}, function(responseText) {
												alert("상품을 설정하셨습니다");
											}, "json")
									.done(function(result) {
										gdsId = result.McmMalGds001VO.gdsId;
										$('#gdsId').val(gdsId);
										fnResult();
											}).fail(function() {
										alert("상품설정을 실패하셨습니다.");
									});
						};
						function fnResult(){
							 $("#McmMalGds001VO").attr("target", "");   
							$('#McmMalGds001VO').attr("action","<c:url value='/McmMalGds001M13C.do'/>");
							$('#McmMalGds001VO').submit();
						}
						
					</script>
	</head>    
	<style>
	.pointer{
		cursor: default !important;
	}	
	.pointer:hover{
	background-color: #eeeeee !important;
	}
	</style>
<body>
	<form:form commandName="McmMalGds001VO" name="McmMalGds001VO" method="post">
		<form:hidden path="gdsAttSnImg" />
		<form:hidden path="gdsAttSnImgPath" />
		<form:hidden path="gdsAttMnImg" />
		<form:hidden path="gdsAttImgPath" />
		<form:hidden path="gdsId" />
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
			                    <div class="aside_menu_back">상품 > 상품관리 > <b>상품관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    <div class="content_1">
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>상품 등록 <small>| 쇼핑몰의 기본적인 상품등록을 할 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                        <div class="pointer_cap">
			                        	<div class="pointer pointer_active" id="basicSetTab"><a href="#" id="btnBasicGo" style="color:black">기본 설정</a></div>
			                        	<div class="pointer" id="detailSetTab" style="">상세 설명</a></div>
			                        	<div class="pointer" id="keywordSetTab">키워드</a></div>
			                        </div>
			                        
			                        <div class="content_1_1" id="basicSet">
                            			<div class="tab tab_1 tab_1_active">
                                    		<div class="tab_line tab_1_1">
						                        <div class="resize_box">
			                                           <h3>기본설정</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">상품코드</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 0px; width: 22%;">
			                                                    <p class="first_text">* 상품 등록시 자동 생성됩니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">상품명</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;width:22%;">
			                                                	<form:input path="gdsNm" style="width: 95%;" />
			                                                </li>
			                                                
		                                                    <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">수량</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 20%;"">
			                                                	<form:input path="gds001002" /> 개
			                                                </li>
			                                               
			                                            </ul>
			                                            
			                                            <ul>
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">회원판매가</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;width:22%;">
			                                                    <form:input path="gds001001" /> 원
			                                                </li>
			                                                
	                                                      <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">일반판매가</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;">
			                                                	<form:input path="gds001003" /> 원
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">할인판매가</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;">
			                                                    <form:input path="gds001005" /> 원
			                                                </li>
			                                               
			                                            </ul>
			                                            <ul>
                                            	           <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">할인판매여부</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width: 22%;">
			                                                	<form:radiobutton path="gds001004" label="유" value="Y" />
			                                                	<form:radiobutton path="gds001004" label="무" value="N" checked="checked"/>
			                                                </li>
			                                            	<li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">사업자코드</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;width: 22%;">
			                                                	<form:select path="lcsId">
			                                                		<form:option value=""  label="선택하세요" />
			                                                		<c:forEach var ="resultList" items="${resultList}">
			                                                			<form:option value="${resultList.lcsId}" label="${resultList.lcsId}" />
			                                                		</c:forEach>
			                                                	</form:select>
			                                                </li>
			                                                
															<li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">카테고리</li>			                                                
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;">
			                                                	<form:select path="cd">
			                                                		<form:option value="" label="선택하세요" />
			                                                		<c:forEach var ="cdResultList" items="${cdResultList}">
			                                                			<form:option value="${cdResultList.cd}" label="${cdResultList.cdNm}" />
			                                                		</c:forEach>
			                                                	</form:select>
			                                                </li>
			                                            </ul>    
														<ul>
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">이미지</li>
			                                                <li class="sub_back_p sub_back_b" style=" width: 35%;">
			                                                   <form:input path = "gdsImgNm2" readonly="true" />
			                                                     <a href="#" id="btnImg2">찾아보기</a>
			                                                    <p class="first_text">* 메인 이미지사이즈는 가로 204 * 세로 204 픽셀로 생성하여 등록하여 주십시오.</p>
			                                                </li>
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">이미지</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                   <form:input path = "gdsImgNm" readonly="true" />
			                                                     <a href="#" id="btnImg">찾아보기</a>
			                                                    <p class="first_text">* 썸네일 이미지사이즈는 가로 204 * 세로 204 픽셀로 생성하여 등록하여 주십시오.</p>
			                                                </li>
			                                            </ul>
			                                    </div><!-- resize_box -->
                              			<div class="save_button">
                              				<a href="#" id="btnSave">저장</a>
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