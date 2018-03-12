$('header').load('../header.html');
$('footer').load('../footer.html');
$('.left-nav').load('../left-nav.html');

var loginUserNoItem = $('#loginUserNo'),
formDataItem = $('#formData'),

oldPasswordItem = $('#oldPassword'),
passwordItem = $('#newPassword'),
pwConfirmItem = $('#newPwConfirm'),

chkOldPwMsgItem = $('#chkOldPwMsg'),
chkPwMsgItem = $('#chkPwMsg'),

addBtn = $('#addBtn'),

conPw = null,
completConfirm = null;

var index = location.href.indexOf('?');
if (index != -1) {
var qs = location.href.substr(index + 1);
var arr = qs.split('=');
$(window).ready(function() {
    $.ajax({
        url: '../json/member/' + arr[1],
        dataType: 'json',
        success: (result) => {
        
          if (result.status == 'fail') {
            window.alert("잘못된 접근입니다.");
            return location.href='chgpwd.html?no=' + result.realUserNo;
          }
          loginUserNoItem.val(result.member.no);
       },
       error: function () {
         alert("회원 정보를 확인할 수 없습니다.");
         location.href='../auth/loginform.html';
       }
   });
});
}

var re_password = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,18}/;

function checkNewPassword() {
if (re_password.test(passwordItem.val()) == true) {
    chkPwMsgItem.html('<p class="checkMessages" style="color:blue;">사용 가능한 비밀번호입니다.</p>');
    conPw = true;
    return conPw;
} else if (re_password.test(passwordItem.val()) == false) {
    chkPwMsgItem.html('<p class="checkMessages" style="color:red;">비밀번호는 영문/숫자/특수문자 조합 6~18자입니다.</p>');
    conPw = false;
    return conPw;
} 
};


function confirmNewPassword() {
if (passwordItem.val() == pwConfirmItem.val() && conPw == true) {
    chkPwMsgItem.html('<p class="checkMessages" style="color:blue;">비밀번호 확인 일치!</p>');
    completConfirm = true;
    return completConfirm;
} else if (re_password.test(pwConfirmItem.val()) == false) {
    chkPwMsgItem.html('<p class="checkMessages" style="color:red;">비밀번호는 영문/숫자/특수문자 조합 6~18자입니다.</p>');
    completConfirm = false;
    return completConfirm;
} else {
    chkPwMsgItem.html('<p class="checkMessages" style="color:red;">비밀번호 확인 불일치!</p>');
    completConfirm = false;
    return completConfirm;
}
};


addBtn.click(() => {

if (oldPasswordItem.val() == passwordItem.val()) {
    chkPwMsgItem.html('<p class="checkMessages" style="color:red;">기존 비밀번호와 다른 비밀번호를 입력해주세요.</p>');
    passwordItem.val("");
    pwConfirmItem.val("");
    passwordItem.focus();
    return; 
} else if (oldPasswordItem.val() == "") {
    chkOldPwMsgItem.html('<p class="checkMessages" style="color:red;">기존 비밀번호를 입력해 주세요.</p>');
    oldPasswordItem.focus();
    return;
}

//비밀번호 검사
if (passwordItem.val() == "") {
    chkPwMsgItem.html('<p class="checkMessages" style="color:red;">비밀번호를 입력해 주세요.</p>');
    pwConfirmItem.val("");
    passwordItem.focus();
    return;
} else if (re_password.test(passwordItem.val()) == false) {
    passwordItem.focus();
    return;
} else if (completConfirm == false) {
    pwConfirmItem.focus();
    return;
} else if (pwConfirmItem.val() == "") {
    chkPwMsgItem.html('<p class="checkMessages" style="color:red;">비밀번호 확인을 입력해 주세요.</p>');
    pwConfirmItem.focus();
    return;
}


var formData = new FormData(formDataItem[0]);

$.ajax('../json/member/updatePassword', {
data: formData,
dataType: 'json',
method: 'POST',
processData: false,
contentType: false,
success: (result) => {
    
    if (result.status == 'success') {
    $.getJSON('../json/auth/logout', (result) => {
            console.log(result);
            location.href='../auth/loginform.html';
        });
    }
    
    if (result.status == 'compare_fail') {
        chkOldPwMsgItem.html('<p class="checkMessages" style="color:red;">기존 비밀번호가 일치하지 않습니다.</p>');
        oldPasswordItem.val("");
        oldPasswordItem.focus();
        return;
    }
    
    if (result.status == 'fail') {
        alert("회원정보가 일치하지 않습니다.");
        return;
    }
},
error: () => {
    alert("서버 입력 오류!");
}
});
});
