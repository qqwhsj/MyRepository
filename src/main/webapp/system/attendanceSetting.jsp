<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:set var="ssm" value="${pageContext.request.contextPath}"/>
    <c:set var="web" value="${pageContext.request.contextPath}/system"/>
    <link rel="stylesheet" type="text/css" href="${ssm}/bootstrap/css/bootstrap.min.css"/>
    <link href="${ssm}/bootstrap/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
    <script src="${ssm}/js/jquery-2.2.3.min.js"></script>
    <script src="${ssm}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ssm}/bootstrap/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${ssm}/bootstrap/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="${ssm}/js/attendance.js"></script>
    <title>考勤设置</title>

</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;">
            <form action="#" method="post">
                <table class="table table-bordered" style="margin-top: 20px;">
                    <thead>
                    <tr>
                        <th style="display:none">ID</th>
                        <th>上班时间</th>
                        <th>午休开始时间</th>
                        <th>午休结束时间</th>
                        <th>下班时间</th>
                        <th style="width: 100px;">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="success">
                        <td style="display:none"></td>
                        <td>${offTime.offBegin}</td>
                        <td>${offTime.noonBegin}</td>
                        <td>${offTime.noonOver}</td>
                        <td>${offTime.offOver}</td>
                        <td>
                            <a href="${web}/updateAttendanceSetting.jsp" class="btn btn-primary btn">修改</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</body>
</html>