<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


							<div class="aside_position">
			                    <div class="aside_menu_1"><img src="<c:url value='/images/admin/di.png' />" alt=""></div>
			                    
			                    
			                    <!-- 주문현황 -->
			                    <c:if test="${ 'M001' eq upMenuId }">
			                    
				                    <div class="click_on">
				                        <ul>
				                            <li class="aside_menu_2"><h4>주문현황<span class="plus_11">-</span><span class="plus_22">+</span></h4></li>
				                            <ul class="click_out aside_menu_2_1" >
<li <c:if test="${ 'M001001' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M001001' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmShpOrd002M01L.do' />?upMenuId=M001&subMenuId=M001001">주문조회</a></li>
<li <c:if test="${ 'M001002' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M001002' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmShpOrd003M01L.do' />?upMenuId=M001&subMenuId=M001002">장바구니</a></li>
				                            </ul>
				                        </ul>                
				                   </div><!-- End of click_on -->
			                   
			                   </c:if>
			                   
			                   
			                   <!-- 정보내역-->
								<c:if test="${ 'M002' eq upMenuId }">
				                    <div class="click_on">
				                        <ul>
				                            <li class="aside_menu_2"><h4>정보내역<span class="plus_11">-</span><span class="plus_22">+</span></h4></li>
				                            <ul class="click_out aside_menu_2_1">
<li <c:if test="${ 'M002001' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M002001' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnUsr001M03U.do' />?upMenuId=M002&subMenuId=M002001">회원정보관리</a></li>
<li <c:if test="${ 'M002002' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M002002' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnUsr001M04R.do' />?upMenuId=M002&subMenuId=M002002">회원탈퇴</a></li>			                                    
				                            </ul>
				                        </ul>             
				                   </div><!-- End of click_on -->
			                   </c:if>
			                   
			                   
			                   <!-- 고객센터-->
			                   <c:if test="${ 'M003' eq upMenuId }">
				                   <div class="click_on">
				                        <ul>
				                            <li class="aside_menu_2"><h4>고객센터<span class="plus_11">-</span><span class="plus_22">+</span></h4></li>
				                            <ul class="click_out aside_menu_2_1">
<li <c:if test="${ 'M003001' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M003001' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnBbs006M01L.do' />?upMenuId=M003&subMenuId=M003001">1:1문의</a></li>
<li <c:if test="${ 'M003002' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M003002' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnBbs006M11L.do' />?upMenuId=M003&subMenuId=M003002">FAQ</a></li>
<li <c:if test="${ 'M003003' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M003003' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnBbs006M21L.do' />?upMenuId=M003&subMenuId=M003003">공지사항</a></li>
<li <c:if test="${ 'M003004' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M003004' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnBbs006M31L.do' />?upMenuId=M003&subMenuId=M003004">고객후기</a></li>
<%-- 
<li <c:if test="${ 'M003002' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M003002' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="#                                     ?upMenuId=M003&subMenuId=M003002">상품문의</a></li>
<li <c:if test="${ 'M003003' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M003003' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="#                                     ?upMenuId=M003&subMenuId=M003003">상품후기</a></li> 
--%>
				                            </ul>
				                        </ul>               
				                   </div><!-- End of click_on -->
			                   </c:if>
			                   
			                   
			                   <!-- 상품관리-->
			                   <c:if test="${ 'M004' eq upMenuId }">
				                   <div class="click_on">
				                        <ul>
				                            <li class="aside_menu_2"><h4>상품관리<span class="plus_11">-</span><span class="plus_22">+</span></h4></li>
				                            <ul class="click_out aside_menu_2_1">
<li <c:if test="${ 'M004001' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M004001' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmMalGds001M01L.do' />?upMenuId=M004&subMenuId=M004001">상품관리</a></li>			                                    
				                            </ul>
				                        </ul>              
				                   </div><!-- End of click_on -->
			                   </c:if>
			                   
			                   
			                   <!-- 주문관리-->
			                   <c:if test="${ 'M005' eq upMenuId }">
				                   <div class="click_on">
				                        <ul>
				                            <li class="aside_menu_2"><h4>주문관리<span class="plus_11">-</span><span class="plus_22">+</span></h4></li>
				                            <ul class="click_out aside_menu_2_1">
				                            
