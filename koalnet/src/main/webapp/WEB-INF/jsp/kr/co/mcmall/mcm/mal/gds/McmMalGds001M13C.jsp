<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmMalGds001M001L.jsp
  * @Description : 상품 상세설명 등록
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
	    		$("#fileImg1").change(function() {
					fnReadUploadImage(this);
				});
	    		$("#fileImg2").change(function() {
					fnReadUploadImage2(this);
				});
	    		$("#fileImg3").change(function() {
					fnReadUploadImage3(this);
				});
	    		$("#fileImg4").change(function() {
					fnReadUploadImage4(this);
				});
	    		$("#fileImg5").change(function() {
					fnReadUploadImage5(this);
				});
	    		
	    		$('#btnCancle').click(function(){
	    			$("#McmMalGds001VO").attr("target", "");
					$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M01L.do'/>");
					$("#McmMalGds001VO").submit();
	    		});
	    		$('#btnDetailSave').click(function(){
	    			fnDetailSave();
	    		});
	    		
		});
	    			
	    			function fnDetailSave(){
	    				$("#McmMalGds001VO").attr("target", "");
    					var fileImg1 = document.getElementById("fileImg1");
    					var fileImg1Path = fileImg1.value;
    					
    					var fileImg2 = document.getElementById("fileImg2");
    					var fileImg2Path = fileImg2.value;
    					
    					var fileImg3 = document.getElementById("fileImg3");
    					var fileImg3Path = fileImg3.value;
    					
    					var fileImg4 = document.getElementById("fileImg4");
    					var fileImg4Path = fileImg4.value;
    					
    					var fileImg5 = document.getElementById("fileImg5");
    					var fileImg5Path = fileImg5.value;
    					
    					$('#McmMalGds001VO').ajaxSubmit({
    						url : '/McmMalGds001M13CP.do',
    						type : 'POST',
    						dataType : 'json',
    						complete : function(result){
    							fnResult();
    						},
    						error : function(){
    							alert("실패");
    						}
    					});
    				function fnResult(){
    					$("#McmMalGds001VO").attr("target", "");
    					$("#McmMalGds001VO").attr("action","<c:url value='/McmMalGds001M23C.do' />");
    					$("#McmMalGds001VO").submit();
    				}
    					
	    			}	
			    	function fnUpload(){
			    		$('#fileImg1').click();
			    	}
			    	function fnUpload2(){
			    		$('#fileImg2').click();
			    	}
			    	function fnUpload3(){
			    		$('#fileImg3').click();
			    	}
			    	function fnUpload4(){
			    		$('#fileImg4').click();
			    	}
			    	function fnUpload5(){
			    		$('#fileImg5').click();
			    	}
					function fnReadUploadImage(inputObject) {
						if (window.File && window.FileReader) {
							if (inputObject.files && inputObject.files[0]) {
								if (!(/image/i).test(inputObject.files[0].type)) {
									alert("이미지 파일을 선택해 주세요!");
									return false;
								}
								var reader = new FileReader();
								reader.onload = function(e) {
									$('#img_box').attr('src',e.target.result);
								}
								reader.readAsDataURL(inputObject.files[0]);
							}
						} else {
							alert("이미지를 선택하세요.");
						}
					}
					
					function fnReadUploadImage2(inputObject) {
						if (window.File && window.FileReader) {
							if (inputObject.files && inputObject.files[0]) {
								if (!(/image/i).test(inputObject.files[0].type)) {
									alert("이미지 파일을 선택해 주세요!");
									return false;
								}
								var reader = new FileReader();
								reader.onload = function(e) {
									$('#img_box2').attr('src',e.target.result);
								}
								reader.readAsDataURL(inputObject.files[0]);
							}
						} else {
							alert("이미지를 선택하세요.");
						}
					}
					function fnReadUploadImage3(inputObject) {
						if (window.File && window.FileReader) {
							if (inputObject.files && inputObject.files[0]) {
								if (!(/image/i).test(inputObject.files[0].type)) {
									alert("이미지 파일을 선택해 주세요!");
									return false;
								}
								var reader = new FileReader();
								reader.onload = function(e) {
									$('#img_box3').attr('src',e.target.result);
								}
								reader.readAsDataURL(inputObject.files[0]);
							}
						} else {
							alert("이미지를 선택하세요.");
						}
					}
					function fnReadUploadImage4(inputObject) {
						if (window.File && window.FileReader) {
							if (inputObject.files && inputObject.files[0]) {
								if (!(/image/i).test(inputObject.files[0].type)) {
									alert("이미지 파일을 선택해 주세요!");
									return false;
								}
								var reader = new FileReader();
								reader.onload = function(e) {
									$('#img_box4').attr('src',e.target.result);
								}
								reader.readAsDataURL(inputObject.files[0]);
							}
						} else {
							alert("이미지를 선택하세요.");
						}
					}
					function fnReadUploadImage5(inputObject) {
						if (window.File && window.FileReader) {
							if (inputObject.files && inputObject.files[0]) {
								if (!(/image/i).test(inputObject.files[0].type)) {
									alert("이미지 파일을 선택해 주세요!");
									return false;
								}
								var reader = new FileReader();
								reader.onload = function(e) {
									$('#img_box5').attr('src',e.target.result);
								}
								reader.readAsDataURL(inputObject.files[0]);
							}
						} else {
							alert("이미지를 선택하세요.");
						}
					}

					</script>
	</head>
	<style>
	.pointer{
		cursor: default !important;
	}	
	.pointer:hover{
	background-color: #eeeeee !important;
	}
	</style>    
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
			                            <h3>상품 등록 <small>| 쇼핑몰의 기본적인 상품 상세설명 등록을 할 수 있습니다.</small></h3>
			                        </div>
			                        <%-- 상단 타이틀 끝  --%>
			                        <div class="pointer_cap">
			         					<div class="pointer" id="basicSetTab">기본 설정</a></div>
			                        	<div class="pointer  pointer_active" id="detailSetTab"><a href="#" id="btnDetailGo"  style="color:black">상세 설명</a></div>
			                        	<div class="pointer" id="keywordSetTab">키워드</a></div>
			                        </div>
                              
	                              <div class="content_1_1" id="detailSet">
	                           		 <div class="tab tab_1 tab_1_active list_tab_cap">
	                                    <div class="tab_line tab_1_1 list_tab">
	                                      <div class="cap_margin_top last_child_div">
	                                         
	                                          <div class="list_cap">
	                                             <div class="list_o">설명 1</div>
	                                             <div class="list_l"><img src="<c:url value='/images/admin/example.png' />" alt="" id="img_box" style="height:80px;"></div>
	                                             <div class="list_r"><form:textarea path="gdsCnts1" cols="140" rows="10" placeholder="글쓰기.." name="gdsCnts" /></div>
	                                             <div class="list_last">
	                                             		<p style="width: 35%;margin-left: 38%;font-size: 13px;color: #919191;"> * 이미지사이즈는 가로 662 * 세로 423 픽셀로 생성하여 등록하여 주십시오</p>
