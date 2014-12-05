<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 01.12.2014
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html ng-app="FileManager">
<head>
    <meta charset="utf-8">
    <script src="/CM/resources/bower_components/angular/angular.min.js"></script>
    <link href="/CM/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <script src="/CM/resources/workspace/filemanager/script/app.js"></script>
    <script src="/CM/resources/workspace/filemanager/script/controller.js"></script>
    <script src="/CM/resources/workspace/filemanager/script/directive.js"></script>
    <link href="/CM/resources/workspace/filemanager/style/default.css" rel="stylesheet">
    <script src="/CM/resources/bower_components/angular-file-upload/angular-file-upload.min.js"></script>
</head>
<body>
<section id="screen" ng-controller="screen" ng-init="full = 0">
    <nav>
        <a ng-show="full == 0" href="#" class="fa fa-arrow-right" ng-click="full = 1">&nbsp;Только левая</a>
        <a ng-show="full != 0" href="#" class="fa fa-columns" ng-click="full = 0">&nbsp;Показать обе панели</a>
        <a ng-show="full == 0" href="#" class="fa fa-arrow-right" ng-click="full = 2">&nbsp;Только правая</a>
    </nav>
    <div ng-hide="full == 2"
         ng-include="'/CM/resources/workspace/filemanager/view/screen.html'" ng-controller="left"
         ng-class="full == 1 ? 'fullLeft' : ''"
         class="left"></div>
    <div ng-hide="full == 1"
         ng-include="'/CM/resources/workspace/filemanager/view/screen.html'" ng-controller="right"
         ng-class="full == 2 ? 'fullRight' : ''"
         class="right"></div>
</section>
</body>
</html>