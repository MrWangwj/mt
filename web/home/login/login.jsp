<%--
  Created by IntelliJ IDEA.
  User: zhouxiaofei
  Date: 2017/12/21
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>美团-登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login/login.css">
</head>
<body>
    <div class="login_form">
        <form action="/LoginServlet" method="post">
            <div class="form-group">
                <input type="text" name="phone" class="form-control" placeholder="手机号">
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="密码">
            </div>
            <div class="form-group">
                <p class="msg">${msg}</p>
            </div>
            <button type="submit" class="btn btn-info btn-block">登录</button>
        </form>
    </div>
</body>
</html>
