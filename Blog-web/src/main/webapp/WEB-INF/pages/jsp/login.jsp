<%--
  ~ (c) Copyright 2017 lvxi. All Rights Reserved.
  --%>

<%--
  User: lvxi Date: 2017/2/23 22:31
  Note:
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lx" uri="http://lvxiblog.cn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>用户登录</title>
    <%@include file="/WEB-INF/pages/jsp/common/head.html" %>
</head>
<body>
<form data-toggle="validator" role="form" class="form-horizontal" action="${basePath}login" method="post">
    <div class="row">
        <div class="col-md-offset-4 col-md-3">
            <div class="form-title">用户登录</div>
        </div>
    </div>
    <div class="form-group has-feedback">
        <label for="account" class="col-md-4 control-label">账户:</label>
        <div class="col-md-3">
            <input type="text" class="form-control" id="account" name="account" placeholder="用户名" required minlength="4"
                   maxlength="30" pattern="^[_A-z0-9]{4,30}$" data-error="用户名要是英文字母,数字,下划线_,长度4-30位">
            <span class="glyphicon form-control-feedback"></span>
            <div class="help-block with-errors">
            </div>
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
    <c:if  test="${!empty loginError}">
        <div class="row">
            <div class="col-md-offset-4 col-md-3">
                <div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <i class="iconfont icon-tishi1"></i>
                    <c:out value="${loginError}"></c:out>
                </div>
            </div>
        </div>
    </c:if>
    <div class="form-group">
        <div class="col-md-offset-4 col-md-3">
            <button type="submit" class="btn  btn-info center-block " style="width: 60%">登 录</button>
        </div>
    </div>
</form>
<lx:hello/>
<%@include file="/WEB-INF/pages/jsp/common/footer.html" %>
<script src="/plugins/bootstrap-validator.min.js"></script>
</body>
</html>
