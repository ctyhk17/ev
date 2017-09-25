<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
  /**
  * @Class Name : FmsCmnItrR001.jsp
  * @Description : 인트로
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2017.05.17            최초 생성
  *
  * author 개발팀
  * since 2017.05.17
  * 
  */
%>



<!DOCTYPE html>
<html lang="ko">

	<head>
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmMainHeadInclude.jsp" %>  
	    
	    <script type="text/javascript">
			
				$(document).ready(function () {  
	
					// 정렬
					$("#ordDivCd").change(function(){
						fnList();
		             });
					
					// 정렬
					$("[name=ordItems]").click(function(){
						
						$("#ordDivCd").val($(this).attr("ordDivCd"));
						
						
						fnList();
		             });
					
					
					// 검색
					$("#btnSearch").click(function(){
						
						fnList();
		            });
					
					
					// 상품설명 화면으로 이동
					fnView( $("[name=resultList]") );
					
					// 카테고리 이동
					fnCtgr( $("[name=pcCtgrList]") );
					fnCtgr( $("[name=mbCtgrList]") );
					
					fnBbsNtcView( $("[name=ntcList]") );
					fnBbsUseView( $("[name=useList]") );
					
					
					
					
					
					$(".M_top_menu").click(function(){
		                  $('.M_top_menu_1,.M_top_menu_1_back').slideToggle(100).toggleClass('dis');
		             });// End of sub_menu
		            $(".M_top_menu_1_back").click(function(){
		                $('.M_top_menu_1,.M_top_menu_1_back').slideToggle(100).toggleClass('dis');
		             });// End of M_top_menu_1_back //메뉴 제외 클릭시
		            $(".close").click(function(){
		                $('.M_top_menu_1,.M_top_menu_1_back').slideToggle(100).toggleClass('dis');
		             });// End of M_top_menu_1_back //메뉴 제외 클릭시
		            
		            $(".M_top_menu_1 ul li").click(function(){     		
		                $(this).parent().find("ul").stop().slideToggle(200);
		             });// End of M_top_menu_1
		            
		            $(".active_on").click(function(){     		
		               $('.kategorie_tab').slideToggle(0).toggleClass('dis_1');
		             });// End of M_top_menu_1
		             
		             
				});
				
				
				// 상세보기
				function fnView(obj){
					obj.css("cursor", "pointer").click( function() {
	
						$("#gdsId").val($(this).attr("gdsId"));
						
						//alert($("#gdsId").val());
						
						$("#mcmMalItr001VO").attr("action", "<c:url value='/McmShpOrd001M01R.do'/>");
						$("#mcmMalItr001VO").submit();  
						
		             	   
					});
				}
				
				
				// 카테고리 이동
				function fnCtgr(obj){
					obj.css("cursor", "pointer").click( function() {
	
						$("#searchCtgrCd").val($(this).attr("ctgrCd"));
						
						
						$("#mcmMalItr001VO").attr("action", "<c:url value='/McmMalItr001M01L.do'/>");
						$("#mcmMalItr001VO").submit();  
						
		             	   
					});
				}
				
				
				function fnLinkPage(pageNo) {
					$("#pageIndex").val(pageNo);

					$("#mcmMalItr001VO").attr("action", "<c:url value='/McmMalItr001M01L.do'/>");
					$("#mcmMalItr001VO").submit();
				}
				
				// 목록 조회
				function fnList(){
					$("#mcmMalItr001VO").attr("action", "<c:url value='/McmMalItr001M01L.do'/>");
					$("#mcmMalItr001VO").submit();
				}
				
				
				function fnBbsNtcView(obj) {
					obj.css("cursor", "pointer").click( function() {
						$("#bbsId").val($(this).attr("bbsId"));
						
						
						$("#mcmMalItr001VO").attr("action", "<c:url value='/McmCmnBbs006M22R.do'/>?upMenuId=M003&subMenuId=M003003");
						$("#mcmMalItr001VO").submit();  
					});
				}
				
				
				function fnBbsUseView(obj) {
					obj.css("cursor", "pointer").click( function() {
						$("#bbsId").val($(this).attr("bbsId"));
						
						
						$("#mcmMalItr001VO").attr("action", "<c:url value='/McmCmnBbs006M32R.do'/>?upMenuId=M003&subMenuId=M003004");
						$("#mcmMalItr001VO").submit();  
					});
				}
				
				
			</script>
			
	</head><!-- End of head -->

	<body>
