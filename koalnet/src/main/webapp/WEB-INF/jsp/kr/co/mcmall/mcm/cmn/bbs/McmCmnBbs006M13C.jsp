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
    
    	<script type="text/javascript">
			$(document).ready(function(){
				$('#btnList').click(function(){
					fnList();
		    	});
				$('#btnWrite').click(function(){
					fnWrite();
		    	});
				
			});		
			function fnList() {
				
				location.href="/McmCmnBbs006M11L.do?upMenuId=M003&subMenuId=M003002";
				
			}
			function fnWrite(){
		    	
		    	var bbsFaqCnts1 = $("#bbsFaqCnts1").val();
		    	var bbsFaqCnts2 = $("#bbsFaqCnts2").val();
		    	
	    		var checkPotNo = new Array();
	    		
				
				var usrId = $("#usrId").val();
				var strId = $("#strId").val();
	 	    	
		    	if(bbsFaqCnts1.length == 0){
		    		alert('질문을 입력해주세요.');
		    		$("#bbsFaqCnts1").focus();
		    		return false;
		    	};
		    	if( bbsFaqCnts2 == '' )  {
	               alert("답변을 입력하세요.");
	               $("#bbsFaqCnts2").focus();
	               return false;
		        };
		    	
	 	    	jQuery.ajaxSettings.traditional = true;
	 	    	$.post(
	 	    		"<c:url value='/McmCmnBbs006M13CP.do'/>",
	 	    		{
	 	    			"bbsFaqCnts1" : bbsFaqCnts1,
	 	    			"bbsFaqCnts2" : bbsFaqCnts2,
	 	    			"bbsOpn" : $("#bbsOpn").val()
	 	    			
	 	    		},
	 	    		function(responseText){
	 	    			alert("등록 되었습니다.");
	 	    			fnList();
	 	    		},
	 	    		"json"
	 	    	)
	 	    	.done(function(){
	 	    		fnList();
	 	    	})
	 	    	.fail(function(){
	 	    		alert('등록에 실패하였습니다.');
	 	    	}); 
		    }
		
	</script>
    
	</head>

	<body>


<form:form commandName="mcmCmnBbs006VO" name="mcmCmnBbs006VO" method="post">
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
							<div class="aside_menu_back">고객센터 > 1:1 문의 > <b>1:1 문의하기</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>1:1 문의 <small>| 1:1상담을 입력하실 수 있습니다.</small></h3>
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
			                                                <li class="title_back" style="width:10%;">구분</li>
			                                                <li class="sub_back" style="width:80%;">
			                                                	<form:select path="bbsOpn" style="width:90%;">
			                                                		<form:option value="">선택</form:option>
			                                                	<c:forEach var="cdList" items="${cdList}">
			                                                		<form:option value="${cdList.cd}">${cdList.cdNm}</form:option>
			                                                	</c:forEach>
			                                                </form:select>	
			                                                </li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:10%; padding: 88px 5px; vertical-align: 85px; ">FAQ(질문)</li>
			                                                <li class="sub_back" style="width:80%;">
			                                                	<form:textarea rows="10" cols="70" path="bbsFaqCnts1" />
			                                                </li>
			                                            </ul>			                                         
			                                            <ul>
			                                                <li class="title_back" style="width:10%; padding: 88px 5px; vertical-align: 85px; ">FAQ(답변)</li>
			                                                <li class="sub_back" style="width:80%;">
			                                                	<form:textarea rows="10" cols="70" path="bbsFaqCnts2" /> 
			                                                </li>
			                                            </ul>
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                       <%-- 하단 버튼 시작 --%>   
			                                       <div class="save_button"> 
			                                       	<a href="#" id="btnWrite">저장</a>
			                                       	&nbsp;
			                                       	 <a href="#" id="btnList">목록</a>
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