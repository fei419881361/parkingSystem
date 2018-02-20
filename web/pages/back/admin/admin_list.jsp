<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <base href="<%=basePath%>">
    <title>停车管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet"/>
    <link href="assets/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/css/basic.css" rel="stylesheet"/>
    <link href="assets/css/custom.css" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
</head>
<body>
<div id="wrapper">
    <jsp:include page="/pages/back/header.jsp"></jsp:include>

    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <c:if test="${adminList != null}">
                <table class="table table-border">
                    <tr>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>电话</th>
                        <th>入职时间</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${adminList}" var="admin">
                        <tr>
                            <td>${admin.id}</td>
                            <td>${admin.name}</td>
                            <td>${admin.age}</td>
                            <c:choose>
                                <c:when test="${admin.sex==1}">
                                    <td>男</td>
                                </c:when>
                                <c:otherwise>
                                    <td>女</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${admin.phoneNumber}</td>
                            <td>${admin.work_time}</td>
                            <td>
                                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal" onclick=Value('${admin.id}','${admin.name}','${admin.age}','${admin.phoneNumber}','${admin.work_time}') >修改</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="col-md-5 col-md-offset-5">
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
                        <label for="name" class="col-md-3 control-label">姓名</label>
                        <div class="col-md-6">
                            <input type="number" name="name" id="name" class="form-control input-sm">
                        </div>
                    </div>
                    <%--性别--%>
                    <div class="form-group">
                        <label for="age" class="col-md-3 control-label">年龄</label>
                        <div class="col-md-6">
                            <input type="text" name="age" id="age" class="form-control input-sm">
                        </div>
                    </div>



                    <!--性别-->
                    <div class="form-group">
                        <label for="sex" class="col-md-3 control-label">性别</label>
                        <div class="radio">
                            <div class="col-md-2 col-md-offset-1">
                                <input type="radio" name="sex" id="sex" value="1" checked >男
                            </div>
                            <div class="col-md-1">
                                <input type="radio" name="sex" id="sex2"  value="2">女
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="work_time" class="col-md-3 control-label">工作时间</label>
                        <div class="col-md-6">
                            <input type="date" name="work_time" id="work_time" maxlength="10" class="form-control input-sm">
                        </div>
                    </div>

                    <!--联系电话-->
                    <div class="form-group">
                        <label for="phoneNumber" class="col-md-3 control-label">联系电话</label>
                        <div class="col-md-6">
                            <input type="text" name="phoneNumber" id="phoneNumber" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userName" class="col-md-3 control-label">账号</label>
                        <div class="col-md-6">
                            <input type="text" name="userName" id="userName" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="col-md-3 control-label">密码</label>
                        <div class="col-md-6">
                            <input type="password" name="password" id="password" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <button type="submit" class="btn btn-success c">提交</button>
                            <button type="reset" class="btn btn-success">重置</button>
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
    <script>
    $(function () {
        $("tr:even").css("background","#EFEFEF");
    })
    function Value(id,name,age,phone,work_time) {
        $('#id').val(id);
        $('#name').val(name);
        $('#age').val(age);
        $('#phoneNumber').val(phone);
        $('#work_time').val(work_time);
    }
    function updateInfo()
    {
        var xmlhttp;
        var id = $('#id').val();
        var name = $('#name').val();
        var age  = $('#age').val();
        var phone  = $('#phoneNumber').val();
        var work_time  = $('#work_time').val();
        var sex  = $('#sex').val();
        var url = "";
        if(name==""||age==""||phone==""||work_time==""||sex==""){
            alert("填写内容不能为空");
        }else {
            url = "?name="+name+"&age="+age+"&phone="+phone+"&work_time="+work_time+"&sex="+sex+"&id="+id;
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

        xmlhttp.open("GET","pages/back/admin/AdminServlet/update"+url,true);
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

        xmlhttp.open("GET","pages/back/admin/AdminServlet/delete"+url,true);
        xmlhttp.send();
    }

</script>
</body>
</html>
