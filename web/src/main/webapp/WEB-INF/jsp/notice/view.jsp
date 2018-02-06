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

<h1>공지 상세 정보</h1>

<c:if test="${not empty noticeInfo}">
        <form action='update' method='post'>
        
        <div class='form-group row'>
        <label for='no' class='col-sm-2 col-form-label'>번호</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='no' type='number' 
                name='no' value='${noticeInfo.no}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='noticeTitle' class='col-sm-2 col-form-label'>제목</label>
        <div class='col-sm-10'>
        <input class='form-control' id='noticeTitle' type='text' 
                name='noticeTitle' value='${noticeInfo.noticeTitle}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='noticeDescription' class='col-sm-2 col-form-label'>내용</label>
        <div class='col-sm-10'>
        <input class='form-control' id='noticeDescription' type='text' 
                name='noticeDescription' value='${noticeInfo.noticeDescription}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='noticeDate' class='col-sm-2 col-form-label'>등록일</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='noticeDate' type="date" 
                name='noticeDate' value='${noticeInfo.noticeDate}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='viewCount' class='col-sm-2 col-form-label'>조회수</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='viewCount' type="number" 
                name='viewCount' value='${noticeInfo.viewCount}'>
        </div>
        </div>

        <div class='form-group row'>
        <div class='col-sm-10'>
        <button id="btn"  class='btn btn-primary btn-sm'>변경</button>
        <a href='delete?no=${noticeInfo.no}' class='btn btn-primary btn-sm'>삭제</a>
        </div>
        </div>
        </form>
        
</c:if>

<c:if test="${empty noticeInfo}">
        <p>'${param.no}'번 공지 정보가 없습니다.</p>
</c:if> 

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    