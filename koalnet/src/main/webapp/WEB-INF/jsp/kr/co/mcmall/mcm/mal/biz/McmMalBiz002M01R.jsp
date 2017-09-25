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
				
				$("#btnCopyUrl").attr('data-clipboard-action',document.location.href);
				var clipboard = new Clipboard('#btnCopyUrl');
				clipboard.on('success',function(e){
					alert('복사되었습니다.');
				});
				clipboard.on('error',function(e){
					console.log(e);
				});
				
				
				$("#btnSave").click(function() {	
					fn_Save();
				});
				
				$("#btnDelete").click(function(){
					fn_Delete();
				})
				
				$("#btnGoList").click(function() {	
					fn_GoList();
				});
				
				
				fncView( $("[name=resultList]") );

			});
			
			// 목록으로
			function fn_GoList(){
				$("#mcmMalBiz002VO").attr("action", "<c:url value='/McmMalBiz002M01L.do'/>");
				$("#mcmMalBiz002VO").submit();	
				
			}
			
			// 삭제
			function fn_Delete(){
				if(confirm("해당 홍보물을 삭제하시겠습니까?"))
				{
					var seqNo = $('#seqNo').val();
					
					$.post(
						"<c:url value='/McmMalBiz002M04DP.do'/>",
						{ "seqNo" : seqNo },
							function (responseText){
								alert("홍보물이 정상적으로 삭제되었습니다.");
								
							},
							"json"
					).done(function(){
						fn_GoList();
					}).fail(function(){
						alert("홍보물 삭제를 실패하였습니다.");
					});
				}
		}

			
			// 저장
			function fn_Save(){
				var itrCnts       = $("#itrCnts").val();
				var note          = $("#note").val();
				var lcsId         = $("#lcsId").val();
				var gdsId         = $("#gdsId").val();
				var seqNo         = $("#seqNo").val();
				var strId         = $("#strId").val();
				
				
				jQuery.ajaxSettings.traditional = true;
				$.post(
						"<c:url value='/McmMalBiz002M01UProc.do'/>", 
						{ 
							  "itrCnts"           : itrCnts
							, "note"              : note
							, "lcsId"             : lcsId
							, "gdsId"             : gdsId
							, "seqNo"             : seqNo
							, "strId"             : strId
						}, 
						function(responseText)
						{
							var rtnMsg = responseText.rtnMsg;
							alert("정상적으로 저장되었습니다.") 
							
						}, 
						"json"
				)
				.done(function() {
					fn_GoList();
 				})
				.fail(function() {
					alert( "등록되지 않은 상품입니다." );
				})
				;

			}
			
			
			
			
			
			
			
		</script>	
    
	</head>

	<body>


<form:form commandName="mcmMalBiz002VO" name="mcmMalBiz002VO" method="post">
	
	<form:hidden path="lcsId"/>
	<form:hidden path="gdsId"/>
	<form:hidden path="strId"/>
	<form:hidden path="seqNo"/>
	
	
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
							<div class="aside_menu_back">홍보관리 > 홍보물 관리 > <b>홍보물 조회</b></div>
							<%-- 페이지 네베게이션  끝--%>
			                    
							<div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
							<div class="content_1">
			                        
		                        <%-- 상단 타이틀 시작  --%>
		                        <div class="content_1_top">
		                            <h3>홍보물 조회 <small>| 홍보물 등록/조회 하실 수 있습니다.</small></h3>
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
			                                            <ul class="re_first" name="resultList"  lcsId="${mcmMalBiz002VO.lcsId}">
			                                                <li class="title_back" style="width:16%;">사업자 아이디</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${mcmMalBiz002VO.lcsId}"/></li>
			                                                <li class="title_back" style="width:16%;">사용자 아이디</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${mcmMalBiz002VO.usrId}"/></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">상점</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${mcmMalBiz002VO.strId}"/></li>
			                                                
			                                                <li class="title_back" style="width:16%;">상품</li>
			                                                <li class="sub_back" style="width:30%;"><c:out value="${mcmMalBiz002VO.gdsNm}"/></li>
			                                                
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">메모</li>
			                                                <li class="sub_back" style="width:30%;">
			                                               	    <form:input path="note" style="width:95%;"/>
			                                                </li>
			                                               <li class="title_back" style="width:16%;" >홍보물 URL</li>
			                                                <li class="sub_back" style="width:30%;">
			                                               
			                                                <a href="http://mall.mcbiz.co.kr/${selectResultInfo.seqNo}" id="btnCopyUrl" data-clipboard-action="copy" data-clipboard-target="#textBody"> 
			                                                	<textarea style="width:73%; vertical-align: -3px; border:none;resize:none;height:15px;overflow:hidden;"readonly="readonly" id="textBody">http://mall.mcbiz.co.kr/${selectResultInfo.seqNo}</textarea>
			                                                </a>
			                                                <button type="button" id="btnCopyUrl" data-clipboard-action="copy" data-clipboard-target="#textBody">복사</button>
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
				                                       <a href="#" id="btnSave">저장</a>
				                                       <a href="#" id="btnDelete">삭제</a>
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