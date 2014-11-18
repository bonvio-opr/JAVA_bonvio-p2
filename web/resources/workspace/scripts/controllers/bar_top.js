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
        .controller('Bar_topCtrl', ['$scope', '$location', function ($scope, $location) {

            console.log('Bar_topCtrl it work');

            //CurrentUserCredentials
            $scope.CurrentUserCredentials = JSON.parse(localStorage.getItem('CurrentUserCredentials'));

            //CurrentUserWorkspaces
            var CurrentUserWorkspaces = JSON.parse(localStorage.getItem('CurrentUserWorkspaces'));

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


        }]);
});