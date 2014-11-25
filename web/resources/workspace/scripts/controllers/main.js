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

            $scope.toggleHideMenuDesktops = function () {
                $scope.viewMenu = false;
            };

            $scope.viewMenu = false;

            $scope.toggleViewMenu = function (ggg) {
                $scope.viewMenu = $scope.viewMenu === true ? false : true;
                //$scope.viewMenu = false;
                //alert(ggg);
            };

            /**
             * unit
             */

            $http.get('getApplicationsById/'+$routeParams.desktopId).success(function(data) {
                localStorage.setItem('getApplicationsById', JSON.stringify(data));
                $scope.applicationUnits = data;
            });

            /*            $http.get('resources/workspace/JSON/p1.json').success(function (data) {
             localStorage.setItem('getApplicationsById', JSON.stringify(data));
             $scope.applicationUnits = data;
             });*/


            // icon
            $scope.iconUpdate = function (unit) {
                delete unit.unitActive;
                $http.post('updateApplicationPosition', unit).success(function (data) {
                    localStorage.setItem('getApplicationsById', JSON.stringify(data));
                    //$scope.applicationUnits = data;
                    console.log("good - " + data);
                });
            };

            $scope.windowUpdate = function (activeWindow) {
                $http.post('createWindow', activeWindow).success(function (data) {
//                    localStorage.setItem('getApplicationsById', JSON.stringify(data));
                    console.log("good - " + data);
                });
            };


        }]);// endMainCtrl

});