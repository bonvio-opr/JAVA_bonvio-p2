/**
 * Created by mil on 20.11.2014.
 */
define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name draggable
     * @description
     * # draggable
     * Controller of the generatorAngularRequireApp
     */

    angular.module('myCurrentTime', [])
        .directive('myCurrentTime', ['$interval', 'dateFilter', function($interval, dateFilter) {

            function link(scope, element, attrs) {
                var format,
                    timeoutId;

                function updateTime() {
                    element.text(dateFilter(new Date(), format));
                }

                scope.$watch(attrs.myCurrentTime, function(value) {
                    format = value;
                    updateTime();
                });

                element.on('$destroy', function() {
                    $interval.cancel(timeoutId);
                });

                // start the UI update process; save the timeoutId for canceling
                timeoutId = $interval(function() {
                    updateTime(); // update DOM
                }, 1000);
            }

            return {
                link: link
            };
        }]);

});