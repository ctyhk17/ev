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
				
				var bbsCnts = $("#bbsCnts").val();
				
				$('#btnList').click(function(){
					fnList();
		    	});
				$('#btnUpdate').click(function(){
					fnUpdate();
		    	});
				
			});		
			function fnList() {
				
				location.href="/McmCmnBbs006M31L.do?upMenuId=M003&subMenuId=M003004";
				
			}
			function fnUpdate(){
		    	
		    	var bbsSubJect = $("#bbsSbj").val();
		    	var bbsCnts = $("#bbsCnts").val();
		    	
	 	    	
		    	if(bbsSubJect.length == 0){
		    		alert('제목을 입력해주세요.');
		    		$("#bbsSbj").focus();
		    		return false;
		    	};
		    	if( bbsCnts == '' )  {
		               alert("내용을 입력하세요.");
		               $("#bbsCnts").focus();
		               return false;
		        };
		    	
	 	    	jQuery.ajaxSettings.traditional = true;
	 	    	$.post(
	 	    		"<c:url value='/McmCmnBbs006M34UP.do'/>",
	 	    		{
	 	    			"bbsSbj" : bbsSubJect,
	 	    			"bbsCnts" : bbsCnts,
	 	    			"bbsId" : $("#bbsId").val()
	 	    		},
	 	    		function(responseText){
	 	    			alert("수정 되었습니다.");
	 	    			fnList();
	 	    		},
	 	    		"json"
	 	    	)
	 	    	.done(function(){
	 	    		fnList();
	 	    	})
	 	    	.fail(function(){
	 	    		alert('수정에 실패하였습니다.');
	 	    	}); 
		    }
		
	</script>
    
	</head>

	<body>


<form:form commandName="mcmCmnBbs006VO" name="mcmCmnBbs006VO" method="post">
<form:hidden path="bbsId" value="${resultMap.bbsId }"/>
	
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
							<div class="aside_menu_back">고객센터 > <b>고객후기</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>고객센터 <small>| 고객후기을 입력하실 수 있습니다.</small></h3>
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
			                                           <h3>고객후기</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back" style="width:10%;">제목</li>
			                                                <li class="sub_back" style="width:70%;"><form:input type="text" path="bbsSbj" style="width:50%;" value="${resultMap.bbsSbj }"/></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:10%; padding: 88px 5px; vertical-align: 85px; ">고객후기</li>
			                                                <li class="sub_back" style="width:50%;">
			                                                	<textarea rows="10" cols="70" id="bbsCnts" name="bbsCnts"  ><c:out value="${resultMap.bbsCnts }" escapeXml="false" /></textarea>
			                                                </li>
			                                            </ul>
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                       <%-- 하단 버튼 시작 --%>   
			                                       <div class="save_button"> 
			                                       	<a href="#" id="btnUpdate">수정</a>
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