<!-- 	                                                 <a href="javascript:fnUpload()" class="list_l_a" id="btnImg">이미지 등록</a> -->
	                                                 <input type="file" id="fileImg1" name="fileImg1" style="display:none;"/>
	                                                 <a href="javascript:fnUpload()" class="list_r_a" id="btnImg">이미지 등록</a>
	                                             </div>
	                                          </div>
	
	                                          <div class="list_cap">
	                                             <div class="list_o">설명 2</div>
	                                             <div class="list_l"><img src="<c:url value='/images/admin/example.png' />" alt="" id="img_box2" style="height:80px;"></div>
	                                             <div class="list_r"><form:textarea path="gdsCnts2" cols="140" rows="10" placeholder="글쓰기.." name="gdsCnts" /></div>
	                                             <div class="list_last">
	                                             		<p style="width: 35%;margin-left: 38%;font-size: 13px;color: #919191;"> * 이미지사이즈는 가로 662 * 세로 423 픽셀로 생성하여 등록하여 주십시오</p>
<!-- 	                                                 <a href="#" class="list_l_a">이미지 등록</a> -->
													 <input type="file" id="fileImg2" name="fileImg2" style="display:none;"/>		
	                                                 <a href="javascript:fnUpload2()" class="list_r_a" id="btnImg">이미지 등록</a>
	                                             </div>
	                                          </div>
	                                          
	                                          <div class="list_cap">
	                                             <div class="list_o">설명 3</div>
	                                             <div class="list_l"><img src="<c:url value='/images/admin/example.png' />" alt="" id="img_box3" style="height:80px;"></div>
	                                             <div class="list_r"><form:textarea path="gdsCnts3" cols="140" rows="10" placeholder="글쓰기.." name="gdsCnts" /></div>
	                                             <div class="list_last">
	                                             		<p style="width: 35%;margin-left: 38%;font-size: 13px;color: #919191;"> * 이미지사이즈는 가로 662 * 세로 423 픽셀로 생성하여 등록하여 주십시오</p>
