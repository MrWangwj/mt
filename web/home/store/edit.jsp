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
            <input type="hidden" name="id" value="${ store.id }">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="name" placeholder="请输入店铺名称" value="${ store.name }">
                </div>
            </div>

            <div class="form-group">
                <label for="image" class="col-sm-2 control-label">展示图片</label>
                <div class="col-sm-10">
                    <input type="file" id="image" >
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


        $.ajaxFileUpload({
            url:"上传控制器URL", //这里是关键，这里地址必须和必须和本地地址一样，不然违反同源策略，  这样写的url:"http://www.baidu.com/mobilechat"是不行的。如果确实需要跨域提交，需要加一个中间层。 也可以用jsonp
            data:data,    //参数这里不能这样写$('.registerform').serialize(), 因为我传递的是JSON格式的数据。$('#form1').serialize()传递的参数不是这样的格式。
            fileElementId:'file', //文件选择框的id属性
            dataType: 'json',   //服务器返回的格式，可以是json ,也可以是jsonp
            success:function(data,msg){
                //dosomething------ 成功处理代码
            },
            error:function(data){
                //dosomething------ 错误处理代码
            }
        })
    }
</script>
</html>