<%@page import="java100.app.domain.member.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>공지관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>공지 목록</h1>

<jsp:include page="../listToolbar.jsp"/>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>제목</th><th>닉네임</th><th>조회수</th><th>등록일</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="noticeInfo">
        <tr>
        <td>${noticeInfo.no}</td>
        <td><a href='${noticeInfo.no}'>${noticeInfo.noticeTitle}</a></td>
        <td>${noticeInfo.member.nickName}</td>
        <td>${noticeInfo.viewCount}</td>
        <td>${noticeInfo.noticeDate}</td>
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
    