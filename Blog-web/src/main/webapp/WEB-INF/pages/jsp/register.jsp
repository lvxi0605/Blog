<%--
  Created by IntelliJ IDEA.
  User: lvxi
  Date: 2017/2/7
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>用户注册</title>

    <link href="/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<form data-toggle="validator" role="form" class="form-horizontal" action="/user/register" method="post">
    <div class="row">
        <div class="col-md-offset-4 col-md-3">
            <div class="form-title">用户注册</div>
        </div>
    </div>
    <div class="form-group has-feedback">
        <label for="account" class="col-md-4 control-label">账户:</label>
        <div class="col-md-3">
            <input type="text" class="form-control" id="account" name="account" placeholder="用户名" required minlength="4"
                   maxlength="30" pattern="^[_A-z0-9]{4,30}$" data-error="用户名要是英文字母,数字,下划线_,长度4-30位">
            <span class="glyphicon form-control-feedback"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>

    <div class="form-group has-feedback">
        <label for="password" class="col-md-4 control-label">密码:</label>
        <div class="col-md-3">
            <input type="password" class="form-control" id="password" name="password" placeholder="密码" minlength="6"
                   maxlength="30" data-error="密码长度6-30" required>
            <span class="glyphicon form-control-feedback"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>

    <div class="form-group has-feedback">
        <label for="confirmPassword" class="col-md-4 control-label">确认密码:</label>
        <div class="col-md-3">
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="密码"
                   minlength="6" maxlength="30" data-error="密码长度6-30" data-match="#password"
                   data-match-error="两次数输入的密码不一致" required>
            <span class="glyphicon form-control-feedback"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-md-offset-4 col-md-3">
            <button type="submit" class="btn  btn-info center-block " style="width: 60%">注 册</button>
        </div>
    </div>
</form>


<script src="/plugins/jquery/jquery-1.11.3.min.js"></script>
<script src="/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/plugins/bootstrap/js/validator.min.js"></script>
</body>
</html>
