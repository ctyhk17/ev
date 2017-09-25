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
		
			$(document).ready(function () {  

				
				
				
				$("#btnIdFind").click(function() {	
					fnIdFind();
				});
				
				$("#btnMalFind").click(function() {	
					fnMalFind();
				});
				
				$("#btnUpFind").click(function() {	
					fnUpFind();
				});
				
				$("#btnGoList").click(function() {	
					fnGoList();
				});
				
				$("#btnSave").click(function() {	
					fnSave();
				});
				
				
				
				fncView( $("[name=resultList]") );

			});
			
			// 목록으로
			function fnGoList(){
				$("#mcmMalBiz002VO").attr("action", "<c:url value='/McmMalBiz002M01L.do'/>");
				$("#mcmMalBiz002VO").submit();				
			}
			
			function fnIdFind(){
				var win = window.open("<c:url value='/McmMalBiz001P03C.do'/>", "callback", "toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=550, height=550, top=0,left=20");
			}
			
			function fnMalFind(){
				var win = window.open("<c:url value='/McmMalBiz001P04C.do'/>", "callback", "toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=550, height=550, top=0,left=20");
			}
			
			function fnUpFind(){
				var win = window.open("<c:url value='/McmMalBiz001P05C.do'/>", "callback", "toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=550, height=550, top=0,left=20");
			}
			
			function fnSave(){
				var lcsId       = $("#lcsId").val();
				var strId       = $("#strId").val();
				var gdsId       = $("#gdsId").val();
				var note        = $("#note").val();
				var itrCnts     = $("#itrCnts").val();
				var seqNo       = $("#seqNo").val();
				var brcUrlAddr  = $("#brcUrlAddr").val();
				
				/* if(usrId.length==0){
					alert('ID를 입력해주세요.')
					$("#usrId").focus();
					return;
				}; */
				
				jQuery.ajaxSettings.traditional = true;
				$.post(
			    		"<c:url value='/McmMalBiz002M03CP.do'/>",
			    		{
			    			"lcsId"      : lcsId,
			    			"strId"      : strId,
			    			"gdsId"      : gdsId,
			    			"note"       : note,
			    			"itrCnts"    : itrCnts,
			    			"seqNo"      : seqNo,
			    			"brcUrlAddr" : brcUrlAddr
			    		},
			    		function(responseText){
			    			alert("홍보물이 등록 되었습니다.")
			    		},
			    		"json"
			    	)
			    	.done(function(){
			    		fnGoList();
			    	})
			    	.fail(function(){
			    		alert('홍보물 등록에 실패하였습니다.');
			    	});
			}
			
			
			
			
		</script>	
    
	</head>

	<body>


<form:form commandName="mcmMalBiz002VO" name="mcmMalBiz002VO" method="post">
	<form:hidden path="brcUrlAddr"/>
	<form:hidden path="usrId"/>
	<form:hidden path="lcsId"/>
	
	
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
							<div class="aside_menu_back">홍보관리 > 홍보물 관리 > <b>홍보물 등록</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>홍보물 등록 <small>| 홍보물 등록/조회 하실 수 있습니다.</small></h3>
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
			                                                <li class="title_back" style="width:16%;">사업자 코드</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="lcsId" readonly="true" style="border:none;"/>
			                                                </li>
			                                                 <li class="title_back" style="width:16%;">노트</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="note" placeholder="* 메모를 남겨주세요"/>
			                                                </li>
			                                                
			                                              <%--   <li class="title_back" style="width:16%;">사용자 아이디</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${ usrId}"/>
			                                                </li> --%>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">상점</li>
			                                                <li class="sub_back" style="width:30%;"><form:input path="strId" readonly="true" style="border:none;"/>
			                                                	<!-- <a href="#" id="btnMalFind" style="background-color:#f29d06; color:white; font-size:12px; padding:8px; font-weight:bold;">상점찾기</a> -->
			                                                </li>
			                                                <li class="title_back" style="width:16%;">상품</li>
															
			                                                <li class="sub_back" style="width:15%;">
				                                                <form:select path="gdsId" style="width:90%;">
				                                                		<form:option value="">선택</form:option>
				                                                	<c:forEach var="gdsList" items="${selectGdsList}">
				                                                		<form:option value="${gdsList.gdsId}">${gdsList.gdsNm}</form:option>
				                                                	</c:forEach>
			                                                </form:select>	
			                                                 </li>
			                                            </ul>
			                                            
			                                        	 <ul>
			                                                <li class="title_back" style="width:16%; padding:88px 5px; vertical-align:86px;">인사말</li>
			                                                <li class="sub_back" style="width:30%;">
			                                                	<form:textarea path="itrCnts" rows="10" style="width:275%; height:180px;"/>
			                                                </li>
			                                                
			                                            </ul>
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        <!-- <div class="suchen"><a href="#" class="suchen_a">검색</a></div> -->
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button">
														<a href="#" id="btnSave">등록</a>
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