<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
<nav class='navbar navbar-expand-lg navbar-light bg-light'>
<a class='navbar-brand' href='../index.html'>
  <img src='${contextPath}/images/bootstrap-solid.svg' width='30' height='30' class='d-inline-block align-top' alt=''>
  비트캠프
</a>

<c:if test="${empty menuVisible or menuVisible == true}">
<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
  <span class='navbar-toggler-icon'></span>
</button>
<div class='collapse navbar-collapse' id='navbarNav'>
<ul class='navbar-nav mr-auto'>
  <li class='nav-item'>
    <a class='nav-link' href='../member/list'>회원정보</a>
  </li>
  <li class='nav-item'>
    <a class='nav-link' href='../performance/list'>공연정보</a>
  </li>
  <li class='nav-item'>
    <a class='nav-link' href='../request/list'>공연요청</a>
  </li>
  <li class='nav-item'>
    <a class='nav-link' href='../sponsor/list'>공연후원</a>
  </li>
</ul>

<c:choose>
    <c:when test="${sessionScope.loginUser != null}">
        ${sessionScope.loginUser.nickName}
        <a href="${contextPath}/app/auth/logout" 
           class='btn btn-light btn-sm'>로그아웃</a>
    </c:when>

    <c:otherwise>
       <a href="${contextPath}/app/auth/login" 
           class='btn btn-primary btn-sm'>로그인</a>
    </c:otherwise>
</c:choose>

</div>
</c:if>

</nav>
</header>





    