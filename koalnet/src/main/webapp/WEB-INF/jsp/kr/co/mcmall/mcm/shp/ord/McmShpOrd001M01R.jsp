<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%

//response.setHeader("cache-control","no-cache, no-store, must-revalidate");
//response.setHeader("expires","0");
//response.setHeader("pragma","no-cache");

%>
<%
  /**
  * @Class Name : McmShpOrd001M01R.jsp
  * @Description : 사업자별 브로셔 홈
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
	
		<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeadInclude.jsp" %>
		<style>
			a.cbtn {
				height: 25px;
				padding: 0 14px 0;
				border: 1px solid #d7242b;
				font-size: 13px;
				line-height: 25px;
			}
			
			
	</style>
		
		
		<script type="text/javascript">
		
		
		
			var noticePopup = null;  // 밖에다가 선언
		
			$(document).ready(function () {  
				
				
				/* function getCookie(name){
					var nameOfCookie = name+"=";
					var x = 0;
					while(x<=document.cookie.length){
						var y = (x+nameOfCookie.length);
						if(document.cookie.substring(x,y)==nameOfCookie){
							if(endOfCookie=document.cookie.substring(y,endOfCookie));
						}
						x = document.cookie.indexOf(" ",x)+1;
						if(x==0)break;
					}
					return "";
				}
				if(getCookie("popup")!="done"){
					var noticePopup = window.open("<c:url value='/html/koalnet/mal/re_popup.html' />","noticePopup","toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=550, height=560, top=0px,left=0px");
					noticePopup.opener=self;
				} */
				
				
				/* function checkPopupCookie(cookieName){
					var cookie = document.cookie;
					if(cookie.length>0){
						startIndex = cookie.indexOf(cookieName);
						if(startIndex!=-1){
							return true;
						}else{
							return false;
						};
					}else{
						return false;
					};
				} */
				
				
				
				
				/* function getCookie(name){
					var nameOfCookie = name+"=";
					var x = 0;
					while(x<=document.cookie.length){
						var y = (x+nameOfCookie.length);
						if(document.cookie.substring(x,y)==nameOfCookie){
							if((endOfCookie=document.cookie.indexOf(";",y))==-1)
								endOfCookie=document.cookie.length;
							return unescape(document.cookie.substring(y,endOfCookie));
						}
						x = document.cookie.indexOf(" ",x)+1;
						if(x==0)break;
					}
					return "";
				}
				if(getCookie("popup")!="done"){
					var noticePopup = window.open("<c:url value='/html/koalnet/mal/re_popup.html' />","noticePopup","toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=550, height=560, top=0px,left=0px");
					noticePopup.opener=self;
				}
				
				
				function checkPopupCookie(cookieName){
					var cookie = document.cookie;
					if(cookie.length>0){
						startIndex = cookie.indexOf(cookieName);
						if(startIndex!=-1){
							return true;
						}else{
							return false;
						};
					}else{
						return false;
					};
				} */
				
				
				
				$("a[id ^= 'btnPopClose']").click(function() {	
					//btnGoOrd();
					$("#cartPop").hide();
				});
				
				// 수량선택화면으로 이동
				$("#btnGoOrd").click(function() {	
					btnGoOrd();
// 					alert('2017-07-01 ~ 2017-07-31일 까지는 상품 등록 기간입니다.\n상품 구매는 2017-08-01부터 가능합니다.\n불편을 드려 죄송합니다.');
				});
				
				// 장바구니
				$("#btnGoCart").click(function() {	
// 					alert('2017-07-01 ~ 2017-07-31일 까지는 상품 등록 기간입니다.\n상품 구매는 2017-08-01부터 가능합니다.\n불편을 드려 죄송합니다.');
					btnGoCart();

				});
				
				
				// 장바구니 목록 이동
				$("#btnCartYes").click(function() {	
					
					$("#mcmShpOrd001VO").attr("action", "<c:url value='/McmShpOrd001M02R.do'/>");
					$("#mcmShpOrd001VO").submit();
					
					location.href = "<c:url value='/McmShpOrd003M01L.do?upMenuId=M001&subMenuId=M001002'/>";
		

				});
				

				// 상태바 표시
				$("#rateLine").css("width", "${resultInfo.selRt }%");
				
				
				// 숫자 포멧팅
				$("#ordCntMask").number(true);
				
				$("#ordCntMask").keyup(function() {	
					fn_calAmt();
				});
				
				
				$("#btnAddCnt").click(function() {	
					var ordCnt = removeComma($("#ordCntMask").val());
					
					if(! $.isNumeric(ordCnt)){
						ordCnt = 0;						
					}
					
					ordCnt = parseInt(ordCnt) + 1;
					
					$("#ordCntMask").val(ordCnt);
					
					fn_calAmt();
				});
				
				$("#btnMinusCnt").click(function() {
					
					var ordCnt = removeComma($("#ordCntMask").val());
					
					if(! $.isNumeric(ordCnt)){
						ordCnt = 0;						
					}
					
					if(ordCnt > 0)
						ordCnt = parseInt(ordCnt) - 1;
					
					
					$("#ordCntMask").val(ordCnt);
					
					fn_calAmt();
				});
				
				fn_calAmt();
				
				// RSS 목록 조회
				<c:forEach items="${ keywordList }" var="keywordInfo" varStatus="status">
					fnInitRss("${keywordInfo.kwdRssUrl}", $("#rssTable${keywordInfo.seqNo}"));
				</c:forEach>
				
				fnKeywordTab("1");
				

				
			});
			
			
			// 금액 계산
			function fn_calAmt(){
				
				var gdsAmt = $("#gdsAmt").val();
				var ordCnt = removeComma($("#ordCntMask").val());
				
				if(! $.isNumeric(gdsAmt)){
					alert('단가가 잘못 입력되었습니다.\n관리자에게 문의하세요.');						
				}
				
				if(! $.isNumeric(ordCnt)){
					ordCnt = 0;						
				}
				
				var ordTotAmt = parseInt(gdsAmt) * parseInt(ordCnt);
				
				$("#ordTotAmtMask").text(numberWithCommas(ordTotAmt));
			}

			
			
			// 예매화면으로 이동
			function btnGoOrd(){
				
				if($("#ordCntMask").val() <= 0) {
					alert("상품수량을 선택하여 주십시오");
					return false;
				} 
				
				$("#ordCnt").val($("#ordCntMask").number(true).val());
				$("#ordAmt").val($("#gdsAmt").val());
				$("#ordDiv").val("dir");
				
				$("#mcmShpOrd001VO").attr("action", "<c:url value='/McmShpOrd001M02R.do'/>");
				$("#mcmShpOrd001VO").submit();
			}
			
			
			// 카트 등록 이동
			function btnGoCart(){
				
				/* $("#mcmShpOrd001VO").attr("action", "<c:url value='/fnd/ord/DdFndOrd001R21.do'/>");
				$("#mcmShpOrd001VO").submit(); */
				
				/* $("#mcmShpOrd001VO").attr("action", "<c:url value='/fnd/ord/DdFndOrd001R21.do'/>");
				$("#mcmShpOrd001VO").submit(); */
				
				if($("#ordCntMask").val() <= 0) {
					alert("상품수량을 선택하여 주십시오");
					return false;
				} 
				
				if(confirm("해당상품을 장바구니에 등록하겠습니까?")){
					
  					var gdsId     = $("#gdsId").val();
  					var lcsId = $("#lcsId").val();
  					var gdsAmt = $("#gdsAmt").val();
  					var ordCnt = $("#ordCntMask").number(true).val();
  					
					$.post(
							"<c:url value='/McmShpOrd003M03C.do'/>", 
							{ 
								"gdsId" : gdsId,
								"lcsId" : lcsId,
								"ordCnt" : ordCnt,
								"ordAmt" : gdsAmt
							}, 
							function(responseText)
							{
								$("#cartPop").show();		
							}, 
							"json"
					)
					.done(function() {
							
					})
					.fail(function() {
						alert( "처리 도중 에러가 발생하였습니다." );
						$("#cartPop").show();	
					});
				}
			} 
			
			// 탭 컨트롤
			function fnKeywordTab(idx)
			{
				$("#rssList1").hide();
				$("#rssList2").hide();
				$("#rssList3").hide();
				$("#rssList4").hide();
				$("#rssList5").hide();
				
				if(idx == "1")
					$("#rssList1").show();
				
				if(idx == "2")
					$("#rssList2").show();
				
				if(idx == "3")
					$("#rssList3").show();
				
				if(idx == "4")
					$("#rssList4").show();
				
				if(idx == "5")
					$("#rssList5").show();
				
			}
			 
			
			// RSS 목록 조회
			function fnInitRss(feed, target){
				
				if(feed.length == 0)
				{
					return;
				}
					
					
				$.ajax({
				    url: feed,
				    dataType: "xml",
				    type: 'GET',
				    success: function(res) {
						var myXML = res.responseText;
						
						// This is the part xml2Json comes in.
						var JSONConvertedXML = $.xml2json(myXML);
						
						var innerHtml = "";
						
						target.empty();
						
								
						for(var i = 0; i < JSONConvertedXML.channel.item.length; i++){
							//$('#myXMLList').append('<li><a href="#">'+JSONConvertedXML.book.character[i].name+'</a></li>')
							
							var filter = "win16|win32|win64|mac";
							if( navigator.platform  ){
						        if( filter.indexOf(navigator.platform.toLowerCase())<0 ){
						        	var title = JSONConvertedXML.channel.item[i].title;
									var titleLen = title.length;
									var titleSub = "";
									
									if(titleLen > 25){
										titleSub = title.substring(0,25)+".....";
									}else{
										titleSub = JSONConvertedXML.channel.item[i].title;
									}
						        	
									innerHtml += '<tr>';
//		 							innerHtml += '<td style="display: inline-block; width: 95%; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">'
									innerHtml += '<td style="display: inline-block; width: 100%; overflow: hidden; text-overflow: ellipsis;">'
									innerHtml += ' <a href="'+JSONConvertedXML.channel.item[i].link+'"  title="게시물로 이동" target="_blank">';
									innerHtml += titleSub;
									innerHtml += ' </a>';
									innerHtml += '</td>';
									innerHtml += '</tr>';
									
					        }else{
								
								innerHtml += '<tr>';
//	 							innerHtml += '<td style="display: inline-block; width: 95%; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">'
								innerHtml += '<td style="display: inline-block; width: 100%; overflow: hidden; text-overflow: ellipsis;">'
								innerHtml += ' <a href="'+JSONConvertedXML.channel.item[i].link+'"  title="게시물로 이동" target="_blank">';
								innerHtml += JSONConvertedXML.channel.item[i].title;
								innerHtml += ' </a>';
								innerHtml += '</td>';
								innerHtml += '</tr>';
						        }
						    }


							
							
							
	
                        
						
											
						}
						
						target.append(innerHtml);
						
				    }
				});
			}
			
		</script>	
		
	    
	</head><!-- End of head -->

