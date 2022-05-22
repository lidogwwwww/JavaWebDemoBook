<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        .login {
            border: 3px solid #ffffff;
            height: 220px;
            width: 350px;
            margin: 0 auto;
            text-align: center;
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            border-radius: 15px;
            background-color: paleturquoise;
            opacity: 80%;
        }

        .tag {
            position: relative;
            /*transform: translateY(-150%);*/

            top:20px;
            margin-top: 15px;

            text-align: center;

        }
        #Login_button,#Re_button,#ReButton,#back_button{
            width: 80px;
            height:25px;
            border: 0px;
            border-radius: 20px;

        }
        .identity{
            float: left;
            width:50%;
            height:50px;
            text-align: center;

        }
        #user{
            background-color: paleturquoise;
            border-top-left-radius: 10px;

        }
        #admin{
            background-color: white;
            border-top-right-radius: 10px;

        }
        #Login_button:hover,#Re_button:hover,#ReButton:hover,#back_button:hover{
            background-color:paleturquoise;
            border: 2px solid gray;
        }
    </style>
    <script type="text/javascript" src="index.js"></script>
    <script type="text/javascript" src="jquery-3.5.1.js"></script>
    <script>

        $(function (){
            $("#admin").click(function (){

                $(this).css({"background-color":"paleturquoise"});
                $("#user").css({"background-color":"white"});
                $("#Login_button").val("AdminLogin");
                $("#Re_button").css({"display":"none"});
            });
            $("#user").click(function (){
                window.location.reload();
                $(this).css({"background-color":"paleturquoise"});
                $("#admin").css({"background-color":"white"});
                $("#Login_button").val("UserLogin");
            });
            $("#Re_button").click(function (){
                $("#loginForm").css({"display":"none"});
                $("#user").css({"display":"none"});
                $("#admin").css({"display":"none"});
                $("#Re_Form").css({"display":"block"});
            });
            $("#back_button").click(function (){
                $("#loginForm").css({"display":"block"});
                $("#user").css({"display":"block"});
                $("#admin").css({"display":"block"});
                $("#Re_Form").css({"display":"none"});

            });
        });
        function ReCheck(){
            if($("#userName").val()=="")
            {
                alert("username is empty");
                $("#userName").focus();
                return false;
            }
            else if($("#userName").val().length>=10){
                alert("The username cannot contain more than 10 characters");
                $("#userName").focus();
                return false;

            }
            else if($("#userAccount").val()=="")
            {
                alert("account is empty");
                $("#userAccount").focus();
                return false;
            }
            else if($("#userAccount").val().length>15){
                alert("The account cannot contain more than 15 characters");
                $("#userAccount").focus();
                return false;
            }
            else if($("#userPassword").val()=="")
            {
                alert("password is empty");
                $("#userPassword").focus();
                return false;
            }
            else if($("#userPassword").val().length>20){
                alert("The account cannot contain more than 20 characters");
                $("#userPassword").focus();
                return false;
            }
            else if($("#reUserPassword").val()!=$("#userPassword").val())
            {
                alert("The confirm password is inconsistent with the password!");
                $("#reUserPassword").val("");
                $("#reUserPassword").focus();
                return false;
            }

            return true;
        }

    </script>
</head>
<body background="loginphoto.jpg"
      style=" background-size:100% 100%;
            background-attachment: fixed;">
<div class="login">

    <div class="identity"id="user">
        <h3>user</h3>
    </div>
    <div class="identity" id="admin">
        <h3>admin</h3>
    </div>
        <form  method="post" action="UserServlet" onsubmit="return check();" id="loginForm">
                <input type="text" class="tag" name="UserName" id="name"placeholder="account">
                <br>
                <input type="password" class="tag" name="Password"id="password"placeholder="password">
                <br>
                <input type="submit" class="tag" name="UserAction" value="UserLogin" id="Login_button">
                <input type="button" class="tag" name="" value="register" id="Re_button">
         </form>
    <form  method="post" action="UserServlet" onsubmit="return ReCheck();" id="Re_Form" style="display:none">
      <input type="text" class="tag" name="re_userName" id="userName"placeholder="username">
        <br>
      <input type="text" class="tag" name="re_Account" id="userAccount"placeholder="account">
        <br>
      <input type="password" class="tag" name="re_password"id="userPassword"placeholder="password">
        <br>
       <input type="password" class="tag" name=""id="reUserPassword"placeholder="confirm password">
        <br>
        <input type="submit" class="tag" name="UserAction" value="register" id="ReButton">
        <input type="button" class="tag" name="" value="back" id="back_button">
    </form>
    </div>
</body>

</html>