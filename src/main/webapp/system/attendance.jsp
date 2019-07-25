<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="ssm" value="${pageContext.request.contextPath}"></c:set>
	<c:set var="sign" value="${pageContext.request.contextPath}/sign"></c:set>
	<c:set var="web" value="${pageContext.request.contextPath}/mavenssm01"></c:set>
	<script type="text/javascript" src="${ssm}/js/user-info.js"></script>
	<link rel="stylesheet" type="text/css" href="${ssm}/bootstrap/css/bootstrap.min.css"/>
	<link href="${ssm}/bootstrap/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
	<script src="${ssm}/js/jquery-2.2.3.min.js"></script>
	<script src="${ssm}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ssm}/bootstrap/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script src="${ssm}/bootstrap/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
	<script src="${ssm}/js/attendance.js"></script>
<title>考勤管理</title>
</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
	<div class="row clearfix">
		<div class="col-md-12 column" style="padding: 20px;">
			<div style="float: left;">
<%--				<c:if test="${isSignIn == 0 }">--%>
					<input type="button" class="btn btn-primary btn" value="签到" onclick="attendSignIn('${sign}')"/>
<%--					<input type="button" class="btn btn-primary btn" value="签到" href="${ssm}/signIn.do"/>--%>
<%--				</c:if>--%>
				<input type="button" class="btn btn-primary btn" value="签退" onclick="atttendSignOut('${sign}')"/>
			</div>
			<form action="${sign}/attendance.do" method="post" id="attendForm" role="form" class="form-inline" style="float: right;margin-bottom: 10px;">
				<div class="form-group" style="margin-right: 20px;">
					 <label for="signIn" style="margin-right: 10px;">签到时间</label>

					<input type="text" class="form-control" id="signIn" name="signIn"
						   placeholder="签到时间，如：2017-01-01" />
				</div>
				<div class="form-group">
					 <label for="signOut" style="margin-right: 10px;">签退时间</label><input type="text" class="form-control" id="signOut" name="signOut" placeholder="签退时间，如：2017-01-02" />
				</div>
				<button type="button" class="btn btn-primary btn" onclick="findAttend()">查询</button>
			</form>
			<table class="table table-bordered" style="margin-top: 20px;">
				<thead>
					<tr>
						<th style="width: 150px;">姓名</th>
						<th>签到时间</th>
						<th>签退时间</th>
						<th>IP</th>
					</tr>
				</thead>
				<tbody>
				    <c:forEach items="${signPage.list}" var="signIndex">
						<tr class="success">
							<td>${signIndex.sname}</td>
							<td>${signIndex.signin}</td>
							<td>${signIndex.signout}</td>
							<td>${signIndex.signip}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<span>共${signPage.totalElm}条记录 共${signPage.totalPage}页 当前第${signPage.pageIndex}页</span>
			<ul class="pagination" style="float: right;margin: 0;">
				<li><a href="${sign}/attendance.do?signIn=${signIn}&signOut=${signOut}" onclick="">首页</a></li>
				<c:if test="${signPage.pageIndex>1}">
					<li class="disabled">
						<a href="${sign}/attendance.do?index=${signPage.pageIndex-1}&signIn=${signIn}&signOut=${signOut}">上一页</a>
					</li>
				</c:if>
				<c:if test="${signPage.pageIndex<signPage.totalPage}">
					<li class="disabled">
						<a href="${sign}/attendance.do?index=${signPage.pageIndex+1}&signIn=${signIn}&signOut=${signOut}">下一页</a>
					</li>
				</c:if>
				<li><a href="${sign}/attendance.do?index=${signPage.totalPage}&signIn=${signIn}&signOut=${signOut}" onclick="">尾页</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">

	$(function () {
		$("#signOut").datetimepicker({
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
		$("#signIn").datetimepicker({
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