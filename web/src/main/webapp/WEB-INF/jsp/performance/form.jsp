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
<label for='name' class='col-sm-2 col-form-label'>공연명</label>
<div class='col-sm-10'>
<input class='form-control' id='name' type='text' name='name'>
</div>
</div>

<!-- <div class='form-group row'>
<label for='genre' class='col-sm-2 col-form-label'>공연장르</label>
<div class='col-sm-10'>
<input class='form-control' id='genre' type='text' name='genre'>
</div>
</div> -->

<div class='form-group row'>
<label for='genre' class='col-sm-2 col-form-label'>공연장르</label>
<div class='col-sm-10'>
<!-- <div class="input-group mb-3"> -->
  <select class="custom-select" id="inputGroupSelect02" name="genre">
    <option selected>Choose...</option>
    <option value='솔로'>솔로</option>
    <option value='그룹'>그룹</option>
    <option value='발라드'>발라드</option>
    <option value='R & B'>R & B</option>
    <option value='락'>락</option>
    <option value='랩'>랩</option>
    <option value='개그'>개그</option>
    <option value='마술'>마술</option>
  </select>
  <!-- <div class="input-group-append">
    <label class="input-group-text" for="inputGroupSelect02">Options</label>
  </div> -->
</div>
</div>

<div class='form-group row'>
<label for='joinDate' class='col-sm-2 col-form-label'>공연날짜</label>
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
<label for='detailDesc' class='col-sm-2 col-form-label'>공연내용</label>
<div class='col-sm-10'>
<textarea class='form-control' id='detailDesc' name='detailDesc'></textarea>
</div>
</div>

<div class='form-group row'>
<label for='specialDesc' class='col-sm-2 col-form-label'>특이사항</label>
<div class='col-sm-10'>
<input class='form-control' id='specialDesc' type='text' name='specialDesc'>
</div>
</div>

<div class='form-group row'>
<label for='file1' class='col-sm-2 col-form-label'>공연사진/영상</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file1" name="files">
</div>
</div>

<div class='form-group row'>
<label for='file2' class='col-sm-2 col-form-label'>공연사진/영상</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file2" name="files">
</div>
</div>

<div class='form-group row'>
<label for='file3' class='col-sm-2 col-form-label'>공연사진/영상</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file3" name="files">
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

<%-- 
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
<label for='name' class='col-sm-2 col-form-label'>공연명</label>
<div class='col-sm-10'>
<input class='form-control' id='name' type='text' name='name'>
</div>
</div>

<div class='form-group row'>
<label for='genre' class='col-sm-2 col-form-label'>공연장르</label>
<div class='col-sm-10'>
<input class='form-control' id='genre' type='text' name='genre'>
</div>
</div>

<div class='form-group row'>
<label for='joinDate' class='col-sm-2 col-form-label'>공연날짜</label>
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
<label for='detailDesc' class='col-sm-2 col-form-label'>공연내용</label>
<div class='col-sm-10'>
<textarea class='form-control' id='detailDesc' name='detailDesc'></textarea>
</div>
</div>

<div class='form-group row'>
<label for='specialDesc' class='col-sm-2 col-form-label'>특이사항</label>
<div class='col-sm-10'>
<input class='form-control' id='specialDesc' type='text' name='specialDesc'>
</div>
</div>

<div class='form-group row'>
<label for='file1' class='col-sm-2 col-form-label'>공연사진/영상</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file1" name="files">
</div>
</div>

<div class='form-group row'>
<label for='file2' class='col-sm-2 col-form-label'>공연사진/영상</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file2" name="files">
</div>
</div>

<div class='form-group row'>
<label for='file3' class='col-sm-2 col-form-label'>공연사진/영상</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file3" name="files">
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
</html> --%>
