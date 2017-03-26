<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<body>
<shiro:guest>
    <a href="${ctx}/login">登录</a>
    <a href="${ctx}/register">注册</a>
    <br>
</shiro:guest>
<shiro:user>
    欢迎您,${userProfile.nickname}
    <a href="${ctx}/logout">退出</a>
    <br>
</shiro:user>
<a href="${ctx}/system/admin">后台管理</a>
<a href="${ctx}/system/role/addRole">添加角色</a>

<a href="${ctx}/system/resource/addResource">添加系统资源</a>

<a href="${ctx}/test">测试</a>
</body>
</html>