<body>

	<form:form commandName="mcmShpOrd001VO" name="mcmShpOrd001VO" method="post">
		<form:hidden path="gdsId" />
		<form:hidden path="lcsId" />
		<form:hidden path="gdsAmt" />
		<form:hidden path="ordCnt" />
		<form:hidden path="ordAmt" />
		<form:hidden path="ordDiv"/>
		
		
		
		
		
		
<header>
	<%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcHeaderInclude.jsp" %>
</header><!-- End of header -->   
    
<article>

    <div id="content_box">
        <div class="content_1">
            
            <div class="box_1">
            
	            <h1>${resultInfo.gdsNm}</h1>
	            <%-- <img src="<c:url value='/images/dang_content1.jpg' />" alt="" /> --%> 
	            <img src="<c:url value='/McmGdsMnImg.do' />?gdsId=${ resultInfo.gdsId }&divCd=1" alt="" >
	            </div>
	            
	            
	            <div class="box_2">
	            	
	            	<div class="box_2_mar">
	            
			            <h1><fmt:formatNumber value="${resultInfo.selCnt}" groupingUsed="true"/><span>개</span></h1>
			            
			            
			            <div class="back_gauge">
			            	<div id="rateLine" class="gaugebar"></div>
			            	<div class="gaugebar_text"><c:out value="${resultInfo.selRt }" /> %</div>
			            </div>
			            
			            
			            <p class="m_margin">(판매수량 : <fmt:formatNumber value="${resultInfo.selCnt}" groupingUsed="true"/> 개 / 총판매수량 : <fmt:formatNumber value="${resultInfo.gdsCnt}" groupingUsed="true"/> 개)</p>
                    
                    
		                <ul class="box_2_ul">
		                    <li><b>판매가</b> : <span class="line-through"><fmt:formatNumber value="${resultInfo.gdsGnrAmt}" groupingUsed="true"/></span><small>원</small></li>
		                    
		                    
		                    
		                    <c:if test="${ 'N' eq resultInfo.gdsSaleYn }">
		                    	<li class="b_line"><b>회원가</b> : <span><fmt:formatNumber value="${resultInfo.gdsMbAmt}" groupingUsed="true"/></span><small>원</small> <span class="position"><big><b>${resultInfo.salRt}%</b></big></span></li>
		                    </c:if>
		                    
		                    <c:if test="${ 'Y' eq resultInfo.gdsSaleYn }">
		                    	<li class="b_line"><b>회원가</b> : <span  class="line-through"><fmt:formatNumber value="${resultInfo.gdsMbAmt}" groupingUsed="true"/></span><small>원</small> <span class="position"><big><b>${resultInfo.salRt}%</b></big></span></li>
		                    	<li class="b_line"><b>할인가</b> : <span><fmt:formatNumber value="${resultInfo.gdsSaleAmt}" groupingUsed="true"/></span><small>원</small></li>
		                    </c:if>
		                    
		                   <!--  <li class="select_box">
		                        <b>옵션</b> : 
		                        <select name="" id="">
		                            <option value="">선택하세요</option>    
		                        </select>
		                    </li> -->
		                    <li><b>수량</b> : <input type="text" name="ordCntMask" id="ordCntMask" style="text-align:right;" value="0"/>
		                        <a href="#;" class="plus" id="btnAddCnt">+</a>
		                        <a href="#;" class="minus" id="btnMinusCnt">-</a>
		                    </li>
		                    <div class="result">
	                            <h1 id="ordTotAmtMask"></h1> 
	                            <h1><small>원</small></h1>
	                        </div>
						</ul>
		                    
			            
			            <div class="titi">
			            	<a href="#;" id="btnGoCart" class="ti"><img src="<c:url value='/images/brochure/dang_ticat.png' />" alt=""/><h2>장바구니담기</h2></a>
			            	<a href="#;" id="btnGoOrd" class="ti_2"><h2>바로 구매</h2></a>
			            </div>
	            
	            </div>
            </div>
            
        </div><!-- End of content_1 -->
        <div class="content_2">
            <%-- <div><h2><img src="<c:url value='/images/dang.png' />" alt="당당충주" title="당당충주" id="ps_1"/></h2></div>
            <div><h2><img src="<c:url value='/images/ytn.png' />" alt="YTN뉴스" title="YTN뉴스" id="ps_2"/></h2></div>
            <div><h2><img src="<c:url value='/images/lightworld.png' />" alt="라이트월드" title="라이트월드" id="ps_3"/></h2></div>
            <div><h2><img src="<c:url value='/images/chance.png' />" alt="매칭찬스비즈" title="매칭찬스비즈" id="ps_4"/></h2></div> --%>
        </div><!-- End of content_2 -->
        
        <div class="content_3">
            <h3>상품 설명</h3>
            <div class="line"></div>
           
           
           
           
           <c:if test="${ not empty prInfo.itrCnts }">
           
	           <div class="box_3">
	                 <div class="box_3_text" id="box_3_text1">
	                        <c:out value="${fn:replace(prInfo.itrCnts, cn, br)}"  escapeXml="false" />
	                        
	                 </div>
	            </div> 
            </c:if>
            
            
            <%-- 
            <div id="iframe_0">
             	<iframe title="자연에서 숙성 된 꾸지뽕의 효능은?" width="100%" height="682" src="http://tv.kakao.com/embed/player/cliplink/303838054?service=kakao_tv" allowfullscreen frameborder="0" scrolling="no"></iframe>
            </div> 
			 --%>
            
            
            <c:forEach items="${ gdsCntsList }" var="gdsCnts" varStatus="status">
            	<c:if test="${status.first}" >
            		<div id="box_3_con" class="box_3_con slider_0_1">
            	</c:if>
            	<c:if test="${not status.first}" >
            		<div id="box_3_con" class="box_3_con">
            	</c:if>
            		
            		
            			<div class="box_3_img"><img src="<c:url value='/McmGdsDtlImg.do' />?gdsId=${ gdsCnts.gdsId }&seqNo=${ gdsCnts.seqNo }" alt="" /></div>
		                 <div class="box_3_text" id="box_3_text2">
		                    <h2>${ gdsCnts.gdsSbj }</h2><br>
		                    <p><c:out value="${fn:replace(gdsCnts.gdsCnts, cn, br)}"  escapeXml="false" /></p> <br>
		                </div>
            	
            		</div>
            	
            </c:forEach>
            
           
               
