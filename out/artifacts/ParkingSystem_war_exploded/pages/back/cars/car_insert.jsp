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
            <div class="col-md-12">
                <div class="col-md-6 col-md-offset-4">
                    <h1 class="h1">添加注册车辆</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
            <%--编写数据增加表单--%>
                <form action="<%=basePath%>pages/back/cars/CarServlet/insert" method="post" class="form-horizontal" id="insertForm">

                    <div class="form-group">
                        <label for="car_num" class="col-md-3 control-label">车牌号</label>
                        <div class="col-md-6">
                            <input type="text" name="car_num" id="car_num" class="form-control input-sm">
                        </div>
                    </div>

                        <c:if test="${allPark_ids != null}">

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





                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <button type="submit" class="btn btn-success c">提交</button>
                            <button type="reset" class="btn btn-success">重置</button>
                        </div>
                    </div>
                </form>
        </div>
    </div>
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
</body>
</html>
