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
	    		 
	    		$('#btnImg').click(function(){
	    			fnImgPopup();
	    		});
	    		
	    		$('#btnImg2').click(function(){
	    			fnImgPopup2();
	    		})
	    		
	    		$('#btnUpdate').click(function(){
	    			fnInfoUpdate();
	    		});
	    		
	    		$('#btnBasicGo').click(function(){
	    			$("#McmMalGds001VO").attr("target", "");
					$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M04U.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    		$('#btnDetailGo').click(function(){
	    			$("#McmMalGds001VO").attr("target", "");
	    			$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M14U.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    		$('#btnKeywordGo').click(function(){
	    			$("#McmMalGds001VO").attr("target", "");
	    			$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M24U.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    		
	    	});
	    	
	    	function fnInfoUpdate(){
	    		$("#McmMalGds001VO").attr("target", "");  
	    		var gdsId = $('#gdsId').val();
	    		var gdsNm = $('#gdsNm').val();
	    		var gds001002 = $('#gds001002').val();
	    		var gds001001 = $('#gds001001').val();
	    		var gdsAttSnImg = $('#gdsAttSnImg').val();
	    		var gdsAttSnImgPath = $('#gdsAttSnImgPath').val();
	    		var gdsAttMnImg = $('#gdsAttMnImg').val();
	    		var gdsAttImgPath = $('#gdsAttImgPath').val();
	    		var gds001004 = $('input[type=radio]:checked').val();
	    		var gds001005 = $('#gds001005').val();
	    		var gds001003 = $('#gds001003').val();
	    		var cd = $('#cd').val();
	    		jQuery.ajaxSettings.traditional = true;
				$.post(
						"<c:url value='/McmMalGds001M04UP.do' />",
						{
							 "gdsId":gdsId
							,"gdsNm":gdsNm
							,"gds001002":gds001002
							,"gds001001":gds001001
							,"gdsAttSnImg":gdsAttSnImg
							,"gdsAttImgPath":gdsAttImgPath
							,"gdsAttMnImg":gdsAttMnImg
							,"gdsAttSnImgPath":gdsAttSnImgPath
							,"gds001004":gds001004
							,"gds001005":gds001005
							,"gds001003":gds001003
							,"cd":cd
						},
						function(result){
							alert("수정완료 되었습니다.");
						},"json"
					  ).done(function(){
			    			$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M01L.do'/>");
							$("#McmMalGds001VO").submit();
					  }).fail(function(){
						  alert("상품 수정을 실패하였습니다.");
					  })
	    	}
	    	
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
		</script>
	</head>    
<body>
	<form:form commandName="McmMalGds001VO" name="McmMalGds001VO" method="post">
		<form:hidden path="gdsId" />
		<form:hidden path="gdsAttSnImg" />
		<form:hidden path="gdsAttSnImgPath" />
		<form:hidden path="gdsAttMnImg" />
		<form:hidden path="gdsAttImgPath" />
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
			                            <h3>상품 등록 <small>| 쇼핑몰의 기본적인 상품을 수정 할 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                        <div class="pointer_cap">
			                        	<div class="pointer pointer_active" id="basicSetTab"><a href="#" id="btnBasicGo" style="color:black">기본 설정</a></div>
			                        	<div class="pointer" id="detailSetTab"><a href="#" id="btnDetailGo" style="color:black" >상세 설명</a></div>
			                        	<div class="pointer" id="keywordSetTab"><a href="#" id="btnKeywordGo" style="color:black" >키워드</a></div>
			                        </div>
			                        
			                        <div class="content_1_1" id="basicSet">
                            			<div class="tab tab_1 tab_1_active">
                                    		<div class="tab_line tab_1_1">
						                        <div class="resize_box">
			                                           <h3>기본설정</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">상품코드</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 0px; width: 22%;">
			                                                    <p class="first_text">* 이미 생성된 코드입니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">상품명</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align:2px;width:22%;">
			                                                	<form:input path="gdsNm" style="width: 95%;" />
			                                                </li>
			                                                
                                                             <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">수량</li>
			                                                <li class="sub_back_p sub_back_b" style="  width: 20%;vertical-align: 2px;">
			                                                	<form:input path="gds001002" /> 개
			                                                </li>
			                                            </ul>
			                                            
			                                            <ul>
			                                
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">회원판매가</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;width:22%;">
			                                                    <form:input path="gds001001" /> 원
			                                                </li>
			                                               
	                                                        <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">일반판매가</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;width:22%;">
			                                                	<form:input path="gds001003" /> 원
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">할인판매가</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;">
			                                                    <form:input path="gds001005" /> 원
			                                                </li>
			                                            </ul>
			                                            
			                                            <ul>
                                            	           <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">할인판매여부</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px; width:22%;">
			                                                	<form:radiobutton path="gds001004" label="유" value="Y" />
			                                                	<form:radiobutton path="gds001004" label="무" value="N" />
			                                                </li>
			                                            	<li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">사업자코드</li>
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;width: 22%;">
			                                                	<form:select path="lcsId">
			                                                		<form:option value="">선택하세요</form:option>
			                                                		<c:forEach var ="resultList" items="${resultList}">
			                                                			<form:option value="${resultList.lcsId}">${resultList.lcsId}</form:option>
			                                                		</c:forEach>
			                                                	</form:select>
			                                                </li>
															<li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;">카테고리</li>			                                                
			                                                <li class="sub_back_p sub_back_b" style="vertical-align: 2px;width:20%;">
			                                                	<form:select path="cd">
			                                                		<form:option value="" label="선택하세요" />
			                                                		<c:forEach var ="cdResultList" items="${cdResultList}">
			                                                			<form:option value="${cdResultList.cd}" label="${cdResultList.cdNm}" />
			                                                		</c:forEach>
			                                                	</form:select>
			                                                </li>
			                                            </ul>    
														<ul>
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;padding:115px 5px;vertical-align:7px;">이미지</li>
			                                                <li class="sub_back_p sub_back_b" style=" width: 30%;position:relative;vertical-align:-80px;">
			                                                   <form:input path = "gdsImgNm2" readonly="true" />
			                                                     <a href="#" id="btnImg2">찾아보기</a>
			                                                    <p class="first_text">* 메인 이미지사이즈는 가로 204 * 세로 204 픽셀로 생성하여 등록하여 주십시오.</p>
			                                                    <img id = "parentImgBox2" src ="<c:url value='/McmGdsMnImg.do?gdsId=${resultMap.gdsId }&divCd=1' />" style="width: 235px!important; position: absolute;top: -165px;left: 55px;max-height:140px;" />
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;text-align:center;padding:115px 5px;vertical-align:7px;">이미지</li>
			                                                <li class="sub_back_p sub_back_b" style=" width: 30%;position:relative;vertical-align:-80px;">
			                                                   <form:input path = "gdsImgNm" readonly="true" />
			                                                     <a href="#" id="btnImg">찾아보기</a>
			                                                    <p class="first_text">* 썸네일 이미지사이즈는 가로 204 * 세로 204 픽셀로 생성하여 등록하여 주십시오.</p>
			                                                    <img id = "parentImgBox" src ="<c:url value='/McmGdsMnImg.do?gdsId=${resultMap.gdsId }&divCd=2' />" style="width: 235px!important; position: absolute;top: -165px;left: 55px;max-height:140px;" />
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