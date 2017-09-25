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
					$("#btnUpLcs").click(function(){
						fnUpLcs();
					})
					
					
					
					fnInfoView($("[name=resultList]"));
				});
				
				
				
				
				function fnUpLcs(){
					
					
					
					var upLcsId = $("input[type=radio]:checked").val(); 
					var usrId      = $("#usrId").val();
					
				
				jQuery.ajaxSettings.traditional = true;
				$.post(
						"<c:url value='/McmMalBiz001P03RP.do' />",
						{
							"usrId"     : usrId,
							"upLcsId"   : upLcsId
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
					
					$("#mcmMalBiz001VO").attr("action", "<c:url value='/McmMalBiz001P03R.do'/>");
					$("#mcmMalBiz001VO").submit();
				}
				
				function fnInfoView(obj){
					obj.css("cursor","pointer").click(function(){
						
						 
						 $("#upLcsId").val($(this).attr("upLcsId"));
					}); 
				  }
				
				
				function fnLinkPage(pageNo){
					$("#pageIndex").val(pageNo);
					
					$("#mcmMalBiz001VO").attr("action", "<c:url value='/McmMalBiz001P03R.do'/>");
					$("#mcmMalBiz001VO").submit();
				}
				
				
			</script>
	<body>
		<form:form commandName="mcmMalBiz001VO" name="mcmMalBiz001VO" method="post">
			<form:hidden path="usrId"/>
			<form:hidden path="strId"/>
			<form:hidden path="lcsId"/>
			<form:hidden path="upLcsId"/>
			
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
                                                   <li></li>
                                                   <li style="width: 7%;">순번</li>
                                                   <li style="width:18%;">아이디</li>
                                                   <li style="width:19%;">이름</li>
                                                   <li style="width:20%;">전화번호</li>
                                                   <li style="width:27%;">이메일</li>
                                               </ul>
                                           </div>
                                           
                                           
                                           <c:forEach items="${ resultList }" var="resultInfo">
                                           	<div class="flex flex_2" >
                                                <ul name="resultList"  strId="${resultInfo.strId }"  upLcsId="${resultInfo.upLcsId}">
                                                	<li><form:radiobutton path="upLcsId" value="${resultInfo.upLcsId}" class="usrId"/></li>
                                                    <li style="width: 7%;">${ resultInfo.rn }</li>
                                                    <li style="width:18%;">${ resultInfo.usrId }</li>
                                                    <li style="width:19%;">${ resultInfo.usrNm }</li>
                                                    <li style="width:20%;">${ resultInfo.telNo }</li>
                                                    <li style="width:27%;">${ resultInfo.emailAddr }</li>
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
		       
		           		 <a href="#" id="btnUpLcs">등록</a>
		            <a href="#" id="btnClose">닫기</a>
		        </div>
		    </div>
		</form:form>
	</body><!-- End of body -->

</html>