<li <c:if test="${ 'M005001' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M005001' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmShpOrd004M01L.do' />?upMenuId=M005&subMenuId=M005001">주문관리</a></li>
<li <c:if test="${ 'M005002' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M005002' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmShpOrd004M21L.do' />?upMenuId=M005&subMenuId=M005002">취소관리</a></li>		                                    
<li <c:if test="${ 'M005003' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M005003' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmShpOrd004M31L.do' />?upMenuId=M005&subMenuId=M005003">교환관리</a></li>
<li <c:if test="${ 'M005004' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M005004' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmShpOrd004M41L.do' />?upMenuId=M005&subMenuId=M005004">반품관리</a></li>
<%-- <li <c:if test="${ 'M005005' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M005005' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmShpOrd004M51L.do' />?upMenuId=M005&subMenuId=M005005">환불관리</a></li> --%>
				                            </ul>
				                        </ul>              
				                   </div><!-- End of click_on -->
			                   </c:if>
			                   
			                   
			                   <!-- 홍보관리-->
			                   <c:if test="${ 'M006' eq upMenuId }">
				                   <div class="click_on">
				                        <ul>
				                            <li class="aside_menu_2"><h4>홍보관리<span class="plus_11">-</span><span class="plus_22">+</span></h4></li>
				                            <ul class="click_out aside_menu_2_1">
<li <c:if test="${ 'M006001' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M006001' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value="/McmMalBiz002M01L.do"/>?upMenuId=M006&subMenuId=M006001">홍보물관리</a></li>	
<li <c:if test="${ 'M006002' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M006002' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value="/McmMalBiz003M01L.do"/>?upMenuId=M006&subMenuId=M006002">팀장관리</a></li>		                                    
<li <c:if test="${ 'M006003' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M006003' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value="/McmMalBiz001M01L.do"/>?upMenuId=M006&subMenuId=M006003">사업자관리</a></li>
				                            </ul>
				                        </ul>              
				                   </div><!-- End of click_on -->
			                   </c:if>
			                   
			                   
			                   <!-- 현황통계-->
			                   <c:if test="${ 'M007' eq upMenuId }">
				                   <div class="click_on">
				                        <ul>
				                            <li class="aside_menu_2"><h4>현황통계<span class="plus_11">-</span><span class="plus_22">+</span></h4></li>
				                            <ul class="click_out aside_menu_2_1">
<li <c:if test="${ 'M007001' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M007001' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value="/McmMalStt001M01L.do"/>?upMenuId=M007&subMenuId=M007001">상품별매출현황</a></li>	
<li <c:if test="${ 'M007002' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M007002' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value="/McmMalStt003M01L.do"/>?upMenuId=M007&subMenuId=M007002">사업자별매출현황</a></li>		                                    
<li <c:if test="${ 'M007003' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M007003' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value="/McmMalStt002M01L.do"/>?upMenuId=M007&subMenuId=M007003">일자별매출현황</a></li>
<li <c:if test="${ 'M007004' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M007004' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value="/McmCmnPot001M01L.do"/>?upMenuId=M007&subMenuId=M007004">포인트조회</a></li>
				                            </ul>
				                        </ul>              
				                   </div><!-- End of click_on -->
								</c:if>
			                   
			                   
			                   <!-- 조합원관리 -->
			                   <c:if test="${ 'M008' eq upMenuId }">
				                   <div class="click_on">
				                        <ul>
				                            <li class="aside_menu_2"><h4>조합원관리<span class="plus_11">-</span><span class="plus_22">+</span></h4></li>
				                            <ul class="click_out aside_menu_2_1">
