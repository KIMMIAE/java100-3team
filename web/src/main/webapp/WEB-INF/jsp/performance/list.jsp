<%@page import="java100.app.domain.performance.Performance"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<title>공연 정보</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>공연 목록</h1>

<jsp:include page="../listToolbar.jsp"/>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>아티스트명</th><th>공연명</th><th>공연장르</th><th>공연날짜</th><th>공연장소</th><th>등록자</th><th>조회수</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="performance">
    <c:set var="title" value="${fn:length(performance.name) == 0 ? 
           '(공연명이 없습니다.)' : performance.name}"/>
    <tr>
    <td>${performance.no}</td>
    <td>${performance.artist.artistName}</td>
    <td><a href='${performance.no}'><span class="d-inline-block text-truncate" 
           style="max-width: 300px;">${title}</span></a></td>
    <td>${performance.genre}</td>
    <td>${performance.entryDate}</td>
    <td>${performance.location}</td>
    <td>${performance.writer.nickName}</td>
    <td>${performance.viewCount}</td>
    </tr>
</c:forEach>

</tbody>
</table>

<jsp:include page="../paging.jsp"/>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    