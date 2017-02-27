<%--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  ~ (c) Copyright 2017 lvxi. All Rights Reserved.
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~--%>

<%--
  User: lvxi Date: 2017/2/23 22:31
  Note:
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>测试</title>
    <%@include file="/WEB-INF/pages/jsp/common/head.html" %>
    <style>
        .panel {
            display: block;
            width: 100%;
            padding: 6px;
            margin-bottom: 5px;
            color: #555;
            background-color: #fff;
            background-image: none;
            border: 1px solid #ccc;
            border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
            -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
        }

        .panel2 {
            position: relative;
            display: table;
            border-collapse: separate;
        }

        .tipPanel {
            position: absolute;
            left: 15px;
            height: 50px;
            z-index: 10000;
            background: red;
            display:none;
        }
    </style>
    <script>
        function resizeReferPanel(referGroupId,referPanelID) {
            var referGroup = $("#"+referGroupId);
            var referPanel =  $("#"+referPanelID);
            referPanel.width(referGroup.width());
        }
        $(document).ready(function () {
            var referGroup = $("#referGroup");
            var referPanel =  $("#referPanel");

            $(window).resize(function () {
                referPanel.width(referGroup.width());
            });
            $("#testInput").focus(function(){
                referGroup.width($("#group").width());
                $("#testTip").show();
            });
            $("#testInput").blur(function(){
                $("#testTip").hide();
            });
        });

    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-centered">
            <div id="referGroup" class="input-group">
                <input id="referInput" type="text" class="form-control">
                <div class="input-group-btn">
                    <button class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                </div>
            </div>
            <div id="referPanel" class="tipPanel"></div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/pages/jsp/common/footer.html" %>
</body>
</html>
