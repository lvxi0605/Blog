<%--
  Created by IntelliJ IDEA.
  User: lvxi
  Date: 2017/2/7
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/WEB-INF/pages/jsp/common/base.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户注册</title>
    <link href="/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/plugins/datepick/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<form data-toggle="validator" role="form" class="form-horizontal" action="/system/addRole" method="post">
    <div class="container">
        <div class="form-title">新建角色</div>
        <div class="row">
            <div class="col-md-offset-1 col-md-10">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group has-feedback">
                            <label for="name" class="col-md-4 control-label col-sm-padding">名称:</label>
                            <div class="col-md-8 col-no-padding">
                                <input type="text" class="form-control" id="name" name="name" placeholder="角色名称"
                                       required
                                       maxlength="20" data-error="角色名称长度至多20位">
                                <span class="glyphicon form-control-feedback"></span>
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group has-feedback">
                            <label for="code" class="col-md-4 control-label col-sm-padding">编码:</label>
                            <div class="col-md-8 col-no-padding">
                                <input type="text" class="form-control" id="code" name="code" placeholder="编码" required
                                       maxlength="20" data-error="编码长度至多20位">
                                <span class="glyphicon form-control-feedback"></span>
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group has-feedback">
                            <label for="icon" class="col-md-4 control-label col-sm-padding">图标:</label>
                            <div class="col-md-8 col-no-padding">
                                <input type="text" class="form-control" id="icon" name="icon"
                                       placeholder="bootstrap图标类字符串"
                                       required
                                       maxlength="65" data-error="长度至多65位">
                                <span class="glyphicon form-control-feedback"></span>
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class=" col-md-4">
                        <div class="form-group">
                            <label for="availabale" class="col-md-4 col-sm-padding control-label ">启用:
                            </label>
                            <input type="checkbox" id="availabale" name="availabale" style="margin-top:12px" checked>
                        </div>
                    </div>

                    <div class="col-md-5">
                        <div class="form-group">
                            <label for="deadline" class=" col-md-3  col-sm-padding  control-label ">有效日期: </label>
                            <div class="input-group date form_datetime col-md-8 " >
                                <input size="16" id="deadline" name="deadline" class="form-control" type="text" value="" readonly>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span class="input-group-addon"><span
                                        class="glyphicon glyphicon glyphicon-calendar"></span></span>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-4">
                        <label for="description" class="col-md-4 control-label">说明:</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-1">
                    </div>
                    <div class="col-md-11 col-no-padding">
                        <div class="form-group has-feedback">

                            <textarea class="form-control" id="description" name="description" rows="3" style="width: 100%"
                                      maxlength="100" data-error="长度至多100位"
                                      placeholder="添加角色描述"></textarea>
                        </div>
                    </div>

                    <span class="glyphicon form-control-feedback"></span>
                    <div class="help-block with-errors"></div>
                </div>
            </div>
        </div>



                <button type="submit" class="btn  btn-info center-block " style="width: 100px">添 加</button>
        </div>
    </div>
</form>


<script src="/plugins/jquery/jquery-1.11.3.min.js"></script>
<script src="/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/plugins/bootstrap/js/validator.min.js"></script>
<script src="/plugins/datepick/bootstrap-datetimepicker.min.js"></script>
<script src="/plugins/datepick/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
    /**
     *
     * 获取当前时间,返回字符串形式 yyyy/MM/dd - hh:ii
     */
    function getCurrentDate() {
        function p(s) {
            return s < 10 ? '0' + s : s;
        }

        var myDate = new Date();
        //获取当前年
        var year = myDate.getFullYear();
        //获取当前月
        var month = myDate.getMonth() + 1;
        //获取当前日
        var date = myDate.getDate();
        var h = myDate.getHours();       //获取当前小时数(0-23)
        var m = myDate.getMinutes();     //获取当前分钟数(0-59)
        var s = myDate.getSeconds();
        var now = year + '-' + p(month) + "-" + p(date) + " " + p(h) + ':' + p(m) + ":" + p(s);
        return now;
    }

    $(".form_datetime").datetimepicker({
        language: "zh-CN",
        format: "yyyy-mm-dd hh:ii:ss",
        autoclose: true,
        todayBtn: false,
        startDate: getCurrentDate(),
        minuteStep: 5
    });
</script>
</body>
</html>
