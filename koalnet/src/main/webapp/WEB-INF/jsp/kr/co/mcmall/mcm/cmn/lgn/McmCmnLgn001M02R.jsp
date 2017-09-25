<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"      uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
  /**
  * @Class Name : McmCmnLgn001M02R.jsp
  * @Description : ID , PWD 찾기
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2017.05.30            최초 생성
  *
  * author 개발팀
  * since 2017.05.30
  *
  */
%>


<!DOCTYPE html>
<html lang="ko">
	
	<head>
	
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 모바일 -->
	    
	    <title>당당충주</title>
	    
	    
	    <!-- 스타일 시트 -->
	    <link rel="stylesheet" href="<c:url value='/css/brochure/brochure.css' />"> <!-- css.index -->
	    <link rel="stylesheet" href="<c:url value='/css/jquery-ui.css' />"> <!-- css.index -->
	    
	    
	    <!-- Jquery JS -->
	    <script type="text/javascript"  src="<c:url value='/js/jquery-1.10.2.js' />"></script>
	    <script type="text/javascript"  src="<c:url value='/js/jquery.number.min.js' />"></script>
	    <script type="text/javascript"  src="<c:url value='/js/jquery.maskedinput.min.js' />"></script>
	    <script type="text/javascript" src="<c:url value='/js/jquery-ui-1.12.0.js' />"></script>
	    
	    <script type="text/javascript" src="<c:url value='/js/jquery.checkbyte.js' />"></script>
	    <script type="text/javascript" src="<c:url value='/js/jquery.textchange.js' />"></script>
	    <script type="text/javascript" src="<c:url value='/js/jquery.uamatch.js' />"></script>
	    
	    
	    <!-- Custom JS -->
	    <script type="text/javascript"  src="<c:url value='/js/common.js' />"></script>    
	    <script  type="text/javascript" src="<c:url value='/js/admin/admin.js'/>"></script>
	    
	    
	    <script type="text/javascript">
	    
	    	$(document).ready(function(){
	    		
	    		// 아이디 찾기
	    		$("#btnSearchId").click(function(){
	    			fnSearchId();
	    		});
	    		
	    		// 비밀번호 찾기
	    		$("#btnSearchPwd").click(function(){
	    			fnSearchPwd();
	    		})
	    	});
	    	
	    	// 아이디 찾기
	    	function fnSearchId(){
	    		
	    		var searchIdByUsrNm = $('#searchIdByUsrNm').val();
	    		var searchIdByTelNo = $('#searchIdByTelNo').val();
	    		
	    		if(searchIdByUsrNm.length == 0)
    			{
    				alert("이름을 입력하세요.");
    				$('#searchIdByUsrNm').focus();
    				return;
    			}
	    		
	    		if(searchIdByTelNo.length == 0)
    			{
    				alert("전화번호를 입력하세요.");
    				$('#searchIdByTelNo').focus();
    				return;
    			}
	    		
	    		var resultMsg     = "검색된 아이디 : ";

	    		$.post(
	            		"<c:url value='/McmCmnLgn001P02R.do'/>",
	            		{
	            			"searchIdByUsrNm":searchIdByUsrNm,
	            			"searchIdByTelNo":searchIdByTelNo 
	            		},
	           			function(responseText){
	            			
	            			
	            			if(responseText.rtnList.length > 0){
	            				for(var i=0; i<responseText.rtnList.length; i++){
		            				
		            				resultMsg += responseText.rtnList[i].usrId + "&nbsp;&nbsp;&nbsp;";
		            			}	
	            			}else{
	            				resultMsg = "검색된 아이디가 존재하지 않습니다.";
	            			}
	            			
	            			
	            			$("#resultIdArea").show();
	            			$("#resultId").html(resultMsg);
	            			
	            		},
	            		"json"
	            	  ).done(function(){
                      })
                    .fail(function(){
                       alert("처리도중 오류가 발생하였습니다.");
                    })	
	    	};
	    	
	    	
	    	// 비밀번호 찾기
	    	function fnSearchPwd(){
	    		
	    		var searchPwdByUsrId = $('#searchPwdByUsrId').val();
	    		var searchPwdByUsrNm = $('#searchPwdByUsrNm').val();
	    		var searchPwdByTelNo = $('#searchPwdByTelNo').val();
	    		
	    		
	    		if(searchPwdByUsrId.length == 0)
    			{
    				alert("아이디를 입력하세요.");
    				$('#searchPwdByUsrId').focus();
    				return;
    			}
	    		
	    		
	    		if(searchPwdByUsrNm.length == 0)
    			{
    				alert("이름을 입력하세요.");
    				$('#searchPwdByUsrNm').focus();
    				return;
    			}
	    		
	    		if(searchPwdByTelNo.length == 0)
    			{
    				alert("전화번호를 입력하세요.");
    				$('#searchPwdByTelNo').focus();
    				return;
    			}
	    		
	    		
	            $.post(
					"<c:url value='/McmCmnLgn001P02RP.do'/>",
	            	{
	            			  "searchPwdByUsrId":searchPwdByUsrId
	            			, "searchPwdByUsrNm":searchPwdByUsrNm
	            			, "searchPwdByTelNo":searchPwdByTelNo
	            			
	            	},
	           		function(responseText){
	            		
	            		alert(responseText.rtnMsg);
	            		$("#resultPwdArea").show();
	            		$("#resultPwd").html(responseText.rtnMsg);
	            	},
	            	"json"
	            )
				.done(function(){
                })
                .fail(function(){
					alert("처리도중 에러가 발생하였습니다.");
                })	
	    		
	    	}
		</script>
			
			
	</head><!-- End of head -->

	<body>

	<form:form commandName="mcmCmnLgn001VO" name="mcmCmnLgn001VO" method="post">
			<header>
	   <div id="header_box">
	         <div class="back1">
	<!--            <div class="story">Story</div>-->
	            <div class="logo"><h2><a href="<c:url value="/McmMalItr001M01L.do"/>"><img src="<c:url value="/images/brochure/w_logo.png"/>"></a></h2></div>
	         </div>
	           <div class="back">
	            <ul class="footer_box">
	<!--            <li><img src="../images/m.png" alt="매칭찬스" title="매칭찬스"></li>-->
	         <%--    <li><img src="<c:url value="/images/brochure/t.png"/>" alt="트위터" title="트위터"></li>
	            <li><img src="<c:url value="/images/brochure/f.png"/>" alt="페이스북" title="페이스북"></li> --%>
	            </ul>
	        </div>
	    </div>
	</header>
		
		<article>
    <div id="content_box">
   
        <div class="sub_content_1">
            
            <div class="sub_box_1">
            <h1><!--<img src="../images/dang_logo_1.png" alt="">--> 아이디/비밀번호 찾기</h1>
            <div class="line" id="line_top"></div> 
            </div>
            <div id="main_box">
               <div class="search_id">
                   <h2>ID SEARCH</h2>
               </div>
               <div class="search_id_box">
                   <div><h3><span>▶이름</span> <form:input path="searchIdByUsrNm" /></h3></div>
                   <div><h3><span>▶전화번호</span> <form:input path="searchIdByTelNo" /><a href="#" class="id_check" id="btnSearchId">찾기</a></h3></div>
	                    <ul id="resultIdArea" style="display:none;">
		             	   <li id="resultId" style="width:100%; list-style: none;"></li>
		            	</ul>
               </div>
               
               <div class="search_pw">
                   <h2>PASSWORD SEARCH</h2>
               </div>
               <div class="search_id_box">
                   <div><h3><span>▶아이디</span> <form:input path="searchPwdByUsrId" /></h3></div>
                   <div><h3><span>▶이름</span> <form:input path="searchPwdByUsrNm" /></h3></div>
                   <div><h3><span>▶전화번호</span> <form:input path="searchPwdByTelNo" /><a href="#" class="id_check" id="btnSearchPwd">찾기</a></h3></div>
	                    <ul id="resultPwdArea" style="display:none;">
		                  <li id="resultPwd" style="width:100%; list-style: none;"></li>
		            	</ul>
               </div>
            </div>
        </div><!-- End of content_1 -->

    </div><!-- End of content_box -->
