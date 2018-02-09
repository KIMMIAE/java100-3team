<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>게시물 상세정보</h1>

<c:if test="${not empty performance}">
    <form action='update' method='post' enctype="multipart/form-data">
        
        
        <div class='form-group row'>
        <label for='no' class='col-sm-2 col-form-label'>번호</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='no' type='number' 
                name='no' value='${performance.no}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='memberNo' class='col-sm-2 col-form-label'>회원번호</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='memberNo' type='number' 
                name='memberNo' value='${performance.artist.no}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='name' class='col-sm-2 col-form-label'>공연명</label>
        <div class='col-sm-10'>
        <input class='form-control' id='name' type='text' 
                name='name' value='${performance.name}'>
        </div>
        </div>
        
        <%-- <div class='form-group row'>
        <label for='genre' class='col-sm-2 col-form-label'>공연장르</label>
        <div class='col-sm-10'>
        <input class='form-control' id='genre' type='text'
                name='genre' value='${performance.genre}'>
        </div>
        </div> --%>

        <div class='form-group row'>
        <label for='genre' class='col-sm-2 col-form-label'>공연장르</label>
        <div class='col-sm-10'>
        <!-- <div class="input-group mb-3"> -->
          <select class="custom-select" id="inputGroupSelect02" name="genre">
            <option selected>${performance.genre}</option>
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
        <input class='form-control' id='entryDate' type='date'
                name='entryDate' value='${performance.entryDate}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='location' class='col-sm-2 col-form-label'>공연장소</label>
        <div class='col-sm-10'>
        <input class='form-control' id='location' type='text'
                name='location' value='${performance.location}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='detailDesc' class='col-sm-2 col-form-label'>공연내용</label>
        <div class='col-sm-10'>
        <textarea class='form-control' id='detailDesc'
                   name='detailDesc'>${performance.detailDesc}</textarea>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='specialDesc' class='col-sm-2 col-form-label'>특이사항</label>
        <div class='col-sm-10'>
        <input class='form-control' id='specialDesc' type='text'
                name='specialDesc' value='${performance.specialDesc}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label class='col-sm-2 col-form-label'>공연사진/영상</label>
        <div class='col-sm-10'>
        <c:forEach items="${performance.medias}" var="file">
          <a href="${contextPath}/download/${file.filename}">${file.filename}</a><br>
        </c:forEach>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='file1' class='col-sm-2 col-form-label'>파일1</label>
        <div class='col-sm-10'>
        <input type="file" class="form-control-file" id="file1" name="files">
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='file2' class='col-sm-2 col-form-label'>파일2</label>
        <div class='col-sm-10'>
        <input type="file" class="form-control-file" id="file2" name="files">
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='file3' class='col-sm-2 col-form-label'>파일3</label>
        <div class='col-sm-10'>
        <input type="file" class="form-control-file" id="file3" name="files">
        </div>
        </div>
        
        
        
        <div class='form-group row'>
        <label for='jjimFlag' class='col-sm-2 col-form-label'>관심 지역</label>
        <div class='col-sm-10'>
            <input type='checkbox' id='jjimFlag' name='jjimFlag'>
            <label for='jjimFlag'>찜</label>
        </div>
        </div>
        
        
        <%-- <div class='form-group row'>
        <label for='jjimFlag' class='col-sm-2 col-form-label'>공연 찜</label>
        <div class='col-sm-10'>
            <input type="radio" id="jjimFlag" name="jjimFlag" value="${performance.jjim.jjimFlag}">
            <label for="jjimFlag">찜</label>
        </div>
        </div> --%>
        
        <!-- <div class='form-group row'>
        <label for='ripple' class='col-sm-2 col-form-label'>리플</label>
        <div class='col-sm-10'>
        <input class='form-control' id='ripple' type='text' 
                name='ripple'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='rating' class='col-sm-2 col-form-label'>평점</label>
        <div class='col-sm-10'>
        <input class='form-control' id='rating' type='text' 
                name='rating'>
        </div>
        </div> -->
        
        <!-- 
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
         -->
        
        
        
        <%-- 
        <div class='form-group row'>
        <label for='title' class='col-sm-2 col-form-label'>제목</label>
        <div class='col-sm-10'>
        <input class='form-control' id='title' type='text' 
                name='title' value='${performance.title}'>
        </div>
        </div>
        <div class='form-group row'>
        <label for='content' class='col-sm-2 col-form-label'>내용</label>
        <div class='col-sm-10'>
        <textarea class='form-control' id='content' 
                    name='content'>${performance.content}</textarea>
        </div>
        </div>
        <div class='form-group row'>
        <label for='regdate' class='col-sm-2 col-form-label'>등록일</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='regdate' type='date' 
                value='${performance.regDate}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='viewcnt' class='col-sm-2 col-form-label'>조회수</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='viewcnt' type='number' 
                value='${performance.viewCount}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label class='col-sm-2 col-form-label'>첨부파일</label>
        <div class='col-sm-10'>
        <c:forEach items="${performance.files}" var="file">
          <a href="${contextPath}/download/${file.filename}">${file.filename}</a><br>
        </c:forEach>
        </div>
        </div>
        
        <div class='form-group row'>
		<label for='file1' class='col-sm-2 col-form-label'>파일1</label>
		<div class='col-sm-10'>
		<input type="file" class="form-control-file" id="file1" name="file">
		</div>
		</div>
		
		<div class='form-group row'>
		<label for='file2' class='col-sm-2 col-form-label'>파일2</label>
		<div class='col-sm-10'>
		<input type="file" class="form-control-file" id="file2" name="file">
		</div>
		</div>
		
		<div class='form-group row'>
		<label for='file3' class='col-sm-2 col-form-label'>파일3</label>
		<div class='col-sm-10'>
		<input type="file" class="form-control-file" id="file3" name="file">
		</div>
		</div> --%>
        
        <div class='form-group row'>
        <div class='col-sm-10'>
        <button class='btn btn-primary btn-sm'>변경</button>
        <a href='delete?no=${performance.no}' class='btn btn-primary btn-sm'>삭제</a>
        </div>
        </div>
    </form>
