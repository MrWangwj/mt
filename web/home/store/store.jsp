
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>美团-</title>
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

    <h3>参团产品</h3>
    <div class="goods">
        <div class="good">
            <div class="good-image">
                <img src="" alt="">
            </div>

            <div class="good-text">
                <h4>单人套餐</h4>
                <p>￥<span>123123</span></p>
            </div>

            <div class="good-but">
                <button>立即抢购</button>
            </div>
        </div>
    </div>
</div>

<%@include file="../layout/footer.jsp"%>
</body>
<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</html>
