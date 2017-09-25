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

				// 수정처리
				$("#btnUpdate").click(function() {	
					fncUpdate();
				});
				
				// 상세보기 화면으로 이동
				$("#btnGoView").click(function() {	
					fncGoView();
				});
				
				// 행추가
				$("#btnAddRow").click(function() {	
					fncAddRow();
				});
				
				// 길이제한
				$("#adsubItem").checkbyte({ limit:4, title : "항목" });
				$("#adsubDes").checkbyte({ limit:100, title : "내용" });
				$("#adsubGrantDes").checkbyte({ limit:50, title : "가감점 부여 내용" });
				$("#adsubApplProdDes").checkbyte({ limit:10, title : "적용기간" });
				$("#adsubExamDes").checkbyte({ limit:100, title : "적용기간" });
				$("#note").checkbyte({ limit:1000, title : "적용기간" });

			});
			
			
			// 수정처리
			function fncUpdate(){
			
				var adsubMgntNo             = $("#adsubMgntNo").val();
				
				var adsubSlctCd             = $("#adsubSlctCd").val();
				var adsubItem               = $("#adsubItem").val();
				var adsubDes                = $("#adsubDes").val();
				
				var adsubApplOrgSlctCd      = $("#adsubApplOrgSlctCd").val();
				var adsubGrantDes           = $("#adsubGrantDes").val();
				var adsubApplStanDtSlctCd   = $("#adsubApplStanDtSlctCd").val();
				var adsubApplProdDes        = $("#adsubApplProdDes").val();
				var adsubExamDes            = $("#adsubExamDes").val();
				var note                    = $("#note").val();
				
				var adsubTrgtCdArr = new Array();
				$("select[name=adsubTrgtCd]").each(function(i){
					adsubTrgtCdArr.push($(this).val());
				});
				
				
				// 입력값 체크
				if(adsubSlctCd == null || adsubSlctCd.length == 0){
					alert("구분을 선택하세요.");
					$("#adsubSlctCd").focus();
					return;
				}
				
				if(adsubItem == null || adsubItem.length == 0){
					alert("항목을 입력하세요.");
					$("#adsubItem").focus();
					return;
				}
				
				if(adsubDes == null || adsubDes.length == 0){
					alert("내용을 입력하세요.");
					$("#adsubDes").focus();
					return;
				}
				
				if(!fncIsValid())
				{
					return;
				}
				
				if(adsubApplOrgSlctCd == null || adsubApplOrgSlctCd.length == 0){
					alert("적용기관을 선택하세요.");
					$("#adsubApplOrgSlctCd").focus();
					return;
				}
				
				if(adsubGrantDes == null || adsubGrantDes.length == 0){
					alert("가감점 부여 내용을 입력하세요.");
					$("#adsubGrantDes").focus();
					return;
				}
				
				if(adsubApplStanDtSlctCd == null || adsubApplStanDtSlctCd.length == 0){
					alert("적용기준일자를 선택하세요.");
					$("#adsubApplStanDtSlctCd").focus();
					return;
				}
				
				if(adsubApplProdDes == null || adsubApplProdDes.length == 0){
					alert("적용기간을 입력하세요.");
					$("#adsubApplProdDes").focus();
					return;
				}
				
				jQuery.ajaxSettings.traditional = true;
				
				$.post(
						"<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntUProc.do'/>", 
						{ 
							  "adsubMgntNo"           : adsubMgntNo
							, "adsubSlctCd"           : adsubSlctCd           
							, "adsubItem"             : adsubItem            
							, "adsubDes"              : adsubDes                
							, "adsubApplOrgSlctCd"    : adsubApplOrgSlctCd    
							, "adsubGrantDes"         : adsubGrantDes           
							, "adsubApplStanDtSlctCd" : adsubApplStanDtSlctCd 
							, "adsubApplProdDes"      : adsubApplProdDes        
							, "adsubExamDes"          : adsubExamDes            
							, "note"                  : note         
							, "adsubTrgtCdArr"        : adsubTrgtCdArr
						}, 
						function(responseText)
						{
							var rtnMsg = responseText.rtnMsg;
							alert("데이터가 정상적으로 수정되었습니다.") 
							
						}, 
						"json"
				)
				.done(function() {
					fncGoView();
 				})
				.fail(function() {
					alert( "처리 도중 에러가 발생하였습니다." );
				})
				;

			}
			
			
			// 행추가
			function fncAddRow(){
				
				var cnt      = $("select[name=adsubTrgtCd]").length;
				var limitCnt = parseInt('<c:out value="${ adsubTrgtCdListCnt }" />');
				
				if(limitCnt <= cnt){
					alert("대상 구분은 최대 "+limitCnt+"건 입니다.");
					return;
				}
				
				
				var innerHtml = "<tr>";
				innerHtml +=    "    <td style=\"border: 0px; margin-left: 0; margin-top: 0; margin-bottom: 0; padding: 0 0 0 0;  line-height: 33px;\">";
				innerHtml +=    "        <select name=\"adsubTrgtCd\" id=\"adsubTrgtCd\" style=\"width:200px;\" onchange=\"fncDupChkeck(this);\" >";
				innerHtml +=                 $("#adsubTrgtCd").html();
				innerHtml +=    "        </select>";
				innerHtml +=    "        &nbsp;<input type=\"button\" value=\"-\" class=\"btn_gray\" onClick=\"fncDeleteRow(this)\">";
				innerHtml +=    "    </td>";
				innerHtml +=    "</tr>";
				
				innerHtml  = innerHtml.replace(/selected=\"selected\"/gi, ""); 
				
				
				$("#tdAdsubTrgtArea").append(innerHtml);
			}
			
			// 행삭제
			function fncDeleteRow(obj){
				
				
				$(obj).parent().remove();
			}
			
			
			function fncIsValid()
			{
				var flag = true;
				
				$("select[name=adsubTrgtCd]").each(function(i){
					if($(this).val() == null || $(this).val().length == 0){
						alert("대상을 선택하세요.");
						$(this).focus();
						flag = false;
					}
					return;
				});
				
				return flag;
				
			}
			
			// 중복 검사
			function fncDupChkeck(obj)
			{
				
				var param = $(obj).val();
				var cnt = 0;
				
				$("select[name=adsubTrgtCd]").each(function(i){
					if($(this).val() == param){
						cnt++;
					}
				});
				
				if(cnt > 1){
					alert("이미 선택한 대상입니다.");
					$(obj).val("");	
				}
				
			}
			
			
			
			// 상세화면으로 이동
			function fncGoView(){
				
				$("#pjtFnerAdsubMgntVO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntR.do'/>");
				$("#pjtFnerAdsubMgntVO").submit();
			}
			
		</script>	
    
	</head>

	<body>


<form:form commandName="mcmTplTpl001VO" name="mcmTplTpl001VO" method="post">
	
	
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
			                                       
			                                       
			                                        <div class="resize_box">
			                                           <h3>사업장</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back" style="width:30%;"><input type="text"></li>
			                                                <li class="title_back" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back" style="width:30%;"><input type="text"></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back" style="width:30%;"><input type="text"></li>
			                                                <li class="title_back" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back" style="width:30%;"><input type="text"></li>
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back" style="width:auto;"><input type="text"></li>
			                                            </ul>
			                                            <ul>
			                                            	<li class="title_back title_back_p title_back_b" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b" style="width:30%;">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b" style="width:30%;">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                            </ul>
			                                            
			                                            <ul>
			                                            	<li class="title_back title_back_p title_back_b" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b" style="width:auto;">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                                
			                                            </ul>
			                                            
			                                            <ul>
			                                                <li class="title_back title_back_p" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p" style="width:30%;">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p" style="width:30%;">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                            <ul>
			                                                <li class="title_back title_back_p" style="width:16%;">사업장주소</li>
			                                                <li class="sub_back_p" style="width:auto;">
			                                                    <input type="text" >
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">실제 접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                            
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        <!-- <div class="suchen"><a href="#" class="suchen_a">검색</a></div> -->
			                                        
			                                       <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> <a href="#">저장</a></div>
			                                       <%-- 하단 버튼 끝 --%>
			                                       
			                                        
			                                        <div class="resize_box">
			                                           <h3>사업장</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:20%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                            
			                                            <ul>
			                                                <li class="title_back title_back_p title_back_b" style="width:10%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p title_back_b" style="width:20%;">사업장주소</li>
			                                                <li class="sub_back_p sub_back_b">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                        </div><!-- resize_box -->
			                                        <div class="save_button"><a href="#">저장</a></div>
			                                        
			                                        <div class="resize_box">
			                                           <h3>사업장</h3>
			                                            <ul class="re_first">
			                                                <li class="title_back title_back_p" style="width:10%;">사업장주소</li>
			                                                <li class="sub_back_p">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">실제 접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p" style="width:20%;">사업장주소</li>
			                                                <li class="sub_back_p">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">실제 접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                            
			                                            <ul>
			                                                <li class="title_back title_back_p" style="width:10%;">사업장주소</li>
			                                                <li class="sub_back_p">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">실제 접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                                
			                                                <li class="title_back title_back_p" style="width:20%;">사업장주소</li>
			                                                <li class="sub_back_p">
			                                                    <input type="text">
			                                                    <p class="first_text">* 입력시 관리자 화면에 도메인 정보가 노출됩니다.</p>
			                                                    <p class="text_in">실제 접속 도메인의 추가 및 변경은 해당 도메인 사이트에서 가능합니다.</p>
			                                                </li>
			                                               
			                                            </ul>
			                                        </div><!-- resize_box -->
			                                        
			                                        
			                                        <%-- 하단 버튼 시작 --%>
			                                       <div class="save_button"> <a href="#">저장</a></div>
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