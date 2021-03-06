<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mt.model.Store" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>美团</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/layout/layout.css">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index/index.css">
</head>
<body>

<%--header--%>
<%@include file="home/layout/header.jsp" %>

<%--content--%>
<div class="content">
    <ul class="store">
        <c:forEach var="store" items="${ list }" varStatus="status">
        <a href="${ pageContext.request.contextPath }/get/store?id=${ store.getId() }">
            <li>
                <div>
                    <div class="store-img">
                        <img src="${ pageContext.request.contextPath }${ store.getImage() }" alt="">
                    </div>

                    <div class="store-text">
                        <h2>${ store.getName() }</h2>
                        <p>${ store.getLocation() }</p>
                    </div>
                </div>

            </li>
        </a>
        </c:forEach>
    </ul>
</div>

<%--footer--%>
<%@include file="home/layout/footer.jsp"%>

</body>
<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</html>
