<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%--引入jQuery--%>
    <script src="${pageContext.request.contextPath}/statics/jquery.js"></script>
    <script>
        function verifyName() {
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                data:{"name": $("#name").val()},
                success: function (data, status) {
                    if (data.toString() === "ok") {
                        $("#userinfo").css("color", "green");
                    } else {
                        $("#userinfo").css("color", "red");
                    }
                    $("#userinfo").html(data);
                }
            });
        }

        function verifyPwd() {
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                data:{"pwd": $("#pwd").val()},
                success: function (data, status) {
                    if (data.toString() === "ok") {
                        $("#pwdinfo").css("color", "green");
                    } else {
                        $("#pwdinfo").css("color", "red");
                    }
                    $("#pwdinfo").html(data);
                }
            });
        }
    </script>
</head>
<body>
<div class="row clearfix">
    <div class="col-md-4 col-xs-6 col-center-block">
        <label class="text-center" style="width: 100px">用户名:</label>
        <input type="text" id="name" onblur="verifyName()">
        <span id="userinfo"></span>
    </div>
</div>
<div class="row clearfix">
    <div class="col-md-4 col-xs-6 col-center-block">
        <label class="text-center" style="width: 100px">密 码:</label>
        <input type="text" id="pwd" onblur="verifyPwd()">
        <span id="pwdinfo"></span>
    </div>
</div>
</body>
</html>

<style>
    .middle {
        float: none;
        vertical-align: center;
        horiz-align: center;
    }
    .center {
        float: none;
        margin-left: auto;
        margin-right: auto;
    }

    .login-form {
        position: absolute;
        top: 50%;
        -webkit-transform: translateY(-50%);
        -moz-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        -o-transform: translateY(-50%);
        transform: translateY(-50%);
        min-height: 300px;
        height: auto;
    }

    .middle-1 {
        position: absolute;
        top: 0;
        left: 0;
        bottom: 0;
        right: 0;
        margin: auto;
    }

    .col-center-block {
        float: none;
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
</style>

