<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmCmnAth001M01L.jsp
  * @Description : 조합원 리스트 화면
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
	    		$( "#endDtSearch" ).datepicker().mask("9999-99-99");
				$( "#stDtSearch" ).datepicker().mask("9999-99-99");
				
	    		$('#btnSeachList').click(function(){
					fnSearchList();
				});
	    		
	    		$('#btnCtrInsert').click(function(){
	    			fnCtrInsert();
	    		});
	    		
	    		$('#btnCtrDelete').click(function(){
	    			fnCtrDelete();
	    		})
	    		fnCtrUpdate($("[name=resultList]"));
	    	});
	    	
	    	function fnCtrUpdate(obj){
	    		obj.css("cursor","pointer").click(function(){
					$('#cd').val($(this).attr("cd"));
					$('#cdNm').val($(this).attr("cdNm"));
					$('#cdEtc').val($(this).attr("cdEtc"));
					$("#McmCmnCtr001VO").attr("action", "<c:url value='/McmCmnCtr001M04U.do'/>");
					$("#McmCmnCtr001VO").submit();	
				});
	    	}
	    	
	    	
	    	function fnCtrDelete(){
	       		if($("input[type='checkbox']:checked").length == 0){
	    			alert("체크를 한 후 진행해주세요.");
	    			return;
	       		}else{
	       			if(confirm("선택항목을 삭제하시겠습니까?"))
	       				{
	       					var checkCtr = new Array();
	       					
	       					$('.checkCtr:checked').each(function(){
	       						checkCtr.push($(this).val());
	       					});
	       				}
	       			jQuery.ajaxSettings.traditional = true;
					 $.post(
							"<c:url value='/McmCmnCtr001M05DP.do' />",
							{
								"checkCtr":checkCtr
							},
							function(result){
								alert("삭제되었습니다.");
							},"json"
							).done(function(){
								document.location.reload();
							}).fail(function(){
								alert("삭제 실패하였습니다.");
								document.location.reload();
							}) 
	       		}
	       		
	       		
	    	};
	    	
	    	function fnCtrInsert(){
				location.href="/McmCmnCtr001M03C.do?upMenuId=M010&subMenuId=M010007";
	    	};
	    	
	    	function fnSearchList(){
				$("#pageIndex").val("1");
				
				$("#McmCmnCtr001VO").attr("action", "<c:url value='/McmCmnCtr001M01L.do'/>");
				$("#McmCmnCtr001VO").submit();
			}
			
			function fncLinkPage(pageNo){
				$("#pageIndex").val(pageNo);
				
				$("#McmCmnCtr001VO").attr("action", "<c:url value='/McmCmnCtr001M01L.do'/>");
				$("#McmCmnCtr001VO").submit();
			};
		</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="McmCmnCtr001VO" name="McmCmnCtr001VO" method="post">
	<form:hidden path="cd" />
	<form:hidden path="cdNm" />
	<form:hidden path="cdEtc" />
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
			                    <div class="aside_menu_back">시스템설정 > <b>카테고리관리</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>카테고리관리 <small>| 카테고리 관리 하실 수 있습니다.</small></h3>
			                        </div>
			                        
			                        <div class="content_1_1">
			                             <div class="tab tab_1 tab_1_active">
			                                    <div class="tab_line tab_1_1"> 
			                                        <%-- 검색조건 시작 --%>
													<div class="resize_box">
				                                            <ul class="re_first">
			                                                <li class="title_back" style="width:10%;text-align: center;">카테고리ID</li>
			                                                <li class="sub_back" style="width:15%;">
			                                                	<form:input path="ctrSearch" />
			                                                </li>
			                                                
			                                                <li class="title_back" style="width:10%;text-align: center;">카테고리명</li>
			                                                <li class="sub_back" style="width:15%;">
			                                                	<form:input path="cdNmSearch" />
			                                                </li>
                                                           <li class="title_back" style="width:10%;text-align: center;">등록일/수정일</li>
			                                                <li class="sub_back">
			                                               		 <form:input path="stDtSearch" style="text-align:center;" /> ~ <form:input path="endDtSearch" style="text-align:center;"/>
			                                                </li>
			                                            </ul>
													</div>
				                                    <%-- 검색조건 종료 --%>
													<div class="suchen">
				                                                <a href="#" class="suchen_a" id="btnSeachList">검색</a>
				                                    </div>
			                                        <div class="line_class"></div>
			                                        
			                                        
			                                        
			                                        
			                                        <%-- ========================================== --%>
			                                       <%-- 본문 시작 --%>
			                                       <%-- ========================================== --%>
			                                        <div class="suchen_result_cap">
			                                        
			                                        
				                                        <div class="suchen_result"> 전체 <b><c:out value="${totCnt}" /></b></b>건</div>
					                                        <div>
					                                            <div class="flex first_flex">
					                                                <ul>
					                                                	<li style="width:5%;"></li>
					                                                	 <li style="width:8%;">번호</li>
					                                                    <li style="width:18%;">카테고리ID</li>
					                                                    <li style="width:35%;">카테고리명</li>
					                                                    <li style="width:18.099999%;">상품등록건수</li>
					                                                    <li style="width:15%;">등록일/수정일</li>
					                                                </ul>
					                                            </div>
					                                            	<c:forEach var="resultList" items="${resultList}">
					                                            	<div class="flex flex_2">
																		<ul>
																		  <li style="width:5%; padding:15px 0px;">
						                                                    	<form:checkbox path="checkCtr" value="${resultList.cd}" class="checkCtr" />
						                                                    </li>
						                                                    <li style="width:8%; padding:15px 0px;">
						                                                    	<c:out value="${resultList.rn}" />
						                                                    </li>
						                                                    <li style="width:18%; padding:15px 0px;" name="resultList" cd="${resultList.cd}" cdNm="${resultList.cdNm}" cdEtc="${resultList.cdEtc }">
						                                                    	<c:out value="${resultList.cd}" />
						                                                    </li>
						                                                    <li style="width:35%; padding:15px 0px;" name="resultList" cd="${resultList.cd}" cdNm="${resultList.cdNm}" cdEtc="${resultList.cdEtc }">
						                                                    	<c:out value="${resultList.cdNm}" />
						                                                    </li>
						                                                    <li style="width:18.099999%; padding:15px 0px;">
						                                                    	<c:out value="${resultList.cnt}" />
																			</li>
						                                                    <li style="width:15%; padding:15px 0px;">
						                                                    	<c:out value="${resultList.lstUdtDt}" />
						                                                    </li>
						                                                    
						                                                </ul>
					                                            	</div>
					                                            	</c:forEach>
						                                         <c:if test="${ empty resultList }" >
					                                            	<div class="flex flex_2" >
						                                                <ul>
						                                                    <li style="width: 99%;">조회 결과가 없습니다.</li>
						                                                </ul>
						                                        	</div>
					                                            </c:if>
						                                        <div class="flex last_flex">
					                                            </div>
<!-- 					                                            페이지 네비게이션 시작 -->
					                                 			<div class="next">
					                                            	<ul>
														        		<ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fncLinkPage" />
														        		<form:hidden path="pageIndex" />
														        	</ul>
													           </div>
													              <div class="save_button">
													           	<a href="#" id = "btnCtrInsert">등록</a>
													           	<a href="#" id = "btnCtrUpdate">수정</a>
													           	<a href="#" id = "btnCtrDelete">삭제</a>
													           </div>
													          </div>
				                                        </div>
			                                        
											</div><!-- End of tab_1_1 -->
										</div>
									</div>
								</div>
						</div><!-- End of content -->
	              </div><!-- End of aside -->
              </div><!-- End of aside_back -->
          </div><!-- End of article_cap -->
		</article>




		<footer>
		    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminFooterInclude.jsp" %>
		</footer><!-- End of footer -->
	
</form:form>
	
	</body><!-- End of body -->

</html>