</article><!-- End of article -->
		
		
		
		<%-- <div class="header_cap">
			<div class="header">
				<a href="<c:url value='/cmn/itr/DdCmnItr000R.do' />"><img src="<c:url value='/images/koalnet/web_img/b_logo4.png' />"  alt="" style="width:254px"></a>
				<p><b>충주시</b>와 만들어가는 <b>당뇨로부터 당당한 대한민국</b></p>
		   </div>
		</div>
  
		<div class="signup">
	       <div class="tilte_dang">
	           <h1><img src="<c:url value='/images/koalnet/web_img/dang_logo_1.png' />" alt="" /> 아이디/비빌번호 찾기</h1>
	       </div>
	       <div class="line_padding">
	            <div class="sub_title id_search">
	                   <p>아이디 찾기</p>
	            </div>
	            <div class="line_border"></div>
	            <ul>
	                <li style="width:28%;"><p>▶ 이름</p></li>
	                <li style="width:72%;"><form:input path="searchIdByUsrNm" /></li>
	            </ul>
	            <ul>
	                <li style="width:28%;"><p>▶ 전화번호</p></li>
	                <li style="width:42%;"><form:input path="searchIdByTelNo" /></li>
	                <li style="width:30%; text-align:right;"><a href="#" class="id_check" id="btnSearchId">찾기</a></li>
	            </ul>
	            
	            <ul id="resultIdArea" style="display:none;">
	                <li id="resultId" style="width:100%;"></li>
	            </ul>
	            
	            <div class="sub_title pw_search">
	                   <p>비밀번호 찾기</p>
	            </div>
	            <div class="line_border"></div>
	            <ul>
	                <li style="width:28%;"><p>▶ 아이디</p></li>
	                <li style="width:72%;"><form:input path="searchPwdByUsrId" /></li>
	            </ul>
	            <ul>
	                <li style="width:28%;"><p>▶ 이름</p></li>
	                <li style="width:72%;"><form:input path="searchPwdByUsrNm" /></li>
	            </ul>
	            <ul>
	                <li style="width:28%;"><p>▶ 전화번호</p></li>
	                <li style="width:42%;"><form:input path="searchPwdByTelNo" /></li>
	                <li style="width:30%; text-align:right;"><a href="#" class="id_check" id="btnSearchPwd">찾기</a></li>
	            </ul>
	            
	            <ul id="resultPwdArea" style="display:none;">
	                <li id="resultPwd" style="width:100%;"></li>
	            </ul>
	      </div>
	    </div> 
		
		<div class="footer_cap">
			<div class="footer">
				<a href="http://www.chungju.go.kr" target="_blank"><img src="<c:url value='/images/koalnet/web_img/dang.png' />"  alt="" style="width:150px"></a>
				<p>(27339) 충청북도 충주시 으뜸로 21(금릉동)　전화번호 : 043-850-0760~3 <br>
					Copyright ⓒ 2017 당뇨건강생활사회적협동조합. All rights reserved.</p>
			</div>
		</div> 	
 --%>

	
</form:form>	
	</body><!-- End of body -->

</html>