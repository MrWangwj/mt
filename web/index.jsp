<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mt.model.Store" %><%--
  Created by IntelliJ IDEA.
  User: wangweijin
  Date: 2017/12/20
  Time: 下午10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>美团</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index/index.css">
</head>
<body>
<div>
    <c:forEach var="store" items="${ list }" varStatus="status">
        <div>
            ${ store.getName() }
        </div>
    </c:forEach>
</div>

</body>
<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</html>
