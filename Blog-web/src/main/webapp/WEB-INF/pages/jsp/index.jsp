<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lx" uri="http://lvxiblog.cn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<body>
<shiro:guest>
<a href="${basePath}login" >登录</a>
<a href="${basePath}register">注册</a>
<br>
</shiro:guest>
<shiro:user>

</shiro:user>
<a href="/system/role/addRole">添加角色</a>
<a href="/test">测试</a>
<lx:hello/>
</body>
</html>
