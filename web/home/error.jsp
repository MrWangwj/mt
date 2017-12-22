<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>美团-</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/layout/layout.css">
</head>
<style>
    .content>div{
        width: 200px;
        margin: 0 auto;
    }
</style>
<body>
<%@include file="./layout/header.jsp"%>

<div class="content">
    <div>
        <h3>发生错误</h3>
        <p><a href="#" onClick="javascript :history.go(-1);">点击</a>返回上一级</p>
    </div>
</div>

<%@include file="./layout/footer.jsp"%>
</body>
<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</html>