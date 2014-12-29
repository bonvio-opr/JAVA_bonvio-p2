<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 24.12.2014
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html ng-app="Members">
<head>
    <title>Группы</title>
    <script src="/CM/resources/bower_components/angular/angular.min.js"></script>
    <link href="/CM/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <script src="/CM/resources/workspace/member/script/app.js"></script>
    <script src="/CM/resources/workspace/member/script/controller.js"></script>
    <script src="/CM/resources/workspace/member/script/directive.js"></script>

    <style>
        div {
            //outline: 2px solid #000; /* Чёрная рамка */
            border: 1px solid #ff0900; /* Желтая рамка */
            border-radius: 10px; /* Радиус скругления */
        }
    </style>

</head>
<body ng-controller="memberPage">


<div>Приглашения в группу:
    <table>
        <tr >
            <td>
                ИД
            </td>
            <td>
                Группа
            </td>
            <td>
                Пользователь
            </td>
            <td>
                Группа
            </td>
            <td>
                Группа ID
            </td>
        </tr>


        <tr ng-repeat="invatation in invatations">
            <td>
                {{invatation.id}}
            </td>
            <td>
                {{invatation.groupName}}
            </td>
            <td>
                {{invatation.userFirstName}} {{invatation.userSurname}} {{invatation.userPatronymic}}
            </td>
            <td>
                {{invatation.accepted}}
            </td>
            <td>
                {{invatation.groupId}}
            </td>
        </tr>
    </table>
</div>

<div> Участники в группе:
    <input type="text" ng-model="groupIdForMembers" placeholder="Ид группы"/><br>
    <input type="button" ng-click="getMembers()" value="Найти"/> <br>
    <table>
        <tr >
            <td>
                ИД
            </td>
            <td>
                Группа
            </td>
            <td>
                Пользователь
            </td>
            <td>
                Группа
            </td>
            <td>
                Группа ID
            </td>
        </tr>


        <tr ng-repeat="invatation in members">
            <td>
                {{invatation.id}}
            </td>
            <td>
                {{invatation.groupName}}
            </td>
            <td>
                {{invatation.userFirstName}} {{invatation.userSurname}} {{invatation.userPatronymic}}
            </td>
            <td>
                {{invatation.accepted}}
            </td>
            <td>
                {{invatation.groupId}}
            </td>
        </tr>
    </table>
</div>



<div>
    отправленные заявки из этой группы: <br>

        <input type="text" ng-model="groupId" placeholder="Ид группы"/><br>
        <input type="button" ng-click="loadGroupInvitentions()" value="Найти"/>




    <table>
        <tr>
            <td>
                ИД
            </td>
            <td>
                Юзер
            </td>
            <td>
                Группа
            </td>
            <td>
                Группа
            </td>
        </tr>
        <tr ng-repeat="invatation in invatationsGroup">
            <td>
                {{invatation.id}}
            </td>
            <td>
                {{invatation.groupName}}
            </td>
            <td>
                {{invatation.userFirstName}} {{invatation.userSurname}} {{invatation.userPatronymic}}
            </td>
            <td>
                {{invatation.accepted}}
            </td>
            <td>
                {{invatation.groupId}}
            </td>
        </tr>
    </table>


</div>
<div></div>
<div></div>


</body>
</html>
