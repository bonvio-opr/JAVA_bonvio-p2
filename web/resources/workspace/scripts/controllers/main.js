define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name MainCtrl
     * @description
     * # MainCtrl
     * Controller of the p2DashboardApp
     */
    angular.module('MainCtrl', [])

        .controller('MainCtrl', ['$scope', '$http', function ($scope, $http) {

            console.log('mainCtrl it work');

            $http.get('getCurrentUserCredentials').success(function(data) {
                localStorage.setItem('CurrentUserCredentials', JSON.stringify(data));
            });
            $http.get('getWorkspaces').success(function(data) {
                localStorage.setItem('CurrentUserWorkspaces', JSON.stringify(data));
            });

            $scope.custom = false;
            $scope.toggleCustom = function() {
                $scope.custom = $scope.custom === true ? false: true;
            };


        }]);// endMainCtrl

});
