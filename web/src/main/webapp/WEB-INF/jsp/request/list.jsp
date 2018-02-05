<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<title>공연 요청 게시판</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h3>공연 요청 게시물 목록</h3>

<jsp:include page="../listToolbar.jsp"/>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>제목</th><th>등록일</th><th>조회수</th><th>작성자</th>
</tr>
</thead> 
<c:forEach items="${list}" var="request">
    <c:set var="title" value="${fn:length(request.title) == 0 ? 
    '(제목이 없습니다.)' : request.title}"/>
        <tr>
        <td>${request.no}</td>
        <%--   
        <td><a href='${request.no}'>${fn:substring(title, 0, 20)}
        ${(fn:length(title) > 20) ? '...' : ''}</a></td>
        --%>
        <td><a href='${request.no}'><span class="d-inline-block text-truncate" 
            style="max-width: 300px;">${title}</span></a></td>
        <td>${request.regDate}</td>
        <td>${request.viewCount}</td>
        <td>${request.writer.nickName}</td>
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
    