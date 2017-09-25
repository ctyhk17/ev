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
	
					// 검색
					$("#btnRetrieve").click(function() {	
						fncRetrieve();
					});
					
					// 초기화
					$("#btnClear").click(function() {	
						
						$("[searchItem=true]").each(
							function(){
								
								if($(this).attr('type') == "radio")
								{
									$(this).filter(":radio[value='']").prop("checked", true);
								
								}else if($(this).attr('type') == "checkbox")
								{
									$(this).prop("checked", true);
								}else{
									$(this).val("");
								}
							}
						);
						
						// 조회
						fncRetrieve();
						
						
						
						fncView( $("[name=resultList]") );
						
						
						
					});
					
					// 엔터키 이벤트
					$("[searchItem=true]").keydown(function(e) {
				        if (e.keyCode == 13) {
				        	fncRetrieve();
				        }
				    }); 
					
					// 페이지수 변경
					$("#recordCountPerPage").change(function() {
						fncRetrieve();
					});
	
					// 등록
					$("#btnCreate").click(function() {	
						fncCreate();
					});
					
					
					fncView( $("[name=resultList]") );
	
				});
				
				
				// 조회
				function fncRetrieve(){
					$("#pageIndex").val("1");
					
					$("#mcmTplTpl001VO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntL.do'/>");
					$("#mcmTplTpl001VO").submit();
				}
				
				// 등록
				function fncCreate(){
					
					$("#mcmTplTpl001VO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntI.do'/>");
					$("#mcmTplTpl001VO").submit();
				}
				
				
				function fncView(obj){
					obj.css("cursor", "pointer").click( function() {
	
						$("#adsubMgntNo").val($(this).attr("adsubMgntNo"));
						
						$("#mcmTplTpl001VO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntR.do'/>");
						$("#mcmTplTpl001VO").submit();  
						
		             	   
					});
				}
				
				
				
				
				
				// 페이지 이동
				function fncLinkPage(pageNo){
					$("#pageIndex").val(pageNo);
					
					$("#mcmTplTpl001VO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntL.do'/>");
					$("#mcmTplTpl001VO").submit();
					
				}
				
			</script>
			
			
	</head><!-- End of head -->

	<body>


