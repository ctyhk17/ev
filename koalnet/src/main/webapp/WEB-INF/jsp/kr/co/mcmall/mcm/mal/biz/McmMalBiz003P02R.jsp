<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmTplTpl003M01L.jsp
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
					$("#btnAdd").click(function(){
						fnAdd();
					})
					
					fnInfoView($("[name=resultList]"));
				});
				
				function fnClose(){
					close();
				}
				
				function fnFind(){
					var usrNm        = $('#usrNm').val();
					var telNo        = $('#telNo').val();
					var usrNm2       = "";
					var telNo2       = "";
					var usrId        = "";
					var emailAddr    = "";
					var innerHTML    = "";
					var lcsId        = "";
					jQuery.ajaxSettings.traditional=true;
					$.post(
							"<c:url value='/McmMalBiz003P03CP.do'/>",
							{
								"usrNm":usrNm,
								"telNo":telNo
							},
							function(result){
								innerHTML = "<table><tr style='text-align:center;'><th></th><th>아이디</th><th>이름</th><th>연락처</th><th>이메일</th></tr>";
								for(var i=0; i<result.list.length; i++)
								{
									usrId     = result.list[i].usrId;
									usrNm2    = result.list[i].usrNm;
									emailAddr = result.list[i].emailAddr;
									telNo2    = result.list[i].telNo;
									lcsId     = result.list[i].lcsId;
									innerHTML += "<tr style='text-align:center;' name='resultList' usrId='"+usrId+"' lcsId='"+lcsId+"'>"
											  +  "<td><input type='checkbox' class='checkChoice' value='"+lcsId+"'></td>"
											  +  "<td>"+usrId+"</td>"
											  +  "<td>"+usrNm2+"</td>"
											  +  "<td>"+telNo2+"</td>"
											  +  "<td>"+emailAddr+"</td>"
											  +  "<td id='lcsId' style='display:none;'>"+lcsId+"</td>"
											  +  "</tr>";
									
								}
								innerHTML += "</table>";
							},
							"json"
									
					).done(function(){
						$('.result').html(innerHTML);
						fnInfoView($("[name=resultList]"));
					})
					.fail(function(){
						alert("검색 실패하였습니다.");
					})
					
				}
				
				function fnInfoView(obj){
					obj.css("cursor","pointer").click(function(){
						
						 $("#usrId").val($(this).attr("usrId"));
						 $("#lcsId").val($(this).attr("lcsId"));
						 
						 
					}); 
				  }
				
				function fnSendToUsrId(){
					var str = $("#usrId").val();
					$("#usrId",opener.document).val(str);
					
					window.close();
				};
				
				function fnAdd(){
					 var upLcsId= $('#upLcsId').val();
					 var usrId = $('#usrId').val();
					 var lcsId = new Array();
					 
					 $(".checkChoice:checked").each(function(){
						 lcsId.push($(this).val());
						 
					 });
					 jQuery.ajaxSettings.traditional = true;
					 $.post(
						"<c:url value='/McmMalBiz003P02CP.do'/>",
					 {
						"upLcsId":upLcsId,
						"lcsId":lcsId,
						"usrId":usrId,
					 },
					 function(result){
						 alert('등록이 완료 되었습니다.');
					 },
					 "json"
					 
					 ).done(function(){
						 window.opener.document.location.reload();
						 window.close();
					 }).fail(function(){
						 alert('ID를 확인해 주세요.');
					 })
				 };
				
			</script>
	<body>
		<form:form commandName="mcmMalBiz003VO" name="mcmMalBiz003VO" method="post">
			<form:hidden path="usrId"/>
			<form:hidden path="lcsId"/>
			<form:hidden path="upLcsId"/>
		    <div class="popup">
		        <div>
		            <h2 class="title">회원검색</h2>
		        </div>
		        <div class="popup_input">
		            <span>이름: <form:input path="usrNm"/></span>
		            <span>연락처: <form:input path="telNo"/></span> 
		            <div class="popup_button_box"><a href="#" id="btnFind" class="popup_button" style="padding:6px;">찾기</a></div>
		        </div>
		       
		        <div class="result">
		            <table>
		                <!-- <tr>
		                    <th>111</th>
		                    <th>222</th>
		                    <th>333</th>
		                    <th>444</th>
		                </tr>
		                <tr>
		                    <td>111</td>
		                    <td>222</td>
		                    <td>333</td>
		                    <td>444</td>
		                </tr>
		                <tr>
		                    <td>111</td>
		                    <td>222</td>
		                    <td>333</td>
		                    <td>444</td>
		                </tr> -->
		            </table>
		        </div>
		        <div class="close">
		            <a href="#" id="btnAdd">등록</a>
		            <a href="#" id="btnClose">닫기</a>
		        </div>
		    </div>
		</form:form>
	</body><!-- End of body -->

</html>