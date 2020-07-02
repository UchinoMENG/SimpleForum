
function changeBack(id){
    id.style.background = 'url("images/爱梨2.jpg")';
    id.style.backgroundSize = "120%";
    id.style.backgroundRepeat = "no-repeat";
}
function changePre(id){
    id.style.background = 'url("images/爱梨.jpg")';
    id.style.backgroundSize = "150%";
    id.style.backgroundRepeat = "no-repeat";
}
function emailTemp(id){
    $(id).css({"height":"30px"});
    $("#emailerror").hide();
}
function emailblur(id) {
    $(id).css("height","25px");
    if (checkEmail()) {
        $(id).css("border-bottom-color","cyan");
        $("#emailerror").hide();
    }
    else{
        $("#emailerror").show();
        $(id).css("border-bottom-color","red");
    }
}
function checkEmail() {
    var getEmail = $("#email").val();
    var reg_email = /^\w{3,}@\w{2,}\.\w+$/;
    var flag = reg_email.test(getEmail);
    return flag;
}
function checkpassword() {
    var getPassword = $("#password").val();
    var reg_password = /^\w{6,}$/;
    var flag = reg_password.test(getPassword);
    return flag;
}
function passwordFocus(id) {
    $(id).css({"height":"30px"});
    $("#passwordInfo").hide();
}
function passwordHide(id) {
    $(id).css("height","25px");
    if (checkpassword()) {
        $(id).css("border-bottom-color","cyan");
        $("#passwordInfo").hide();
    }
    else{
        $("#passwordInfo").show();
        $(id).css("border-bottom-color","red");
    }
}

