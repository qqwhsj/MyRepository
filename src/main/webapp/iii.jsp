<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/4 0004
  Time: 下午 3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <title>Title</title>
    <c:set var="ssm" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css" href="${ssm}/bootstrap/css/bootstrap.min.css"/>
    <link href="${ssm}/bootstrap/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
    <script src="${ssm}/js/jquery-2.2.3.min.js"></script>
    <script src="${ssm}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ssm}/bootstrap/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${ssm}/bootstrap/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
</head>
<body>
<div style="height:500px;border: 1px solid #f79646">
    <div>
<%--        <form id="input-group date" method="" action="">--%>
            &nbsp;&nbsp;&nbsp;
            <label style="font-weight:normal;background-color: #fac090;width: 80px;text-align: center">Date</label>
            <input type="text" id="input_date" name="recordDate" style="border:0.5px solid #fac090"/>
<%--        </form>--%>
    </div>
</div>
<script type="text/javascript">

    $(function(){
        $("#input_date").datetimepicker({
            bootcssVer:3,  //bootstrap-datetimepicker＋bootstrap v3，但这个插件使用的时候，并没有和V3相匹配，仍然调用的是bootstrap V2的图标 把bootcssVer的值直接设为3，否则datetimepicker不会显示出上、下个月的箭头
            format: 'yyyy-mm-dd',
            minView: 'month',//设置时间选择为年月日 去掉时分秒选择
            todayBtn: true, //如果此值为true 或 "linked"，则在日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。如果是true的话，"Today" 按钮仅仅将视图转到当天的日期，如果是"linked"，当天日期将会被选中。
            language: 'zh-CN',
            autoclose: true, //当选择一个日期之后是否立即关闭此日期时间选择器。
            keyboardNavigation: true, //是否允许通过方向键改变日期。
            forceParse: true, //当选择器关闭的时候，是否强制解析输入框中的值。
            todayHighlight: 1  //如果为true, 高亮当前日期
        }).on("click", function () {
            //設置可选的最后日期為當前日期
            $("#input_date").datetimepicker("setEndDate", getToday())
        });
    });

    //獲取當前日期
    function getToday(){
        var today = new Date()
        var year = today.getFullYear();
        var month = today.getMonth() + 1;
        var day = today.getDate();
        var todayStr = year+"-"+month+"-"+day;
        return todayStr;
    }
</script>
</body>
</html>
