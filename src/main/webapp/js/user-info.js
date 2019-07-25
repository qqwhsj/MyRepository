/**
 * 添加用户
 * @returns {Boolean}
 */
function userAdd() {

    return dateVerify();
}

/**
 * 修改用户信息
 * @returns {Boolean}
 */
function userUpdate() {

    return dateVerify();
}

/**
 * 删除用户信息
 * @param path 路径前缀
 * @param id
 */
function userDel(mid) {
    if (!confirm("确定删除吗")) {
        return;
    }
    $.ajax({
        url: "/mavenssm01/deleteUser.do",
        type: "POST",
        data: {mid: mid},
        dataType: "json",
        success: function (data) {
            var result = "";
            alert(data.list.length)
            for (var i = 0; i < data.list.length; i++) {
                result +="<tr class='success'>"
                result += "<td>" + data.list[i].mname + "</td>";
                result += "<td>" + data.list[i].age + "</td>";
                var sex = "";
                if (data.list[i].sex == 0) {
                    sex = "男";
                } else if (data.list[i].sex == 1) {
                    sex = "女";
                } else if (data.list[i].sex == 2) {
                    sex = "未知性别";
                }
                result += "<td>" + sex + "</td>";
                result += "<td>" + data.list[i].mobile + "</td>";
                result += "<td>" + data.list[i].email + "</td>";
                result += "<td>" + data.list[i].birthday + "</td>";
                result += "<td>" + data.list[i].entrytime + "</td>";
                var estatus = "";
                if (data.list[i].estatus == 0) {
                    estatus = "总经理";
                } else if (data.list[i].estatus == 1) {
                    estatus = "部门经理";
                } else if (data.list[i].estatus == 2) {
                    estatus = "普通职员";
                }
                result += "<td>" +estatus + "</td>";
                result+="<td>\n" +
                    " <a href=\"${ssm}/userInfo.do?mid="+data.list[i].mid+"\" class=\"btn btn-primary btn\">详情</a>\n" +
                    " <a href=\"${web}/userInfoUpdate.do?method=update&mid="+data.list[i].mid+" class=\"btn btn-primary btn\">修改</a>\n" +
                    " <a href=\"javascript:void(0);\" onclick=\"userDel('"+data.list[i].mid+"')\" class=\"btn btn-primary btn\">删除</a>\n" +
                    " </td>";
                result+="</tr>";
                //分页下标

            }
            $("tbody").html(result);
        }, error: function (data) {
            alert("系统错误，请联系管理员");
            alert(data);
        }
    });
}


/**
 * 验证用户信息
 * @returns {Boolean}
 */
function dateVerify() {
    var account = $("#account").val();
    var realName = $("#realName").val();
    var age = $("#age").val();
    var mobile = $("#mobile").val();
    var email = $("#email").val();
    var birthday = $("#birthday").val();
    var identity = $("#identity").val();
    var entryTime = $("#entryTime").val();

    if (account == '') {
        alert("帐号不允许为空！");
        return false;
    }
    if (realName == '') {
        alert("姓名不允许为空！");
        return false;
    }
    if (age == '') {
        alert("年龄不允许为空！");
        return false;
    }
    var numberVer = /^\+?[1-9][0-9]*$/;
    if (!numberVer.test(age)) {
        alert("年龄必须为非零正整数");
        return false;
    }
    var mobileVer = /^((1[3|4|5|7|8][0-9]{1})+\d{8})$/;
    if (mobile != '') {
        if (!mobileVer.test(mobile)) {
            alert("请输入正确的手机号！");
            return false;
        }
    }
    var emailVer = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    if (email != '') {
        if (!emailVer.test(email)) {
            alert("请输入正确的邮箱！");
            return false;
        }
    }
    var birthdayVer = /^((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))$/;
    if (birthday != '' && !birthdayVer.test(birthday)) {
        alert("请输入正确的生日格式");
        return false;
    }
    var identityVer = /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i;
    if (identity != '' && !identityVer.test(identity)) {
        alert("请输入正确的身份证号！");
        return false;
    }
    if (entryTime != '') {
        var date_ymd = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
        if (!date_ymd.test(entryTime)) {
            alert("请输入正确的入职日期格式！");
            return false;
        }
    }

    return true;
}