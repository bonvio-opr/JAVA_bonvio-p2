<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 20.11.2014
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="ProfileApp">
<head>
    <title>Profile</title>
    <script src="/CM/resources/bower_components/angular/angular.min.js"></script>
    <script>

        'use strict';

        var app = angular.module('ProfileApp', []);

        app.directive('myUpload', [function () {
            return {
                restrict: 'A',
                link: function (scope, elem, attrs) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        scope.image = e.target.result;
                        scope.$apply();
                    }

                    elem.on('change', function() {
                        reader.readAsDataURL(elem[0].files[0]);
                    });
                }
            };
        }]);

        app.controller('ProfileCTRL', ['$scope', '$http', function($scope, $http) {

            $http.post('/CM/settings/profile/getProfile', null).success(function(data) {
                //alert(data);
                $scope.profileName = data.profileName;
                $scope.profileSurname = data.profileSurname;
                $scope.profilePatronymic = data.profilePatronymic;
                $scope.profileCity = data.profileCity;
                $scope.profileCountry = data.profileCountry;
                $scope.profileEmail = data.profileEmail;
                $scope.profilePhoneNumber = data.profilePhoneNumber;
            });

            $scope.updateProfile = function(){
                var data = new Object ();
                data.profileName = $scope.profileName;
                data.profileSurname = $scope.profileSurname;
                data.profilePatronymic = $scope.profilePatronymic;
                data.profileCity =  $scope.profileCity;
                data.profileCountry = $scope.profileCountry;
                data.profileEmail =  $scope.profileEmail;
                data.profilePhoneNumber = $scope.profilePhoneNumber;

                $http.post('/CM/settings/profile/refreshProfile', data).success(function(data) {
                    // for refresh
                    $http.post('/CM/settings/profile/getProfile', null).success(function(data) {
                        $scope.profileName = data.profileName;
                        $scope.profileSurname = data.profileSurname;
                        $scope.profilePatronymic = data.profilePatronymic;
                        $scope.profileCity = data.profileCity;
                        $scope.profileCountry = data.profileCountry;
                        $scope.profileEmail = data.profileEmail;
                        $scope.profilePhoneNumber = data.profilePhoneNumber;
                    });
                });
            }

            $scope.refreshUserPassAndPhone = function(){
                var data = new Object ();
                data.profilePhoneNumber = $scope.profilePhoneNumber;
                data.profilePassword = $scope.profilePassword;

                $http.post('/CM/settings/profile/refreshUserPassAndPhone', data).success(function(data) {
                    $scope.profilePassword = null;
                });
            }


            $scope.refreshUserImage = function(){
                var data = $scope.imagetosave;

                $http({method: 'POST', url: '/CM/settings/profile/refreshUserImage', headers: { 'Content-Type': 'multipart/form-data' },data: data}).success(function(){

                }).error(function(){

                });

            }

        }]);


    </script>
</head>
<body>

<div ng-controller="ProfileCTRL">
{{ddd}}
    <table>
        <tr>
            <td>Имя
            </td>
            <td><input type="text" ng-model="profileName" value="{{profileName}}"/>
            </td>
        </tr>
        <tr>
            <td>Фамилия
            </td>
            <td><input type="text" ng-model="profileSurname" value="{{profileSurname}}"/>
            </td>
        </tr>
        <tr>
            <td>Отчество
            </td>
            <td><input type="text" ng-model="profilePatronymic" value="{{profilePatronymic}}"/>
            </td>
        </tr>
        <tr>
            <td>Город
            </td>
            <td><input type="text" ng-model="profileCity" value="{{profileCity}}"/>
            </td>
        </tr>
        <tr>
            <td>Страна
            </td>
            <td><input type="text" ng-model="profileCountry" value="{{profileCountry}}"/>
            </td>
        </tr>
        <tr>
            <td>Емейл
            </td>
            <td><input type="text" ng-model="profileEmail" value="{{profileEmail}}"/>
            </td>
        </tr>
        <tr>
            <td>Телефон
            </td>
            <td><input type="text" ng-model="profilePhoneNumber" value="+7{{profilePhoneNumber}}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input style="float: right" type="button" value="Сохранить" ng-click="updateProfile ()"/>
            </td>
        </tr>
    </table>

    <br>
    <br>
    <br>

    <table>
        <tr>
            <td>Пароль
            </td>
            <td><input type="password" ng-model="profilePassword" value="{{profilePassword}}"/>
            </td>
        </tr>
        <tr>
            <td>Телефон
            </td>
            <td><input type="text" ng-model="profilePhoneNumber" value="{{profilePhoneNumber}}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input style="float: right" type="button" value="Сохранить" ng-click="refreshUserPassAndPhone ()"/>
            </td>
        </tr>
    </table>
    <br>


Тут будет аватар:
    <input type="button" value="Сохранить картинку!" ng-click="refreshUserImage ()"/>

<br>
    <input my-upload type="file" name="upload" ng-model="imagetosave">
    <br>
    <img style="width: 300px; height: 200px;"   ng-if="image" src="{{image}}" alt="">




</div>
</body>
</html>
