<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>美团-编辑店铺</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/layout/layout.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/store/edit.css">
</head>
<body>
<%@include file="../layout/header.jsp"%>

<div class="content">
    <div>
        <form class="form-horizontal">

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="name" placeholder="请输入店铺名称" value="${ store.name }">
                </div>
            </div>

            <div class="form-group">
                <label for="location" class="col-sm-2 control-label">地点</label>
                <div class="col-sm-10">
                    <input type="text" name="location" class="form-control" id="location" placeholder="请输入店铺地址" value="${ store.location }">
                </div>
            </div>

            <div class="form-group">
                <label for="phone"  class="col-sm-2 control-label">联系电话</label>
                <div class="col-sm-10">
                    <input type="text" name="phone" class="form-control" id="phone" placeholder="请输入店铺联系电话" value="${ store.phone }">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-default" onclick="saveEdit()">保存修改</button>
                </div>
            </div>

        </form>
    </div>
</div>

<%@include file="../layout/footer.jsp"%>
</body>
<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script>
    function saveEdit(){
        $.post(
            '${ pageContext.request.contextPath }/set/edit/store',
            {
                id: "${ store.id }",
                name: $('#name').val(),
                location: $('#location').val(),
                phone: $('#phone').val(),
            },
            function (data) {
                
            }
        );
    }
</script>
</html>