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
    <title>六合花园小区停车管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="validate/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="validate/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="validate/js/jquery.metadata.js"></script>
    <script type="text/javascript" src="validate/js/additional-methods.min.js"></script>
    <script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
    <script type="text/javascript" src="validate/login.js"></script>
</head>
<body style="background-color: #E2E2E2;">
<div class="container">
    <div class="row text-center " style="padding-top:100px;">
        <div class="col-md-12">
            <h2>六合花园小区停车管理系统</h2>
        </div>
    </div>
    <div class="row ">

        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

            <div class="panel-body">
                <form id="loginForm" role="form" action="<%=basePath%>pages/back/AdminServlet/login" method="post">
                    <hr />
                    <h5>Enter Details to Login</h5>
                    <br />
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-user"  ></i></span>
                        <input type="text" class="form-control" id="account" name="account" value="admin" placeholder="Your Username " />
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                        <input type="password" class="form-control" id="pwd" name="pwd" value=""  placeholder="Your Password" />
                    </div>
                    <div class="form-group input-group">
                        <button type="submit" class="btn btn-primary ">管理员登录</button>
                    </div>
                    <hr />
                    忘记密码 ? <a href="#" >点击这里 </a> 或者联系QQ： <a href="#">419881361</a>
                </form>
            </div>

        </div>
    </div>
</div>

</body>
</html>
