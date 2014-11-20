/**
 * Created by mil on 18.11.2014.
 */
define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name DashboardCtrl
     * @description
     * # DashboardCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular.module('Bar_bottomCtrl', [])
        .controller('Bar_bottomCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {

            console.log('Bar_bottomCtrl it work');

            //$scope.format = 'M/d/yy h:mm:ss a';
            $scope.format = 'H:mm:ss';

        }]);
});