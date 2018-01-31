<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>


</head>

<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>회원 상세 정보</h1>

<c:if test="${not empty member}">
        <form action='update' method='post' enctype="multipart/form-data">
        
        <div class='form-group row'>
        <!-- <label for='no' class='col-sm-2 col-form-label'>번호</label> -->
        <div class='col-sm-10'>
        <input type="hidden" class='form-control' readonly id='no' type='number' 
                name='no' value='${member.no}'>
        </div>
        </div>
        
        <%-- <c:forEach items="${board.files}" var="file"> --%>
          <img src="${contextPath}/download/${member.photo}" height="100"><br>
          <%-- <a href="${contextPath}/download/${member.photo}">${member.photo}</a><br> --%>
        <%-- </c:forEach> --%>        
        <input type="file" class="form-control-file" id="file" name="file">
        
        <div class='form-group row'>
        <label for='email' class='col-sm-2 col-form-label'>이메일</label>
        <div class='col-sm-10'>
        <input class='form-control' id='email' type='text' 
                name='email' value='${member.email}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='password' class='col-sm-2 col-form-label'>암호</label>
        <div class='col-sm-10'>
        <input class='form-control' id='password' type='password' 
                name='password' value='${member.password}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='name' class='col-sm-2 col-form-label'>닉네임</label>
        <div class='col-sm-10'>
        <input class='form-control' id='name' type='text' 
                name='nickName' value='${member.nickName}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='messageFlag' class='col-sm-2 col-form-label'>메세지 수신</label>
        <div class='col-sm-10'>
            <input type="radio" id="messageFlag1" name="messageFlag" value="1" ${member.messageFlag == '1' ? 'checked' : ''}>
            <label for="messageFlag">수신</label>
        
            <input type="radio" id="messageFlag2" name="messageFlag" value="0" ${member.messageFlag == '0' ? 'checked' : ''}>
            <label for="messageFlag">거부</label>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='messageId' class='col-sm-2 col-form-label'>메세지 수신 아이디</label>
        <div class='col-sm-10'>
        <input class='form-control' id='messageId' type='text' name='messageId' value='${member.messageId}'>
        </div>
        </div>

        <div class='form-group row'>
        <label for='type' class='col-sm-2 col-form-label'>가입자 유형</label>
        <div class='col-sm-10'>
            <input type="radio" id="type1" name="type" value="일반회원" ${member.type == '일반회원' ? 'checked' : ''}>
            <%-- <input type="radio" id="type1" name="type" value="일반회원" <c:if test="${member.type == '일반회원'}">checked</c:if>> --%>
            <label for="type">일반회원</label>

            <input type="radio" id="type2" name="type" value="아티스트" ${member.type == "아티스트" ? 'checked' : ''}>
            <%-- <input type="radio" id="type2" name="type" value="아티스트" <c:if test="${member.type eq '아티스트'}">checked</c:if>> --%>
            <label for="type">아티스트</label>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='artistName' class='col-sm-2 col-form-label'>아티스트/팀명</label>
        <div class='col-sm-10'>
        <input class='form-control' id='artistName' type='text' name='artist.artistName' <%--  value='${member.artist.artistName}'> --%>
                value="${member.type == '아티스트' ? member.artist.artistName : ''}">
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='artistMember' class='col-sm-2 col-form-label'>팀구성원</label>
        <div class='col-sm-10'>
        <input class='form-control' id='artistMember' type='text' name='artist.artistMember'<%--  value='${member.artist.artistMember}'> --%> 
                value="${member.type == '아티스트' ? member.artist.artistName : ''}">
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='profile' class='col-sm-2 col-form-label'>프로필</label>
        <div class='col-sm-10'>
        <input class='form-control' id='profile' type='text' name='artist.profile'<%--  value='${member.artist.profile}'> --%> 
                value="${member.type == '아티스트' ? member.artist.profile : ''}">
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='joinDate' class='col-sm-2 col-form-label'>팀결성날짜</label>
        <div class='col-sm-10'>
        <input class='form-control' id='joinDate' type='date' name='artist.joinDate'<%--  value='${member.artist.joinDate}'> --%> 
                value="${member.type == '아티스트' ? member.artist.joinDate : null}">
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='interestArea' class='col-sm-2 col-form-label'>관심 지역</label>
      
        <div class='col-sm-10'>
            
            <input type='checkbox' id='areas1' name='areas' value='홍대'>
            <label for='areas'>홍대</label>
            
            <input type='checkbox' id='areas2' name='areas' value='대학로'>
            <label for='areas'>대학로</label>
            
            <input type='checkbox' id='areas3' name='areas' value='신촌'>
            <label for='areas'>신촌</label>
            
            <input type='checkbox' id='areas4' name='areas' value='건대'>
            <label for='areas'>건대</label>
            
            <input type='checkbox' id='areas5' name='areas' value='한강공원'>
            <label for='areas'>한강공원</label>
            
            <input type='checkbox' id='areas6' name='areas' value='뚝섬유원지'>
            <label for='areas'>뚝섬유원지</label>
            
            <input type='checkbox' id='areas7' name='areas' value='보라매'>
            <label for='areas'>보라매</label>
            
            <input type='checkbox' id='areas8' name='areas' value='신림역'>
            <label for='areas'>신림역</label>
            
            <!-- 
            <input class='form-check-input' type='checkbox' id='interestArea' name='interestArea' value='홍대' >
            <label class='form-check-label' for='interestArea'>홍대</label>
            
            <input class='form-check-input' type='checkbox' id='interestArea' name='interestArea' value='대학로' >
            <label class='form-check-label' for='interestArea'>대학로</label>
            
            <input class='form-check-input' type='checkbox' id='interestArea' name='interestArea' value='신촌' >
            <label class='form-check-label' for='interestArea'>신촌</label>
            
            <input class='form-check-input' type='checkbox' id='interestArea' name='interestArea' value='건대' >
            <label class='form-check-label' for='interestArea'>건대</label>
            
            <input class='form-check-input' type='checkbox' id='interestArea' name='interestArea' value='한강공원' >
            <label class='form-check-label' for='interestArea'>한강공원</label>
            
            <input class='form-check-input' type='checkbox' id='interestArea' name='interestArea' value='뚝섬유원지' >
            <label class='form-check-label' for='interestArea'>뚝섬유원지</label>
            
            <input class='form-check-input' type='checkbox' id='interestArea' name='interestArea' value='보라매' >
            <label class='form-check-label' for='interestArea'>보라매</label>
            
            <input class='form-check-input' type='checkbox' id='interestArea' name='interestArea' value='신림역' >
            <label class='form-check-label' for='interestArea'>신림역</label> -->
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='interestArea' class='col-sm-2 col-form-label'>관심 장르</label>
        
        <div class='col-sm-10'>
            <input type='checkbox' id='genre1' name='genres' value='솔로'>
            <label for='genres'>솔로</label>
            
            <input type='checkbox' id='genre2' name='genres' value='그룹'>
            <label for='genres'>그룹</label>
            
            <input type='checkbox' id='genre3' name='genres' value='발라드'>
            <label for='genres'>발라드</label>
            
            <input type='checkbox' id='genre4' name='genres' value='R & B'>
            <label for='genres'>R & B</label>
            
            <input type='checkbox' id='genre5' name='genres' value='락'>
            <label for='genres'>락</label>
            
            <input type='checkbox' id='genre6' name='genres' value='랩'>
            <label for='genres'>랩</label>
            
            <input type='checkbox' id='genre7' name='genres' value='개그'>
            <label for='genres'>개그</label>
            
            <input type='checkbox' id='genre8' name='genres' value='마술'>
            <label for='genres'>마술</label>
        </div>
        </div>
        
        
         
        <div class='form-group row'>
        <div class='col-sm-10'>
        <button id="btn"  class='btn btn-primary btn-sm'>변경</button>
        <a href='delete?no=${member.no}' class='btn btn-primary btn-sm'>삭제</a>
        </div>
        </div>
        </form>
