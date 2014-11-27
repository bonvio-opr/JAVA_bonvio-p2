define([
        'angular',
        "directives/winDirective"
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
            'winDirective'

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

            $scope.getWindow = function (unit) {
              $scope.applicationUrl = $sce.trustAsResourceUrl(unit.unitCode);

                $http.post('getwindow/' + unit.uniteID, null).success(function (data) {
                  console.log(data);
                    $rootScope.applicationUnits[unit.uniteID].windows.push(data);
                });
            };
            $scope.updateWindow = function (window) {


                $http.post('updatewindow/', window).success(function (data) {
                    console.log("good - " + data);
                });
            };
            $scope.deleteWindow = function ($index) {
              console.log("del = " + $index);


              //
              //
              //  var data = {};
              //  data.windowId = window.windowId;
              //  console.log();
              //  $http.post('deletewindow/', data).success(function (data) {
              //      console.log("good - " + data);
              //  });
              //
              //console.log(window.ownerUnitId);
              //console.log($rootScope.applicationUnits);
            };






        }]);

});