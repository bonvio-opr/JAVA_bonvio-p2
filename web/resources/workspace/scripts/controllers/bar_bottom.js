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
        .controller('Bar_bottomCtrl', ['$scope', '$http', '$sce', '$rootScope', function ($scope, $http, $sce, $rootScope) {

//            $scope.applicationUnits

            console.log('Bar_bottomCtrl it work');
            $scope.update  = function() {
                console.log($rootScope.applicationUnits);
            };
//            console.log($scope.applicationUnits);


            /**
             * tabsUI
             */



            /**
             * rightPanel
             * @type {string}
             */
            //$scope.format = 'M/d/yy h:mm:ss a';
            $scope.format = 'H:mm:ss';




        }]);
});