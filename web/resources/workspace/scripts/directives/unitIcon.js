define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name
     * @description
     * #
     * Controller of the generatorAngularRequireApp
     */
    angular.module('unitIcon',[]).directive("unitIcon", [function() {
        return {
            restrict : 'A',
            require: "ngModel",
            link: function ($scope, $element, $attribute, ngModel) {
                $element.on("mouseup", function () {
                    $scope.$apply(function () {
                        // получаем стили
                        var elementStyle = window.getComputedStyle($element[0]);
                        // задаем отступы
                        ngModel.$viewValue.unitPositionX = parseInt(elementStyle["left"]);
                        ngModel.$viewValue.unitPositionY = parseInt(elementStyle["top"]);
                    });
                });
            }
        };
    }]);



});