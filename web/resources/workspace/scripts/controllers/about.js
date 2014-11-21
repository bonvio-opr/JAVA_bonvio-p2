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
        .controller('AboutCtrl', ['$scope', '$location', function ($scope, $location) {

            console.log('AboutCtrl it work');
            localStorage.setItem("selectedURL", "about");

            //localStorage.setItem('p2DashboardAppUrl', '/about');
            //$scope.phoneId = $routeParams.phoneId;
        }]);
});
