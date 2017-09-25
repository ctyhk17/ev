<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String upMenuId = (String)request.getParameter("upMenuId");
	if(upMenuId == null)
		upMenuId = "";
	String subMenuId = (String)request.getParameter("subMenuId");
	if(subMenuId == null)
		subMenuId = "";
	
	request.setAttribute("upMenuId", upMenuId);
	request.setAttribute("subMenuId", subMenuId);
	
%>

<input type="hidden" name="upMenuId"  id="upMenuId"  value="<%= upMenuId %>"/>
<input type="hidden" name="subMenuId" id="subMenuId" value="<%= subMenuId %>"/>


	<div class="heard_border">
             <div class="heard_cap">
                  <div class="top_left">
                  </div> 
                  <div class="top_menu">
                  <c:if test="${empty userInfoVO }">
                      <a href="<c:url value='/McmMalItr001M01L.do' />">HOME</a>
                      <a href="<c:url value='/McmCmnLgn001M01R.do' />">LOGIN</a>
                      <a href="<c:url value='/McmCmnUsr001M01C.do' />">JOIN</a>
                      <a href="#;">CONTACT US</a>
                   </c:if>
                   <c:if test="${ not empty userInfoVO }">
                      <a href="<c:url value='/McmMalItr001M01L.do' />">HOME</a>
                      <a href="<c:url value='/McmCmnLgn001M99RP.do' />">LOGOUT</a>
                      <a href="<c:url value='/McmCmnUsr001M03U.do' />?upMenuId=M002&subMenuId=M002001">MY PAGE</a>
                      <a href="<c:url value='/McmShpOrd003M01L.do' />?upMenuId=M001&subMenuId=M001002">CART</a>
                      <a href="#;">CONTACT US</a>
                   </c:if>   
                  </div>
            </div>
        </div><!-- End of pc top_menu -->
         
        <div class="logo_box">
           <div class="M_top_menu" id="btn">
               <div class="M_t"></div>
               <div class="M_m"></div>
               <div class="M_b"></div>
           </div>
            <c:if test="${ not empty userInfoVO }">
               <div class="M_top_menu_1">
                  <div class="M_top_menu_1_back"></div>
                  <div class="close">X</div>
                   <ul>
                       <li><a href="<c:url value = '/McmMalItr001M01L.do' />">HOME</a></li>
                   </ul>
                   <ul><li><a href="<c:url value='/McmCmnLgn001M99RP.do' />">LOGOUT</a></li></ul>
                   <ul><li><a href="<c:url value='/McmShpOrd003M01L.do' />?upMenuId=M001&subMenuId=M001002">CART</a></li></ul>
                   <ul><li><a href="#;">CONTACT US</a></li></ul>
               </div>
            </c:if>
               
      		<c:if test="${empty userInfoVO }">
             <div class="M_top_menu_1">
                  <div class="M_top_menu_1_back"></div>
                  <div class="close">X</div>
                   <ul>
                       <li><a href="<c:url value = '/McmMalItr001M01L.do' />">HOME</a></li>
                   </ul>
                   <ul><li><a href="<c:url value = '/McmCmnLgn001M01R.do' />">LOGIN</a></li></ul>
                   <ul><li><a href="<c:url value='/McmCmnUsr001M01C.do' />">JOIN</a></li></ul>
               </div>
           </c:if>
               
               
            <div class="logo"><a href="<c:url value='/McmMalItr001M01L.do'/>"><img src="<c:url value='/images/main/koalicon.png' />" alt="" title="home"></a></div>
            <div class="Search">
            	<form:select path="searchCtgrCd" style="width:90px;">
	                
                    <form:option value="">전체</form:option>
                    <c:forEach items="${ ctgrList }" var="ctgrCd">
                    	<form:option value="${ ctgrCd.cd }">${ ctgrCd.cdNm }</form:option>
                    </c:forEach>
                </form:select>   
                <form:input path="searchKeyword" />
                <a href="#;" id="btnSearch">검색</a>
            </div>
        </div>
