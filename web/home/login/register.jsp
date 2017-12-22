
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>美团-注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login/register.css">
</head>
<body>
<div class="register_form">
    <form>
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" name="name" id="name" class="form-control">
        </div>
        <div class="form-group">
            <label for="sex">性别</label>
            <select name="sex" id="sex" class="form-control">
                <option>男</option>
                <option>女</option>
            </select>
        </div>
        <div class="form-group">
            <label for="phone">手机号</label>
            <input type="text" name="phone" id="phone" class="form-control">
        </div>
        <div class="form-group">
            <label for="phone">邮箱</label>
            <input type="text" name="email" id="email" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" name="password" id="password" class="form-control">
        </div>
        <div class="form-group">
            <label for="rePassword">确认密码</label>
            <input type="password" name="rePassword" id="rePassword" class="form-control">
        </div>
        <button type="button" class="btn btn-info btn-block" data-toggle="modal" data-target=".bs-example-modal-sm">注册</button>
    </form>

    <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">注册确认</h4>
                </div>
                <div class="modal-body">
                    <p>注册信息一旦提交，将无法修改，确认提交吗？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-info" id="register">确认提交</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $("#register").click(function () {
            var name = $("#name").val().trim();
            var sex = $("#sex").val();
            var phone = $("#phone").val().trim();
            var email = $("#email").val().trim();
            var password = $("#password").val().trim();
            var rePassword = $("#rePassword").val().trim();

            var reg_name = /^[\u4E00-\u9FA5]{1,10}$/;
            var reg_phone = /^1[3|5|7|8]\d{9}$/;
            var reg_email = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
            var reg_password = /^[a-zA-Z0-9]{6,16}$/;

            if (!reg_name.test(name)) {
                alert("姓名格式不正确");
                return;
            } else if (!reg_phone.test(phone)) {
                alert("手机号格式不正确");
                return;
            } else if (!reg_email.test(email)) {
                alert("邮箱格式不正确");
                return;
            } else if (!reg_password.test(password)) {
                alert("密码格式不正确");
                return;
            } else if (password !== rePassword) {
                alert("两次密码输入不一致");
                return;
            } else {
                var _url = "/RegisterServlet";
                var _params = {
                    "name": name,
                    "sex": sex,
                    "phone": phone,
                    "email": email,
                    "password": password
                };
                $.post(_url, _params, function (code) {
                    if (code != null ) {
                        alert("注册成功");
                        setTimeout((
                            window.location = "/home/login/login.jsp"
                        ),2000);
                    } else {
                        alert("注册失败，请检查后重新注册");
                    }
                });
            }
        });
    });
</script>
</html>
