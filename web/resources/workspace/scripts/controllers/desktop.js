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
        .controller('DesktopCtrl', ['$scope', '$http', '$sce', '$routeParams', function ($scope, $http, $sce, $routeParams) {
            console.log('DesktopCtrl it work');

            localStorage.setItem("selectedURL", $routeParams.desktopId);

            console.log("selected selectedDesktopId: "+$routeParams.desktopId);

            localStorage.setItem("selectedDesktopId", $routeParams.desktopId);


/*            $http.get('getApplicationsById/'+$routeParams.desktopId).success(function(data) {
                localStorage.setItem('getApplicationsById', JSON.stringify(data));
                $scope.applicationUnits = data;
            });*/

            $http.get('resources/workspace/JSON/p1.json').success(function(data) {
                localStorage.setItem('getApplicationsById', JSON.stringify(data));
                $scope.applicationUnits = data;
            });


//            $scope.iconUpdate = function(unit) {
//                delete unit.unitActive;
//                $http.post('#', unit).success(function (data) {
//                    localStorage.setItem('getApplicationsById', JSON.stringify(data));
//                    //$scope.applicationUnits = data;
//                    console.log("good - " + data);
//                });
//            };
//            $scope.windowUpdate = function(activeWindow) {
//                $http.post('#', activeWindow).success(function (data) {
//                    localStorage.setItem('getApplicationsById', JSON.stringify(data));
//                    //$scope.applicationUnits = data;
//                    console.log("good - " + data);
//                });
//            };



        }]);

});