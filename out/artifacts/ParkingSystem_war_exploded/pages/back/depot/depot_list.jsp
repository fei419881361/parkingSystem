<%--
  Created by IntelliJ IDEA.
  User: 41988
  Date: 2018/2/17
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    <jsp:include page="/pages/back/header.jsp"/>

    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <c:if test="${allDepots != null}">
                <table class="table table-border">
                    <tr>
                        <th>所属停车场编号</th>
                        <th>车位总数</th>
                        <th>开发商</th>
                        <th>位置</th>
                        <th>创建日期</th>
                        <th>修改日期</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${allDepots}" var="depot">
                        <tr>
                            <td>${depot.id}</td>
                            <td>${depot.park_num}</td>
                            <td>${depot.developer}</td>
                            <td>${depot.position}</td>
                            <td>${depot.createTime}</td>
                            <td>${depot.updateTime}</td>

                            <td>
                                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal" onclick=Value('${depot.id}','${depot.park_num}','${depot.developer}','${depot.position}') >修改</button>
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
                <form class="form-horizontal" id="insertForm">
                    <div class="form-group">
                        <div class="col-md-6">
                            <input type="hidden" name="id" id="id" class="form-control input-sm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="park_num" class="col-md-3 control-label">车位总数</label>
                        <div class="col-md-6">
                            <input type="text" name="park_num" id="park_num" class="form-control input-sm" onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="developer" class="col-md-3 control-label">开发商</label>
                        <div class="col-md-6">
                            <input type="text" name="developer" id="developer" class="form-control input-sm" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="postion" class="col-md-3 control-label">位置</label>
                        <div class="col-md-6">
                            <textarea name="postion" id="postion" class="form-control"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <%--<button type="button" class="btn btn-default" data-dismiss="modal" >关闭--%>
                <%--</button>--%>
                <button type="button" class="btn btn-primary" onclick="updateInfo()">
                    保存
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<jsp:include page="/pages/back/footer.jsp"/>
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

    function Value(id,park_num,developer,postion) {
        $('#id').val(id);
        $('#park_num').val(park_num);
        $('#developer').val(developer);
        $('#postion').val(postion);
    }
    function updateInfo()
    {
        var xmlhttp;
        var id = $('#id').val();
        var park_num = $('#park_num').val();
        var developer = $('#developer').val();
        var postion  = $('#postion').val();
        var url = "";
        if(park_num==""||developer==""||postion==""){
            alert("填写内容不能为空");
        }else {
            url = "?park_num="+park_num+"&developer="+developer+"&postion="+postion+"&id="+id;
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

        xmlhttp.open("GET","pages/back/depot/DepotServlet/update"+url,true);
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

        xmlhttp.open("GET","pages/back/depot/DepotServlet/delete"+url,true);
        xmlhttp.send();
    }

</script>
</body>
</html>
