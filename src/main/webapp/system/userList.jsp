<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:set var="ssm" value="${pageContext.request.contextPath}"/>
    <c:set var="web" value="${pageContext.request.contextPath}/system"/>
    <link rel="stylesheet" href="${ssm}/bootstrap/css/bootstrap.min.css"/>
    <title>用户列表</title>
    <script type="text/javascript">
        // 条件查询
        function findUser() {
            var realName = $("#realName").val();
            var age = $("#age").val();
            var nz_number = /^\+?[1-9][0-9]*$/;
            if (age != '' && !nz_number.test(age)) {
                alert("年龄必须为非零正整数");
                return;
            }
            $("#userForm").submit();
        }

        // 分页查询
        function userPage(page) {
            $("#pageNo").val(page);
            findUser();
        }
    </script>
</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;">
            <div style="float: left;">
                <a href="${web}/addUser.jsp" class="btn btn-primary btn">添加</a>
            </div>
            <form action="${ssm}/userList.do" method="post" id="userForm" role="form" class="form-inline"
                  style="float: right;margin-bottom: 10px;">
                <div class="form-group" style="margin-right: 20px;">
                    <label for="newMname" style="margin-right: 10px;">姓名</label><input type="text"
                                                                                    class="form-control"
                                                                                                 id="newMname"
                                                                                                 name="newMname"
                                                                                                 placeholder="姓名"/>
                </div>
                <div class="form-group">
                    <label for="newAge" style="margin-right: 10px;">年龄</label><input type="text"
                                                                                                    class="form-control"
                                                                                                    id="newAge" name="newAge"
                                                                                                    placeholder="年龄"/>
                </div>
<%--                <input type="hidden" id="pageNo" name="offset" value="">--%>
                <button type="submit" class="btn btn-primary btn" onclick="">查询</button>
<%--                findUser()--%>
            </form>
            <table class="table table-bordered" style="margin-top: 20px;">
                <thead>
                <tr>
                    <th>用户名</th>
                    <th style="width: 100px;">年龄</th>
                    <th style="width: 100px;">性别</th>
                    <th>手机号</th>
                    <th>邮箱</th>
                    <th>生日</th>
                    <th>入职日期</th>
                    <th style="width: 100px;">状态</th>
                    <th style="width: 200px;">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${msgPage.list}" var="elmIndex">
                    <tr class="success">
                        <td><c:out value="${elmIndex.mname}"/></td>
                        <td><c:out value="${elmIndex.age}"/></td>
                        <td><c:choose>
                            <c:when test="${elmIndex.sex==0}">
                                男
                            </c:when>
                            <c:when test="${elmIndex.sex==1}">
                                女
                            </c:when>
                            <c:when test="${elmIndex.sex==2}">
                                未知性别
                            </c:when>
                        </c:choose></td>
                        <td><c:out value="${elmIndex.mobile}"/></td>
                        <td><c:out value="${elmIndex.email}"/></td>
                        <td><c:out value="${elmIndex.birthday}"/></td>
                        <td><c:out value="${elmIndex.entrytime}"/></td>
                        <td><c:choose>
                            <c:when test="${elmIndex.estatus==0}">
                                总经理
                            </c:when>
                            <c:when test="${elmIndex.estatus==1}">
                                部门经理
                            </c:when>
                            <c:when test="${elmIndex.estatus==2}">
                                普通职员
                            </c:when>
                        </c:choose></td>
                        <td>
                            <a href="${ssm}/userInfo.do?mid=${elmIndex.mid}" class="btn btn-primary btn">详情</a>
                            <a href="${ssm}/userInfoUpdate.do?mid=${elmIndex.mid}" class="btn btn-primary btn">修改</a>
                            <a href="javascript:void(0);" onclick="userDel('${elmIndex.mid}')" class="btn btn-primary btn">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <span>${msgPage.totalElm}条记录 共${msgPage.totalPage}页 当前第${msgPage.pageIndex}页</span>
            <!-- 分页 -->
            <ul class="pagination" style="float: right;margin: 0;">
                <li><a href="javascript:location.href='/mavenssm01/userList.do?newMname=${newMname}&newAge=${newAge}'" onclick="">首页</a></li>
                <c:if test="${msgPage.pageIndex>1}">
                    <li class="disabled">
                        <a href="<c:url value='/userList.do?index=${msgPage.pageIndex-1}&newMname=${newMname}&newAge=${newAge}'/>">上一页</a>
                    </li>
                </c:if>
                <c:if test="${msgPage.pageIndex<msgPage.totalPage}">
                    <li class="disabled">
                        <a href="${ssm}/userList.do?index=${msgPage.pageIndex+1}&newMname=${newMname}&newAge=${newAge}">下一页</a>
                    </li>
                </c:if>
                <li><a href="${ssm}/userList.do?index=${msgPage.totalPage}&newMname=${newMname}&newAge=${newAge}" onclick="">尾页</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${ssm}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${ssm}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ssm}/js/user-info.js"></script>
</html>