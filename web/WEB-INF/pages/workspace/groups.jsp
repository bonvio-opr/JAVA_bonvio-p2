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
</html>
