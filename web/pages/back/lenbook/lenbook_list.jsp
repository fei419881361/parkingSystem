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
    <title>IFOX书管理系统</title>
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
            <c:if test="${allLenbooks != null}">
            <table class="table table-border">
                <tr>
                    <th>编号</th>
                    <th>图书名称</th>
                    <th>真实姓名</th>
                    <th>创建日期</th>
                    <th>是否归还</th>
                    <th>归还日期</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${allLenbooks}" var="len">
                   <tr>
                       <td>${len.leid}</td>
                       <td>${len.books.name}</td>
                       <td>${len.member.name}</td>
                       <td>${len.credate}</td>
                       <td>
                           <c:if test="${len.retdate != null}">
                               已经归还
                           </c:if>
                           <c:if test="${len.retdate == null}">
                               还未归还
                           </c:if>
                       </td>
                       <td>${len.retdate}</td>
                       <td>
                           <c:if test="${len.retdate == null}">
                               <a href="<%=request.getContextPath()%>/pages/back/lenbook/LenbookServlet/updateByRetdate?leid=${len.leid}&bid=${len.books.bid}">归还图书</a>
                           </c:if>
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
</script>
</body>
</html>
