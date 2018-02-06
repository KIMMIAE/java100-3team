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
<title>공연 후기</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>공연 후기</h1>

<jsp:include page="../listToolbar.jsp"/>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>닉네임</th><th>후기내용</th><th>조회수</th><th>등록일</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="performanceReview">
    <c:set var="title" value="${fn:length(performanceReview.reviewDescription) == 0 ? 
           '(등록된 글이 없습니다.)' : performanceReview.reviewDescription}"/>
    <tr>
    <td>${performanceReview.reviewNo}</td>
    <td>${performanceReview.writer.nickName}</td>
    <td><a href='${performanceReview.reviewNo}'><span class="d-inline-block text-truncate" 
           style="max-width: 300px;">${title}</span></a></td>
    <td>${performanceReview.viewCount}</td>
    <td>${performanceReview.regDate}</td>
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
    