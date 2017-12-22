<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>美团-添加店铺</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/layout/layout.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/store/edit.css">
</head>
<body>
<%@include file="../layout/header.jsp"%>

<div class="content">
    <div>
        <form action="${ pageContext.request.contextPath }/add/store" class="form-horizontal" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="name" placeholder="请输入店铺名称">
                </div>
            </div>

            <div class="form-group">
                <label for="image" class="col-sm-2 control-label">展示图片</label>
                <div class="col-sm-10">
                    <input type="file" id="image" name="image">
                </div>
            </div>

            <div class="form-group">
                <label for="location" class="col-sm-2 control-label">地点</label>
                <div class="col-sm-10">
                    <input type="text" name="location" class="form-control" id="location" placeholder="请输入店铺地址">
                </div>
            </div>

            <div class="form-group">
                <label for="phone"  class="col-sm-2 control-label">联系电话</label>
                <div class="col-sm-10">
                    <input type="text" name="phone" class="form-control" id="phone" placeholder="请输入店铺联系电话">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">添加</button>
                </div>
            </div>

        </form>
    </div>


</div>

<%@include file="../layout/footer.jsp"%>
</body>
<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script src="${ pageContext.request.contextPath }/js/ajaxfileupload.js"></script>
</html>