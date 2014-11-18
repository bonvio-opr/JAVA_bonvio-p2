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

            console.log('MainCtrl it work');

            $http.get('getCurrentUserCredentials').success(function(data) {
                localStorage.setItem('CurrentUserCredentials', JSON.stringify(data));
            });
            $http.get('getWorkspaces').success(function(data) {
                localStorage.setItem('CurrentUserWorkspaces', JSON.stringify(data));
            });


            $scope.toggleHideMenuDesktops = function() {
                $scope.viewMenu = false;
                $scope.animatedMenu = 'fadeOut';
            };

            $scope.viewMenu = false;
            $scope.animatedMenu = 'fadeOut';
            $scope.toggleViewMenu = function() {
                $scope.viewMenu = $scope.viewMenu === true ? false: true;
                $scope.animatedMenu = $scope.animatedMenu === 'fadeOut' ? 'fadeIn': 'fadeOut';
            };


        }]);// endMainCtrl

});
