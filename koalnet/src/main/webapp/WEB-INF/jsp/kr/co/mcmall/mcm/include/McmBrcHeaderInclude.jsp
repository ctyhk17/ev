<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>

<input type="hidden" name="upMenuId"  id="upMenuId"  value=""/>
<input type="hidden" name="subMenuId" id="subMenuId" value=""/>


	<div id="menu_m">
		        <div id="on">
		           <div id="one" class="first"></div>
		           <div id="two" class="second"></div>
		           <div id="three" class="third"></div>
		        </div>
		        <ul>
		            <li><a href="<c:url value='/McmMalItr001M01L.do' />">홈</a></li>
		
					<c:if test="${ empty userInfoVO  }">
			            <li><a href="<c:url value='/McmCmnLgn001M01R.do' />">로그인</a></li>
			            <li><a href="<c:url value='/McmCmnUsr001M01C.do' />">회원가입</a></li>
			        </c:if>
			        
			        <c:if test="${ not empty userInfoVO  }">
			        	<li><a href="<c:url value='/McmCmnUsr001M03U.do' />?upMenuId=M002&subMenuId=M002001">MY PAGE</a></li>
		            	<li><a href="<c:url value='/McmCmnLgn001M99RP.do' />">로그아웃</a></li>
			        </c:if>
		            
		        </ul>
	</div>
		 

   <div id="header_box">
   	
         <div class="back1">
            <div class="story"><a href="<c:url value='/McmShpOrd002M01L.do?upMenuId=M001&subMenuId=M001001' />">My Page</a></div> <!-- 추가 마이페이지버튼 -->
            <div class="logo"><h2><a href="<c:url value='/McmMalItr001M01L.do' />"><img style="width:75px;" src="<c:url value='/images/main/koalicon2.png' /> "></a></h2></div>
         </div>
           <div class="back">
            <ul class="footer_box">
<!--            <li><a href=""><img src="../images/m.png" alt="매칭찬스" title="매칭찬스"></a></li>-->
             <li><img src="<c:url value='/images/brochure/t.png' />" alt="트위터" title="트위터"/></li>
            <li><img src="<c:url value='/images/brochure/f.png' />" alt="페이스북" title="페이스북"/></li>
            </ul>
        </div>
    </div>