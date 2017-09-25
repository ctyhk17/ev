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


	<div class="header_cap">
        <div class="menu_back">
            <div class="menu_top">
                <div class="logo"><a href="<c:url value='/McmMalItr001M01L.do' />"><img src="<c:url value='/images/main/koalicon2.png' />" alt=""></a></div>
                <div class="menu">
                   <ul>
                   
                   
						<c:if test="${ not empty userInfoVO }">
								<li><a href="#">${ userInfoVO.usrNm } 님 (${ userInfoVO.usrId })</a> | </li>
		                       <li><a href="#">주문현황</a> | </li>
		                       <li><a href="<c:url value='/McmCmnLgn001M99RP.do' />">로그아웃</a> </li>
						</c:if>
						
						<c:if test="${ empty userInfoVO }">
							<li><a class="topmenu_line" href="<c:url value='/McmCmnLgn001M01R.do' />" title="로그인페이지로 이동">로그인</a> | </li>
							<li><a class="topmenu_line" href="<c:url value='/McmCmnUsr001M01C.do' />" title="회원가입페이지로 이동">회원가입</a></li>
						</c:if>
                    	   
                       
                       
                       
                       <!-- <li><a href="#">조합원관리</a> | </li> -->
                       <!-- <li class="click_sub"><a href="#">자주쓰는메뉴 ▼</a> | 
                            <ul class="display_none">
                               <li><a href="#">메뉴_1</a></li>
                               <li><a href="#">메뉴_2</a></li>
                               <li><a href="#">메뉴_3</a></li>
                               <li><a href="#">메뉴_4</a></li>
                           </ul>
                        </li> -->
                       <!-- <li class="click_sub"><a href="#">더보기 ▼</a> | 
                           <ul class="display_none">
                               <li><a href="#">메뉴_1</a></li>
                               <li><a href="#">메뉴_2</a></li>
                               <li><a href="#">메뉴_3</a></li>
                               <li><a href="#">메뉴_4</a></li>
                           </ul>
                       </li> -->
                       <!-- <li><input type="text" placeholder="메뉴검색" class="margin_l"></li> -->
                       
                       
                       
                   </ul>
                </div>
            </div>
        </div>
        <div class="menu_back_1">
            <div class="menu_top_1">
            <c:if test="${
            	   userInfoVO.athCdMap.containsKey('CMN001001')
            	or userInfoVO.athCdMap.containsKey('CMN001002') 
			    or userInfoVO.athCdMap.containsKey('CMN001003') 
			    or userInfoVO.athCdMap.containsKey('CMN001004') 
			    or userInfoVO.athCdMap.containsKey('CMN001005')
            }">
				<a href="<c:url value='/McmShpOrd002M01L.do' />?upMenuId=M001&subMenuId=M001001"  <c:if test="${ 'M001' eq upMenuId }"> class="active_a" </c:if> >주문현황</a>
            	<a href="<c:url value='/McmCmnUsr001M03U.do' />?upMenuId=M002&subMenuId=M002001"  <c:if test="${ 'M002' eq upMenuId }"> class="active_a" </c:if> >정보내역</a>
            	<a href="<c:url value='/McmCmnBbs006M01L.do' />?upMenuId=M003&subMenuId=M003001"  <c:if test="${ 'M003' eq upMenuId }"> class="active_a" </c:if> >고객센터</a>
			</c:if>
			<c:if test="${
			       userInfoVO.athCdMap.containsKey('CMN001002') 
			    or userInfoVO.athCdMap.containsKey('CMN001003') 
			    or userInfoVO.athCdMap.containsKey('CMN001004') 
			    or userInfoVO.athCdMap.containsKey('CMN001005')
			}">
				<a href="<c:url value='/McmMalBiz002M01L.do' />?upMenuId=M006&subMenuId=M006001" <c:if test="${ 'M006' eq upMenuId }"> class="active_a" </c:if> >홍보관리</a>
			</c:if>
			<c:if test="${
			      userInfoVO.athCdMap.containsKey('CMN001003') 
			   or userInfoVO.athCdMap.containsKey('CMN001004')
			   or userInfoVO.athCdMap.containsKey('CMN001005')
			}">
				<a href="<c:url value='/McmMalGds001M01L.do' />?upMenuId=M004&subMenuId=M004001"  <c:if test="${ 'M004' eq upMenuId }"> class="active_a" </c:if> >상품관리</a>
            	<a href="<c:url value='/McmShpOrd004M01L.do' />?upMenuId=M005&subMenuId=M005001"  <c:if test="${ 'M005' eq upMenuId }"> class="active_a" </c:if> >주문관리</a>
            	
			</c:if>
			<c:if test="${
			       userInfoVO.athCdMap.containsKey('CMN001002') 
			    or userInfoVO.athCdMap.containsKey('CMN001003') 
			    or userInfoVO.athCdMap.containsKey('CMN001004') 
			    or userInfoVO.athCdMap.containsKey('CMN001005')
			}">
				<a href="<c:url value='/McmMalStt001M01L.do' />?upMenuId=M007&subMenuId=M007001" <c:if test="${ 'M007' eq upMenuId }"> class="active_a" </c:if> >현황통계</a>
			</c:if>
			
			
			
			
			
			<c:if test="${
			   userInfoVO.athCdMap.containsKey('CMN001005')
			}">            	
            	<a href="<c:url value='/McmCmnUsr002M11L.do' />?upMenuId=M008&subMenuId=M008001"  <c:if test="${ 'M008' eq upMenuId }"> class="active_a" </c:if> >조합원관리</a>
<%--             	<a href="<c:url value='/DdCmnAdm001M01L.do' />?upMenuId=M009&subMenuId=M009001"  <c:if test="${ 'M009' eq upMenuId }"> class="active_a" </c:if> >게시판관리</a> --%>
            	
            </c:if>
            <c:if test="${
			   userInfoVO.athCdMap.containsKey('CMN001005') or userInfoVO.athCdMap.containsKey('CMN001006')
			}">
				<a href="<c:url value='/McmCmnCcd001M01L.do' />?upMenuId=M010&subMenuId=M010001"  <c:if test="${ 'M010' eq upMenuId }"> class="active_a" </c:if> >시스템설정</a>
			</c:if> 
			
            </div>
        </div>
    </div>
