define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name generatorAngularRequireApp.controller:ApplicationCtrl
     * @description
     * # ApplicationCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular.module('ApplicationCtrl', ['ngSanitize'])
        .controller('ApplicationCtrl', ['$scope', '$sce', '$routeParams', function ($scope, $sce, $routeParams) {

            console.log('ApplicationCtrl it work');

           // console.log("selected selectedUnitId: "+$routeParams.unitId);

            //localStorage.setItem("selectedUnitId", $routeParams.unitId);

            var selectedWsUnits = JSON.parse(localStorage.getItem("selectedWsUnits"));

            $scope.applicationUrl = $sce.trustAsResourceUrl(selectedWsUnits[$routeParams.unitIndex].unitCode);

        }]);
});
