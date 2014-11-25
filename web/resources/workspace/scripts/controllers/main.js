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

        .controller('MainCtrl', ['$scope', '$location', '$http', '$sce', '$routeParams', function ($scope, $location, $http, $sce, $routeParams) {

            console.log('MainCtrl it work');

            /**
             * selectedURL
             */
            /*if (localStorage.getItem("selectedURL") != undefined){
             $location.path(localStorage.getItem("selectedURL"));
             } else {
             localStorage.setItem("selectedURL", "/");
             }*/
            // end selectedURL

            /**
             * Menu
             */
            $scope.toggleHideMenuDesktops = function () {
                $scope.viewMenu = false;
            };

            $scope.viewMenu = false;

            $scope.toggleViewMenu = function (ggg) {
                $scope.viewMenu = $scope.viewMenu === true ? false : true;
            };
            // end Menu

        }]);// endMainCtrl

});
