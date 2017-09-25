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
		<script type="text/javascript"  src="<c:url value='/js/clipboard.js' />"></script>
    
    
    	<script type="text/javascript">
		
			$(document).ready(function () {  

				$("#btnUpAdd").click(function(){
					fnUpAdd();
				})
				
				
				$("#btnCopyUrl").attr('data-clipboard-action',document.location.href);
				
				var clipboard = new Clipboard('#btnCopyUrl');
				clipboard.on('success',function(e){
					alert('복사되었습니다.');
				});
				clipboard.on('error',function(e){
					console.log(e);
				});
				
				
				
				$("#btnUpdate").click(function() {
					$("#mcmMalBiz001VO").attr("action", "<c:url value='/McmMalBiz001M04U.do'/>");
					$("#mcmMalBiz001VO").submit();	
				});
				
				
				$("#btnGoList").click(function() {	
					fnGoList();
				});

			});
			
			
			// 목록으로
			function fnGoList(){
				$("#mcmMalBiz001VO").attr("target","");
				$("#mcmMalBiz001VO").attr("action", "<c:url value='/McmMalBiz001M01L.do'/>");
				$("#mcmMalBiz001VO").submit();				
			}
			
			function fnUpAdd(){
				var title  = "addPopup";
				var status = "toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=640, height=650, top=0,left=20";
				window.open("","addPopup",status);
				
				$("#mcmMalBiz001VO").attr("target","addPopup");
				$("#mcmMalBiz001VO").attr("action","<c:url value='/McmMalBiz001P03R.do'/>");
				$("#mcmMalBiz001VO").attr("method","post");
	    		$("#mcmMalBiz001VO").submit();
			}
			
			


			
			
			
			
			
		</script>	
    
	</head>

	<body>


<form:form commandName="mcmMalBiz001VO" name="mcmMalBiz001VO" method="post">
	
	<form:hidden path="upLcsId"/>
	<form:hidden path="lcsId"/>
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
							<div class="aside_menu_back">홍보관리 > 사업자 관리 > <b>사업자 조회</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>사업자 조회 <small>| 사업자를 등록/조회 하실 수 있습니다.</small></h3>
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
			                                            <ul class="re_first" name="resultList" >
			                                                <li class="title_back" style="width:16%;">사업자 구분코드</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${selectResultInfo.lcsId}"/></li>
			                                                <li class="title_back" style="width:16%;">사업자 연락처</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${selectResultInfo.telNo}"/></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사업자 아이디</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${selectResultInfo.usrId}"/></li>
			                                                <li class="title_back" style="width:16%;">상점 아이디</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${selectResultInfo.strId}"/></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사업자 이름</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${selectResultInfo.usrNm}"/></li>
			                                                <li class="title_back" style="width:16%;">팀장</li>
			                                                <li class="sub_back" style="width:30%;">
																<a href="#" id="btnUpAdd" style="background-color:#f29d06; color:white; font-size:12px; padding:8px; font-weight:bold;"> 등록/수정하기</a>
															</li>
			                                            </ul>
			                                            <br/>
			                                           <ul>
			                                                <li class="title_back" style="width:99.1%;border-top: 1px solid black;text-align:center;">팀장 상세</li>
			                                            </ul>
			                                            <ul style="padding:10px; background-color: #eeeeee;">
			                                                <li class="sub_back" style="width:25%; text-align:center;">구분코드</li>
			                                                <li class="sub_back" style="width:28%; text-align:center;">아이디</li>
			                                                <li class="sub_back" style="width:19%; text-align:center;">이름</li>
			                                                <li class="sub_back" style="width:25%; text-align:center;">연락처</li>
			                                            </ul>
			                                            
			                                            <c:forEach var="resultList" items="${resultList}">
			                                            <ul style="padding:10px;" lcsId="${resultList.lcsId}">
			                                                <li class="sub_back" style="width:25%; text-align:center;"><c:out value="${resultList.lcsId}"/></li>
			                                                <li class="sub_back" style="width:28%; text-align:center;"><c:out value="${resultList.usrId}"/></li>
			                                                <li class="sub_back" style="width:19%; text-align:center;"><c:out value="${resultList.usrNm}"/></li>
			                                                <li class="sub_back" style="width:25%; text-align:center;"><c:out value="${resultList.telNo}"/></li>
			                                                
			                                            </ul>
			                                            </c:forEach>
			                                         
			                                              <c:if test="${empty resultList}">
					                                            <div class="flex flex_2">
						                                            <ul>
						                                            	<li style="width:100%;">조회 된 팀장이 없습니다.</li>
						                                            </ul>
					                                            </div>
				                                            </c:if>
			                                            
			                                         
			                                            
			                                            
			                                            
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        <!-- <div class="suchen"><a href="#" class="suchen_a">검색</a></div> -->
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> 
				                                       <!-- <a href="#" id="btnUpdate">수정</a> -->
				                                       <a href="#" id="btnGoList">취소</a>
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