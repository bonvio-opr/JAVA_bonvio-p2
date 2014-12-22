<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 18.12.2014
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>











<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>bonvio-groups</title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimal-ui" />
    <meta name="apple-mobile-web-app-status-bar-style" content="yes" />
    <%--<link rel="shortcut icon" href="/favicon.png" type="image/x-icon" />--%>
    <link rel="stylesheet" href="/CM/resources/workspace/bonvio-groups/www/css/app.min.css" />
    <link rel="stylesheet" href="/CM/resources/workspace/bonvio-groups/www/css/responsive.min.css" />
    <%--<script src="http://localhost:8001/target/target-script-min.js"></script>--%>
    <script src="/CM/resources/workspace/bonvio-groups/www/js/app.min.js"></script>
</head>
<body ng-app="BonvioGroups" ng-controller="MainController">

<!-- Sidebars -->
    <div ng-include="'sidebar.html'"
     ui-track-as-search-param='true'
     class="sidebar sidebar-left"></div>

<%--
    <div ng-include="'sidebarRight.html'"
     class="sidebar sidebar-right"></div>
--%>

<div class="app" ng-swipe-right='Ui.turnOn("uiSidebarLeft")' ng-swipe-left='Ui.turnOff("uiSidebarLeft")'>

    <!-- Navbars -->

    <div class="navbar navbar-app navbar-absolute-top">
        <div class="navbar-brand navbar-brand-center" ui-yield-to="title">
            Mobile Angular UI
        </div>
        <div class="btn-group pull-left">
            <div ui-toggle="uiSidebarLeft" class="btn sidebar-toggle">
                <i class="fa fa-bars"></i> Menu
            </div>
        </div>
        <%--
        <div class="btn-group pull-right" ui-yield-to="navbarAction">
            <div ui-toggle="uiSidebarRight" class="btn">
                <i class="fa fa-comment"></i> Chat
            </div>
        </div>
        --%>
    </div>

    <div class="navbar navbar-app navbar-absolute-bottom">
        <div class="btn-group justified">
            <a href="#" class="btn btn-navbar"><i class="fa fa-plus-square"></i> Добавить группу</a>
        </div>
    </div>

    <!-- App Body -->
    <div class="app-body" ng-class="{loading: loading}">
        <div ng-show="loading" class="app-content-loading">
            <i class="fa fa-spinner fa-spin loading-spinner"></i>
        </div>
        <div class="app-content">
            <ng-view></ng-view>
        </div>
    </div>

</div><!-- ~ .app -->

<div ui-yield-to="modals"></div>
</body>
</html>



















<%--<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>bonvio-groups</title>

    &lt;%&ndash;/CM/resources/&ndash;%&gt;

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimal-ui" />
    <meta name="apple-mobile-web-app-status-bar-style" content="yes" />
    &lt;%&ndash;<link rel="shortcut icon" href="/favicon.png" type="image/x-icon" />&ndash;%&gt;

    <link rel="stylesheet" href="/CM/resources/workspace/group/bower_components/mobile-angular-ui/dist/css/mobile-angular-ui-base.min.css" />
    <link rel="stylesheet" href="/CM/resources/workspace/group/bower_components/mobile-angular-ui/dist/css/mobile-angular-ui-desktop.min.css" />
    <link rel="stylesheet" href="/CM/resources/workspace/group/bower_components/mobile-angular-ui/dist/css/mobile-angular-ui-hover.min.css" />

    <link rel="stylesheet" href="/CM/resources/workspace/group/bower_components/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" href="/CM/resources/workspace/group/bower_components/bootstrap/dist/css/bootstrap-theme.min.css" />

    <link href="/CM/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <script src="/CM/resources/workspace/group/bower_components/angular/angular.min.js"></script>
    <script src="/CM/resources/workspace/group/bower_components/angular-route/angular-route.min.js"></script>

    <script src="/CM/resources/workspace/group/bower_components/angular-ui-bootstrap/dist/ui-bootstrap-custom-0.12.0.min.js"></script>
    <script src="/CM/resources/workspace/group/bower_components/angular-ui-bootstrap/dist/ui-bootstrap-custom-tpls-0.12.0.min.js"></script>

    <script src="/CM/resources/workspace/group/bower_components/jquery/dist/jquery.js"></script>

    <script src="/CM/resources/workspace/group/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <script src="/CM/resources/workspace/group/bower_components/mobile-angular-ui/dist/js/mobile-angular-ui.min.js"></script>

    <script src="/CM/resources/workspace/group/bower_components/angular/angular.min.js"></script>


    <script src="/CM/resources/workspace/group/src/js/app.js"></script>
    <script src="/CM/resources/workspace/group/src/js/controllers/main_controller.js"></script>
    <script src="/CM/resources/workspace/group/src/js/controllers/home_controller.js"></script>

</head>
<body ng-app="BonvioGroups" ng-controller="MainController">

