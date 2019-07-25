<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:set var="ssm" value="${pageContext.request.contextPath}"/>
    <c:set var="web" value="${pageContext.request.contextPath}/system"/>
    <script type="text/javascript" src="${ssm}/js/user-info.js"></script>
    <link rel="stylesheet" type="text/css" href="${ssm}/bootstrap/css/bootstrap.min.css"/>
    <link href="${ssm}/bootstrap/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
    <script src="${ssm}/js/jquery-2.2.3.min.js"></script>
    <script src="${ssm}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ssm}/bootstrap/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${ssm}/bootstrap/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <title>新增用户</title>
    <style type="text/css">
        .inputText {
            width: 430px !important;
        }

        .rowDiv {
            margin-bottom: 15px;
        }

        .form-lavel {
            width: 80px;
            text-align: right;
        }
    </style>
</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;padding-top: 0px;">
            <form action="${ssm}/updateMsg.do?mid=${msgIndex.mid}" method="post" id="userForm" enctype="multipart/form-data" role="form" class="form-inline"
                  style="margin-bottom: 10px;">
                <div id="userInfoDiv" class="form" style="padding:5px;">
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="username">账号：</label>
                                <input type="hidden" name="username" id="username" value="${username }"/>
                                <input type="hidden" name="sex" id="sex" value="${msgIndex.sex }"/>
                                <input type="hidden" name="uid" id="uid" value="${msgIndex.uid }"/>
                                <input type="text" class="form-control inputText"
                                       name="username" value="${username}"
                                       disabled="disabled">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="mname">姓名：</label>
                                <input type="text" class="form-control inputText" id="mname" name="mname"
                                       value="${msgIndex.mname}">
                                <c:if test="${exMsg.mnameEx eq null}">
                                    <span style="color: red;">*</span>
                                </c:if>
                                &nbsp;${exMsg.mnameEx}
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="mname">性别：</label>
                                <input type="radio" name="sex" value="0" />男&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="sex" value="1"/>女&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="sex" value="2"/>未知
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="age">年龄：</label>
                                <input type="text" class="form-control inputText" id="age" name="age"
                                       value="${msgIndex.age}">
                                <c:if test="${exMsg.ageEx eq null}">
                                    <span style="color: red;">*</span>
                                </c:if>
                                &nbsp;${exMsg.ageEx}
                            </div>

                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="mobile">手机号：</label>
                                <input type="text" class="form-control inputText" id="mobile" name="mobile"
                                       value="${msgIndex.mobile}">
                                <c:if test="${exMsg.mobileEx eq null}">
                                    <span style="color: red;">*</span>
                                </c:if>
                                &nbsp;${exMsg.mobileEx}
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="email">邮箱：</label>
                                <input type="text" class="form-control inputText" id="email" name="email"
                                       value="${msgIndex.email}">
                                <c:if test="${exMsg.emailEx eq null}">
                                    <span style="color: red;">*</span>
                                </c:if>
                                &nbsp;${exMsg.emailEx}
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="input_date">生日：</label>
                                <input type="text" class="form-control inputText" id="input_date" name="birthday"
                                       value="${msgIndex.birthday}"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="identity">身份证：</label>
                                <input type="text" class="form-control inputText" id="identity" name="identity"
                                       value="${msgIndex.identity}">
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="position">所属职位：</label>
                                <select class="form-control" id="position" name="position">
                                    <option value="0">总经理</option>
                                    <option value="1">部门经理</option>
                                    <option value="2">普通职员</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel">头像：</label>
                                <input type="file" name="file" style="display: inline-block;">
                                <img alt="" src="${msgIndex.image}" width="100" height="100">
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="input_date2">入职日期：</label>
                                <input type="text" class="form-control inputText" id="input_date2" name="entrytime"
                                       value="${msgIndex.entrytime}"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="estatus">员工状态：</label>
                                <select class="form-control" id="estatus" name="estatus">
                                    <option value="0">试用期</option>
                                    <option value="1">转正</option>
                                    <option value="2">离职</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary btn" value="提交"
                                       onclick="javascript:location.href='userList.html'"/>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        var method = '${methodUpdate}';
        alert(method);
        if (method != 'update') {
            // 展示用户详情时，文本框禁止编辑
            var texts = $("#userInfoDiv input[type='text']");
            var selects = $("#userInfoDiv select");
            $.each(texts, function () {
                $(this).attr("readonly", true);
            });
            $.each(selects, function () {
                $(this).attr("readonly", true);
            });
            $("input[type='submit']").hide();
        }

    });
    $(function () {
        $("#input_date").datetimepicker({
            bootcssVer: 3,  //bootstrap-datetimepicker＋bootstrap v3，但这个插件使用的时候，并没有和V3相匹配，仍然调用的是bootstrap V2的图标 把bootcssVer的值直接设为3，否则datetimepicker不会显示出上、下个月的箭头
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
    $(function () {
        $("#input_date2").datetimepicker({
            bootcssVer: 3,  //bootstrap-datetimepicker＋bootstrap v3，但这个插件使用的时候，并没有和V3相匹配，仍然调用的是bootstrap V2的图标 把bootcssVer的值直接设为3，否则datetimepicker不会显示出上、下个月的箭头
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
            $("#input_date2").datetimepicker("setEndDate", getToday())
        });
    });

    //獲取當前日期
    function getToday() {
        var today = new Date()
        var year = today.getFullYear();
        var month = today.getMonth() + 1;
        var day = today.getDate();
        var todayStr = year + "-" + month + "-" + day;
        return todayStr;
    }
</script>
</html>