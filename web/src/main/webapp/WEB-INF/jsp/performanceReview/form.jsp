<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
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

<h1>공연 등록</h1>

<form action="add" method='post' enctype="multipart/form-data">

<div class='form-group row'>
<label for='performance.no' class='col-sm-2 col-form-label'>공연정보</label>
<div class='col-sm-10'>
<input class='form-control' id='performance.no' type='number' name='performance.no'>
</div>
</div>

<div class='form-group row'>
<label for='reviewDescription' class='col-sm-2 col-form-label'>후기내용</label>
<div class='col-sm-10'>
<input class='form-control' id='reviewDescription' type='text' name='reviewDescription'>
</div>
</div>

<div class='form-group row'>
<label for='file1' class='col-sm-2 col-form-label'>공연사진/영상</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file1" name="file">
</div>
</div>

<div class='form-group row'>
<label for='file2' class='col-sm-2 col-form-label'>공연사진/영상</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file2" name="file">
</div>
</div>

<div class='form-group row'>
<label for='file3' class='col-sm-2 col-form-label'>공연사진/영상</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file3" name="file">
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
    