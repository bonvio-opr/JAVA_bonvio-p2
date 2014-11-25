define([
        'angular',
        //'directives/windows'
        'directives/itsADrag',
        'directives/drag',
        //'directives/resizeIt'
        'directives/resizable'
],
    function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name DesktopCtrl
     * @description
     * # DesktopCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular
        .module('DesktopCtrl', [
            //'windows'
            //'drag',
            //'resizeIt',
            'itsADrag',
            'resizable'

        ])
        .controller('DesktopCtrl', ['$scope', '$http', '$sce', '$routeParams', '$rootScope', function ($scope, $http, $sce, $routeParams, $rootScope) {
            console.log('DesktopCtrl it work');

            localStorage.setItem("selectedURL", $routeParams.desktopId);

            console.log("selected selectedDesktopId: "+$routeParams.desktopId);

            localStorage.setItem("selectedDesktopId", $routeParams.desktopId);


            /**
             * unit
             */

            $http.get('getApplicationsById/'+$routeParams.desktopId).success(function(data) {
                localStorage.setItem('getApplicationsById', JSON.stringify(data));
                $scope.applicationUnits = data;
                console.log(data);

                $rootScope.applicationUnits = data;
            });

            // icon
            $scope.iconUpdate = function (unit) {
                delete unit.unitActive;
                $http.post('updateApplicationPosition/', unit).success(function (data) {
                    localStorage.setItem('getApplicationsById', JSON.stringify(data));
                });
            };

//            $scope.windowUpdate = function (activeWindow) {
//                $http.post('getwindow/', activeWindow).success(function (data) {
////                    localStorage.setItem('getApplicationsById', JSON.stringify(data));
//                    console.log("good - " + data);
//                });
//            };

            $scope.getWindow = function (unitId) {
                $http.post('getwindow/' + unitId, null).success(function (data) {
                    $scope.applicationUnits[unitId].windows.push(data);
                });
            };
            $scope.updateWindow = function (window) {
                $http.post('updatewindow/', window).success(function (data) {
                    console.log("good - " + data);
                });
            };
            $scope.deleteWindow = function (window) {
                $http.post('deletewindow/', window.windowId).success(function (data) {
                    console.log("good - " + data);
                });
                $scope.applicationUnits[window.ownerUnitId].windows.splice(window.windowId, 1);
            };






        }]);

});