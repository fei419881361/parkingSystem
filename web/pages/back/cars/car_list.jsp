<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <base href="<%=basePath%>">
    <title>停车管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/basic.css" rel="stylesheet" />
    <link href="assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <jsp:include page="/pages/back/header.jsp"></jsp:include>

    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <c:if test="${allCars != null}">
            <table class="table table-border">
                <tr>
                    <th>编号</th>
                    <th>所属停车场编号</th>
                    <th>车牌</th>
                    <th>车主姓名</th>
                    <th>车主电话</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${allCars}" var="cars">
                   <tr>
                       <td>${cars.id}</td>
                       <td>${cars.park_id}</td>
                       <td>${cars.car_num}</td>
                       <td>${cars.owner_name}</td>
                       <td>${cars.owner_phone}</td>
                       <td>
                           <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal" onclick=Value('${cars.id}','${cars.park_id}','${cars.car_num}','${cars.owner_name}','${cars.owner_phone}') >修改</button>
                       </td>
                   </tr>
                </c:forEach>
            </table>
                <div class="col-md-5 col-md-offset-3">
                    <jsp:include page="/pages/split_bar.jsp"></jsp:include>
                </div>
            </c:if>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改信息
                </h4>
            </div>
            <div class="modal-body">
                <form  class="form-horizontal" id="insertForm">

                    <div class="form-group">
                        <div class="col-md-6">
                            <input type="hidden" name="id" id="id" class="form-control input-sm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="car_num" class="col-md-3 control-label">车牌号</label>
                        <div class="col-md-6">
                            <input type="text" name="car_num" id="car_num" class="form-control input-sm">
                        </div>
                    </div>

                    <c:if test="${allPark_ids != null}">
                        <%--aid--%>
                        <div class="form-group">
                            <label for="park_id" class="col-md-3 control-label">停车场ID</label>
                            <div class="col-md-6">
                                <select class="form-control"id="park_id" name="park_id">
                                    <c:forEach items="${allPark_ids}" var="depot">
                                        <option value="${depot.id}">${depot.id}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </c:if>

                    <div class="form-group">
                        <label for="owner_name" class="col-md-3 control-label">车主姓名</label>
                        <div class="col-md-6">
                            <input type="text" name="owner_name" id="owner_name" class="form-control input-sm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="owner_phone" class="col-md-3 control-label">车主电话</label>
                        <div class="col-md-6">
                            <input type="text" name="owner_phone" id="owner_phone" class="form-control input-sm">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="updateInfo()">
                    保存
                </button>
                <button type="button" class="btn btn-warning" data-dismiss="modal" onclick="deleteItem()" >删除
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<jsp:include page="/pages/back/footer.jsp"></jsp:include>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>

<script type="text/javascript" src="validate/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="validate/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="validate/js/jquery.metadata.js"></script>
<script type="text/javascript" src="validate/js/additional-methods.min.js"></script>
<script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
<script type="text/javascript" src="validate/member_insert.js"></script>
<script>
    $(function () {
        $("tr:even").css("background","#EFEFEF");
    })
    function Value(id,park_id,car_num,owner_name,owner_phone) {
        $('#id').val(id);
        $('#park_id').val(park_id);
        $('#car_num').val(car_num);
        $('#owner_name').val(owner_name);
        $('#owner_phone').val(owner_phone);
    }
    function updateInfo()
    {
        var xmlhttp;
        var id = $('#id').val();
        var park_id = $('#park_id').val();
        var car_num = $('#car_num').val();
        var owner_name  = $('#owner_name').val();
        var owner_phone = $('#owner_phone').val();
        var url = "";
        if(park_id==""||car_num==""||owner_name==""||owner_phone==""){
            alert("填写内容不能为空");
        }else {
            url = "?park_id="+park_id+"&car_num="+car_num+"&owner_name="+owner_name+"&owner_phone="+owner_phone+"&id="+id;
        }

        if (window.XMLHttpRequest)
        {
            //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            // IE6, IE5 浏览器执行代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                alert("修改成功");
                window.location.reload();
            }
        }

        xmlhttp.open("GET","pages/back/cars/CarServlet/update"+url,true);
        xmlhttp.send();
    }

    function deleteItem() {
        var xmlhttp;
        var id = $('#id').val();
        var url = "";

        url = "?id="+id;

        if (window.XMLHttpRequest)
        {
            //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            // IE6, IE5 浏览器执行代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                alert("删除成功");
                window.location.reload();
            }
        }

        xmlhttp.open("GET","pages/back/cars/CarServlet/delete"+url,true);
        xmlhttp.send();
    }
</script>
</body>
</html>
