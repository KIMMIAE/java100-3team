<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
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

<h3>공연 요청</h3>

<form action="add" method='post'>

<div class='form-group row'>
<label for='title' class='col-sm-2 col-form-label'>제목</label>
<div class='col-sm-10'>
<input class='form-control' id='title' type='text' name='title'>
</div>
</div>

<div class='form-group row'>
<label for='detailDesc' class='col-sm-2 col-form-label'>내용</label>
<div class='col-sm-10'>
<textarea class='form-control' id='detailDesc' name='detailDesc'></textarea>
</div>
</div>

<div class='form-group row'>
<label for='genre' class='col-sm-2 col-form-label'>공연장르</label>
<div class='col-sm-10'>
<input class='form-control' id='genre' type='text' name='genre'>
</div>
</div>

<div class='form-group row'>
<label for='entryDate' class='col-sm-2 col-form-label'>공연날짜</label>
<div class='col-sm-10'>
<input class='form-control' id='entryDate' type='date' name='entryDate'>
</div>
</div>

<div class='form-group row'>
<label for='location' class='col-sm-2 col-form-label'>공연장소</label>
<div class='col-sm-10'>
<input class='form-control' id='location' type='text' name='location'>
</div>
</div>

<div class='form-group row'>
<label for='specialDesc' class='col-sm-2 col-form-label'>특이사항</label>
<div class='col-sm-10'>
<input class='form-control' id='specialDesc' type='text' name='specialDesc'>
</div>
</div>

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
    