<form:form commandName="mcmMalItr001VO" name="mcmMalItr001VO" method="post">
		<input type="hidden" name="gdsId" id="gdsId"/>
		<input type="hidden" name="bbsId" id="bbsId"/>
	
		<header>
		    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmMainHeaderInclude.jsp" %>
		
		</header><!-- End of header -->   
		
		
		<article>
		
		    
	        
	        <%-- 카테고리 시작 --%>
	        <div class="Kategorie_cap">
                <div class="swiper-container-tab">
                    <ul class="swiper-wrapper tabs">
                        <li class="swiper-slide active active_on"><a href="#;"><img src="<c:url value='/images/main/menu.png' />" alt="" class="menu_ve"> 전체상품</a></li>
                        <li class="swiper-slide"><a href="#;">쇼핑기획전</a></li>
                        <li class="swiper-slide"><a href="#;">금주의상품</a></li>
                        <li class="swiper-slide"><a href="#;">자기계발</a></li>
                        <li class="swiper-slide"><a href="#;">여행문화</a></li>
                        <li class="swiper-slide"><a href="#;">가족친화</a></li>
                        <li class="swiper-slide"><a href="#;">커뮤니티</a></li>
                    </ul>
                </div>
        </div><!-- End of Kategorie_cap -->
        <div class="PC_Kategorie_cap">
            <div class="PC_swiper-container-tab">
                <ul class="PC_swiper-wrapper PC_tabs">
                    <li class="PC_swiper-slide active"><a href="#;"><img src="<c:url value='/images/main/menu.png' />" alt="" class="menu_ve"> 전체카테고리</a></li>
                    <li class="PC_swiper-slide"><a href="#;">쇼핑기획전</a></li>
                    <li class="PC_swiper-slide"><a href="#;">금주의상품</a></li>
                    <li class="PC_swiper-slide"><a href="#;">자기계발</a></li>
                    <li class="PC_swiper-slide"><a href="#;">여행문화</a></li>
                    <li class="PC_swiper-slide"><a href="#;">가족친화</a></li>
                    <li class="PC_swiper-slide"><a href="#;">커뮤니티</a></li>
                </ul>
            </div>
        </div> <!-- End of PC_Kategorie_cap -->
        <script src="<c:url value='/js/main/slider/swiper_tab_customizing.js' />"></script> <!-- Swiper_tab_customizing.Js -->

        
        <div class="swiper-cap custom_sw">    
          <div class="kategorie_tab">
              <ul>
                  <li><a href="#;">뷰티/쥬얼리/시계</a></li>
                  <li><a href="#;">잡화/슈즈/명품</a></li>
                  <li><a href="#;">주방/생활/건강/애완</a></li>
                  <li><a href="#;">가구/침구/인테리어</a></li>
                  <li><a href="#;">식품/마트</a></li>
                  <li><a href="#;">유아/출산/완구</a></li>
                  <li><a href="#;">의류/아웃도어/속옷</a></li>
                  <li><a href="#;">스포츠/레저/캠핑</a></li>
                  <li><a href="#;">가전/컴퓨터/휴대폰</a></li>
                  <li><a href="#;">교육/도서/악기/종교</a></li>
                  <li><a href="#;">기업/물류/문구/꽃</a></li>
                  <li><a href="#;">숙박/특판/명절</a></li>
                  <li><a href="#;">생활복지관</a></li>
              </ul>
          </div>
           
           
           <div class="swiper-container">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <img src="<c:url value='/images/main/slider/slider_1.jpg' />" alt=""><!-- 960 * 382px 최적size-->
                    </div>
                    <div class="swiper-slide">
                        <img src="<c:url value='/images/main/slider/slider_2.jpg' />" alt=""><!-- 960 * 382px 최적size-->
                    </div>
                    <div class="swiper-slide">
                        <img src="<c:url value='/images/main/slider/slider_3.jpg' />" alt=""><!-- 960 * 382px 최적size-->
                    </div>
                </div>
                <!-- Add Pagination -->
                <div class="swiper-pagination"></div>
                <!-- Add Pagination -->
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
            </div>
            <script src="<c:url value='/js/main/slider/swiper_customizing.js' />"></script><!-- Swiper_customizing JS -->
        </div><!-- End of swiper-cap -->
	        
		    			   
		    
		    <div class="content_cap">
		        <div class="content_list">
		           
		            <div class="item_index">
		                <b>PRODUCT LIST</b> 
		                <span class="option">
		                    <a href="#;" name="ordItems" ordDivCd="BEST"  <c:if test="${ 'BEST' eq mcmMalItr001VO.ordDivCd }"> style="font-weight: bold;text-decoration: underline;"</c:if> >베스트상품</a>|
		                    <a href="#;" name="ordItems" ordDivCd="NEW"   <c:if test="${ 'NEW'  eq mcmMalItr001VO.ordDivCd }"> style="font-weight: bold;text-decoration: underline;"</c:if> >최신상품</a>|
		                    <a href="#;" name="ordItems" ordDivCd="SALE"  <c:if test="${ 'SALE' eq mcmMalItr001VO.ordDivCd }"> style="font-weight: bold;text-decoration: underline;"</c:if> >세일상품</a>
		                </span>
		                <form:select path="ordDivCd" class="option_m">
		                    <form:option value="BEST">베스트상품</form:option>
		                    <form:option value="NEW">최신상품</form:option>
		                    <form:option value="SALE">세일상품</form:option>
		                </form:select>
		                
		            </div>
		            
		            
		            <%-- 상품 목록 시작 --%>
		          <c:forEach items="${ resultList }" var="resultInfo" varStatus="status">
		            
			            <div class="item" > 
			                <a href="#;" name="resultList" gdsId="${ resultInfo.gdsId }"><img src="<c:url value='/McmGdsMnImg.do' />?gdsId=${ resultInfo.gdsId }&divCd=2" alt=""  onerror="this.src='<c:url value="/images/main/noimage.jpg" />'" />
				                <p>
				                	${ resultInfo.gdsNm }<br>
				                	<span class="text_de"><fmt:formatNumber value="${resultInfo.gdsGnrAmt}" groupingUsed="true"/><small>원</small></span>
				                	
				                    <c:if test="${ 'Y' eq resultInfo.gdsSaleYn}" >
				                    	<span><b><big><fmt:formatNumber value="${resultInfo.gdsSaleAmt}" groupingUsed="true"/></big><small>원</small></b></span>
				                    </c:if>
				                    
				                    <c:if test="${ 'Y' ne resultInfo.gdsSaleYn}" >
				                    	<span><b><big><fmt:formatNumber value="${resultInfo.gdsMbAmt}" groupingUsed="true"/></big><small>원</small></b></span>
				                    </c:if>
				                    
				                    
				                     
				                    <span><big><fmt:formatNumber value="${resultInfo.salRt}" groupingUsed="true"/></big><small>%</small></span>
				                </p>
				                <div class="purchase"><span><b>${resultInfo.selCnt}개 </b><small>구매</small></span></div>
			                </a>
			            </div>
		            </c:forEach>
		            
		    
		            
		            <c:if test="${ empty resultList }">
		            	<div class="item item_not_search">
			                <img src="<c:url value='/images/main/Search.png' />" alt="" />
			                <h2>검색된 상품이 없습니다.</h2>
			                <p>해당 상품이 존재하지 않거나 판매종료 또는 중지된 상품은 검색 할 수 없습니다.</p>
			                <p>이용에 불편을 드려 대단히 죄송합니다.</p>
			            </div>
		            </c:if>
		            <%-- 상품 목록 끝 --%>
		            
		            
		            <%-- 페이징 시작 --%>
		            <div class="paging">
						<div id="button">
		         			<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fnLinkPage" />
							<form:hidden path="pageIndex" />
						</div>
					</div>
		            <%-- 페이징 끝 --%>
		            
		        </div>
		    </div><!-- End of content_cap -->
		    
		    <div class="guide_cap">
		        <div class="guide">
		           <div class="guide_item">
		                <div class="guide_1">
		                    <dl>
		                        <dt><h3>이용안내</h3></dt>
		                        <dd>
		                          <a href="/McmMalItr001M02R.do">
		                            <img src="<c:url value='/images/main/guide_item_1.png' />" alt="">
		                            <p><b>회사소개</b><br>코알넷을 소개합니다.<span>＞</span></p>
		                          </a>
		                        </dd>
		                        <dd class="middle">
		                            <a href="/McmCmnBbs006M11L.do?upMenuId=M003&subMenuId=M003002">
		                            <img src="<c:url value='/images/main/guide_item_2.png' />" alt="">
		                            <p><b>자주하는 질문</b><br>FAQ를 확인해 보세요.<span>＞</span></p>
		                          </a>
		                        </dd>
		                        <dd>
		                            <a href="/McmCmnBbs006M01L.do?upMenuId=M003&subMenuId=M003001">
		                            <img src="<c:url value='/images/main/guide_item_3.png' />" alt="">
		                            <p><b>1:1문의</b><br>궁금하신 점이 있으세요?<span>＞</span></p>
		                          </a>
		                        </dd>
		                    </dl>
		                </div>
		                <div class="guide_2">
		                    <dl>
		                        <dt><h3>고객센터</h3></dt>
		                        <dd class="img"><img src="<c:url value='/images/main/guide_item_4.png' />" alt=""></dd>
		                        <dd><p><b>${ resultInfo.strNm } 대표번호</b><br><big>${ resultInfo.str001001 }</big></p></dd>
		                        <dd class="ve"><p><img src="<c:url value='/images/main/guide_item_5.png' />" alt=""> ${ resultInfo.str001002 }</p></dd>
		                        <dd class="ve"><p><img src="<c:url value='/images/main/guide_item_6.png' />" alt=""> FAX : ${ resultInfo.str001003 }</p></dd>
		                        <dd class="left"><p class="left_size">${ resultInfo.str001004 }</p><p>${ resultInfo.str001006 }<br><b>${ resultInfo.str001005 }</b></p></dd>
		                        <!-- <dd class="left"><p class="left_size">신한은행협동조합원</p><p>조합복지몰<br><b>00-000-0000</b></p></dd> -->
		                    </dl>
		                </div>
		                <div class="guide_3">
		                   <div class="guide_3_1">
		                     <dl>
		                       <dt><h3>공지사항</h3></dt>
		                       <c:forEach items="${ ntcList }" var="resultInfo" varStatus="status">
		                        <dd name="ntcList" bbsId="${resultInfo.bbsId }">- <c:out value="${fn:substring(resultInfo.bbsSbj,0,23)}" /><c:if test="${fn:length(resultInfo.bbsSbj) gt 23  }" >...</c:if><span><c:out value="${resultInfo.lstUdtDt}" /></span></dd>
		                       </c:forEach>
		                          <c:if test="${ empty ntcList }" >
                                     	<dd>등록된 공지사항이 없습니다.</dd>
                                  </c:if>
		                     </dl>
		                   </div>
		                   <div class="guide_3_2">
		                     <dl>
		                       <dt><h3>고객후기</h3></dt>
		                        <c:forEach items="${ useList }" var="resultInfo" varStatus="status">
		                        <dd name="useList" bbsId="${resultInfo.bbsId }">- <c:out value="${fn:substring(resultInfo.bbsSbj,0,23)}" /><c:if test="${fn:length(resultInfo.bbsSbj) gt 23  }" >...</c:if><span><c:out value="${resultInfo.lstUdtDt}" /></span></dd>
		                       </c:forEach>
		                        <c:if test="${ empty useList }" >
                                     	<dd>등록된 고객후기가 없습니다.</dd>
                                </c:if>
		                   </dl>
		                   </div>
		                </div>
		           </div>
		        </div>
		    </div><!-- End of guide_cap -->
		    
		    
		    
		   
		   
		</article>   
		   
		   
		   
		   
	
	
	
		<footer>
			<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmMainFooterInclude.jsp" %>
		</footer><!-- End of footer -->
	
	
</form:form>

	</body><!-- End of body -->

</html>