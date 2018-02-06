<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<title>공연후기</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>공연후기 상세정보</h1>
<c:if test="${not empty performanceReview}">
        <form action='update' method='post' enctype="multipart/form-data">
        
        <div class='form-group row'>
        <label for='reviewNo' class='col-sm-2 col-form-label'>번호</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='reviewNo' type='number' 
                name='reviewNo' value='${performanceReview.reviewNo}'>
        </div>
        </div>
        <div class='form-group row'>
        <label for='nickName' class='col-sm-2 col-form-label'>닉네임</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='nickName' type='text' 
                name='nickName' value='${performanceReview.writer.nickName}'>
        </div>
        </div>
        <div class='form-group row'>    
        <label for='performance' class='col-sm-2 col-form-label'>공연명</label>
        <div class='col-sm-10'>
        <textarea class='form-control' readonly id='name' 
                    name='name'>${performanceReview.performance.name}</textarea>
        </div>
        </div>
        <div class='form-group row'>
        <label for='performance' class='col-sm-2 col-form-label'>공연장소</label>
        <div class='col-sm-10'>
        <textarea class='form-control' readonly id='location' 
                    name='location'>${performanceReview.performance.location}</textarea>
        </div>
        </div>
        <div class='form-group row'>
        <label for='performance' class='col-sm-2 col-form-label'>공연장르</label>
        <div class='col-sm-10'>
        <textarea class='form-control' readonly id='genre' 
                    name='genre'>${performanceReview.performance.genre}</textarea>
        </div>
        </div>
        <div class='form-group row'>
        <label for='performance' class='col-sm-2 col-form-label'>공연날짜</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='entryDate' type='date' 
                value='${performanceReview.performance.entryDate}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label class='col-sm-2 col-form-label'>첨부파일</label>
        <div class='col-sm-10'>
        <c:forEach items="${performanceReview.reviewFiles}" var="file">
          <a href="${contextPath}/download/${file.reviewFilename}">${file.reviewFilename}</a><br>
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
        <label for='reviewDescription' class='col-sm-2 col-form-label'>후기내용</label>
        <div class='col-sm-10'>
        <textarea class='form-control' id='reviewDescription'
                   name='reviewDescription'>${performanceReview.reviewDescription}</textarea>
        </div>
        </div>
        <div class='form-group row'>
        <label for='regdate' class='col-sm-2 col-form-label'>등록일</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='regdate' type='date' 
                value='${performanceReview.regDate}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='viewcnt' class='col-sm-2 col-form-label'>조회수</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='viewcnt' type='number' 
                value='${performanceReview.viewCount}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <div class='col-sm-10'>
        <button class='btn btn-primary btn-sm'>변경</button>
        <a href='delete?no=${performanceReview.reviewNo}' class='btn btn-primary btn-sm'>삭제</a>
        </div>
        </div>
        </form>

</c:if>

<c:if test="${empty performanceReview}">
        <p>'${param.no}'번 게시물이 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
