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
            <form action="<%=basePath%>pages/back/parkingLot/ParkingLotServlet/listSplit" method="post" role="form" id="insertForm">
                <div class="form-group">
                    <label for="park_id" class="col-md-3 control-label">停车场ID</label>
                    <div class="col-md-6">
                        <select class="form-control"id="park_id" name="pid">
                            <c:forEach items="${allPark_ids}" var="depot">
                                <c:choose>
                                    <c:when test="${depot.id eq pid}">
                                        <option value="${depot.id}" selected="selected">${depot.id}</option>
                                    </c:when>

                                    <c:otherwise>
                                        <option value="${depot.id}">${depot.id}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-success c">查看</button>
                </div>
            </form>

            <c:if test="${allParkLots != null}">
            <table class="table">
                <tr>
                    <th>车位编号</th>
                    <th>车位位置</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${allParkLots}" var="parkinglot">
                   <tr>
                       <td>${parkinglot.number}</td>
                       <td>${parkinglot.position}</td>
                       <td>
                           <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal" onclick=Value('${parkinglot.id}','${parkinglot.number}','${parkinglot.position}') >修改</button>
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
                <form class="form-horizontal" >
                    <div class="form-group">
                        <div class="col-md-6">
                            <input type="hidden" name="id" id="id" class="form-control input-sm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="number" class="col-md-3 control-label">车位编号</label>
                        <div class="col-md-6">
                            <input type="text" name="number" id="number" class="form-control input-sm" onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="postion" class="col-md-3 control-label">车位位置</label>
                        <div class="col-md-6">
                            <input type="text" name="postion" id="postion" class="form-control input-sm" >
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-primary" onclick="updateInfo()">
                    保存
                </button>
                    <button type="button" class="btn btn-warning" onclick="deleteItem()">
                        删除
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
    function Value(id,number,postion) {
        $('#id').val(id);
        $('#number').val(number);
        $('#postion').val(postion);
    }
    function updateInfo()
    {
        var xmlhttp;
        var id = $('#id').val();number
        var number = $('#number').val();
        var postion  = $('#postion').val();
        var url = "";
        if(number==""||postion==""){
            alert("填写内容不能为空");
        }else {
            url = "?number="+number+"&postion="+postion+"&id="+id;
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

        xmlhttp.open("GET","pages/back/parkingLot/ParkingLotServlet/update"+url,true);
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

        xmlhttp.open("GET","pages/back/parkingLot/ParkingLotServlet/delete"+url,true);
        xmlhttp.send();
    }
</script>
</body>
</html>