</c:if>

<c:if test="${empty member}">
        <p>'${param.no}'번 회원 정보가 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>


<script type="text/javascript">

window.onload = function() {
    
    var areas = [];
    
    var i = 0;
    <c:forEach items="${arealist}" var="info">
        areas[i++]="${info.areaName}";
    </c:forEach>

    var objAreas = document.getElementsByName("areas");
    for (i=0; i < objAreas.length; i++) {
        for (j=0; j < areas.length; j++) {
            if (objAreas[i].value == "홍대" && areas[j] == "홍대") {
                objAreas[i].checked = true;
            }
            if (objAreas[i].value == "대학로" && areas[j] == "대학로") {
                objAreas[i].checked = true;
            }
            if (objAreas[i].value == "신촌" && areas[j] == "신촌") {
                objAreas[i].checked = true;
            }
            if (objAreas[i].value == "건대" && areas[j] == "건대") {
                objAreas[i].checked = true;
            }
            if (objAreas[i].value == "한강공원" && areas[j] == "한강공원") {
                objAreas[i].checked = true;
            }
            if (objAreas[i].value == "뚝섬유원지" && areas[j] == "뚝섬유원지") {
                objAreas[i].checked = true;
            }
            if (objAreas[i].value == "보라매" && areas[j] == "보라매") {
                objAreas[i].checked = true;
            }
            if (objAreas[i].value == "신림역" && areas[j] == "신림역") {
                objAreas[i].checked = true;
            }
        }
    }
    
    var genres = [];
    
    i = 0;
    <c:forEach items="${genrelist}" var="info">
        genres[i++]="${info.genreName}";
    </c:forEach>

    var objGenre = document.getElementsByName("genres");
    for (i=0; i < objGenre.length; i++) {
        for (j=0; j < genres.length; j++) {
            if (objGenre[i].value == "솔로" && genres[j] == "솔로") {
                objGenre[i].checked = true;
            }
            if (objGenre[i].value == "그룹" && genres[j] == "그룹") {
                objGenre[i].checked = true;
            }
            if (objGenre[i].value == "발라드" && genres[j] == "발라드") {
                objGenre[i].checked = true;
            }
            if (objGenre[i].value == "R & B" && genres[j] == "R & B") {
                objGenre[i].checked = true;
            }
            if (objGenre[i].value == "락" && genres[j] == "락") {
                objGenre[i].checked = true;
            }
            if (objGenre[i].value == "랩" && genres[j] == "랩") {
                objGenre[i].checked = true;
            }
            if (objGenre[i].value == "개그" && genres[j] == "개그") {
                objGenre[i].checked = true;
            }
            if (objGenre[i].value == "마술" && genres[j] == "마술") {
                objGenre[i].checked = true;
            }
        }
    }
}
</script>

<script type="text/javascript">
btn.onclick = function () {
    //var joinDate = document.querySelector("#joinDate")
    /* var joinDate = document.getElementById("joinDate");
    //alert(checkJoinDate);
    if (!joinDate.value) {
        joinDate.value = "0001-01-01";
        //alert(joinDate.value);
    } */
}
</script>

</body>
</html>
    