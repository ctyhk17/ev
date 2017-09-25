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
	    		$( "#stProdDt" ).datepicker().mask("9999-99-99");
				$( "#endProdDt" ).datepicker().mask("9999-99-99"); 
	    		
	    		$('#btnProdDelete').click(function(){
	    			fnProdDelete();
	    		});
	    		
	    		$('#btnProdInsert').click(function(){
	    			fnProdInsert();
	    		});
	    		
	    		$('#btnSeachList').click(function(){
	    			fnSeachList();
	    		});
	    		$('#btnProdUp').click(function(){
	    			fnProdUp();
	    		});
	    		$('#btnProdDown').click(function(){
	    			fnProdDown();
	    		});
	    		
	    		
				fnInfoView($("[name=resultList]"));	    		
	    	});
	    	
	    	function fnProdDown(){
	    		
	    		if($("input[type='checkbox']:checked").length == 0){
	    			alert("체크를 한 후 진행해주세요.");
	    			return;
	    		}else{
	    		
				var checkGdsId = new Array();
	    		
	    		$('.checkGdsId:checked').each(function(){
	    			checkGdsId.push($(this).val());
	    		});
	    		
	    		jQuery.ajaxSettings.traditional = true;
	    		$.post(
	    				"<c:url value='/McmMalGds001M34UP.do' />",
	    				{
	    					"checkGdsId":checkGdsId
	    				},
	    				function(result){
	    					alert("해당 상품을 내렸습니다.");
	    				}
	    			  ).done(function(){
	    					 document.location.reload();
	    				}).fail(function(){
		    				  alert("실패하였습니다.");
		    				  document.location.reload();
	    				})		  
	    	}	
	    	}
	    	function fnProdUp(){
	    		if($("input[type='checkbox']:checked").length == 0){
	    			alert("체크를 한 후 진행해주세요.");
	    			return;
	    		}else{
	    			var checkGdsId = new Array();
	    		
	    		$('.checkGdsId:checked').each(function(){
	    			checkGdsId.push($(this).val());
	    		});
	    		
	    		jQuery.ajaxSettings.traditional = true;
	    		$.post(
	    				"<c:url value='/McmMalGds001M33CP.do' />",
	    				{
	    					"checkGdsId":checkGdsId
	    				},
	    				function(result){
	    					alert("해당 상품을 올렸습니다.");
	    				},"json"
	    			  ).done(function(){
	    				  document.location.reload();
	    			  }).fail(function(){
	    				  alert("실패하였습니다.");
	    				  document.location.reload();
	    			  })
	    	}
	    	}
	    	function fnProdDelete(){
	    		if($("input[type='checkbox']:checked").length == 0){
	    			alert("체크를 한 후 진행해주세요.");
	    			return;
	    		}else{
	    		if(confirm("선택항목을 삭제하시겠습니까?"))
	    			{
			    		var checkGdsId = new Array();
			    		
			    		$('.checkGdsId:checked').each(function(){
			    			checkGdsId.push($(this).val());
			    		});
	    			}
	    		 jQuery.ajaxSettings.traditional = true;
				 $.post(
						"<c:url value='/McmMalGds001M05DP.do' />",
						{
							"checkGdsId":checkGdsId
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
	    	}
	    	function fnInfoView(obj){
	    		obj.css("cursor","pointer").click(function(){
	    			$("#gdsId").val($(this).attr("gdsId"));
					$("#McmMalGds001VO").attr("action", "<c:url value='/McmMalGds001M04U.do'/>");
					$("#McmMalGds001VO").submit();	
	    		});
	    	}
	    	
	    	
	    	function fnSeachList(){

				
			     var startDate = new Date($("#stProdDt").datepicker("getDate"));
				 var endDate = new Date($("#endProdDt").datepicker("getDate"));
				   if(endDate - startDate <0){
						alert('날짜를 확인해주십시오.');
						$("#endProdDt").focus();
							  return false;
					}
	    		
	    		$("#pageIndex").val("1");
				$("#McmMalGds001VO").attr("action", "<c:url value='/McmMalGds001M01L.do' />");
				$("#McmMalGds001VO").submit();
	    	}
	    	
	    	function fnProdInsert(){
	    		$("#McmMalGds001VO").attr("action", "<c:url value='/McmMalGds001M03C.do'/>");
				$("#McmMalGds001VO").submit();
	    	}
	    	
	    	function fncLinkPage(pageNo){
				$("#pageIndex").val(pageNo);
				
				$("#McmMalGds001VO").attr("action", "<c:url value='/McmMalGds001M01L.do' />");
				$("#McmMalGds001VO").submit();
			};
	    </script>
	    
	</head><!-- End of head -->
<body>
	<form:form commandName="McmMalGds001VO" name="McmMalGds001VO" method="post">
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
			                            <h3>상품 관리 <small>| 쇼핑몰의 기본적인 상품목록을 볼 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                        
<!-- 			                         <div class="pointer_cap"> -->
<!-- 			                        	<div class="pointer pointer_active">상품상세설명</div> -->
<!-- 			                        	<div class="pointer">상품설정</div> -->
<!-- 			                        	<div class="pointer">상품키워드관리</div> -->
<!-- 			                        </div>  -->
			                        
			                        
			                        <div class="content_1_1">
			                             <div class="tab tab_1 tab_1_active">
			                                    <div class="tab_line tab_1_1"> 
			                                        <%-- 검색조건 시작 --%>
													<div class="resize_box">
				                                            <ul class="re_first">
			                                                <li class="title_back" style="width:5%;text-align: center;">상품코드</li>
			                                                <li class="sub_back" style="width:13%;">
			                                                	<form:input path="gdsIdSeach" />
			                                                </li>
			                                                
			                                                <li class="title_back" style="width:5%;text-align: center;">상품명</li>
			                                                <li class="sub_back" style="width:13%;">
			                                                	<form:input path="gdsNmSeach" />
			                                                </li>
			                                                
			                                                <li class="title_back" style="width:8%;text-align: center;">등록일/수정일</li>
			                                                <li class="sub_back">
			                                               		 <form:input path="stProdDt" style="text-align:center;" /> ~ <form:input path="endProdDt" style="text-align:center;"/>
			                                                </li>
			                                                
			                                                <li class="title_back" style="width:8%;text-align: center;">상품노출</li>
			                                                <li class="sub_back">
			                                               		 <form:select path="useYnSearch">
			                                               		 	<form:option value="" label="전체" />
			                                               		 	<form:option value="Y" label="Y" />
			                                               		 	<form:option value="N" label="N" />
			                                               		 </form:select>
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
					                                                	<li style="width:5%;" ></li>
					                                                	 <li style="width:8%;">번호</li>
					                                                    <li style="width:15%;">상품코드</li>
					                                                    <li style="width:15.099999%;">이미지</li>
					                                                    <li style="width:35%;">상품명</li>
					                                                    <li style="width:15%;">등록일/수정일</li>
					                                                    <li style="width:6%;">상품노출</li>
					                                                </ul>
					                                            </div>
					                                            <c:forEach var="resultList" items="${resultList}">
					                                            	<div class="flex flex_2">
																		<ul style="height:48px;">
																			<li style="width:5%; padding:15px 0px;">
						                                                    	<form:checkbox path="checkGdsId" value="${resultList.gdsId}" class="checkGdsId" />
						                                                    </li>
						                                                    <li style="width:8%; padding:15px 0px;">
						                                                    <c:out value="${resultList.rn}" />
						                                                    </li>
						                                                    <li style="width:15%; padding:15px 0px;" name="resultList" gdsId="${resultList.gdsId}">
						                                                    	<c:out value="${resultList.gdsId}" />
						                                                    </li>
						                                                    <li style="width:15.099999%; padding:15px 0px;" name="resultList" gdsId="${resultList.gdsId}">
						                                                    	<img src="<c:url value='/McmGdsMnImg.do?gdsId=${resultList.gdsId }&divCd=2'/>" style="width: 90px !important;height:45px !important; margin-top:-14px;"/>
						                                                    </li>
						                                                    <li style="width:35%; padding:15px 0px;" name="resultList" gdsId="${resultList.gdsId}">
						                                                    	<c:out value="${resultList.gdsNm}" />
						                                                    </li>
						                                                    <li style="width:15%; padding:15px 0px;">
						                                                    	<c:out value="${resultList.lstUdtDt}" />
						                                                    </li>
   						                                                    <li style="width:6%; padding:15px 0px;">
						                                                    	<c:out value="${resultList.useYn}" />
						                                                    </li>
						                                                    
						                                                </ul>
					                                            	</div>
					                                                </c:forEach>
						                                         <c:if test="${ empty resultList }" >
					                                            	<div class="flex flex_2" >
						                                                <ul>
						                                                    <li style="width: 99.89999%;">조회 결과가 없습니다.</li>
						                                                </ul>
						                                        	</div>
					                                            </c:if>
						                                        <div class="flex last_flex">
					                                            </div>
					                                            <%-- 페이지 네비게이션 시작 --%>
					                                 			<div class="next">
					                                            	<ul>
														        		<ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fncLinkPage" />
														        		<form:hidden path="pageIndex" />
														        	</ul>
													           </div>
													           <div class="save_button">
													           <a href="#" id = "btnProdUp">상품 올리기</a>
													           <a href="#" id = "btnProdDown">상품 내리기</a>
													           	<a href="#" id = "btnProdInsert">상품 등록</a>
													           <a href="#" id = "btnProdDelete">선택 삭제</a>
													           </div>
													          </div>
				                                        </div>
				                                        
				                                        
				                                        
			                                        
			                                        <%-- 검색 결과 시작 --%>
			                                        <%-- <div class="suchen_result_cap">
				                                        <div class="suchen_result">전체 <b><c:out value="${paginationInfo.totalRecordCount}" /></b> 개</div>
					                                        <div>
					                                            <div class="flex first_flex">
					                                                <ul>
					                                                    <li style="width:8%;">
					                                                    	<input type="checkbox" id="allCheck">
					                                                    </li>
					                                                    <li style="width:10%;">번호</li>
					                                                    <li style="width:15%;">상품코드</li>
					                                                    <li style="width:8.099999%;">이미지</li>
					                                                    <li style="width:30%;">상품명</li>
					                                                    <li style="width:18%;">등록일/수정일</li>
					                                                    <li style="width:10%;">수정</li>
					                                                </ul>
					                                            </div>
																	<c:forEach var="resultList" items="${resultList}">
					                                            	<div class="flex flex_2">
																		<ul name="resultList" gdsId="${resultList.gdsId}">
						                                                    <li style="width:8%;padding: 0 0!important;">
						                                                    	<input type="checkbox">
						                                                    </li>
						                                                    <li style="width:10%;padding: 0 0!important;">
						                                                    <c:out value="${resultList.rn}" />
						                                                    </li>
						                                                    <li style="width:15%;padding: 0 0!important;">
						                                                    	<c:out value="${resultList.gdsId}" />
						                                                    </li>
						                                                    <li style="width:8.099999%;padding: 0 0!important;">
						                                                    	<img src="<c:out value='${resultList.gdsAttImgPath}${resultList.gdsAttSnImg}'/>" style="width: 65px !important;height: 45px !important;vertical-align: -17.5px;"/>
						                                                    </li>
						                                                    <li style="width:30%;padding: 0 0!important;">
						                                                    	<c:out value="${resultList.gdsNm}" />
						                                                    </li>
						                                                    <li style="width:18%;padding: 0 0!important;">
						                                                    	<c:out value="${resultList.lstUdtDt}" />
						                                                    </li>
						                                                    <li style="width:10%;padding: 0 0!important;">
						                                                   		<a href="#" id="btnUpdate">수정</a>
						                                                    </li>
						                                                </ul>
					                                            	</div>
					                                                </c:forEach>
					                                                
					                                            하단 버튼 시작
					                                            <div class="flex last_flex">
					                                            </div>
					                                            하단 버튼 끝
					                                            
					                                            
					                                            페이지 네비게이션 시작
					                                            <div class="next">
					                                            	<ul>
					                                            		<li>
					                                                    	<ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fncLinkPage" />
					        												<form:hidden path="pageIndex" />
					        											</li>	
			        												</ul>
					                                            </div>
					                                            <div class="save_button"><a href="#" id = "btnProdInsert">상품 등록</a></div>
				                                        </div>
			                                        </div> --%>
			                                        
			                                        
			                                        
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
</body>
</html>