<%--
                <div id="box_3_con" class="box_3_con">
		                 <div class="box_3_img"><img src="<c:url value='/images/dang_Web_2.jpg' />" alt=""></div>
		                 <div class="box_3_text" id="box_3_text4">
		                     
		                    <h2>꾸지뽕에 함유된 가바 성분!!</h2><br>
		
		                    <p>꾸지뽕에는 '가바'라는 성분도 들어 있는데,
		                    가바는 포유류의 뇌 속에 존재하는 신경전달물질 중의 하나로 뇌혈류 개선, 
		                    기억력 개선 뿐만 아니라 혈액 내에서 중성지방을 줄이고 간 기능을 높이는데도 
		                    도움이 되는 성분입니다.</p>
		
		                    <p>일반 오디뽕잎의 4.6배, 녹차의 46배정도가 많이 들어 있어 혈당을 낮춰주고 
		                    인슐린을 생산하는 췌장의 부담을 줄여 준다고 합니다</p>
		                    
		                    <div class="box_3_con_hide_2" style="font-size:14px;"><!-- 모바일에서 hide pc에서 show-->
		                        
		                    <p>그외에도 꾸지뽕(구지뽕, 꾸지뽕) 효능으로는 미네랄이 풍부해서 체내 포도당 
		                    이용률을 높이고 인슐린 분비를 조절하여 혈당 조절에도 도움을 줍니다.</p>
		
		                    <p>생리 활성 물질 함량이 높으며 비타민 B1, B2, C가 풍부, 무기질 함량이 높고, 
		                    가바, 루틴 풍부하여 당뇨 및 고혈압에 도움을 준다고 합니다.
		                    고성군의 특화상품, 동의보감에도 알려져 있으며, 건강한 
		                    안심 먹거리로 알려져 있습니다.</p>
		                    </div>
		                    
		                    <p class="rel"><span class="slider_2">더보기 ▼</span></p>
		                </div>
               </div>
 --%>               
               
               
                 
	           	<h3>관련최신뉴스</h3>
	           	<div class="line"></div>
               
               <%-- RSS 링크 처리 부분 --%>
               <div class="tab_cap">
               
               		<c:forEach items="${ keywordList }" var="keywordInfo" varStatus="status">
		                   <div  class="tab1" onclick="fnKeywordTab('${ status.count }');">${ keywordInfo.kwdNm }</div>		                   	
               		</c:forEach>
                   
                   
               </div>
               <div class="main_table_cap" id="rssList1" style="display:none;">
                    <table id="rssTable1">
                       <!--  <tr>
                            <th style="width:10%;">순번1</th>
                            <th style="width:90%;">제목</th>                            
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                        </tr> -->
                    </table>
               </div>
               <div class="main_table_cap" id="rssList2" style="display:none;">
                    <table id="rssTable2">
                        <!-- <tr>
                            <th style="width:10%;">순번2</th>
                            <th style="width:90%;">제목</th>                            
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                        </tr> -->
                    </table>
               </div>
               <div class="main_table_cap" id="rssList3" style="display:none;">
                    <table id="rssTable3">
                        <!-- <tr>
                            <th style="width:10%;">순번3</th>
                            <th style="width:90%;">제목</th>                            
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                        </tr> -->
                    </table>
               </div>
               <div class="main_table_cap" id="rssList4" style="display:none;">
                    <table id="rssTable4">
                       <!--  <tr>
                            <th style="width:10%;">순번4</th>
                            <th style="width:90%;">제목</th>                            
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                        </tr> -->
                    </table>
               </div>
               <div class="main_table_cap" id="rssList5" style="display:none;">
                    <table id="rssTable5">
                       <!--  <tr>
                            <th style="width:10%;">순번5</th>
                            <th style="width:90%;">제목</th>                            
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                        </tr> -->
                    </table>
               </div>
              <!--카트넣기 영역 시작-->
				<div id="cartPop" style="display: none;">
					<div style="background-color:#fff;position: absolute; margin-left:157px; top:541px; left:50%; text-align:center; 
											font-family:'맑은 고딕','Malgun Gothic','Apple SD Gothic Neo',AppleGothic,'돋움',Dotum,'굴림',Gulim,Helvetica,sans-serif;">
						<div class="popYUIArea" style="width:268px; border:solid 1px #d7242b; ">
							<div class="popYUI_tit" style="background-color:#d7242b; position: relative; height:40px; line-height:37px;">
								<h1 style="padding:0 0 0 20px; line-height:37px; font-size: 16px; color:#fff; font-weight:bold;">장바구니에 담기</h1>
							</div>
							<div class="popYUI_cont" style="margin:0 20px; padding: 20px 0 20px 0;">
								<dl class="yesAlertDl">
									<dt style="padding-bottom: 4px; line-height:1.3em; font-size: 14px; color: #333; font-weight: bold; letter-spacing:-1px;">상품이 카트에 담겼습니다.</dt>
									<dd style="line-height:16px; color:#666;">
										<p style="line-height:18px;color:#666;display: block; text-align:center;">
											바로 확인하시겠습니까?
										</p>
									</dd>
								</dl>	
								<br/>
								<div class="popYUI_botBtn">
									<a href="#;" id="btnCartYes">
									<span style="padding:0; width:78px; border-color:#d7242b;border-bottom-color: #165fa1;border-right-color: #165fa1;background-color: #d7242b;
									    display: inline-block; zoom: 1; vertical-align: top;">
										<em style="color: #fff !important; font-style:normal;position: relative; padding: 0; overflow: hidden; line-height: 26px; font-size:12px; font-weight : bold; text-indent: 0; cursor:pointer; 
										display:inline-block; zoom:1; text-align: center; vertical-align: top;">예</em></span>
									</a>
									<a href="#;" id="btnPopClose">
									<span style="padding:0; width:78px; border-color:#d7242b;border-bottom-color: #165fa1;border-right-color: #165fa1;background-color: #d7242b;
									    display: inline-block; zoom: 1; vertical-align: top;">
										<em style="color: #fff !important; font-style:normal;position: relative; padding: 0; overflow: hidden; line-height: 26px; font-size:12px; font-weight : bold; text-indent: 0; cursor:pointer; 
										display:inline-block; zoom:1; text-align: center; vertical-align: top;">아니오</em></span>
									</a>
								</div>
							</div>
							<div class="btn-r">
								<a href="#;" class="cbtn" id="btnPopClose">Close</a>
							</div>
						</div>
					</div>
				</div>

               
               
              
               
               
        </div><!-- End of content_3 -->
    </div><!-- End of content_box -->
</article><!-- End of article -->
    
<footer>

    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmBrcFooterInclude.jsp" %>
    
</footer><!-- End of footer -->


</form:form>
</body><!-- End of body -->

</html>