<!-- 	                                                 <a href="#" class="list_l_a">이미지 등록</a> -->
	                                                 <input type="file" id="fileImg3" name="fileImg3" style="display:none;"/>		
	                                                 <a href="javascript:fnUpload3()" class="list_r_a" id="btnImg">이미지 등록</a>
	                                             </div>
	                                          </div>
	                                          
	                                          <div class="list_cap">
	                                             <div class="list_o">설명 4</div>
	                                             <div class="list_l"><img src="<c:url value='/images/admin/example.png' />" alt="" id="img_box4" style="height:80px;"></div>
	                                             <div class="list_r"><form:textarea path="gdsCnts4" cols="140" rows="10" placeholder="글쓰기.." name="gdsCnts" /></div>
	                                             <div class="list_last">
	                                             		<p style="width: 35%;margin-left: 38%;font-size: 13px;color: #919191;"> * 이미지사이즈는 가로 662 * 세로 423 픽셀로 생성하여 등록하여 주십시오</p>
<!-- 	                                                 <a href="#" class="list_l_a">이미지 등록</a> -->
	                                                 <input type="file" id="fileImg4" name="fileImg4" style="display:none;"/>		
	                                                 <a href="javascript:fnUpload4()" class="list_r_a" id="btnImg">이미지 등록</a>
	                                             </div>
	                                          </div>
	                                          
	                                          <div class="list_cap">
	                                             <div class="list_o">설명 5</div>
	                                             <div class="list_l"><img src="<c:url value='/images/admin/example.png' />" alt="" id="img_box5" style="height:80px;"></div>
	                                             <div class="list_r"><form:textarea path="gdsCnts5" cols="140" rows="10" placeholder="글쓰기.." name="gdsCnts" /></div>
	                                             <div class="list_last">
	                                             		<p style="width: 35%;margin-left: 38%;font-size: 13px;color: #919191;"> * 이미지사이즈는 가로 662 * 세로 423 픽셀로 생성하여 등록하여 주십시오</p>
<!-- 	                                                 <a href="#" class="list_l_a">이미지 등록</a> -->
	                                                 <input type="file" id="fileImg5" name="fileImg5" style="display:none;"/>		
	                                                 <a href="javascript:fnUpload5()" class="list_r_a" id="btnImg">이미지 등록</a>
	                                             </div>
	                                          </div>	                                          
	                                      </div>
	                                      <div class="save_button_2"><a href="#" id="btnDetailSave">저장</a> <a href="#" id="btnCancle">취소</a></div>
	                                  </div><!-- End of tab_1_1 -->
	                            </div>
	                        </div>
						</div>
					</div>	
				</div>
			</div>
		</article>
		<footer>
		    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminFooterInclude.jsp" %>
		</footer><!-- End of footer -->		
	</form:form>	
</body>
</html>