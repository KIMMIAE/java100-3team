<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>회원등록</h1>
<form action="add" method='post' enctype="multipart/form-data">


<div class='form-group row'>
<label for='file' class='col-sm-2 col-form-label'>사진</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file" name="file">
</div>
</div>


<div class='form-group row'>
<label for='email' class='col-sm-2 col-form-label'>가입이메일</label>
<div class='col-sm-10'>
<input class='form-control' id='email' type='text' name='email'>
</div>
</div>

<div class='form-group row'>
<label for='password' class='col-sm-2 col-form-label'>암호</label>
<div class='col-sm-10'>
<input class='form-control' id='password' type='password' name='password'>
</div>
</div>

<div class='form-group row'>
<label for='nickName' class='col-sm-2 col-form-label'>닉네임</label>
<div class='col-sm-10'>
<input class='form-control' id='nickName' type='text' name='nickName'>
</div>
</div>

<div class='form-group row'>
<label for='messageFlag' class='col-sm-2 col-form-label'>메세지 수신</label>
<div class='col-sm-10'>
    <input type="radio" id="messageFlag1" name="messageFlag" value="1" checked>
    <label for="messageFlag">수신</label>

    <input type="radio" id="messageFlag2" name="messageFlag" value="0">
    <label for="messageFlag">거부</label>
</div>
</div>

<div class='form-group row'>
<label for='messageId' class='col-sm-2 col-form-label'>메세지 수신 아이디</label>
<div class='col-sm-10'>
<input class='form-control' id='messageId' type='text' name='messageId'>
</div>
</div>

<div class='form-group row'>
<label for='type' class='col-sm-2 col-form-label'>가입자 유형</label>
<div class='col-sm-10'>
    <input type="radio" id="type1" name="type" value="일반회원" checked>
    <label for="type">일반회원</label>

    <input type="radio" id="type2" name="type" value="아티스트">
    <label for="type">아티스트</label>
</div>
</div>

<div class='form-group row'>
<label for='artistName' class='col-sm-2 col-form-label'>아티스트/팀명</label>
<div class='col-sm-10'>
<input class='form-control' id='artistName' type='text' name='artist.artistName' value=''>
</div>
</div>

<div class='form-group row'>
<label for='artistMember' class='col-sm-2 col-form-label'>팀구성원</label>
<div class='col-sm-10'>
<input class='form-control' id='artistMember' type='text' name='artist.artistMember' value=''>
</div>
</div>

<div class='form-group row'>
<label for='profile' class='col-sm-2 col-form-label'>프로필</label>
<div class='col-sm-10'>
<input class='form-control' id='profile' type='text' name='artist.profile' value=''>
</div>
</div>

<div class='form-group row'>
<label for='joinDate' class='col-sm-2 col-form-label'>팀결성날짜</label>
<div class='col-sm-10'>
<input class='form-control' id='joinDate' type='date' name='artist.joinDate'>
</div>
</div>


<div class='form-group row'>
<label for='areas' class='col-sm-2 col-form-label'>관심 지역</label>
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
    
    
    <!-- <input class='form-check-input' type='checkbox' id='areas1' name='areas' value='홍대'>
    <label class='form-check-label' for='areas'>홍대</label>
    
    <input class='form-check-input' type='checkbox' id='areas2' name='areas' value='대학로'>
    <label class='form-check-label' for='areas'>대학로</label>
    
    <input class='form-check-input' type='checkbox' id='areas3' name='areas' value='신촌'>
    <label class='form-check-label' for='areas'>신촌</label>
    
    <input class='form-check-input' type='checkbox' id='areas4' name='areas' value='건대'>
    <label class='form-check-label' for='areas'>건대</label>
    
    <input class='form-check-input' type='checkbox' id='areas5' name='areas' value='한강공원'>
    <label class='form-check-label' for='areas'>한강공원</label>
    
    <input class='form-check-input' type='checkbox' id='areas6' name='areas' value='뚝섬유원지'>
    <label class='form-check-label' for='areas'>뚝섬유원지</label>
    
    <input class='form-check-input' type='checkbox' id='areas7' name='areas' value='보라매'>
    <label class='form-check-label' for='areas'>보라매</label>
    
    <input class='form-check-input' type='checkbox' id='areas8' name='areas' value='신림역'>
    <label class='form-check-label' for='areas'>신림역</label> -->
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
<button id="btn" class='btn btn-primary btn-sm'>등록</button>
</div>
</div>

</form>
<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>


<script type="text/javascript">
btn.onclick = function() {
    /* var cnt = 0;
    var areas = document.getElementsByName("areas");
    for (i=0; i < areas.length; i++) {
        //alert("areas");
        if (!areas[i].checked) {
            cnt++;
            //areas[i].value="없음";
            //alert("areas" + i + " : " + areas[i].value);
        }
    }
    alert(cnt);
    if (cnt == areas.length) {
        alert(areas.length);
        areas[0].checked = true;
        areas[0].value = "없음"
    } */
    
    //var joinDate = document.querySelector("#joinDate")
    /* var joinDate = document.getElementById("joinDate");
    //alert(joinDate);
    if (!joinDate.value) {
        joinDate.value = "0001-01-01";
        //alert(joinDate.value);
    } */
}
</script>

</body>
</html>