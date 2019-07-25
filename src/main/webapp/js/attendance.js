// 条件查询
function findAttend() {
	var reg = /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/;

	var signInStr = $("#signIn").val();
	var signOutStr = $("#signOut").val();
	if (signInStr != '' && !reg.test(signInStr)) {
		alert("输入的签到时期格式有误，正确格式为：YYYY-MM-DD");
		return;
	}
	if (signOutStr != '' && !reg.test(signOutStr)) {
		alert("输入的签退时期格式有误，正确格式为：YYYY-MM-DD");
		return;
	}
	if (signInStr != '' && signOutStr != '') {
		// 部分火狐浏览器不兼容 YYYY-MM-DD格式
		signInStr = signInStr.replace(/-/g,"/");
		signOutStr = signOutStr.replace(/-/g,"/");
		var signIn = new Date(signInStr);
		var signOut = new Date(signOutStr);
		if (signIn.getTime() > signOut.getTime()) {
			alert("签退日期不能早于签到日期");
			return;
		}
	}
	
	$("#attendForm").submit();
}

// 分页查询
function attendPage(page) {
	$("#pageNo").val(page);
	findAttend();
}

/**
 * 签到
 * @param path
 */
function attendSignIn(path) {
    // alert("path");
	$.ajax({
		url:  path+"/signIn.do",
		type: "POST",
		dataType: "json",
		success: function(data) {
			if (data == '2') {
				alert("签到失败！");
			} else if (data == '0') {
				alert("用户今日已签到");
			} else {
				alert("签到成功！");
				window.location.href = path + "/attendance.do";
			}
		}, error: function(data) {
			alert(path);
		}
	});
}

/**
 * 签退
 * @param path
 */
function atttendSignOut(path) {
	$.ajax({
		url: path + "/signOut.do",
		type: "POST",
		dateType: "json",
		success: function(data) {
			if (data == 2) {
				alert("用户今日已签退！");
			} else if (data == 0) {
				alert("请先完成签到！");
			} else if (data ==1) {
				alert("签退成功！");
				window.location.href = path + "/attendance.do";
			}else if (data==3){
                alert("请使用签到电脑签退！");
			}else{
				alert("签退失败")
			}
		}, error: function(data) {
			alert("系统错误，请联系管理员！");
		}
	});
}