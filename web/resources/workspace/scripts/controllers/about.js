define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name generatorAngularRequireApp.controller:AboutCtrl
     * @description
     * # AboutCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular.module('AboutCtrl', [])
        .controller('AboutCtrl', ['$scope', function ($scope) {

            console.log('aboutCtrl it work');

            //localStorage.setItem('p2DashboardAppUrl', '/about');
            //$scope.phoneId = $routeParams.phoneId;
        }]);
});
