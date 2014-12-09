/**
 * Created by Niko on 27.11.2014.
 */
define(["angular"], function (angular) {
	"use strict";

	angular.module("updateCoord", [])
		.directive("winCoord", [function () {
			return {
				restrict: "A",
				require: "ngModel",
				link: function (scope, element, attribute, ngModel) {
					element.on("mousedown", function () {
					// изменяем Z-INDEX
					element.css("z-index", scope.maxZIndex);
					ngModel.$viewValue.zIndex = element.css("z-index");
					});
					element.on("mousemove", function () {
						scope.$apply(function () {
							if (ngModel.$viewValue.isMax == 0) {
								// получаем стили
								var elementStyle = window.getComputedStyle(element[0]);
								// задаем отступы
								ngModel.$viewValue.windowPositionX = parseInt(elementStyle["left"]);
								ngModel.$viewValue.windowPositionY = parseInt(elementStyle["top"]);
								// задаем размеры
								ngModel.$viewValue.windowWidth = parseInt(elementStyle["width"]);
								ngModel.$viewValue.windowHeight = parseInt(elementStyle["height"]);
							}
						});
					});
				}
			};
		}])
		.directive("iconCoord", [function () {
			return {
				restrict: "A",
				require: "ngModel",
				link: function (scope, element, attribute, ngModel) {
					element.on("mousemove", function () {
						scope.$apply(function () {
							// получаем стили
							var elementStyle = window.getComputedStyle(element[0]);
							// задаем отступы
							ngModel.$viewValue.unitPositionX = parseInt(elementStyle["left"]);
							ngModel.$viewValue.unitPositionY = parseInt(elementStyle["top"]);
						});
					});
				}
			};
		}]);
});