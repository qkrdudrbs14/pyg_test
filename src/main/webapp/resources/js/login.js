


$(document).ready(() => {
    console.log("login.js");

    window.addEventListener("keyup",function(e){
        if(e.keyCode == 13){
            validation_activity();
        }
    })

});

function validation_activity(){

    let pw = CryptoJS.SHA256($('#password').val()).toString()
    $('#password').val(pw)
    pw = $('#password').val;
//    let pw = $('#password').val()
    const pattern1 = /[0-9]/; // 숫자
    const pattern2 = /[a-zA-Z]/;  // 영문자
    const pattern3 = /[~!@\#$%<>^&*]/;     // 특수문자

    console.log(`pw = ${pw}`);
    if(pattern1.test(pw) && pattern2.test(pw) && pattern3.test(pw) && pw.length>8) {   // 숫자, 영문자, 특수문자를 포함한 9자 이상의 비밀번호
        document.frm.submit();
    } else {
        document.frm.submit();
//        document.location.href="/login?error=999";
    }
}