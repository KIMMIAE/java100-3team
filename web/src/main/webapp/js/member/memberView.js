var formDataItem = $('#formData'),
    updateBtn = $('#updateBtn'),
    deleteBtn = $('#deleteBtn'),
    
    cuttingBtn = $('#cuttingBtn'),
    
    /* input의 id 변수들 */
    
    noItem = $('#no'),
    emailItem = $('#email'),
    pwConfirmItem = $('#pwConfirm'),
    nickNameItem = $('#nickName'),
    messageFlag1Item = $('#messageFlag1'),
    messageFlag2Item = $('#messageFlag2'),
    messageIdItem = $('#messageId'),
    type1Item = $("#type1"),
    type2Item = $("#type2"),
    artistNameItem = $('#artistName'),
    artistMemberItem = $('#artistMember'),
    profileItem = $('#profile'),
    joinDateItem = $('#joinDate'),
    areasDivItem = $('#areasDiv'),
    genresDivItem = $('#genresDiv'),
    
    imageCropperItem = $('#image-cropper'),
    hiddenImageData = $('#hidden-image-data'),
    
    /* check div들에 문구를 출력해줄 변수들 */
    
    chkEmailMsgItem = $('#chkEmailMsg'),
    chkPwMsgItem = $('#chkPwMsg'),
    chkNickMsgItem = $('#chkNickMsg'),
    chkMessageIdItem = $('#chkMessageId'),
    chkArtistNameItem = $('#chkArtistName'),
    chkArtistMemberItem = $('#chkArtistMember'),
    chkProfileItem = $('#chkProfile'),
    chkJoinDateItem = $('#chkJoinDate'),
    chkAreasItem = $('#chkAreas'),
    chkGenresItem = $('#chkGenres'),
    
    chkImageItem = $('#chkImageMsg'),
    
    /* 검증용 변수 */
    
    emailCount = null,
    nickNameCount = null,
    conPw = null,
    completConfirm = null,
    currentPicture = null,
    
    memberPhoto ="dragNdrop";
    


    
cuttingBtn.click(function(){
    var imageData = imageCropperItem.cropit('export', {
        type: 'image/jpeg',
        quality: .9,
        originalSize: true
    });
    
    hiddenImageData.val(imageData);
    
    if (hiddenImageData.val() != "") {
        chkImageItem.html('<p class="checkMessages">사진 편집이 완료 되었습니다.</p>')
    }
});
    
      

    
$('header').load('../header.html');
$('footer').load('../footer.html');
$('.left-nav').load('../left-nav.html');
    
$("#messageFlag1").click(function(){
    $("#messageIdDiv").show();
});
    
$("#messageFlag2").click(function(){
    $("#messageIdDiv").hide();
});

$("#artistInfoDiv").hide();

$("#type1").click(function(){
    $("#artistInfoDiv").hide();
});

$("#type2").click(function(){
    $("#artistInfoDiv").show();
});

var index = location.href.indexOf('?');

