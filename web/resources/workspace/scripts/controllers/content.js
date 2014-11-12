define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name ContentCtrl
     * @description
     * # NavCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular.module('ContentCtrl', [])
        .controller('ContentCtrl', ['$scope', '$routeParams', function ($scope, $routeParams) {

            console.log('contentCtrl it work');

        }]);
});