</c:if>
<c:if test="${empty performance}">
        <p>'${param.no}'번 게시물이 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>




<script src='../node_modules/jquery/dist/jquery.min.js'></script>
<script src='../node_modules/popper.js/dist/umd/popper.min.js'></script>
<script src='../node_modules/bootstrap/dist/js/bootstrap.min.js'></script>
<!-- <script src='../js/bit.js'></script> -->


</body>
</html>


<%-- 
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>게시물 상세정보</h1>

<c:if test="${not empty performance}">
    <form action='update' method='post' enctype="multipart/form-data">
        
        
        <div class='form-group row'>
        <label for='no' class='col-sm-2 col-form-label'>번호</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='no' type='number' 
                name='no' value='${performance.no}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='name' class='col-sm-2 col-form-label'>공연명</label>
        <div class='col-sm-10'>
        <input class='form-control' id='name' type='text' 
                name='name' value='${performance.name}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='genre' class='col-sm-2 col-form-label'>공연장르</label>
        <div class='col-sm-10'>
        <input class='form-control' id='genre' type='text'
                name='genre' value='${performance.genre}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='joinDate' class='col-sm-2 col-form-label'>공연날짜</label>
        <div class='col-sm-10'>
        <input class='form-control' id='entryDate' type='date'
                name='entryDate' value='${performance.entryDate}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='location' class='col-sm-2 col-form-label'>공연장소</label>
        <div class='col-sm-10'>
        <input class='form-control' id='location' type='text'
                name='location' value='${performance.location}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='detailDesc' class='col-sm-2 col-form-label'>공연내용</label>
        <div class='col-sm-10'>
        <textarea class='form-control' id='detailDesc'
                   name='detailDesc'>${performance.detailDesc}</textarea>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='specialDesc' class='col-sm-2 col-form-label'>특이사항</label>
        <div class='col-sm-10'>
        <input class='form-control' id='specialDesc' type='text'
                name='specialDesc' value='${performance.specialDesc}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label class='col-sm-2 col-form-label'>공연사진/영상</label>
        <div class='col-sm-10'>
        <c:forEach items="${performance.medias}" var="file">
          <a href="${contextPath}/download/${file.filename}">${file.filename}</a><br>
        </c:forEach>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='file1' class='col-sm-2 col-form-label'>파일1</label>
        <div class='col-sm-10'>
        <input type="file" class="form-control-file" id="file1" name="files">
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='file2' class='col-sm-2 col-form-label'>파일2</label>
        <div class='col-sm-10'>
        <input type="file" class="form-control-file" id="file2" name="files">
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='file3' class='col-sm-2 col-form-label'>파일3</label>
        <div class='col-sm-10'>
        <input type="file" class="form-control-file" id="file3" name="files">
        </div>
        </div>
        
        <!-- 
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
         -->
        
        
        
        
        <div class='form-group row'>
        <label for='title' class='col-sm-2 col-form-label'>제목</label>
        <div class='col-sm-10'>
        <input class='form-control' id='title' type='text' 
                name='title' value='${performance.title}'>
        </div>
        </div>
        <div class='form-group row'>
        <label for='content' class='col-sm-2 col-form-label'>내용</label>
        <div class='col-sm-10'>
        <textarea class='form-control' id='content' 
                    name='content'>${performance.content}</textarea>
        </div>
        </div>
        <div class='form-group row'>
        <label for='regdate' class='col-sm-2 col-form-label'>등록일</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='regdate' type='date' 
                value='${performance.regDate}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='viewcnt' class='col-sm-2 col-form-label'>조회수</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='viewcnt' type='number' 
                value='${performance.viewCount}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label class='col-sm-2 col-form-label'>첨부파일</label>
        <div class='col-sm-10'>
        <c:forEach items="${performance.files}" var="file">
          <a href="${contextPath}/download/${file.filename}">${file.filename}</a><br>
        </c:forEach>
        </div>
        </div>
        
        <div class='form-group row'>
		<label for='file1' class='col-sm-2 col-form-label'>파일1</label>
		<div class='col-sm-10'>
		<input type="file" class="form-control-file" id="file1" name="file">
		</div>
		</div>
		
		<div class='form-group row'>
		<label for='file2' class='col-sm-2 col-form-label'>파일2</label>
		<div class='col-sm-10'>
		<input type="file" class="form-control-file" id="file2" name="file">
		</div>
		</div>
		
		<div class='form-group row'>
		<label for='file3' class='col-sm-2 col-form-label'>파일3</label>
		<div class='col-sm-10'>
		<input type="file" class="form-control-file" id="file3" name="file">
		</div>
		</div>
        
        <div class='form-group row'>
        <div class='col-sm-10'>
        <button class='btn btn-primary btn-sm'>변경</button>
        <a href='delete?no=${performance.no}' class='btn btn-primary btn-sm'>삭제</a>
        </div>
        </div>
    </form>
</c:if>
<c:if test="${empty performance}">
        <p>'${param.no}'번 게시물이 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html> --%>