<li <c:if test="${ 'M008001' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M008001' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnUsr002M11L.do' />?upMenuId=M008&subMenuId=M008001">조합원가입승인</a></li>	
<li <c:if test="${ 'M008003' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M008003' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnUsr003M01L.do' />?upMenuId=M008&subMenuId=M008003">회원관리</a></li>		                                    
<li <c:if test="${ 'M008002' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M008002' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnUsr002M01L.do' />?upMenuId=M008&subMenuId=M008002">조합원관리</a></li>		                                    
				                            </ul>
				                        </ul>              
				                   </div><!-- End of click_on -->
								</c:if>
			                   
			                   
			                   <!-- 게시판관리 -->
			                   <c:if test="${ 'M009' eq upMenuId }">
				                   <div class="click_on">
				                        <ul>
				                            <li class="aside_menu_2"><h4>게시판관리<span class="plus_11">-</span><span class="plus_22">+</span></h4></li>
				                            <ul class="click_out aside_menu_2_1">
<li <c:if test="${ 'M009001' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M009001' ne subMenuId }"> class="aside_menu_4" </c:if> ><a  href="<c:url value='/DdCmnAdm001M01L.do' />?upMenuId=M009&subMenuId=M009001">공지사항</a></li>	
<li <c:if test="${ 'M009002' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M009002' ne subMenuId }"> class="aside_menu_4" </c:if> ><a  href="<c:url value='/DdCmnAdm002M01L.do' />?upMenuId=M009&subMenuId=M009002">회원사뉴스</a></li>		                                    
<li <c:if test="${ 'M009003' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M009003' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/DdCmnAdm003M01CL.do' />?upMenuId=M009&subMenuId=M009003">행사관리</a></li>
<li <c:if test="${ 'M009004' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M009004' ne subMenuId }"> class="aside_menu_4" </c:if> ><a  href="<c:url value='/DdCmnAdm004M01L.do' />?upMenuId=M009&subMenuId=M009004">갤러리</a></li>
<li <c:if test="${ 'M009005' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M009005' ne subMenuId }"> class="aside_menu_4" </c:if> ><a  href="<c:url value='/DdCmnAdm005M01L.do' />?upMenuId=M009&subMenuId=M009005">묻고답하기</a></li>
<li <c:if test="${ 'M009006' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M009006' ne subMenuId }"> class="aside_menu_4" </c:if> ><a  href="<c:url value='/DdCmnAdm006M01L.do' />?upMenuId=M009&subMenuId=M009006">회원사관리</a></li>
				                            </ul>
				                        </ul>              
				                   </div><!-- End of click_on -->
			                   </c:if>
			                   
			                   
			                   <!-- 시스템설정 -->
			                   <c:if test="${ 'M010' eq upMenuId }">
				                   <div class="click_on">
				                        <ul>
				                            <li class="aside_menu_2"><h4>시스템설정<span class="plus_11">-</span><span class="plus_22">+</span></h4></li>
				                            <ul class="click_out aside_menu_2_1">
<li <c:if test="${ 'M010001' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M010001' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnCcd001M01L.do' />?upMenuId=M010&subMenuId=M010001">코드그룹관리</a></li>	
<li <c:if test="${ 'M010002' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M010002' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnCcd001M11L.do' />?upMenuId=M010&subMenuId=M010002">공통코드관리</a></li>	
<li <c:if test="${ 'M010003' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M010003' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnAth001M01L.do' />?upMenuId=M010&subMenuId=M010003">권한관리</a></li>		                                    
<li <c:if test="${ 'M010004' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M010004' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnAth002M01L.do' />?upMenuId=M010&subMenuId=M010004">권한별사용자관리</a></li>
<li <c:if test="${ 'M010005' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M010005' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmMalStr001M02R.do' />?upMenuId=M010&subMenuId=M010005">상점관리</a></li>
<li <c:if test="${ 'M010006' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M010006' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnKwd001M01L.do' />?upMenuId=M010&subMenuId=M010006">키워드관리</a></li>
<li <c:if test="${ 'M010007' eq subMenuId }"> class="aside_menu_4 active_color" </c:if> <c:if test="${ 'M010007' ne subMenuId }"> class="aside_menu_4" </c:if> ><a href="<c:url value='/McmCmnCtr001M01L.do' />?upMenuId=M010&subMenuId=M010007">카테고리관리</a></li>
				                            </ul>
				                        </ul>              
				                   </div><!-- End of click_on -->
			                   </c:if>
			                   
			                   
			                   
			                   
			                   
			                </div><!-- End aside_position -->
