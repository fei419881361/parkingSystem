<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
            <span class="sr-only">停车场管理系统</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="./index.jsp">停车场管理系统</a>
    </div>
    <!--顶部-->
    <div class="header-right">
        <a href="pages/back/AdminServlet/logout" class="btn btn-danger" title="Logout"> 退出系统</a>
    </div>
</nav>
<!-- 导航 -->
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li>
                <div class="user-img-div">
                    <img src="../../assets/img/park.png" class="img-thumbnail" />

                    <div class="inner-text">
                        管理员: <c:if test="${account != null}">
                        ${account}
                    </c:if>
                    </div>
                </div>
            </li>

            <li>
                <a class="active-menu" href="#"><i class="fa fa-dashboard "></i>导航</a>
            </li>
            
            <!--管理员维护-->
            <li>
                <a href="./index.jsp"><i class="fa fa-desktop "></i>管理员信息 <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="./member/member_insert.jsp"><i class="fa fa-toggle-on"></i>录入管理员</a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" id="userlist" onclick="check()"><i class="fa fa-toggle-on"></i>管理员列表</a>
                    </li>
                </ul>
            </li>
            <!--停车场信息-->
            <li>
                <a href="./index.jsp"><i class="fa fa-yelp "></i>停车场管理 <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="pages/back/depot/DepotServlet/insertPro"><i class="fa fa-coffee"></i>增加停车场</a>
                    </li>
                    <li>
                        <a href="pages/back/depot/DepotServlet/listSplit"><i class="fa fa-flash "></i>停车场列表</a>
                    </li>
                </ul>
            </li>
            <!--已登记车辆信息-->
            <li>
                <a href="/pages/back/index.jsp"><i class="fa fa-yelp "></i>车辆管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="pages/back/cars/CarServlet/insertPro"><i class="fa fa-coffee"></i>增加登记车辆</a>
                    </li>
                    <li>
                        <a href="pages/back/cars/CarServlet/listSplit"><i class="fa fa-flash "></i>登记车辆列表</a>
                    </li>
                </ul>
            </li>
            <!--车位管理-->
            <li>
                <a href="/pages/back/index.jsp"><i class="fa fa-yelp "></i>车位管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="pages/back/parkingLot/ParkingLotServlet/insertPro"><i class="fa fa-coffee"></i>增加车位</a>
                    </li>
                    <li>
                        <a href="pages/back/parkingLot/ParkingLotServlet/listSplit"><i class="fa fa-flash "></i>车位详情</a>
                    </li>
                </ul>
            </li>
            <!--收费管理-->
            <li>
                <a href="./index.jsp"><i class="fa fa-bicycle "></i>收费管理 <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="pages/back/lenbook/LenbookServlet/insertPro"><i class="fa fa-desktop "></i>收费登记 </a>
                    </li>
                    <li>
                        <a href="pages/back/lenbook/LenbookServlet/listSplit"><i class="fa fa-desktop "></i>收费详情 </a>
                    </li>
                </ul>
            </li>
            <!--车位保养管理-->
            <li>
                <a href="./index.jsp"><i class="fa fa-bicycle "></i>车位保养管理 <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="pages/back/maintain/MaintainServlet/insertPro"><i class="fa fa-desktop "></i>保养登记 </a>
                    </li>
                    <li>
                        <a href="pages/back/maintain/MaintainServlet/maintainInfo"><i class="fa fa-desktop "></i>保养记录 </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<script>

</script>