if (index != -1) { // 기존 데이터를 조회할 경우,
    var qs = location.href.substr(index + 1);
    var arr = qs.split('=');

    $(() => {
        $.ajax('../json/member/' + arr[1], {
            dataType: 'json',
            success: (result) => {
                
                if (result.status == 'fail') {
                  window.alert("잘못된 접근입니다.");
                  return location.href='view.html?no=' + result.realUserNo;
                }
                
                noItem.val(result.member.no);
                emailItem.val(result.member.email);
                nickNameItem.val(result.member.nickName);

                if (result.member.messageFlag == '1') {
                    messageFlag1Item.prop("checked", true);
                    $("#messageIdDiv").show();
                } else {
                    messageFlag2Item.prop("checked", true);
                    $("#messageIdDiv").hide();
                }

                messageIdItem.val(result.member.messageId);

                if (result.member.type == "아티스트") {
                    type2Item.prop("checked", true);
                    $("#artistInfoDiv").show();
                    artistNameItem.val(result.member.artist.artistName);
                    artistMemberItem.val(result.member.artist.artistMember);
                    profileItem.val(result.member.artist.profile);
                    joinDateItem.val(formatDate(result.member.artist.joinDate));

                } else {
                    type1Item.prop("checked", true);
                }


                var areas = [];
                var i = 0;
                for (var info of result.arealist) {
                    areas[i++] = info.areaName;

                    var objAreas = document.getElementsByName("areas");
                    for (i = 0; i < objAreas.length; i++) {
                        for (j = 0; j < areas.length; j++) {
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
                }

                var genres = [];
                i = 0;

                for (var info of result.genrelist) {
                    genres[i++] = info.genreName;
                    var objGenre = document.getElementsByName("genres");
                    
                    for (i = 0; i < objGenre.length; i++) {
                        
                        for (j = 0; j < genres.length; j++) {
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
                
                currentPicture = result.member.photo;
                
                imageCropperItem.cropit({
                    imageBackground:true, 
                    imageBackgroundBorderWidth: 15,
                    allowDragNDrop:true,
                    imageState: { src: "../download/" + currentPicture }
                });
                
                return currentPicture;
            },
            error: () => {
                window.alert('서버 실행 오류!');
            }
        });
    });

} else { // 신규 데이터 입력일 경우,
    alert('잘못 된 경로입니다. 회원가입 페이지로 넘어갑니다.');
    location.href='form.html';
}

function formatDate(jason) {
    var jasondate = new Date(jason);
    return jasondate.getFullYear() + '-' +
    pad((jasondate.getMonth() + 1), 2) + '-' +
    pad(jasondate.getDate(), 2);
}

function pad(n, width) {
    n = n + '';
    return n.length >= width ? n : new Array(width - n.length + 1).join('0') + n;
}

var re_email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
var re_password = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,18}/;
var re_nickName = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,10}$/;



function checkEmail() {
    $.ajax({
        url: '../json/member/checkEmail',
        type: 'post',
        data: {
            email: emailItem.val()
        },
        success: function (count) {
            if (count == 0 && re_email.test(emailItem.val()) == true) {
                chkEmailMsgItem.html('<p class="checkMessages" style="color:blue;">사용 가능한 이메일입니다.</p>');
                emailCount = count;
                return emailCount;
            } else if (re_email.test(emailItem.val()) == false) {
                chkEmailMsgItem.html('<p class="checkMessages" style="color:red;">이메일 형식이 맞지 않습니다.</p>');
                emailCount = count;
                return emailCount;
            } else if (count == 1) {
                chkEmailMsgItem.html('<p class="checkMessages" style="color:red;">이미 가입한 이메일입니다.</p>');
                emailCount = count;
                return emailCount;
            } 
        },
        error: function () {
            alert("이메일 체크 중 서버 에러");
        }
    });
};

function checkNickName() {
    $.ajax({
        url: '../json/member/checkNickName',
        type: 'post',
        data: {
            nickName: nickNameItem.val()
        },
        success: function (count) {
            if (count == 0 && re_nickName.test(nickNameItem.val()) == true) {
                chkNickMsgItem.html('<p class="checkMessages" style="color:blue;">사용 가능한 닉네임입니다.</p>');
                nickNameCount = count;
                return nickNameCount;
            } else if (re_nickName.test(nickNameItem.val()) == false) {
                chkNickMsgItem.html('<p class="checkMessages" style="color:red;">닉네임 형식이 맞지 않습니다.</p>');
                nickNameCount = count;
                return nickNameCount;
            } else if (count == 1) {
                chkNickMsgItem.html('<p class="checkMessages" style="color:red;">이미 등록된 닉네임입니다.</p>');
                nickNameCount = count;
                return nickNameCount;
            }
        },
        error: function () {
            alert("닉네임 체크 중 서버 에러");
        }
    });
};




updateBtn.click(() =>  {
console.log("업데이트 버튼");
// 이메일 검증
if (emailItem.val() == "") {
    console.log("이메일 검증 1");
    chkEmailMsgItem.html('<p class="checkMessages" style="color:red;">이메일을 입력해주세요.</p>');
    emailItem.focus();
    return;
}

if (re_email.test(emailItem.val()) == false || emailCount == 1) {
    emailItem.focus();
    return;
}


// 닉네임 검사
if (nickNameItem.val() == "") {
    console.log("닉네임 검사 1");
    chkNickMsgItem.html('<p class="checkMessages" style="color:red;">닉네임을 입력해 주세요.</p>');
    nickNameItem.focus();
    return;
} else if (re_nickName.test(nickNameItem.val()) == false) {
    console.log("닉네임 검사 2");
    nickNameItem.focus();
    return;
} else if (nickNameCount == 1) {
    console.log("닉네임 검사 3");
    console.log(nickNameCount);
    nickNameItem.focus();
    return;
}


// 메시지 수신 동의 시 아이디 입력 확인
if ($("input[name='messageFlag']:checked").val() == 
        '1' && messageIdItem.val() == "") {
    chkMessageIdItem.html('<p class="checkMessages" style="color:red;">메세지를 수신 받을 카카오톡 ID를 입력해주세요.</p>');
    messageIdItem.focus();
   return;
} 

// 아티스트 입력 항목 검사
if ($("input[name='type']:checked").val() == '아티스트') {
    if (artistNameItem.val() == "") {
        chkArtistNameItem.html("활동명을 입력해주세요.");
        artistNameItem.focus();
        return;
    } else if (artistMemberItem.val() == "") {
        chkArtistMemberItem.html("팀 구성원을 입력해주세요.");
        artistMemberItem.focus();
        return;
    } else if (profileItem.val() == "") {
        chkProfileItem.html("프로필을 입력해주세요.");
        profileItem.focus();
        return;
    } else if (joinDateItem.val() == "") {
        chkJoinDateItem.html("팀 결성일을 입력해주세요!");
        joinDateItem.focus();
        return;
    }
}

// 관심 장르와 지역 반드시 입력
if ($("input[name='genres']:checked").val() == null) {
    chkGenresItem.html("관심 지역을 체크해주세요.");
    genresDivItem.focus();
   return;
}

if ($("input[name='areas']:checked").val() == null) {
    chkAreasItem.html("관심 장르를 체크해주세요");
    areasDivItem.focus();
   return;
}

var formData = new FormData(formDataItem[0]);

if (joinDateItem.val() != "") {
    formData.append("artist.joinDate", joinDateItem.val() + " 00:00");
}


console.log(hiddenImageData.val());

if (hiddenImageData.val() != "") {
    formData.append("base64Image", hiddenImageData.val());
}
    $.ajax('../json/member/update', {
        data: formData,
        dataType: 'json',
        method: 'POST',
        processData: false,
        contentType: false,
        success: () => {
            location.href="../index.html";
        },
        error: () => {
            alert("서버 입력 오류!");
        }
    });
});


deleteBtn.click(() => {
    $.ajax('../json/member/delete', {
        data: {
            no: noItem.val()
        },
        dataType: 'json',
        success: (result) => {
            location.href = "list.html";
        },
        error: () => {
            window.alert('삭제 중 서버 실행 오류!');
        }
    });
});


