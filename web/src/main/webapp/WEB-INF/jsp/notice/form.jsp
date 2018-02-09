<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>공지정보</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>공지등록</h1>
<form action="add" method='post'>

<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>공지제목</label>
<div class='col-sm-10'>
<input class='form-control' id='title' type='text' name='noticeTitle'>
</div>
</div>

<div class='form-group row'>
<label for='noticeDescription' class='col-sm-2 col-form-label'>공지내용</label>
<div class='col-sm-10'>
<input class='form-control' id='description' type='text' name='noticeDescription'>
</div>
</div>

<!-- <div class='form-group row'>
<label for='noticeDate' class='col-sm-2 col-form-label'>공지날짜</label>
<div class='col-sm-10'>
<input class='form-control' id='date' type='date' name='noticeDate'>
</div>
</div> -->

<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm'>등록</button>
</div>
</div>
</form>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    