define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name DashboardCtrl
     * @description
     * # DashboardCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular.module('DashboardCtrl', [])
        .controller('DashboardCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {

            console.log('dashboardCtrl it work');

            console.log("selected selectedWsId: "+$routeParams.wsId);

            localStorage.setItem("selectedWsId", $routeParams.wsId);

            $scope.selectedWsId = $routeParams.wsId;

            $http.get('getApplicationsById/'+$routeParams.wsId).success(function(data) {
                localStorage.setItem('selectedWsUnits', JSON.stringify(data));
                $scope.wsUnits = data;
            });

        }]);
});