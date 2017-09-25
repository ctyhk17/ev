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
					
					
					// 상단 이미지 스크롤
					 $(".M_top_menu").click(function(){
		                  $('.M_top_menu_1').slideToggle(100);
		             });
		             
		             
				});
				
				
				// 상세보기
				function fnView(obj){
					obj.css("cursor", "pointer").click( function() {
	
						$("#gdsId").val($(this).attr("gdsId"));
						
						alert($("#gdsId").val());
						
						$("#mcmMalItr001VO").attr("action", "<c:url value='/McmShpOrd001M01R.do'/>");
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
				
				
				
				
			</script>
			
	</head><!-- End of head -->

	<body>
<form:form commandName="mcmMalItr001VO" name="mcmMalItr001VO" method="post">
	
		<header>
		    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmMainHeaderInclude.jsp" %>
		    
		    	<div class="logo logo_sub"><a href="/McmMalItr001M01L.do"><img src="<c:url value='/images/koalnet/mal/logo.png' />" alt="" title="home" /></a> <h1>회사소개</h1></div>
		    </div>
		</header><!-- End of header -->   
		
		<article>
		
			<div class="sub_company_cap">
		       <div class="sub_company">
		          <div class="com_le">
		           <h2>조합복지몰 <small><sup>Shopping Mall</sup></small></h2>
		           <div class="line"></div>
		           <p>
		                <b>안녕하십니까!! <br>
		                조합복지몰에 오신 것을 환영합니다.</b> <br><br>
		
		                <small>당뇨건강생활 사회적협동조합(이하 ‘조합’이라 한다)은 자주, 자립, 자치를 바탕으로 하는 다양한 조합 활동을 통하여
		                조합원의 건강과 권익증진을 도모하고 나아가 모든 국민이 당뇨로부터 안전한 삶을 영위할수 있도록 지원하기 위해 
		                농림축산식품부 허가를 받아 2017. 2. 16일 설립하였습니다.<br><br>
		
		                협동조합은 전국 당뇨인(당뇨위험군)과 당뇨효능작물 및 기능성식품 등을 생산하는 생산자가 직접 참여하는 당뇨건강생활
		                공동체(플랫폼)를 구성하여 당뇨 및 만성질환 예방관리, 당뇨상품 생산·유통·판매, 관광, 홍보, 6차산업화 등 지원, 개인
		                맞춤형 당뇨진단과 교육, 컨텐츠 등을 제공해 건강한 대한민국을 만드는데 일조해 나갈 것입니다.<br><br>
		
		                조합원 가입을 통해 당뇨와 관련된 교육, 음식, 효능작물 등 정보공유는 물론, 조합에서 제공하는 다양한 혜택을 누려보시기 
		                바랍니다</small>
		           </p>
		           
		           </div>
		           <div class="com_ri">
		               <img src="<c:url value='/images/koalnet/mal/company_1.png' />" alt="" />
		           </div>
		       </div>
		   </div>
		   
		    <div class="sub_company_cap_1">
		       <div class="sub_company">
		            <div class="title_sub"><h2>CI <small><sup>Corporate Identity</sup></small></h2></div>
		            <div class="line_1"></div>
		            <div class="title_sub_1"><h4>브랜드 LOGO</h4></div>
		            <div class="com_le_r">
		                <img src="<c:url value='/images/koalnet/mal/company_2.png' />" alt="" />
		            </div>    
		            <div class="com_ri_r">
		                <img src="<c:url value='/images/koalnet/mal/company_3.png' />" alt="" />
		           </div>
		       </div>
		   </div>
		   
		   <div class="sub_company_cap_2">
		       <div class="sub_company">
		            <div class="title_sub"><h2>찾아오시는길 <small><sup> Location</sup></small></h2></div>
		            <div class="line_1"></div>
		            
		                <div class="tab_1" style="padding: 0;">
							<div id="map" style="height: 428px; width: 100%"></div>
							<script>
							function initMap() {
							var uluru = {lat: 36.991025, lng: 127.925953};
							var map = new google.maps.Map(document.getElementById('map'), {
							zoom: 17,
							center: uluru,
							});
							var contentString = '<div id="content">'+
						      '<div id="siteNotice">'+
						      '</div>'+
						      '<h3 id="firstHeading" class="firstHeading">(27339) 충청북도 충주시 으뜸로 21(금릉동)</h3>'+
						      '<div id="bodyContent">'+
						      '<br><p>전화번호 : 043-850-0760~3</p>'+
						      '</div>'+
						      '</div>';
						      
							var infowindow = new google.maps.InfoWindow({
								content: contentString
							});
							var marker = new google.maps.Marker({
							position: uluru,
							map: map
							});
							marker.addListener('click', function() {
							    infowindow.open(map, marker);
							  });
							}
							</script>
							<script async defer
							src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCiVK3yaDyQ1gBq7sr_O2maUiocTye_7PI&callback=initMap">
							</script>						    
						</div>
		            
		       </div>
		   </div>
		    
		    
		    
		   
		   
		   
		   
		   
		   
		   
		</article><!-- End of article -->
	
	
	
		<footer>
			<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmMainFooterInclude.jsp" %>
		</footer><!-- End of footer -->
	
	
</form:form>

	</body><!-- End of body -->

</html>