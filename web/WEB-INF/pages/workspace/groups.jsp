<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 18.12.2014
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div>
    {{items}}
</div>
<br>

<div>
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
<br>
<div>
    <table>
        <tr>
            <td>Найти группу по имени:</td>
        </tr>
        <tr >
            <td><input type="text" ng-model="groupNameSearch"/></td>
        </tr>
        <tr >
            <td><input type="submit" ng-click="searchGroup()" value="Отправить"/></td>
        </tr>
    </table>
</div>

<br>
<div>
    <table>
        <tr>
            <td>Name</td>
            <td>ShortName</td>
            <td>Info</td>
            <td>Info</td>
        </tr>
        <tr ng-repeat="group in groups">
            <td>{{group.groupName}}</td>
            <td>{{group.groupShortName}}</td>
            <td>{{group.groupInfo}}</td>
            <td><input type="button" ng-click="deleteGroup (group.groupId)" value="Удалить"/></td>
        </tr>
    </table>
</div>


</body>
</html>
