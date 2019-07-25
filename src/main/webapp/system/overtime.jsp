<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:set var="ssm" value="${pageContext.request.contextPath}"></c:set>
    <c:set var="sign" value="${pageContext.request.contextPath}/sign"></c:set>
    <c:set var="web" value="${pageContext.request.contextPath}/mavenssm01"></c:set>
<link rel="stylesheet" href="${ssm}/bootstrap/css/bootstrap.min.css" />
<title>加班管理</title>
<script type="text/javascript">
    //条件查询
    function findOver(){
	    var realName = $("#realName").val();
	    $("#userForm").submit();
	}
    //分页查询
    function overPage(page,oname){
    	window.location.href="/mavenssm01/sign/overtime.do?index="+page+"&oname="+oname;

    }
</script>
</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;">
            <div style="float: left;">
                 <input type="button" class="btn btn-primary btn" value="添加" onclick="overtimeHTML()"/>
            </div>
            <form action="#" method="post" id="overForm" role="form" class="form-inline" style="float: right;margin-bottom: 10px;">
                <div class="form-group" style="margin-right: 20px;">
                     <label for="exampleInputEmail1" style="margin-right: 10px;">姓名</label><input type="text" class="form-control" id="realName" name="realName" placeholder="姓名"/>
                </div>
                <input type="hidden" id="pageNo" name="offset" value="${page.pageNo}">
                <button type="button" class="btn btn-primary btn" onclick="findOver()">查询</button>
            </form>
            <table class="table table-bordered" style="margin-top: 20px;">
                <thead>
                    <tr>
                        <th style="display:none">ID</th>
                        <th>姓名</th>
                        <th>申请时间</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>加班时长</th>
                        <th>描述</th>
                        <th>审批状态</th>
                        <th style="width: 150px;">操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${overPage.list}" var="overIndex">
                    <tr class="success">
                        <td style="display:none"></td>
                        <td>${overIndex.oname}</td>
                        <td>${overIndex.submittime}</td>
                        <td>${overIndex.otbegin}</td>
                        <td>${overIndex.otover}</td>
                        <td>${overIndex.duration}</td>
                        <td>${overIndex.discription}</td>
                        <td>
                            <c:if test="${overIndex.isratify==1}">
                                已审批
                            </c:if>
                            <c:if test="${overIndex.isratify==0}">
                                未审批
                            </c:if>

                        </td>
                        <td>
                            <a href="#" class="btn btn-primary btn" onclick="overtimeHTML()">修改</a>
                            <a href="#" class="btn btn-primary btn" onclick="operation()">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <span>共${overPage.totalElm}条记录 共${overPage.totalPage}页 当前第${overPage.pageIndex}页</span>
            <!-- 分页 -->
            <ul class="pagination" style="float: right;margin: 0;">
                <li><a href="javascript:void(0)" onclick="overPage(1,'${oname}')">首页</a></li>
                <c:if test="${overPage.pageIndex>1}">
                    <li><a href="javascript:void(0)" onclick="overPage('${overPage.pageIndex-1}','${oname}')">上一页</a></li>
                </c:if>
                <c:if test="${overPage.pageIndex}<${overPage.totalPage}">
                    <li><a href="javascript:void(0)" onclick="overPage('${overPage.pageIndex+1}','${oname}')">下一页</a></li>
                </c:if>
                <li><a href="javascript:void(0)" onclick="overPage('${overPage.totalPage}','${oname}')">尾页</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${ssm}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${ssm}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ssm}/js/overtime.js"></script>
</html>