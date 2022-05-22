
function check(){
    const user = document.getElementsByName("UserName")[0].value;
    const password = document.getElementsByName("Password")[0].value;
    if(user=='')
    {
        alert("account is empty");
        document.getElementsByName("UserName")[0].focus();
        return false;
    }
    if(password=='')
    {
        alert("password is empty");
        document.getElementsByName("Password")[0].focus();
        return false;
    }
    return true;

}



