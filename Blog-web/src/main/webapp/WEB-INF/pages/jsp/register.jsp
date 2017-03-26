<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>用户注册</title>
    <%@include file="/WEB-INF/pages/jsp/common/head.jsp" %>
</head>
<body ng-app="registerApp">
<div class="container">
    <div class="col-md-4 form-label-compact">

        <form id="registerForm" ng-controller="registerFormController" class="form-horizontal"
              action="${ctx}/register" method="post">
            <div class="col-md-offset-3 form-title">用户注册</div>
            <div class="form-group">
                <label for="account" class="col-md-3 control-label">账户:</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="account" name="account" ng-model="account"
                           ng-blur="isExistUser()" placeholder="用户名">
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="col-md-3 control-label">密码:</label>
                <div class="col-md-9">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                </div>
            </div>

            <div class="form-group">
                <label for="confirmPassword" class="col-md-3 control-label">确认密码:</label>
                <div class="col-md-9">
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                           placeholder="密码">
                </div>
            </div>

            <c:if test="${fn:length(errorMap) gt 0 }">
            <div class="alert alert-danger alert-dismissible col-left-compact" role="alert" style="margin-left: -6px;">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <div style="display: inline-block;vertical-align:top">
                    <i class="iconfont icon-tishi1"></i>
                </div>
                <div style="display: inline-block">
                    <ol>
                        <c:forEach var="item" items="${errorMap}" varStatus="st">
                            <li>
                                ${item.value}
                            </li>
                        </c:forEach>
                    </ol>
                </div>
            </div>
            </c:if>
            <div class="form-group">
                <div class="col-md-offset-3 col-md-9 col-left-compact" style="">
                    <button type="submit" class="btn  btn-info" style="width: 100%">注 册</button>
                </div>
            </div>
    </div>
    </form>
</div>
</div>


<%@include file="/WEB-INF/pages/jsp/common/footer.jsp" %>
<script src="${ctx}/js/register.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