<form:form commandName="mcmTplTpl001VO" name="mcmTplTpl001VO" method="post">
	
	
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
			                    <div class="aside_menu_back">기본설정 > 기본정책 > <b>기본 정보 설정</b></div>
			                    <%-- 페이지 네베게이션  끝--%>
			                    
			                    <div class="slide_left"><span class="this_span_11">＜</span><span class="this_span_22">＞</span></div>
			                    
			                    
			                    <div class="content_1">
			                        
			                        <%-- 상단 타이틀 시작  --%>
			                        <div class="content_1_top">
			                            <h3>기본 정보 설정 <small>| 쇼핑몰의 기본적인 정보를 변경하실 수 있습니다.</small></h3>
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
			                                       
			                                       
			                                       
			                                        <%-- 검색조건 시작 --%>
													<div class="resize_box">
				                                            <ul class="re_first">
			                                                <li class="title_back" style="width:8%;">사업장주소</li>
			                                                <li class="sub_back" style="width:15%;"><input type="text"></li>
			                                                
			                                                <li class="title_back" style="width:8%;">사업장주소</li>
			                                                <li class="sub_back" style="width:15%;"><input type="text"></li>
			                                                
			                                                <li class="title_back" style="width:8%;">사업장주소</li>
			                                                <li class="sub_back" style="width:15%;"><input type="text"></li>
			                                                
			                                                <li class="title_back" style="width:8%;">사업장주소</li>
			                                                <li class="sub_back" style="width:15%;"><input type="text"></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:8%;">사업장주소</li>
			                                                <li class="sub_back" style="width:15%;"><input type="text"></li>
			                                                
			                                                <li class="title_back" style="width:8%;">사업장주소</li>
			                                                <li class="sub_back" style="width:15%;"><input type="text"></li>
			                                                
			                                                <li class="title_back" style="width:8%;">사업장주소</li>
			                                                <li class="sub_back" style="width:15%;"><input type="text"></li>
			                                                
			                                                <li class="title_back" style="width:8%;">사업장주소</li>
			                                                <li class="sub_back" style="width:15%;"><input type="text"></li>
			                                            </ul>
													</div>
				                                    <%-- 검색조건 종료 --%>
			                                            
			                                            
			                                            
			                                       
			                                       
			                                       
			                                       
                                        
                                        
                                        
													<div class="suchen">
				                                                <a href="#" class="suchen_a">검색</a>
				                                    </div>
			                                        
			                                        
			                                        <div class="line_class"></div>
			                                        
			                                        
			                                        <%-- 검색 결과 시작 --%>
			                                        <div class="suchen_result_cap">
			                                        
			                                        
				                                        <div class="suchen_result">검색 <b>2</b>명 / 전체 <b>2</b>명</div>
					                                        <div>
					                                            <div class="flex first_flex">
					                                                <ul>
					                                                    <li style="width:2%;"><input type="checkbox"></li>
					                                                    <li style="width:8%;">번호</li>
					                                                    <li style="width:6%;">이름</li>
					                                                    <li style="width:14%;">아이디/닉네임</li>
					                                                    <li>포인트</li>
					                                                    <li>예치금</li>
					                                                    <li>기타등등</li>
					                                                    <li>기타등등</li>
					                                                    <li>최종로그인</li>
					                                                    <li>회원가입일</li>
					                                                    <li>가입승인</li>
					                                                    <li>메일/SMS</li>
					                                                    <li>수정</li>
					                                                </ul>
					                                            </div>
					                                            <div class="flex flex_2">
					                                                <ul>
					                                                    <li style="width:2%;"><input type="checkbox"></li>
					                                                    <li style="width:8%;">010-5682-4444</li>
					                                                    <li style="width:6%;">이민호</li>
					                                                    <li style="width:14%;">mortality384/꽃이피었습니다</li>
					                                                    <li>2만 포인트</li>
					                                                    <li>30,000</li>
					                                                    <li>0</li>
					                                                    <li>0</li>
					                                                    <li>13:00</li>
					                                                    <li>2017-06-13</li>
					                                                    <li>허용</li>
					                                                    <li><a href="#">메일</a> <a href="#">SMS</a></li>
					                                                    <li><a href="#">수정</a></li>
					                                                </ul>
					                                            </div>
					                                            <div class="flex flex_2">
					                                                <ul>
					                                                    <li style="width:2%;"><input type="checkbox"></li>
					                                                    <li style="width:8%;">010-5682-4444</li>
					                                                    <li style="width:6%;">이민호</li>
					                                                    <li style="width:14%;">mortality384/꽃이피었습니다</li>
					                                                    <li>2만 포인트</li>
					                                                    <li>30,000</li>
					                                                    <li>0</li>
					                                                    <li>0</li>
					                                                    <li>13:00</li>
					                                                    <li>2017-06-13</li>
					                                                    <li>허용</li>
					                                                    <li><a href="#">메일</a> <a href="#">SMS</a></li>
					                                                    <li><a href="#">수정</a></li>
					                                                </ul>
					                                            </div>
					                                            <div class="flex flex_2">
					                                                <ul>
					                                                    <li style="width:2%;"><input type="checkbox"></li>
					                                                    <li style="width:8%;">010-5682-4444</li>
					                                                    <li style="width:6%;">이민호</li>
					                                                    <li style="width:14%;">mortality384/꽃이피었습니다</li>
					                                                    <li>2만 포인트</li>
					                                                    <li>30,000</li>
					                                                    <li>0</li>
					                                                    <li>0</li>
					                                                    <li>13:00</li>
					                                                    <li>2017-06-13</li>
					                                                    <li>허용</li>
					                                                    <li><a href="#">메일</a> <a href="#">SMS</a></li>
					                                                    <li><a href="#">수정</a></li>
					                                                </ul>
					                                            </div>
					                                            <div class="flex flex_2">
					                                                <ul>
					                                                    <li style="width:2%;"><input type="checkbox"></li>
					                                                    <li style="width:8%;">010-5682-4444</li>
					                                                    <li style="width:6%;">이민호</li>
					                                                    <li style="width:14%;">mortality384/꽃이피었습니다</li>
					                                                    <li>2만 포인트</li>
					                                                    <li>30,000</li>
					                                                    <li>0</li>
					                                                    <li>0</li>
					                                                    <li>13:00</li>
					                                                    <li>2017-06-13</li>
					                                                    <li>허용</li>
					                                                    <li><a href="#">메일</a> <a href="#">SMS</a></li>
					                                                    <li><a href="#">수정</a></li>
					                                                </ul>
					                                            </div>
					                                            <div class="flex flex_2">
					                                                <ul>
					                                                    <li style="width:2%;"><input type="checkbox"></li>
					                                                    <li style="width:8%;">010-5682-4444</li>
					                                                    <li style="width:6%;">이민호</li>
					                                                    <li style="width:14%;">mortality384/꽃이피었습니다</li>
					                                                    <li>2만 포인트</li>
					                                                    <li>30,000</li>
					                                                    <li>0</li>
					                                                    <li>0</li>
					                                                    <li>13:00</li>
					                                                    <li>2017-06-13</li>
					                                                    <li>허용</li>
					                                                    <li><a href="#">메일</a> <a href="#">SMS</a></li>
					                                                    <li><a href="#">수정</a></li>
					                                                </ul>
					                                            </div>
					                                            
					                                            
					                                            <%-- 하단 버튼 시작 --%>
					                                            <div class="flex last_flex">
					                                                   <a href="#">선택 가입승인</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">선택 가입탈퇴</a>
					                                                   <a href="#">엑셀 다운로드</a>
					                                            </div>
					                                            <%-- 하단 버튼 끝 --%>
					                                            
					                                            
					                                            <%-- 페이지 네비게이션 시작 --%>
					                                            <div class="next">
					                                                <ul>
					                                                    <li><a href="#">≪</a></li>
					                                                    <li><a href="#">＜</a></li>
					                                                    <li><a href="#" class="a_active">1</a></li>
					                                                    <li><a href="#">2</a></li>
					                                                    <li><a href="#">3</a></li>
					                                                    <li><a href="#">4</a></li>
					                                                    <li><a href="#">5</a></li>
					                                                    <li><a href="#">＞</a></li>
					                                                    <li><a href="#">≫</a></li>
					                                                </ul>
					                                            </div>
					                                            <%-- 페이지 네비게이션 끝 --%>
				                                            
				                                        </div>
				                                        
			                                        </div>
			                                        <!-- suchen_result_cap -->
			                                        <%-- 검색 결과 종료 --%>
			                                        
			                                        
													<div class="save_button"><a href="#">저장</a> <a href="#">저장</a></div>
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 
                                       				 <%-- ========================================== --%>
                                       				 <%-- 본문 종료 --%>
                                       				 <%-- ========================================== --%>
			                                        
											</div>
											<!-- End of tab_1_1 -->
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