<!-- Sidebars -->
<div ng-include="'/CM/resources/workspace/group/src/templates/sidebar.html'"
     ui-track-as-search-param='true'
     class="sidebar sidebar-left"></div>

<!--<div ng-include="'sidebarRight.html'"
     class="sidebar sidebar-right"></div>-->

<div class="app" ng-swipe-right='Ui.turnOn("uiSidebarLeft")' ng-swipe-left='Ui.turnOff("uiSidebarLeft")'>

    <!-- Navbars -->

    <div class="navbar navbar-app navbar-absolute-top">
        <div class="navbar-brand navbar-brand-center" ui-yield-to="title">
            Mobile Angular UI
        </div>
        <div class="btn-group pull-left">
            <div ui-toggle="uiSidebarLeft" class="btn sidebar-toggle">
                <i class="fa fa-bars"></i> Menu
            </div>
        </div>
        <!--        <div class="btn-group pull-right" ui-yield-to="navbarAction">
                  <div ui-toggle="uiSidebarRight" class="btn">
                    <i class="fa fa-comment"></i> Chat
                  </div>
                </div>-->
    </div>

    <div class="navbar navbar-app navbar-absolute-bottom">
        <div class="btn-group justified">
            <a href="#" class="btn btn-navbar"><i class="fa fa-plus-square"></i> Добавить группу</a>
        </div>
    </div>

    <!-- App Body -->
    <div class="app-body" ng-class="{loading: loading}">
        <div ng-show="loading" class="app-content-loading">
            <i class="fa fa-spinner fa-spin loading-spinner"></i>
        </div>
        <div class="app-content">
            <ng-view></ng-view>
        </div>
    </div>

</div><!-- ~ .app -->

<div ui-yield-to="modals"></div>
</body>
</html>--%>












<%--
<!doctype html>
<html ng-app="Groups">
<head>
    <title>Группы</title>
    <script src="/CM/resources/bower_components/angular/angular.min.js"></script>
    <link href="/CM/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <script src="/CM/resources/workspace/group/script/app.js"></script>
    <script src="/CM/resources/workspace/group/script/controller.js"></script>
    <script src="/CM/resources/workspace/group/script/directive.js"></script>
</head>
<body ng-controller="groupsPage">

<div style="clear: both">

<div style="float: left; width: 100px">
    {{items}}
</div>


<div style="float: left; width: 300px">
    <form ng-submit="createGroup()">
    <table>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" ng-model="groupName" required/>
            </td>
        </tr>
        <tr>
            <td>ShortName</td>
            <td>
                <input type="text" ng-model="groupShortName" required/>
            </td>
        </tr>
        <tr>
            <td>Info</td>
            <td>
                <input type="text" ng-model="groupInfo" required/>
            </td>
        </tr>
        <tr>
            <td>Картинка</td>
            <td>будет</td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit"  value="Отправить"/>
            </td>
        </tr>
    </table>
    </form>
</div>

<div style="float: left; width: 300px">
    <table>
        <tr>
            <td>Найти группу по имени:</td>
        </tr>
        <tr >
            <td><input type="text" ng-model="groupNameSearch"/></td>
        </tr>
        <tr >
            <td><input type="submit" ng-click="searchGroup()" value="Найти"/></td>
        </tr>
    </table>
</div>


<div style="float: left">
    мои группы <br>
    <table>
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>ShortName</td>
            <td>Info</td>
            <td>Info</td>
        </tr>
        <tr ng-repeat="group in groups">
            <td>{{group.groupId}}</td>
            <td><a href="" ng-click="getPointsByGroupId (group.groupId)" > {{group.groupName}} </a></td>
            <td>{{group.groupShortName}}</td>
            <td>{{group.groupInfo}}</td>
            <td><input type="button" ng-click="deleteGroup (group.groupId)" value="Удалить"/></td>
        </tr>
    </table>
</div>
</div>

<div style="clear: both">
    <div style="float: left">
        точки в группе
        <table>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>GroupId</td>
                <td>Description</td>
                <td>delete</td>
            </tr>
            <tr ng-repeat="point in points">
                <td>{{point.id}}</td>
                <td>{{point.name}}</td>
                <td>{{point.groupId}}</td>
                <td>{{point.description}}</td>
                <td><input type="button" ng-click="deletePoint (point.id)" value="Удалить"/></td>
            </tr>
        </table>

    </div>

    <div style="float: left">
        Создать Точку <br>
        <form ng-submit="createPoint()">
        <table>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" ng-model="pointName" required/>
                </td>
            </tr>
            <tr>
                <td>Description</td>
                <td>
                    <input type="text" ng-model="pointDescription" required/>
                </td>
            </tr>
            <tr>
                <td>GroupId</td>
                <td>
                    <input type="number" ng-model="pointGroupId" required/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit"  value="Создать точку"/>
                </td>
            </tr>
        </table>
        </form>
    </div>




</div>



</body>
</html>--%>
