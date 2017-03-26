<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>添加角色</title>
    <%@include file="/WEB-INF/pages/jsp/common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-9 form-label-compact">
        <form  class="form-horizontal" action="/system/addRole" method="post">
            <div class="form-title">新建角色</div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                    <label for="name" class="col-md-4 control-label">名称:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="name" name="name" placeholder="角色名称"
                               required
                               maxlength="20" data-error="角色名称长度至多20位">
                    </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="code" class="col-md-4 control-label">编码:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="code" name="code" placeholder="编码" required
                                   maxlength="20" data-error="编码长度至多20位">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="icon" class="col-md-4 control-label">图标:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="icon" name="icon"
                                   placeholder="bootstrap图标类字符串"
                                   required
                                   maxlength="65" data-error="长度至多65位">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="availabale" class="col-md-4 col-sm-padding control-label ">启用:
                        </label>
                        <div class="col-md-8">
                            <div id="availabale" class="switch switch-large">
                                <input name="availabale" type="checkbox" checked />
                            </div>
                        <%--<input type="checkbox" id="availabale" name="availabale" style="margin-top:12px" checked>--%>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                <div class="form-group" style="margin-right:0px;">
                        <label for="deadline" class=" col-md-2 control-label ">有效日期: </label>
                        <div class="input-group date form_datetime col-md-6 ">
                            <input size="16" id="deadline" name="deadline" class="form-control" type="text"
                                   readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="description" class="col-md-4 control-label">说明:</label>
                    </div>
                </div>
            </div>
            <div class="row row-horizontal-no-margin">
                <div class="col-md-offset-1 col-md-11" style="padding-left: 8px">
                    <div class="form-group ">
                            <textarea class="form-control" id="description" name="description" rows="3"
                                      style="width: 100%"
                                      maxlength="100" data-error="长度至多100位"
                                      placeholder="添加角色描述"></textarea>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn  btn-info center-block " style="width: 100px">添 加</button>
        </form>
    </div>
</div>
    <%@include file="/WEB-INF/pages/jsp/common/footer.jsp" %>
    <script src="${ctx}/js/system/role/addRole.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
