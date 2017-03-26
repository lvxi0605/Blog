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
<html lang="zh-CN" ng-app>
<head>
    <title>测试</title>
    <link rel="stylesheet/less" type="text/css" href="/less/test.less" />
    <%@include file="/WEB-INF/pages/jsp/common/head.jsp" %>
    <style>
        .panel {
            /*display: block;*/
            /*width: 100%;*/
            /*padding: 6px;*/
            /*margin-bottom: 5px;*/
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
        .referPopPanel {
            position: absolute;
            left: 15px;
            height: 550px;
            z-index: 10000;
            /*background: red;*/
            display:none;
        }
    </style>
    <script>
        function Refer(referId) {
            this.id=referId;
            this.referGroupDiv=$("#referGroup_"+this.id);
            this.referPopPanel=$("#referPopPanel_"+this.id);
            this.referInput=$("#referInput_"+this.id);
            this.referBtn=$("#referBtn_"+this.id);
            this.isHoverPopPanel=false;
            this.isShowPopPanel=false;
            this.showPopPanel = function (isShow) {
                if(isShow && !this.isShowPopPanel){
                    console.log("显示面板");
                    this.referPopPanel.show();
                }else if(!isShow && this.isShowPopPanel) {
                    console.log("隐藏面板");
                    this.referPopPanel.hide();
                }
                this.isShowPopPanel=isShow;
            };

            this.resizePopPanel=function(width,height)
            {   console.log("重置弹出面板大小");
                if(width==null) width=this.referGroupDiv.width();
                this.referPopPanel.width(width);
                $("#list2").setGridWidth(width);
                if(height!=null) this.referPopPanel.height(height);
            };
            this.resizePopPanel();

        }

        function initRefer(refId) {
            var refer= new Refer(refId);
            refer.resizePopPanel();
            refer.referBtn.click(function(){
                refer.showPopPanel(true);
            });
            refer.referPopPanel.hover(function () {
                refer.isHoverPopPanel=true;
            }, function () {
                refer.isHoverPopPanel=false;
            });

            refer.referInput.focus(function(){
                refer.showPopPanel(true);
            });

            $(document).click(function(){
                if(!refer.isHoverPopPanel && !refer.referInput.is(":focus") && !refer.referBtn.is(":focus")){
                    refer.showPopPanel(false);
                }
            });
            $(window).resize(function() {
                refer.resizePopPanel();
            });
        }


        $(document).ready(function () {
            var testRefer = initRefer("test");


        });
    </script>
</head>
<body>
<div class="container" >
    <div class="row">
        <div class="col-lg-4 col-centered" >
            <div id="referGroup_test" class="input-group">
                <input id="referInput_test" ng-model="person.name" type="text" class="form-control">
                <div class="input-group-btn">
                    <button id="referBtn_test" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                </div>
            </div>
            <div id="referPopPanel_test" class="referPopPanel">
                <table id="list2"></table>
                <div id="pager2"></div>
            </div>
        </div>
    </div>
    <div class="row">

    </div>
</div>
<div class="boxlx">

</div>
<%--<table id="tableAjax11" class="table table-condensed "  data-pagination='true' data-striped='true'  data-toggle="table" data-url="http://localhost:8080/test/json">--%>

<%--</table>--%>

<%@include file="/WEB-INF/pages/jsp/common/footer.jsp" %>

<script>
    $(function(){
        //页面加载完成之后执行
        pageInit();
    });
    function pageInit(){
        //创建jqGrid组件
        $("#list2").jqGrid({
            url: 'http://localhost:8080/test/json',
            mtype: "GET",
            styleUI : 'Bootstrap',
            datatype: "json",
            //width:"100%",
           // shrinkToFit:true,
            colModel: [
                    { label: '工号', name: 'account', key: true, width: "40px" },
                    { label: '名称', name: 'nickname' }//,
    //                { label: 'Order Date', name: 'OrderDate', width: 150 },
    //                { label: 'Freight', name: 'Freight', width: 150 },
    //                { label:'Ship Name', name: 'ShipName', width: 150 }
                ],
            viewrecords: false,
            height: 250,
            rowNum: 20 ,
            pager: "#pager2",
            jsonReader : {
                root:"data",
                page: "currPage",
                total: "totalPages",
                records: "totalRecords",
                repeatitems: false
            }
        });
        $("#list2").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        /*创建jqGrid的操作按钮容器*/
        /*可以控制界面上增删改查的按钮是否显示*/
       // jQuery("#list2").jqGrid('navGrid', '#pager2', {edit : false,add : false,del : false});
    }
</script>
</body>
</html>
