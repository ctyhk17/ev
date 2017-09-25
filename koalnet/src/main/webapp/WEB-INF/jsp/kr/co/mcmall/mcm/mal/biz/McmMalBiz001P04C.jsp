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
					
					fnInfoView($("[name=resultList]"));
				});
				
				function fnClose(){
					close();
				}
				
				function fnFind(){
					var strId        = $('#strId').val();
					var strNm        = $('#strNm').val();
					var strId2       = "";
					var strNm2       = "";
					var strDm        = "";
					var strCnts      = "";
					var innerHTML    = "";
					jQuery.ajaxSettings.traditional=true;
					$.post(
							"<c:url value='/McmMalBiz001P04CP.do'/>",
							{
								"strId":strId,
								"strNm":strNm
							},
							function(result){
								innerHTML = "<table><tr style='text-align:center;'><th>상점 아이디</th><th>상점명</th><th>상점설명</th><th>상점URL</th></tr>";
								for(var i=0; i<result.list.length; i++)
								{
									strId2    = result.list[i].strId;
									strNm2    = result.list[i].strNm;
									strDm     = result.list[i].strDm;
									strCnts   = result.list[i].strCnts;
									innerHTML += "<tr style='text-align:center;' name='resultList' strId='"+strId2+"'>"
											  +  "<td>"+strId2+"</td>"
											  +  "<td>"+strNm2+"</td>"
											  +  "<td>"+strCnts+"</td>"
											  +  "<td>"+strDm+"</td>"
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
						
						 $("#strId").val($(this).attr("strId"));
						 
						 fnSendToUsrId();
					}); 
				  }
				function fnSendToUsrId(){
					var str = $("#strId").val();
					$("#strId",opener.document).val(str);
					
					window.close();
				}
				
			</script>
	<body>
		<form:form commandName="mcmMalBiz001VO" name="mcmMalBiz001VO" method="post">
			<form:hidden path="strId"/>
		    <div class="popup">
		        <div>
		            <h2 class="title">상점검색</h2>
		        </div>
		        <div class="popup_input">
		            <span>상점ID: <form:input path="strId"/></span>
		            <span>상점명: <form:input path="strNm"/></span> 
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
		            <a href="#" id="btnClose">닫기</a>
		        </div>
		    </div>
		</form:form>
	</body><!-- End of body -->

</html>