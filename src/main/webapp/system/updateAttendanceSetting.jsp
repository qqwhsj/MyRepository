<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改考勤设置</title>
    <c:set var="ssm" value="${pageContext.request.contextPath}"></c:set>
    <c:set var="sign" value="${pageContext.request.contextPath}/sign"></c:set>
    <c:set var="web" value="${pageContext.request.contextPath}/mavenssm01"></c:set>
    <link rel="stylesheet" type="text/css" href="${ssm}/bootstrap/css/bootstrap.min.css"/>
    <link href="${ssm}/bootstrap/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
    <script src="${ssm}/js/jquery-2.2.3.min.js"></script>
    <script src="${ssm}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ssm}/bootstrap/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${ssm}/bootstrap/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <style type="text/css">
        .myDiv {
            width: 400px;
            height: 350px;
            border: 1px solid #5e5e5e;
            top: 20%;
            left: 20%;
            margin-top: -100px;
            margin-left: -150px;
            position: absolute;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="myDiv">
    <div class="row-fluid">
        <form class="form-horizontal" method="post" action="${sign}/updateOffTime.do" style="padding: 15px;">
            <input type="hidden" name="id" value=""/>
            <h3>修改考勤设置：</h3>
            <div class="form-group">
                <label class="col-sm-4 control-label" for="offBegin">上班时间:</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" id="offBegin" name="offBegin" value="09:00:00">
                    &nbsp;${offTimeEx.offBeginEx}
                </div>
            </div>
            <div class="form-group">

                <label class="col-sm-4 control-label" for="noonBegin">午休开始时间:</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" id="noonBegin" name="noonBegin" placeholder="12:00:00">
                    &nbsp;${offTimeEx.noonBeginEx}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label" for="noonOver">午休结束时间:</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" id="noonOver" name="noonOver" value="13:00:00">
                    &nbsp;${offTimeEx.noonOverEx}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label" for="offOver">下班时间:</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" id="offOver" name="offOver" value="18:00:00">
                    &nbsp;${offTimeEx.offOverEx}
                </div>
            </div>
            <div class="row" style="float:right;">
                <div class="col-sm-12">
                    <input type="submit" class="btn btn-primary btn" value="提交"/>
                </div>
            </div>
        </form>
        <p style="color: red;text-align: center;"></p>
    </div>
</div>
</body>
<script type="text/javascript">
</script>
</html>