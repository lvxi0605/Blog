<%--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  ~ (c) Copyright 2017 lvxi. All Rights Reserved.
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~--%>

<%--
  User: lvxi Date: 2017/3/3 23:10
  Note:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>Less学习</title>
    <link rel="stylesheet/less" type="text/css" href="/less/test.less" />
    <%@include file="/WEB-INF/pages/jsp/common/head.jsp" %>

</head>
<body>
<div id="header">
<h1>Hello Less</h1>
    <p><a >学习让我快乐!!!</a>可以在一个选择器中嵌套另一个选择器来实现继承，这样很大程度减少了代码量，并且代码看起来更加的清晰。</p>
</div>
<%@include file="/WEB-INF/pages/jsp/common/footer.jsp" %>
</body>
</html>