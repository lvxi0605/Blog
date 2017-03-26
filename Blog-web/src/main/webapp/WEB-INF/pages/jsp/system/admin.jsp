<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  ~ (c) Copyright 2017 lvxi. All Rights Reserved.
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~--%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>系统后台管理系统</title>
    <%@include file="/WEB-INF/pages/jsp/common/head.jsp" %>
    <link href="${ctx}/css/system/admin.less" rel="stylesheet/less" type="text/css" />
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-default admin-navbar" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#leftNav" aria-expanded="false">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>

                        <div class="navbar-toggle input-group collapsed admin-btn">
                            <button type="button" class="dropdown-toggle " data-toggle="collapse"
                                    data-target="#person-menu" aria-expanded="false"
                                    style="background: none;border:none">
                                <img style="" height="42" width="42" class=" img-circle"
                                     src="http://d.hiphotos.baidu.com/image/pic/item/9f510fb30f2442a70ac9d94bd543ad4bd013021c.jpg"/>
                            </button>
                            <%--此处复制js生成--%>
                        </div>

                    <a class="navbar-brand admin-brand" href="#"> <img src="${ctx}/image/logo.png" style="vertical-align:middle;"/>Blog</a>

                </div>

                <ul class="nav navbar-nav navbar-right hidden-xs">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle admin-btn" style="padding:0px" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">
                            <img style="" height="48" width="48" class=" img-circle"
                                 src="http://d.hiphotos.baidu.com/image/pic/item/9f510fb30f2442a70ac9d94bd543ad4bd013021c.jpg"/>
                        </a>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="#"><i class="icon-gerenzhongxin"></i>个人中心</a></li>
                            <li><a href="#"><i class="icon-shezhi"></i>设置</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#"><i class="icon-tuichu"></i>退出</a></li>
                        </ul>
                    </li>
                </ul>

                <div class="collapse navbar-collapse " id="person-menu">
                    <ul class="nav navbar-nav visible-xs-block">
                        <li><a href="#"><i class="icon-gerenzhongxin"></i>个人中心</a></li>
                        <li><a href="#"><i class="icon-shezhi"></i>设置</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#"><i class="icon-tuichu"></i>退出</a></li>
                    </ul>
                </div>

            </div>
        </nav>
    </div>
    <div class="row admin-context test-border">
        <div id="leftMenu"  class="col-md-2 panel panel-default" >
            <%--左侧菜单开始--%>
            <div class="panel-body">
                <div id="leftNav" class="collapse navbar-collapse" >
                    <ul id="accordion" class="accordion">
                        <li>
                            <div class="link"><i class="fa fa-paint-brush"></i>首页<i class="glyphicon glyphicon-menu-down"></i></div>
                            <ul class="submenu">
                                <li>
                                    <a href="#">Photoshop</a>
                                </li>
                                <li>
                                    <a href="#">HTML</a>
                                </li>
                                <li>
                                    <a href="#">CSS</a>
                                </li>
                                <li>
                                    <a href="#">Maquetacion web</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <div class="link"><i class="fa fa-code"></i>个人中心<i class="fa fa-chevron-down"></i></div>
                            <ul class="submenu">
                                <li>
                                    <a href="#">Javascript</a>
                                </li>
                                <li>
                                    <a href="#">jQuery</a>
                                </li>
                                <li>
                                    <a href="#">Frameworks javascript</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <div class="link"><i class="fa fa-mobile"></i>Diseño responsive<i class="fa fa-chevron-down"></i></div>
                            <ul class="submenu">
                                <li>
                                    <a href="#">Tablets</a>
                                </li>
                                <li>
                                    <a href="#">Dispositivos mobiles</a>
                                </li>
                                <li>
                                    <a href="#">Medios de escritorio</a>
                                </li>
                                <li>
                                    <a href="#">Otros dispositivos</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <div class="link"><i class="fa fa-globe"></i>Posicionamiento web<i class="fa fa-chevron-down"></i></div>
                            <ul class="submenu">
                                <li>
                                    <a href="#">Google</a>
                                </li>
                                <li>
                                    <a href="#">Bing</a>
                                </li>
                                <li>
                                    <a href="#">Yahoo</a>
                                </li>
                                <li>
                                    <div class="link"><i class="fa fa-globe"></i>子菜单<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <li>
                                            <a href="#">Tablets</a>
                                        </li>
                                        <li>
                                            <a href="#">Dispositivos mobiles</a>
                                        </li>
                                        <li>
                                            <a href="#">Medios de escritorio</a>
                                        </li>
                                        <li>
                                            <a href="#">Otros dispositivos</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="rightMenu"  class="col-md-10 panel panel-default">
            <div class="panel-body test-border"  >
            <div class="test-border">
                <%--右侧显示区域开始--%>
                123456
            </div>
            </div>
        </div>
    </div>

</div>


<%@include file="/WEB-INF/pages/jsp/common/footer.jsp" %>
<script src="${ctx}/js/system/admin.js" type="text/javascript"></script>
</body>
</html>