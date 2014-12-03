/**
 * Created by mil on 18.11.2014.
 */
define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name DashboardCtrl
     * @description
     * # DashboardCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular.module('Bar_topCtrl', [])
        .controller('Bar_topCtrl', ['$scope', '$http', function ($scope, $http) {

            console.log('Bar_topCtrl it work');

            //CurrentUserCredentials
            if (localStorage.getItem('CurrentUserCredentials') != undefined) {
                $scope.CurrentUserCredentials = JSON.parse(localStorage.getItem('CurrentUserCredentials'));
            } else {
                $http.get('getCurrentUserCredentials').success(function(data) {
                    localStorage.setItem('CurrentUserCredentials', JSON.stringify(data));
                    $scope.CurrentUserCredentials = data;
                });
            }

            //CurrentUserWorkspaces
            function currentUserWorkspaces(data) {
                var CurrentUserWorkspaces = data;
                var CurrentUserPrivateWorkspaces = [],
                    CurrentUserAdditionWorkspaces = [];
                for (var i=0; i<CurrentUserWorkspaces.length; i++){
                    if (CurrentUserWorkspaces[i].wsType == "p"){
                        CurrentUserPrivateWorkspaces.push(CurrentUserWorkspaces[i]);
                    } else {
                        CurrentUserAdditionWorkspaces.push(CurrentUserWorkspaces[i]);
                    }
                }
                $scope.CurrentUserPrivateWorkspaces = CurrentUserPrivateWorkspaces;
                $scope.CurrentUserAdditionWorkspaces = CurrentUserAdditionWorkspaces;
            }
            if (localStorage.getItem('CurrentUserWorkspaces') != undefined) {
                var data = JSON.parse(localStorage.getItem('CurrentUserWorkspaces'));
                currentUserWorkspaces(data);
            } else {
                $http.get('getWorkspaces').success(function(data) {
                    localStorage.setItem('CurrentUserWorkspaces', JSON.stringify(data));
                    currentUserWorkspaces(data);
                });
            }


        }]);
});