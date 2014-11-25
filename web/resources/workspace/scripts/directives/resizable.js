/**
 * Created by mil on 21.11.2014.
 */
define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name
     * @description
     * #
     * Controller of the generatorAngularRequireApp
     */

    angular.module('resizable',[])

    .directive('resizable', function () {
        return {
            restrict: 'A',
            scope: {
                callback: '&onResize'
            },
            link: function postLink(scope, elem, attrs) {
                elem.resizable();
                console.log(123);
                elem.on('resizestop', function (evt, ui) {
                    if (scope.callback) { scope.callback(); }
                });
            }
        };
    });

});