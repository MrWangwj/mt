<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>美团-店铺详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/layout/layout.css">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/store/store.css">
</head>
<body>
<%@include file="../layout/header.jsp"%>

<div class="content">
    <div class="store">
        <div class="store-text">
            <div class="store-name">
                <h1>${ store.getName() }</h1>
                <p>
                    <a href="${ pageContext.request.contextPath }/edit/store?id=${ store.id }">编辑</a>
                    |
                    <a href="">删除</a>
                </p>
            </div>
            <div class="store-location">
                <p>地址：${ store.getLocation() }</p>
                <p>电话：${ store.getPhone() }</p>
            </div>
        </div>

        <div class="store-image">
            <img src="${ pageContext.request.contextPath }${ store.getImage() }" alt="">
        </div>
    </div>
    <div class="test">
        <h3>参团产品</h3>
        <button type="button" class="btn btn-success">添加产品</button>
    </div>

    <div class="goods">
        <c:forEach var="good" items="${ goods }" varStatus="status">
            <div class="good">
                <div>
                    <div class="good-image">
                        <img src="${ pageContext.request.contextPath }${ good.image }" alt="">
                    </div>

                    <div class="good-text">
                        <div>
                            <h4>${ good.name }</h4>
                            <p>
                                <a href="">删除</a>
                                |
                                <a href="">编辑</a>
                            </p>
                        </div>
                        <p>￥<span>${ good.price }</span></p>
                    </div>

                    <div class="good-but">
                        <button type="button" class="btn btn-warning">立即抢购+</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@include file="../layout/footer.jsp"%>
</body>
<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</html>
