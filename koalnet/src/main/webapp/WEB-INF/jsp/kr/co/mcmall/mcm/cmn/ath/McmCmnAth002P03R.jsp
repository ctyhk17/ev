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
	    
	   
<style>
    .popup {width: 100%;margin: 0% auto;max-width: 700px;}
    .popup > div > h2{text-align: center;background: #313c4a;color: white;padding: 5px 0;}
    .popup_input {padding: 15px 0;position: relative;}
    .popup_input > span{margin-left: 10px;display: inline-block;width: 40%;margin-top: 5px;}
    .popup_button {position: absolute;right: 10px;padding: 18px 10px;top: 15px;background: #f29d06;color: white;display: inline-block;}
    .popup_input{background: #ebebeb;}

    .result > table{ width: 100%;}
    .result > table th{background: #727272;color: white;padding: 5px 0;font-size: 16px;}
    .result > table td{padding: 4px 0;color: black;background: #f4f4f4;font-size: 14px;}

    .close {margin-top: 15px;display: inline-block;width: 100%;text-align: center;}
    .close > a{text-decoration: none; color: white; background: #313c4a;padding: 5px 20px;}

    .s_button{display: inline-block;width: 100%;margin: 15px 0 0 0;position: relative;height: 31px;}
    .s_button > a {padding: 5px;display: inline-block;background: #313c4a;color: white;text-decoration: none;position: absolute;right: 2px;}
    /* =================================================================== End of admin_popup =================================================================== */
        
    @media all and (max-width: 500px){

    .popup {width: 100%;margin: 0% auto;max-width: 700px;}
    .popup > div > h2{text-align: center;background: #313c4a;color: white;padding: 5px 0;}
    .popup_input {padding: 15px 0;position: relative;text-align: left;padding-top: 10px;}
    .popup_input > span{margin-left: 15px;display: inline-block;width: 40%;margin-top: 5px;}
    .popup_button_box {margin-top: 20px;position: relative;width: 100%;}
    .popup_button_box > a{position: absolute;top: 0;left: 0;text-align: center;width: 100%;padding: 5px 0;margin: auto;}

    .result {border-top: 2px dashed white;margin-top: 25px;}

    .close {margin-top: 15px;display: inline-block;width: 100%;text-align: right;}
    .close > a{text-decoration: none; color: white; background: #313c4a;padding: 5px 0;width: 100%;display: inline-block;text-align: center;}

    .s_button{display: inline-block;width: 100%;margin: 30px 0 -30px 0;position: relative;height: 32px;}
    .s_button > a {padding: 2px 0;display: inline-block;background: #313c4a;color: white;text-decoration: none;position: absolute;right: 0;width: 100%;text-align: center;bottom: 0;}
    /* =================================================================== End of admin_popup =================================================================== */

    }
</style>
			
	</head><!-- End of head -->
 
	    <script type="text/javascript">
			
				$(document).ready(function () {  
					$("#btnClose").click(function(){
						fnClose();
					})
					$("#btnFind").click(function(){
						fnFind();
					})
					$("#btnAthCd").click(function(){
						fnAthCd();
					})
					$("#btnAthCdLcs").click(function(){
						fnAthCdLcs();
					})
					
					
					$("#chkAll").click(function(){
							if($("#chkAll").prop("checked")) {
								$("input[type=checkbox]").prop("checked",true);
								
							} else {
							$("input[type=checkbox]").prop("checked",false); } 
					});

					
				
					
					fnInfoView($("[name=resultList]"));
				});
				
				
				// 사업자 아이디 생성
				function fnAthCdLcs(){
					var usrIdArray = new Array();
					var athCd = $("#athCd").val();
					
					
				$(".usrIdArray:checked").each(function(){
					usrIdArray.push($(this).val());
					
					
				});
				
				
				jQuery.ajaxSettings.traditional = true;
				$.post(
						"<c:url value='/McmCmnAth002M02CP.do' />",
						{
							"usrIdArray":usrIdArray,
							"athCd"     :athCd
						},
						function(result){
							var res = result.rtnMsg;
							if(res ==1){
								alert('사업자가 등록되었습니다.')
							}
							
						},"json"
						).done(function(){
							
							fnAddLcs();
							
						}).fail(function(){
							alert("이미 등록된 회원입니다.");
							
						}) 
	    	}
				
				// 사업자 CMN001003 코드 넣기
				function fnAddLcs(){
					var usrIdArray  = new Array();
					var athCd       = $("#athCd").val(); 
					
					$(".usrIdArray:checked").each(function(){
						usrIdArray.push($(this).val());
					});
					
					jQuery.ajaxSettings.traditional = true;
					$.post(
							"<c:url value='/McmCmnAth002P01CP.do' />",
							{
								"usrIdArray": usrIdArray,
								"athCd"     : athCd
							},
							function(result){
								
							},"json"
							).done(function(){
								opener.parent.location.reload();
								window.close();
								
							}).fail(function(){
								alert("이미 등록된 회원입니다.");
								document.location.reload();
							}) 
				}
				
				function fnAthCd(){
					var usrIdArray = new Array();
					var athCd = $("#athCd").val();
					
					
				$(".usrIdArray:checked").each(function(){
					usrIdArray.push($(this).val());
				});
				jQuery.ajaxSettings.traditional = true;
				$.post(
						"<c:url value='/McmCmnAth002P01CP.do' />",
						{
							"usrIdArray":usrIdArray,
							"athCd"     :athCd
						},
						function(result){
							alert("등록되었습니다.");
						},"json"
						).done(function(){
							opener.parent.location.reload();
							window.close();
							
						}).fail(function(){
							alert("이미 등록된 회원입니다.");
							document.location.reload();
						}) 
	    	}
				
				function fnClose(){
					close();
				}
				
				function fnFind(){
					$("#pageIndex").val("1");
					
					$("#mcmCmnAth002VO").attr("action", "<c:url value='/McmCmnAth002P03R.do'/>");
					$("#mcmCmnAth002VO").submit();
				}
				
				function fnInfoView(obj){
					obj.css("cursor","pointer").click(function(){
						
						 $("#usrId").val($(this).attr("usrId"));
						 
					}); 
				  }
				
				
				function fnLinkPage(pageNo){
					$("#pageIndex").val(pageNo);
					
					$("#mcmCmnAth002VO").attr("action", "<c:url value='/McmCmnAth002P03R.do'/>");
					$("#mcmCmnAth002VO").submit();
				}
				
				function fnCheck(){
					
					
				}
			</script>
	<body>
		<form:form commandName="mcmCmnAth002VO" name="mcmCmnAth002VO" method="post">
			<form:hidden path="usrId"/>
			<form:hidden path="athCd"/>
			<form:hidden path="strId"/>
			
		    <div class="popup">
		        <div>
		            <h2 class="title">회원검색</h2>
		        </div>
		        <div class="popup_input">
		            <span>이름: <form:input path="searchUsrNm" style="width:70%;" /></span>
		            <span>연락처: <form:input path="searchTelNo" style="width:70%;" /></span> 
		            <div class="popup_button_box"><a href="#" id="btnFind" class="popup_button" style="padding:6px;">찾기</a></div>
		        </div>
		       <div class="suchen_result">전체 <b>${paginationInfo.totalRecordCount}</b>명</div>
		          <div class="flex first_flex">
                                               <ul>
                                                   <li><form:checkbox path="usrIdArray" value="usrIdArray" id="chkAll"/></li>
                                                   <li style="width: 7%;">순번</li>
                                                   <li style="width:18%;">아이디</li>
                                                   <li style="width:19%;">이름</li>
                                                   <li style="width:20%;">전화번호</li>
                                                   <li style="width:27%;">이메일</li>
                                               </ul>
                                           </div>
                                           
                                           
                                           <c:forEach items="${ resultList }" var="resultInfo">
                                           	<div class="flex flex_2" >
                                                <ul>
                                                	<li><form:checkbox path="usrIdArray" value="${resultInfo.usrId}" class="usrIdArray"/></li>
                                                    <li name="resultList" style="width: 7%;" usrId="${ resultInfo.usrId }" strId="${resultInfo.strId }">${ resultInfo.rn }</li>
                                                    <li name="resultList" style="width:18%;" usrId="${ resultInfo.usrId }" strId="${resultInfo.strId }">${ resultInfo.usrId }</li>
                                                    <li name="resultList" style="width:19%;" usrId="${ resultInfo.usrId }" strId="${resultInfo.strId }">${ resultInfo.usrNm }</li>
                                                    <li name="resultList" style="width:20%;" usrId="${ resultInfo.usrId }" strId="${resultInfo.strId }">${ resultInfo.telNo }</li>
                                                    <li name="resultList" style="width:27%;" usrId="${ resultInfo.usrId }" strId="${resultInfo.strId }">${ resultInfo.emailAddr }</li>
                                                </ul>
                                            </div>	
                                           </c:forEach>
                                           
                                           <c:if test="${ empty resultList }" >
                                           	<div class="flex flex_2" >
                                                <ul name="resultList">
                                                    <li style="width: 99%;">조회 결과가 없습니다.</li>
                                                </ul>
                                        	</div>
                                           </c:if>
                                           
                                           <div class="next">
                                           	<ul>
                                                <ui:pagination paginationInfo = "${paginationInfo}" type="image2" jsFunction="fnLinkPage" />
        										<form:hidden path="pageIndex" />
       										</ul>
                                           </div>
		        <div class="close">
		        <c:choose>
		        	<c:when test="${mcmCmnAth002VO.athCd eq 'CMN001003' }">
		            	<a href="#" id="btnAthCdLcs">등록</a>
		            </c:when>
		            <c:otherwise>
		           		 <a href="#" id="btnAthCd">등록</a>
		            </c:otherwise>
		        </c:choose>
		            <a href="#" id="btnClose">닫기</a>
		        </div>
		    </div>
		</form:form>
	</body><!-- End of body -->

</html>