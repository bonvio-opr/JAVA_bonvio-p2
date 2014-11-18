define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name DesktopCtrl
     * @description
     * # DesktopCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular.module('DesktopCtrl', [])
        .controller('DesktopCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {
            console.log('DesktopCtrl it work');

            console.log("selected selectedDesktopId: "+$routeParams.desktopId);

            localStorage.setItem("selectedDesktopId", $routeParams.desktopId);

            $scope.desktopId = $routeParams.desktopId;

            $http.get('getApplicationsById/'+$routeParams.desktopId).success(function(data) {
                localStorage.setItem('applicationUnits', JSON.stringify(data));
                $scope.applicationUnits = data;
            });

        }]);
});